package com.google.android.gms.internal.cast;

import android.animation.Animator;

public final class zzcr extends zzcp {
    protected final Animator zza;
    private final int zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private final zzcv zzd = new zzcq(this);

    private zzcr(Animator animator, int i10, Runnable runnable) {
        this.zza = animator;
        this.zzb = -1;
    }

    public static void zzd(Animator animator, int i10, Runnable runnable) {
        animator.addListener(new zzcr(animator, -1, (Runnable) null));
    }

    public static /* bridge */ /* synthetic */ boolean zze(zzcr zzcr) {
        return zzcr.zzb != -1 && zzcr.zzc >= 0;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!zza(animator)) {
            zzcy.zzb().zza(this.zzd);
        }
    }
}
