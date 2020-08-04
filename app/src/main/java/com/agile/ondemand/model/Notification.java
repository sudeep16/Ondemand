package com.agile.ondemand.model;

public class Notification {

    private boolean accept;
    private String customerID;
    private String serviceID;
    private Owner username;

    public Notification(boolean accept, String customerID, String serviceID,Owner username) {
        this.accept = accept;
        this.customerID = customerID;
        this.serviceID = serviceID;
        this.username = username;
    }

    public Owner getUsername() {
        return username;
    }

    public void setUsername(Owner username) {
        this.username = username;
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

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
}
