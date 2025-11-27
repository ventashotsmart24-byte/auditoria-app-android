package com.google.android.gms.cast;

import n0.t0;

final class zzac extends t0.b {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzac(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    public final void onRouteUnselected(t0 t0Var, t0.i iVar) {
        this.zza.zzv("onRouteUnselected");
        if (this.zza.zzm == null) {
            this.zza.zzv("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(iVar.i());
        if (fromBundle == null || !fromBundle.getDeviceId().equals(this.zza.zzm.getDeviceId())) {
            this.zza.zzv("onRouteUnselected, device does not match");
        } else {
            CastRemoteDisplayLocalService.stopService();
        }
    }
}
