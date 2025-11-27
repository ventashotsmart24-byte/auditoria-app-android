package com.google.android.gms.measurement.internal;

final class zzij implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzim zzb;

    public zzij(zzim zzim, long j10) {
        this.zzb = zzim;
        this.zza = j10;
    }

    public final void run() {
        this.zzb.zzt.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
