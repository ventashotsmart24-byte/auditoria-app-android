package com.google.android.gms.measurement.internal;

final class zziw extends zzap {
    final /* synthetic */ zzjm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zziw(zzjm zzjm, zzgm zzgm) {
        super(zzgm);
        this.zza = zzjm;
    }

    public final void zzc() {
        zzjm zzjm = this.zza;
        zzjm.zzg();
        if (zzjm.zzL()) {
            zzjm.zzt.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjm.zzs();
        }
    }
}
