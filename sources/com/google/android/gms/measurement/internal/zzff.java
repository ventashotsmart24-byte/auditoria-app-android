package com.google.android.gms.measurement.internal;

import androidx.collection.e;
import com.google.android.gms.common.internal.Preconditions;

final class zzff extends e {
    final /* synthetic */ zzfi zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzff(zzfi zzfi, int i10) {
        super(20);
        this.zza = zzfi;
    }

    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfi.zzd(this.zza, str);
    }
}
