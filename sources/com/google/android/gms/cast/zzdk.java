package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdk implements RemoteMediaPlayer.MediaChannelResult {
    final /* synthetic */ Status zza;

    public zzdk(zzdl zzdl, Status status) {
        this.zza = status;
    }

    public final JSONObject getCustomData() {
        return null;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
