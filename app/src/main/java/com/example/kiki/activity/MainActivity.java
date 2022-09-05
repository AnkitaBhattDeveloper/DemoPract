package com.example.kiki.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kiki.R;
import com.example.kiki.fragments.AccountFragment;
import com.example.kiki.fragments.CartFragment;
import com.example.kiki.fragments.CategoryFragment;
import com.example.kiki.fragments.HomeFragment;
import com.example.kiki.fragments.ItemsFragment;
import com.example.kiki.fragments.NotificationFragment;
import com.example.kiki.fragments.SubCategoryFragment;
import com.example.kiki.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        replaceFragment(new HomeFragment());
        String category_name = getIntent().getStringExtra("category_name");
        String item_name = getIntent().getStringExtra("item");


        Log.e("TAG", "onCreate: select category name" + category_name);
        if (category_name != null) {
            replaceFragment(new SubCategoryFragment().newInstance(getIntent().getStringExtra("category_name"), category_name));
            binding.bottomNav.setVisibility(View.GONE);

        }
       /* if (name != null)
            replaceFragment(new SubCategoryFragment().newInstance(getIntent().getStringExtra("name"),name));*/

        else {
            Log.e("TAG", "onCreate: select category");
            binding.bottomNav.setVisibility(View.VISIBLE);
        }

        if (item_name != null) {
            replaceFragment(new ItemsFragment().newInstance(getIntent().getStringExtra("item"), item_name));
            binding.bottomNav.setVisibility(View.GONE);
        }
        else {
            Log.e("TAG", "onCreate: item is null");
            binding.bottomNav.setVisibility(View.VISIBLE);
        }


        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());

                    break;
                case R.id.category:
                    replaceFragment(new CategoryFragment());
                    break;
                case R.id.notification:
                    replaceFragment(new NotificationFragment());
                    break;
                case R.id.account:
                    replaceFragment(new AccountFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;
                default:
                    replaceFragment(new HomeFragment());
            }


            return true;
        });


    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment).commit();
    }


}