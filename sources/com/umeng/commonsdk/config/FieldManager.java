package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

public class FieldManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14619a = "cfgfd";

    /* renamed from: b  reason: collision with root package name */
    private static b f14620b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14621c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Object f14622d = new Object();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final FieldManager f14623a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f14623a;
    }

    public static boolean allow(String str) {
        synchronized (f14622d) {
            if (!f14621c) {
                return false;
            }
            boolean a10 = b.a(str);
            return a10;
        }
    }

    public static boolean b() {
        boolean z10;
        synchronized (f14622d) {
            z10 = f14621c;
        }
        return z10;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.C0200d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", str2);
        synchronized (f14622d) {
            Pair<Long, String> a10 = a(imprintProperty);
            if (((Long) a10.first).longValue() > 1000 && (str = (String) a10.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(split[i10], f14620b, d.b(strArr[i10]));
                }
            }
            f14621c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.C0200d.class.getName()};
        synchronized (f14622d) {
            f14620b.a();
            if (str != null) {
                Pair<Long, String> a10 = a(str);
                if (((Long) a10.first).longValue() > 1000 && (str2 = (String) a10.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(split[i10], f14620b, d.b(strArr[i10]));
                }
            }
            f14621c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, (Object) null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
