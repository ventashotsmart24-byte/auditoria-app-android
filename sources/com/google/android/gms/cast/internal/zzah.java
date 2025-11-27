package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

public final class zzah extends zza {
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void zze(IStatusCallback iStatusCallback, String[] strArr, String str, List list) {
        Parcel zza = zza();
        zzc.zze(zza, iStatusCallback);
        zza.writeStringArray(strArr);
        zza.writeString(str);
        zza.writeTypedList((List) null);
        zzd(2, zza);
    }

    public final void zzf(zzad zzad, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        zza.writeStringArray(strArr);
        zzd(5, zza);
    }

    public final void zzg(zzad zzad, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        zza.writeStringArray(strArr);
        zzd(7, zza);
    }

    public final void zzh(zzad zzad, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        zza.writeStringArray(strArr);
        zzd(6, zza);
    }
}
