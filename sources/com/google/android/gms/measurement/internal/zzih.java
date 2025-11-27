package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzih implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzim zze;

    public zzih(zzim zzim, zzie zzie, zzie zzie2, long j10, boolean z10) {
        this.zze = zzim;
        this.zza = zzie;
        this.zzb = zzie2;
        this.zzc = j10;
        this.zzd = z10;
    }

    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
