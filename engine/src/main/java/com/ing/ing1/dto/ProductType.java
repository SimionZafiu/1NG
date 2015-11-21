package com.ing.ing1.dto;

/**
 * Created by ggkekas on 20/11/15.
 */
public enum ProductType {
    CURRENT,
    SAVINGS,
    FIXED_INCOME,
    INVESTMENT;

    public enum ProductSubType {
        LOW_RISK,
        MEDIUM_RISK,
        HIGH_RISK
    }
}
