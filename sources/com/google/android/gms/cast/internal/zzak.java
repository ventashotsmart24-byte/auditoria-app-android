package com.google.android.gms.cast.internal;

import java.io.IOException;

final class zzak implements zzar {
    final /* synthetic */ zzap zza;

    public zzak(zzap zzap) {
        this.zza = zzap;
    }

    public final void zza(long j10, int i10, Object obj) {
        if (i10 != 0) {
            this.zza.zzB.setException(new IOException("storing session is timeout"));
        }
    }

    public final void zzb(long j10) {
        this.zza.zzB.setResult(null);
    }
}
