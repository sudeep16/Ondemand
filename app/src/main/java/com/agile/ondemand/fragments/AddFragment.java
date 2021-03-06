package com.agile.ondemand.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.agile.ondemand.bll.CategoryBLL;
import com.agile.ondemand.strictmode.StrictModeClass;
import com.agile.ondemand.url.Url;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment {

    private Spinner spinner;
    private EditText etDescription, etdayFrom, etdayTo, etPrice;
    private TextView tvOpeningTime, tvClosingTime;
    private Button btnPost;
    private String category, description, daysFrom, daysTo, price, openingTime, closingTime;

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
        etDescription = root.findViewById(R.id.etDescription);
        etdayFrom = root.findViewById(R.id.etDaysFrom);
        etdayTo = root.findViewById(R.id.etDaysTo);
        etPrice = root.findViewById(R.id.etPrice);
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
                if (Validation()){
                    serviceAds();
                }
            }
        });
        return root;
    }

    /**timer picker dialogue*/
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

    //Add serviceAds
    private void serviceAds() {
        CategoryBLL categoryBLL = new CategoryBLL();
        StrictModeClass.StrictMode();
        category = spinner.getSelectedItem().toString();
        description = etDescription.getText().toString();
        openingTime = tvOpeningTime.getText().toString();
        closingTime = tvClosingTime.getText().toString();
        daysFrom = etdayFrom.getText().toString();
        daysTo = etdayTo.getText().toString();
        price = etPrice.getText().toString();

        if (categoryBLL.addCategory(Url.token, category, description, openingTime, closingTime,
                daysFrom, daysTo, price)) {
            Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean Validation(){
        boolean status =  true;

        if (spinner.getSelectedItem().toString().trim().equals("select category")){
            Toast.makeText(getActivity(), "Chose a category", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(etDescription.getText().toString().trim())){
            etDescription.setError("Type a description");
        }else if (TextUtils.isEmpty(tvOpeningTime.getText().toString())){
            Toast.makeText(getActivity(), "Select a time", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(tvClosingTime.getText().toString())){
            Toast.makeText(getActivity(), "Select a time", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(etdayFrom.getText().toString())){
            etdayFrom.setError("Type available days from");
        }else if (TextUtils.isEmpty(etdayTo.getText().toString())){
            etdayTo.setError("Type available days from");
        }else if (TextUtils.isEmpty(etPrice.getText().toString())){
            etPrice.setError("Input an amount");
        }
        return status;

    }
}
