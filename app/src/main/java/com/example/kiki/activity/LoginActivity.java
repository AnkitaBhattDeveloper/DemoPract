package com.example.kiki.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kiki.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        onClick();


    }

    public void onClick() {
        binding.btLogin.setOnClickListener(view -> {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (email.isEmpty()){
                binding.etEmail.setError("Enter valid email");
                return;
            }
            if (password.isEmpty()) {
                binding.etPassword.setError("Enter Password");
                return;
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    startActivity(new Intent(context, MainActivity.class));
                    LoginActivity.this.finish();
                    Toast.makeText(context, "User logged in Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("TAG", "onComplete: " );
                    Toast.makeText(context, "Invalid email/password", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(e -> Log.e("TAG", "onFailure: "+e.getLocalizedMessage() ));
        });
        binding.btSignUp.setOnClickListener(view -> startActivity(new Intent(context, SignupActivity.class)));
    }

}