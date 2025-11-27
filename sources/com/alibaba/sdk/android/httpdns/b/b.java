package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.c.a;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static f f4920a = null;

    /* renamed from: a  reason: collision with other field name */
    private static a f5a = null;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f6a = false;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f4921n = true;

    public static List<e> a() {
        ArrayList arrayList = new ArrayList();
        if (!f6a) {
            return arrayList;
        }
        arrayList.addAll(f4920a.a());
        return arrayList;
    }

    public static void b(Context context) {
        if (context != null) {
            f5a.c(context);
        }
    }

    public static boolean g() {
        return f4921n;
    }

    public static String i() {
        return f5a.i();
    }

    public static void a(Context context) {
        a(context, (a) null);
    }

    public static void b(e eVar) {
        if (eVar != null) {
            f4920a.b(eVar);
        }
    }

    public static void a(Context context, a aVar) {
        f4920a = new a(context);
        f5a = aVar;
        if (aVar == null) {
            f5a = a.a();
        }
    }

    public static void a(e eVar) {
        if (eVar != null) {
            f4920a.a(eVar);
        }
    }

    public static void a(boolean z10, boolean z11) {
        f6a = z10;
        f4921n = z11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m0a() {
        return f6a;
    }
}
