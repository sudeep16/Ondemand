package com.agile.ondemand.testbl;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.Notification;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.UserUpdate;
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


    public boolean deletePost(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.deleteMyPost(Url.token,id);

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

    public boolean getMyPost(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<List<ServiceAds>> listCall = usersApi.getUserPost(token);
        listCall.enqueue(new Callback<List<ServiceAds>>() {
            @Override
            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                if (response.isSuccessful()) {
                    isSuccess = true;

                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<List<ServiceAds>> call, Throwable t) {
            }
        });
        return isSuccess;
    }


    public boolean getNotification(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<List<Notification>> listCall = usersApi.getNotification(token);
        listCall.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.isSuccessful()) {
                    isSuccess = true;

                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
            }
        });
        return isSuccess;
    }





}
