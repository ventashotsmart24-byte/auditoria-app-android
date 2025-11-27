package com.google.android.gms.flags;

public final class zzb {
    private boolean zzj = false;
    private zzc zzk = null;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzj     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return
        L_0x0007:
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r0 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            java.lang.String r1 = "com.google.android.gms.flags"
            com.google.android.gms.dynamite.DynamiteModule r0 = com.google.android.gms.dynamite.DynamiteModule.load(r3, r0, r1)     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            java.lang.String r1 = "com.google.android.gms.flags.impl.FlagProviderImpl"
            android.os.IBinder r0 = r0.instantiate(r1)     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            com.google.android.gms.flags.zzc r0 = com.google.android.gms.flags.zzd.asInterface(r0)     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            r2.zzk = r0     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            r0.init(r3)     // Catch:{ RemoteException | LoadingException -> 0x0025 }
            r3 = 1
            r2.zzj = r3     // Catch:{ RemoteException | LoadingException -> 0x0025 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.flags.zzb.initialize(android.content.Context):void");
    }

    public final <T> T zzb(Flag<T> flag) {
        synchronized (this) {
            if (this.zzj) {
                return flag.zza(this.zzk);
            }
            T zzb = flag.zzb();
            return zzb;
        }
    }
}
