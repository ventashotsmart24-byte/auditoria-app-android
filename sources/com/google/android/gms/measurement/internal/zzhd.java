package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhd implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzhx zzc;

    public zzhd(zzhx zzhx, AtomicReference atomicReference, boolean z10) {
        this.zzc = zzhx;
        this.zza = atomicReference;
        this.zzb = z10;
    }

    public final void run() {
        this.zzc.zzt.zzt().zzx(this.zza, this.zzb);
    }
}
