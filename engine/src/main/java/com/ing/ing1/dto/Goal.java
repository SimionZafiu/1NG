package com.ing.ing1.dto;

import com.ing.ing1.util.Helper;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ggkekas on 20/11/15.
 */
public class Goal {
    private int id;
    private GoalType type;
    private double targetAmount;
    private Calendar startDate;
    private Calendar endDate;
    private List<ContractedProduct> products;

    public List<ContractedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ContractedProduct> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GoalType getGoalType() {
        return type;
    }

    public void setGoalType(String type) {
        this.type = GoalType.valueOf(type.toUpperCase());
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        try {
            this.startDate = Helper.getCalendarFromStringDate(startDate);
        } catch (ParseException e) {
            throw new RuntimeException("Problem while trying to parse string date " + startDate, e);
        }
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        try {
            this.endDate = Helper.getCalendarFromStringDate(endDate);
        } catch (ParseException e) {
            throw new RuntimeException("Problem while trying to parse string date " + endDate, e);
        }
    }

    public int getDuration() {
        return Helper.getMonthsDifference(startDate, endDate);
    }

    public double getCurrentTotalYield() {
        return products.stream().mapToDouble(ContractedProduct::getYield).sum();
//        double sum = 0;
//        for(ContractedProduct contractedProduct : products) {
//            sum += contractedProduct.getYield();
//        }
//        return sum;
    }
}
