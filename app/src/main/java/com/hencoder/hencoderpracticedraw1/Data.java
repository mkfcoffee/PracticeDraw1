package com.hencoder.hencoderpracticedraw1;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Mcoffee.
 */

public class Data {
    private String name;
    private int amount;
    private int color;

    public Data(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Data(String name, int amount, int color) {
        this.name = name;
        this.amount = amount;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static int randomColor(){
       return randomColor(255);
    }

    public static int randomColor(int alpha) {
        Random rnd = new Random();
        alpha = Math.min(Math.max(1, alpha), 255);
        return Color.argb(alpha, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
