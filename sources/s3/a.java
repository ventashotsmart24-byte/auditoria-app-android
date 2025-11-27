package s3;

import b3.h;
import d4.h;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k3.f;
import k3.g;
import r3.e;

public abstract class a {

    /* renamed from: s3.a$a  reason: collision with other inner class name */
    public static class C0122a {

        /* renamed from: a  reason: collision with root package name */
        public final k3.c f9322a;

        /* renamed from: b  reason: collision with root package name */
        public final f f9323b;

        /* renamed from: c  reason: collision with root package name */
        public final k3.b f9324c;

        /* renamed from: d  reason: collision with root package name */
        public final List f9325d;

        /* renamed from: e  reason: collision with root package name */
        public final e f9326e;

        /* renamed from: f  reason: collision with root package name */
        public final b[] f9327f;

        public C0122a(g gVar, k3.c cVar) {
            e eVar;
            this.f9322a = cVar;
            this.f9324c = gVar.K();
            this.f9323b = gVar.k();
            b[] b10 = c.c().b(cVar.s());
            this.f9327f = b10;
            int length = b10.length;
            if (length != 0) {
                List v10 = cVar.v();
                this.f9325d = v10;
                Iterator it = v10.iterator();
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        eVar = null;
                        break;
                    }
                    e eVar2 = (e) it.next();
                    if (eVar2.v() == length) {
                        int i10 = 0;
                        while (i10 < length) {
                            if (eVar2.x(i10).equals(this.f9327f[i10].f9328a)) {
                                i10++;
                            }
                        }
                        eVar = eVar2;
                        break loop0;
                    }
                }
            } else {
                eVar = cVar.d();
                this.f9325d = Collections.singletonList(eVar);
            }
            if (eVar != null) {
                this.f9326e = eVar;
                return;
            }
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + h.G(this.f9322a.z()));
        }

        public e a(List list) {
            for (e eVar : this.f9325d) {
                h.a h10 = this.f9324c.h(this.f9323b, eVar);
                if (!(h10 == null || h.a.DISABLED == h10)) {
                    if (h.a.DELEGATING == h10 || eVar != this.f9326e) {
                        return null;
                    }
                }
            }
            for (b bVar : this.f9327f) {
                list.add(bVar.f9329b);
            }
            return this.f9326e;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class f9328a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9329b;

        public b(Class cls, String str) {
            this.f9328a = cls;
            this.f9329b = str;
        }
    }

    public static class c {

        /* renamed from: d  reason: collision with root package name */
        public static final c f9330d;

        /* renamed from: e  reason: collision with root package name */
        public static final RuntimeException f9331e;

        /* renamed from: a  reason: collision with root package name */
        public final Method f9332a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f9333b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f9334c;

        static {
            c cVar = null;
            try {
                e = null;
                cVar = new c();
            } catch (RuntimeException e10) {
                e = e10;
            }
            f9330d = cVar;
            f9331e = e;
        }

        public c() {
            try {
                this.f9332a = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.f9333b = cls.getMethod("getName", new Class[0]);
                this.f9334c = cls.getMethod("getType", new Class[0]);
            } catch (Exception e10) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", new Object[]{e10.getClass().getName(), e10.getMessage()}), e10);
            }
        }

        public static c c() {
            RuntimeException runtimeException = f9331e;
            if (runtimeException == null) {
                return f9330d;
            }
            throw runtimeException;
        }

        public String[] a(Class cls) {
            Object[] d10 = d(cls);
            String[] strArr = new String[d10.length];
            int i10 = 0;
            while (i10 < d10.length) {
                try {
                    strArr[i10] = (String) this.f9333b.invoke(d10[i10], new Object[0]);
                    i10++;
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)}), e10);
                }
            }
            return strArr;
        }

        public b[] b(Class cls) {
            Object[] d10 = d(cls);
            b[] bVarArr = new b[d10.length];
            int i10 = 0;
            while (i10 < d10.length) {
                try {
                    try {
                        bVarArr[i10] = new b((Class) this.f9334c.invoke(d10[i10], new Object[0]), (String) this.f9333b.invoke(d10[i10], new Object[0]));
                        i10++;
                    } catch (Exception e10) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)}), e10);
                    }
                } catch (Exception e11) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", new Object[]{Integer.valueOf(i10), Integer.valueOf(d10.length), d4.h.X(cls)}), e11);
                }
            }
            return bVarArr;
        }

        public Object[] d(Class cls) {
            try {
                return (Object[]) this.f9332a.invoke(cls, new Object[0]);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + d4.h.X(cls));
            }
        }
    }

    public static e a(g gVar, k3.c cVar, List list) {
        return new C0122a(gVar, cVar).a(list);
    }

    public static String[] b(Class cls) {
        return c.c().a(cls);
    }
}
