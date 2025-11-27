package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

final class zzdt extends zzdu {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzdu zzc;

    public zzdt(zzdu zzdu, int i10, int i11) {
        this.zzc = zzdu;
        this.zza = i10;
        this.zzb = i11;
    }

    public final Object get(int i10) {
        zzdj.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i10 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final boolean zzf() {
        return true;
    }

    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzdu zzh(int i10, int i11) {
        zzdj.zzd(i10, i11, this.zzb);
        zzdu zzdu = this.zzc;
        int i12 = this.zza;
        return zzdu.subList(i10 + i12, i11 + i12);
    }
}
