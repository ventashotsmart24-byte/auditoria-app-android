package com.google.android.gms.cast;

import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbj implements Runnable {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzbj(zzbo zzbo, int i10) {
        this.zza = zzbo;
        this.zzb = i10;
    }

    public final void run() {
        zzbo zzbo = this.zza;
        int i10 = this.zzb;
        zzbp.zzx(zzbo.zza);
        zzbo.zza.zzz = 1;
        synchronized (zzbo.zza.zzy) {
            for (zzq zzd : zzbo.zza.zzy) {
                zzd.zzd(i10);
            }
        }
        zzbo.zza.zzR();
        zzbp zzbp = zzbo.zza;
        Task unused = zzbp.zzP(zzbp.zza);
    }
}
