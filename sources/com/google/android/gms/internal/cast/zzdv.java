package com.google.android.gms.internal.cast;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public abstract class zzdv<K, V> implements Map<K, V>, Serializable {
    @CheckForNull
    private transient zzdw<Map.Entry<K, V>> zza;
    @CheckForNull
    private transient zzdw<K> zzb;
    @CheckForNull
    private transient zzdq<V> zzc;

    public static <K, V> zzdv<K, V> zzc() {
        return zzec.zza;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return false;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v10) {
        return v10;
    }

    public final int hashCode() {
        return zzed.zza(entrySet());
    }

    public final boolean isEmpty() {
        return true;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzdw<K> zzdw = this.zzb;
        if (zzdw != null) {
            return zzdw;
        }
        zzdw<K> zze = zze();
        this.zzb = zze;
        return zze;
    }

    @CheckForNull
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
            sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
            boolean z10 = true;
            for (Map.Entry entry : entrySet()) {
                if (!z10) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
                sb.append(entry.getValue());
                z10 = false;
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("size cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public abstract zzdq<V> zza();

    /* renamed from: zzb */
    public final zzdq<V> values() {
        zzdq<V> zzdq = this.zzc;
        if (zzdq != null) {
            return zzdq;
        }
        zzdq<V> zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzdw<Map.Entry<K, V>> zzd();

    public abstract zzdw<K> zze();

    /* renamed from: zzf */
    public final zzdw<Map.Entry<K, V>> entrySet() {
        zzdw<Map.Entry<K, V>> zzdw = this.zza;
        if (zzdw != null) {
            return zzdw;
        }
        zzdw<Map.Entry<K, V>> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
