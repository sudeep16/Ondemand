package com.agile.ondemand.bll;

import android.app.Service;
import android.util.Log;
import android.widget.Toast;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryBLL {
    private boolean isSuccess = true;

    public boolean addCategory(String token, String category, String description, String openingTime,
                               String closingTime, String daysFrom, String daysTo, String price) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.serviceAds(token,
                category, description, openingTime, closingTime, daysFrom, daysTo, price);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    isSuccess = true;
                    System.out.println(response.code());
                 //  ServiceAds serviceAds=response.body();
                 //   Log.v("RESPONSE_BODY", response.body());

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
