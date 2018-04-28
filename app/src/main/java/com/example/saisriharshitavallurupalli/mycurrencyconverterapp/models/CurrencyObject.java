package com.example.saisriharshitavallurupalli.mycurrencyconverterapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyObject {

    @SerializedName("success")
    @Expose
    public boolean success;
    @SerializedName("terms")
    @Expose
    public String terms;
    @SerializedName("privacy")
    @Expose
    public String privacy;
    @SerializedName("timestamp")
    @Expose
    public int timestamp;
    @SerializedName("source")
    @Expose
    public static String source;
    @SerializedName("quotes")
    @Expose
    public Quotes quotes;



}
