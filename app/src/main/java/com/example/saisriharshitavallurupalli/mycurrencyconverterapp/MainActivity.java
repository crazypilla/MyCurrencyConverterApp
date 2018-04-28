package com.example.saisriharshitavallurupalli.mycurrencyconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String AMT_KEY="amtK";
    public static final String SRC_KEY="srcK";
    public static final String DEST_KEY="destK";
    //public static Button convertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final EditText srcAmt=(EditText)findViewById(R.id.fromCurrencyAmount);
         final EditText srcCurr=(EditText)findViewById(R.id.fromCurrency);
         final EditText destCurr=(EditText)findViewById(R.id.toCurrency);
         final Button convertButton=(Button)findViewById(R.id.convertButton);
        // final String amt=srcAmt.getText().toString();
        // final String src=srcCurr.getText().toString();
        // final String dest=destCurr.getText().toString();



        convertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent convertResultsIntent= new Intent(getApplicationContext(),ConvertResult.class);

               Log.i("MAClassInfo: AMT",srcAmt.getText().toString());
                Log.i("MAClassInfo:SRC",srcCurr.getText().toString());
                Log.i("MAClassInfo:DEST",destCurr.getText().toString());
                convertResultsIntent.putExtra(AMT_KEY,srcAmt.getText().toString());
                convertResultsIntent.putExtra(SRC_KEY,srcCurr.getText().toString());
                convertResultsIntent.putExtra(DEST_KEY,destCurr.getText().toString());

                startActivity(convertResultsIntent);
            }
        });


    }
}
