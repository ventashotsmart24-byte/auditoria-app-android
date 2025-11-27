package com.alibaba.sdk.android.httpdns.probe;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static IPProbeService f5017a;

    public static synchronized IPProbeService a(b bVar) {
        IPProbeService iPProbeService;
        synchronized (d.class) {
            if (f5017a == null) {
                e eVar = new e();
                f5017a = eVar;
                eVar.setIPListUpdateCallback(bVar);
            }
            iPProbeService = f5017a;
        }
        return iPProbeService;
    }
}
