package com.agile.ondemand.bll;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HireBLL {
    private boolean isSuccess = true;

    public boolean hirePost(String token, String paymentMethod, String day, String time,String location,String username){
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> hirePostCall = usersApi.Hire(token, paymentMethod,day,time,location,username);

        hirePostCall.enqueue(new Callback<Void>() {
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
