package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);

        login = findViewById(R.id.btnLogin);

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
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        LoginBLL loginBLL = new LoginBLL();
        StrictModeClass.StrictMode();

        if (loginBLL.checkUser(username, password)){
            Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();
        }

    }
}