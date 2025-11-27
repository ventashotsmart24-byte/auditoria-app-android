package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzad extends zza implements zzaf {
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final zzq zze(zzo zzo) {
        Parcel zza = zza();
        zzc.zzd(zza, zzo);
        Parcel zzB = zzB(6, zza);
        zzq zzq = (zzq) zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }

    public final zzq zzf(zzo zzo) {
        Parcel zza = zza();
        zzc.zzd(zza, zzo);
        Parcel zzB = zzB(8, zza);
        zzq zzq = (zzq) zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }

    public final boolean zzg() {
        Parcel zzB = zzB(9, zza());
        boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }

    public final boolean zzh(zzs zzs, IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zzd(zza, zzs);
        zzc.zzf(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }

    public final boolean zzi() {
        Parcel zzB = zzB(7, zza());
        boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }
}
