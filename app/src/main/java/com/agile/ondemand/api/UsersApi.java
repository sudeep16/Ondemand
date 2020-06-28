package com.agile.ondemand.api;

import com.agile.ondemand.model.User;
import com.agile.ondemand.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersApi {
    /**User Registration*/

    @POST("users/register")
    Call<SignUpResponse> registerUser(@Body User user);
}
