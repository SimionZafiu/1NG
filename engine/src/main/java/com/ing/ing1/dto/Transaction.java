package com.ing.ing1.dto;

import com.ing.ing1.dto.TransactionType;

/**
 * Created by ggkekas on 20/11/15.
 */
public class Transaction {
    private int id;
    private double amount;
    private TransactionType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = TransactionType.valueOf(type.toUpperCase());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
