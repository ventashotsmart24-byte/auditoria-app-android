package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.cl;

public enum Gender implements cl {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int value;

    private Gender(int i10) {
        this.value = i10;
    }

    public static Gender findByValue(int i10) {
        if (i10 == 0) {
            return MALE;
        }
        if (i10 == 1) {
            return FEMALE;
        }
        if (i10 != 2) {
            return null;
        }
        return UNKNOWN;
    }

    public int getValue() {
        return this.value;
    }
}
