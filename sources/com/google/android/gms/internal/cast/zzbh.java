package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzbh extends UIController implements RemoteMediaClient.ProgressListener {
    private final View zza;
    private final zza zzb;

    public zzbh(View view, zza zza2) {
        this.zza = view;
        this.zzb = zza2;
        view.setEnabled(false);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j10, long j11) {
        zza();
    }

    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, 1000);
        }
        zza();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        this.zza.setEnabled(false);
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        boolean z10 = false;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else if (!remoteMediaClient.isLiveStream()) {
            this.zza.setEnabled(true);
        } else {
            View view = this.zza;
            if (remoteMediaClient.zzq()) {
                zza zza2 = this.zzb;
                if ((((long) zza2.zza()) + zza2.zze()) - (((long) zza2.zzd()) + zza2.zze()) >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    z10 = true;
                }
            }
            view.setEnabled(z10);
        }
    }
}
