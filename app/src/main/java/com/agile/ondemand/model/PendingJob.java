package com.agile.ondemand.model;

public class PendingJob {

    private String paymentMethod;
    private String day;
    private String time;
    private String location;
    private Owner hiredBy;

    public PendingJob(String paymentMethod, String day, String time, String location, Owner hireBy) {
        this.paymentMethod = paymentMethod;
        this.day = day;
        this.time = time;
        this.location = location;
        this.hiredBy = hireBy;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Owner getHiredBy() {
        return hiredBy;
    }

    public void setHiredBy(Owner hiredBy) {
        this.hiredBy = hiredBy;
    }
}
