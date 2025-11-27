package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzlu {
    private static final zzlu zza = new zzlu();
    private final zzly zzb = new zzle();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzlu() {
    }

    public static zzlu zza() {
        return zza;
    }

    public final zzlx zzb(Class cls) {
        zzkn.zzf(cls, "messageType");
        zzlx zzlx = (zzlx) this.zzc.get(cls);
        if (zzlx == null) {
            zzlx = this.zzb.zza(cls);
            zzkn.zzf(cls, "messageType");
            zzkn.zzf(zzlx, "schema");
            zzlx zzlx2 = (zzlx) this.zzc.putIfAbsent(cls, zzlx);
            if (zzlx2 == null) {
                return zzlx;
            }
            return zzlx2;
        }
        return zzlx;
    }
}
