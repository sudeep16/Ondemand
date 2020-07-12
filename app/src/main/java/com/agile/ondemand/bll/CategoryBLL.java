package com.agile.ondemand.bll;

import android.widget.Toast;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryBLL {
    private boolean isSuccess = false;

    public boolean addCategory(String token, String category, String description, String openingTime,
                               String closingTime, String daysFrom, String daysTo, String price){
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<Void> voidCall = usersApi.serviceAds(token,
                category, description, openingTime, closingTime, daysFrom, daysTo, price);

        voidCall.enqueue(new Callback<Void>() {
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
