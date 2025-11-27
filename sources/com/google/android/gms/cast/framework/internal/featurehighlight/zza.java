package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.GestureDetector;
import android.view.MotionEvent;

final class zza extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ zzh zza;

    public zza(zzh zzh) {
        this.zza = zzh;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (this.zza.zzc.contains(Math.round(x10), Math.round(y10)) && this.zza.zzd.zzg(x10, y10)) {
            return true;
        }
        this.zza.zzk.zza();
        return true;
    }
}
