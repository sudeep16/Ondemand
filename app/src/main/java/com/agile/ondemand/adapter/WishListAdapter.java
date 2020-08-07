package com.agile.ondemand.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.fragments.ViewProfileFragment;
import com.agile.ondemand.model.User;
import com.agile.ondemand.model.WishList;
import com.agile.ondemand.url.Url;

import java.sql.RowId;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.WishListViewHolder> {

    Context context;
    List<WishList> wishLists;

    public WishListAdapter(Context context, List<WishList> wishLists) {
        this.context = context;
        this.wishLists = wishLists;
    }

    @NonNull
    @Override
    public WishListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_design, parent, false);
        return new WishListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WishListViewHolder holder, final int position) {
        final WishList wishList = wishLists.get(position);
        holder.Username.setText(wishList.getUsername());
        holder.wishListId.setText(wishList.get_id());
        holder.btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                ViewProfileFragment viewProfileFragment = new ViewProfileFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username",wishList.getUsername());
                viewProfileFragment.setArguments(bundle);
                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, viewProfileFragment)
                        .addToBackStack(null).commit();
            }
        });
        
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersApi usersApi = Url.getInstance().create(UsersApi.class);
                Call<Void> deleteWishList = usersApi.deleteWishList(Url.token, wishList.get_id());
                
                deleteWishList.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(context, "Code "+response.body(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        wishLists.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Removed from wishList", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context, "error "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return wishLists.size();
    }

    public class WishListViewHolder extends RecyclerView.ViewHolder {

        private TextView Username, wishListId;
        private Button btnViewProfile;
        private Button btnRemove;

        public WishListViewHolder(@NonNull View itemView) {
            super(itemView);

            Username = itemView.findViewById(R.id.tvFUsername);
            btnViewProfile= itemView.findViewById(R.id.btnViewProfile);
            wishListId= itemView.findViewById(R.id.wishListId);
            btnRemove = itemView.findViewById(R.id.btnRemove);

        }
    }
}
