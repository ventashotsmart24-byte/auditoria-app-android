package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzjj implements Runnable {
    final /* synthetic */ zzjl zza;

    public zzjj(zzjl zzjl) {
        this.zza = zzjl;
    }

    public final void run() {
        zzjm zzjm = this.zza.zza;
        Context zzau = zzjm.zzt.zzau();
        this.zza.zza.zzt.zzaw();
        zzjm.zzo(zzjm, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
