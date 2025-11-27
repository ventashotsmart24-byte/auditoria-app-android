package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzak implements OnFailureListener {
    public final /* synthetic */ zzam zza;
    public final /* synthetic */ zzan zzb;

    public /* synthetic */ zzak(zzam zzam, zzan zzan) {
        this.zza = zzam;
        this.zzb = zzan;
    }

    public final void onFailure(Exception exc) {
        zzam zzam = this.zza;
        Status status = new Status(8, "unknown error");
        if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            status = new Status(apiException.getStatusCode(), apiException.getMessage());
        }
        int i10 = CastSession.zza;
        zzam.setResult(status);
    }
}
