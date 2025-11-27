package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zzd extends AnimatorListenerAdapter {
    final /* synthetic */ zzh zza;

    public zzd(zzh zzh) {
        this.zza = zzh;
    }

    public final void onAnimationEnd(Animator animator) {
        zzh zzh = this.zza;
        zzh.zzg = zzh.zzb(zzh);
        this.zza.zzg.start();
    }
}
