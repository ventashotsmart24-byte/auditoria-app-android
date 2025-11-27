package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzkw;
import java.util.List;
import java.util.Map;

final class zza extends zzd {
    private final zzfr zza;
    private final zzhx zzb;

    public zza(zzfr zzfr) {
        super((zzc) null);
        Preconditions.checkNotNull(zzfr);
        this.zza = zzfr;
        this.zzb = zzfr.zzq();
    }

    public final int zza(String str) {
        this.zzb.zzh(str);
        return 25;
    }

    public final long zzb() {
        return this.zza.zzv().zzq();
    }

    public final Boolean zzc() {
        return this.zzb.zzi();
    }

    public final Double zzd() {
        return this.zzb.zzj();
    }

    public final Integer zze() {
        return this.zzb.zzl();
    }

    public final Long zzf() {
        return this.zzb.zzm();
    }

    public final Object zzg(int i10) {
        if (i10 == 0) {
            return this.zzb.zzr();
        }
        if (i10 == 1) {
            return this.zzb.zzm();
        }
        if (i10 == 2) {
            return this.zzb.zzj();
        }
        if (i10 != 3) {
            return this.zzb.zzi();
        }
        return this.zzb.zzl();
    }

    public final String zzh() {
        return this.zzb.zzo();
    }

    public final String zzi() {
        return this.zzb.zzp();
    }

    public final String zzj() {
        return this.zzb.zzq();
    }

    public final String zzk() {
        return this.zzb.zzo();
    }

    public final String zzl() {
        return this.zzb.zzr();
    }

    public final List zzm(String str, String str2) {
        return this.zzb.zzs(str, str2);
    }

    public final Map zzn(boolean z10) {
        List<zzkw> zzt = this.zzb.zzt(z10);
        a aVar = new a(zzt.size());
        for (zzkw zzkw : zzt) {
            Object zza2 = zzkw.zza();
            if (zza2 != null) {
                aVar.put(zzkw.zzb, zza2);
            }
        }
        return aVar;
    }

    public final Map zzo(String str, String str2, boolean z10) {
        return this.zzb.zzu(str, str2, z10);
    }

    public final void zzp(String str) {
        this.zza.zzd().zzd(str, this.zza.zzav().elapsedRealtime());
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.zza.zzd().zze(str, this.zza.zzav().elapsedRealtime());
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.zzb.zzD(str, str2, bundle);
    }

    public final void zzt(String str, String str2, Bundle bundle, long j10) {
        this.zzb.zzE(str, str2, bundle, true, false, j10);
    }

    public final void zzu(zzgs zzgs) {
        this.zzb.zzJ(zzgs);
    }

    public final void zzv(Bundle bundle) {
        this.zzb.zzP(bundle);
    }

    public final void zzw(zzgr zzgr) {
        this.zzb.zzT(zzgr);
    }

    public final void zzx(zzgs zzgs) {
        this.zzb.zzZ(zzgs);
    }
}
