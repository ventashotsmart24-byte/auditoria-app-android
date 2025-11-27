package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzc implements OnSuccessListener {
    public final /* synthetic */ CastContext zza;

    public /* synthetic */ zzc(CastContext castContext) {
        this.zza = castContext;
    }

    public final void onSuccess(Object obj) {
        CastContext.zzc(this.zza, (Bundle) obj);
    }
}
