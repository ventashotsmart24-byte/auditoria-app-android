package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzhe extends ContentObserver {
    final /* synthetic */ zzhf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzhe(zzhf zzhf, Handler handler) {
        super((Handler) null);
        this.zza = zzhf;
    }

    public final void onChange(boolean z10) {
        this.zza.zzf();
    }
}
