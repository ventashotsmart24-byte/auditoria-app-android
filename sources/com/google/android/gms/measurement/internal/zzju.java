package com.google.android.gms.measurement.internal;

final class zzju implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkc zzb;

    public zzju(zzkc zzkc, long j10) {
        this.zzb = zzkc;
        this.zza = j10;
    }

    public final void run() {
        zzkc.zzl(this.zzb, this.zza);
    }
}
