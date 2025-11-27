package r3;

import c4.o;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.b;
import k3.j;
import r3.f0;
import r3.t;

public class h extends u {

    /* renamed from: d  reason: collision with root package name */
    public final o f9112d;

    /* renamed from: e  reason: collision with root package name */
    public final t.a f9113e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f9114f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final f0 f9115a;

        /* renamed from: b  reason: collision with root package name */
        public final Field f9116b;

        /* renamed from: c  reason: collision with root package name */
        public o f9117c = o.e();

        public a(f0 f0Var, Field field) {
            this.f9115a = f0Var;
            this.f9116b = field;
        }

        public g a() {
            return new g(this.f9115a, this.f9116b, this.f9117c.b());
        }
    }

    public h(b bVar, o oVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f9112d = oVar;
        this.f9113e = bVar == null ? null : aVar;
        this.f9114f = z10;
    }

    public static List m(b bVar, f0 f0Var, t.a aVar, o oVar, j jVar, boolean z10) {
        return new h(bVar, oVar, aVar, z10).l(f0Var, jVar);
    }

    public final void i(Class cls, Class cls2, Map map) {
        a aVar;
        for (Class declaredFields : d4.h.x(cls, cls2, true)) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (k(field) && (aVar = (a) map.get(field.getName())) != null) {
                    aVar.f9117c = d(aVar.f9117c, field.getDeclaredAnnotations());
                }
            }
        }
    }

    public final Map j(f0 f0Var, j jVar, Map map) {
        t.a aVar;
        Class a10;
        j s10 = jVar.s();
        if (s10 == null) {
            return map;
        }
        Class q10 = jVar.q();
        Map j10 = j(new f0.a(this.f9112d, s10.j()), s10, map);
        for (Field field : q10.getDeclaredFields()) {
            if (k(field)) {
                if (j10 == null) {
                    j10 = new LinkedHashMap();
                }
                a aVar2 = new a(f0Var, field);
                if (this.f9114f) {
                    aVar2.f9117c = d(aVar2.f9117c, field.getDeclaredAnnotations());
                }
                j10.put(field.getName(), aVar2);
            }
        }
        if (!(j10 == null || (aVar = this.f9113e) == null || (a10 = aVar.a(q10)) == null)) {
            i(a10, q10, j10);
        }
        return j10;
    }

    public final boolean k(Field field) {
        if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
            return true;
        }
        return false;
    }

    public List l(f0 f0Var, j jVar) {
        Map j10 = j(f0Var, jVar, (Map) null);
        if (j10 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(j10.size());
        for (a a10 : j10.values()) {
            arrayList.add(a10.a());
        }
        return arrayList;
    }
}
