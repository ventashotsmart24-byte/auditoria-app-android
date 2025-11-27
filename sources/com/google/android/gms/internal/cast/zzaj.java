package com.google.android.gms.internal.cast;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import n0.o1;
import n0.s0;
import n0.t0;

public final class zzaj extends zzr {
    private final t0 zza;
    private final Map<s0, Set<t0.b>> zzb = new HashMap();
    private zzar zzc;

    public zzaj(t0 t0Var, CastOptions castOptions) {
        this.zza = t0Var;
        if (Build.VERSION.SDK_INT > 30) {
            boolean zzc2 = castOptions.zzc();
            boolean zzd = castOptions.zzd();
            t0Var.v(new o1.a().b(zzc2).c(zzd).a());
            if (zzc2) {
                zzl.zzd(zzju.CAST_OUTPUT_SWITCHER_ENABLED);
            }
            if (zzd) {
                this.zzc = new zzar();
                t0Var.u(new zzag(this.zzc));
                zzl.zzd(zzju.CAST_TRANSFER_TO_LOCAL_ENABLED);
            }
        }
    }

    private final void zzr(s0 s0Var, int i10) {
        for (t0.b b10 : this.zzb.get(s0Var)) {
            this.zza.b(s0Var, b10, i10);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzs */
    public final void zzp(s0 s0Var) {
        for (t0.b q10 : this.zzb.get(s0Var)) {
            this.zza.q(q10);
        }
    }

    public final Bundle zzb(String str) {
        for (t0.i iVar : this.zza.l()) {
            if (iVar.k().equals(str)) {
                return iVar.i();
            }
        }
        return null;
    }

    public final String zzc() {
        return this.zza.m().k();
    }

    public final void zzd(Bundle bundle, int i10) {
        s0 d10 = s0.d(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzr(d10, i10);
        } else {
            new zzco(Looper.getMainLooper()).post(new zzai(this, d10, i10));
        }
    }

    public final void zze(Bundle bundle, zzu zzu) {
        s0 d10 = s0.d(bundle);
        if (!this.zzb.containsKey(d10)) {
            this.zzb.put(d10, new HashSet());
        }
        this.zzb.get(d10).add(new zzae(zzu));
    }

    public final void zzf() {
        for (Set<t0.b> it : this.zzb.values()) {
            for (t0.b q10 : it) {
                this.zza.q(q10);
            }
        }
        this.zzb.clear();
    }

    public final void zzg(Bundle bundle) {
        s0 d10 = s0.d(bundle);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzp(d10);
        } else {
            new zzco(Looper.getMainLooper()).post(new zzah(this, d10));
        }
    }

    public final void zzh() {
        t0 t0Var = this.zza;
        t0Var.s(t0Var.g());
    }

    public final void zzi(String str) {
        for (t0.i iVar : this.zza.l()) {
            if (iVar.k().equals(str)) {
                this.zza.s(iVar);
                return;
            }
        }
    }

    public final void zzj(int i10) {
        this.zza.x(i10);
    }

    public final boolean zzk() {
        t0.i f10 = this.zza.f();
        if (f10 == null || !this.zza.m().k().equals(f10.k())) {
            return false;
        }
        return true;
    }

    public final boolean zzl() {
        t0.i g10 = this.zza.g();
        if (g10 == null || !this.zza.m().k().equals(g10.k())) {
            return false;
        }
        return true;
    }

    public final boolean zzm(Bundle bundle, int i10) {
        return this.zza.o(s0.d(bundle), i10);
    }

    public final zzar zzn() {
        return this.zzc;
    }

    public final /* synthetic */ void zzo(s0 s0Var, int i10) {
        synchronized (this.zzb) {
            zzr(s0Var, i10);
        }
    }

    public final void zzq(MediaSessionCompat mediaSessionCompat) {
        this.zza.t(mediaSessionCompat);
    }
}
