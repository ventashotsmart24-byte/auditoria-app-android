package r3;

import c4.o;
import d4.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.b;
import k3.j;
import r3.f0;
import r3.t;

public class k extends u {

    /* renamed from: d  reason: collision with root package name */
    public final t.a f9128d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9129e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public f0 f9130a;

        /* renamed from: b  reason: collision with root package name */
        public Method f9131b;

        /* renamed from: c  reason: collision with root package name */
        public o f9132c;

        public a(f0 f0Var, Method method, o oVar) {
            this.f9130a = f0Var;
            this.f9131b = method;
            this.f9132c = oVar;
        }

        public j a() {
            Method method = this.f9131b;
            if (method == null) {
                return null;
            }
            return new j(this.f9130a, method, this.f9132c.b(), (p[]) null);
        }
    }

    public k(b bVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f9128d = bVar == null ? null : aVar;
        this.f9129e = z10;
    }

    public static boolean k(Method method) {
        if (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) {
            return false;
        }
        return true;
    }

    public static l m(b bVar, f0 f0Var, t.a aVar, o oVar, j jVar, List list, Class cls, boolean z10) {
        return new k(bVar, aVar, z10).l(oVar, f0Var, jVar, list, cls);
    }

    public final void i(f0 f0Var, Class cls, Map map, Class cls2) {
        o oVar;
        if (cls2 != null) {
            j(f0Var, cls, map, cls2);
        }
        if (cls != null) {
            for (Method method : h.z(cls)) {
                if (k(method)) {
                    y yVar = new y(method);
                    a aVar = (a) map.get(yVar);
                    if (aVar == null) {
                        if (this.f9171a == null) {
                            oVar = o.e();
                        } else {
                            oVar = e(method.getDeclaredAnnotations());
                        }
                        map.put(yVar, new a(f0Var, method, oVar));
                    } else {
                        if (this.f9129e) {
                            aVar.f9132c = f(aVar.f9132c, method.getDeclaredAnnotations());
                        }
                        Method method2 = aVar.f9131b;
                        if (method2 == null) {
                            aVar.f9131b = method;
                        } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                            aVar.f9131b = method;
                            aVar.f9130a = f0Var;
                        }
                    }
                }
            }
        }
    }

    public void j(f0 f0Var, Class cls, Map map, Class cls2) {
        if (this.f9171a != null) {
            for (Class declaredMethods : h.w(cls2, cls, true)) {
                for (Method method : declaredMethods.getDeclaredMethods()) {
                    if (k(method)) {
                        y yVar = new y(method);
                        a aVar = (a) map.get(yVar);
                        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                        if (aVar == null) {
                            map.put(yVar, new a(f0Var, (Method) null, e(declaredAnnotations)));
                        } else {
                            aVar.f9132c = f(aVar.f9132c, declaredAnnotations);
                        }
                    }
                }
            }
        }
    }

    public l l(o oVar, f0 f0Var, j jVar, List list, Class cls) {
        boolean z10;
        Class a10;
        Class cls2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i(f0Var, jVar.q(), linkedHashMap, cls);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j jVar2 = (j) it.next();
            t.a aVar = this.f9128d;
            if (aVar == null) {
                cls2 = null;
            } else {
                cls2 = aVar.a(jVar2.q());
            }
            i(new f0.a(oVar, jVar2.j()), jVar2.q(), linkedHashMap, cls2);
        }
        t.a aVar2 = this.f9128d;
        Class<Object> cls3 = Object.class;
        if (aVar2 == null || (a10 = aVar2.a(cls3)) == null) {
            z10 = false;
        } else {
            j(f0Var, jVar.q(), linkedHashMap, a10);
            z10 = true;
        }
        if (z10 && this.f9171a != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                y yVar = (y) entry.getKey();
                if ("hashCode".equals(yVar.b()) && yVar.a() == 0) {
                    try {
                        Method declaredMethod = cls3.getDeclaredMethod(yVar.b(), new Class[0]);
                        if (declaredMethod != null) {
                            a aVar3 = (a) entry.getValue();
                            aVar3.f9132c = f(aVar3.f9132c, declaredMethod.getDeclaredAnnotations());
                            aVar3.f9131b = declaredMethod;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return new l();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            j a11 = ((a) entry2.getValue()).a();
            if (a11 != null) {
                linkedHashMap2.put(entry2.getKey(), a11);
            }
        }
        return new l(linkedHashMap2);
    }
}
