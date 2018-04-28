package com.example.saisriharshitavallurupalli.mycurrencyconverterapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saisriharshitavallurupalli.mycurrencyconverterapp.models.CurrencyObject;
import com.example.saisriharshitavallurupalli.mycurrencyconverterapp.retrofit.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.saisriharshitavallurupalli.mycurrencyconverterapp.MainActivity.AMT_KEY;
import static com.example.saisriharshitavallurupalli.mycurrencyconverterapp.MainActivity.DEST_KEY;
import static com.example.saisriharshitavallurupalli.mycurrencyconverterapp.MainActivity.SRC_KEY;

//import static com.example.saisriharshitavallurupalli.mycurrencyconverterapp.MainActivity.fromAmountStr;

public class ConvertResult extends AppCompatActivity {
    public  static TextView displayText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_result);

        displayText=(TextView)findViewById(R.id.display);



        Bundle b = new Bundle();
        b = getIntent().getExtras();
         String amt = b.getString(AMT_KEY);
        final String src=b.getString(SRC_KEY);
        final String dest=b.getString(DEST_KEY);

        Log.i("from amount ",amt);
        Log.i("from curr",src);
         getData(Double.parseDouble(amt),src,dest);
        Log.i("to curr",dest);

    }


   public void fade(View v)
   {

       ImageView pic1=(ImageView) findViewById(R.id.pic1);
       ImageView pic2=(ImageView) findViewById(R.id.pic2);
       pic1.animate().alpha(0).setDuration(2000);
       pic2.animate().alpha(1).setDuration(2000);

   }


    private void getData(Double amount, String src, final String dest) {

       final Double amt=amount;
        Map<String,String> parameters=new HashMap<>();

        //parameters.put("access_key","8676171-014b260fab275b497c9fd8142");
        parameters.put("access_key","6ce9c309296ff96518543cdc5e38fcfb");
        //parameters.put("format","1");
        //  parameters.put("currencies","INR");
        //  parameters.put("access_key","8363e0e84a24ed40235f2e03a3818612");
        RetrofitClient
                .getCcApi().baseApiCall(parameters).enqueue(new Callback<CurrencyObject>() {
            @Override
            public void onResponse(Call<CurrencyObject> call, Response<CurrencyObject> response) {
                Log.i("success",response.body().toString());

                double finalAmt=(response.body().quotes.uSDINR)*amt;
                Log.i("final amt",finalAmt+" ");

               displayText.setText("As per current values, the value you entered is:  "+finalAmt+"  INR");


            }

            @Override
            public void onFailure(Call<CurrencyObject> call, Throwable t) {
                Log.e("error", t.getMessage());

            }
        });


    }


}
