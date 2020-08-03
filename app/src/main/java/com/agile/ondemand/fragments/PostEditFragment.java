package com.agile.ondemand.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.agile.ondemand.R;

import java.util.Calendar;

public class PostEditFragment extends Fragment {

    private Spinner updateSpinner;
    private TextView updateTime1, updateTime2;
    private EditText etUpdateDaysFrom, etUpdateDaysTo, etUpdateDescription, etUpdatePrice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postedit, container, false);

        updateSpinner = view.findViewById(R.id.updateSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        updateSpinner.setAdapter(adapter);

        updateTime1 = view.findViewById(R.id.updateTime1);
        updateTime2 = view.findViewById(R.id.updateTime2);
        etUpdateDaysFrom = view.findViewById(R.id.etUpdateDaysFrom);
        etUpdateDaysTo = view.findViewById(R.id.etUpdateDaysTo);
        etUpdateDescription = view.findViewById(R.id.etUpdateDescription);
        etUpdatePrice = view.findViewById(R.id.etUpdatePrice);

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


        return view;
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
