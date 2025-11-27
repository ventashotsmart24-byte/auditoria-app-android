package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

public final /* synthetic */ class zzh implements RemoteCall {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ String[] zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzh(zzn zzn, String[] strArr, String str, List list) {
        this.zza = zzn;
        this.zzb = strArr;
        this.zzc = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzn zzn = this.zza;
        String[] strArr = this.zzb;
        String str = this.zzc;
        ((zzah) ((zzo) obj).getService()).zze(new zzj(zzn, (TaskCompletionSource) obj2), strArr, str, (List) null);
    }
}
