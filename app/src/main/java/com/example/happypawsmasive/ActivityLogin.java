package com.example.happypawsmasive;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLogin extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button buttonlogin;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(ActivityLogin.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        buttonlogin = findViewById(R.id.btn_Login);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputEmail.getText().length()>0 && inputPassword.getText().length() > 0) {
                    login(inputEmail.getText().toString(), inputPassword.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void login(String email, String password) {
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful() && task.getResult() != null) {
                    if (task.getResult().getUser() != null) {
                        reload();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Login Gagal!", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private void reload() {
        startActivity (new Intent(getApplicationContext(), NavActivity.class));
    }

    @Override
    public void onStart(){
        super.onStart();
        // Chek if user is signed in (non-null) and update UI accordingly.
        FirebaseUser curentUser = mAuth.getCurrentUser();
        if (curentUser != null){
            reload();
        }
    }

    public void onClickGoToForgotPassword(View view) {
        Intent forget = new Intent( ActivityLogin.this, ActivityForgotPassword.class);
        startActivity(forget);
    }

    public void onClickGoToSignUp(View view){
        Intent regist = new Intent(ActivityLogin.this, ActivitySignup.class);
        startActivity(regist);
    }
}

