package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

public final class zzkc extends zzf {
    protected final zzkb zza = new zzkb(this);
    protected final zzka zzb = new zzka(this);
    protected final zzjy zzc = new zzjy(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    public zzkc(zzfr zzfr) {
        super(zzfr);
    }

    public static /* bridge */ /* synthetic */ void zzj(zzkc zzkc, long j10) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j10));
        zzkc.zzc.zza(j10);
        if (zzkc.zzt.zzf().zzu()) {
            zzkc.zzb.zzb(j10);
        }
    }

    public static /* bridge */ /* synthetic */ void zzl(zzkc zzkc, long j10) {
        zzkc.zzg();
        zzkc.zzm();
        zzkc.zzt.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j10));
        if (zzkc.zzt.zzf().zzu() || zzkc.zzt.zzm().zzm.zzb()) {
            zzkc.zzb.zzc(j10);
        }
        zzkc.zzc.zzb();
        zzkb zzkb = zzkc.zza;
        zzkb.zza.zzg();
        if (zzkb.zza.zzt.zzJ()) {
            zzkb.zzb(zzkb.zza.zzt.zzav().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    public final boolean zzf() {
        return false;
    }
}
