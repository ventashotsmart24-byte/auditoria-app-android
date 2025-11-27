package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.UserManager;

public final class zzhb {
    private static UserManager zza;
    private static volatile boolean zzb = (!zzb());

    private zzhb() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r7 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0041 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.Context r7) {
        /*
            boolean r0 = zzb()
            r1 = 0
            if (r0 == 0) goto L_0x0056
            boolean r0 = zzb
            if (r0 == 0) goto L_0x000c
            goto L_0x0056
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.measurement.zzhb> r0 = com.google.android.gms.internal.measurement.zzhb.class
            monitor-enter(r0)
            boolean r2 = zzb     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x0056
        L_0x0015:
            r2 = 1
            r3 = 1
        L_0x0017:
            r4 = 2
            r5 = 0
            if (r3 > r4) goto L_0x0046
            android.os.UserManager r4 = zza     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x0029
            java.lang.Class<android.os.UserManager> r4 = android.os.UserManager.class
            java.lang.Object r4 = r7.getSystemService(r4)     // Catch:{ all -> 0x0053 }
            android.os.UserManager r4 = (android.os.UserManager) r4     // Catch:{ all -> 0x0053 }
            zza = r4     // Catch:{ all -> 0x0053 }
        L_0x0029:
            android.os.UserManager r4 = zza     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x002f
            r7 = 1
            goto L_0x004b
        L_0x002f:
            boolean r6 = r4.isUserUnlocked()     // Catch:{ NullPointerException -> 0x0041 }
            if (r6 != 0) goto L_0x003f
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch:{ NullPointerException -> 0x0041 }
            boolean r7 = r4.isUserRunning(r6)     // Catch:{ NullPointerException -> 0x0041 }
            if (r7 != 0) goto L_0x0046
        L_0x003f:
            r7 = 1
            goto L_0x0047
        L_0x0041:
            zza = r5     // Catch:{ all -> 0x0053 }
            int r3 = r3 + 1
            goto L_0x0017
        L_0x0046:
            r7 = 0
        L_0x0047:
            if (r7 == 0) goto L_0x004b
            zza = r5     // Catch:{ all -> 0x0053 }
        L_0x004b:
            if (r7 == 0) goto L_0x004f
            zzb = r2     // Catch:{ all -> 0x0053 }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            if (r7 != 0) goto L_0x0056
            return r2
        L_0x0053:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            throw r7
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhb.zza(android.content.Context):boolean");
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
