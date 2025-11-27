package com.umeng.powersdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    int f16183a;

    /* renamed from: b  reason: collision with root package name */
    int f16184b;

    /* renamed from: c  reason: collision with root package name */
    int f16185c;

    /* renamed from: d  reason: collision with root package name */
    WeakReference<Activity> f16186d;

    /* renamed from: e  reason: collision with root package name */
    boolean f16187e;

    /* renamed from: f  reason: collision with root package name */
    int f16188f;

    /* renamed from: g  reason: collision with root package name */
    boolean f16189g;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f16199a = new c((byte) 0);
    }

    private c() {
        this.f16183a = 1;
        this.f16184b = 0;
        this.f16185c = 0;
        this.f16187e = true;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0098 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008e A[Catch:{ all -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009c A[Catch:{ all -> 0x00af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x003a }
            r2 = 21
            if (r1 < r2) goto L_0x003a
            android.content.Context r1 = com.umeng.powersdk.PowerManager.getApplicationContext()     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "batterymanager"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x003a }
            android.os.BatteryManager r1 = (android.os.BatteryManager) r1     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x003a
            r2 = 2
            long r1 = r1.getLongProperty(r2)     // Catch:{ all -> 0x003a }
            float r1 = (float) r1     // Catch:{ all -> 0x003a }
            r2 = 1176256512(0x461c4000, float:10000.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x002d
            r2 = -971227136(0xffffffffc61c4000, float:-10000.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
        L_0x002d:
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
        L_0x0030:
            java.lang.String r2 = "ci"
            float r1 = java.lang.Math.abs(r1)     // Catch:{ all -> 0x003a }
            double r3 = (double) r1     // Catch:{ all -> 0x003a }
            r0.put(r2, r3)     // Catch:{ all -> 0x003a }
        L_0x003a:
            android.content.Context r1 = com.umeng.powersdk.PowerManager.getApplicationContext()     // Catch:{ all -> 0x00af }
            com.umeng.powersdk.b r1 = com.umeng.powersdk.b.a(r1)     // Catch:{ all -> 0x00af }
            com.umeng.powersdk.a r1 = r1.a()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "le"
            int r3 = r1.f16175a     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "vo"
            int r3 = r1.f16176b     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "te"
            int r3 = r1.f16177c     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "st"
            int r3 = r1.f16178d     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "ch"
            int r3 = r1.f16179e     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "ts"
            long r3 = r1.f16180f     // Catch:{ all -> 0x00af }
            r0.put(r2, r3)     // Catch:{ all -> 0x00af }
            com.efs.sdk.base.core.config.GlobalInfoManager r1 = com.efs.sdk.base.core.config.GlobalInfoManager.getInstance()     // Catch:{ all -> 0x0098 }
            com.efs.sdk.base.core.config.GlobalInfo r1 = r1.getGlobalInfo()     // Catch:{ all -> 0x0098 }
            java.util.Map r1 = r1.getGlobalInfoMap()     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = "stime"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0098 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0098 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x0098 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0098
            java.lang.String r3 = "ptime"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0098 }
            long r4 = r4 - r1
            r0.put(r3, r4)     // Catch:{ all -> 0x0098 }
        L_0x0098:
            java.lang.ref.WeakReference<android.app.Activity> r1 = r6.f16186d     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x00af
            java.lang.String r2 = "c_act"
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00af }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ all -> 0x00af }
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x00af }
            r0.put(r2, r1)     // Catch:{ all -> 0x00af }
        L_0x00af:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.powersdk.c.a():org.json.JSONObject");
    }

    public /* synthetic */ c(byte b10) {
        this();
    }
}
