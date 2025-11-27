package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbb;
import com.google.android.gms.cast.zzbd;
import com.google.android.gms.cast.zzbe;
import com.google.android.gms.cast.zzbp;
import com.google.android.gms.cast.zzbq;
import com.google.android.gms.common.api.internal.TaskApiCall;

final class zzl extends zzs {
    final /* synthetic */ CastSession zza;

    public /* synthetic */ zzl(CastSession castSession, zzk zzk) {
        this.zza = castSession;
    }

    public final void zzb(int i10) {
        CastSession.zzg(this.zza, i10);
    }

    public final void zzc(String str, String str2) {
        if (this.zza.zzh != null) {
            zzbp zzbp = (zzbp) this.zza.zzh;
            zzbp.doWrite(TaskApiCall.builder().run(new zzbe(zzbp, str, str2, (zzbq) null)).setMethodKey(8407).build()).addOnCompleteListener(new zzi(this));
        }
    }

    public final void zzd(String str, LaunchOptions launchOptions) {
        if (this.zza.zzh != null) {
            zzbp zzbp = (zzbp) this.zza.zzh;
            zzbp.doWrite(TaskApiCall.builder().run(new zzbd(zzbp, str, launchOptions)).setMethodKey(8406).build()).addOnCompleteListener(new zzj(this));
        }
    }

    public final void zze(String str) {
        if (this.zza.zzh != null) {
            zzbp zzbp = (zzbp) this.zza.zzh;
            zzbp.doWrite(TaskApiCall.builder().run(new zzbb(zzbp, str)).setMethodKey(8409).build());
        }
    }
}
