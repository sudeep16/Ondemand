package com.agile.ondemand.acitivty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    private EditText firstName, lastName, address, username, email, phone, gender, password, confirmPassword;
    private RadioButton male, female;
    private Button btnsignup;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        address = findViewById(R.id.etAddress);
        username = findViewById(R.id.etUsername);
        email = findViewById(R.id.etEmail);
        phone = findViewById(R.id.etPhone);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        password = findViewById(R.id.etPassword);
        confirmPassword = findViewById(R.id.etConfirmPassword);
        btnsignup = findViewById(R.id.btnRegister);

        radioGroup = findViewById(R.id.radioGroup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String firstname = firstName.getText().toString().trim();
        String lastname = lastName.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String Username = username.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Phone = phone.getText().toString().trim();

        int selectGender = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectGender);
        String gender = radioButton.getText().toString().trim();

        String passwordd = password.getText().toString().trim();
        String Cpassword = confirmPassword.getText().toString().trim();

        SignUpBLL signUpBLL =new SignUpBLL();
        StrictModeClass.StrictMode();

        if (signUpBLL.signupUser(firstname, lastname, Address, Username, Email, Phone, gender, passwordd)){

        }else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}