package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzaa extends zza implements IGmsCallbacks {
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void onPostInitComplete(int i10, IBinder iBinder, Bundle bundle) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zza.writeStrongBinder(iBinder);
        zzc.zzd(zza, bundle);
        zzC(1, zza);
    }

    public final void zzb(int i10, Bundle bundle) {
        throw null;
    }

    public final void zzc(int i10, IBinder iBinder, zzj zzj) {
        throw null;
    }
}
