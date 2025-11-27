package com.google.android.gms.measurement.internal;

final class zzfz implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgj zzb;

    public zzfz(zzgj zzgj, zzq zzq) {
        this.zzb = zzgj;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzQ(this.zza);
    }
}
