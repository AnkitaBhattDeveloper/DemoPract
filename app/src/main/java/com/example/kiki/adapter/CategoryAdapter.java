package com.example.kiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.SubCategoryModel;
import com.example.kiki.activity.MainActivity;
import com.example.kiki.databinding.CategoryLayoutBinding;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    CategoryLayoutBinding binding;
    Context context;
    List<SubCategoryModel> list = new ArrayList<>();

    public CategoryAdapter(Context context,List<SubCategoryModel>list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CategoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.name.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImage_url()).into(holder.binding.image);
        binding.image.setOnClickListener(view -> context.startActivity(new Intent(context, MainActivity.class)
                .putExtra("category_name",list.get(position).getName())));

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CategoryLayoutBinding binding;

        public ViewHolder(CategoryLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
