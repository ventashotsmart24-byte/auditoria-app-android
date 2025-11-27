package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f5261b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    public AtomicInteger f5262c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    private AtomicInteger f5263d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private AtomicInteger f5264e = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    private AtomicInteger f5265f = new AtomicInteger(0);

    public final void a() {
        if ((this.f5263d.get() != 0 || this.f5264e.get() != 0 || this.f5261b.get() != 0 || this.f5262c.get() != 0 || this.f5265f.get() != 0) && this.f5251a != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            ControllerCenter controllerCenter = this.f5251a;
            int i10 = this.f5263d.get();
            int i11 = this.f5264e.get();
            int i12 = this.f5261b.get();
            int i13 = this.f5262c.get();
            int i14 = this.f5265f.get();
            b bVar = new b("efs_core", "lf_st", f.a.f5270a.f5266a.f5260c);
            bVar.put("create_cnt", Integer.valueOf(i10));
            bVar.put("cache_cnt", Integer.valueOf(i11));
            bVar.put("req_cnt", Integer.valueOf(i12));
            bVar.put("err_cnt", Integer.valueOf(i13));
            bVar.put("expire_cnt", Integer.valueOf(i14));
            this.f5263d.addAndGet(i10 * -1);
            this.f5264e.addAndGet(i11 * -1);
            this.f5261b.addAndGet(i12 * -1);
            this.f5262c.addAndGet(i13 * -1);
            this.f5265f.addAndGet(i14 * -1);
            controllerCenter.send(bVar);
        }
    }

    public final void b() {
        this.f5263d.incrementAndGet();
    }

    public final void c() {
        this.f5264e.incrementAndGet();
    }

    public final void d() {
        this.f5265f.incrementAndGet();
    }
}
