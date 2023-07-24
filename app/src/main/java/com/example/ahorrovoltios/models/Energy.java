package com.example.ahorrovoltios.models;

public class Energy {
    float kw;
    float price;
    String month;

    public Energy(float kw, float price, String month) {
        this.kw = kw;
        this.price = price;
        this.month = month;
    }

    public float getKw() {
        return kw;
    }

    public float getPrice() {
        return price;
    }

    public String getMonth() {
        return month;
    }
}
