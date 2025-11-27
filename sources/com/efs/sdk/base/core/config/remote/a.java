package com.efs.sdk.base.core.config.remote;

import com.efs.sdk.base.IConfigRefreshAction;

public final class a implements IConfigRefreshAction {

    /* renamed from: com.efs.sdk.base.core.config.remote.a$a  reason: collision with other inner class name */
    public static class C0075a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f5221a = new a();
    }

    public static a a() {
        return C0075a.f5221a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b2, code lost:
        com.efs.sdk.base.core.util.Log.i("efs.config", "config request succ, config is:\n ".concat(java.lang.String.valueOf(r2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bf, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String refresh() {
        /*
            r11 = this;
            com.efs.sdk.base.core.config.GlobalEnvStruct r0 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r0 = r0.mAppContext
            boolean r0 = com.efs.sdk.base.core.util.NetworkUtil.isConnected(r0)
            java.lang.String r1 = "efs.config"
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "Config refresh fail, network is disconnected."
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r1, (java.lang.String) r0)
            return r2
        L_0x0016:
            com.efs.sdk.base.core.config.remote.b r0 = com.efs.sdk.base.core.config.remote.b.a()
            r3 = 1
            java.lang.String r0 = r0.a((boolean) r3)
            com.efs.sdk.base.core.a.c r4 = com.efs.sdk.base.core.a.c.a()
            r5 = 0
        L_0x0024:
            r6 = 3
            if (r5 >= r6) goto L_0x00b2
            com.efs.sdk.base.core.a.a r6 = com.efs.sdk.base.core.a.a.a()
            java.lang.String r7 = r4.b()
            boolean r8 = r6.f5121a
            java.lang.String r9 = "efs.px.api"
            if (r8 == 0) goto L_0x0042
            java.lang.String r8 = java.lang.String.valueOf(r7)
            java.lang.String r10 = "get config from server, wpkHeader is "
            java.lang.String r8 = r10.concat(r8)
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r9, (java.lang.String) r8)
        L_0x0042:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r10 = "/apm_cc"
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            boolean r6 = r6.f5121a
            if (r6 == 0) goto L_0x0064
            java.lang.String r6 = java.lang.String.valueOf(r8)
            java.lang.String r10 = "get config from server, url is "
            java.lang.String r6 = r10.concat(r6)
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r9, (java.lang.String) r6)
        L_0x0064:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r3)
            java.lang.String r9 = "wpk-header"
            r6.put(r9, r7)
            com.efs.sdk.base.core.util.a.d r7 = new com.efs.sdk.base.core.util.a.d
            r7.<init>(r8)
            com.efs.sdk.base.core.util.a.d r6 = r7.a((java.util.Map<java.lang.String, java.lang.String>) r6)
            com.efs.sdk.base.core.a.b r7 = com.efs.sdk.base.core.a.b.a()
            com.efs.sdk.base.core.util.a.d r6 = r6.a((com.efs.sdk.base.http.AbsHttpListener) r7)
            com.efs.sdk.base.core.util.a.c r6 = r6.a()
            com.efs.sdk.base.core.util.a.b r7 = r6.f5308a
            java.lang.String r8 = "get"
            r7.f5305e = r8
            java.lang.Object r6 = r6.a()
            com.efs.sdk.base.http.HttpResponse r6 = (com.efs.sdk.base.http.HttpResponse) r6
            boolean r7 = r6.succ
            if (r7 == 0) goto L_0x0096
            java.lang.String r2 = r6.data
            goto L_0x00b2
        L_0x0096:
            java.lang.String r7 = r6.getBizCode()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00b1
            java.lang.String r7 = "1000"
            java.lang.String r6 = r6.getBizCode()
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            int r5 = r5 + 1
            goto L_0x0024
        L_0x00b1:
            return r2
        L_0x00b2:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "config request succ, config is:\n "
            java.lang.String r0 = r3.concat(r0)
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r1, (java.lang.String) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.config.remote.a.refresh():java.lang.String");
    }
}
