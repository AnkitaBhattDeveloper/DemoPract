package com.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiki.databinding.BottomSheetBinding;
import com.example.kiki.databinding.FragmentCartBinding;
import com.example.App.Constants;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CartFragment extends Fragment {

    FragmentCartBinding binding;
    BottomSheetBinding bottomSheetBinding;
    Constants constants;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        binding = FragmentCartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheet();
            }
        });
    }

    public void bottomSheet() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetBinding = BottomSheetBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(bottomSheetBinding.getRoot());
        bottomSheetDialog.show();
        GpayBtnClick();
    }
    public void GpayBtnClick()
    {
        bottomSheetBinding.rBtnGPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri =
                        new Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", "your-merchant-vpa@xxx")
                                .appendQueryParameter("pn", "your-merchant-name")
                                .appendQueryParameter("mc", "your-merchant-code")
                                .appendQueryParameter("tr", "your-transaction-ref-id")
                                .appendQueryParameter("tn", "your-transaction-note")
                                .appendQueryParameter("am", "your-order-amount")
                                .appendQueryParameter("cu", "INR")
                                .appendQueryParameter("url", "your-transaction-url")
                                .build();

     Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(constants.GOOGLE_PAY_PACKAGE_NAME);
    startActivityForResult(intent, constants.GOOGLE_PAY_REQUEST_CODE);

            }
        });
    }

}