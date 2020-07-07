package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.bll.SignUpBLL;
import com.agile.ondemand.strictmode.StrictModeClass;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etAddress, etUsername, etEmail, etPhone, gender, etPassword, etConfirmPassword;
    private RadioButton male, female;
    private Button btnsignup, btnlogin;
    private RadioGroup radioGroup;
    private String firstName, lastName, address, username, email, phone, password, cPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddress);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnsignup = findViewById(R.id.btnRegister);
        btnlogin = findViewById(R.id.btnLoginA);

        radioGroup = findViewById(R.id.radioGroup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    signUp();
                }
            }
        });
    }

    private void signUp() {
        firstName = etFirstName.getText().toString().trim();
        lastName = etLastName.getText().toString().trim();
        address = etAddress.getText().toString().trim();
        username = etUsername.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        cPassword = etConfirmPassword.getText().toString().trim();

        int selectGender = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectGender);
        String gender = radioButton.getText().toString().trim();

        SignUpBLL signUpBLL = new SignUpBLL();
        StrictModeClass.StrictMode();

        if (signUpBLL.signupUser(firstName, lastName, address, username, email, phone, gender, password)) {

        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        boolean status = true;

        if (TextUtils.isEmpty(etFirstName.getText().toString().trim())) {
            etFirstName.setError("Type your First Name");
            return false;
        } else if (TextUtils.isEmpty(etLastName.getText().toString().trim())) {
            etLastName.setError("Type your Last Name");
            return false;
        } else if (TextUtils.isEmpty(etAddress.getText().toString().trim())) {
            etAddress.setError("Type your Address");
            return false;
        } else if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
            etUsername.setError("Type your Username");
            return false;
        } else if (etUsername.getText().toString().trim().length() < 6) {
            etUsername.setError("Minimum 6 character");
            status = false;
        } else if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            etEmail.setError("Type your Email Address");
            return false;
        } else if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            etPassword.setError("Phone number required");
            return false;
        } else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
            etPassword.setError("please type your password");
            return false;
        } else if (TextUtils.isEmpty(etConfirmPassword.getText().toString().trim())) {
            etConfirmPassword.setError("please type your password");
            return false;
        } else if (!etPassword.equals(etConfirmPassword)) {
            etConfirmPassword.setError("password didn't matched");
        }
        return status;
    }
}