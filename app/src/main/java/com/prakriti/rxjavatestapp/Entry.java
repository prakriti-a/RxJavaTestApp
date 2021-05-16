package com.prakriti.rxjavatestapp;

import java.math.BigDecimal;
import java.util.Date;

public class Entry {
// we show entries on recycler view, instead of simple string objects

    // values shown in entry
    private final String entryName;
    private final BigDecimal entryPrice; // java.math
    private final Date entryDate; // java.util

    public Entry(String entryName, BigDecimal entryPrice, Date entryDate) {
        this.entryName = entryName;
        this.entryPrice = entryPrice;
        this.entryDate = entryDate;
    }

    public String getEntryName() {
        return entryName;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }

}
