package com.agile.ondemand.bll;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackBLL {
    private boolean isSuccess = true;

    public boolean giveFeedback(String token, String rating, String comment, String username){
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> giveFeedbackCall = usersApi.addFeedback(token, rating, comment, username);

        giveFeedbackCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
        return isSuccess;
    }
}
