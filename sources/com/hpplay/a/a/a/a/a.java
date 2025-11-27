package com.hpplay.a.a.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10416a = "US-ASCII";

    /* renamed from: b  reason: collision with root package name */
    private static final String f10417b = "multipart/form-data";

    /* renamed from: c  reason: collision with root package name */
    private static final String f10418c = "[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)";

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f10419d = Pattern.compile(f10418c, 2);

    /* renamed from: e  reason: collision with root package name */
    private static final String f10420e = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f10421f = Pattern.compile(f10420e, 2);

    /* renamed from: g  reason: collision with root package name */
    private static final String f10422g = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f10423h = Pattern.compile(f10422g, 2);

    /* renamed from: i  reason: collision with root package name */
    private final String f10424i;

    /* renamed from: j  reason: collision with root package name */
    private final String f10425j;

    /* renamed from: k  reason: collision with root package name */
    private final String f10426k;

    /* renamed from: l  reason: collision with root package name */
    private final String f10427l;

    public a(String str) {
        this.f10424i = str;
        if (str != null) {
            this.f10425j = a(str, f10419d, "", 1);
            this.f10426k = a(str, f10421f, (String) null, 2);
        } else {
            this.f10425j = "";
            this.f10426k = "UTF-8";
        }
        if (f10417b.equalsIgnoreCase(this.f10425j)) {
            this.f10427l = a(str, f10423h, (String) null, 2);
        } else {
            this.f10427l = null;
        }
    }

    private String a(String str, Pattern pattern, String str2, int i10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(i10) : str2;
    }

    public String b() {
        return this.f10425j;
    }

    public String c() {
        String str = this.f10426k;
        if (str == null) {
            return f10416a;
        }
        return str;
    }

    public String d() {
        return this.f10427l;
    }

    public boolean e() {
        return f10417b.equalsIgnoreCase(this.f10425j);
    }

    public a f() {
        if (this.f10426k != null) {
            return this;
        }
        return new a(this.f10424i + "; charset=UTF-8");
    }

    public String a() {
        return this.f10424i;
    }
}
