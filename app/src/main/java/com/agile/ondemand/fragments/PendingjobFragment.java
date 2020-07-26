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
import com.agile.ondemand.adapter.WishListAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingjobFragment extends Fragment {

    RecyclerView pendingjob;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pendingjob, container, false);

        pendingjob = view.findViewById(R.id.PendingjobRecycler);

        hireList();
        return view;

    }

    private void hireList() {

        StrictModeClass.StrictMode();
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<PendingJob>> pendingJobCall = usersApi.getHiredList(Url.token);

        pendingJobCall.enqueue(new Callback<List<PendingJob>>() {
            @Override
            public void onResponse(Call<List<PendingJob>> call, Response<List<PendingJob>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<PendingJob> pendingJobs =  response.body();

                PendingJobAdapter pendingJobAdapter = new PendingJobAdapter(getActivity(), pendingJobs);
                pendingjob.setAdapter(pendingJobAdapter);
                pendingjob.setLayoutManager(new LinearLayoutManager(getActivity()));

            }

            @Override
            public void onFailure(Call<List<PendingJob>> call, Throwable t) {

            }
        });
    }
}
