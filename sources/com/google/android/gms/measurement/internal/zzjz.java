package com.google.android.gms.measurement.internal;

final class zzjz extends zzap {
    final /* synthetic */ zzka zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjz(zzka zzka, zzgm zzgm) {
        super(zzgm);
        this.zza = zzka;
    }

    public final void zzc() {
        zzka zzka = this.zza;
        zzka.zzc.zzg();
        zzka.zzd(false, false, zzka.zzc.zzt.zzav().elapsedRealtime());
        zzka.zzc.zzt.zzd().zzf(zzka.zzc.zzt.zzav().elapsedRealtime());
    }
}
