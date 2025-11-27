package com.google.android.gms.measurement.internal;

final class zzb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzd zzc;

    public zzb(zzd zzd, String str, long j10) {
        this.zzc = zzd;
        this.zza = str;
        this.zzb = j10;
    }

    public final void run() {
        zzd.zzb(this.zzc, this.zza, this.zzb);
    }
}
