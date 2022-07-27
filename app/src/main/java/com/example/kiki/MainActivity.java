package com.example.kiki;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragments.CategoryFragment;
import com.example.kiki.databinding.ActivityMainBinding;
import com.example.fragments.AccountFragment;
import com.example.fragments.CartFragment;
import com.example.fragments.SubCategoryFragment;
import com.example.fragments.HomeFragment;
import com.example.fragments.NotificationFragment;


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


        Log.e("TAG", "onCreate: select category name"+category_name);
        if (category_name!= null)
        {
            replaceFragment(new SubCategoryFragment().newInstance(getIntent().getStringExtra("name"),category_name));
        }
        else
        {
            Log.e("TAG", "onCreate: select category");
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