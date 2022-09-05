package com.example.kiki.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiki.data.TotalCartPrice;
import com.example.kiki.databinding.TotalCartItemPriceLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class TotalCartItemPriceAdapter extends RecyclerView.Adapter<TotalCartItemPriceAdapter.ViewHolder> {

    int c = 0;
    int sum = 0;
    int d =0;
    public TotalCartItemPriceLayoutBinding bind;
    List<TotalCartPrice> totalItemList = new ArrayList<>();
    Context context;

    public TotalCartItemPriceAdapter(Context context, List<TotalCartPrice> totalItemList) {
        this.context = context;
        this.totalItemList = totalItemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        bind = TotalCartItemPriceLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.productName.setText(totalItemList.get(position).getProductName());
        holder.binding.productPrice.setText(totalItemList.get(position).getProductPrice() + "");
        Log.e("TAG", "onBindViewHolder: position " + position);


        String b = String.valueOf(holder.binding.productPrice.getText());

       int  c = Integer.parseInt(b);
         d = d + c;


        Log.e("TAG", "onBindViewHolder: sum " + b);
        Log.e("TAG", "onBindViewHolder: c " + c);
        Log.e("TAG", "onBindViewHolder: d " + d + " c "+c);


    }

    @Override
    public int getItemCount() {
        return totalItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TotalCartItemPriceLayoutBinding binding;

        public ViewHolder(TotalCartItemPriceLayoutBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}
