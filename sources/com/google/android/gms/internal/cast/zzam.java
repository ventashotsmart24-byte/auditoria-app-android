package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zzam<R extends Result> extends BasePendingResult<R> {
    private final zzan<R, Status> zza;

    public zzam(zzan<R, Status> zzan) {
        super((GoogleApiClient) null);
        this.zza = zzan;
    }

    public final R createFailedResult(Status status) {
        int i10 = CastSession.zza;
        return status;
    }
}
