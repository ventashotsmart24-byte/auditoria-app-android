package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzb implements OnSuccessListener {
    public final /* synthetic */ CastContext zza;

    public /* synthetic */ zzb(CastContext castContext) {
        this.zza = castContext;
    }

    public final void onSuccess(Object obj) {
        this.zza.zze((Bundle) obj);
    }
}
