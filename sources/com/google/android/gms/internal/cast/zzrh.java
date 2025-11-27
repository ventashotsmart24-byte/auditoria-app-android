package com.google.android.gms.internal.cast;

import java.util.Iterator;

final class zzrh implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzri zzb;

    public zzrh(zzri zzri) {
        this.zzb = zzri;
        this.zza = zzri.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
