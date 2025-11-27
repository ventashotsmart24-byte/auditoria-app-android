package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

final class zzcw extends zzcy {
    private final Handler zza;

    public zzcw(Looper looper) {
        this.zza = new Handler(looper);
    }

    public final void zza(zzcv zzcv) {
        this.zza.postDelayed(zzcv.zzc(), 0);
    }
}
