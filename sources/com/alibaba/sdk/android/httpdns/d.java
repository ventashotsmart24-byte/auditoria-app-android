package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.b.c;
import com.alibaba.sdk.android.httpdns.b.e;
import com.alibaba.sdk.android.httpdns.b.g;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import com.alibaba.sdk.android.httpdns.probe.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f4935a = new d();

    /* renamed from: a  reason: collision with other field name */
    private static IPProbeService f11a = com.alibaba.sdk.android.httpdns.probe.d.a(new b() {
        public void a(String str, String[] strArr) {
            e eVar;
            if (str != null && strArr != null && strArr.length != 0 && (eVar = (e) d.a().get(str)) != null) {
                e eVar2 = new e(str, strArr, eVar.a(), eVar.b(), eVar.a(), eVar.getCacheKey());
                d.a().put(str, eVar2);
                StringBuilder sb = new StringBuilder();
                for (int i10 = 0; i10 < eVar2.getIps().length; i10++) {
                    sb.append(eVar2.getIps()[i10] + ",");
                }
                i.f("optimized host:" + str + ", ip:" + sb.toString());
            }
        }
    });

    /* renamed from: a  reason: collision with other field name */
    private static ConcurrentMap<String, e> f12a;

    /* renamed from: a  reason: collision with other field name */
    private static ConcurrentSkipListSet<String> f13a;

    private d() {
        f12a = new ConcurrentHashMap();
        f13a = new ConcurrentSkipListSet<>();
    }

    public static d a() {
        return f4935a;
    }

    /* access modifiers changed from: private */
    public void b() {
        List<e> a10 = com.alibaba.sdk.android.httpdns.b.b.a();
        String i10 = com.alibaba.sdk.android.httpdns.b.b.i();
        for (e next : a10) {
            if (a(next)) {
                com.alibaba.sdk.android.httpdns.b.b.b(next);
            } else if (i10.equals(next.f4926m)) {
                next.f4927n = String.valueOf(System.currentTimeMillis() / 1000);
                e eVar = new e(next);
                f12a.put(next.host, eVar);
                if (com.alibaba.sdk.android.httpdns.b.b.g()) {
                    com.alibaba.sdk.android.httpdns.b.b.b(next);
                }
                a(next.host, eVar);
            }
        }
    }

    public void clear() {
        f12a.clear();
        f13a.clear();
    }

    public int count() {
        return f12a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public e m4a(String str) {
        return f12a.get(str);
    }

    public void b(String str) {
        f13a.remove(str);
    }

    private IPProbeItem a(String str) {
        List<IPProbeItem> list = f.f18a;
        if (list == null) {
            return null;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (str.equals(list.get(i10).getHostName())) {
                return list.get(i10);
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<String> m5a() {
        return new ArrayList<>(f12a.keySet());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m6a() {
        if (com.alibaba.sdk.android.httpdns.b.b.a() != null) {
            c.a().submit(new Runnable() {
                public void run() {
                    try {
                        d.this.b();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m7a(String str) {
        f13a.add(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8a(String str, e eVar) {
        ArrayList<g> arrayList;
        f12a.put(str, eVar);
        if (com.alibaba.sdk.android.httpdns.b.b.a() != null) {
            e a10 = eVar.a();
            ArrayList<g> arrayList2 = a10.f7a;
            if ((arrayList2 == null || arrayList2.size() <= 0) && ((arrayList = a10.f8b) == null || arrayList.size() <= 0)) {
                com.alibaba.sdk.android.httpdns.b.b.b(a10);
            } else {
                com.alibaba.sdk.android.httpdns.b.b.a(a10);
            }
        }
        a(str, eVar);
    }

    private boolean a(e eVar) {
        return (System.currentTimeMillis() / 1000) - c.a(eVar.f4927n) > 604800;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9a(String str) {
        return f13a.contains(str);
    }

    private boolean a(String str, e eVar) {
        IPProbeItem a10;
        if (eVar == null || eVar.getIps() == null || eVar.getIps().length <= 1 || f11a == null || (a10 = a(str)) == null) {
            return false;
        }
        if (f11a.getProbeStatus(str) == IPProbeService.a.PROBING) {
            f11a.stopIPProbeTask(str);
        }
        i.f("START PROBE");
        f11a.launchIPProbeTask(str, a10.getPort(), eVar.getIps());
        return true;
    }
}
