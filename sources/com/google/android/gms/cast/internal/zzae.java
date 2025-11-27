package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbq;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzae extends zza {
    public zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze() {
        zzd(17, zza());
    }

    public final void zzf() {
        zzd(1, zza());
    }

    public final void zzg(String str, String str2, zzbq zzbq) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, zzbq);
        zzd(14, zza);
    }

    public final void zzh(String str, LaunchOptions launchOptions) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, launchOptions);
        zzd(13, zza);
    }

    public final void zzi() {
        zzd(4, zza());
    }

    public final void zzj(zzag zzag) {
        Parcel zza = zza();
        zzc.zze(zza, zzag);
        zzd(18, zza);
    }

    public final void zzk(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(11, zza);
    }

    public final void zzl() {
        zzd(6, zza());
    }

    public final void zzm(String str, String str2, long j10) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j10);
        zzd(9, zza);
    }

    public final void zzn(boolean z10, double d10, boolean z11) {
        Parcel zza = zza();
        zzc.zzb(zza, z10);
        zza.writeDouble(d10);
        zzc.zzb(zza, z11);
        zzd(8, zza);
    }

    public final void zzo(double d10, double d11, boolean z10) {
        Parcel zza = zza();
        zza.writeDouble(d10);
        zza.writeDouble(d11);
        zzc.zzb(zza, z10);
        zzd(7, zza);
    }

    public final void zzp(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(5, zza);
    }

    public final void zzq() {
        zzd(19, zza());
    }

    public final void zzr(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(12, zza);
    }
}
