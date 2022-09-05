package com.example.kiki.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kiki.App.Constants;
import com.example.kiki.adapter.CartAdapter;
import com.example.kiki.adapter.TotalCartItemPriceAdapter;
import com.example.kiki.data.CartItemModel;
import com.example.kiki.data.TotalCartPrice;
import com.example.kiki.databinding.BottomSheetBinding;
import com.example.kiki.databinding.FragmentCartBinding;
import com.example.kiki.util.TotalAmountInterface;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment implements TotalAmountInterface {

    FragmentCartBinding binding;
    BottomSheetBinding bottomSheetBinding;
    Constants constants;
    ArrayList<CartItemModel> cartItemList = new ArrayList<>();
    List<TotalCartPrice> totalItemList = new ArrayList<>();
    TotalCartPrice totalCart = new TotalCartPrice();

    int sum, c, total = 0, getsum;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public CartFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        Log.e("TAG", "newInstance: " + param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            String item = getArguments().getString("item");
            Log.e("TAG", "onCreate:  cart fragment " + item);


            String itemPrice = getArguments().getString("ItemPrice");
            Log.e("TAG", "onCreate:  cart fragment " + itemPrice);

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
        cartAdapter();
        Totala();


    }

    public void cartAdapter() {
        CartAdapter cartAdapter = new CartAdapter(requireContext(), cartItemList, this);
        binding.rvCart.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        cartItemList.add(new CartItemModel("", "a", "a", "1"));
        cartItemList.add(new CartItemModel("", "b", "b", "2"));
        cartItemList.add(new CartItemModel("", "c", "c", "3"));


        binding.rvCart.setAdapter(cartAdapter);
        binding.rvCart.hasFixedSize();
    }

    public void Totala() {
        TotalCartItemPriceAdapter totalCartItemPriceAdapter = new TotalCartItemPriceAdapter(requireContext(), totalItemList);
        binding.totalPriceRv.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        totalItemList.add(new TotalCartPrice("Meloso", totalCart.getProductPrice()));
        Log.e("TAG", "Totala: " + totalCart.getProductPrice());

        binding.totalPriceRv.setAdapter(totalCartItemPriceAdapter);
        binding.totalPriceRv.hasFixedSize();

    }

    @Override
    public void cartValueUpdate(int sum) {
        Log.e("TAG", "totalItemAdded: sum----> " + sum);
        binding.TotalPrice.setText(sum + " Rs.");

    }


   /* public void bottomSheet() {

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
    }*/

}