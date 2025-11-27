package com.google.android.gms.internal.cast;

import android.os.Parcel;

public abstract class zzcl extends zzb implements zzcm {
    public zzcl() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
    }

    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        zzb(parcel.readInt());
        return true;
    }
}
