package com.agile.ondemand.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.fragments.PostEditFragment;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPostAdapter extends RecyclerView.Adapter<UserPostAdapter.UserPostHolder> {

    Context context;
    List<ServiceAds> serviceAdsList;

    public UserPostAdapter(Context context, List<ServiceAds> serviceAdsList) {
        this.context = context;
        this.serviceAdsList = serviceAdsList;
    }

    @NonNull
    @Override
    public UserPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userpost_recycler, parent, false);
        return new UserPostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserPostHolder holder, final int position) {

        final ServiceAds serviceAds = serviceAdsList.get(position);
        holder.name.setText(serviceAds.getAdOwner().getUsername());
        holder.address.setText(serviceAds.getAdOwner().getAddress());
        holder.category.setText(serviceAds.getCategory());
        holder.description.setText(serviceAds.getDescription());
        holder.time1.setText(serviceAds.getOpeningTime());
        holder.time2.setText(serviceAds.getClosingTime());
        holder.dayFrom.setText(serviceAds.getDaysFrom());
        holder.dayTo.setText(serviceAds.getDaysTo());
        holder.price.setText(serviceAds.getPrice());
        holder.postid.setText(serviceAds.getId());


        holder.btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.btnmenu);
                popupMenu.inflate(R.menu.edit_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.itemDelete:

                                UsersApi usersApi = Url.getInstance().create(UsersApi.class);
                                Call<Void> deletePost = usersApi.deleteMyPost(Url.token, serviceAds.getId());

                                deletePost.enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        if (!response.isSuccessful()) {
                                            Toast.makeText(context, "code" + response.code(), Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        serviceAdsList.remove(position);
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<Void> call, Throwable t) {
                                        Toast.makeText(context, "error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            case R.id.itemEdit:
                                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                                PostEditFragment postEditFragment = new PostEditFragment();
                                appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, postEditFragment).addToBackStack(null).commit();

                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return serviceAdsList.size();
    }

    public class UserPostHolder extends RecyclerView.ViewHolder {

        private TextView name, category, address, description, time1, time2, dayFrom, dayTo, price, postid,
                btnmenu;

        public UserPostHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvPostName);
            category = itemView.findViewById(R.id.tvPostCategory);
            address = itemView.findViewById(R.id.tvPostAddress);
            description = itemView.findViewById(R.id.tvPostDescription);
            time1 = itemView.findViewById(R.id.tvPostTime1);
            time2 = itemView.findViewById(R.id.tvPostTime2);
            dayFrom = itemView.findViewById(R.id.tvPostDayFrom);
            dayTo = itemView.findViewById(R.id.tvPostDayTo);
            price = itemView.findViewById(R.id.tvPostPrice);
            btnmenu = itemView.findViewById(R.id.tvMenuPost);
            postid = itemView.findViewById(R.id.postID);
        }
    }
}
