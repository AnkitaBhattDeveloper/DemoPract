package com.example.kiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiki.databinding.AccountLayoutBinding;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    Context context;
    ArrayList<String>account_list;
    AccountLayoutBinding binding ;
    public AccountAdapter(Context context,ArrayList<String> account_list)
    {
        this.context = context;
        this.account_list = account_list;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AccountLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        binding.accText.setText("Settings");


    }

    @Override
    public int getItemCount() {
        return account_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        AccountLayoutBinding bind;
        public ViewHolder(AccountLayoutBinding b)
        {
            super(b.getRoot());
            bind = b;
        }
    }
}
