package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

final class zzhs implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzhx zzf;

    public zzhs(zzhx zzhx, zzai zzai, int i10, long j10, boolean z10, zzai zzai2) {
        this.zzf = zzhx;
        this.zza = zzai;
        this.zzb = i10;
        this.zzc = j10;
        this.zzd = z10;
        this.zze = zzai2;
    }

    public final void run() {
        this.zzf.zzV(this.zza);
        zzhx.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzpd.zzc();
        if (this.zzf.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
