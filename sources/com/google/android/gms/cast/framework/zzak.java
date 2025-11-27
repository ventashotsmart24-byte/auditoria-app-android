package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzak extends zza implements zzal {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISessionManager");
    }

    public final int zze() {
        Parcel zzb = zzb(8, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final IObjectWrapper zzf() {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzg() {
        Parcel zzb = zzb(7, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final void zzh(zzab zzab) {
        Parcel zza = zza();
        zzc.zze(zza, zzab);
        zzc(4, zza);
    }

    public final void zzi(zzan zzan) {
        Parcel zza = zza();
        zzc.zze(zza, zzan);
        zzc(2, zza);
    }

    public final void zzj(boolean z10, boolean z11) {
        Parcel zza = zza();
        zzc.zzb(zza, true);
        zzc.zzb(zza, z11);
        zzc(6, zza);
    }

    public final void zzk(zzab zzab) {
        Parcel zza = zza();
        zzc.zze(zza, zzab);
        zzc(5, zza);
    }

    public final void zzl(zzan zzan) {
        Parcel zza = zza();
        zzc.zze(zza, zzan);
        zzc(3, zza);
    }

    public final void zzm(Bundle bundle) {
        Parcel zza = zza();
        zzc.zzc(zza, bundle);
        zzc(9, zza);
    }
}
