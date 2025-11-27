package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.g;

public class zzcp extends AnimatorListenerAdapter {
    private final g zza = new g();

    public final void onAnimationCancel(Animator animator) {
        this.zza.put(animator, Boolean.TRUE);
    }

    public final void onAnimationStart(Animator animator) {
        this.zza.put(animator, Boolean.FALSE);
    }

    public final boolean zza(Animator animator) {
        if (!this.zza.containsKey(animator) || !((Boolean) this.zza.get(animator)).booleanValue()) {
            return false;
        }
        return true;
    }
}
