package com.google.android.gms.internal.cast;

final class zzqa {
    private static final zzpz zza;
    private static final zzpz zzb = new zzpz();

    static {
        zzpz zzpz;
        try {
            zzpz = (zzpz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzpz = null;
        }
        zza = zzpz;
    }

    public static zzpz zza() {
        return zza;
    }

    public static zzpz zzb() {
        return zzb;
    }
}
