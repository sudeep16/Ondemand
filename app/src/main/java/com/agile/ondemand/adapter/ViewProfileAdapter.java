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
import com.agile.ondemand.model.UserUpdate;

import java.util.List;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.getpost_recycler,parent,false);
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


    }

    @Override
    public int getItemCount() {
        return serviceAdsList.size();
    }

    public class ViewProfileHolder extends RecyclerView.ViewHolder {

        private TextView postUsername, postAddress, postContact, postCategory, postDesc, postTime1, posTime2, postDayFrom, postDayTo, postPrice;

        public ViewProfileHolder(@NonNull View itemView) {
            super(itemView);

            postUsername = itemView.findViewById(R.id.postUsername);
            postAddress = itemView.findViewById(R.id.postAddress);
            postContact = itemView.findViewById(R.id.postPhone);
            postCategory = itemView.findViewById(R.id.postCategory);
            postDesc = itemView.findViewById(R.id.postDesc);
            postTime1 = itemView.findViewById(R.id.PostTime1);
            posTime2 = itemView.findViewById(R.id.PostTime2);
            postDayFrom = itemView.findViewById(R.id.PostDayFrom);
            postDayTo = itemView.findViewById(R.id.PostDayTo);
            postPrice = itemView.findViewById(R.id.PostPrice);
        }
    }
}
