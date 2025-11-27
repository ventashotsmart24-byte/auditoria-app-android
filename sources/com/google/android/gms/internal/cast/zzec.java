package com.google.android.gms.internal.cast;

import java.util.Map;
import javax.annotation.CheckForNull;

final class zzec<K, V> extends zzdv<K, V> {
    static final zzdv<Object, Object> zza = new zzec((Object) null, new Object[0], 0);
    final transient Object[] zzb;

    private zzec(@CheckForNull Object obj, Object[] objArr, int i10) {
        this.zzb = objArr;
    }

    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        return null;
    }

    public final int size() {
        return 0;
    }

    public final zzdq<V> zza() {
        return new zzeb(this.zzb, 1, 0);
    }

    public final zzdw<Map.Entry<K, V>> zzd() {
        return new zzdz(this, this.zzb, 0, 0);
    }

    public final zzdw<K> zze() {
        return new zzea(this, new zzeb(this.zzb, 0, 0));
    }
}
