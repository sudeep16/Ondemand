package com.agile.ondemand.url;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    // public static final String base_url = "http://192.168.1.11:3000/";
   public static final String base_url = "http://10.0.2.2:3007/";
   // public static final String base_url = "http://192.168.100.247:3007/";
//    public static final String base_url = "http://192.168.9.101:3012";
    // public static final String base_url = "http://172.100.100.5:3000/";

    public static String token = "Bearer ";
    public static String imagePath = base_url + "uploads/";

    public static Retrofit getInstance() {
        Gson gson=new GsonBuilder().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        Request newRequest = originalRequest.newBuilder()
                                //.header("Authorization", "Bearer")
                                .build();
                        return chain.proceed(newRequest);
                    }
                })


                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
