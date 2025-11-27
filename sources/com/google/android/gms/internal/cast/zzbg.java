package com.google.android.gms.internal.cast;

import android.widget.ProgressBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzbg extends UIController implements RemoteMediaClient.ProgressListener {
    private final ProgressBar zza;
    private final long zzb;

    public zzbg(ProgressBar progressBar, long j10) {
        this.zza = progressBar;
        this.zzb = j10;
        zza();
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j10, long j11) {
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, this.zzb);
        }
        zza();
    }

    public final void onSessionEnded() {
        if (getRemoteMediaClient() != null) {
            getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isLiveStream()) {
            this.zza.setMax(1);
            this.zza.setProgress(0);
            return;
        }
        this.zza.setMax((int) remoteMediaClient.getStreamDuration());
        this.zza.setProgress((int) remoteMediaClient.getApproximateStreamPosition());
    }
}
