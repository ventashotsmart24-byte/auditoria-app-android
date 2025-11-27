package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

public class cm {
    public static cl a(Class<? extends cl> cls, int i10) {
        try {
            return (cl) cls.getMethod("findByValue", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i10)});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
