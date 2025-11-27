package com.umeng.ut.b.a.a;

class e {
    public static String get(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e10) {
            com.umeng.ut.a.c.e.b("", e10, new Object[0]);
            return str2;
        }
    }
}
