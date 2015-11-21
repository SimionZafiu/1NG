package com.ing.ing1.dto;

/**
 * Created by ggkekas on 20/11/15.
 */
public class SavingsAccountAllocation extends GoalInvestmentAllocation {
    private double currentBalance;
    private double securityBuffer;


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getSecurityBuffer() {
        return securityBuffer;
    }

    public void setSecurityBuffer(double securityBuffer) {
        this.securityBuffer = securityBuffer;
    }
}
