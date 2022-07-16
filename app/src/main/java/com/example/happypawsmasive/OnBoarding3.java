package com.example.happypawsmasive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OnBoarding3 extends AppCompatActivity {
    Button btn_Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding3);
        getSupportActionBar().hide();

        btn_Action = findViewById(R.id.btn_action);
        btn_Action.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityLogin.class));
            }
        });
    }
}

