package com.agile.ondemand.testbl;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.agile.ondemand.adapter.WishListAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishlistBl {

    private boolean isSuccess = true;

    public boolean addToWishlist(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.wishList(Url.token, id);

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


    public boolean deleteWishList(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.wishList(token, id);

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


    //getWishList


    public boolean getWishList(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<WishList>> listCall = usersApi.getWishList(token);

        listCall.enqueue(new Callback<List<WishList>>() {
            @Override
            public void onResponse(Call<List<WishList>> call, Response<List<WishList>> response) {
                if (!response.isSuccessful()) {
                    List<WishList> wishLists = response.body();
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }

            }

            @Override
            public void onFailure(Call<List<WishList>> call, Throwable t) {
            }
        });
        return isSuccess;

    }


    //wishList by username

    public boolean getWishListbyUsername(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> wishList = usersApi.wishList(token, id);

        wishList.enqueue(new Callback<Void>() {
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