package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbc implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Cast.MessageReceivedCallback zzc;

    public /* synthetic */ zzbc(zzbp zzbp, String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        this.zza = zzbp;
        this.zzb = str;
        this.zzc = messageReceivedCallback;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzJ(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
