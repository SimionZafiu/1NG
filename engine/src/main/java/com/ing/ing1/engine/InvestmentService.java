package com.ing.ing1.engine;

import com.ing.ing1.dto.*;
import com.ing.ing1.http.INGApiClient;
import com.ing.ing1.util.Helper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/**
 * Created by ggkekas on 20/11/15.
 */
@Service
public class InvestmentService {

    private static final Logger LOGGER = LogManager.getLogger(SingleAccountEngine.class);

    @Autowired
    private INGApiClient apiClient;

    public void setApiClient(INGApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public SavingsAccountAllocation allocateToSavings(Customer customer, double sumIncome, double availableAmount) {
        ContractedProduct savingsAccount = getCustomerSavingsAccount(customer);
        SavingsAccountAllocation savingsAllocation = new SavingsAccountAllocation();
        double securityBuffer = calculateSecurityBuffer(sumIncome);
        savingsAllocation.setSecurityBuffer(securityBuffer);
        savingsAllocation.setCurrentBalance(savingsAccount.getBalance());
        if(savingsAccount.getBalance() < securityBuffer) {
            double diff = availableAmount - securityBuffer;
            if(diff < 0) {
                savingsAllocation.setInvestedAmount(availableAmount);
                savingsAllocation.setOnTrack(GoalProgressStatus.AMBER.name());
            } else {
                savingsAllocation.setInvestedAmount(diff);
                savingsAllocation.setOnTrack(GoalProgressStatus.GREEN.name());
            }
        }
        apiClient.investAmount(savingsAllocation);
        return savingsAllocation;
    }

    private ContractedProduct getCustomerSavingsAccount(Customer customer) {
        Optional<Goal> savingsAccountGoal = customer.getGoals().stream().filter(g -> g.getType() == GoalType.SAVINGS).findFirst();
        if(!savingsAccountGoal.isPresent()) {
            throw new RuntimeException("No savings account goal found for customer " + customer.getId());
        }
        List<ContractedProduct> list = savingsAccountGoal.get().getContractedProductList();
        if(CollectionUtils.isEmpty(list)) {
            throw new RuntimeException("No savings account found in the savings account goal of customer " + customer.getId());
        }
        return list.get(0);
    }

    private double calculateSecurityBuffer(double income) {
        return 2 * 0.7 * income;
    }

    public GoalInvestmentAllocation allocateToFixedIncomeProducts(Customer customer, Goal goal,
                                                                  double currentMonthAvailableAmount, double savingsAccountSurplus, Calendar currentSimulatedTime) {
        try {
            Calendar goalStart = goal.getStartDate();
            int goalDurationInMonths= goal.getDuration();
            int goalActiveMonths = Helper.getMonthsDifference(goalStart, currentSimulatedTime);
            int goalRemainingMonths = goalDurationInMonths - goalActiveMonths;
            List<Product> products = apiClient.getAllProducts();
            Product bestProduct = findBestProduct(products, goalRemainingMonths);

            double monthlyYieldTarget = goal.getTargetAmount() / goalRemainingMonths;
            double optimalYield = monthlyYieldTarget * goalActiveMonths;
            double currentYield = goal.getCurrentTotalYield();

            // Calculate any possibly missed previous investments
            double missing = currentYield - optimalYield;
            // Current amount to be invested
            double amountToInvest = bestProduct.getAmountToInvest(monthlyYieldTarget);
            // Target = current + any possibly missed previous investments
            double currentInvestmentTarget = amountToInvest - missing;
            double totalAvailableAmount = currentMonthAvailableAmount + savingsAccountSurplus;

            GoalInvestmentAllocation goalInvestmentAllocation = new GoalInvestmentAllocation();
            goalInvestmentAllocation.setInvestedAmount(currentInvestmentTarget);
            goalInvestmentAllocation.setGoalId(goal.getId());
            goalInvestmentAllocation.setProductId(bestProduct.getId());
            goalInvestmentAllocation.setOnTrack(currentInvestmentTarget <= totalAvailableAmount
                    ? GoalProgressStatus.GREEN.name() :
                    (currentInvestmentTarget > totalAvailableAmount && currentInvestmentTarget <= 1.05 * totalAvailableAmount
                            ? GoalProgressStatus.AMBER.name() : GoalProgressStatus.RED.name()));
            // Withdraw money from savings account if you made use of the surplus
            if(currentInvestmentTarget > currentMonthAvailableAmount) {
                apiClient.withdraw(getCustomerSavingsAccount(customer),
                        currentInvestmentTarget - currentMonthAvailableAmount);
            }

            apiClient.investAmount(goalInvestmentAllocation);
            return goalInvestmentAllocation;

        } catch (Exception e) {
            LOGGER.error("Error while trying to allocate amount to fixed income products", e);
            throw new RuntimeException("Error while trying to allocate amount to products", e);
        }
    }

    public GoalInvestmentAllocation allocateToInvestmentProducts(Goal goal, double availableAmount, Calendar currentSimulatedTime) {
        GoalInvestmentAllocation goalInvestmentAllocation = new GoalInvestmentAllocation();
        Calendar goalStart = goal.getStartDate();
        int goalDurationInMonths= goal.getDuration();
        int goalActiveMonths = Helper.getMonthsDifference(goalStart, currentSimulatedTime);
        int goalRemainingMonths = goalDurationInMonths - goalActiveMonths;
        List<Product> products = apiClient.getInvestmentProducts();
        Optional<Product> product;
        boolean alreadyContractedProduct = goal.getContractedProductList() != null && goal.getContractedProductList().get(0) != null;
        if(goalActiveMonths < 0.35 * goalDurationInMonths) {
            product = products.stream().filter(p -> p.getSubType() == ProductType.ProductSubType.HIGH_RISK).findFirst();
        } else if(goalActiveMonths >= 0.35 * goalDurationInMonths && goalActiveMonths < 0.8 * goalDurationInMonths) {
            product = products.stream().filter(p -> p.getSubType() == ProductType.ProductSubType.MEDIUM_RISK).findFirst();
            if(alreadyContractedProduct) {
                availableAmount += goal.getContractedProductList().get(0).getBalance();
                apiClient.withdraw(goal.getContractedProductList().get(0), goal.getContractedProductList().get(0).getBalance());
            }
        } else {
            product = products.stream().filter(p -> p.getSubType() == ProductType.ProductSubType.LOW_RISK).findFirst();
            if(alreadyContractedProduct) {
                availableAmount += goal.getContractedProductList().get(0).getBalance();
                apiClient.withdraw(goal.getContractedProductList().get(0), goal.getContractedProductList().get(0).getBalance());
            }
        }

        if(availableAmount > 0) {
            goalInvestmentAllocation.setInvestedAmount(availableAmount);
            goalInvestmentAllocation.setGoalId(goal.getId());
            goalInvestmentAllocation.setProductId(product.get().getId());
            double monthlyYieldTarget = goal.getTargetAmount() / goalRemainingMonths;
            double currentInvestedAmount = alreadyContractedProduct ? goal.getContractedProductList().get(0).getBalance() : 0;
            double idealInvestedAmount = goalActiveMonths * monthlyYieldTarget;
            goalInvestmentAllocation.setOnTrack(currentInvestedAmount >= 0.95 * idealInvestedAmount
                    ? GoalProgressStatus.GREEN.name() :
                    (currentInvestedAmount < 0.95 * idealInvestedAmount && currentInvestedAmount >= 0.8 * idealInvestedAmount
                            ? GoalProgressStatus.AMBER.name() : GoalProgressStatus.RED.name()));

            apiClient.investAmount(goalInvestmentAllocation);
        }
        return goalInvestmentAllocation;
    }

    private Product findBestProduct(List<Product> products, int goalRemainingMonths) {
        Optional<Product> bestProduct = products.stream().filter(p -> p.getDuration() <= goalRemainingMonths).sorted().findFirst();
        return bestProduct.get();
//        List<Product> appropriateProducts = new ArrayList<>();
//        for(Product product : products) {
//            if(product.getDuration() <= goalRemainingMonths) {
//                appropriateProducts.add(product);
//            }
//        }
//        Collections.sort(appropriateProducts);
//        return appropriateProducts.get(0);
    }

}
