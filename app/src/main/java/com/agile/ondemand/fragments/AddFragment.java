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
import com.agile.ondemand.url.Url;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment {

    private Spinner spinner;
    private EditText description, etdayFrom, etdayTo, price;
    private TextView tvOpeningTime, tvClosingTime;
    private Button btnPost;

    int t1Hour, t1Minute, t2Hour, t2Minute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        spinner = root.findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        tvOpeningTime = root.findViewById(R.id.time1);
        tvClosingTime = root.findViewById(R.id.time2);

        description = root.findViewById(R.id.etDescription);
        etdayFrom = root.findViewById(R.id.etDaysFrom);
        etdayTo = root.findViewById(R.id.etDaysTo);
        price = root.findViewById(R.id.etPrice);
        btnPost = root.findViewById(R.id.btnPost);

        tvOpeningTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

        tvClosingTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime1();
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceAds();
            }
        });

        return root;
    }

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
                        tvOpeningTime.setText(hourOfDay + ":" + minute + " " + amPm + " ");
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
                        tvClosingTime.setText(hourOfDay + ":" + minute + " " + amPm);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    private void serviceAds() {
        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        String category = spinner.getSelectedItem().toString();

        Call<Void> voidCall = usersApi.serviceAds(
                Url.token,
                category,
                description.getText().toString(),
                tvOpeningTime.getText().toString(),
                tvClosingTime.getText().toString(),
                etdayFrom.getText().toString(),
                etdayTo.getText().toString(),
                price.getText().toString()
        );

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "posted", Toast.LENGTH_SHORT).show();
                    return;
                }else
                {
                    Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
