package com.google.android.gms.cast;

public final /* synthetic */ class zzbh implements Runnable {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbh(zzbo zzbo, int i10) {
        this.zza = zzbo;
        this.zzb = i10;
    }

    public final void run() {
        zzbo zzbo = this.zza;
        zzbo.zza.zzx.onApplicationDisconnected(this.zzb);
    }
}
