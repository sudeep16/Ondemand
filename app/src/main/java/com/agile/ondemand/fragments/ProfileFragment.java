package com.agile.ondemand.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.LoginActivity;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.User;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private EditText etPFirstName, etPLastName, etPAddresss, etPUsername, etPEmail, etPhone;

    private Button btnLogout, btnUpdate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        etPFirstName = view.findViewById(R.id.etPFirstName);
        etPLastName = view.findViewById(R.id.etPLastName);
        etPAddresss = view.findViewById(R.id.etPAddresss);
        etPUsername = view.findViewById(R.id.etPUsername);
        etPEmail = view.findViewById(R.id.etPEmail);
        etPhone = view.findViewById(R.id.etPPhone);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnUpdate = view.findViewById(R.id.btnPUpdate);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        loadUser();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUpdate();
            }
        });

        return view;
    }

    private void logOut() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        Intent intent = new Intent(getContext(), LoginActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(0);
    }

    /**get user*/
    private void loadUser() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<User> userCall = usersApi.getUserDetail(Url.token);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StrictModeClass.StrictMode();
                try {
                    String firstName = response.body().getFirstName();
                    String LastName = response.body().getLastName();
                    String address = response.body().getAddress();
                    String username = response.body().getUsername();
                    String email = response.body().getEmail();
                    String phone = response.body().getPhone();

                    etPFirstName.setText(firstName);
                    etPLastName.setText(LastName);
                    etPAddresss.setText(address);
                    etPUsername.setText(username);
                    etPEmail.setText(email);
                    etPhone.setText(phone);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    /**update user*/
    private void userUpdate() {
        String PFirstName = etPFirstName.getText().toString().trim();
        String PLastName = etPLastName.getText().toString().trim();
        String PAddress = etPAddresss.getText().toString().trim();
        String PUsername = etPUsername.getText().toString().trim();
        String PEmail = etPEmail.getText().toString().trim();
        String PPhone = etPhone.getText().toString().trim();

        UserUpdate userUpdate = new UserUpdate(PFirstName, PLastName, PAddress, PUsername, PEmail, PPhone);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

    }

}
