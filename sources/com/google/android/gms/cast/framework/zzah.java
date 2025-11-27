package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzah extends zza implements zzaj {
    public zzah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ISession");
    }

    public final int zze() {
        Parcel zzb = zzb(17, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final int zzf() {
        Parcel zzb = zzb(18, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final IObjectWrapper zzg() {
        Parcel zzb = zzb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    public final String zzh() {
        Parcel zzb = zzb(2, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final String zzi() {
        Parcel zzb = zzb(3, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void zzj(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(15, zza);
    }

    public final void zzk(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(12, zza);
    }

    public final void zzl(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(13, zza);
    }

    public final void zzm(boolean z10) {
        Parcel zza = zza();
        zzc.zzb(zza, z10);
        zzc(14, zza);
    }

    public final void zzn(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(11, zza);
    }

    public final void zzo(int i10) {
        Parcel zza = zza();
        zza.writeInt(i10);
        zzc(16, zza);
    }

    public final boolean zzp() {
        Parcel zzb = zzb(5, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzq() {
        Parcel zzb = zzb(6, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzr() {
        Parcel zzb = zzb(8, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzs() {
        Parcel zzb = zzb(7, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzt() {
        Parcel zzb = zzb(9, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }

    public final boolean zzu() {
        Parcel zzb = zzb(10, zza());
        boolean zzf = zzc.zzf(zzb);
        zzb.recycle();
        return zzf;
    }
}
