package com.google.android.gms.cast.internal;

final class zzr implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ int zzb;

    public zzr(zzv zzv, zzw zzw, int i10) {
        this.zza = zzw;
        this.zzb = i10;
    }

    public final void run() {
        this.zza.zzj.onApplicationDisconnected(this.zzb);
    }
}
