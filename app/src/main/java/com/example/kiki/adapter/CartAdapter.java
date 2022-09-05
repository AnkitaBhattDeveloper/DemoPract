package com.example.kiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiki.data.CartItemModel;
import com.example.kiki.databinding.CartLayoutBinding;
import com.example.kiki.util.TotalAmountInterface;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    CartLayoutBinding binding;
    Context context;
    ArrayList<CartItemModel> cartItemList;
    int sum = 0;
    Boolean isClicked = false;
    int item_price;
    public TotalAmountInterface amountInterface;

    public CartAdapter(Context context, ArrayList<CartItemModel> cartItemList, TotalAmountInterface amountInterface) {
        this.context = context;
        this.cartItemList = cartItemList;
        this.amountInterface = amountInterface;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CartLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind.totalItemCount.setText("0");

        holder.bind.itemName.setText(cartItemList.get(position).getItem_name());
        holder.bind.itemPrice.setText(cartItemList.get(position).getItem_price());
        holder.bind.itemDesc.setText(cartItemList.get(position).getItem_desc());


        holder.bind.addItem.setOnClickListener(view -> {
            cartItemList.get(position).setItem_count((cartItemList.get(position).getItem_count() + 1));
            holder.bind.totalItemCount.setText(cartItemList.get(position).getItem_count() + "");
            item_price = Integer.parseInt(cartItemList.get(position).getItem_price());
            sum = sum + item_price;
            holder.updateCart(sum);

        });


        holder.bind.descItem.setOnClickListener(view -> {
            isClicked = true;
            cartItemList.get(position).setItem_count((cartItemList.get(position).getItem_count() - 1));
            holder.bind.totalItemCount.setText(cartItemList.get(position).getItem_count() + " ");
            item_price = Integer.parseInt(cartItemList.get(position).getItem_price());
            if (sum != 0)
                sum = sum - item_price;
            holder.updateCart(sum);
        });

    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        CartLayoutBinding bind;

        public ViewHolder(CartLayoutBinding b) {
            super(b.getRoot());
            bind = b;

        }

        public void updateCart(int sum) {
            amountInterface.cartValueUpdate(sum);
        }


    }

}
