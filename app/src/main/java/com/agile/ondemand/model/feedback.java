package com.agile.ondemand.model;

public class feedback {

    private String rating, comment;
    private Owner commentBy;

    public feedback(String rating, String comment, Owner commentBy) {
        this.rating = rating;
        this.comment = comment;
        this.commentBy = commentBy;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Owner getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(Owner commentBy) {
        this.commentBy = commentBy;
    }
}
