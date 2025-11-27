package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpd;

final class zzhr implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzhx zzg;

    public zzhr(zzhx zzhx, zzai zzai, long j10, int i10, long j11, boolean z10, zzai zzai2) {
        this.zzg = zzhx;
        this.zza = zzai;
        this.zzb = j10;
        this.zzc = i10;
        this.zzd = j11;
        this.zze = z10;
        this.zzf = zzai2;
    }

    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzhx.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzpd.zzc();
        if (this.zzg.zzt.zzf().zzs((String) null, zzdu.zzam)) {
            zzhx.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
