package com.example.kiki.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kiki.data.UsersModel;
import com.example.kiki.databinding.ActivityCompleteProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompleteProfileActivity extends AppCompatActivity {
    ActivityCompleteProfileBinding binding;
    Context context;
    DatabaseReference dbRef;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompleteProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();


        dbRef = firebaseDatabase.getReference();

        binding.btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.etUserName.getText().toString();
                String address = binding.etAddress.getText().toString();
                String phone = binding.etUserMobile.getText().toString();
                String email = binding.etUserEmail.getText().toString();
                saveUser(name,email,address,phone);

            }
        });
    }

    private void saveUser(String name,String email,String address,String phone) {
        dbRef.child("Users")
                .child(uid)
                .setValue(new UsersModel(uid,name, email, address, phone))
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            startActivity(new Intent(context, MainActivity.class));
                            CompleteProfileActivity.this.finish();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Error : " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}