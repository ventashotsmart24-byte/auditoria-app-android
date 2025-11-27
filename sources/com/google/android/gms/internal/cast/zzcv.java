package com.google.android.gms.internal.cast;

import android.view.Choreographer;

public abstract class zzcv {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j10);

    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new zzct(this);
        }
        return this.zzb;
    }

    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new zzcu(this);
        }
        return this.zza;
    }
}
