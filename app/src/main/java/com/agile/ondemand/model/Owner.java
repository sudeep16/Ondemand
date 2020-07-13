package com.agile.ondemand.model;

public class Owner {

     private String _id;
     private String address;
     private String username;
     private String phone;

    public Owner(String _id, String address, String username, String phone) {
        this._id = _id;
        this.address = address;
        this.username = username;
        this.phone = phone;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
