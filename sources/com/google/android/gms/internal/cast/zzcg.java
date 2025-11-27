package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;

final class zzcg extends zzcl {
    final /* synthetic */ zzcm zza;
    final /* synthetic */ zzch zzb;

    public zzcg(zzch zzch, zzcm zzcm) {
        this.zzb = zzch;
        this.zza = zzcm;
    }

    public final void zzb(int i10) {
        zzch.zze.d("onRemoteDisplayEnded", new Object[0]);
        zzcm zzcm = this.zza;
        if (zzcm != null) {
            zzcm.zzb(i10);
        }
        if (this.zzb.zzf != null) {
            this.zzb.zzf.onRemoteDisplayEnded(new Status(i10));
        }
    }
}
