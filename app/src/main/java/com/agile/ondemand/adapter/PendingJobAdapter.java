package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.model.PendingJob;

import java.util.List;

public class PendingJobAdapter extends RecyclerView.Adapter<PendingJobAdapter.PendingJobHolder> {

    Context context;
    List<PendingJob> pendingJobList;

    public PendingJobAdapter(Context context, List<PendingJob> pendingJobList) {
        this.context = context;
        this.pendingJobList = pendingJobList;
    }

    @NonNull
    @Override
    public PendingJobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pendingjob, parent, false);
        return new PendingJobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingJobHolder holder, int position) {

        final PendingJob pendingJob = pendingJobList.get(position);
        holder.Customer.setText(pendingJob.getHiredBy().getUsername());
        holder.location.setText(pendingJob.getLocation());
        holder.day.setText(pendingJob.getDay());
        holder.time.setText(pendingJob.getTime());
        holder.paymentMethod.setText(pendingJob.getPaymentMethod());

    }

    @Override
    public int getItemCount() {
        return pendingJobList.size();
    }

    public class PendingJobHolder extends RecyclerView.ViewHolder {

        private TextView Customer, location, day, time, paymentMethod;

        public PendingJobHolder(@NonNull View itemView) {
            super(itemView);
            Customer = itemView.findViewById(R.id.tvCustomerUsername);
            location = itemView.findViewById(R.id.tvCustomerLocation);
            day = itemView.findViewById(R.id.tvChosenDate);
            time = itemView.findViewById(R.id.tvChosenTime);
            paymentMethod = itemView.findViewById(R.id.tvChosenPayment);

        }
    }
}
