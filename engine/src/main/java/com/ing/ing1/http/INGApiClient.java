package com.ing.ing1.http;

import com.ing.ing1.dto.*;
import com.ing.ing1.util.Helper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ggkekas on 18/11/15.
 */
@EnableAspectJAutoProxy
@Component
public class INGApiClient {
//    private static final String URL = "http://213.157.170.77/NL/commonapi/";
    private static final Logger LOGGER = LogManager.getLogger(INGApiClient.class);
    private static final String URL = "http://172.16.0.89/1ng/api/";
    private static final String TRANSACTIONS = URL + "transactions";
    private static final String CUSTOMERS = URL + "customers";
    private static final String SERVER_STATUS = "server/status/";
    private static final String ACCOUNTS = "accounts/";
    private static final String PROD_FEATURES = "prod_features/";

    private final RestTemplate restTemplate = new RestTemplate();

    public ServerStatus getServerStatus() {
        return restTemplate.getForObject(URL + SERVER_STATUS, ServerStatus.class);
    }

//    public ProdFeatures getProducts(String prod) {
//        return restTemplate.getForObject(URL + PROD_FEATURES + (prod != null ? "?type=" + prod : ""), ProdFeatures.class);
//    }

    public Account getAccount(String id) {
        return restTemplate.getForObject(URL + ACCOUNTS + id, Account.class);
    }

    // TODO implement REST call for getting products
    public List<Product> getAllProducts() {
        return null;
    }

    // TODO implement REST call for getting products
    public List<Product> getInvestmentProducts() {
        return null;
    }

    // TODO implement REST call for getting savings account goal
    public Goal getSavingsAccountGoal(int customerId) {
        return null;
    }

    // TODO implement REST call for getting savings product
    public Product getSavingsAccountProduct() {
        return null;
    }

    // TODO implement REST call for getting customer goals
    public List<Goal> getCustomerGoals(int customerId) {
        return null;
    }

    // TODO implement investment
    public void investAmount(GoalInvestmentAllocation investment) {

    }

    public List<Transaction> getTransactions(int customerId, Calendar start, Calendar end) {
        String startString = Helper.getDateString(start);
        String endString = Helper.getDateString(end);
        String request = TRANSACTIONS + "?from=" + startString + "&to=" + endString
                + "&customerId=" + customerId;
        LOGGER.info("Request: " + request);
        Transaction[] transactions = restTemplate.getForObject(request, Transaction[].class);
        return Arrays.asList(transactions);
    }

    //TODO implement customer
    public List<Customer> getCustomers() {
        return Arrays.asList(restTemplate.getForObject(CUSTOMERS, Customer[].class));
    }

    // TODO implement withdraw
    public void withdraw(ContractedProduct contractedProduct, double amount) {
    }

    // TODO implement rebalance
    public void rebalance(ContractedProduct contractedProduct, double yield) {
    }

    // TODO implement deposit
    public void deposit(Customer customer, double amount) {

    }

    // TODO close goal
    public void closeGoal(Goal goal) {
    }

    // TODO update status
    public void updateGoalStatus(Goal goal, GoalProgressStatus red) {
    }
}
