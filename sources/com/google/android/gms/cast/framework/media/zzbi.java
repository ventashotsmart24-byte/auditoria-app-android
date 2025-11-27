package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zzbi extends BasePendingResult<RemoteMediaClient.MediaChannelResult> {
    public zzbi() {
        super((GoogleApiClient) null);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbh(this, status);
    }
}
