package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzbc extends UIController {
    private final TextView zza;
    private final List<String> zzb;

    public zzbc(TextView textView, List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = textView;
        arrayList.addAll(list);
    }

    public final void onMediaStatusUpdated() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (mediaInfo = ((MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus())).getMediaInfo()) != null && (metadata = mediaInfo.getMetadata()) != null) {
            for (String next : this.zzb) {
                if (metadata.containsKey(next)) {
                    this.zza.setText(metadata.getString(next));
                    return;
                }
            }
            this.zza.setText("");
        }
    }
}
