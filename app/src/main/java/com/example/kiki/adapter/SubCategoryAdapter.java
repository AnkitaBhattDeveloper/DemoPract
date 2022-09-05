package com.example.kiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.SubCategoryModel;
import com.example.kiki.activity.MainActivity;
import com.example.kiki.databinding.SubCategoryLayoutBinding;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {
    SubCategoryLayoutBinding bind;
    ArrayList<SubCategoryModel> cList;
    Context context;
    String type;

    public SubCategoryAdapter(Context context, ArrayList<SubCategoryModel> cList, String type) {
        this.cList = cList;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    bind = SubCategoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
    return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.binding.subCatName.setText(cList.get(position).getName());
            Glide.with(context).load(cList.get(position).getImage_url()).into(holder.binding.subCatImage);
          holder.binding.subCatImage.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  context.startActivity(new Intent(context,MainActivity.class)
                          .putExtra("item", String.valueOf(holder.binding.subCatName)));

              }
          });

    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SubCategoryLayoutBinding binding;

        public ViewHolder(SubCategoryLayoutBinding b) {
            super(b.getRoot());
            binding = b;


        }
    }


}
