package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void onBindViewHolder(@NonNull PendingJobHolder holder, final int position) {

        final PendingJob pendingJob = pendingJobList.get(position);
        holder.Customer.setText(pendingJob.getHiredBy().getUsername());
        holder.location.setText(pendingJob.getLocation());
        holder.day.setText(pendingJob.getDay());
        holder.time.setText(pendingJob.getTime());
        holder.paymentMethod.setText(pendingJob.getPaymentMethod());
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersApi usersApi = Url.getInstance().create(UsersApi.class);
                Call<Void> pendingVoidCall = usersApi.pendingJobApproval(Url.token, pendingJob.getHiredBy().getUsername(), true);

                pendingVoidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(context, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(context, "Accepted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        holder.btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UsersApi usersApi = Url.getInstance().create(UsersApi.class);
                Call<Void> pendingVoidCall = usersApi.pendingJobApproval(Url.token, pendingJob.getHiredBy().getUsername(), false);

                pendingVoidCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(context, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StrictModeClass.StrictMode();
                        try {

                            UsersApi  usersApi1 = Url.getInstance().create(UsersApi.class);
                            Call<Void> deletehiredlist = usersApi1.deleteHiredList(Url.token, pendingJob.get_id());

                            deletehiredlist.enqueue(new Callback<Void>() {
                                @Override
                                public void onResponse(Call<Void> call, Response<Void> response) {
                                    if (!response.isSuccessful()){
                                        Toast.makeText(context, "Code "+response.code(), Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                    pendingJobList.remove(position);
                                    notifyDataSetChanged();
                                    Toast.makeText(context, "Declined and removed", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<Void> call, Throwable t) {

                                }
                            });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }



                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(context, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendingJobList.size();
    }

    public class PendingJobHolder extends RecyclerView.ViewHolder {

        private TextView Customer, location, day, time, paymentMethod;
        private Button btnAccept, btnDecline;

        public PendingJobHolder(@NonNull View itemView) {
            super(itemView);
            Customer = itemView.findViewById(R.id.tvCustomerUsername);
            location = itemView.findViewById(R.id.tvCustomerLocation);
            day = itemView.findViewById(R.id.tvChosenDate);
            time = itemView.findViewById(R.id.tvChosenTime);
            paymentMethod = itemView.findViewById(R.id.tvChosenPayment);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            btnDecline = itemView.findViewById(R.id.btnDecline);
        }
    }
}
