package com.agile.ondemand.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.model.UserUpdate;

import java.util.List;

public class ViewProfileAdapter extends RecyclerView.Adapter<ViewProfileAdapter.ViewProfileHolder> {

    Context context;
    List<UserUpdate> userUpdateList;

    public ViewProfileAdapter(Context context, List<UserUpdate> userUpdateList) {
        this.context = context;
        this.userUpdateList = userUpdateList;
    }

    @NonNull
    @Override
    public ViewProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_viewprofile,parent,false);
        return new ViewProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewProfileHolder holder, int position) {

        final UserUpdate userUpdate = userUpdateList.get(position);
        holder.viewFirstName.setText(userUpdate.getFirstName());
        holder.viewLastName.setText(userUpdate.getLastName());
        holder.viewUsername.setText(userUpdate.getUsername());
        holder.viewAddress.setText(userUpdate.getAddress());
        holder.viewEmail.setText(userUpdate.getEmail());
        holder.viewContact.setText(userUpdate.getPhone());

    }

    @Override
    public int getItemCount() {
        return userUpdateList.size();
    }

    public class ViewProfileHolder extends RecyclerView.ViewHolder {

        private TextView viewFirstName, viewLastName, viewAddress, viewUsername, viewEmail, viewContact;

        public ViewProfileHolder(@NonNull View itemView) {
            super(itemView);

            viewFirstName = itemView.findViewById(R.id.viewFirstName);
            viewLastName = itemView.findViewById(R.id.viewLastName);
            viewAddress = itemView.findViewById(R.id.viewAddress);
            viewUsername = itemView.findViewById(R.id.viewUsername);
            viewEmail = itemView.findViewById(R.id.viewEmail);
            viewContact = itemView.findViewById(R.id.viewContact);
        }
    }
}
