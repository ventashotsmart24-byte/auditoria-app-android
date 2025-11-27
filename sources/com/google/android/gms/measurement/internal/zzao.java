package com.google.android.gms.measurement.internal;

final class zzao implements Runnable {
    final /* synthetic */ zzgm zza;
    final /* synthetic */ zzap zzb;

    public zzao(zzap zzap, zzgm zzgm) {
        this.zzb = zzap;
        this.zza = zzgm;
    }

    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
