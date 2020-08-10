package com.agile.ondemand.bll;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.Notification;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.User;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileBLL {
    private boolean isSuccess = true;

    public boolean updateUserData(String token, String id,UserUpdate userUpdate ) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.updateUserData(token,id,userUpdate);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
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
