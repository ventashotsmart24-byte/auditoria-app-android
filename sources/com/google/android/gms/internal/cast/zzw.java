package com.google.android.gms.internal.cast;

import android.view.ViewGroup;

final class zzw implements Runnable {
    final /* synthetic */ zzx zza;

    public zzw(zzx zzx) {
        this.zza = zzx;
    }

    public final void run() {
        if (this.zza.zza.zzg) {
            ((ViewGroup) this.zza.zza.zzb.getWindow().getDecorView()).removeView(this.zza.zza);
            if (this.zza.zza.zzc != null) {
                this.zza.zza.zzc.onOverlayDismissed();
            }
            this.zza.zza.zzg();
        }
    }
}
