package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgd;
import java.util.ArrayList;
import java.util.List;

final class zzkq {
    zzgd zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzkt zze;

    public /* synthetic */ zzkq(zzkt zzkt, zzkp zzkp) {
        this.zze = zzkt;
    }

    private static final long zzb(zzft zzft) {
        return ((zzft.zzd() / 1000) / 60) / 60;
    }

    public final boolean zza(long j10, zzft zzft) {
        Preconditions.checkNotNull(zzft);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (!this.zzc.isEmpty() && zzb((zzft) this.zzc.get(0)) != zzb(zzft)) {
            return false;
        }
        long zzbw = this.zzd + ((long) zzft.zzbw());
        this.zze.zzg();
        if (zzbw >= ((long) Math.max(0, ((Integer) zzdu.zzh.zza((Object) null)).intValue()))) {
            return false;
        }
        this.zzd = zzbw;
        this.zzc.add(zzft);
        this.zzb.add(Long.valueOf(j10));
        int size = this.zzc.size();
        this.zze.zzg();
        if (size >= Math.max(1, ((Integer) zzdu.zzi.zza((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
