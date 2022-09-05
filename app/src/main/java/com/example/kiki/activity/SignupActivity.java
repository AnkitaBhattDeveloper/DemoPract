package com.example.kiki.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kiki.databinding.ActivitySignupBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;
        onClick();


    }

    public void onClick() {
        binding.btSignUp.setOnClickListener(view -> {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();
            String confirmPassword = binding.etConfirmPassword.getText().toString();

            if (email.isEmpty()) {
                binding.etEmail.setError("Enter valid email");
                return;
            }
            if (password.isEmpty()) {
                binding.etPassword.setError("Enter Password");
                return;
            }
            if (!password.equals(confirmPassword)) {
                binding.etConfirmPassword.setError("Re-type your password");
                return;
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "User created Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, CompleteProfileActivity.class));
                    SignupActivity.this.finish();
                } else {
                    Log.e("TAG", "onComplete: ");
                    Toast.makeText(context, "Invalid email/password", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(e ->  Toast.makeText(context, "Error : "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
        });
    }

}