package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjr {
    static final zzjr zza = new zzjr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzjr zzd;
    private final Map zze;

    public zzjr() {
        this.zze = new HashMap();
    }

    public static zzjr zza() {
        zzjr zzjr = zzd;
        if (zzjr != null) {
            return zzjr;
        }
        synchronized (zzjr.class) {
            zzjr zzjr2 = zzd;
            if (zzjr2 != null) {
                return zzjr2;
            }
            zzjr zzb2 = zzjz.zzb(zzjr.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzkd zzb(zzlm zzlm, int i10) {
        return (zzkd) this.zze.get(new zzjq(zzlm, i10));
    }

    public zzjr(boolean z10) {
        this.zze = Collections.emptyMap();
    }
}
