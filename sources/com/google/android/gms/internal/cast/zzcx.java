package com.google.android.gms.internal.cast;

import android.view.Choreographer;

final class zzcx extends zzcy {
    private final Choreographer zza = Choreographer.getInstance();

    public final void zza(zzcv zzcv) {
        this.zza.postFrameCallback(zzcv.zzb());
    }
}
