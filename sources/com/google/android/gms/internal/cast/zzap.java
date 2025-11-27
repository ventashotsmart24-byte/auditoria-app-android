package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzap implements OnFailureListener {
    public final /* synthetic */ zzar zza;

    public /* synthetic */ zzap(zzar zzar) {
        this.zza = zzar;
    }

    public final void onFailure(Exception exc) {
        zzar.zza(this.zza, exc);
    }
}
