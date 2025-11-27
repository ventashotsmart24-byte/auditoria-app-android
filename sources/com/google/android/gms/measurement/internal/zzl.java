package com.google.android.gms.measurement.internal;

final class zzl implements Runnable {
    final /* synthetic */ zzo zza;
    final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzo zzo) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzo;
    }

    public final void run() {
        this.zzb.zza.zzq().zzT(this.zza);
    }
}
