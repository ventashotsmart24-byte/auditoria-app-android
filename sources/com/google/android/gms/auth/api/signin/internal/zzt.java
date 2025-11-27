package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zzd;
import com.google.android.gms.internal.p001authapi.zze;

public abstract class zzt extends zzd implements zzs {
    public zzt() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public final boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 101:
                zzc((GoogleSignInAccount) zze.zzc(parcel, GoogleSignInAccount.CREATOR), (Status) zze.zzc(parcel, Status.CREATOR));
                break;
            case 102:
                zze((Status) zze.zzc(parcel, Status.CREATOR));
                break;
            case 103:
                zzf((Status) zze.zzc(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
