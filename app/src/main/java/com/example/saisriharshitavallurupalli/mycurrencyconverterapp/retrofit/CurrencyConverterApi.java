package com.example.saisriharshitavallurupalli.mycurrencyconverterapp.retrofit;

import com.example.saisriharshitavallurupalli.mycurrencyconverterapp.models.CurrencyObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface CurrencyConverterApi {

    @GET("live")
    Call<CurrencyObject> baseApiCall(@QueryMap Map<String, String> parameter);


}
