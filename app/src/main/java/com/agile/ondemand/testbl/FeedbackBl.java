package com.agile.ondemand.testbl;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.agile.ondemand.adapter.FeedbackAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackBl {

    private boolean isSuccess = true;

    public boolean getUserFeedback(String token) {

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<feedback>> feedbackCall = usersApi.getUserFeedback(token);

        feedbackCall.enqueue(new Callback<List<feedback>>() {
            @Override
            public void onResponse(Call<List<feedback>> call, Response<List<feedback>> response) {
                if (!response.isSuccessful()) {
                    isSuccess=true;
                    List<feedback> feedbacks = response.body();
                }else{
                    isSuccess=false;

                }
            }

            @Override
            public void onFailure(Call<List<feedback>> call, Throwable t) {

            }
        });
        return isSuccess;
    }
}
