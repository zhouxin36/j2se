package com.j2se.drools.bean3;

import java.util.Date;

public class CashFlow {
    private Date date;
    private double amount;
    private int    type;
    long           accountNo;

    @Override
    public String toString() {
        return "CashFlow{" +
                "date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                ", accountNo=" + accountNo +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public CashFlow() {
    }
}
