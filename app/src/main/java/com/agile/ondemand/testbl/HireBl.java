package com.agile.ondemand.testbl;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.url.Url;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HireBl {
    boolean isSuccess=false;
//    public HireBl(){}
//
//    public boolean addOrder(PendingJob pendingJob,String username){
//        UsersApi foodAPI= Url.getInstance().create(UsersApi.class);
//        Call<HireResponse> cartModelCall=foodAPI.HirePerson(pendingJob,username);
//
//        try {
//            Response<HireResponse> cartresponse = cartModelCall.execute();
//            if (cartresponse.isSuccessful()) {
//                isSuccess=true;
//            }
//            else{
//                isSuccess=false;
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        return isSuccess;
//    }
//


    public boolean approvePendingJob(String token, String id,boolean accept) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.pendingJobApproval(Url.token,id,accept);

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

    public boolean deleteHireList(String token, String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.deleteHiredList(Url.token,id);

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

    public boolean getPendingJobs(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<List<PendingJob>> listCall = usersApi.getHiredList(token);
        listCall.enqueue(new Callback<List<PendingJob>>() {
            @Override
            public void onResponse(Call<List<PendingJob>> call, Response<List<PendingJob>> response) {
                if (response.isSuccessful()) {
                    isSuccess = true;

                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<List<PendingJob>> call, Throwable t) {
            }
        });
        return isSuccess;
    }





}
