package com.google.android.gms.internal.measurement;

final class zzky extends zzla {
    public /* synthetic */ zzky(zzkx zzkx) {
        super((zzkz) null);
    }

    public final void zza(Object obj, long j10) {
        ((zzkm) zzmy.zzf(obj, j10)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j10) {
        zzkm zzkm = (zzkm) zzmy.zzf(obj, j10);
        zzkm zzkm2 = (zzkm) zzmy.zzf(obj2, j10);
        int size = zzkm.size();
        int size2 = zzkm2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkm.zzc()) {
                zzkm = zzkm.zzd(size2 + size);
            }
            zzkm.addAll(zzkm2);
        }
        if (size > 0) {
            zzkm2 = zzkm;
        }
        zzmy.zzs(obj, j10, zzkm2);
    }

    private zzky() {
        super((zzkz) null);
    }
}
