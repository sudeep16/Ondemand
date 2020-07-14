package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button login, btnRegister;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        actionButtons();
    }

    private void actionButtons() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etUsername.getText().toString())) {
                    etUsername.setError("Input Username");
                    return;
                }
                if (TextUtils.isEmpty(etPassword.getText().toString())) {
                    etPassword.setError("Input Password");
                    return;
                }
                login();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initialize() {
        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);
        btnRegister = findViewById(R.id.btnRegister);
        login = findViewById(R.id.btnLogin);
        checkbox = findViewById(R.id.checkBox);
    }

    private void login() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        LoginBLL loginBLL = new LoginBLL();
        StrictModeClass.StrictMode();

        if (loginBLL.checkUser(username, password)) {

            if (checkbox.isChecked()) {
                SaveIntoSharedPreference();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return;
            }
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        } else {
            etPassword.setError("Password is incorrect");
            etUsername.setError("Username is incorrect");
        }
    }

    private void SaveIntoSharedPreference() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", etUsername.getText().toString().trim());
        editor.putString("password", etPassword.getText().toString().trim());
        editor.commit();

        Toast.makeText(this, "password saved", Toast.LENGTH_LONG).show();
    }
}