package com.efs.sdk.launch;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;

public class LaunchConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f5343a = "LaunchConfigManager";

    /* renamed from: b  reason: collision with root package name */
    private final int f5344b = 0;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f5345c;

    /* renamed from: d  reason: collision with root package name */
    private int f5346d = 100;

    /* renamed from: e  reason: collision with root package name */
    private int f5347e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5348f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f5349g;

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LaunchConfigManager(android.content.Context r18, com.efs.sdk.base.EfsReporter r19) {
        /*
            r17 = this;
            r0 = r17
            r17.<init>()
            java.lang.String r1 = "LaunchConfigManager"
            r0.f5343a = r1
            r1 = 0
            r0.f5344b = r1
            r2 = 100
            r0.f5346d = r2
            r0.f5348f = r1
            android.content.Context r3 = r18.getApplicationContext()
            r0.f5349g = r3
            r4 = r19
            r0.f5345c = r4
            java.lang.String r4 = "efs_launch"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r1)
            java.lang.String r5 = "apm_startperf_sampling_rate_last"
            if (r3 == 0) goto L_0x002c
            int r3 = r3.getInt(r5, r1)
            r0.f5347e = r3
        L_0x002c:
            android.content.Context r3 = r0.f5349g
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r1)
            java.lang.String r6 = "apm_startperf_sampling_rate"
            r7 = -1
            if (r3 == 0) goto L_0x003c
            int r3 = r3.getInt(r6, r7)
            goto L_0x003d
        L_0x003c:
            r3 = -1
        L_0x003d:
            com.efs.sdk.base.EfsReporter r8 = r0.f5345c
            java.lang.String[] r6 = new java.lang.String[]{r6}
            com.efs.sdk.launch.LaunchConfigManager$1 r9 = new com.efs.sdk.launch.LaunchConfigManager$1
            r9.<init>()
            r8.getAllSdkConfig(r6, r9)
            if (r3 == r7) goto L_0x004f
            r0.f5346d = r3
        L_0x004f:
            android.content.Context r3 = r0.f5349g
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r1)
            java.lang.String r6 = "03f870871950c148387b251894ed3e88"
            r7 = 0
            if (r3 == 0) goto L_0x0060
            long r9 = r3.getLong(r6, r7)
            goto L_0x0061
        L_0x0060:
            r9 = r7
        L_0x0061:
            java.lang.String r11 = "8f2f54c08600aa25915617fa1371441b"
            if (r3 == 0) goto L_0x006a
            boolean r12 = r3.getBoolean(r11, r1)
            goto L_0x006b
        L_0x006a:
            r12 = 0
        L_0x006b:
            int r13 = r0.f5346d
            if (r13 != 0) goto L_0x0094
            if (r12 == 0) goto L_0x007f
            if (r3 == 0) goto L_0x007f
            android.content.SharedPreferences$Editor r2 = r3.edit()
            if (r2 == 0) goto L_0x007f
            r2.putBoolean(r11, r1)
            r2.commit()
        L_0x007f:
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0091
            if (r3 == 0) goto L_0x0091
            android.content.SharedPreferences$Editor r2 = r3.edit()
            if (r2 == 0) goto L_0x0091
            r2.putLong(r6, r7)
            r2.commit()
        L_0x0091:
            r7 = 0
            goto L_0x0122
        L_0x0094:
            boolean r3 = com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()
            r7 = 1
            if (r3 == 0) goto L_0x009d
            goto L_0x0122
        L_0x009d:
            int r3 = r0.f5346d
            int r8 = r0.f5347e
            if (r3 == r8) goto L_0x00a5
            r3 = 1
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            java.lang.Long r8 = java.lang.Long.valueOf(r9)
            int r9 = r0.f5346d
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.Long r10 = java.lang.Long.valueOf(r13)
            long r13 = r10.longValue()
            long r15 = r8.longValue()
            long r13 = r13 - r15
            java.lang.Long r8 = java.lang.Long.valueOf(r13)
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            if (r12 == 0) goto L_0x00d3
            long r15 = r8.longValue()
            int r12 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d3
            if (r3 != 0) goto L_0x00d3
            boolean r2 = com.efs.sdk.launch.LaunchManager.isDebug
            goto L_0x0122
        L_0x00d3:
            long r15 = r8.longValue()
            int r8 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r8 >= 0) goto L_0x00e1
            if (r3 == 0) goto L_0x00de
            goto L_0x00e1
        L_0x00de:
            boolean r2 = com.efs.sdk.launch.LaunchManager.isDebug
            goto L_0x0091
        L_0x00e1:
            if (r9 == 0) goto L_0x00f3
            if (r9 != r2) goto L_0x00e7
        L_0x00e5:
            r2 = 1
            goto L_0x00f4
        L_0x00e7:
            java.util.Random r3 = new java.util.Random
            r3.<init>()
            int r2 = r3.nextInt(r2)
            if (r2 > r9) goto L_0x00f3
            goto L_0x00e5
        L_0x00f3:
            r2 = 0
        L_0x00f4:
            if (r2 == 0) goto L_0x00f9
            boolean r2 = com.efs.sdk.launch.LaunchManager.isDebug
            goto L_0x00fc
        L_0x00f9:
            boolean r2 = com.efs.sdk.launch.LaunchManager.isDebug
            r7 = 0
        L_0x00fc:
            android.content.Context r2 = r0.f5349g
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r4, r1)
            if (r2 == 0) goto L_0x0110
            android.content.SharedPreferences$Editor r3 = r2.edit()
            if (r3 == 0) goto L_0x0110
            r3.putBoolean(r11, r7)
            r3.commit()
        L_0x0110:
            if (r2 == 0) goto L_0x0122
            android.content.SharedPreferences$Editor r2 = r2.edit()
            if (r2 == 0) goto L_0x0122
            long r8 = r10.longValue()
            r2.putLong(r6, r8)
            r2.commit()
        L_0x0122:
            r0.f5348f = r7
            android.content.Context r2 = r0.f5349g
            android.content.SharedPreferences r1 = r2.getSharedPreferences(r4, r1)
            if (r1 == 0) goto L_0x013a
            android.content.SharedPreferences$Editor r1 = r1.edit()
            if (r1 == 0) goto L_0x013a
            int r2 = r0.f5346d
            r1.putInt(r5, r2)
            r1.commit()
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.launch.LaunchConfigManager.<init>(android.content.Context, com.efs.sdk.base.EfsReporter):void");
    }

    public boolean enableTracer() {
        return this.f5348f;
    }
}
