package com.google.android.gms.cast.framework.media.uicontroller;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

public abstract class UIController {
    private RemoteMediaClient zza;

    @RecentlyNullable
    public RemoteMediaClient getRemoteMediaClient() {
        return this.zza;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }

    public void onSessionConnected(@RecentlyNonNull CastSession castSession) {
        RemoteMediaClient remoteMediaClient;
        if (castSession != null) {
            remoteMediaClient = castSession.getRemoteMediaClient();
        } else {
            remoteMediaClient = null;
        }
        this.zza = remoteMediaClient;
    }

    public void onSessionEnded() {
        this.zza = null;
    }
}
