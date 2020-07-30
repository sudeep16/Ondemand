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
import com.agile.ondemand.adapter.PendingJobAdapter;
import com.agile.ondemand.adapter.UserPostAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPostFragment extends Fragment {

    private RecyclerView myPostRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypost, container, false);
        myPostRecycler = view.findViewById(R.id.myPostRecycler);

        MyPost();
        return view;
    }

    private void MyPost() {
        StrictModeClass.StrictMode();
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<ServiceAds>> listCall = usersApi.getUserPost(Url.token);

        listCall.enqueue(new Callback<List<ServiceAds>>() {
            @Override
            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<ServiceAds> serviceAds = response.body();
                UserPostAdapter userPostAdapter = new UserPostAdapter(getActivity(), serviceAds);
                myPostRecycler.setAdapter(userPostAdapter);
                myPostRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<ServiceAds>> call, Throwable t) {

            }
        });

    }
}
