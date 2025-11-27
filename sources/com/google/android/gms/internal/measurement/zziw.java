package com.google.android.gms.internal.measurement;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

final class zziw implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzje zzje = (zzje) obj;
        zzje zzje2 = (zzje) obj2;
        zziv zziv = new zziv(zzje);
        zziv zziv2 = new zziv(zzje2);
        while (zziv.hasNext() && zziv2.hasNext()) {
            int compareTo = Integer.valueOf(zziv.zza() & UnsignedBytes.MAX_VALUE).compareTo(Integer.valueOf(zziv2.zza() & UnsignedBytes.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzje.zzd()).compareTo(Integer.valueOf(zzje2.zzd()));
    }
}
