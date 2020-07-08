package com.agile.ondemand.bll;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validation {
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=<>_!*().,])" +    //at least 1 special character
                    ".{6,}" +               //at least 6 characters
                    "$");

    private String throwError;

    public boolean validateFirstName(String regFirstName){
        return !regFirstName.isEmpty();
    }

    public boolean validateLastName(String regLastName){
        return !regLastName.isEmpty();
    }

    public boolean validateAddress(String regAddress){
        return !regAddress.isEmpty();
    }

    public String validateEmail(String regEmail){
        if (regEmail.isEmpty()){
            throwError = "required";
            return throwError;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(regEmail).matches()){
            throwError = "invalid";
            return throwError;
        } else {
            throwError = "noError";
            return throwError;
        }
    }

    public String validatePhone(String regPhone) {
        if (regPhone.isEmpty()) {
            throwError = "required";
            return throwError;
        } else if (regPhone.length() > 11) {
            throwError = "invalid";
            return throwError;
        } else {
            throwError = "noError";
            return throwError;
        }
    }

    public String validatePassword(String regPassword) {
        if (regPassword.isEmpty()) {
            throwError = "required";
            return throwError;
        } else if (!PASSWORD_PATTERN.matcher(regPassword).matches()) {
            throwError = "weakPassword";
            return throwError;
        } else {
            throwError = "noError";
            return throwError;
        }
    }

    public String validateConfirmPassword(String regPassword, String regCPassword) {
        if (!regPassword.equals(regCPassword)) {
            throwError = "!Password";
            return throwError;
        } else if (regCPassword.isEmpty()) {
            throwError = "required";
            return throwError;
        } else {
            throwError = "noError";
            return throwError;
        }
    }

    public String validateUsername(String regUsername) {
        if (regUsername.isEmpty()) {
            throwError = "required";
            return throwError;
        } else if (regUsername.length() > 31) {
            throwError = "usernameTooLong";
            return throwError;
        } else if (regUsername.length() < 7) {
            throwError = "usernameTooShort";
            return throwError;
        } else {
            throwError = "noError";
            return throwError;
        }
    }
}
