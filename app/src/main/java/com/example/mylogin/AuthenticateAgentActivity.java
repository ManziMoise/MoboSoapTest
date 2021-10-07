package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.mylogin.SOAPRequest.METHOD;
import static com.example.mylogin.SOAPRequest.NAMESPACE;

public class AuthenticateAgentActivity extends AppCompatActivity {

    EditText principalType, principal, credentials;
    Button submit;

    SOAPRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate_agent);

        principal = (EditText)findViewById(R.id.principalEd);
        principalType=(EditText)findViewById(R.id.principalTypeEd);
        credentials=(EditText)findViewById(R.id.credentialsEd);
        submit = (Button)findViewById(R.id.submitBtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newPrincipalType = principalType.getText().toString();
                String newPrincipal = principal.getText().toString();
                String newCredentials = credentials.getText().toString();


                new AuthTask().execute();

            }
        });


    }

    private  class AuthTask extends AsyncTask<Void, Void, Boolean>{



        @Override
        protected Boolean doInBackground(Void... params) {

           request = new SOAPRequest(NAMESPACE, METHOD);




            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

        }
    }
}