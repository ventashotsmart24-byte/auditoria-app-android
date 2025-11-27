package com.umeng.message.proguard;

import android.graphics.Bitmap;
import android.text.TextUtils;

final class dk {

    /* renamed from: a  reason: collision with root package name */
    final ck f15786a;

    /* renamed from: b  reason: collision with root package name */
    final Bitmap f15787b;

    /* renamed from: c  reason: collision with root package name */
    private final String f15788c;

    public dk(ck ckVar, Bitmap bitmap) {
        this.f15786a = ckVar;
        this.f15788c = ckVar.c();
        this.f15787b = bitmap;
    }

    public final boolean a() {
        if (bs.a(this.f15786a.a()) == bs.f15532a) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dk)) {
            return false;
        }
        dk dkVar = (dk) obj;
        if (hashCode() != dkVar.hashCode()) {
            return false;
        }
        return TextUtils.equals(this.f15788c, dkVar.f15788c);
    }

    public final int hashCode() {
        String str = this.f15788c;
        if (str != null) {
            return str.hashCode();
        }
        return super.hashCode();
    }
}
