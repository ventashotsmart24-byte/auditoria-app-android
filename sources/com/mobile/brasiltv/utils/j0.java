package com.mobile.brasiltv.utils;

import android.content.SharedPreferences;
import t9.i;
import v9.a;
import z9.g;

public final class j0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f12591a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f12592b;

    public j0(String str, Boolean bool) {
        this.f12591a = str;
        this.f12592b = bool;
    }

    public /* bridge */ /* synthetic */ void a(Object obj, g gVar, Object obj2) {
        d((c) obj, gVar, ((Boolean) obj2).booleanValue());
    }

    /* renamed from: c */
    public Boolean b(c cVar, g gVar) {
        boolean z10;
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        SharedPreferences e10 = cVar.e();
        String str = this.f12591a;
        if (str == null) {
            str = gVar.getName();
        }
        Boolean bool = this.f12592b;
        if (bool != null) {
            z10 = bool.booleanValue();
        } else {
            z10 = false;
        }
        return Boolean.valueOf(e10.getBoolean(str, z10));
    }

    public void d(c cVar, g gVar, boolean z10) {
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        SharedPreferences.Editor edit = cVar.e().edit();
        String str = this.f12591a;
        if (str == null) {
            str = gVar.getName();
        }
        edit.putBoolean(str, z10).apply();
    }
}
