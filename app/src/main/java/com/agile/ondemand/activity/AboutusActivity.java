package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.agile.ondemand.R;

public class AboutusActivity extends AppCompatActivity {

    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        about = findViewById(R.id.about);
        about.setText("This is the platform where Service providers can earn more with their skills.Service Providers would be able to check Various types of services: Providers can add various types of services. Moreover, Service provider can update and delete any Services\n" +
                "Service Provider app provides options to choose your task as per their schedule, complete the task and get paid twice in a week with direct deposit to your account.\n" +
                "From the app Services, Providers are able to check all the Pending Jobs, Upcoming Jobs, Accepted jobs, declined jobs. Moreover They can check the profile and give feedback as well.\n" +
                "The app helps to earn more money at any time you want, fully active in time, the better you do, you are appreciated well, the income increases.");
    }
}