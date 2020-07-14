package com.agile.ondemand.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.CategoryAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlumberFragment extends Fragment {

    private RecyclerView rvPlumber;
    private String category;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_plumber, container, false);

        rvPlumber = root.findViewById(R.id.rvPlumber);
        Bundle bundle = getArguments();
        category = bundle.getString("category");

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<ServiceAds>> listCall = usersApi.getServiceAdsByCategory(Url.token,category);
//        Call<ServiceAds> serviceAdsCall = usersApi.getCategory(Url.token);

        listCall.enqueue(new Callback<List<ServiceAds>>() {
            @Override
            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), ""+ response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<ServiceAds> serviceAds = response.body();
                CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), serviceAds);
                rvPlumber.setAdapter(categoryAdapter);
                rvPlumber.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<List<ServiceAds>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return root;


    }


}