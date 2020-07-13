package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agile.ondemand.R;

public class FeedbackActivity extends AppCompatActivity {

    RatingBar rateBar;
    TextView value;
    EditText feedback;
    Button feedbackSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        //Retriving assigned ID from layout to respected field
        rateBar = findViewById(R.id.ratingBar);
        value = findViewById(R.id.value);
        feedback = findViewById(R.id.feedbackComment);
        feedbackSubmit = findViewById(R.id.submitFeeds);

        //Setting OnClickListener in Submit Button
        feedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (feedback.getText().toString().isEmpty()) {
                    Toast.makeText(FeedbackActivity.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    feedback.setText("");
                    rateBar.setRating(0);
                    Toast.makeText(FeedbackActivity.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Showing value when Rate bar is clicked
        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Value : " + rating);

            }
        });


    }
}