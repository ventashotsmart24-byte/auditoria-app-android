package com.google.android.gms.internal.cast;

final class zzpv implements zzqc {
    private final zzqc[] zza;

    public zzpv(zzqc... zzqcArr) {
        this.zza = zzqcArr;
    }

    public final zzqb zzb(Class<?> cls) {
        String str;
        zzqc[] zzqcArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzqc zzqc = zzqcArr[i10];
            if (zzqc.zzc(cls)) {
                return zzqc.zzb(cls);
            }
        }
        String name = cls.getName();
        if (name.length() != 0) {
            str = "No factory is available for message type: ".concat(name);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }

    public final boolean zzc(Class<?> cls) {
        zzqc[] zzqcArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzqcArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
