package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzbf implements OnFailureListener {
    public final /* synthetic */ zzbg zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzbf(zzbg zzbg, long j10) {
        this.zza = zzbg;
        this.zzb = j10;
    }

    public final void onFailure(Exception exc) {
        int i10;
        zzbg zzbg = this.zza;
        long j10 = this.zzb;
        if (exc instanceof ApiException) {
            i10 = ((ApiException) exc).getStatusCode();
        } else {
            i10 = 13;
        }
        zzbg.zza.zzd.zzR(j10, i10);
    }
}
