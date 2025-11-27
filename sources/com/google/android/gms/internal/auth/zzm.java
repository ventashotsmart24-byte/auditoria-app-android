package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

final class zzm extends zzn {
    private final /* synthetic */ zzl zzag;

    public zzm(zzl zzl) {
        this.zzag = zzl;
    }

    public final void zza(boolean z10) {
        Status status;
        zzl zzl = this.zzag;
        if (z10) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzh.zzad;
        }
        zzl.setResult(new zzq(status));
    }
}
