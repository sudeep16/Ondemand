package com.agile.ondemand.testbl;

import android.app.DownloadManager;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;

import static com.agile.ondemand.testbl.CatResponse.*;

public class CatBl {
    private boolean isSuccess = true;

    SignUpResponse catResponse;

    public boolean addCategory(String token,String category, String description, String openingTime,
                               String closingTime, String daysFrom, String daysTo, String price) {
       // postServiceModel postServiceModel1=new postServiceModel(category,description,openingTime,closingTime,daysFrom,daysTo,price);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

//          String token1=catResponse.getToken();


        Call<CatResponse> voidCall = usersApi.addService("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTcwNTIxNzB9.R-Hj9D3-Ou4Wc377wc-Ev_vfbsyAkz8ErnK7uJVajHk",category,description,openingTime,closingTime,daysFrom,daysTo,price);


        try {
            Response<CatResponse> catResponseResponse = voidCall.execute();
            if (catResponseResponse.isSuccessful()) {
                //Url.token += catResponseResponse.body().getToken();

              // Url.token += catResponseResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        


//        voidCall.enqueue(new Callback<CatResponse>() {
//            @Override
//            public void onResponse(Call<CatResponse> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    isSuccess = true;
//                } else {
//                    isSuccess = false;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//            }
//        });
        return isSuccess;
    }

}
