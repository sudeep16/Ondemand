package com.agile.ondemand.testbl;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.agile.ondemand.adapter.UserPostAdapter;
import com.agile.ondemand.adapter.UsersAdapter;
import com.agile.ondemand.adapter.ViewProfileAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.Notification;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.sql.PreparedStatement;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileBl {
    private boolean isSuccess = true;

    public boolean updateUserData(String token, String id, UserUpdate userUpdate) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.updateUserData(token, id, userUpdate);

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
        Call<Void> voidCall = usersApi.deleteMyPost(token, id);

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


    //loadUser
    public boolean getUserDetail(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<UserUpdate> userUpdateCall = usersApi.getUserDetail(Url.token);

        userUpdateCall.enqueue(new Callback<UserUpdate>() {
            @Override
            public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                if (!response.isSuccessful()) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<UserUpdate> call, Throwable t) {
            }
        });
        return isSuccess;
    }

    public boolean userDelete(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> userDeleteCall = usersApi.deleteUserAccount(token, id);

        userDeleteCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
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


    //counts

    public boolean pendingJobCount(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Integer> pendingJobCountCall = usersApi.getPendingJobCount(token);
        pendingJobCountCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int count = response.body();
                String countString = Integer.toString(count);
                if (!response.isSuccessful()) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
            }
        });
        return isSuccess;
    }

    public boolean feedbacksCount(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Integer> feedbacksCountCall = usersApi.getTotalFeedbacksCount(Url.token);
        feedbacksCountCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int count = response.body();
                String countString = Integer.toString(count);
                System.out.println(countString);
                if (!response.isSuccessful()) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
        return isSuccess;
    }


   public boolean loadUserByFirstName(String token,String firstLetter) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
//        Bundle bundle = new Bundle();
        Call<List<UserUpdate>> listCall = usersApi.getUserByFirstLetter(Url.token, firstLetter);

        listCall.enqueue(new Callback<List<UserUpdate>>() {
            @Override
            public void onResponse(Call<List<UserUpdate>> call, Response<List<UserUpdate>> response) {
                if (!response.isSuccessful()) {
                    isSuccess = true;
                    List<UserUpdate> usersFirstName = response.body();
                    System.out.println(usersFirstName);
                } else {
                    isSuccess = false;
                }

            }

            @Override
            public void onFailure(Call<List<UserUpdate>> call, Throwable t) {
            }
        });
return isSuccess;
    }


    //GET current user's details
    public boolean viewUserProfile(String token, String username) {
        final UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        String username1 = "Tester1";
        Call<UserUpdate> userUpdateCall = usersApi.ViewUser(token, username1);
        userUpdateCall.enqueue(new Callback<UserUpdate>() {
            @Override
            public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                if (!response.isSuccessful()) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<UserUpdate> call, Throwable t) {
            }
        });
        return isSuccess;
    }

    public boolean getViewProfilePost(String token, String id) {
        UsersApi usersApi1 = Url.getInstance().create(UsersApi.class);
        Call<List<ServiceAds>> viewProfilePost = usersApi1.getViewProfilePost(token, id);
        viewProfilePost.enqueue(new Callback<List<ServiceAds>>() {
            @Override
            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                if (!response.isSuccessful()) {

                    isSuccess = true;
                    List<ServiceAds> serviceAds = response.body();
                } else {
                    isSuccess = false;
                }
            }


            @Override
            public void onFailure(Call<List<ServiceAds>> call, Throwable t) { }
        });

    return isSuccess;
    }

}
