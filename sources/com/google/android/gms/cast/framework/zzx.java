package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzx extends zza implements zzz {
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    public final void zze(boolean z10, int i10) {
        Parcel zza = zza();
        zzc.zzb(zza, z10);
        zza.writeInt(0);
        zzc(6, zza);
    }

    public final void zzf(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        Parcel zza = zza();
        zzc.zzc(zza, applicationMetadata);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z10);
        zzc(4, zza);
    }

    public final void zzg(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(5, zza);
    }

    public final void zzh(Bundle bundle) {
        Parcel zza = zza();
        zzc.zzc(zza, (Parcelable) null);
        zzc(1, zza);
    }

    public final void zzi(ConnectionResult connectionResult) {
        Parcel zza = zza();
        zzc.zzc(zza, connectionResult);
        zzc(3, zza);
    }

    public final void zzj(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(2, zza);
    }
}
