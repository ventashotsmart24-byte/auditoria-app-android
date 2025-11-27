package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzri extends AbstractList<String> implements RandomAccess, zzpo {
    /* access modifiers changed from: private */
    public final zzpo zza;

    public zzri(zzpo zzpo) {
        this.zza = zzpo;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzpn) this.zza).get(i10);
    }

    public final Iterator<String> iterator() {
        return new zzrh(this);
    }

    public final ListIterator<String> listIterator(int i10) {
        return new zzrg(this, i10);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzpo zzd() {
        return this;
    }

    public final Object zze(int i10) {
        return this.zza.zze(i10);
    }

    public final List<?> zzh() {
        return this.zza.zzh();
    }
}
