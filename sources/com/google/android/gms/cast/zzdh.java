package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzdh implements ResultCallback<Status> {
    final /* synthetic */ zzdi zza;
    private final long zzb;

    public zzdh(zzdi zzdi, long j10) {
        this.zza = zzdi;
        this.zzb = j10;
    }

    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        if (!status.isSuccess()) {
            this.zza.zza.zzb.zzR(this.zzb, status.getStatusCode());
        }
    }
}
