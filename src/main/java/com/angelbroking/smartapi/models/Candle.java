package com.angelbroking.smartapi.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Candle {

    public String timeStamp;
    public Double open;
    public Double high;
    public Double low;
    public Double close;
    public Long volume;

    public Candle(
            String timeStamp,
            Double open,
            Double high,
            Double low,
            Double close,
            Long volume
    ) {
        this.timeStamp = timeStamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;

    }

    public Candle() {

    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Candle{" +
                "timeStamp='" + timeStamp + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }

    public List<Candle> parseResponse(JSONObject response) throws JSONException {
        JSONArray data = response.getJSONArray("data");

        List<Candle> candles = new ArrayList<Candle>();
//        Candle[] candles = new Candle[data.length()];

        for (int i = 0; i < data.length(); i++) {

            JSONArray d = data.getJSONArray(i);
            Candle candle = new Candle(
                    d.getString(0),
                    d.getDouble(1),
                    d.getDouble(2),
                    d.getDouble(3),
                    d.getDouble(4),
                    d.getLong(5)
            );
            candles.add(candle);
//            candles[i] = candle;
        }
        return candles;
    }
}