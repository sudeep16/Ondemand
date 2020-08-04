package com.agile.ondemand.model;

public class Notification {

    private boolean accept;
    private String customerID;
    private Owner serviceID;

    public Notification(boolean accept, String customerID, Owner serviceID) {
        this.accept = accept;
        this.customerID = customerID;
        this.serviceID = serviceID;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Owner getServiceID() {
        return serviceID;
    }

    public void setServiceID(Owner serviceID) {
        this.serviceID = serviceID;
    }
}
