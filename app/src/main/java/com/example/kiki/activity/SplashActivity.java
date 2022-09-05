package com.example.kiki.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kiki.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
ActivitySplashBinding binding;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, WelcomeActivity.class));
                finish();
            }
        },1500);
    }
}