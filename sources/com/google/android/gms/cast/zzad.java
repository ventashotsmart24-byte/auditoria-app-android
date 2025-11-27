package com.google.android.gms.cast;

final class zzad implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzad(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    public final void run() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        boolean zzs = castRemoteDisplayLocalService.zzs;
        StringBuilder sb = new StringBuilder(59);
        sb.append("onCreate after delay. The local service been started: ");
        sb.append(zzs);
        castRemoteDisplayLocalService.zzv(sb.toString());
        if (!this.zza.zzs) {
            CastRemoteDisplayLocalService.zza.e("[Instance: %s] %s", this.zza, "The local service has not been been started, stopping it");
            this.zza.stopSelf();
        }
    }
}
