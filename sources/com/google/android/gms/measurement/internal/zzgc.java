package com.google.android.gms.measurement.internal;

final class zzgc implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgj zzc;

    public zzgc(zzgj zzgj, zzaw zzaw, zzq zzq) {
        this.zzc = zzgj;
        this.zza = zzaw;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
