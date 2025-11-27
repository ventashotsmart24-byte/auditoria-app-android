package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g extends a {

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f5271b = new ConcurrentHashMap<>(10);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f5272a;

        /* renamed from: b  reason: collision with root package name */
        String f5273b;

        /* renamed from: c  reason: collision with root package name */
        String f5274c;

        /* renamed from: d  reason: collision with root package name */
        AtomicInteger f5275d = new AtomicInteger(0);

        public a(String str, String str2, String str3) {
            this.f5272a = str;
            this.f5273b = str2;
            this.f5274c = str3;
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.f5271b.containsKey(str4) || this.f5271b.get(str4) == null) {
            this.f5271b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.f5271b.get(str4).f5275d.incrementAndGet();
    }

    public final void a() {
        try {
            if (this.f5251a == null) {
                return;
            }
            if (ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                for (Map.Entry<String, a> value : this.f5271b.entrySet()) {
                    a aVar = (a) value.getValue();
                    int i10 = aVar.f5275d.get();
                    if (i10 > 0) {
                        ControllerCenter controllerCenter = this.f5251a;
                        String str = aVar.f5272a;
                        String str2 = aVar.f5273b;
                        String str3 = aVar.f5274c;
                        b bVar = new b("efs_core", "req_succ_rate", f.a.f5270a.f5266a.f5260c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", Integer.valueOf(i10));
                        controllerCenter.send(bVar);
                        aVar.f5275d.addAndGet(i10 * -1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
