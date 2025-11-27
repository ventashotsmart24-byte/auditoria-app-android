package com.google.android.gms.measurement.internal;

final class zzgi implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgj zze;

    public zzgi(zzgj zzgj, String str, String str2, String str3, long j10) {
        this.zze = zzgj;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j10;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzR(this.zzb, (zzie) null);
            return;
        }
        this.zze.zza.zzR(this.zzb, new zzie(this.zzc, str, this.zzd));
    }
}
