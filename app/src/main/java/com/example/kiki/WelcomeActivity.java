package com.example.kiki;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.ViewPagerAdapter;
import com.example.kiki.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {
    ActivityWelcomeBinding binding;
    //ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        int[] images = {R.drawable.ecomdemo, R.drawable.ecomdemo, R.drawable.ecomdemo};
        viewPagerAdapter = new ViewPagerAdapter(this, images);
        binding.pager.setAdapter(viewPagerAdapter);

        binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,LoginActivity.class));
                finish();
            }
        });

    }
}