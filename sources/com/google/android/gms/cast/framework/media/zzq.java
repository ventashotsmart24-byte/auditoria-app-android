package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

public final /* synthetic */ class zzq implements ResultCallback {
    public final /* synthetic */ MediaQueue zza;

    public /* synthetic */ zzq(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void onResult(Result result) {
        this.zza.zzn((RemoteMediaClient.MediaChannelResult) result);
    }
}
