package com.agile.ondemand.bll;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.User;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SignUpBLL {
    private boolean isSuccess = false;

    public boolean signupUser(String firstName, String lastName, String address, String username, String email, String phone, String gender, String password) {
        User user = new User(firstName, lastName, address, username, email, phone, gender, password);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<SignUpResponse> signUpResponseCall = usersApi.registerUser(user);

        try {
            Response<SignUpResponse> signUpResponseResponse = signUpResponseCall.execute();
            if (signUpResponseResponse.isSuccessful() && signUpResponseResponse.body().getStatus().equals("Registered successfully")) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
