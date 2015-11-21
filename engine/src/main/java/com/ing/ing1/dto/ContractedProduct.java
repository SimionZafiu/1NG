package com.ing.ing1.dto;

import com.ing.ing1.util.Helper;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by ggkekas on 20/11/15.
 */
public class ContractedProduct {
    private int id;
    private int customerId;
    private Product product;
    private Calendar creationDate;
    private double amount;
    private double balance;

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        try {
            this.creationDate = Helper.getCalendarFromStringDate(creationDate);
        } catch (ParseException e) {
            throw new RuntimeException("Problem while trying to parse string date " + creationDate, e);
        }
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getYield() {
        double monthlyInterestRate = product.getInterestRate() / (double) 12;
        return balance * Math.pow(1 + monthlyInterestRate, product.getDuration());
    }
}
