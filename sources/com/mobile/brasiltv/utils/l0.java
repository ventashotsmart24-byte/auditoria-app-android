package com.mobile.brasiltv.utils;

import android.content.SharedPreferences;
import t9.i;
import v9.a;
import z9.g;

public final class l0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f12598a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12599b;

    public l0(String str, String str2) {
        i.g(str2, "defaultValue");
        this.f12598a = str;
        this.f12599b = str2;
    }

    /* renamed from: c */
    public String b(c cVar, g gVar) {
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        SharedPreferences e10 = cVar.e();
        String str = this.f12598a;
        if (str == null) {
            str = gVar.getName();
        }
        String string = e10.getString(str, this.f12599b);
        if (string == null) {
            return "";
        }
        return string;
    }

    /* renamed from: d */
    public void a(c cVar, g gVar, String str) {
        i.g(cVar, "thisRef");
        i.g(gVar, "property");
        i.g(str, "value");
        SharedPreferences.Editor edit = cVar.e().edit();
        String str2 = this.f12598a;
        if (str2 == null) {
            str2 = gVar.getName();
        }
        edit.putString(str2, str).apply();
    }
}
