package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzm implements RemoteMediaClient.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    public /* synthetic */ zzm(ExpandedControllerActivity expandedControllerActivity, zzl zzl) {
        this.zza = expandedControllerActivity;
    }

    public final void onAdBreakStatusUpdated() {
        this.zza.zzr();
    }

    public final void onMetadataUpdated() {
        this.zza.zzq();
    }

    public final void onPreloadStatusUpdated() {
    }

    public final void onQueueStatusUpdated() {
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.zzu.setText(this.zza.getResources().getString(R.string.cast_expanded_controller_loading));
    }

    public final void onStatusUpdated() {
        RemoteMediaClient zze = this.zza.zzl();
        if (zze != null && zze.hasMediaSession()) {
            this.zza.zzL = false;
            this.zza.zzp();
            this.zza.zzr();
        } else if (!this.zza.zzL) {
            this.zza.finish();
        }
    }
}
