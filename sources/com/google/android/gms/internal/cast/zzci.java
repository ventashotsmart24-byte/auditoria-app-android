package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.view.Surface;

public abstract class zzci extends zzb implements zzcj {
    public zzci() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            zzb(parcel.readInt(), parcel.readInt(), (Surface) zzc.zza(parcel, Surface.CREATOR));
        } else if (i10 == 2) {
            zzd(parcel.readInt());
        } else if (i10 == 3) {
            zzf();
        } else if (i10 == 4) {
            zzc();
        } else if (i10 != 5) {
            return false;
        } else {
            zze(zzc.zzf(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
