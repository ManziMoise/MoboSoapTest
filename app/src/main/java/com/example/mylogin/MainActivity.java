package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView authcd, validcd, paycd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authcd = (CardView)findViewById(R.id.AuthCard);
        validcd = (CardView)findViewById(R.id.ValidateCard);
        paycd = (CardView)findViewById(R.id.paymentCard);


        authcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent authIntent = new Intent(MainActivity.this, AuthenticateAgentActivity.class);
                startActivity(authIntent);
            }
        });
        validcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent validIntent = new Intent(MainActivity.this, CustomerValidationActivity.class);
                startActivity(validIntent);
            }
        });
        paycd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent payIntent = new Intent(MainActivity.this, AuthenticateAgentActivity.class);
                startActivity(payIntent);
            }
        });
    }
}