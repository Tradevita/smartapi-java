package com.angelbroking.smartapi.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Holdings {

    @SerializedName("t1quantity")
    public int t1Quantity;

    @SerializedName("authorisedquantity")
    public int authorisedQuantity;

    @SerializedName("product")
    public String product;

    @SerializedName("quantity")
    public int quantity;

    @SerializedName("ltp")
    public double ltp;

    @SerializedName("haircut")
    public double haircut;

    @SerializedName("profitandloss")
    public double profitAndLoss;

    @SerializedName("collateraltype")
    public String collateralType;

    @SerializedName("averageprice")
    public double averagePrice;

    @SerializedName("tradingsymbol")
    public String tradingSymbol;

    @SerializedName("exchange")
    public String exchange;

    @SerializedName("close")
    public Double close;

    @SerializedName("isin")
    public String isIn;

    @SerializedName("realisedquantity")
    public int realisedQuantity;

    @SerializedName("symboltoken")
    public String symbolToken;

    @SerializedName("collateralquantity")
    public int collateralQuantity;

    public int getT1Quantity() {
        return t1Quantity;
    }

    public void setT1Quantity(int t1Quantity) {
        this.t1Quantity = t1Quantity;
    }

    public int getAuthorisedQuantity() {
        return authorisedQuantity;
    }

    public void setAuthorisedQuantity(int authorisedQuantity) {
        this.authorisedQuantity = authorisedQuantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getLtp() {
        return ltp;
    }

    public void setLtp(double ltp) {
        this.ltp = ltp;
    }

    public double getHaircut() {
        return haircut;
    }

    public void setHaircut(double haircut) {
        this.haircut = haircut;
    }

    public double getProfitAndLoss() {
        return profitAndLoss;
    }

    public void setProfitAndLoss(double profitAndLoss) {
        this.profitAndLoss = profitAndLoss;
    }

    public String getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getTradingSymbol() {
        return tradingSymbol;
    }

    public void setTradingSymbol(String tradingSymbol) {
        this.tradingSymbol = tradingSymbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public String getIsIn() {
        return isIn;
    }

    public void setIsIn(String isIn) {
        this.isIn = isIn;
    }

    public int getRealisedQuantity() {
        return realisedQuantity;
    }

    public void setRealisedQuantity(int realisedQuantity) {
        this.realisedQuantity = realisedQuantity;
    }

    public String getSymbolToken() {
        return symbolToken;
    }

    public void setSymbolToken(String symbolToken) {
        this.symbolToken = symbolToken;
    }

    public int getCollateralQuantity() {
        return collateralQuantity;
    }

    public void setCollateralQuantity(int collateralQuantity) {
        this.collateralQuantity = collateralQuantity;
    }

    @Override
    public String toString() {
        return "Holdings{" +
                "t1Quantity=" + t1Quantity +
                ", authorisedQuantity=" + authorisedQuantity +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", ltp=" + ltp +
                ", haircut=" + haircut +
                ", profitAndLoss=" + profitAndLoss +
                ", collateralType='" + collateralType + '\'' +
                ", averagePrice=" + averagePrice +
                ", tradingSymbol='" + tradingSymbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", close=" + close +
                ", isIn='" + isIn + '\'' +
                ", realisedQuantity=" + realisedQuantity +
                ", symbolToken='" + symbolToken + '\'' +
                ", collateralQuantity=" + collateralQuantity +
                '}';
    }

    public List<Holdings> parseResponse(JSONObject response) throws JSONException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        JSONArray data = response.getJSONArray("data");

        List<Holdings> holdings = new ArrayList<Holdings>();

        for (int i = 0; i < data.length(); i++) {
            holdings.add(
                    gson.fromJson(String.valueOf(data.get(i)), Holdings.class)
            );
        }

        return holdings;
    }
}
