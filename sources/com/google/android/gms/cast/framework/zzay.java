package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;

final class zzay extends zzao {
    final /* synthetic */ SessionProvider zza;

    public /* synthetic */ zzay(SessionProvider sessionProvider, zzax zzax) {
        this.zza = sessionProvider;
    }

    public final IObjectWrapper zzb(String str) {
        Session createSession = this.zza.createSession(str);
        if (createSession == null) {
            return null;
        }
        return createSession.zzl();
    }

    public final String zzc() {
        return this.zza.getCategory();
    }

    public final boolean zzd() {
        return this.zza.isSessionRecoverable();
    }
}
