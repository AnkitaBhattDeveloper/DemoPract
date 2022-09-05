package com.example.kiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.PostItemModel;
import com.example.kiki.activity.ProductDetailActivity;
import com.example.kiki.databinding.HomePostLayoutBinding;

import java.util.ArrayList;

public class HomePostAdapter extends RecyclerView.Adapter<HomePostAdapter.ViewHolder> {
    HomePostLayoutBinding binding;
    Context context;
    ArrayList<PostItemModel> posts;

    public HomePostAdapter(Context context, ArrayList<PostItemModel> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomePostLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(posts.get(position).getItemUrl()).into(holder.binding.iPost);
        holder.binding.iPost.setOnClickListener(view -> {
            context.startActivity(new Intent(context, ProductDetailActivity.class)
                    .putExtra("item",posts.get(position).getItemUrl()));
        });


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        HomePostLayoutBinding binding;

        public ViewHolder(HomePostLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

}
