package com.google.android.gms.internal.cast;

import n0.t0;

public final /* synthetic */ class zzaf implements Runnable {
    public final /* synthetic */ zzag zza;
    public final /* synthetic */ t0.i zzb;
    public final /* synthetic */ t0.i zzc;
    public final /* synthetic */ zzno zzd;

    public /* synthetic */ zzaf(zzag zzag, t0.i iVar, t0.i iVar2, zzno zzno) {
        this.zza = zzag;
        this.zzb = iVar;
        this.zzc = iVar2;
        this.zzd = zzno;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
