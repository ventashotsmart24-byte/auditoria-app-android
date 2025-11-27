package z8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public final class v1 implements d1 {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f20998b = Logger.getLogger(v1.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final Constructor f20999c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f21000d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f21001e;

    /* renamed from: f  reason: collision with root package name */
    public static final RuntimeException f21002f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f21003g = {1L};

    /* renamed from: a  reason: collision with root package name */
    public final Object f21004a;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055 A[ADDED_TO_REGION] */
    static {
        /*
            java.lang.Class<z8.v1> r0 = z8.v1.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f20998b = r0
            r0 = 1
            r1 = 0
            r2 = 0
            java.lang.String r3 = "java.util.concurrent.atomic.LongAdder"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0046 }
            java.lang.String r4 = "add"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ all -> 0x0046 }
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch:{ all -> 0x0046 }
            r5[r1] = r6     // Catch:{ all -> 0x0046 }
            java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "sum"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x0043 }
            java.lang.reflect.Method r5 = r3.getMethod(r5, r6)     // Catch:{ all -> 0x0043 }
            java.lang.reflect.Constructor[] r3 = r3.getConstructors()     // Catch:{ all -> 0x0041 }
            int r6 = r3.length     // Catch:{ all -> 0x0041 }
            r7 = 0
        L_0x002f:
            if (r7 >= r6) goto L_0x003e
            r8 = r3[r7]     // Catch:{ all -> 0x0041 }
            java.lang.Class[] r9 = r8.getParameterTypes()     // Catch:{ all -> 0x0041 }
            int r9 = r9.length     // Catch:{ all -> 0x0041 }
            if (r9 != 0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            int r7 = r7 + 1
            goto L_0x002f
        L_0x003e:
            r8 = r2
        L_0x003f:
            r3 = r2
            goto L_0x0053
        L_0x0041:
            r3 = move-exception
            goto L_0x0049
        L_0x0043:
            r3 = move-exception
            r5 = r2
            goto L_0x0049
        L_0x0046:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x0049:
            java.util.logging.Logger r6 = f20998b
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            java.lang.String r8 = "LongAdder can not be found via reflection, this is normal for JDK7 and below"
            r6.log(r7, r8, r3)
            r8 = r2
        L_0x0053:
            if (r3 != 0) goto L_0x0060
            if (r8 == 0) goto L_0x0060
            f20999c = r8
            f21000d = r4
            f21001e = r5
            f21002f = r2
            goto L_0x006d
        L_0x0060:
            f20999c = r2
            f21000d = r2
            f21001e = r2
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r3)
            f21002f = r2
        L_0x006d:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0[r1] = r2
            f21003g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.v1.<clinit>():void");
    }

    public v1() {
        RuntimeException runtimeException = f21002f;
        if (runtimeException == null) {
            try {
                this.f21004a = f20999c.newInstance(new Object[0]);
            } catch (InstantiationException e10) {
                throw new RuntimeException(e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException(e12);
            }
        } else {
            throw runtimeException;
        }
    }

    public static boolean a() {
        if (f21002f == null) {
            return true;
        }
        return false;
    }

    public void add(long j10) {
        Object[] objArr;
        try {
            Method method = f21000d;
            Object obj = this.f21004a;
            if (j10 == 1) {
                objArr = f21003g;
            } else {
                objArr = new Object[]{Long.valueOf(j10)};
            }
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
