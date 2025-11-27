package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzm;

public class ReconnectionService extends Service {
    private static final Logger zza = new Logger("ReconnectionService");
    private zzag zzb;

    @RecentlyNullable
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        zzag zzag = this.zzb;
        if (zzag != null) {
            try {
                return zzag.zzf(intent);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "onBind", zzag.class.getSimpleName());
            }
        }
        return null;
    }

    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzag zzc = zzm.zzc(this, sharedInstance.getSessionManager().zzb(), sharedInstance.zzb().zza());
        this.zzb = zzc;
        if (zzc != null) {
            try {
                zzc.zzg();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "onCreate", zzag.class.getSimpleName());
            }
            super.onCreate();
        }
    }

    public void onDestroy() {
        zzag zzag = this.zzb;
        if (zzag != null) {
            try {
                zzag.zzh();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "onDestroy", zzag.class.getSimpleName());
            }
            super.onDestroy();
        }
    }

    public int onStartCommand(@RecentlyNonNull Intent intent, int i10, int i11) {
        zzag zzag = this.zzb;
        if (zzag != null) {
            try {
                return zzag.zze(intent, i10, i11);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "onStartCommand", zzag.class.getSimpleName());
            }
        }
        return 2;
    }
}
