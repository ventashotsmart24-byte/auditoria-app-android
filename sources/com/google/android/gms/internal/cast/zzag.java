package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import n0.t0;

public final class zzag implements t0.f {
    private static final Logger zza = new Logger("MediaRouterOPTListener");
    private final zzar zzb;
    private final Handler zzc = new zzco(Looper.getMainLooper());

    public zzag(zzar zzar) {
        this.zzb = (zzar) Preconditions.checkNotNull(zzar);
    }

    public final ListenableFuture<Void> onPrepareTransfer(t0.i iVar, t0.i iVar2) {
        zza.d("Prepare transfer from Route(%s) to Route(%s)", iVar, iVar2);
        zzno zzk = zzno.zzk();
        this.zzc.post(new zzaf(this, iVar, iVar2, zzk));
        return zzk;
    }

    public final /* synthetic */ void zza(t0.i iVar, t0.i iVar2, zzno zzno) {
        this.zzb.zze(iVar, iVar2, zzno);
    }
}
