package com.hpplay.sdk.source.bean;

public class PassCacheBean {
    public String body;
    public String header;
    public int type;

    public PassCacheBean(int i10, String str, String str2) {
        this.type = i10;
        this.header = str;
        this.body = str2;
    }
}
