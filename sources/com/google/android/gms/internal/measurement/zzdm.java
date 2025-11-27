package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzdm extends zzdu {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdm(zzef zzef, zzbz zzbz, int i10) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = zzbz;
        this.zzb = i10;
    }

    public final void zza() {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).getTestFlag(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zza.zze((Bundle) null);
    }
}
