package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomerValidationActivity extends AppCompatActivity {

    EditText nid, collection;
    Button submitValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_validation);

        nid= (EditText)findViewById(R.id.nidEd);
        collection= (EditText)findViewById(R.id.collectionEd);
        submitValid= (Button) findViewById(R.id.submitValidBtn);


        submitValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        
    }
}