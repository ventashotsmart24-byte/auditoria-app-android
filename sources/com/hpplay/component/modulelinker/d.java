package com.hpplay.component.modulelinker;

import android.app.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10559a = "ModuleLoadUtils";

    /* renamed from: b  reason: collision with root package name */
    private static ClassLoader f10560b;

    /* renamed from: c  reason: collision with root package name */
    private static ClassLoader f10561c;

    public static void a(ClassLoader classLoader) {
        f10560b = classLoader;
    }

    public static void b(ClassLoader classLoader) {
        f10561c = classLoader;
    }

    public static Application c() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, (Object[]) null), (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ClassLoader a() {
        return f10560b;
    }

    public static ClassLoader b() {
        return f10561c;
    }

    public static Object a(String str, String str2, Object... objArr) {
        Class a10 = a(str);
        if (a10 == null) {
            return null;
        }
        Method[] declaredMethods = a10.getDeclaredMethods();
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            if (!method.getName().equals(str2) || method.getParameterTypes().length != objArr.length) {
                i10++;
            } else {
                method.setAccessible(true);
                return method.invoke(a10, objArr);
            }
        }
        return null;
    }

    public static Object a(Object obj, String str, Object... objArr) {
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i10 = 0;
        while (i10 < length) {
            Method method = declaredMethods[i10];
            if (!method.getName().equals(str) || method.getParameterTypes().length != objArr.length) {
                i10++;
            } else {
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            }
        }
        return null;
    }

    public static Object a(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            declaredFields = cls.getFields();
        }
        for (Field field : declaredFields) {
            if (field.getName().equals(str)) {
                field.setAccessible(true);
                return field.get(obj);
            }
        }
        return null;
    }

    public static Object a(Object obj, Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object a(String str, String str2) {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get((Object) null);
    }

    public static void a(Object obj, String str, Object obj2) {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void a(String str, String str2, Object obj) {
        Class a10 = a(str);
        Field declaredField = a10.getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(a10, obj);
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Class a10 = a(str);
            if (a10 != null) {
                return a10.getConstructor(clsArr).newInstance(objArr);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(str.lastIndexOf("."), str.length()));
            sb.append(" not find ...");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Class a10 = a(str);
            return a10.getDeclaredMethod(str2, clsArr).invoke(a10, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            if (f10561c != null) {
                try {
                    return f10561c.loadClass(str);
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public static void a(Object obj) {
        if (obj != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.getType().toString().startsWith(Name.LABEL)) {
                    field.setAccessible(true);
                    field.set(obj, (Object) null);
                }
            }
        }
    }
}
