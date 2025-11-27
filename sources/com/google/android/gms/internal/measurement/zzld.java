package com.google.android.gms.internal.measurement;

final class zzld implements zzlk {
    private final zzlk[] zza;

    public zzld(zzlk... zzlkArr) {
        this.zza = zzlkArr;
    }

    public final zzlj zzb(Class cls) {
        zzlk[] zzlkArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzlk zzlk = zzlkArr[i10];
            if (zzlk.zzc(cls)) {
                return zzlk.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzlk[] zzlkArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzlkArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
