package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends AppCompatActivity {

    private RatingBar rateBar;
    private TextView tvValue;
    private EditText etFeedback;
    private Button btnFeedback;
    private float ratingValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initialize();
        actionButtons();
    }


    private void actionButtons() {
        //Setting OnClickListener in Submit Button
        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(FeedbackActivity.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    feedback();
                    etFeedback.setText("");
                    rateBar.setRating(0);
                    Toast.makeText(FeedbackActivity.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Showing value when Rate bar is clicked
        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvValue.setText("Value : " + rating);
                ratingValue = rating;
            }
        });
    }

    private void feedback() {
        String comment = etFeedback.getText().toString();
        String rating = Float.toString(ratingValue);

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> feedbackCall = usersApi.addFeedback(Url.token, rating, comment);

        feedbackCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(FeedbackActivity.this, "Code " + response.body(),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(FeedbackActivity.this, "Error " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initialize() {
        rateBar = findViewById(R.id.ratingBar);
        tvValue = findViewById(R.id.value);
        etFeedback = findViewById(R.id.etFeedback);
        btnFeedback = findViewById(R.id.btnFeedback);
    }
}