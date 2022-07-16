package com.example.happypawsmasive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OnBoarding2  extends AppCompatActivity {
    Button btn_Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding2);
        getSupportActionBar().hide();

        btn_Action = findViewById(R.id.btn_action);
        btn_Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OnBoarding3.class));
            }
        });
    }
}
