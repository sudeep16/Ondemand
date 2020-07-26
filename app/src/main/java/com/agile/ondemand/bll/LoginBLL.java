package com.agile.ondemand.bll;

import android.widget.Toast;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<SignUpResponse> userCall = usersApi.checkUser("username", "password");

        try {
            Response<SignUpResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().getStatus().equals("Login successful")) {
                Url.token += loginResponse.body().getToken();
                isSuccess = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
