package com.agile.ondemand.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.agile.ondemand.R;

import java.text.DateFormat;
import java.util.Calendar;

public class AddFragment extends Fragment {

    private Spinner spinner;

    TextView timer1, timer2;
    int t1Hour, t1Minute, t2Hour, t2Minute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        spinner = root.findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        timer1 = root.findViewById(R.id.time1);
        timer2 = root.findViewById(R.id.time2);

        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime1();
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
                        timer1.setText(hourOfDay+ ":"+ minute + " " + amPm + " ");
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
                        timer2.setText(hourOfDay+ ":"+ minute + " " + amPm);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }
}
