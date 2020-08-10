package com.agile.ondemand.testbl;

public class postServiceModel {

    private String category;
    private String description;
    private String openingTime;
    private String closingTime;
    private String daysFrom;
    private String daysTo;
    private String price;

    public postServiceModel(String category, String description, String openingTime, String closingTime, String daysFrom, String daysTo, String price) {
        this.category = category;
        this.description = description;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.daysFrom = daysFrom;
        this.daysTo = daysTo;
        this.price = price;
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
}
