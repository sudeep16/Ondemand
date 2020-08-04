package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.model.Notification;

import java.util.List;

import retrofit2.Call;

public class NotificationResponseAdapter extends RecyclerView.Adapter<NotificationResponseAdapter.NotificationResponseViewHolder> {

    private boolean accept;

    Context context;
    List<Notification> notificationCall;

    public NotificationResponseAdapter(Context context, List<Notification> notificationCall) {
        this.context = context;
        this.notificationCall = notificationCall;
    }

    @NonNull
    @Override
    public NotificationResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_recycler, parent, false);
        return new NotificationResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationResponseViewHolder holder, int position) {
        final Notification notification = notificationCall.get(position);

        holder.ServiceProvider.setText(notification.getServiceID().getUsername());

        if (accept) {
            holder.message.setText("your service has been accepted");
            return;
        }
        holder.message.setText("your service has been declined");
    }

    @Override
    public int getItemCount() {
        return notificationCall.size();
    }

    public class NotificationResponseViewHolder extends RecyclerView.ViewHolder {

        private TextView ServiceProvider, message;

        public NotificationResponseViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            ServiceProvider = itemView.findViewById(R.id.serviceProvider);
        }
    }
}
