package com.j2se.drools.bean3;

import java.util.Date;

public class AccountPeriod {
    private Date start;
    private Date end;

    @Override
    public String toString() {
        return "AccountPeriod{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public AccountPeriod() {
    }
}
