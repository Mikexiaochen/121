package com.xc.pojo;

import java.util.Date;

public class Cart {
    private Integer cart_skuid;
    private String cart_name;
    private String cart_thumburl;
    private double cart_price;
    private int cart_count;
    private int cart_checked;
    private Date createttime;

    public Integer getCart_skuid() {
        return cart_skuid;
    }

    public void setCart_skuid(Integer cart_skuid) {
        this.cart_skuid = cart_skuid;
    }

    public String getCart_name() {
        return cart_name;
    }

    public void setCart_name(String cart_name) {
        this.cart_name = cart_name;
    }

    public String getCart_thumburl() {
        return cart_thumburl;
    }

    public void setCart_thumburl(String cart_thumburl) {
        this.cart_thumburl = cart_thumburl;
    }

    public double getCart_price() {
        return cart_price;
    }

    public void setCart_price(double cart_price) {
        this.cart_price = cart_price;
    }

    public int getCart_count() {
        return cart_count;
    }

    public void setCart_count(int cart_count) {
        this.cart_count = cart_count;
    }

    public int getCart_checked() {
        return cart_checked;
    }

    public void setCart_checked(int cart_checked) {
        this.cart_checked = cart_checked;
    }

    public Date getCreatettime() {
        return createttime;
    }

    public void setCreatettime(Date createttime) {
        this.createttime = createttime;
    }
}
