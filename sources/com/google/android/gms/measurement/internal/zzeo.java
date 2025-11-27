package com.google.android.gms.measurement.internal;

final class zzeo implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzep zzb;

    public zzeo(zzep zzep, boolean z10) {
        this.zzb = zzep;
        this.zza = z10;
    }

    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
