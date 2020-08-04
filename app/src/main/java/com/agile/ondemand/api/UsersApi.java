package com.agile.ondemand.api;

import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.model.User;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.serverresponse.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    Call<UserUpdate> getUserDetail(@Header("Authorization") String token);

    /**
     * update user
     */
    @PUT("users/profile/{id}")
    Call<Void> updateUserData(@Header("Authorization") String token,
                              @Path("id") String id,
                              @Body UserUpdate userUpdate);

    @DELETE("users/profile/{id}")
    Call<Void> deleteUserAccount(@Header("Authorization") String token,
                                 @Path("id") String id);

    @POST("wishlist/{username}")
    Call<Void> wishList(@Header("Authorization") String token,
                        @Path("username") String username);

    @FormUrlEncoded
    @POST("pendingList/{username}")
    Call<Void> pendingJobApproval(@Header("Authorization") String token,
                                  @Path("username") String username,
                                  @Field("accept") Boolean accept);

    @GET("wishlist")
    Call<List<WishList>> getWishList(@Header("Authorization") String token);

    @GET("hiredList/pending")
    Call<List<PendingJob>> getHiredList(@Header("Authorization") String token);

    @GET("hiredList/pendingCount")
    Call<Integer> getPendingJobCount(@Header("Authorization") String token);

    @GET("feedbacks/myTotalFeedbacksCount")
    Call<Integer> getTotalFeedbacksCount(@Header("Authorization") String token);

    @GET("users/profile/{firstletter}")
    Call<List<UserUpdate>> getUserByFirstLetter(@Header("Authorization") String token,
                                                @Path("firstletter") String firstletter);


    /**
     * get user's post
     */
    @GET("serviceAds/mypost/services")
    Call<List<ServiceAds>> getUserPost(@Header("Authorization") String token);

    /**
     * get feedback
     */
    @GET("feedbacks/myfeedbacks")
    Call<List<feedback>> getUserFeedback(@Header("Authorization") String token);

    @GET("users/profileByUsername/{username}")
    Call<UserUpdate> ViewUser(@Header("Authorization") String token,
                              @Path("username") String username);

    @GET("serviceAds/postById/{id}")
    Call<List<ServiceAds>> getViewProfilePost(@Header("Authorization") String token,
                                              @Path("id") String id);

    @DELETE("serviceAds/modifyMyPost/{id}")
    Call<Void> deleteMyPost(@Header("Authorization") String token,
                            @Path("id") String id);

    @GET("serviceAds/modifyMyPost/{id}")
    Call<ServiceAdsUpdate> fetchDataToUpdateFragment(@Header("Authorization") String token,
                                                     @Path("id") String id);

    @PUT("serviceAds/modifyMyPost/{id}")
    Call<Void> updateServiceAd(@Header("Authorization") String token,
                               @Path("id") String id,
                               @Body ServiceAdsUpdate serviceAdsUpdate);
}
