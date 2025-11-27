package com.google.android.gms.cast;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzck;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzv implements RemoteCall {
    public final /* synthetic */ CastRemoteDisplayClient zza;

    public /* synthetic */ zzv(CastRemoteDisplayClient castRemoteDisplayClient) {
        this.zza = castRemoteDisplayClient;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzck) ((zzcf) obj).getService()).zzi(new zzz(this.zza, (TaskCompletionSource) obj2));
    }
}
