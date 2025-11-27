package com.umeng.analytics.pro;

import java.io.Serializable;

public class cu implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14066a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f14067b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14068c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14069d;

    public cu(byte b10, boolean z10) {
        this.f14067b = b10;
        this.f14066a = false;
        this.f14068c = null;
        this.f14069d = z10;
    }

    public boolean a() {
        return this.f14066a;
    }

    public String b() {
        return this.f14068c;
    }

    public boolean c() {
        if (this.f14067b == 12) {
            return true;
        }
        return false;
    }

    public boolean d() {
        byte b10 = this.f14067b;
        if (b10 == 15 || b10 == 13 || b10 == 14) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.f14069d;
    }

    public cu(byte b10) {
        this(b10, false);
    }

    public cu(byte b10, String str) {
        this.f14067b = b10;
        this.f14066a = true;
        this.f14068c = str;
        this.f14069d = false;
    }
}
