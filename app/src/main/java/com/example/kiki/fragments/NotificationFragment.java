package com.example.kiki.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kiki.adapter.NotificationAdapter;
import com.example.kiki.R;
import com.example.kiki.databinding.FragmentNotificationBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationFragment extends Fragment {

    FragmentNotificationBinding binding;
    NotificationAdapter notificationAdapter;
    ArrayList<String> noti_list = new ArrayList<>();


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public NotificationFragment() {
        // Required empty public constructor
    }


    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
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
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notificationAdapter = new NotificationAdapter(requireContext(), noti_list);
        binding.rvNotification.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        noti_list.add("");
        noti_list.add("");
        noti_list.add("");
        noti_list.add("");
        noti_list.add("");
        noti_list.add("");
        noti_list.add("");
        binding.rvNotification.setAdapter(notificationAdapter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Kiki", "Kiki", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = requireActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "Kiki")
                .setAutoCancel(true)
                .setContentText("Be patient your order will be deleivered in 2 days")
                .setSmallIcon(R.drawable.main_logo)
                .setContentTitle("Your package is delivered");

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(requireContext());
        managerCompat.notify(123, builder.build());


    }
}


/*
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = requireActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "MyNotification")
                .setContentTitle("kiki")
                .setSmallIcon(R.drawable.clothes)
                .setContentText("Sale is going live you are not allowed ")
                .setAutoCancel(true);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(requireContext());
        managerCompat.notify(999, builder.build());
  */
