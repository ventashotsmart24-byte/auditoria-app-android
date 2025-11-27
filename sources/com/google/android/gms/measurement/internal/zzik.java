package com.google.android.gms.measurement.internal;

final class zzik implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzim zzc;

    public zzik(zzim zzim, zzie zzie, long j10) {
        this.zzc = zzim;
        this.zza = zzie;
        this.zzb = j10;
    }

    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzim zzim = this.zzc;
        zzim.zza = null;
        zzim.zzt.zzt().zzG((zzie) null);
    }
}
