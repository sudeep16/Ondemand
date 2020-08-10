package com.agile.ondemand.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.model.Owner;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;
import com.google.gson.JsonSyntaxException;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostEditFragment extends Fragment {

    private TextView updateTime1, updateTime2, updateSpinner;
    private EditText etUpdateDaysFrom, etUpdateDaysTo, etUpdateDescription, etUpdatePrice;
    private Button btnUpdate;
    private String[] categoryValue = new String[]{"Plumber", "Electrician", "Laundry", "Painter",
            "Gardener", "Baby Sitter", "Handy Man", "Care Taker", "Catering", "House Keeping"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postedit, container, false);
        updateSpinner = view.findViewById(R.id.updateSpinner);
        updateTime1 = view.findViewById(R.id.updateTime1);
        updateTime2 = view.findViewById(R.id.updateTime2);
        etUpdateDaysFrom = view.findViewById(R.id.etUpdateDaysFrom);
        etUpdateDaysTo = view.findViewById(R.id.etUpdateDaysTo);
        etUpdateDescription = view.findViewById(R.id.etUpdateDescription);
        etUpdatePrice = view.findViewById(R.id.etUpdatePrice);
        btnUpdate = view.findViewById(R.id.btnUpdate);

        updateTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
        updateTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime1();
            }
        });
        viewSelectedData();
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateServiceAd();
            }
        });
        return view;
        //Push check
    }
/**user's service ads edit*/
    private void updateServiceAd() {
        String id = getArguments().getString("id");
        String category = updateSpinner.getText().toString().trim();
        String description = etUpdateDescription.getText().toString().trim();
        String openingTime = updateTime1.getText().toString().trim();
        String closingTime = updateTime2.getText().toString().trim();
        String daysFrom = etUpdateDaysFrom.getText().toString().trim();
        String daysTo = etUpdateDaysTo.getText().toString().trim();
        String price = etUpdatePrice.getText().toString().trim();

        ServiceAdsUpdate serviceAdsUpdate = new ServiceAdsUpdate(id, category, description,
                openingTime, closingTime, daysFrom, daysTo, price);
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);

        Call<Void> voidCall = usersApi.updateServiceAd(Url.token, id, serviceAdsUpdate);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
/**passing data to posteditfragment*/
    private void viewSelectedData() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        final String id = getArguments().getString("id");
        Call<ServiceAdsUpdate> serviceAdsCall = usersApi.fetchDataToUpdateFragment(Url.token, id);
        serviceAdsCall.enqueue(new Callback<ServiceAdsUpdate>() {
            @Override
            public void onResponse(Call<ServiceAdsUpdate> call, Response<ServiceAdsUpdate> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StrictModeClass.StrictMode();
                try {
                    String category = response.body().getCategory();
                    String description = response.body().getDescription();
                    String openingTime = response.body().getOpeningTime();
                    String closingTime = response.body().getClosingTime();
                    String daysFrom = response.body().getDaysFrom();
                    String daysTo = response.body().getDaysTo();
                    String price = response.body().getPrice();
                    updateSpinner.setText(category);
                    updateTime1.setText(openingTime);
                    updateTime2.setText(closingTime);
                    etUpdateDescription.setText(description);
                    etUpdateDaysFrom.setText(daysFrom);
                    etUpdateDaysTo.setText(daysTo);
                    etUpdatePrice.setText(price);
                } catch (IllegalStateException | JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ServiceAdsUpdate> call, Throwable t) {
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("Error " + t.getLocalizedMessage());
            }
        });
    }

    /**time picker dialogue*/
    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        final int minute = c.get(Calendar.MINUTE);
        final int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String amPm;
                        if (hourOfDay >= 12) {
                            hourOfDay -= 12;
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        updateTime1.setText(hourOfDay + ":" + minute + " " + amPm + " ");
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    private void loadTime1() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        final int minute = c.get(Calendar.MINUTE);
        final int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String amPm;
                        if (hourOfDay >= 12) {
                            hourOfDay -= 12;
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        updateTime2.setText(hourOfDay + ":" + minute + " " + amPm);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }
}
