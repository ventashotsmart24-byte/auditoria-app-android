package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbf implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbf(zzbp zzbp, String str, String str2, String str3) {
        this.zza = zzbp;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzI((String) null, this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
