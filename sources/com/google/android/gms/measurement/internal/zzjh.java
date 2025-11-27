package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class zzjh implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjl zzb;

    public zzjh(zzjl zzjl, ComponentName componentName) {
        this.zzb = zzjl;
        this.zza = componentName;
    }

    public final void run() {
        zzjm.zzo(this.zzb.zza, this.zza);
    }
}
