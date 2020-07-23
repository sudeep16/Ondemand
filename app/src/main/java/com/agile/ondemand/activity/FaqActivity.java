package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.agile.ondemand.R;

public class FaqActivity extends AppCompatActivity {

    private ViewGroup tContainer;
    private TextView qtn1, answer1;
    private TextView qtn2, answer2;
    private TextView qtn3, answer3;
    private Toolbar toolbar;
    private Button backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        toolbar = findViewById(R.id.FaqToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        tContainer = findViewById(R.id.transitionContainer);
        qtn1 = findViewById(R.id.qtn1);
        qtn2 = findViewById(R.id.qtn2);
        qtn3 = findViewById(R.id.qtn3);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        backarrow = findViewById(R.id.btnBackArrow);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        qtn1.setText("What is On Demand Service ?");
        answer1.setText("This is the platform where Service providers can earn more with their skills by posting their service online. Customers acquire their service helping them to ease their lifestyle whereas service provider will earn some cash selling their service.");
        qtn2.setText("How can service provider earn cash ?");
        answer2.setText("The appication has set a choice for payment which varies from paying in cash or through their credit card.");
        qtn3.setText("How can customers know their request has been approved by service provider ?");
        answer3.setText("After a customer request for a service, the service provider is provided with choice to accept or decline the customers' request in his pending jobs list. Whatever the choice has been chosen by the service provider, the customer is notified about it in their notification panel.");


        qtn1.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                answer1.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });
        qtn2.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                answer2.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });
        qtn3.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {

                TransitionManager.beginDelayedTransition(tContainer);
                visible = !visible;
                answer3.setVisibility(visible ? View.VISIBLE : View.GONE);

            }
        });
    }
}