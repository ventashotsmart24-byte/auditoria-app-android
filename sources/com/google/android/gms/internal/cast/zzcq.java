package com.google.android.gms.internal.cast;

final class zzcq extends zzcv {
    final /* synthetic */ zzcr zza;

    public zzcq(zzcr zzcr) {
        this.zza = zzcr;
    }

    public final void zza(long j10) {
        zzcr zzcr = this.zza;
        zzcr.zzc = zzcr.zzc + 1;
        zzcr zzcr2 = this.zza;
        if (!zzcr2.zza(zzcr2.zza) && !this.zza.zza.isStarted() && !zzcr.zze(this.zza)) {
            this.zza.zza.start();
        }
    }
}
