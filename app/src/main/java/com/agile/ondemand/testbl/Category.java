package com.agile.ondemand.testbl;

import com.agile.ondemand.model.Owner;

public class Category {

    private String _id;
    private String category;
    private String description;
    private String openingTime;
    private String closingTime;
    private String daysFrom;
    private String daysTo;
    private String price;
//    private Owner adOwner;


    public Category(String _id, String category, String description, String openingTime, String closingTime, String daysFrom, String daysTo, String price) {
        this._id = _id;
        this.category = category;
        this.description = description;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.daysFrom = daysFrom;
        this.daysTo = daysTo;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public String getDaysFrom() {
        return daysFrom;
    }

    public String getDaysTo() {
        return daysTo;
    }

    public String getPrice() {
        return price;
    }
}
