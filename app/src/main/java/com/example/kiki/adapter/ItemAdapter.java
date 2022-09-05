package com.example.kiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.ItemListModel;
import com.example.kiki.activity.ProductDetailActivity;
import com.example.kiki.databinding.ItemsLayoutBinding;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    ItemsLayoutBinding bind;
    ArrayList<ItemListModel> list;
    Context context;


    public ItemAdapter(Context context, ArrayList<ItemListModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bind = ItemsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.binding.itemsName.setText(list.get(position).getItem_name());
        holder.binding.itemsDesc.setText(list.get(position).getItem_description());
        holder.binding.itemsPrice.setText("123");
        Glide.with(context).load(list.get(position).getItem_image()).into(bind.itemsImage);

        holder.binding.itemsImage.setOnClickListener(view -> context.startActivity(new Intent(context, ProductDetailActivity.class)
                .putExtra("product_image",list.get(position).getItem_image())));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemsLayoutBinding binding;

        public ViewHolder(ItemsLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }


}
