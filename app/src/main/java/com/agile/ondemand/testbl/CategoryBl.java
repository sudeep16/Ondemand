package com.agile.ondemand.testbl;

import android.util.Log;
import android.widget.Toast;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;
import com.google.gson.JsonSyntaxException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryBl {
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
                    //ServiceAds serviceAds=response.body();
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

    String token;

    public boolean getServiceList(String token, String category) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        final ServiceAds serviceAds;
        Call<List<ServiceAds>> listCall = usersApi.getServiceAdsByCategory(token,"Plumber");
        listCall.enqueue(new Callback<List<ServiceAds>>() {
            @Override
            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                if (response.isSuccessful()) {
//                    response.code();
                    List<ServiceAds>serviceAdsList=response.body();
                    for(ServiceAds serviceAds1:serviceAdsList){
                        String content="";
                        content+="Token:"+Url.token+"\n";
                        content+="Category"+serviceAds1.getCategory()+"\n";
                        System.out.println(response.code());
                        Log.d("res", response.body().toString());
                        System.out.println(content);
            //&& SignUpResponse.getToken().startsWith("Bearer"
                    }


                    isSuccess = true;
                //    List<ServiceAds> serviceAds = response.body();
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


        public boolean getFeedback(String token) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<List<feedback>> listCall = usersApi.getUserFeedback(token);
        listCall.enqueue(new Callback<List<feedback>>() {
            @Override
            public void onResponse(Call<List<feedback>> call, Response<List<feedback>> response) {
                if (response.isSuccessful()) {
                    isSuccess = true;

                } else {
                    isSuccess = false;
                }
            }

            @Override
            public void onFailure(Call<List<feedback>> call, Throwable t) {
            }
        });
        return isSuccess;
    }


    public boolean updateServiceAd(String token, String id, ServiceAdsUpdate serviceAdsUpdate) {

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> voidCall = usersApi.updateServiceAd(token,id,serviceAdsUpdate);

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




    //view Selected Daata

    public boolean fetchDataToUpdateFragment(String token,String id) {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<ServiceAdsUpdate> serviceAdsCall = usersApi.fetchDataToUpdateFragment(token, id);
        serviceAdsCall.enqueue(new Callback<ServiceAdsUpdate>() {
            @Override
            public void onResponse(Call<ServiceAdsUpdate> call, Response<ServiceAdsUpdate> response) {
                if (!response.isSuccessful()) {
                    isSuccess=true;
                }else{
                    isSuccess=false;
                }
            }
            @Override
            public void onFailure(Call<ServiceAdsUpdate> call, Throwable t) {
            }
        });
        return isSuccess;
    }






}
