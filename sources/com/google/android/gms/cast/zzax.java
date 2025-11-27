package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzae;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzax implements RemoteCall {
    public static final /* synthetic */ zzax zza = new zzax();

    private /* synthetic */ zzax() {
    }

    public final void accept(Object obj, Object obj2) {
        int i10 = zzbp.zzf;
        ((zzae) ((zzx) obj).getService()).zzl();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
