package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzac extends zzb implements zzad {
    public zzac() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 1) {
            return false;
        }
        zzb((Bundle) zzc.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
