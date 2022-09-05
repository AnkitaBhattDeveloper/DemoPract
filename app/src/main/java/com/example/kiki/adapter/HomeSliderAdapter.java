package com.example.kiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.SliderModel;
import com.example.kiki.databinding.HomeSliderLayoutBinding;

import java.util.ArrayList;

public class HomeSliderAdapter extends RecyclerView.Adapter<HomeSliderAdapter.ViewHolder> {
    Context context;
    ArrayList<SliderModel> list;
    HomeSliderLayoutBinding binder;

    public HomeSliderAdapter(Context context,ArrayList<SliderModel> list)
    {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binder = HomeSliderLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getsliderImageUrl()).into(holder.binding.imageSlider);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        HomeSliderLayoutBinding binding;

        public ViewHolder(HomeSliderLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

}
