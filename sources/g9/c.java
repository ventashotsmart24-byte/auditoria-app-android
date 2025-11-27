package g9;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17287a;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String r2 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x000b }
            r3 = r1
            goto L_0x000e
        L_0x000b:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x000e:
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0031
            java.lang.Class<g9.a> r6 = g9.a.class
            java.lang.Class r2 = r2.asSubclass(r6)     // Catch:{ all -> 0x002f }
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x002f }
            java.lang.Class<g9.d> r7 = g9.d.class
            r6[r4] = r7     // Catch:{ all -> 0x002f }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ all -> 0x002f }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x002f }
            g9.d r7 = g9.a.f17284a     // Catch:{ all -> 0x002f }
            r6[r4] = r7     // Catch:{ all -> 0x002f }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ all -> 0x002f }
            g9.a r2 = (g9.a) r2     // Catch:{ all -> 0x002f }
            goto L_0x0032
        L_0x002f:
            r2 = move-exception
            r3 = r2
        L_0x0031:
            r2 = r1
        L_0x0032:
            if (r2 == 0) goto L_0x0037
            f17287a = r2
            goto L_0x0040
        L_0x0037:
            g9.a r2 = new g9.a
            g9.d r6 = g9.a.f17284a
            r2.<init>(r6)
            f17287a = r2
        L_0x0040:
            if (r3 == 0) goto L_0x0097
            java.lang.String r2 = "io.perfmark.PerfMark.debug"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0097
            java.lang.String r2 = "java.util.logging.Logger"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r6 = "getLogger"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x0097 }
            r7[r4] = r0     // Catch:{ all -> 0x0097 }
            java.lang.reflect.Method r6 = r2.getMethod(r6, r7)     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0097 }
            java.lang.Class<g9.c> r8 = g9.c.class
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0097 }
            r7[r4] = r8     // Catch:{ all -> 0x0097 }
            java.lang.Object r6 = r6.invoke(r1, r7)     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = "java.util.logging.Level"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0097 }
            java.lang.String r8 = "FINE"
            java.lang.reflect.Field r8 = r7.getField(r8)     // Catch:{ all -> 0x0097 }
            java.lang.Object r1 = r8.get(r1)     // Catch:{ all -> 0x0097 }
            java.lang.String r8 = "log"
            r9 = 3
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch:{ all -> 0x0097 }
            r10[r4] = r7     // Catch:{ all -> 0x0097 }
            r10[r5] = r0     // Catch:{ all -> 0x0097 }
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            r7 = 2
            r10[r7] = r0     // Catch:{ all -> 0x0097 }
            java.lang.reflect.Method r0 = r2.getMethod(r8, r10)     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x0097 }
            r2[r4] = r1     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = "Error during PerfMark.<clinit>"
            r2[r5] = r1     // Catch:{ all -> 0x0097 }
            r2[r7] = r3     // Catch:{ all -> 0x0097 }
            r0.invoke(r6, r2)     // Catch:{ all -> 0x0097 }
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.c.<clinit>():void");
    }

    public static d a(String str) {
        return f17287a.a(str, Long.MIN_VALUE);
    }

    public static d b(String str, long j10) {
        return f17287a.a(str, j10);
    }

    public static void c(String str, d dVar) {
        f17287a.b(str, dVar);
    }

    public static void d(b bVar) {
        f17287a.c(bVar);
    }

    public static b e() {
        return f17287a.d();
    }

    public static void f(String str) {
        f17287a.e(str);
    }

    public static void g(String str, d dVar) {
        f17287a.f(str, dVar);
    }

    public static void h(String str) {
        f17287a.g(str);
    }

    public static void i(String str, d dVar) {
        f17287a.h(str, dVar);
    }
}
