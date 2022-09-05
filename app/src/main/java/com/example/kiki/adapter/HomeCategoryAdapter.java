package com.example.kiki.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kiki.data.HomeCategoryModel;
import com.example.kiki.activity.MainActivity;
import com.example.kiki.databinding.HomeCategoriesLayoutBinding;

import java.util.ArrayList;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {
    ArrayList<HomeCategoryModel> arrayList = new ArrayList<>();

    Context context;
    HomeCategoriesLayoutBinding binding;
    //String layout;


    public HomeCategoryAdapter(Context context, ArrayList<HomeCategoryModel> list) {
        this.context = context;
        this.arrayList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomeCategoriesLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.binding.catName.setText(arrayList.get(position).getCat_name());
        Glide.with(context).load(arrayList.get(position).getCat_image()).into(holder.binding.catImage);
        holder.binding.catImage.setOnClickListener(view -> context.startActivity(new Intent(context, MainActivity.class)
                .putExtra("category_name",arrayList.get(position).getCat_name())));

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        HomeCategoriesLayoutBinding binding;
       /* TextView text;
        ImageView imageView;*/

        public ViewHolder(HomeCategoriesLayoutBinding b) {
            super(b.getRoot());
            binding = b;
            /*Log.e("TAG", "onCreateViewHolder: item View holder ");
            text = itemView.findViewById(R.id.cat_name);
            imageView = itemView.findViewById(R.id.cat_image);*/
        }

    }


}


