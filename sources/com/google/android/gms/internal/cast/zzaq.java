package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class zzaq implements OnSuccessListener {
    public final /* synthetic */ zzar zza;

    public /* synthetic */ zzaq(zzar zzar) {
        this.zza = zzar;
    }

    public final void onSuccess(Object obj) {
        zzar.zzb(this.zza, (SessionState) obj);
    }
}
