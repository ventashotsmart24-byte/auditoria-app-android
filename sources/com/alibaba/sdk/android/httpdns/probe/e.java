package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.a.a;
import com.alibaba.sdk.android.httpdns.c;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.i;
import com.alibaba.sdk.android.httpdns.probe.IPProbeService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class e implements IPProbeService {

    /* renamed from: a  reason: collision with root package name */
    private b f5018a = null;

    /* renamed from: a  reason: collision with other field name */
    private AtomicLong f35a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private f f5019b = new f() {
        public void a(long j10, c cVar) {
            if (cVar != null) {
                try {
                    if (e.a(e.this).containsKey(cVar.getHostName())) {
                        if (((Long) e.a(e.this).get(cVar.getHostName())).longValue() == j10) {
                            if (cVar.getIps() != null && cVar.j() != null && cVar.k() != null && cVar.getHostName() != null) {
                                i.e("defultId:" + cVar.j() + ", selectedIp:" + cVar.k() + ", promote:" + (cVar.c() - cVar.d()));
                                e.this.a(cVar.getHostName(), cVar.j(), cVar.k(), cVar.c(), cVar.d(), cVar.getIps().length);
                                e.a(e.this).a(cVar.getHostName(), cVar.getIps());
                                e.a(e.this).remove(cVar.getHostName());
                                return;
                            }
                            return;
                        }
                    }
                    i.d("corresponding tasknumber not exists, drop the result");
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5020c = new ConcurrentHashMap<>();

    public IPProbeService.a getProbeStatus(String str) {
        return this.f5020c.containsKey(str) ? IPProbeService.a.PROBING : IPProbeService.a.NO_PROBING;
    }

    public void launchIPProbeTask(String str, int i10, String[] strArr) {
        if (!a.a().f()) {
            i.f("ip probe is forbidden");
        } else if (getProbeStatus(str) == IPProbeService.a.NO_PROBING) {
            long addAndGet = this.f35a.addAndGet(1);
            this.f5020c.put(str, Long.valueOf(addAndGet));
            c.a().execute(new a(addAndGet, str, strArr, i10, this.f5019b));
        } else {
            i.f("already launch the same task, drop the task");
        }
    }

    public void setIPListUpdateCallback(b bVar) {
        this.f5018a = bVar;
    }

    public boolean stopIPProbeTask(String str) {
        if (!this.f5020c.containsKey(str)) {
            return false;
        }
        i.d("stop ip probe task for host:" + str);
        this.f5020c.remove(str);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, long j10, long j11, int i10) {
        b a10 = b.a();
        if (a10 != null) {
            a10.a(str, str2, str3, j10, j11, i10);
        }
    }
}
