package com.agile.ondemand.acitivty;

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
                if (validate()) {
                    signUp();
                }
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

        SignUpBLL signUpBLL = new SignUpBLL();
        StrictModeClass.StrictMode();

        if (signUpBLL.signupUser(firstname, lastname, Address, Username, Email, Phone, gender, passwordd)) {

        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        boolean status = true;

        if (TextUtils.isEmpty(firstName.getText().toString().trim())) {
            firstName.setError("Type your First Name");
            return false;
        } else if (TextUtils.isEmpty(lastName.getText().toString().trim())) {
            lastName.setError("Type your Last Name");
            return false;
        } else if (TextUtils.isEmpty(address.getText().toString().trim())) {
            address.setError("Type your Address");
            return false;
        } else if (TextUtils.isEmpty(username.getText().toString().trim())) {
            username.setError("Type your Address");
            return false;
        } else if (username.getText().toString().trim().length() < 6) {
            username.setError("Minimum 6 character");
            status = false;
        } else if (TextUtils.isEmpty(email.getText().toString().trim())) {
            email.setError("Type your Email Address");
            return false;
        } else if (TextUtils.isEmpty(phone.getText().toString().trim())) {
            phone.setError("Phone number required");
            return false;
        } else if (TextUtils.isEmpty(password.getText().toString().trim())) {
            password.setError("please type your password");
            return false;
        }else if (TextUtils.isEmpty(confirmPassword.getText().toString().trim())) {
            confirmPassword.setError("please type your password");
            return false;
        }else if(!password.equals(confirmPassword)){
            confirmPassword.setError("password didn't matched");
            return false;
        }
        return status;
    }
}