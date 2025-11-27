package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class aw {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        Class<?> a10;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a10 = a(str)) == null) {
            return null;
        }
        try {
            return a10.getDeclaredMethod(str2, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method a10 = a(str, str2, clsArr);
        if (a10 != null) {
            return a(a10, obj, objArr);
        }
        return null;
    }

    public static Field a(String str, String str2) {
        Class<?> a10;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a10 = a(str)) == null) {
            return null;
        }
        try {
            return a10.getField(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str, str2), obj);
    }

    public static Object a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> a10 = a(str);
        if (a10 == null) {
            return null;
        }
        try {
            return a10.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return java.lang.Class.forName(r3, true, r1.getClassLoader());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> a(java.lang.String r3) {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r0 = r0.getContextClassLoader()
            java.lang.Class<com.umeng.analytics.pro.aw> r1 = com.umeng.analytics.pro.aw.class
            if (r0 != 0) goto L_0x0010
            java.lang.ClassLoader r0 = r1.getClassLoader()
        L_0x0010:
            r2 = 1
            java.lang.Class r3 = java.lang.Class.forName(r3, r2, r0)     // Catch:{ all -> 0x0016 }
            return r3
        L_0x0016:
            java.lang.ClassLoader r0 = r1.getClassLoader()     // Catch:{ all -> 0x001f }
            java.lang.Class r3 = java.lang.Class.forName(r3, r2, r0)     // Catch:{ all -> 0x001f }
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.aw.a(java.lang.String):java.lang.Class");
    }
}
