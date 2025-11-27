package com.google.android.gms.cast;

public final /* synthetic */ class zzbi implements Runnable {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbi(zzbo zzbo, int i10) {
        this.zza = zzbo;
        this.zzb = i10;
    }

    public final void run() {
        zzbo zzbo = this.zza;
        int i10 = this.zzb;
        if (i10 == 0) {
            zzbo.zza.zzz = 2;
            zzbo.zza.zzk = true;
            zzbo.zza.zzl = true;
            synchronized (zzbo.zza.zzy) {
                for (zzq zza2 : zzbo.zza.zzy) {
                    zza2.zza();
                }
            }
            return;
        }
        zzbo.zza.zzz = 1;
        synchronized (zzbo.zza.zzy) {
            for (zzq zzb2 : zzbo.zza.zzy) {
                zzb2.zzb(i10);
            }
        }
        zzbo.zza.zzR();
    }
}
