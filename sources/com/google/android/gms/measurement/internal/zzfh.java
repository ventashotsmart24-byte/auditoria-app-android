package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

final class zzfh implements zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfi zzb;

    public zzfh(zzfi zzfi, String str) {
        this.zzb = zzfi;
        this.zza = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzg.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
