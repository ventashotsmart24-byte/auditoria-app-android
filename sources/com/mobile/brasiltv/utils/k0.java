package com.mobile.brasiltv.utils;

import android.content.SharedPreferences;
import t9.i;
import v9.a;
import z9.g;

public final class k0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f12596a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12597b;

    public k0(String str, long j10) {
        this.f12596a = str;
        this.f12597b = j10;
    }

    public /* bridge */ /* synthetic */ void a(Object obj, g gVar, Object obj2) {
        d((c) obj, gVar, ((Number) obj2).longValue());
    }

    /* renamed from: c */
    public Long b(c cVar, g gVar) {
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        SharedPreferences e10 = cVar.e();
        String str = this.f12596a;
        if (str == null) {
            str = gVar.getName();
        }
        return Long.valueOf(e10.getLong(str, this.f12597b));
    }

    public void d(c cVar, g gVar, long j10) {
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        SharedPreferences.Editor edit = cVar.e().edit();
        String str = this.f12596a;
        if (str == null) {
            str = gVar.getName();
        }
        edit.putLong(str, j10).apply();
    }
}
