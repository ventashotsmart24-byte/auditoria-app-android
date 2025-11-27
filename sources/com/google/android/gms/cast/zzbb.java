package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbb implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbb(zzbp zzbp, String str) {
        this.zza = zzbp;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzM(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
