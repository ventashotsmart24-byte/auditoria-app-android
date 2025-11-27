package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzon {
    static final zzon zza = new zzon(true);
    private static volatile boolean zzb = false;
    private static volatile zzon zzc;
    private final Map zzd;

    public zzon() {
        this.zzd = new HashMap();
    }

    public static zzon zza() {
        zzon zzon = zzc;
        if (zzon == null) {
            synchronized (zzon.class) {
                zzon = zzc;
                if (zzon == null) {
                    zzon = zza;
                    zzc = zzon;
                }
            }
        }
        return zzon;
    }

    public zzon(boolean z10) {
        this.zzd = Collections.emptyMap();
    }
}
