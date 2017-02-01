package com.example.nitin.firstapp;

import java.util.ArrayList;

/**
 * Created by nitin on 1/30/2017.
 */

public class Item {
    public String title,image;
    public String year;
    public String rate;
    private ArrayList<String> gen;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getGen() {
        return gen;
    }

    public void setGen(ArrayList<String> gen) {
        this.gen = gen;
    }
}
