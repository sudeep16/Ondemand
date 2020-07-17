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
import retrofit2.http.Path;


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
//    @GET("serviceAds/Plumber")
//    Call<List<ServiceAds>> getCategory(@Header("Authorization") String token);
    @GET("serviceAds/{category}")
    Call<List<ServiceAds>> getServiceAdsByCategory(@Header("Authorization") String token,
                                                   @Path("category") String category);

    @FormUrlEncoded
    @POST("feedbacks/{username}")
    Call<Void> addFeedback(@Header("Authorization") String token,
                           @Field("rating") String rating,
                           @Field("comment") String comment,
                           @Path("username") String username);

    /**
     * Hire Post
     */
    @FormUrlEncoded
    @POST("hiredList/{username}")
    Call<Void> Hire(@Header("Authorization") String token,
                    @Field("paymentMethod") String paymentMethod,
                    @Field("day") String day,
                    @Field("time") String time,
                    @Field("location") String location,
                    @Path("username") String username);

    /**
     * get user
     */
    @GET("users/profile")
    Call<User> getUserDetail(@Header("Authorization") String token);

    /**
     *update user
     */
}
