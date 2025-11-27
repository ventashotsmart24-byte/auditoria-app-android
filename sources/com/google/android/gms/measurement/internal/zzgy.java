package com.google.android.gms.measurement.internal;

public final /* synthetic */ class zzgy implements Runnable {
    public final /* synthetic */ zzhx zza;

    public /* synthetic */ zzgy(zzhx zzhx) {
        this.zza = zzhx;
    }

    public final void run() {
        zzhx zzhx = this.zza;
        zzhx.zzg();
        if (!zzhx.zzt.zzm().zzn.zzb()) {
            long zza2 = zzhx.zzt.zzm().zzo.zza();
            zzhx.zzt.zzm().zzo.zzb(1 + zza2);
            zzhx.zzt.zzf();
            if (zza2 >= 5) {
                zzhx.zzt.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhx.zzt.zzm().zzn.zza(true);
                return;
            }
            zzhx.zzt.zzE();
            return;
        }
        zzhx.zzt.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
