package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.model.User;
import com.agile.ondemand.model.WishList;

import java.util.List;

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
    public void onBindViewHolder(@NonNull WishListViewHolder holder, int position) {
        final WishList wishList = wishLists.get(position);
        holder.Username.setText(wishList.getUsername());



    }

    @Override
    public int getItemCount() {
        return wishLists.size();
    }

    public class WishListViewHolder extends RecyclerView.ViewHolder {

        private TextView Username;
//        private Button btnRemove;

        public WishListViewHolder(@NonNull View itemView) {
            super(itemView);

            Username = itemView.findViewById(R.id.tvFUsername);
//            btnRemove = itemView.findViewById(R.id.btnRemove);

        }
    }
}
