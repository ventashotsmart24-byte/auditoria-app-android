package xa;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class m {

    /* renamed from: d  reason: collision with root package name */
    public static final Map f9788d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final a[] f9789e = new a[4];

    /* renamed from: a  reason: collision with root package name */
    public List f9790a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9791b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9792c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List f9793a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Map f9794b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public final Map f9795c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final StringBuilder f9796d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        public Class f9797e;

        /* renamed from: f  reason: collision with root package name */
        public Class f9798f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9799g;

        public boolean a(Method method, Class cls) {
            Object put = this.f9794b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f9794b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class cls) {
            this.f9796d.setLength(0);
            this.f9796d.append(method.getName());
            StringBuilder sb = this.f9796d;
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
            sb.append(cls.getName());
            String sb2 = this.f9796d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.f9795c.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f9795c.put(sb2, cls2);
            return false;
        }

        public void c(Class cls) {
            this.f9798f = cls;
            this.f9797e = cls;
            this.f9799g = false;
        }

        public void d() {
            if (this.f9799g) {
                this.f9798f = null;
                return;
            }
            Class superclass = this.f9798f.getSuperclass();
            this.f9798f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f9798f = null;
            }
        }

        public void e() {
            this.f9793a.clear();
            this.f9794b.clear();
            this.f9795c.clear();
            this.f9796d.setLength(0);
            this.f9797e = null;
            this.f9798f = null;
            this.f9799g = false;
        }
    }

    public m(List list, boolean z10, boolean z11) {
        this.f9790a = list;
        this.f9791b = z10;
        this.f9792c = z11;
    }

    public List a(Class cls) {
        List list;
        Map map = f9788d;
        List list2 = (List) map.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f9792c) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            map.put(cls, list);
            return list;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List b(Class cls) {
        a g10 = g();
        g10.c(cls);
        while (g10.f9798f != null) {
            f(g10);
            d(g10);
            g10.d();
        }
        return e(g10);
    }

    public final List c(Class cls) {
        a g10 = g();
        g10.c(cls);
        while (g10.f9798f != null) {
            d(g10);
            g10.d();
        }
        return e(g10);
    }

    public final void d(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f9798f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f9798f.getMethods();
            aVar.f9799g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            Class cls = j.class;
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    j jVar = (j) method.getAnnotation(cls);
                    if (jVar != null) {
                        Class cls2 = parameterTypes[0];
                        if (aVar.a(method, cls2)) {
                            aVar.f9793a.add(new l(method, cls2, jVar.threadMode(), jVar.priority(), jVar.sticky()));
                        }
                    }
                } else if (this.f9791b && method.isAnnotationPresent(cls)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f9791b && method.isAnnotationPresent(cls)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f9793a);
        aVar.e();
        synchronized (f9789e) {
            int i10 = 0;
            while (true) {
                if (i10 >= 4) {
                    break;
                }
                a[] aVarArr = f9789e;
                if (aVarArr[i10] == null) {
                    aVarArr[i10] = aVar;
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    public final ya.a f(a aVar) {
        aVar.getClass();
        List list = this.f9790a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return null;
    }

    public final a g() {
        synchronized (f9789e) {
            for (int i10 = 0; i10 < 4; i10++) {
                a[] aVarArr = f9789e;
                a aVar = aVarArr[i10];
                if (aVar != null) {
                    aVarArr[i10] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
