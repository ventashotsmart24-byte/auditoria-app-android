package com.efs.sdk.net;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import java.util.Random;

public class NetConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f5405a = "NetConfigManager";

    /* renamed from: b  reason: collision with root package name */
    private final int f5406b = 0;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f5407c;

    /* renamed from: d  reason: collision with root package name */
    private int f5408d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f5409e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f5410f;

    /* renamed from: g  reason: collision with root package name */
    private int f5411g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f5412h = 100;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f5413i = 10;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5414j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Context f5415k;

    /* renamed from: l  reason: collision with root package name */
    private int f5416l = -1;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5417m = false;

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NetConfigManager(android.content.Context r20, com.efs.sdk.base.EfsReporter r21) {
        /*
            r19 = this;
            r0 = r19
            r19.<init>()
            java.lang.String r1 = "NetConfigManager"
            r0.f5405a = r1
            r2 = 0
            r0.f5406b = r2
            r0.f5408d = r2
            r0.f5409e = r2
            r3 = 100
            r0.f5412h = r3
            r4 = 10
            r0.f5413i = r4
            r0.f5414j = r2
            r4 = -1
            r0.f5416l = r4
            r0.f5417m = r2
            android.content.Context r5 = r20.getApplicationContext()
            r0.f5415k = r5
            r6 = r21
            r0.f5407c = r6
            java.lang.String r6 = "net_launch"
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r6, r2)
            java.lang.String r7 = "apm_netperf_extra_last"
            java.lang.String r8 = "apm_netperf_sampling_rate_last"
            if (r5 == 0) goto L_0x0041
            int r9 = r5.getInt(r8, r2)
            r0.f5410f = r9
            int r5 = r5.getInt(r7, r2)
            r0.f5411g = r5
        L_0x0041:
            android.content.Context r5 = r0.f5415k
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r6, r2)
            java.lang.String r9 = "apm_netperf_extra"
            java.lang.String r10 = "apm_netperf_sampling_rate"
            if (r5 == 0) goto L_0x0058
            int r11 = r5.getInt(r10, r4)
            int r5 = r5.getInt(r9, r4)
            r0.f5409e = r5
            goto L_0x0059
        L_0x0058:
            r11 = -1
        L_0x0059:
            com.efs.sdk.base.EfsReporter r5 = r0.f5407c
            java.lang.String r12 = "apm_netperf_day_limit"
            java.lang.String r13 = "apm_netperf_data_rate"
            java.lang.String[] r9 = new java.lang.String[]{r10, r12, r13, r9}
            com.efs.sdk.net.NetConfigManager$1 r10 = new com.efs.sdk.net.NetConfigManager$1
            r10.<init>()
            r5.getAllSdkConfig(r9, r10)
            if (r11 == r4) goto L_0x006f
            r0.f5408d = r11
        L_0x006f:
            boolean r4 = com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()
            if (r4 == 0) goto L_0x0078
        L_0x0075:
            r1 = 1
            goto L_0x0153
        L_0x0078:
            android.content.Context r4 = r0.f5415k
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r6, r2)
            java.lang.String r9 = "03f870871950c148387b251894ed3e88"
            r10 = 0
            if (r4 == 0) goto L_0x0089
            long r14 = r4.getLong(r9, r10)
            goto L_0x008a
        L_0x0089:
            r14 = r10
        L_0x008a:
            java.lang.String r5 = "8f2f54c08600aa25915617fa1371441b"
            if (r4 == 0) goto L_0x0093
            boolean r16 = r4.getBoolean(r5, r2)
            goto L_0x0095
        L_0x0093:
            r16 = 0
        L_0x0095:
            int r3 = r0.f5408d
            if (r3 != 0) goto L_0x00be
            if (r16 == 0) goto L_0x00a9
            if (r4 == 0) goto L_0x00a9
            android.content.SharedPreferences$Editor r1 = r4.edit()
            if (r1 == 0) goto L_0x00a9
            r1.putBoolean(r5, r2)
            r1.commit()
        L_0x00a9:
            int r1 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r1 == 0) goto L_0x00bb
            if (r4 == 0) goto L_0x00bb
            android.content.SharedPreferences$Editor r1 = r4.edit()
            if (r1 == 0) goto L_0x00bb
            r1.putLong(r9, r10)
            r1.commit()
        L_0x00bb:
            r1 = 0
            goto L_0x0153
        L_0x00be:
            int r4 = r0.f5409e
            int r3 = java.lang.Math.max(r3, r4)
            int r4 = r0.f5410f
            int r10 = r0.f5411g
            int r4 = java.lang.Math.max(r4, r10)
            if (r3 == r4) goto L_0x00d0
            r3 = 1
            goto L_0x00d1
        L_0x00d0:
            r3 = 0
        L_0x00d1:
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            int r10 = r0.f5408d
            int r11 = r0.f5409e
            int r10 = java.lang.Math.max(r10, r11)
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.Long r11 = java.lang.Long.valueOf(r14)
            long r14 = r11.longValue()
            long r17 = r4.longValue()
            long r14 = r14 - r17
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            r14 = 86400000(0x5265c00, double:4.2687272E-316)
            if (r16 == 0) goto L_0x0109
            long r17 = r4.longValue()
            int r16 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0109
            if (r3 != 0) goto L_0x0109
            java.lang.String r3 = " check in allready"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r1, (java.lang.String) r3)
            goto L_0x0075
        L_0x0109:
            long r17 = r4.longValue()
            int r4 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r4 >= 0) goto L_0x011a
            if (r3 == 0) goto L_0x0114
            goto L_0x011a
        L_0x0114:
            java.lang.String r3 = "un repeat check in 24 hour!"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r1, (java.lang.String) r3)
            goto L_0x00bb
        L_0x011a:
            boolean r3 = a((int) r10)
            if (r3 == 0) goto L_0x0127
            java.lang.String r3 = "random check in"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r1, (java.lang.String) r3)
            r1 = 1
            goto L_0x012d
        L_0x0127:
            java.lang.String r3 = "random not check in!"
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r1, (java.lang.String) r3)
            r1 = 0
        L_0x012d:
            android.content.Context r3 = r0.f5415k
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r6, r2)
            if (r3 == 0) goto L_0x0141
            android.content.SharedPreferences$Editor r4 = r3.edit()
            if (r4 == 0) goto L_0x0141
            r4.putBoolean(r5, r1)
            r4.commit()
        L_0x0141:
            if (r3 == 0) goto L_0x0153
            android.content.SharedPreferences$Editor r3 = r3.edit()
            if (r3 == 0) goto L_0x0153
            long r4 = r11.longValue()
            r3.putLong(r9, r4)
            r3.commit()
        L_0x0153:
            r0.f5414j = r1
            android.content.Context r1 = r0.f5415k
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r6, r2)
            if (r1 == 0) goto L_0x0170
            android.content.SharedPreferences$Editor r1 = r1.edit()
            if (r1 == 0) goto L_0x0170
            int r3 = r0.f5408d
            r1.putInt(r8, r3)
            int r3 = r0.f5409e
            r1.putInt(r7, r3)
            r1.commit()
        L_0x0170:
            android.content.Context r1 = r0.f5415k
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r6, r2)
            if (r1 == 0) goto L_0x0184
            int r3 = r1.getInt(r12, r2)
            r0.f5412h = r3
            int r1 = r1.getInt(r13, r2)
            r0.f5413i = r1
        L_0x0184:
            int r1 = r0.f5408d
            int r3 = r0.f5409e
            if (r1 < r3) goto L_0x018d
            r0.f5416l = r2
            return
        L_0x018d:
            if (r3 != 0) goto L_0x0192
            r0.f5416l = r2
            return
        L_0x0192:
            r4 = 100
            int r1 = r1 * 100
            int r1 = r1 / r3
            boolean r1 = a((int) r1)
            if (r1 == 0) goto L_0x01a0
            r0.f5416l = r2
            return
        L_0x01a0:
            r1 = 1
            r0.f5416l = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.NetConfigManager.<init>(android.content.Context, com.efs.sdk.base.EfsReporter):void");
    }

    public boolean enableTracer() {
        return this.f5414j;
    }

    public int getDataRate() {
        return this.f5413i;
    }

    public int getDayLimit() {
        return this.f5412h;
    }

    public int getExtraRateFlag() {
        return this.f5416l;
    }

    public boolean getNetRequestBodyCollectState() {
        return this.f5417m;
    }

    public void setNetRequestBodyCollectState(boolean z10) {
        this.f5417m = z10;
    }

    private static boolean a(int i10) {
        if (i10 == 0) {
            return false;
        }
        return i10 == 100 || new Random().nextInt(100) <= i10;
    }
}
