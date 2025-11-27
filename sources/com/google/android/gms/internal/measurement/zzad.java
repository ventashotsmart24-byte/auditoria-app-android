package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb = 0;

    public zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final boolean hasNext() {
        if (this.zzb < this.zza.zzc()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zzb < this.zza.zzc()) {
            zzae zzae = this.zza;
            int i10 = this.zzb;
            this.zzb = i10 + 1;
            return zzae.zze(i10);
        }
        int i11 = this.zzb;
        throw new NoSuchElementException("Out of bounds index: " + i11);
    }
}
