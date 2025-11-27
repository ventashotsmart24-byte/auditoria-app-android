package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

final class zznv extends zzny {
    final /* synthetic */ zzoe zza;
    private int zzb = 0;
    private final int zzc;

    public zznv(zzoe zzoe) {
        this.zza = zzoe;
        this.zzc = zzoe.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i10 = this.zzb;
        if (i10 < this.zzc) {
            this.zzb = i10 + 1;
            return this.zza.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
