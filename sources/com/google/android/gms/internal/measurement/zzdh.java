package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

final class zzdh extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzef zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdh(zzef zzef, Bundle bundle, zzbz zzbz) {
        super(zzef, true);
        this.zzc = zzef;
        this.zza = bundle;
        this.zzb = zzbz;
    }

    public final void zza() {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).performAction(this.zza, this.zzb, this.zzh);
    }

    public final void zzb() {
        this.zzb.zze((Bundle) null);
    }
}
