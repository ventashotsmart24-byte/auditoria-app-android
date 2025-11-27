package com.google.android.gms.measurement.internal;

final class zzha implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhx zzb;

    public zzha(zzhx zzhx, long j10) {
        this.zzb = zzhx;
        this.zza = j10;
    }

    public final void run() {
        this.zzb.zzt.zzm().zzf.zzb(this.zza);
        this.zzb.zzt.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
