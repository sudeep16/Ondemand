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
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProfileAdapter extends RecyclerView.Adapter<ViewProfileAdapter.ViewProfileHolder> {

    Context context;
    List<ServiceAds> serviceAdsList;

    public ViewProfileAdapter(Context context, List<ServiceAds> serviceAdsList) {
        this.context = context;
        this.serviceAdsList = serviceAdsList;
    }

    @NonNull
    @Override
    public ViewProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_design, parent, false);
        return new ViewProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewProfileHolder holder, int position) {

        final ServiceAds serviceAds = serviceAdsList.get(position);
        holder.postUsername.setText(serviceAds.getAdOwner().getUsername());
        holder.postAddress.setText(serviceAds.getAdOwner().getAddress());
        holder.postContact.setText(serviceAds.getAdOwner().getPhone());
        holder.postDesc.setText(serviceAds.getDescription());
        holder.postCategory.setText(serviceAds.getCategory());
        holder.postTime1.setText(serviceAds.getOpeningTime());
        holder.posTime2.setText(serviceAds.getClosingTime());
        holder.postDayFrom.setText(serviceAds.getDaysFrom());
        holder.postDayTo.setText(serviceAds.getDaysTo());
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

    public class ViewProfileHolder extends RecyclerView.ViewHolder {

        private TextView postUsername, postAddress, postContact, postCategory, postDesc, postTime1, posTime2, postDayFrom, postDayTo, postPrice;
        private Button feedbackButton, btnHire, btnWishList;

        public ViewProfileHolder(@NonNull View itemView) {
            super(itemView);

            postUsername = itemView.findViewById(R.id.tvUsername);
            postAddress = itemView.findViewById(R.id.tvAddress);
            postContact = itemView.findViewById(R.id.tvPhone);
            postCategory = itemView.findViewById(R.id.tvCategories);
            postDesc = itemView.findViewById(R.id.tvDescription);
            postTime1 = itemView.findViewById(R.id.tvFromTime);
            posTime2 = itemView.findViewById(R.id.tvToTime);
            postDayFrom = itemView.findViewById(R.id.tvDayFrom);
            postDayTo = itemView.findViewById(R.id.tvDayTo);
            postPrice = itemView.findViewById(R.id.tvPrice);
            feedbackButton = itemView.findViewById(R.id.feedbackBtn);
            btnHire = itemView.findViewById(R.id.btnHire);
            btnWishList = itemView.findViewById(R.id.btnWishList);
        }
    }
}
