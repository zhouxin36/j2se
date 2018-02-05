package com.j2se.drools.bean;

import java.util.Date;

public class Application {
    private Date dateApplied;
    private boolean valid = true;

    public Application() {
    }

    @Override
    public String toString() {
        return "Application{" +
                "dateApplied=" + dateApplied +
                ", valid=" + valid +
                '}';
    }

    public Application(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
