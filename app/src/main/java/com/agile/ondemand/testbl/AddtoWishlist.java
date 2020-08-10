package com.agile.ondemand.testbl;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddtoWishlist {

    private boolean isSuccess = true;

    public boolean addToWishlist(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.wishList(Url.token,id);

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
