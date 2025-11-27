package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzms implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzmt zzb;

    public zzms(zzmt zzmt) {
        this.zzb = zzmt;
        this.zza = zzmt.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
