package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzav extends zzaq {
    final /* synthetic */ Session zza;

    public /* synthetic */ zzav(Session session, zzau zzau) {
        this.zza = session;
    }

    public final long zzb() {
        return this.zza.getSessionRemainingTimeMs();
    }

    public final IObjectWrapper zzc() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzd(boolean z10) {
        this.zza.end(z10);
    }

    public final void zze(Bundle bundle) {
        this.zza.onResuming(bundle);
    }

    public final void zzf(Bundle bundle) {
        this.zza.onStarting(bundle);
    }

    public final void zzg(Bundle bundle) {
        this.zza.resume(bundle);
    }

    public final void zzh(Bundle bundle) {
        this.zza.start(bundle);
    }

    public final void zzi(Bundle bundle) {
        this.zza.zzj(bundle);
    }
}
