package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzau implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzau(zzbp zzbp, boolean z10) {
        this.zza = zzbp;
        this.zzb = z10;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzK(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
