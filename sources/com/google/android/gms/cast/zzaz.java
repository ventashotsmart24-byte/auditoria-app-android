package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaz implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ double zzb;

    public /* synthetic */ zzaz(zzbp zzbp, double d10) {
        this.zza = zzbp;
        this.zzb = d10;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzL(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
