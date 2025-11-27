package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class zzq implements Handler.Callback {
    final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzr, zzp zzp) {
        this.zza = zzr;
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.zza.zzb) {
                zzn zzn = (zzn) message.obj;
                zzo zzo = (zzo) this.zza.zzb.get(zzn);
                if (zzo != null && zzo.zzi()) {
                    if (zzo.zzj()) {
                        zzo.zzg("GmsClientSupervisor");
                    }
                    this.zza.zzb.remove(zzn);
                }
            }
            return true;
        } else if (i10 != 1) {
            return false;
        } else {
            synchronized (this.zza.zzb) {
                zzn zzn2 = (zzn) message.obj;
                zzo zzo2 = (zzo) this.zza.zzb.get(zzn2);
                if (zzo2 != null && zzo2.zza() == 3) {
                    String valueOf = String.valueOf(zzn2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName zzb = zzo2.zzb();
                    if (zzb == null) {
                        zzb = zzn2.zzb();
                    }
                    if (zzb == null) {
                        String zzd = zzn2.zzd();
                        Preconditions.checkNotNull(zzd);
                        zzb = new ComponentName(zzd, "unknown");
                    }
                    zzo2.onServiceDisconnected(zzb);
                }
            }
            return true;
        }
    }
}
