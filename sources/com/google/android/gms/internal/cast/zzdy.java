package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Map;

final class zzdy extends zzdu<Map.Entry> {
    final /* synthetic */ zzdz zza;

    public zzdy(zzdz zzdz) {
        this.zza = zzdz;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzdj.zza(i10, 0, FirebaseAnalytics.Param.INDEX);
        int i11 = i10 + i10;
        Object obj = this.zza.zzb[i11];
        obj.getClass();
        Object obj2 = this.zza.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return 0;
    }

    public final boolean zzf() {
        return true;
    }
}
