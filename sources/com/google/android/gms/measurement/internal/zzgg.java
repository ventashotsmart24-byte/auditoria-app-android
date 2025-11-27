package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzgg implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgj zzb;

    public zzgg(zzgj zzgj, String str) {
        this.zzb = zzgj;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.zzb.zza.zzA();
        return this.zzb.zza.zzi().zzu(this.zza);
    }
}
