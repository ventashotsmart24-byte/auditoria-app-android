package kotlinx.coroutines.internal;

import ba.t;
import i9.k;
import i9.o;
import i9.r;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import t9.i;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f18271a = new h();

    public final Object a(String str, ClassLoader classLoader, Class cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final List b(Class cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return r.G(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List c() {
        q qVar;
        Class<q> cls = q.class;
        if (!i.a()) {
            return b(cls, cls.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            q qVar2 = null;
            try {
                qVar = cls.cast(Class.forName("da.a", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                qVar = null;
            }
            if (qVar != null) {
                arrayList.add(qVar);
            }
            try {
                qVar2 = cls.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (qVar2 == null) {
                return arrayList;
            }
            arrayList.add(qVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(cls, cls.getClassLoader());
        }
    }

    public final List d(Class cls, ClassLoader classLoader) {
        ArrayList<T> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        i.f(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (T e10 : list) {
            o.n(arrayList, f18271a.e(e10));
        }
        Set<String> J = r.J(arrayList);
        if (!J.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(k.k(J, 10));
            for (String a10 : J) {
                arrayList2.add(f18271a.a(a10, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        q9.a.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        h9.a.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0075, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0076, code lost:
        q9.a.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List e(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "jar"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = ba.s.l(r0, r1, r2, r3, r4)
            if (r1 == 0) goto L_0x005b
            java.lang.String r6 = "jar:file:"
            java.lang.String r6 = ba.t.P(r0, r6, r4, r3, r4)
            r1 = 33
            java.lang.String r6 = ba.t.U(r6, r1, r4, r3, r4)
            java.lang.String r1 = "!/"
            java.lang.String r0 = ba.t.P(r0, r1, r4, r3, r4)
            java.util.jar.JarFile r1 = new java.util.jar.JarFile
            r1.<init>(r6, r2)
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x004f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x004f }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x004f }
            r3.<init>(r0)     // Catch:{ all -> 0x004f }
            java.io.InputStream r0 = r1.getInputStream(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ all -> 0x004f }
            r6.<init>(r2)     // Catch:{ all -> 0x004f }
            kotlinx.coroutines.internal.h r0 = f18271a     // Catch:{ all -> 0x0048 }
            java.util.List r0 = r0.f(r6)     // Catch:{ all -> 0x0048 }
            q9.a.a(r6, r4)     // Catch:{ all -> 0x004f }
            r1.close()
            return r0
        L_0x0048:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r2 = move-exception
            q9.a.a(r6, r0)     // Catch:{ all -> 0x004f }
            throw r2     // Catch:{ all -> 0x004f }
        L_0x004f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0056 }
            throw r0
        L_0x0056:
            r0 = move-exception
            h9.a.a(r6, r0)
            throw r6
        L_0x005b:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r6 = r6.openStream()
            r1.<init>(r6)
            r0.<init>(r1)
            kotlinx.coroutines.internal.h r6 = f18271a     // Catch:{ all -> 0x0073 }
            java.util.List r6 = r6.f(r0)     // Catch:{ all -> 0x0073 }
            q9.a.a(r0, r4)
            return r6
        L_0x0073:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r1 = move-exception
            q9.a.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.h.e(java.net.URL):java.util.List");
    }

    public final List f(BufferedReader bufferedReader) {
        boolean z10;
        boolean z11;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return r.G(linkedHashSet);
            }
            String obj = t.W(t.V(readLine, "#", (String) null, 2, (Object) null)).toString();
            boolean z12 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= obj.length()) {
                    z10 = true;
                    break;
                }
                char charAt = obj.charAt(i10);
                if (charAt == '.' || Character.isJavaIdentifierPart(charAt)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                if (obj.length() > 0) {
                    z12 = true;
                }
                if (z12) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
        }
    }
}
