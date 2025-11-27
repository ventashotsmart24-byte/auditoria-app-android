package com.google.android.gms.internal.cast;

final class zzoq {
    private static final zzoo<?> zza = new zzop();
    private static final zzoo<?> zzb;

    static {
        zzoo<?> zzoo;
        try {
            zzoo = (zzoo) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzoo = null;
        }
        zzb = zzoo;
    }

    public static zzoo<?> zza() {
        zzoo<?> zzoo = zzb;
        if (zzoo != null) {
            return zzoo;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzoo<?> zzb() {
        return zza;
    }
}
