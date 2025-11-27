package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;

public final class zzcb extends zzbz {
    final /* synthetic */ zzcc zza;

    public zzcb(zzcc zzcc) {
        this.zza = zzcc;
    }

    public final void zzd(int i10) {
        zzce.zza.d("onError: %d", Integer.valueOf(i10));
        zzce.zzf(this.zza.zzc);
        this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
    }

    public final void zzf() {
        zzce.zza.d("onDisconnected", new Object[0]);
        zzce.zzf(this.zza.zzc);
        this.zza.setResult(new zzcd(Status.RESULT_SUCCESS));
    }
}
