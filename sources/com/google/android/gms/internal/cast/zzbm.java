package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzq;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzbm extends UIController {
    private final TextView zza;

    public zzbm(TextView textView) {
        this.zza = textView;
    }

    public final void onMediaStatusUpdated() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        String zza2;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && (mediaInfo = remoteMediaClient.getMediaInfo()) != null && (metadata = mediaInfo.getMetadata()) != null && (zza2 = zzq.zza(metadata)) != null) {
            this.zza.setText(zza2);
        }
    }
}
