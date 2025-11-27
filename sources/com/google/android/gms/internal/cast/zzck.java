package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class zzck extends zza {
    public zzck(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() {
        zzd(3, zza());
    }

    public final void zzf(zzcj zzcj, int i10) {
        Parcel zza = zza();
        zzc.zze(zza, zzcj);
        zza.writeInt(i10);
        zzd(5, zza);
    }

    public final void zzg(zzcj zzcj, zzcm zzcm, String str, String str2, Bundle bundle) {
        Parcel zza = zza();
        zzc.zze(zza, zzcj);
        zzc.zze(zza, zzcm);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(7, zza);
    }

    public final void zzh(zzcj zzcj, PendingIntent pendingIntent, String str, String str2, Bundle bundle) {
        Parcel zza = zza();
        zzc.zze(zza, zzcj);
        zzc.zzc(zza, pendingIntent);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(8, zza);
    }

    public final void zzi(zzcj zzcj) {
        Parcel zza = zza();
        zzc.zze(zza, zzcj);
        zzd(6, zza);
    }
}
