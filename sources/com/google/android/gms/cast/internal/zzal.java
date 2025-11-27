package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.CastStatusCodes;

final class zzal implements zzar {
    final /* synthetic */ zzar zza;
    final /* synthetic */ zzap zzb;

    public zzal(zzap zzap, zzar zzar) {
        this.zzb = zzap;
        this.zza = zzar;
    }

    public final void zza(long j10, int i10, Object obj) {
        if (this.zza != null) {
            if (i10 == 2001) {
                zzap zzap = this.zzb;
                zzap.zza.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(zzap.zzA));
                this.zzb.zzz.zzl();
                i10 = CastStatusCodes.INVALID_REQUEST;
            }
            this.zza.zza(j10, i10, obj);
        }
    }

    public final void zzb(long j10) {
        zzar zzar = this.zza;
        if (zzar != null) {
            zzar.zzb(j10);
        }
    }
}
