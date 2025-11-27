package com.umeng.ut.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ut.a.b.g;
import com.umeng.ut.a.c.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f16242a = new a();

    /* renamed from: c  reason: collision with root package name */
    private static long f16243c = 3000;

    /* renamed from: c  reason: collision with other field name */
    private String f64c = "";

    private a() {
    }

    public static a a() {
        return f16242a;
    }

    public static long b() {
        return f16243c;
    }

    private void d() {
        e.c();
        if (!TextUtils.isEmpty(this.f64c)) {
            try {
                Context a10 = com.umeng.ut.a.a.a().a();
                if (com.umeng.ut.a.c.a.a(a10)) {
                    new Thread(new g(a10)).start();
                }
            } catch (Throwable th) {
                e.a("", th);
            }
        }
    }

    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.f64c)) {
            return this.f64c;
        }
        try {
            String value = d.a(context).getValue();
            if (TextUtils.isEmpty(value)) {
                return "ffffffffffffffffffffffff";
            }
            this.f64c = value;
            d();
            return this.f64c;
        } catch (Throwable th) {
            e.a("AppUtdid", th, new Object[0]);
            return "ffffffffffffffffffffffff";
        }
    }

    public synchronized String i() {
        return this.f64c;
    }
}
