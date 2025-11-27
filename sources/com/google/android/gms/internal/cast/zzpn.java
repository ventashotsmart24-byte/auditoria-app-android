package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzpn extends zzns<String> implements RandomAccess, zzpo {
    public static final zzpo zza;
    private static final zzpn zzb;
    private final List<Object> zzc;

    static {
        zzpn zzpn = new zzpn(10);
        zzb = zzpn;
        zzpn.zzb();
        zza = zzpn;
    }

    public zzpn() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzoe) {
            return ((zzoe) obj).zzm(zzph.zzb);
        }
        return zzph.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i10, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzpo) {
            collection = ((zzpo) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zza();
        Object remove = this.zzc.remove(i10);
        this.modCount++;
        return zzi(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zzi(this.zzc.set(i10, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final zzpo zzd() {
        if (zzc()) {
            return new zzri(this);
        }
        return this;
    }

    public final Object zze(int i10) {
        return this.zzc.get(i10);
    }

    /* renamed from: zzf */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzoe) {
            zzoe zzoe = (zzoe) obj;
            String zzm = zzoe.zzm(zzph.zzb);
            if (zzoe.zzi()) {
                this.zzc.set(i10, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzph.zzh(bArr);
        if (zzph.zzi(bArr)) {
            this.zzc.set(i10, zzh);
        }
        return zzh;
    }

    public final /* bridge */ /* synthetic */ zzpg zzg(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.zzc);
            return new zzpn((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzpn(int i10) {
        this.zzc = new ArrayList(i10);
    }

    private zzpn(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
