package com.google.android.gms.internal.cast;

import android.view.Choreographer;

public final /* synthetic */ class zzct implements Choreographer.FrameCallback {
    public final /* synthetic */ zzcv zza;

    public /* synthetic */ zzct(zzcv zzcv) {
        this.zza = zzcv;
    }

    public final void doFrame(long j10) {
        this.zza.zza(j10);
    }
}
