package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

final class zzja implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjm zzb;

    public zzja(zzjm zzjm, zzq zzq) {
        this.zzb = zzjm;
        this.zza = zzq;
    }

    public final void run() {
        zzjm zzjm = this.zzb;
        zzdx zzh = zzjm.zzb;
        if (zzh == null) {
            zzjm.zzt.zzay().zzd().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzp(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e10) {
            this.zzb.zzt.zzay().zzd().zzb("Failed to send consent settings to the service", e10);
        }
    }
}
