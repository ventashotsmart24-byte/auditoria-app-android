package com.google.android.gms.internal.cast;

final class zzqk {
    private static final zzqj zza;
    private static final zzqj zzb = new zzqj();

    static {
        zzqj zzqj;
        try {
            zzqj = (zzqj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzqj = null;
        }
        zza = zzqj;
    }

    public static zzqj zza() {
        return zza;
    }

    public static zzqj zzb() {
        return zzb;
    }
}
