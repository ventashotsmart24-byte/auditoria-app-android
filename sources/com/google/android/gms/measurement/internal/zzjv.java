package com.google.android.gms.measurement.internal;

final class zzjv implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkc zzb;

    public zzjv(zzkc zzkc, long j10) {
        this.zzb = zzkc;
        this.zza = j10;
    }

    public final void run() {
        zzkc.zzj(this.zzb, this.zza);
    }
}
