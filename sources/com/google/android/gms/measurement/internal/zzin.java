package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

final class zzin implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcf zze;
    final /* synthetic */ zzjm zzf;

    public zzin(zzjm zzjm, String str, String str2, zzq zzq, boolean z10, zzcf zzcf) {
        this.zzf = zzjm;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = z10;
        this.zze = zzcf;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            zzjm zzjm = this.zzf;
            zzdx zzh = zzjm.zzb;
            if (zzh == null) {
                zzjm.zzt.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzkw> zzh2 = zzh.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzkw zzkw : zzh2) {
                    String str = zzkw.zze;
                    if (str != null) {
                        bundle.putString(zzkw.zzb, str);
                    } else {
                        Long l10 = zzkw.zzd;
                        if (l10 != null) {
                            bundle.putLong(zzkw.zzb, l10.longValue());
                        } else {
                            Double d10 = zzkw.zzg;
                            if (d10 != null) {
                                bundle.putDouble(zzkw.zzb, d10.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzt.zzv().zzR(this.zze, bundle);
            } catch (RemoteException e11) {
                e10 = e11;
                try {
                    this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e10);
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
            this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e10);
            this.zzf.zzt.zzv().zzR(this.zze, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzt.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
