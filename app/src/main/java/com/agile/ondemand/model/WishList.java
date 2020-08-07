package com.agile.ondemand.model;

public class WishList {
    private String _id;
    private String username;

    public WishList(String _id, String username) {
        this._id = _id;
        this.username = username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
