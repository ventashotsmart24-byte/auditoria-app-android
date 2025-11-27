package com.google.android.gms.internal.measurement;

public class zzks {
    private static final zzjr zzb = zzjr.zza;
    protected volatile zzlm zza;
    private volatile zzje zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        zzks zzks = (zzks) obj;
        zzlm zzlm = this.zza;
        zzlm zzlm2 = zzks.zza;
        if (zzlm == null && zzlm2 == null) {
            return zzb().equals(zzks.zzb());
        }
        if (zzlm != null && zzlm2 != null) {
            return zzlm.equals(zzlm2);
        }
        if (zzlm != null) {
            zzks.zzc(zzlm.zzbS());
            return zzlm.equals(zzks.zza);
        }
        zzc(zzlm2.zzbS());
        return this.zza.equals(zzlm2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzjb) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    public final zzje zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzje zzje = this.zzc;
                return zzje;
            }
            if (this.zza == null) {
                this.zzc = zzje.zzb;
            } else {
                this.zzc = this.zza.zzbs();
            }
            zzje zzje2 = this.zzc;
            return zzje2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zzlm r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzlm r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzlm r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzkp -> 0x0011 }
            com.google.android.gms.internal.measurement.zzje r0 = com.google.android.gms.internal.measurement.zzje.zzb     // Catch:{ zzkp -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzkp -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzje r2 = com.google.android.gms.internal.measurement.zzje.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzks.zzc(com.google.android.gms.internal.measurement.zzlm):void");
    }
}
