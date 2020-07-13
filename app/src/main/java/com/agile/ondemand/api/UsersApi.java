package com.agile.ondemand.api;

import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.User;
import com.agile.ondemand.serverresponse.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface UsersApi {
    /**
     * User Registration
     */
    @POST("users/register")
    Call<SignUpResponse> registerUser(@Body User user);

    /**
     * User Login
     */
    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("username") String username, @Field("password") String password);

    /**
     * Service ads
     */
    @FormUrlEncoded
    @POST("/serviceAds")
    Call<Void> serviceAds(
            @Header("Authorization") String token,
            @Field("category") String category,
            @Field("description") String description,
            @Field("openingTime") String openingTime,
            @Field("closingTime") String closingTime,
            @Field("daysFrom") String daysFrom,
            @Field("daysTo") String daysTo,
            @Field("price") String price);

    /**
     * Category
     */
    @GET("serviceAds/Plumber")
    Call<List<ServiceAds>> getCategory(@Header("Authorization") String token);

//    @GET("serviceAds/{category}")
//    Call<List<ServiceAdShow>> getAllServiceAds (@Header("Authorization") String token,
//                                                @Path("category") String category);
}
