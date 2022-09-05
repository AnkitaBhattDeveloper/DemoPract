package com.example.kiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kiki.adapter.ProductViewPagerAdapter;
import com.example.kiki.fragments.ProductDescriptionFragment;
import com.example.kiki.fragments.ProductSpecificationFragment;
import com.example.kiki.fragments.ProfuctInformationFeagment;
import com.example.kiki.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity {
    ActivityProductDetailBinding binder;
    String item,product_image;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());
        context = this;

        item = getIntent().getStringExtra("item");
        product_image = getIntent().getStringExtra("product_image");
        Log.e("TAG", "onCreate: "+item);
        Glide.with(context).load(item).into(binder.itemImage);

        if (product_image != null)
        {
            Glide.with(context).load(product_image).into(binder.itemImage);
        }


        viewPager();
        floatingButton();

    }


    public void viewPager() {
        ProductViewPagerAdapter viewPagerAdapter = new ProductViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new ProductDescriptionFragment(), "Description");
        viewPagerAdapter.add(new ProductSpecificationFragment(), "Specification");
        viewPagerAdapter.add(new ProfuctInformationFeagment(), "More Information");
        binder.viewPager.setAdapter(viewPagerAdapter);
        binder.tablayout.setupWithViewPager(binder.viewPager);

    }

    public void floatingButton() {
        binder.floatingButton.setBackgroundTintMode(null);
        binder.floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailActivity.this, "item added to cart", Toast.LENGTH_SHORT).show();
            

            }
        });
    }

}