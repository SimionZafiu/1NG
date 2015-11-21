package com.ing.ing1.engine;

import com.ing.ing1.dto.*;
import com.ing.ing1.http.AuthRestTemplate;
import com.ing.ing1.http.INGApiClient;
import com.ing.ing1.test.Quote;
import com.ing.ing1.util.Helper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Main engine loop for the single account
 *
 * Created by ggkekas on 17/11/15.
 */
@Service
public class SingleAccountEngine {

    private static final Logger LOGGER = LogManager.getLogger(SingleAccountEngine.class);
    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(10);
    private static final Random RANDOM = new Random();

//    private INGApiClient apiClient = new INGApiClient();

    @Autowired
    private INGApiClient apiClient;

    public void setApiClient(INGApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Autowired
    private Configuration configuration;

    @Autowired
    private InvestmentService investmentService;

    public void setInvestmentService(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    public void start() {
        EXECUTOR.scheduleAtFixedRate(() -> engineLoop(), 0, 10, TimeUnit.SECONDS);
        LOGGER.info("Started single account engine");
    }

    private void engineLoop() {
//        try {
//            List<Transaction> transactions = apiClient.getTransactions(2, Helper.getCalendarFromStringDate("2015-11-20"), Helper.getCalendarFromStringDate("2015-11-21"));
//            transactions.stream().forEach(System.out::println);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        List<Customer> customers = apiClient.getCustomers();
        if(!CollectionUtils.isEmpty(customers)) {
            Calendar start = Helper.getEpochStart();
            Calendar end = Helper.getEpochStart();
            end.add(Calendar.MONTH, 1);
            for (Customer customer : customers) {
                // Pay interest rates
                payInterestRatesAndEvaluateGoals(customer, start, end);

                // Investments
                investAvailableAmount(customer, start, end);

                start.add(Calendar.MONTH, 1);
                end.add(Calendar.MONTH, 1);
            }
        }
    }

    private void payInterestRatesAndEvaluateGoals(Customer customer, Calendar start, Calendar end) {
        for(Goal goal : customer.getGoals()) {
            if(goal.getContractedProductList() != null) {
                goal.getContractedProductList().stream().filter(
                        p -> p.getProduct().getType() == ProductType.SAVINGS || p.getProduct().getType() == ProductType.INVESTMENT)
                        .forEach((contractedProduct) -> {
                            apiClient.rebalance(contractedProduct, contractedProduct.getYield());
                        });

                goal.getContractedProductList().stream().filter(
                        p -> p.getProduct().getType() == ProductType.FIXED_INCOME && p.getCreationDate().after(Helper.getCurrentDate()))
                        .forEach((contractedProduct) -> {
                            apiClient.rebalance(contractedProduct, contractedProduct.getYield());
                        });

                if(goal.getEndDate() != null && goal.getEndDate().equals(end)) {
                    double totalYield = goal.getContractedProductList().stream().mapToDouble(ContractedProduct::getYield).sum();
                    apiClient.deposit(customer, totalYield);
                    apiClient.closeGoal(goal);
                }
            }
        }
    }

    private void investAvailableAmount(Customer customer, Calendar start, Calendar end) {
        List<Transaction> transactions = apiClient.getTransactions(customer.getId(), start, end);
        if(transactions != null) {
            double sumExpenses = transactions.stream().filter(t -> t.getType() == TransactionType.EXPENSE).mapToDouble(Transaction::getAmount).sum();
            double sumIncome = transactions.stream().filter(t -> t.getType() == TransactionType.INCOME).mapToDouble(Transaction::getAmount).sum();
            double availableAmount = sumIncome - sumExpenses;

            // 1. Step of product allocation - savings
            SavingsAccountAllocation savingsAllocation = investmentService.allocateToSavings(customer, sumIncome, sumExpenses);
            double possibleSavingsAccountSurplus = savingsAllocation.getCurrentBalance() - savingsAllocation.getSecurityBuffer();
            double savingsAccountSurplus = possibleSavingsAccountSurplus < 10 ? 0 : possibleSavingsAccountSurplus;
            // 2. Step of product allocation - fixed income
            availableAmount -= savingsAllocation.getInvestedAmount();
            for (Goal goal : customer.getGoals()) {
                if (goal.getGoalType() != GoalType.SAVINGS && goal.getDuration() <= 3 * 12) {
                    if (availableAmount > 0) {
                        GoalInvestmentAllocation goalInvestmentAllocation = investmentService
                                .allocateToFixedIncomeProducts(customer, goal, availableAmount, savingsAccountSurplus, end);
                        availableAmount -= goalInvestmentAllocation.getInvestedAmount();
                    } else {
                        apiClient.updateGoalStatus(goal, GoalProgressStatus.RED);
                    }
                }
            }

            // 3. Step of product allocation - investment products
            for (Goal goal : customer.getGoals()) {
                if (goal.getGoalType() != GoalType.SAVINGS && goal.getDuration() > 3 * 12) {
                    GoalInvestmentAllocation goalInvestmentAllocation = investmentService
                            .allocateToInvestmentProducts(goal, availableAmount, end);
                    availableAmount -= goalInvestmentAllocation.getInvestedAmount();
                }
            }

            // 4. Nice to have - allocate any remaining to savings account
        }
    }

    private void makeRESTRequest() {
        try {
            //   GET example
            RestTemplate restTemplate = new RestTemplate();
            testGetRequest(restTemplate);
        } catch(Throwable e) {
            LOGGER.error("Error", e);
        }
    }


    private void testGetRequest(RestTemplate restTemplate) {
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        LOGGER.info(quote.toString());
        ServerStatus serverStatus = apiClient.getServerStatus();
        LOGGER.info("Server Status: " + (serverStatus != null ? serverStatus.toString() : "Server not working"));
        Account account = apiClient.getAccount("IAUSDUIOA23874893");
        LOGGER.info("Account: " + (account != null ? account.toString() : "Not found"));
        LOGGER.info("Debug: " + configuration.isDebug());
    }

    private void makePostRequest() {
        // POST upload with exchange
        String url = "http://127.0.0.1:8080/uploadFile";
        String filename = "/home/ggkekas/Downloads/ideal.tar.gz";
        String location = "/home/ggkekas/test/apache" + RANDOM.nextInt(1000) + ".tar.gz";
        AuthRestTemplate authRestTemplate = new AuthRestTemplate("user", "password");
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name", location);
        Resource resource = new FileSystemResource(filename);
        map.add("file", resource);
//            String result = authRestTemplate.execute(url, HttpMethod.POST,
//                    (ClientHttpRequest clientHttpRequest) -> {
//                        clientHttpRequest.getHeaders().setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                        IOUtils.copy(resource.getInputStream(), clientHttpRequest.getBody());
//                    },
//                    new HttpMessageConverterExtractor<>(String.class, authRestTemplate.getMessageConverters()), map);
        String result = authRestTemplate.postForObject(url, map, String.class);
        LOGGER.info(result);
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
