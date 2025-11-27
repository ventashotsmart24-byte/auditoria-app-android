package com.google.android.gms.cast;

public final /* synthetic */ class zzbk implements Runnable {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbk(zzbo zzbo, int i10) {
        this.zza = zzbo;
        this.zzb = i10;
    }

    public final void run() {
        zzbo zzbo = this.zza;
        int i10 = this.zzb;
        zzbo.zza.zzz = 3;
        synchronized (zzbo.zza.zzy) {
            for (zzq zzc : zzbo.zza.zzy) {
                zzc.zzc(i10);
            }
        }
    }
}
