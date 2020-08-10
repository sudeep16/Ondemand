package com.agile.ondemand.testbl;

import com.agile.ondemand.url.Url;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class CategoryBl {

    private String category;
    private String description;
    private String openingTime;
    private String closingTime;
    private String daysFrom;
    private String daysTo;
    private String price;
    boolean isSuccess=false;
    UserApi userApi;

    public static List<Category> categoryList;

    public CategoryBl(String category, String description, String openingTime, String closingTime, String daysFrom, String daysTo, String price) {
        this.category = category;
        this.description = description;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.daysFrom = daysFrom;
        this.daysTo = daysTo;
        this.price = price;
    }
    public CategoryBl(){}

    public boolean addToCart(){
        UserApi foodAPI= Url.getInstance().create(UserApi.class);
        Category cart =new Category("",category,description,openingTime,closingTime,daysFrom,daysTo,price);
        Call<CatResponse> cartModelCall=foodAPI.addService(cart);

        try {
            Response<CatResponse> cartresponse = cartModelCall.execute();
            if (cartresponse.body()!= null) {
                isSuccess=true;
            }
            else{
                isSuccess=false;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return isSuccess;
    }




}
