package ua;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import wa.a;
import wa.b;

public class f {

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap f19653h = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public String f19654a;

    /* renamed from: b  reason: collision with root package name */
    public String f19655b;

    /* renamed from: c  reason: collision with root package name */
    public a f19656c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f19657d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f19658e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f19659f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public boolean f19660g;

    public static f a(Class cls) {
        if (cls != null) {
            f fVar = (f) f19653h.get(cls.getName());
            if (fVar == null) {
                fVar = new f();
                fVar.h(a.f(cls));
                fVar.f(cls.getName());
                Field c10 = a.c(cls);
                if (c10 != null) {
                    a aVar = new a();
                    aVar.e(b.c(c10));
                    aVar.i(c10.getName());
                    aVar.k(b.f(cls, c10));
                    aVar.j(b.e(cls, c10));
                    aVar.f(c10.getType());
                    fVar.g(aVar);
                    List<e> e10 = a.e(cls);
                    if (e10 != null) {
                        for (e eVar : e10) {
                            if (eVar != null) {
                                fVar.f19657d.put(eVar.a(), eVar);
                            }
                        }
                    }
                    List<c> a10 = a.a(cls);
                    if (a10 != null) {
                        for (c cVar : a10) {
                            if (cVar != null) {
                                fVar.f19659f.put(cVar.a(), cVar);
                            }
                        }
                    }
                    List<d> b10 = a.b(cls);
                    if (b10 != null) {
                        for (d dVar : b10) {
                            if (dVar != null) {
                                fVar.f19658e.put(dVar.a(), dVar);
                            }
                        }
                    }
                    f19653h.put(cls.getName(), fVar);
                } else {
                    throw new va.b("the class[" + cls + "]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception");
                }
            }
            return fVar;
        }
        throw new va.b("table info get error,because the clazz is null");
    }

    public a b() {
        return this.f19656c;
    }

    public String c() {
        return this.f19655b;
    }

    public boolean d() {
        return this.f19660g;
    }

    public void e(boolean z10) {
        this.f19660g = z10;
    }

    public void f(String str) {
        this.f19654a = str;
    }

    public void g(a aVar) {
        this.f19656c = aVar;
    }

    public void h(String str) {
        this.f19655b = str;
    }
}
