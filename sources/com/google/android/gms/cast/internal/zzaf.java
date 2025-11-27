package com.google.android.gms.cast.internal;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzaf extends zzb implements zzag {
    public zzaf() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 1:
                zzk(parcel.readInt());
                return true;
            case 2:
                zzb((ApplicationMetadata) zzc.zza(parcel, ApplicationMetadata.CREATOR), parcel.readString(), parcel.readString(), zzc.zzf(parcel));
                return true;
            case 3:
                zzc(parcel.readInt());
                return true;
            case 4:
                zzn(parcel.readString(), parcel.readDouble(), zzc.zzf(parcel));
                return true;
            case 5:
                zzp(parcel.readString(), parcel.readString());
                return true;
            case 6:
                zzh(parcel.readString(), parcel.createByteArray());
                return true;
            case 7:
                zze(parcel.readInt());
                return true;
            case 8:
                zzg(parcel.readInt());
                return true;
            case 9:
                zzd(parcel.readInt());
                return true;
            case 10:
                zzm(parcel.readString(), parcel.readLong(), parcel.readInt());
                return true;
            case 11:
                zzl(parcel.readString(), parcel.readLong());
                return true;
            case 12:
                zzf((zza) zzc.zza(parcel, zza.CREATOR));
                return true;
            case 13:
                zzj((zzy) zzc.zza(parcel, zzy.CREATOR));
                return true;
            case 14:
                zzi(parcel.readInt());
                return true;
            case 15:
                zzo(parcel.readInt());
                return true;
            default:
                return false;
        }
    }
}
