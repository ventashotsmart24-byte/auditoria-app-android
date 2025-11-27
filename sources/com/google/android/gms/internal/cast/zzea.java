package com.google.android.gms.internal.cast;

import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzea<K> extends zzdw<K> {
    private final transient zzdv<K, ?> zza;
    private final transient zzdu<K> zzb;

    public zzea(zzdv<K, ?> zzdv, zzdu<K> zzdu) {
        this.zza = zzdv;
        this.zzb = zzdu;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return 0;
    }

    public final int zza(Object[] objArr, int i10) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzdu<K> zzd() {
        return this.zzb;
    }

    public final zzee<K> zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }
}
