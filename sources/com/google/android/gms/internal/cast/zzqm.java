package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzqm {
    private static final zzqm zza = new zzqm();
    private final zzqq zzb = new zzpw();
    private final ConcurrentMap<Class<?>, zzqp<?>> zzc = new ConcurrentHashMap();

    private zzqm() {
    }

    public static zzqm zza() {
        return zza;
    }

    public final <T> zzqp<T> zzb(Class<T> cls) {
        zzph.zzf(cls, "messageType");
        zzqp<T> zzqp = this.zzc.get(cls);
        if (zzqp == null) {
            zzqp = this.zzb.zza(cls);
            zzph.zzf(cls, "messageType");
            zzph.zzf(zzqp, "schema");
            zzqp<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzqp);
            if (putIfAbsent == null) {
                return zzqp;
            }
            return putIfAbsent;
        }
        return zzqp;
    }
}
