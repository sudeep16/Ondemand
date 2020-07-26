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
import com.agile.ondemand.model.WishList;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserSearchHolder> {

    Context context;
    List<UserUpdate> userUpdateList;

    public UsersAdapter(Context context, List<UserUpdate> userUpdateList) {
        this.context = context;
        this.userUpdateList = userUpdateList;
    }

    @NonNull
    @Override
    public UserSearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usersprofile, parent, false);
        return new UserSearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserSearchHolder holder, int position) {
        final UserUpdate userUpdate = userUpdateList.get(position);




    }

    @Override
    public int getItemCount() {
        return userUpdateList.size();
    }

    public class UserSearchHolder extends RecyclerView.ViewHolder {

        private TextView Username;
//        private Button btnRemove;

        public UserSearchHolder(@NonNull View itemView) {
            super(itemView);

            Username = itemView.findViewById(R.id.tvFUsername);
//            btnRemove = itemView.findViewById(R.id.btnRemove);

        }
    }
}
