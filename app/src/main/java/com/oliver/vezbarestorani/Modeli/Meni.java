package com.oliver.vezbarestorani.Modeli;

import java.io.Serializable;

/**
 * Created by Oliver on 1/5/2018.
 */

public class Meni implements Serializable {

    String link;
    String price;
    String foodname;
    boolean isveg;

    public Meni(String link, String price, String foodname, boolean isveg) {
        this.link = link;
        this.price = price;
        this.foodname = foodname;
        this.isveg = isveg;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public boolean isIsveg() {
        return isveg;
    }

    public void setIsveg(boolean isveg) {
        this.isveg = isveg;
    }
}
