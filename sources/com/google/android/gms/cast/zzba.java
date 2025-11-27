package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzba implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ Cast.MessageReceivedCallback zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzba(zzbp zzbp, Cast.MessageReceivedCallback messageReceivedCallback, String str) {
        this.zza = zzbp;
        this.zzb = messageReceivedCallback;
        this.zzc = str;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzH(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
