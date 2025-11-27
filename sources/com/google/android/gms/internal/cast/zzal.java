package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzal implements OnSuccessListener {
    public final /* synthetic */ zzam zza;
    public final /* synthetic */ zzan zzb;

    public /* synthetic */ zzal(zzam zzam, zzan zzan) {
        this.zza = zzam;
        this.zzb = zzan;
    }

    public final void onSuccess(Object obj) {
        zzam zzam = this.zza;
        Void voidR = (Void) obj;
        int i10 = CastSession.zza;
        zzam.setResult(new Status(0));
    }
}
