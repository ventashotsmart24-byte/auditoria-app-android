package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzs(zzt zzt, boolean z10, boolean z11) {
        super("log");
        this.zzc = zzt;
        this.zza = z10;
        this.zzb = z11;
    }

    public final zzap zza(zzg zzg, List list) {
        int i10;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzg.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int zzb2 = zzh.zzb(zzg.zzb((zzap) list.get(0)).zzh().doubleValue());
        if (zzb2 == 2) {
            i10 = 4;
        } else if (zzb2 == 3) {
            i10 = 1;
        } else if (zzb2 == 5) {
            i10 = 5;
        } else if (zzb2 != 6) {
            i10 = 3;
        } else {
            i10 = 2;
        }
        String zzi = zzg.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            this.zzc.zza.zza(i10, zzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 2; i11 < Math.min(list.size(), 5); i11++) {
            arrayList.add(zzg.zzb((zzap) list.get(i11)).zzi());
        }
        this.zzc.zza.zza(i10, zzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
