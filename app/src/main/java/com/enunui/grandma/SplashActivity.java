package com.enunui.grandma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

 private static int SPLASH_TIME_OUT=2600;
 ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
        System.out.println("starting splash screen");
        System.out.println("--------------------note this");
        boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
              // intent.putExtra();

                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }

}

