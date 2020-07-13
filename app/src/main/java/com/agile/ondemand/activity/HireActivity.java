package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.agile.ondemand.R;

import java.util.Calendar;

public class HireActivity extends AppCompatActivity {

    private Spinner spinner1, spinnerDays;
    private TextView etLocation, tvHireTime;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        tvHireTime = findViewById(R.id.tvHireTime);
        etLocation = findViewById(R.id.etLocation);
        btnConfirm = findViewById(R.id.btnConfirm);

        spinner1 = findViewById(R.id.Spinner1);
        spinnerDays = findViewById(R.id.SpinnerDays);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.paymentMethod, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        ArrayAdapter<CharSequence> arrayDays = ArrayAdapter.createFromResource(this,R.array.days, android.R.layout.simple_spinner_item);
        arrayDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDays.setAdapter(arrayDays);

        tvHireTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        final int minute = c.get(Calendar.MINUTE);
        final int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
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
                        tvHireTime.setText(hourOfDay + ":" + minute + " " + amPm + " ");
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }
}
