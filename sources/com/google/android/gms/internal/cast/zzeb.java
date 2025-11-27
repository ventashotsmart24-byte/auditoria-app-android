package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzeb extends zzdu<Object> {
    private final transient Object[] zza;
    private final transient int zzb;

    public zzeb(Object[] objArr, int i10, int i11) {
        this.zza = objArr;
        this.zzb = i10;
    }

    public final Object get(int i10) {
        zzdj.zza(i10, 0, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i10 + i10 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return 0;
    }

    public final boolean zzf() {
        return true;
    }
}
