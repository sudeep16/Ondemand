package com.agile.ondemand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.NotificationResponseAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.Notification;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends Fragment {

    private RecyclerView notificationRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        notificationRecycler = view.findViewById(R.id.notificationRecycler);
        getNotify();
        return view;

    }
/**user's notification*/
    private void getNotify() {
        StrictModeClass.StrictMode();
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<List<Notification>> notificationCall = usersApi.getNotification(Url.token);

        notificationCall.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Notification> notifications = response.body();
                NotificationResponseAdapter notificationResponseAdapter = new NotificationResponseAdapter(getActivity(), notifications);
                notificationRecycler.setAdapter(notificationResponseAdapter);
                notificationRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {

            }
        });
    }
}
