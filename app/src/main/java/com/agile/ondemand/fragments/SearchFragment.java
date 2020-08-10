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
import com.agile.ondemand.activity.MainActivity;
import com.agile.ondemand.adapter.CategoryAdapter;
import com.agile.ondemand.adapter.UsersAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private RecyclerView searchRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchRecycler = view.findViewById(R.id.searchRecycler);
        loadUserByFirstName();
        return view;
    }

    //Search by user's first name
    private void loadUserByFirstName() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
//        Bundle bundle = new Bundle();
        String firstLetter = getArguments().getString("Firstletter");
        Call<List<UserUpdate>> listCall = usersApi.getUserByFirstLetter(Url.token, firstLetter);

        listCall.enqueue(new Callback<List<UserUpdate>>() {
            @Override
            public void onResponse(Call<List<UserUpdate>> call, Response<List<UserUpdate>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<UserUpdate> usersFirstName = response.body();
                UsersAdapter usersAdapter = new UsersAdapter(getActivity(), usersFirstName);
                searchRecycler.setAdapter(usersAdapter);
                searchRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<UserUpdate>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
