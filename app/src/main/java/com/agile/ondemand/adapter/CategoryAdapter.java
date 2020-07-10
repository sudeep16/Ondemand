package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
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
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final ServiceAds serviceAds = serviceAdsList.get(position);
        holder.category.setText(serviceAds.getCategory());
        holder.timeFrom.setText(serviceAds.getOpeningTime());
        holder.timeTo.setText(serviceAds.getClosingTime());
        holder.dayFrom.setText(serviceAds.getDaysFrom());
        holder.dayTo.setText(serviceAds.getDaysTo());
        holder.price.setText(serviceAds.getPrice());
    }

    @Override
    public int getItemCount() {
        return serviceAdsList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView category, timeFrom, timeTo, dayFrom, dayTo, price;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.tvCategories);
            timeFrom = itemView.findViewById(R.id.tvFromTime);
            timeTo = itemView.findViewById(R.id.tvToTime);
            dayFrom = itemView.findViewById(R.id.tvDayFrom);
            dayTo = itemView.findViewById(R.id.tvDayTo);
            price = itemView.findViewById(R.id.tvPrice);
        }
    }
}
