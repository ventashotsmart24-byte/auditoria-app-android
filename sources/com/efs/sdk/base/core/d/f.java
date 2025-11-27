package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.taobao.accs.common.Constants;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public c f5266a;

    /* renamed from: b  reason: collision with root package name */
    public ControllerCenter f5267b;

    /* renamed from: c  reason: collision with root package name */
    public d f5268c;

    /* renamed from: d  reason: collision with root package name */
    public g f5269d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final f f5270a = new f((byte) 0);
    }

    public /* synthetic */ f(byte b10) {
        this();
    }

    public final void a(String str, String str2, String str3) {
        this.f5269d.a(str, str2, str3);
    }

    private f() {
        this.f5266a = new c();
        this.f5268c = new d();
        this.f5269d = new g();
    }

    public final void a(int i10) {
        ControllerCenter controllerCenter = this.f5267b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i10));
        }
    }

    public final void a(int i10, String str) {
        if (this.f5267b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            b a10 = a("flow_limit_type", i10);
            a10.put(Constants.KEY_HTTP_CODE, str);
            this.f5267b.send(a10);
        }
    }

    public final b a(String str, int i10) {
        b bVar = new b("efs_core", str, this.f5266a.f5260c);
        bVar.put("cver", Integer.valueOf(i10));
        return bVar;
    }
}
