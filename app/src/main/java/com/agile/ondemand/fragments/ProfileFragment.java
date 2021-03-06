package com.agile.ondemand.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    private TextView etPId, tvPendingJob, tvReward, tvPFirstName1;

    private Button btnLogout, btnUpdate, btnPDelete, btnPjob, btnMyPost, btnmyFeedback;
    private ImageView profile_image_gp;

    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        etPFirstName = view.findViewById(R.id.etPFirstName);
        tvPFirstName1 = view.findViewById(R.id.etPFirstName1);
        etPLastName = view.findViewById(R.id.etPLastName);
        etPAddresss = view.findViewById(R.id.etPAddresss);
        etPUsername = view.findViewById(R.id.etPUsername);
        etPEmail = view.findViewById(R.id.etPEmail);
        etPhone = view.findViewById(R.id.etPPhone);
        etPId = view.findViewById(R.id.etPId);

        refreshLayout = view.findViewById(R.id.Refresh);

        tvPendingJob = view.findViewById(R.id.tvPendingJob);
        tvReward = view.findViewById(R.id.tvReward);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnUpdate = view.findViewById(R.id.btnPUpdate);
        btnPDelete = view.findViewById(R.id.btnPDelete);
        btnPjob = view.findViewById(R.id.btnPjob);
        btnMyPost = view.findViewById(R.id.btnMyPost);
        btnmyFeedback = view.findViewById(R.id.btnmyFeedback);

        profile_image_gp = view.findViewById(R.id.profile_image_gp);
        pendingJobCount();
        feedbacksCount();

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Logout of App ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logOut();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        loadUser();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
                loadUser();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUpdate();
            }
        });
        btnPDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Delete account permanently ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                userDelete();
                                logOut();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        btnPjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PendingjobFragment()).addToBackStack(null).commit();
            }
        });

        btnMyPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyPostFragment()).addToBackStack(null).commit();
            }
        });

        btnmyFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedbackFragment()).addToBackStack(null).commit();
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

    /**
     * get user's detail
     */
    private void loadUser() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<UserUpdate> userUpdateCall = usersApi.getUserDetail(Url.token);

        userUpdateCall.enqueue(new Callback<UserUpdate>() {
            @Override
            public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StrictModeClass.StrictMode();
                try {
                    String id = response.body().get_id();
                    String firstName = response.body().getFirstName();
                    String LastName = response.body().getLastName();
                    String address = response.body().getAddress();
                    String username = response.body().getUsername();
                    String email = response.body().getEmail();
                    String phone = response.body().getPhone();
                    etPId.setText(id);
                    etPFirstName.setText(firstName);
                    tvPFirstName1.setText(firstName);
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
            public void onFailure(Call<UserUpdate> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * update user
     */
    private void userUpdate() {
        String pFirstName = etPFirstName.getText().toString().trim();
        String pLastName = etPLastName.getText().toString().trim();
        String pAddress = etPAddresss.getText().toString().trim();
        String pUsername = etPUsername.getText().toString().trim();
        String pEmail = etPEmail.getText().toString().trim();
        String pPhone = etPhone.getText().toString().trim();
        String pId = etPId.getText().toString().trim();
        //Push check

        UserUpdate userUpdate = new UserUpdate(pId, pFirstName, pLastName, pAddress, pUsername, pEmail, pPhone);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<Void> updateUserCall = usersApi.updateUserData(Url.token, pId, userUpdate);
        updateUserCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "Profile updated!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //delete account
    private void userDelete() {
        String id = etPId.getText().toString().trim();

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> userDeleteCall = usersApi.deleteUserAccount(Url.token, id);

        userDeleteCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pendingJobCount() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Integer> pendingJobCountCall = usersApi.getPendingJobCount(Url.token);
        pendingJobCountCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int count = response.body();
                String countString = Integer.toString(count);
                tvPendingJob.setText(countString);
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
    }

    private void feedbacksCount() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Integer> feedbacksCountCall = usersApi.getTotalFeedbacksCount(Url.token);
        feedbacksCountCall.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                int count = response.body();
                String countString = Integer.toString(count);
                tvReward.setText(countString);
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
    }

}
