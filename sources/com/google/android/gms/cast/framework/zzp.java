package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.zzq;
import com.google.android.gms.common.ConnectionResult;

final class zzp extends zzq {
    final /* synthetic */ CastSession zza;

    public /* synthetic */ zzp(CastSession castSession, zzo zzo) {
        this.zza = castSession;
    }

    public final void zza() {
        if (this.zza.zze != null) {
            try {
                if (this.zza.zzi != null) {
                    this.zza.zzi.zzn();
                }
                this.zza.zze.zzh((Bundle) null);
            } catch (RemoteException e10) {
                CastSession.zzb.d(e10, "Unable to call %s on %s.", "onConnected", zzz.class.getSimpleName());
            }
        }
    }

    public final void zzb(int i10) {
        if (this.zza.zze != null) {
            try {
                this.zza.zze.zzi(new ConnectionResult(i10));
            } catch (RemoteException e10) {
                CastSession.zzb.d(e10, "Unable to call %s on %s.", "onConnectionFailed", zzz.class.getSimpleName());
            }
        }
    }

    public final void zzc(int i10) {
        if (this.zza.zze != null) {
            try {
                this.zza.zze.zzj(i10);
            } catch (RemoteException e10) {
                CastSession.zzb.d(e10, "Unable to call %s on %s.", "onConnectionSuspended", zzz.class.getSimpleName());
            }
        }
    }

    public final void zzd(int i10) {
        if (this.zza.zze != null) {
            try {
                this.zza.zze.zzi(new ConnectionResult(i10));
            } catch (RemoteException e10) {
                CastSession.zzb.d(e10, "Unable to call %s on %s.", "onDisconnected", zzz.class.getSimpleName());
            }
        }
    }
}
