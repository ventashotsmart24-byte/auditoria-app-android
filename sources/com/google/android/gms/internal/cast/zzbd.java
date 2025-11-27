package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast;

final class zzbd extends Cast.Listener {
    final /* synthetic */ zzbe zza;

    public zzbd(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void onVolumeChanged() {
        this.zza.zza();
    }
}
