package com.agile.ondemand.model;

public class ServiceAdShow {
    private String category;
    private String description;
    private String openingTime;
    private String closingTime;
    private String daysFrom;
    private String daysTo;
    private String price;
    private String address;
    private String username;
    private String phone;

    public ServiceAdShow(String category, String description, String openingTime, String closingTime,
                         String daysFrom, String daysTo, String price, String address, String username, String phone) {
        this.category = category;
        this.description = description;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.daysFrom = daysFrom;
        this.daysTo = daysTo;
        this.price = price;
        this.address = address;
        this.username = username;
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getDaysFrom() {
        return daysFrom;
    }

    public void setDaysFrom(String daysFrom) {
        this.daysFrom = daysFrom;
    }

    public String getDaysTo() {
        return daysTo;
    }

    public void setDaysTo(String daysTo) {
        this.daysTo = daysTo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
