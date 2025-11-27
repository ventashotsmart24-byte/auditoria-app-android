package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.proto.b;
import com.umeng.commonsdk.statistics.proto.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f14934a = 10;

    /* renamed from: b  reason: collision with root package name */
    private final int f14935b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final String f14936c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f14937d;

    /* renamed from: e  reason: collision with root package name */
    private b f14938e;

    public a(String str) {
        this.f14936c = str;
    }

    private boolean g() {
        String str;
        int i10;
        b bVar = this.f14938e;
        if (bVar == null) {
            str = null;
        } else {
            str = bVar.b();
        }
        if (bVar == null) {
            i10 = 0;
        } else {
            i10 = bVar.h();
        }
        String a10 = a(f());
        if (a10 == null || a10.equals(str)) {
            return false;
        }
        if (bVar == null) {
            bVar = new b();
        }
        bVar.a(a10);
        bVar.a(System.currentTimeMillis());
        bVar.a(i10 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f14936c);
        aVar.c(a10);
        aVar.b(str);
        aVar.a(bVar.e());
        if (this.f14937d == null) {
            this.f14937d = new ArrayList(2);
        }
        this.f14937d.add(aVar);
        if (this.f14937d.size() > 10) {
            this.f14937d.remove(0);
        }
        this.f14938e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f14936c;
    }

    public boolean c() {
        b bVar = this.f14938e;
        if (bVar == null || bVar.h() <= 100) {
            return true;
        }
        return false;
    }

    public b d() {
        return this.f14938e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f14937d;
    }

    public abstract String f();

    public void a(b bVar) {
        this.f14938e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f14937d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() != 0 && !"0".equals(trim) && !"unknown".equals(trim.toLowerCase(Locale.US))) {
            return trim;
        }
        return null;
    }

    public void a(c cVar) {
        this.f14938e = cVar.c().get(this.f14936c);
        List<com.umeng.commonsdk.statistics.proto.a> h10 = cVar.h();
        if (h10 != null && h10.size() > 0) {
            if (this.f14937d == null) {
                this.f14937d = new ArrayList();
            }
            for (com.umeng.commonsdk.statistics.proto.a next : h10) {
                if (this.f14936c.equals(next.f15004a)) {
                    this.f14937d.add(next);
                }
            }
        }
    }
}
