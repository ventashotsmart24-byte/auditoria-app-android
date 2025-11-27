package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzr extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    public zzr(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void run() {
        MediaQueue.zzj(this.zza);
    }
}
