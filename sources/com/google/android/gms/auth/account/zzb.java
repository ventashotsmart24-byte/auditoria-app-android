package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzc;

public abstract class zzb extends com.google.android.gms.internal.auth.zzb implements zza {
    public zzb() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    public final boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            zzc((Account) zzc.zza(parcel, Account.CREATOR));
        } else if (i10 != 2) {
            return false;
        } else {
            zza(zzc.zza(parcel));
        }
        return true;
    }
}
