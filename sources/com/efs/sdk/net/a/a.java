package com.efs.sdk.net.a;

import java.util.HashMap;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f5444c;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, c> f5445a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, d> f5446b;

    private a() {
        b();
    }

    public static a a() {
        if (f5444c == null) {
            f5444c = new a();
        }
        return f5444c;
    }

    private void b() {
        if (this.f5445a == null) {
            this.f5445a = new HashMap<>();
        }
        this.f5445a.clear();
    }

    public final d c(String str) {
        if (this.f5446b == null) {
            this.f5446b = new HashMap<>();
        }
        if (this.f5446b.containsKey(str)) {
            return this.f5446b.get(str);
        }
        d dVar = new d();
        dVar.A = str;
        dVar.D = System.currentTimeMillis();
        this.f5446b.put(str, dVar);
        return dVar;
    }

    public final void d(String str) {
        HashMap<String, d> hashMap = this.f5446b;
        if (hashMap != null && hashMap.containsKey(str)) {
            this.f5446b.remove(str);
        }
    }

    public final c a(String str) {
        if (this.f5445a == null) {
            b();
        }
        c cVar = this.f5445a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.f5468a = str;
        cVar2.f5469b = System.currentTimeMillis();
        this.f5445a.put(str, cVar2);
        return cVar2;
    }

    public final void b(String str) {
        HashMap<String, c> hashMap = this.f5445a;
        if (hashMap != null && hashMap.containsKey(str)) {
            this.f5445a.remove(str);
        }
    }
}
