package com.google.android.gms.measurement.internal;

import java.util.Map;

public final /* synthetic */ class zzhz implements Runnable {
    public final /* synthetic */ zzia zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Exception zzc;
    public final /* synthetic */ byte[] zzd;
    public final /* synthetic */ Map zze;

    public /* synthetic */ zzhz(zzia zzia, int i10, Exception exc, byte[] bArr, Map map) {
        this.zza = zzia;
        this.zzb = i10;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
