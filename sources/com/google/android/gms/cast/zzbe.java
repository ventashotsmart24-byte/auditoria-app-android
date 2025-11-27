package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbe implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbe(zzbp zzbp, String str, String str2, zzbq zzbq) {
        this.zza = zzbp;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzF(this.zzb, this.zzc, (zzbq) null, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
