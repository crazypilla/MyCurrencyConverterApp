package com.example.saisriharshitavallurupalli.mycurrencyconverterapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static CurrencyConverterApi ccApi;
    private static Retrofit getClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static CurrencyConverterApi getCcApi() {
        if (ccApi == null) {
            ccApi = getClient("http://www.apilayer.net/").create(CurrencyConverterApi.class);
        }
        return ccApi;
    }



}
