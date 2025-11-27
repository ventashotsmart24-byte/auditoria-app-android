package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbh implements RemoteMediaClient.MediaChannelResult {
    final /* synthetic */ Status zza;

    public zzbh(zzbi zzbi, Status status) {
        this.zza = status;
    }

    public final JSONObject getCustomData() {
        return null;
    }

    public final MediaError getMediaError() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
