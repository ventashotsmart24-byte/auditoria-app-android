package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzdz<K, V> extends zzdw<Map.Entry<K, V>> {
    private final transient zzdv<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;

    public zzdz(zzdv<K, V> zzdv, Object[] objArr, int i10, int i11) {
        this.zza = zzdv;
        this.zzb = objArr;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals((Object) null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return 0;
    }

    public final int zza(Object[] objArr, int i10) {
        return zzd().zza(objArr, 0);
    }

    public final zzee<Map.Entry<K, V>> zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzdu<Map.Entry<K, V>> zzh() {
        return new zzdy(this);
    }
}
