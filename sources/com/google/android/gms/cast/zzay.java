package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzae;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzay implements RemoteCall {
    public final /* synthetic */ zzbp zza;

    public /* synthetic */ zzay(zzbp zzbp) {
        this.zza = zzbp;
    }

    public final void accept(Object obj, Object obj2) {
        zzx zzx = (zzx) obj;
        ((zzae) zzx.getService()).zzj(this.zza.zza);
        ((zzae) zzx.getService()).zze();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
