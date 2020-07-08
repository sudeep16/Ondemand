package com.agile.ondemand.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.WindowManager;
import android.widget.Toast;

import com.agile.ondemand.R;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.strictmode.StrictModeClass;

public class SplashScreen extends AppCompatActivity {
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkUser()) {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }

    private Boolean checkUser() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("User", MODE_PRIVATE);
        username = sharedPreferences.getString("username", null);
        password = sharedPreferences.getString("password", null);

        if (username != null && password != null) {
            login();
            return true;
        } else {
            return false;
        }
    }

    private void login() {
        String usernameLogin = username;
        String passwordLogin = password;
        LoginBLL loginBLL = new LoginBLL();
        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(usernameLogin, passwordLogin)) {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Token expired", Toast.LENGTH_SHORT).show();
        }
    }
}