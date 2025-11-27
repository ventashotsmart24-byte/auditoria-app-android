package com.google.android.gms.internal.measurement;

final class zzli {
    private static final zzlh zza;
    private static final zzlh zzb = new zzlh();

    static {
        zzlh zzlh;
        try {
            zzlh = (zzlh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlh = null;
        }
        zza = zzlh;
    }

    public static zzlh zza() {
        return zza;
    }

    public static zzlh zzb() {
        return zzb;
    }
}
