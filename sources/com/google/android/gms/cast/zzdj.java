package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdj implements zzar {
    final /* synthetic */ zzdl zza;

    public zzdj(zzdl zzdl) {
        this.zza = zzdl;
    }

    public final void zza(long j10, int i10, Object obj) {
        JSONObject jSONObject = null;
        if (true != (obj instanceof zzao)) {
            obj = null;
        }
        try {
            zzdl zzdl = this.zza;
            Status status = new Status(i10);
            if (obj != null) {
                jSONObject = ((zzao) obj).zza;
            }
            zzdl.setResult(new zzdm(status, jSONObject));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", e10);
        }
    }

    public final void zzb(long j10) {
        try {
            zzdl zzdl = this.zza;
            zzdl.setResult(new zzdk(zzdl, new Status(2103)));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", e10);
        }
    }
}
