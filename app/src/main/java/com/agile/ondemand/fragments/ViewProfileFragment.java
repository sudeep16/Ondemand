package com.agile.ondemand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.ondemand.R;
import com.agile.ondemand.adapter.UsersAdapter;
import com.agile.ondemand.adapter.ViewProfileAdapter;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProfileFragment extends Fragment {
    private TextView viewFirstName, viewLastName, viewUsername, viewAddress, viewEmail, viewContact, viewId;
    private RecyclerView viewprofileRecycler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.getprofile_recycler, container, false);
        viewFirstName = view.findViewById(R.id.viewFirstName);
        viewLastName = view.findViewById(R.id.viewLastName);
        viewUsername = view.findViewById(R.id.viewUsername);
        viewAddress = view.findViewById(R.id.viewAddress);
        viewEmail = view.findViewById(R.id.viewEmail);
        viewContact = view.findViewById(R.id.viewContact);
        viewprofileRecycler = view.findViewById(R.id.viewprofileRecycler);
        viewUserProfile();
        return view;
    }

    private void viewUserProfile() {
        final UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        String username = getArguments().getString("username");
        Call<UserUpdate> userUpdateCall = usersApi.ViewUser(Url.token, username);
        userUpdateCall.enqueue(new Callback<UserUpdate>() {
            @Override
            public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StrictModeClass.StrictMode();
                try {
                    String id = response.body().get_id();
                    String firstName = response.body().getFirstName();
                    String lastName = response.body().getLastName();
                    String username = response.body().getUsername();
                    String address = response.body().getAddress();
                    String email = response.body().getEmail();
                    String contact = response.body().getPhone();
                    viewFirstName.setText(firstName);
                    viewLastName.setText(lastName);
                    viewUsername.setText(username);
                    viewAddress.setText(address);
                    viewEmail.setText(email);
                    viewContact.setText(contact);
                    StrictModeClass.StrictMode();
                    try {
                        UsersApi usersApi1 = Url.getInstance().create(UsersApi.class);
                        Call<List<ServiceAds>> viewProfilePost = usersApi1.getViewProfilePost(Url.token, id);
                        viewProfilePost.enqueue(new Callback<List<ServiceAds>>() {
                            @Override
                            public void onResponse(Call<List<ServiceAds>> call, Response<List<ServiceAds>> response) {
                                if (!response.isSuccessful()) {
                                    Toast.makeText(getActivity(), "code" + response.code(), Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                List<ServiceAds> serviceAds = response.body();
                                ViewProfileAdapter viewProfileAdapter = new ViewProfileAdapter(getActivity(), serviceAds);
                                viewprofileRecycler.setAdapter(viewProfileAdapter);
                                viewprofileRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                            }

                            @Override
                            public void onFailure(Call<List<ServiceAds>> call, Throwable t) {
                                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UserUpdate> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error " + t.getLocalizedMessage());
            }
        });
    }
}
