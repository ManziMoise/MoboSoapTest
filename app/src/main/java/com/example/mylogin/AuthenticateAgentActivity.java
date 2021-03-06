package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static com.example.mylogin.SOAPRequest.METHOD;
import static com.example.mylogin.SOAPRequest.NAMESPACE;

public class AuthenticateAgentActivity extends AppCompatActivity {

    EditText EdPrincipalType, EdPrincipal, EdCredentials;
    Button submit;
    String principalType;
    String principal;
    String credentials, checkCredentialsResponse;

    SOAPRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate_agent);

        EdPrincipal = (EditText)findViewById(R.id.principalEd);
        EdPrincipalType=(EditText)findViewById(R.id.principalTypeEd);
        EdCredentials=(EditText)findViewById(R.id.credentialsEd);
        submit = (Button)findViewById(R.id.submitBtn);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                principalType = EdPrincipalType.getText().toString();
                principal = EdPrincipal.getText().toString();
                credentials = EdCredentials.getText().toString();


                new AuthTask().execute();

            }
        });


    }

    private  class AuthTask extends AsyncTask<Void, Void, String>{

         String NAMESPACE = "http://tests.mcash.rw/rwandatest/services/";
         String METHOD = "access";
         String SOAPACTION = "http://tests.mcash.rw/rwandatest/services/access/";
         String URL = "http://tests.mcash.rw/rwandatest/services/access?principalType=newPrincipalType&principal=newPrincipal&credentials=newCredentials";

        @Override
        protected String doInBackground(Void... params) {

            SoapObject request = new SoapObject(NAMESPACE, METHOD);
            request.addProperty("principalType", principalType);
            request.addProperty("principal", principal);
            request.addProperty("credentials", credentials);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);

            HttpTransportSE transportSE = new HttpTransportSE(URL);
            try {
                transportSE.call(SOAPACTION, envelope);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


            SoapObject response = (SoapObject) envelope.bodyIn;
            SoapPrimitive result = (SoapPrimitive) response.getProperty(checkCredentialsResponse);

            return result.toString();
        }

        @Override
        protected void onPostExecute(String aBoolean) {
            super.onPostExecute(aBoolean);
            Toast.makeText(AuthenticateAgentActivity.this, "The Result is: "+aBoolean+"", Toast.LENGTH_SHORT).show();

        }
    }
}