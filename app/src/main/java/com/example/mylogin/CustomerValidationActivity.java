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

public class CustomerValidationActivity extends AppCompatActivity {

    EditText nid, collection;
    Button submitValid;

    String newNid, newCollection, reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_validation);

        nid = (EditText) findViewById(R.id.nidEd);
        collection = (EditText) findViewById(R.id.collectionEd);
        submitValid = (Button) findViewById(R.id.submitValidBtn);


        submitValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newNid = nid.getText().toString();
                newCollection = collection.getText().toString();


                new CustomerValidationActivity.ValidationTask().execute();

            }
        });


    }

    private class ValidationTask extends AsyncTask<Void, Void, String> {

        String NAMESPACE = "http://52.36.87.202/services/";
        String METHOD = "cbhi";
        String SOAPACTION = "http://52.36.87.202/services/cbhi/";
        String URL = "http://52.36.87.202/services/cbhi/citizenNidValidation.php?citizenNidNumber=newNid&cbhiCollectionYear=newCollection";

        @Override
        protected String doInBackground(Void... params) {

            SoapObject request = new SoapObject(NAMESPACE, METHOD);
            request.addProperty("citizenNidNumber", newNid);
            request.addProperty("cbhiCollectionYear", newCollection);

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
            SoapPrimitive result = (SoapPrimitive) response.getProperty(reply);

            return result.toString();
        }

        @Override
        protected void onPostExecute(String aBoolean) {
            super.onPostExecute(aBoolean);
            Toast.makeText(CustomerValidationActivity.this, "The Result is: " + aBoolean + "", Toast.LENGTH_SHORT).show();

        }
    }
}