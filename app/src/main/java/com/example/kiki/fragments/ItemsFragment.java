package com.example.kiki.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.kiki.adapter.ItemAdapter;
import com.example.kiki.data.ItemListModel;
import com.example.kiki.databinding.FragmentItemsBinding;

import java.util.ArrayList;


public class ItemsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ItemAdapter itemAdapter;
    ArrayList<ItemListModel> list = new ArrayList<>();
    FragmentItemsBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItemsFragment() {
        // Required empty public constructor
    }

    public static ItemsFragment newInstance(String param1, String param2) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentItemsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemAdapter = new ItemAdapter(requireContext(), list);
        binding.ItemRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.ItemRecyclerView.hasFixedSize();
        binding.ItemRecyclerView.setAdapter(itemAdapter);
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));
        list.add(new ItemListModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ2dSKoS6-OwCCRguZTuyHL-KIgz1MDv9Frw&usqp=CAU", "bbbbbbb", "cdgfdsffdf", "123"));




    }
}