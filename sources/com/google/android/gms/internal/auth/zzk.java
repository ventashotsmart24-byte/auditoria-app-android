package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzk extends zzn {
    private final /* synthetic */ zzj zzaf;

    public zzk(zzj zzj) {
        this.zzaf = zzj;
    }

    public final void zzc(Account account) {
        Status status;
        zzj zzj = this.zzaf;
        if (account != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzh.zzad;
        }
        zzj.setResult(new zzo(status, account));
    }
}
