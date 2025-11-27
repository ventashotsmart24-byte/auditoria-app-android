package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzei {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzei(String str, String str2, Bundle bundle, long j10) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j10;
    }

    public static zzei zzb(zzaw zzaw) {
        return new zzei(zzaw.zza, zzaw.zzc, zzaw.zzb.zzc(), zzaw.zzd);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zza;
        String obj = this.zzd.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }

    public final zzaw zza() {
        return new zzaw(this.zza, new zzau(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
