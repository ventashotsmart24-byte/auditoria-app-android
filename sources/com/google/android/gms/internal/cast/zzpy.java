package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzpy<K, V> extends LinkedHashMap<K, V> {
    private static final zzpy zza;
    private boolean zzb = true;

    static {
        zzpy zzpy = new zzpy();
        zza = zzpy;
        zzpy.zzb = false;
    }

    private zzpy() {
    }

    private static int zze(Object obj) {
        if (obj instanceof byte[]) {
            return zzph.zzb((byte[]) obj);
        }
        if (!(obj instanceof zzpa)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zzf() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzf();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z10;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z10 = value.equals(obj2);
                continue;
            } else {
                z10 = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i10 = 0;
        for (Map.Entry entry : entrySet()) {
            i10 += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return i10;
    }

    public final V put(K k10, V v10) {
        zzf();
        zzph.zze(k10);
        zzph.zze(v10);
        return super.put(k10, v10);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzf();
        for (Object next : map.keySet()) {
            zzph.zze(next);
            zzph.zze(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final zzpy<K, V> zza() {
        if (isEmpty()) {
            return new zzpy<>();
        }
        return new zzpy<>(this);
    }

    public final void zzb() {
        this.zzb = false;
    }

    public final void zzc(zzpy<K, V> zzpy) {
        zzf();
        if (!zzpy.isEmpty()) {
            putAll(zzpy);
        }
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zzpy(Map<K, V> map) {
        super(map);
    }
}
