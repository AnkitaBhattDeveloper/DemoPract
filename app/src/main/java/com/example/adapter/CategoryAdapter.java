package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.R;
import com.example.kiki.databinding.CategoryLayoutBinding;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<String> cList;
    Context context;

    public CategoryAdapter(ArrayList<String> cList, Context context) {
        this.cList = cList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.categoryName.setText("Clothing");
        Glide.with(context).load("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.popsci.com%2Fuploads%2F2022%2F03%2F02%2Faviv-rachmadian-7F7kEHj72MQ-unsplash-scaled.jpg%3Fauto%3Dwebp&imgrefurl=https%3A%2F%2Fwww.popsci.com%2Fenvironment%2Fclothing-rental-sustainability%2F&tbnid=Kr2U9c8Xxc-1kM&vet=12ahUKEwiAsZf574v4AhWErmMGHRJ6COEQMygAegUIARDVAQ..i&docid=BayFjIm0r5CnBM&w=2560&h=1707&q=clothes&ved=2ahUKEwiAsZf574v4AhWErmMGHRJ6COEQMygAegUIARDVAQ").into(holder.binding.categoryImage);

    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CategoryLayoutBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CategoryLayoutBinding.bind(itemView);


        }
    }


}
