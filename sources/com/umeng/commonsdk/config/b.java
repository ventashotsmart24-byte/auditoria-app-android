package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f14624a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Object f14625b = new Object();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f14626a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f14626a;
    }

    public void a() {
        synchronized (f14625b) {
            f14624a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f14625b) {
            if (!f14624a.containsKey(str)) {
                return true;
            }
            boolean booleanValue = f14624a.get(str).booleanValue();
            return booleanValue;
        }
    }

    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f14625b) {
                Map<String, Boolean> map = f14624a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
