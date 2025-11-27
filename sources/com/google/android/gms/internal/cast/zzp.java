package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzh;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzaf;
import com.google.android.gms.cast.framework.zzag;
import com.google.android.gms.cast.framework.zzai;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzar;
import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.cast.framework.zzv;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzy;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzp extends zza implements zzq {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    public final zzw zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzs, Map map) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, zzs);
        zza.writeMap(map);
        Parcel zzb = zzb(1, zza);
        zzw zzb2 = zzv.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzz zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, zzt zzt) {
        Parcel zza = zza();
        zzc.zzc(zza, castOptions);
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzt);
        Parcel zzb = zzb(3, zza);
        zzz zzb2 = zzy.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzag zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, iObjectWrapper2);
        zzc.zze(zza, iObjectWrapper3);
        Parcel zzb = zzb(5, zza);
        zzag zzb2 = zzaf.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzaj zzh(String str, String str2, zzar zzar) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzar);
        Parcel zzb = zzb(2, zza);
        zzaj zzb2 = zzai.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }

    public final zzi zzi(IObjectWrapper iObjectWrapper, zzk zzk, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14) {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzk);
        zza.writeInt(i10);
        zza.writeInt(i11);
        zzc.zzb(zza, false);
        zza.writeLong(2097152);
        zza.writeInt(5);
        zza.writeInt(333);
        zza.writeInt(10000);
        Parcel zzb = zzb(6, zza);
        zzi zzb2 = zzh.zzb(zzb.readStrongBinder());
        zzb.recycle();
        return zzb2;
    }
}
