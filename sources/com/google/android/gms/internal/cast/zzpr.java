package com.google.android.gms.internal.cast;

final class zzpr extends zzps {
    public /* synthetic */ zzpr(zzpp zzpp) {
        super((zzpp) null);
    }

    public final void zza(Object obj, long j10) {
        ((zzpg) zzrn.zzf(obj, j10)).zzb();
    }

    public final <E> void zzb(Object obj, Object obj2, long j10) {
        zzpg zzpg = (zzpg) zzrn.zzf(obj, j10);
        zzpg zzpg2 = (zzpg) zzrn.zzf(obj2, j10);
        int size = zzpg.size();
        int size2 = zzpg2.size();
        if (size > 0 && size2 > 0) {
            if (!zzpg.zzc()) {
                zzpg = zzpg.zzg(size2 + size);
            }
            zzpg.addAll(zzpg2);
        }
        if (size > 0) {
            zzpg2 = zzpg;
        }
        zzrn.zzs(obj, j10, zzpg2);
    }

    private zzpr() {
        super((zzpp) null);
    }
}
