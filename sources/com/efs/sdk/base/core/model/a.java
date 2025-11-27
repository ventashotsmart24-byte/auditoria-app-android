package com.efs.sdk.base.core.model;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    String f5280a;

    /* renamed from: b  reason: collision with root package name */
    byte f5281b = 2;

    /* renamed from: c  reason: collision with root package name */
    int f5282c = 0;

    /* renamed from: d  reason: collision with root package name */
    String f5283d = "none";

    /* renamed from: e  reason: collision with root package name */
    int f5284e = 1;

    /* renamed from: f  reason: collision with root package name */
    long f5285f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f5286g = 1;

    /* renamed from: h  reason: collision with root package name */
    String f5287h = "";

    /* renamed from: i  reason: collision with root package name */
    String f5288i = "";

    /* renamed from: j  reason: collision with root package name */
    long f5289j = 0;

    /* renamed from: k  reason: collision with root package name */
    long f5290k = 0;

    public a(String str, byte b10) {
        this.f5280a = str;
        if (b10 <= 0 || 3 < b10) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf(b10)));
        }
        this.f5281b = b10;
    }
}
