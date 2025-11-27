package com.umeng.message.proguard;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.common.UPLog;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f15311a = new a();

    /* renamed from: b  reason: collision with root package name */
    private String f15312b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f15313c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f15314d;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f15315e;

    /* renamed from: f  reason: collision with root package name */
    private Class<?> f15316f;

    private a() {
    }

    public static int a(String str) {
        return f15311a.g(str);
    }

    public static int b(String str) {
        return f15311a.e(str);
    }

    public static int c(String str) {
        return f15311a.f(str);
    }

    public static int d(String str) {
        return f15311a.h(str);
    }

    private int e(String str) {
        if (this.f15313c == null) {
            try {
                this.f15313c = Class.forName(a() + ".R$id");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f15313c, str);
    }

    private int f(String str) {
        if (this.f15314d == null) {
            try {
                this.f15314d = Class.forName(a() + ".R$drawable");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
                UMLog.aq(ac.f15318b, 0, "\\|");
            }
        }
        return a(this.f15314d, str);
    }

    private int g(String str) {
        if (this.f15315e == null) {
            try {
                this.f15315e = Class.forName(a() + ".R$layout");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f15315e, str);
    }

    private int h(String str) {
        if (this.f15316f == null) {
            try {
                this.f15316f = Class.forName(a() + ".R$raw");
            } catch (ClassNotFoundException e10) {
                UPLog.w("R2", UPLog.getStackTrace(e10));
            }
        }
        return a(this.f15316f, str);
    }

    private String a() {
        if (!TextUtils.isEmpty(this.f15312b)) {
            return this.f15312b;
        }
        Application a10 = y.a();
        String h10 = MessageSharedPrefs.getInstance(a10).h();
        if (TextUtils.isEmpty(h10)) {
            h10 = a10.getPackageName();
        }
        this.f15312b = h10;
        UPLog.i("R2", "resPackage:", h10);
        return this.f15312b;
    }

    private int a(Class<?> cls, String str) {
        if (cls != null) {
            try {
                return cls.getField(str).getInt(str);
            } catch (Throwable unused) {
                throw new Resources.NotFoundException(cls.getName() + " field:" + str + " not exist.");
            }
        } else {
            UPLog.e("R2", "getRes(null,", str, ")");
            throw new Resources.NotFoundException(a() + ".R$* field=" + str + " not exist.");
        }
    }
}
