package com.lzy.webparser.model.beans;

/**
 * Created by lizhiyun on 2018/4/16.
 */

public class MainModel {
    private String weburl;
    private String imageurl;

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public MainModel(String weburl, String imageurl) {
        this.weburl = weburl;
        this.imageurl = imageurl;
    }
}
