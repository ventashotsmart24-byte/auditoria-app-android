package com.google.android.gms.internal.cast;

public class zzpm {
    private static final zzon zzb = zzon.zza();
    protected volatile zzqe zza;
    private volatile zzoe zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpm = (zzpm) obj;
        zzqe zzqe = this.zza;
        zzqe zzqe2 = zzpm.zza;
        if (zzqe == null && zzqe2 == null) {
            return zzb().equals(zzpm.zzb());
        }
        if (zzqe != null && zzqe2 != null) {
            return zzqe.equals(zzqe2);
        }
        if (zzqe != null) {
            zzpm.zzc(zzqe.zzs());
            return zzqe.equals(zzpm.zza);
        }
        zzc(zzqe2.zzs());
        return this.zza.equals(zzqe2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzoc) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzq();
        }
        return 0;
    }

    public final zzoe zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzoe zzoe = this.zzc;
                return zzoe;
            }
            if (this.zza == null) {
                this.zzc = zzoe.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            zzoe zzoe2 = this.zzc;
            return zzoe2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.cast.zzqe r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.cast.zzqe r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.cast.zzqe r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzpj -> 0x0011 }
            com.google.android.gms.internal.cast.zzoe r0 = com.google.android.gms.internal.cast.zzoe.zzb     // Catch:{ zzpj -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzpj -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.cast.zzoe r2 = com.google.android.gms.internal.cast.zzoe.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzpm.zzc(com.google.android.gms.internal.cast.zzqe):void");
    }
}
