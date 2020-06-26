package com.robotemi.sdk.sample;

import java.io.Serializable;

public class BookInfo implements Serializable {
    private String title;
    private String price;
    private String subInfo;
    private String coverSrc;
    private String info;
    private String stock;
    private String location;

    public BookInfo(){}
    public BookInfo(String _title, String _price, String _subInfo, String _coverSrc, String _info){
        this.title = _title;
        this.price = _price;
        this.subInfo = _subInfo;
        this.info = _info;
        this.coverSrc = _coverSrc;
    }

    public void setStock(String stock){ this.stock = stock; }
    public void setLocation(String location){ this.location = location; }
    public void setCoverSrc(String coverSrc) { this.coverSrc = coverSrc; }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setSubInfo(String subInfo) {
        this.subInfo = subInfo;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCoverSrc() {
        return coverSrc;
    }
    public String getInfo() {
        return info;
    }
    public String getPrice() {
        return price;
    }
    public String getSubInfo() {
        return subInfo;
    }
    public String getTitle() {
        return title;
    }
    public String getLocation(){ return location; }
    public String getStock(){ return stock; }
}