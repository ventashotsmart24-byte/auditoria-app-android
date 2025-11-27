package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzao extends zzb implements zzap {
    public zzao() {
        super("com.google.android.gms.cast.framework.ISessionProvider");
    }

    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1) {
            IObjectWrapper zzb = zzb(parcel.readString());
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb);
        } else if (i10 == 2) {
            boolean zzd = zzd();
            parcel2.writeNoException();
            zzc.zzb(parcel2, zzd);
        } else if (i10 == 3) {
            String zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        } else if (i10 != 4) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
