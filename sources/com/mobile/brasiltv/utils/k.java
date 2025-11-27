package com.mobile.brasiltv.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f12594a = new k();

    /* renamed from: b  reason: collision with root package name */
    public static Map f12595b = new LinkedHashMap();

    public final void a() {
        f12595b.clear();
    }

    public final long b(String str) {
        i.g(str, "key");
        Long l10 = (Long) f12595b.get(str);
        if (l10 == null) {
            l10 = 0L;
        }
        return l10.longValue();
    }

    public final void c(String str, long j10) {
        i.g(str, "key");
        f12595b.put(str, Long.valueOf(j10));
    }
}
