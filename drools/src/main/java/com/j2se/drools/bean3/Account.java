package com.j2se.drools.bean3;

public class Account {
    private long   accountNo;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", balance=" + balance +
                '}';
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
    }
}
