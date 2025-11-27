package com.google.android.gms.measurement.internal;

final class zzjr implements Runnable {
    final /* synthetic */ zzkt zza;
    final /* synthetic */ Runnable zzb;

    public zzjr(zzjt zzjt, zzkt zzkt, Runnable runnable) {
        this.zza = zzkt;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
