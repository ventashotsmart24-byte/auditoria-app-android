package com.google.android.gms.internal.cast;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

final class zznx implements Comparator<zzoe> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzoe zzoe = (zzoe) obj;
        zzoe zzoe2 = (zzoe) obj2;
        zznv zznv = new zznv(zzoe);
        zznv zznv2 = new zznv(zzoe2);
        while (zznv.hasNext() && zznv2.hasNext()) {
            int zza = zznw.zza(zznv.zza() & UnsignedBytes.MAX_VALUE, zznv2.zza() & UnsignedBytes.MAX_VALUE);
            if (zza != 0) {
                return zza;
            }
        }
        return zznw.zza(zzoe.zzd(), zzoe2.zzd());
    }
}
