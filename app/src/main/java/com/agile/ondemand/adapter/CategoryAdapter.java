package com.agile.ondemand.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.FeedbackActivity;
import com.agile.ondemand.activity.HireActivity;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<ServiceAds> serviceAdsList;

    public CategoryAdapter(Context context, List<ServiceAds> serviceAdsList) {
        this.context = context;
        this.serviceAdsList = serviceAdsList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_design, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryViewHolder holder, int position) {
        final ServiceAds serviceAds = serviceAdsList.get(position);
        holder.category.setText(serviceAds.getCategory());
        holder.description.setText(serviceAds.getDescription());
        holder.timeFrom.setText(serviceAds.getOpeningTime());
        holder.timeTo.setText(serviceAds.getClosingTime());
        holder.dayFrom.setText(serviceAds.getDaysFrom());
        holder.dayTo.setText(serviceAds.getDaysTo());
        holder.price.setText(serviceAds.getPrice());
        holder.tvUsername.setText(serviceAds.getAdOwner().getUsername());
        holder.tvAddress.setText(serviceAds.getAdOwner().getAddress());
        holder.tvPhone.setText(serviceAds.getAdOwner().getPhone());


        holder.feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FeedbackActivity.class);
                intent.putExtra("username", serviceAds.getAdOwner().getUsername());
                context.startActivity(intent);
//                v.getContext().startActivity(new Intent(context, FeedbackActivity.class));
            }
        });

        holder.btnHire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HireActivity.class);
                intent.putExtra("username", serviceAds.getAdOwner().getUsername());
                context.startActivity(intent);
//                v.getContext().startActivity(new Intent(context, HireActivity.class));
            }
        });

        holder.btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersApi usersApi = Url.getInstance().create(UsersApi.class);
                Call<Void> wishList = usersApi.wishList(Url.token, serviceAds.getAdOwner().getUsername());

                wishList.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(context, "" + response.code(), Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(context, "" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceAdsList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView category, description, timeFrom, timeTo, dayFrom, dayTo, price, tvUsername, tvAddress, tvPhone;
        private Button feedbackButton, btnHire, btnWishList;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.tvCategories);
            description = itemView.findViewById(R.id.tvDescription);
            timeFrom = itemView.findViewById(R.id.tvFromTime);
            timeTo = itemView.findViewById(R.id.tvToTime);
            dayFrom = itemView.findViewById(R.id.tvDayFrom);
            dayTo = itemView.findViewById(R.id.tvDayTo);
            price = itemView.findViewById(R.id.tvPrice);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            feedbackButton = itemView.findViewById(R.id.feedbackBtn);
            btnHire = itemView.findViewById(R.id.btnHire);
            btnWishList = itemView.findViewById(R.id.btnWishList);
        }
    }
}
