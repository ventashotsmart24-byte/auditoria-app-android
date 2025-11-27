package com.google.android.gms.measurement.internal;

final class zzkj implements Runnable {
    final /* synthetic */ zzku zza;
    final /* synthetic */ zzkt zzb;

    public zzkj(zzkt zzkt, zzku zzku) {
        this.zzb = zzkt;
        this.zza = zzku;
    }

    public final void run() {
        zzkt.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
