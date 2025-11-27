package com.google.android.gms.internal.cast;

import android.os.IInterface;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzag;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzar;
import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzq extends IInterface {
    zzw zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzs zzs, Map map);

    zzz zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, zzt zzt);

    zzag zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    zzaj zzh(String str, String str2, zzar zzar);

    zzi zzi(IObjectWrapper iObjectWrapper, zzk zzk, int i10, int i11, boolean z10, long j10, int i12, int i13, int i14);
}
