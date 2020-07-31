package com.agile.ondemand.bll;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.serverresponse.GetResponse;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.url.Url;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class WishlistBLL {
    private UsersApi usersApi;

    public WishlistBLL() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
    }

//       public List<WishList> getWishList(){
//            List<WishList> wishLists=new ArrayList<>();
//
//            Call<GetResponse> getResponseCall=usersApi.getWishList();
//        try {
//            Response<GetResponse> getResponseResponse=getResponseCall.execute();
//            if(!getResponseResponse.isSuccessful()){
//                return wishLists;
//            }else if(getResponseResponse.body().getWishList() !=null){
//
//                wishLists=getResponseResponse.body().getWishList();
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//            return wishLists;
//
//       }

    }
