package com.umeng.message.proguard;

import com.umeng.message.entity.UMessage;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public final int f15319a;

    /* renamed from: b  reason: collision with root package name */
    public final UMessage f15320b;

    /* renamed from: c  reason: collision with root package name */
    public Object f15321c;

    /* renamed from: d  reason: collision with root package name */
    public int f15322d;

    public ad(int i10, UMessage uMessage) {
        this.f15319a = i10;
        this.f15320b = uMessage;
    }

    public final boolean equals(Object obj) {
        if (obj != null && ad.class == obj.getClass() && this.f15319a == ((ad) obj).f15319a) {
            return true;
        }
        return false;
    }
}
