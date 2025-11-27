package com.google.android.gms.cast.framework.media.internal;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import com.google.android.gms.cast.MediaSeekOptions;

final class zzo extends MediaSessionCompat.b {
    final /* synthetic */ zzp zza;

    public zzo(zzp zzp) {
        this.zza = zzp;
    }

    public final boolean onMediaButtonEvent(Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if (keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) {
            return true;
        }
        this.zza.zzj.togglePlayback();
        return true;
    }

    public final void onPause() {
        this.zza.zzj.togglePlayback();
    }

    public final void onPlay() {
        this.zza.zzj.togglePlayback();
    }

    public final void onSeekTo(long j10) {
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j10);
        this.zza.zzj.seek(builder.build());
    }
}
