package com.agile.ondemand.bll;

import android.util.Log;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.url.Url;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class AddServiceLogic {

    private String token;
    private ServiceAds serviceAds;
   private List<ServiceAds> serviceAdsList=new ArrayList<>();

    public AddServiceLogic(String token, ServiceAds serviceAds) {
        this.token = token;
        this.serviceAds = serviceAds;
    }

    public AddServiceLogic(String token) {
        this.token = token;
    }

    public List<ServiceAds> createServiceList(){
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
       Call<List<ServiceAds>> listCall = usersApi.(token);
        try {
            Response<List<ServiceAds>> listResponse = listCall.execute();
            serviceAdsList = listResponse.body();
        } catch (IOException e) {
            Log.e("Error is:", e.getMessage());

            e.printStackTrace();

        }
        return serviceAdsList;
    }



    public boolean addNewOrder(){
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<String> listCall = usersApi.addNewService(token,serviceAds);
        try {
            Response<String> orderResponse = listCall.execute();

            if (orderResponse.body().equals("posted")){
                return true;
            }
        } catch (IOException e) {
            Log.e("Error is:", e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
