package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbd implements RemoteCall {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ LaunchOptions zzc;

    public /* synthetic */ zzbd(zzbp zzbp, String str, LaunchOptions launchOptions) {
        this.zza = zzbp;
        this.zzb = str;
        this.zzc = launchOptions;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzG(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
