package m9;

import java.lang.reflect.Method;
import t9.i;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f18984a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final a f18985b = new a((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    public static a f18986c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f18987a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f18988b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f18989c;

        public a(Method method, Method method2, Method method3) {
            this.f18987a = method;
            this.f18988b = method2;
            this.f18989c = method3;
        }
    }

    public final a a(a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f18986c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f18985b;
            f18986c = aVar3;
            return aVar3;
        }
    }

    public final String b(a aVar) {
        Object obj;
        Object obj2;
        Object obj3;
        i.g(aVar, "continuation");
        a aVar2 = f18986c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == f18985b) {
            return null;
        }
        Method method = aVar2.f18987a;
        if (method != null) {
            obj = method.invoke(aVar.getClass(), new Object[0]);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = aVar2.f18988b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, new Object[0]);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = aVar2.f18989c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, new Object[0]);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }
}
