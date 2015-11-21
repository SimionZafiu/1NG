package com.ing.ing1.dto;

/**
 * Created by ggkekas on 20/11/15.
 */
public class GoalInvestmentAllocation {
    private int goalId;
    private double investedAmount;
    private int productId;
    private String onTrack;

    public String isOnTrack() {
        return onTrack;
    }

    public void setOnTrack(String onTrack) {
        this.onTrack = onTrack;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public double getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(double amount) {
        this.investedAmount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
