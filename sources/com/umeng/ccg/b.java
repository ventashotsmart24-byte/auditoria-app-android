package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f14534a = true;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f14535b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f14536c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f14537d = true;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f14538e = true;

    /* renamed from: f  reason: collision with root package name */
    private static Object f14539f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, Boolean> f14540g = new HashMap();

    public static boolean a() {
        boolean z10;
        synchronized (f14539f) {
            z10 = f14534a;
        }
        return z10;
    }

    public static boolean b() {
        boolean z10;
        synchronized (f14539f) {
            z10 = f14535b;
        }
        return z10;
    }

    public static boolean c() {
        boolean z10;
        synchronized (f14539f) {
            z10 = f14536c;
        }
        return z10;
    }

    public static boolean d() {
        boolean z10;
        synchronized (f14539f) {
            z10 = f14537d;
        }
        return z10;
    }

    public static void a(boolean z10) {
        synchronized (f14539f) {
            f14537d = z10;
            f14540g.put(a.f14512e, Boolean.valueOf(z10));
        }
    }

    public static void b(boolean z10) {
        synchronized (f14539f) {
            f14538e = z10;
            f14540g.put(a.f14516i, Boolean.valueOf(z10));
        }
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (f14539f) {
            booleanValue = f14540g.containsKey(str) ? f14540g.get(str).booleanValue() : true;
        }
        return booleanValue;
    }
}
