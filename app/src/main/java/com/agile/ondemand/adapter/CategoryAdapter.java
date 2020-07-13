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
import com.agile.ondemand.model.ServiceAds;

import java.util.List;

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
                String username = holder.tvUsername.getText().toString();
                Intent intent = new Intent(context, FeedbackActivity.class);
                intent.putExtra("username",username);
                v.getContext().startActivity(new Intent(context, FeedbackActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceAdsList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView category, description, timeFrom, timeTo, dayFrom, dayTo, price, tvUsername, tvAddress, tvPhone;
        private Button feedbackButton;

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
        }
    }
}
