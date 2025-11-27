package com.google.android.gms.internal.cast;

import java.util.Set;
import javax.annotation.CheckForNull;

public abstract class zzdw<E> extends zzdq<E> implements Set<E> {
    @CheckForNull
    private transient zzdu<E> zza;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() != set.size() || !containsAll(set)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzed.zza(this);
    }

    public zzdu<E> zzd() {
        zzdu<E> zzdu = this.zza;
        if (zzdu != null) {
            return zzdu;
        }
        zzdu<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzee<E> iterator();

    public zzdu<E> zzh() {
        return zzdu.zzj(toArray());
    }
}
