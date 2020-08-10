package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.url.Url;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HireActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private NotificationManagerCompat notificationManagerCompat;
    int counter = 1;

    private Spinner spinner1;
    private TextView etLocation, tvHireTime, tvDatePicker;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire);

        tvHireTime = findViewById(R.id.tvHireTime);
        etLocation = findViewById(R.id.etLocation);
        btnConfirm = findViewById(R.id.btnConfirm);
        tvDatePicker = findViewById(R.id.tvDatePicker);

        spinner1 = findViewById(R.id.Spinner1);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.paymentMethod, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        tvHireTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation()){
                    Hire();
                }

            }
        });

        tvDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new com.agile.ondemand.datepicker.DatePicker();
                dialogFragment.show(getSupportFragmentManager(), "date picker");
            }
        });

    }

    /**timer picker dialogue*/
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

    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.person_24)
                .setContentTitle("Notification")
                .setContentText("Booking has been placed")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter, notification);
        counter++;

    }

    //Hire service by providing some data which includes payment method, date, time and location
    private void Hire() {
        String paymentM = spinner1.getSelectedItem().toString().trim();
        String datepicker = tvDatePicker.getText().toString().trim();
//        String daysM = spinnerDays.getSelectedItem().toString().trim();
        String timeM = tvHireTime.getText().toString().trim();
        String locations = etLocation.getText().toString().trim();

        String username = getIntent().getExtras().getString("username");

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> hirePost = usersApi.Hire(Url.token, paymentM, datepicker, timeM, locations, username);

        hirePost.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(HireActivity.this, "Code " + response.body(),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                finish();
                DisplayNotification();
                Intent intent = new Intent(HireActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(HireActivity.this, "Error " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.tvDatePicker);
        textView.setText(currentDate);
    }

    boolean Validation(){
        boolean status = true;

        if (spinner1.getSelectedItem().toString().trim().equals("Choose payment method")){
            Toast.makeText(this, "chose a payment method", Toast.LENGTH_SHORT).show();
        }
       else if (TextUtils.isEmpty(etLocation.getText().toString().trim())){
            etLocation.setError("Please type your location");
        }
       return status;
    }
}
