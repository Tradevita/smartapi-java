package com.angelbroking.smartapi.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

public class LTP {

    @SerializedName("tradingsymbol")
    public String tradingSymbol;

    @SerializedName("symboltoken")
    public String symbolToken;

    @SerializedName("open")
    public String open;

    @SerializedName("high")
    public String high;

    @SerializedName("low")
    public String low;

    @SerializedName("close")
    public String close;

    @SerializedName("ltp")
    public String ltp;

    public String getTradingSymbol() {
        return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
        this.tradingSymbol = tradingSymbol;
    }

    public String getSymbolToken() {
        return symbolToken;
    }

    public void setSymbolToken(String symbolToken) {
        this.symbolToken = symbolToken;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLtp() {
        return ltp;
    }

    public void setLtp(String ltp) {
        this.ltp = ltp;
    }

    @Override
    public String toString() {
        return "LTP{" +
                "tradingSymbol='" + tradingSymbol + '\'' +
                ", symbolToken='" + symbolToken + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", ltp='" + ltp + '\'' +
                '}';
    }

    public LTP parseResponse(JSONObject response) throws JSONException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(String.valueOf(response.get("data")), LTP.class);
    }
}
