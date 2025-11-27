package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

final class zzje implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ zzcf zzd;
    final /* synthetic */ zzjm zze;

    public zzje(zzjm zzjm, String str, String str2, zzq zzq, zzcf zzcf) {
        this.zze = zzjm;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        ArrayList arrayList = new ArrayList();
        try {
            zzjm zzjm = this.zze;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzfr = this.zze.zzt;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzlb.zzH(zzh.zzf(this.zza, this.zzb, this.zzc));
                this.zze.zzQ();
                zzfr = this.zze.zzt;
            }
        } catch (RemoteException e10) {
            this.zze.zzt.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e10);
            zzfr = this.zze.zzt;
        } catch (Throwable th) {
            this.zze.zzt.zzv().zzQ(this.zzd, arrayList);
            throw th;
        }
        zzfr.zzv().zzQ(this.zzd, arrayList);
    }
}
