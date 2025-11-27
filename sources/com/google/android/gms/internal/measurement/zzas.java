package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzas implements Iterator {
    final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzas(zzat zzat) {
        this.zza = zzat;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i10 = this.zzb;
        zzat zzat = this.zza;
        if (i10 < zzat.zza.length()) {
            String zzb2 = zzat.zza;
            this.zzb = i10 + 1;
            return new zzat(String.valueOf(zzb2.charAt(i10)));
        }
        throw new NoSuchElementException();
    }
}
