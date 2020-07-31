package com.agile.ondemand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.FeedbackAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.feedback;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackFragment extends Fragment {

    private RecyclerView feedbackRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        feedbackRecycler = view.findViewById(R.id.feedbackRecycler);

        Feedbacks();

        return view;
    }

    private void Feedbacks(){
        StrictModeClass.StrictMode();
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<feedback>> feedbackCall =  usersApi.getUserFeedback(Url.token);

        feedbackCall.enqueue(new Callback<List<feedback>>() {
            @Override
            public void onResponse(Call<List<feedback>> call, Response<List<feedback>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Code "+ response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<feedback> feedbacks = response.body();
                FeedbackAdapter feedbackAdapter = new FeedbackAdapter(getActivity(), feedbacks);
                feedbackRecycler.setAdapter(feedbackAdapter);
                feedbackRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<feedback>> call, Throwable t) {

            }
        });
    }

}
