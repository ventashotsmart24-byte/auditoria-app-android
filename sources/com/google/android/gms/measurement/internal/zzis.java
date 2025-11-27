package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

final class zzis implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzcf zzb;
    final /* synthetic */ zzjm zzc;

    public zzis(zzjm zzjm, zzq zzq, zzcf zzcf) {
        this.zzc = zzjm;
        this.zza = zzq;
        this.zzb = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        String str = null;
        try {
            if (!this.zzc.zzt.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                this.zzc.zzt.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzt.zzq().zzO((String) null);
                this.zzc.zzt.zzm().zze.zzb((String) null);
                zzfr = this.zzc.zzt;
            } else {
                zzjm zzjm = this.zzc;
                zzdx zzh = zzjm.zzb;
                if (zzh == null) {
                    zzjm.zzt.zzay().zzd().zza("Failed to get app instance id");
                    zzfr = this.zzc.zzt;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzh.zzd(this.zza);
                    if (str != null) {
                        this.zzc.zzt.zzq().zzO(str);
                        this.zzc.zzt.zzm().zze.zzb(str);
                    }
                    this.zzc.zzQ();
                    zzfr = this.zzc.zzt;
                }
            }
        } catch (RemoteException e10) {
            this.zzc.zzt.zzay().zzd().zzb("Failed to get app instance id", e10);
            zzfr = this.zzc.zzt;
        } catch (Throwable th) {
            this.zzc.zzt.zzv().zzV(this.zzb, (String) null);
            throw th;
        }
        zzfr.zzv().zzV(this.zzb, str);
    }
}
