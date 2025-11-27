package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzar implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzar(zzat zzat) {
        this.zza = zzat;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.zzb;
        if (i10 < this.zza.zza.length()) {
            this.zzb = i10 + 1;
            return new zzat(String.valueOf(i10));
        }
        throw new NoSuchElementException();
    }
}
