package com.google.android.gms.internal.measurement;

final class zzka implements zzlk {
    private static final zzka zza = new zzka();

    private zzka() {
    }

    public static zzka zza() {
        return zza;
    }

    public final zzlj zzb(Class cls) {
        Class<zzkf> cls2 = zzkf.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzlj) zzkf.zzbz(cls.asSubclass(cls2)).zzl(3, (Object) null, (Object) null);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzkf.class.isAssignableFrom(cls);
    }
}
