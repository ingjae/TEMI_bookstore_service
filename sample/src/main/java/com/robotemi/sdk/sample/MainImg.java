package com.robotemi.sdk.sample;

public class MainImg {
    private String imgUrl;
    private String info;

    MainImg(String _url, String _info){
        this.info = _info;
        this.imgUrl = _url;
    }

    public void setImgUrl(String imgUrl) {this.imgUrl = imgUrl; }
    public void setInfo(String info) {this.info = info;}

    public String getImgUrl(){return imgUrl;}
    public String getInfo(){return info;}
}
