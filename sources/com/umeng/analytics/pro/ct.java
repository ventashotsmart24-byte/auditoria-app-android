package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ct implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends ch>, Map<? extends co, ct>> f14062d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f14063a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f14064b;

    /* renamed from: c  reason: collision with root package name */
    public final cu f14065c;

    public ct(String str, byte b10, cu cuVar) {
        this.f14063a = str;
        this.f14064b = b10;
        this.f14065c = cuVar;
    }

    public static void a(Class<? extends ch> cls, Map<? extends co, ct> map) {
        f14062d.put(cls, map);
    }

    public static Map<? extends co, ct> a(Class<? extends ch> cls) {
        if (!f14062d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e10) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e10.getMessage());
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e11.getMessage());
            }
        }
        return f14062d.get(cls);
    }
}
