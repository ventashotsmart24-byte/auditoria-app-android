package com.hpplay.a.a.a.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f10428a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10429b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10430c;

    public b(String str, String str2) {
        this(str, str2, 30);
    }

    public static String a(int i10) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        instance.add(5, i10);
        return simpleDateFormat.format(instance.getTime());
    }

    public b(String str, String str2, int i10) {
        this.f10428a = str;
        this.f10429b = str2;
        this.f10430c = a(i10);
    }

    public b(String str, String str2, String str3) {
        this.f10428a = str;
        this.f10429b = str2;
        this.f10430c = str3;
    }

    public String a() {
        return String.format("%s=%s; expires=%s", new Object[]{this.f10428a, this.f10429b, this.f10430c});
    }
}
