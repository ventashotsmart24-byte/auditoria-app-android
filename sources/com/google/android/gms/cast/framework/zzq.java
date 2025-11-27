package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzq extends zzaa {
    private final CastStateListener zza;

    public zzq(CastStateListener castStateListener) {
        this.zza = castStateListener;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzc(int i10) {
        this.zza.onCastStateChanged(i10);
    }
}
