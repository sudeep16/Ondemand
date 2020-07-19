package com.agile.ondemand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.WishListAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishListFragment extends Fragment {

    private RecyclerView wishListRecycler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);


        wishListRecycler = view.findViewById(R.id.wishListRecycler);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<WishList>> listCall = usersApi.getWishList(Url.token);

        listCall.enqueue(new Callback<List<WishList>>() {
            @Override
            public void onResponse(Call<List<WishList>> call, Response<List<WishList>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<WishList> wishLists = response.body();
                WishListAdapter wishListAdapter = new WishListAdapter(getActivity(), wishLists);
                wishListRecycler.setAdapter(wishListAdapter);
                wishListRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<WishList>> call, Throwable t) {

            }
        });


        return view;
    }
}
