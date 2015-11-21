package com.ing.ing1.dto;

import com.ing.ing1.util.Helper;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by ggkekas on 20/11/15.
 */
public class Product implements Comparable<Product> {
    private int id;
    private ProductType type;
    private ProductType.ProductSubType subType;
    private Calendar validFromDate;
    private Calendar validToDate;
    private int duration;
    private double interestRate;

    public ProductType.ProductSubType getSubType() {
        return subType;
    }

    public void setSubType(ProductType.ProductSubType subType) {
        this.subType = subType;
    }
    public Calendar getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(String validFromDate) {
        try {
            this.validFromDate = Helper.getCalendarFromStringDate(validFromDate);
        } catch (ParseException e) {
            throw new RuntimeException("Problem while trying to parse string date " + validFromDate, e);
        }
    }

    public Calendar getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(String validToDate) {
        try {
            this.validToDate = Helper.getCalendarFromStringDate(validToDate);
        } catch (ParseException e) {
            throw new RuntimeException("Problem while trying to parse string date " + validToDate, e);
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Product o) {
        double diff = this.getInterestRate() - o.getInterestRate();
        return diff < 0 ? -1 : ((diff > 0) ? 1 : 0);
    }

    public double getAmountToInvest(double targetYieldAmount) {
        double monthlyInterestRate = getInterestRate() / (double) 12;
        return targetYieldAmount / Math.pow(1 + monthlyInterestRate, getDuration());
    }
}
