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
import com.agile.ondemand.bll.Validation;
import com.agile.ondemand.strictmode.StrictModeClass;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etAddress, etUsername, etEmail, etPhone, gender, etPassword, etConfirmPassword;
    private RadioButton male, female;
    private Button btnsignup, btnlogin;
    private RadioGroup radioGroup;
    private String firstName, lastName, address, username, email, phone, password, cPassword;
    private Validation validation = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
        actionButtons();
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

    //Validations
    private boolean validateEmail(){
        email = etEmail.getText().toString().trim();
        if (validation.validateEmail(email).equals("required")){
            etEmail.setError("Required");
            return false;
        } else if (validation.validateEmail(email).equals("invalid")){
            etEmail.setError("Please enter valid email");
            return false;
        } else {
            etEmail.setError(null);
            return true;
        }
    }

    private boolean validateUsername(){
        username = etUsername.getText().toString().trim();
        if (validation.validateUsername(username).equals("required")){
            etUsername.setError("Required");
            return false;
        } else if (validation.validateUsername(username).equals("usernameTooLong")){
            etUsername.setError("Username too long");
            return false;
        } else if (validation.validateUsername(username).equals("usernameTooShort")){
            etUsername.setError("Username too short");
            return false;
        } else {
            etUsername.setError(null);
            return true;
        }
    }

    private boolean validateFirstName(){
        firstName = etFirstName.getText().toString().trim();
        if (!validation.validateFirstName(firstName)){
            etFirstName.setError("Required");
            return false;
        } else {
            etFirstName.setError(null);
            return true;
        }
    }

    private boolean validateLastName(){
        lastName = etLastName.getText().toString().trim();
        if (!validation.validateLastName(lastName)){
            etLastName.setError("Required");
            return false;
        } else {
            etLastName.setError(null);
            return true;
        }
    }

    private boolean validateAddress(){
        address = etAddress.getText().toString().trim();
        if (!validation.validateAddress(address)){
            etAddress.setError("Required");
            return false;
        } else {
            etAddress.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        phone = etPhone.getText().toString().trim();
        if (validation.validatePhone(phone).equals("required")) {
            etPhone.setError("Required");
            return false;
        } else if (validation.validatePhone(phone).equals("invalidPhone")) {
            etPhone.setError("Please enter a valid phone number");
            return false;
        } else {
            etPhone.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        password = etPassword.getText().toString().trim();
        if (validation.validatePassword(password).equals("required")) {
            etPassword.setError("Required");
            return false;
        } else if (validation.validatePassword(password).equals("weakPassword")) {
            etPassword.setError("Password is too weak");
            return false;
        } else {
            etPassword.setError(null);
            return true;
        }
    }

    private boolean validateConfirmPassword() {
        cPassword = etConfirmPassword.getText().toString().trim();
        if (validation.validateConfirmPassword(password, cPassword).equals("!Password")) {
            etConfirmPassword.setError("Password does not match");
            return false;
        } else if (validation.validateConfirmPassword(password, cPassword).equals("required")) {
            etConfirmPassword.setError("Required");
            return false;
        } else {
            etConfirmPassword.setError(null);
            return true;
        }
    }

    //Action Buttons
    private void actionButtons(){
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
                if (!validateFirstName() | !validateLastName() | !validateAddress() | !validateUsername()
                | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword() | !validateConfirmPassword()){
                    return;
                }
                signUp();
            }
        });
    }

    //Binding
    private void initialize(){
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
    }
}