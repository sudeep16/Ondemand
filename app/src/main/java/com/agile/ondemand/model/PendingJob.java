package com.agile.ondemand.model;

public class PendingJob {

    private String _id;
    private String paymentMethod;
    private String day;
    private String time;
    private String location;
    private Owner hiredBy;

    public PendingJob(String _id,String paymentMethod, String day, String time, String location, Owner hireBy) {
        this._id = _id;
        this.paymentMethod = paymentMethod;
        this.day = day;
        this.time = time;
        this.location = location;
        this.hiredBy = hireBy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
