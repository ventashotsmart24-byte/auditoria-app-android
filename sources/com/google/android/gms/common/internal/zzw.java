package com.google.android.gms.common.internal;

import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzw extends zza implements ICancelToken {
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    public final void cancel() {
        zzD(2, zza());
    }
}
