package com.google.android.gms.internal.cast;

final class zzds<E> extends zzdn<E> {
    private final zzdu<E> zza;

    public zzds(zzdu<E> zzdu, int i10) {
        super(zzdu.size(), i10);
        this.zza = zzdu;
    }

    public final E zza(int i10) {
        return this.zza.get(i10);
    }
}
