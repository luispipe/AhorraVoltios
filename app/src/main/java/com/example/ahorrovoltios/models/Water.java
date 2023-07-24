package com.example.ahorrovoltios.models;

public class Water {
    float volume;
    float price;
    String month;

    public Water(float volume, float price, String month) {
        this.volume = volume;
        this.price = price;
        this.month = month;
    }

    public float getVolume() {
        return volume;
    }

    public float getPrice() {
        return price;
    }

    public String getMonth() {
        return month;
    }
}
