package com.google.android.gms.internal.cast;

import java.io.Serializable;
import javax.annotation.CheckForNull;

public abstract class zzdf<T> implements Serializable {
    public static <T> zzdf<T> zzb(@CheckForNull T t10) {
        if (t10 == null) {
            return zzdc.zza;
        }
        return new zzdk(t10);
    }

    @CheckForNull
    public abstract T zza();
}
