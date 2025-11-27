package com.google.android.gms.internal.measurement;

final class zzju {
    private static final zzjs zza = new zzjt();
    private static final zzjs zzb;

    static {
        zzjs zzjs;
        try {
            zzjs = (zzjs) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjs = null;
        }
        zzb = zzjs;
    }

    public static zzjs zza() {
        zzjs zzjs = zzb;
        if (zzjs != null) {
            return zzjs;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzjs zzb() {
        return zza;
    }
}
