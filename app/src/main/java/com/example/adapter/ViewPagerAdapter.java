package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.kiki.R;
import com.example.kiki.databinding.WelcomeLayoutBinding;

import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    int[] images;
    LayoutInflater layoutInflater;
    View itemview;
   // WelcomeLayoutBinding binding;

    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
         itemview = layoutInflater.inflate(R.layout.welcome_layout, container, false);
        ImageView welcome_image = (ImageView) itemview.findViewById(R.id.welcome_image);
        welcome_image.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(itemview);
        return itemview;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }


}
