package com.alibaba.sdk.android.httpdns;

public class h extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private int f4981b;

    public h(int i10, String str) {
        super(str);
        this.f4981b = i10;
    }

    public int getErrorCode() {
        return this.f4981b;
    }
}
