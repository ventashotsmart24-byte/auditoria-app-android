package com.titans.entity;

import t9.i;

public enum RangerPlayTag {
    LIVE("live"),
    VOD("vod"),
    RECORD("record");
    
    private String value;

    private RangerPlayTag(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        i.g(str, "<set-?>");
        this.value = str;
    }
}
