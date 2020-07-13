package com.agile.ondemand.model;

public class ServiceAds {

    private String category;
    private String description;
    private String openingTime;
    private String closingTime;
    private String daysFrom;
    private String daysTo;
    private String price;
    private Owner adOwner;

    public ServiceAds(String category, String description, String openingTime, String closingTime, String daysFrom, String daysTo, String price, Owner adOwner) {
        this.category = category;
        this.description = description;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.daysFrom = daysFrom;
        this.daysTo = daysTo;
        this.price = price;
        this.adOwner = adOwner;
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

    public Owner getAdOwner() {
        return adOwner;
    }

    public void setAdOwner(Owner adOwner) {
        this.adOwner = adOwner;
    }
}
