package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

final class zzkm implements Callable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzkt zzb;

    public zzkm(zzkt zzkt, zzq zzq) {
        this.zzb = zzkt;
        this.zza = zzq;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        zzai zzh = this.zzb.zzh((String) Preconditions.checkNotNull(this.zza.zza));
        zzah zzah = zzah.ANALYTICS_STORAGE;
        if (zzh.zzi(zzah) && zzai.zzb(this.zza.zzv).zzi(zzah)) {
            return this.zzb.zzd(this.zza).zzu();
        }
        this.zzb.zzay().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
