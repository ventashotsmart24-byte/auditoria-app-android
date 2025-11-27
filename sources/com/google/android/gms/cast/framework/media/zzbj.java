package com.google.android.gms.cast.framework.media;

import android.util.Log;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbj implements zzar {
    final /* synthetic */ zzbl zza;

    public zzbj(zzbl zzbl) {
        this.zza = zzbl;
    }

    public final void zza(long j10, int i10, Object obj) {
        JSONObject jSONObject;
        MediaError mediaError = null;
        if (true != (obj instanceof zzao)) {
            obj = null;
        }
        try {
            zzbl zzbl = this.zza;
            Status status = new Status(i10);
            if (obj != null) {
                jSONObject = ((zzao) obj).zza;
            } else {
                jSONObject = null;
            }
            if (obj != null) {
                mediaError = ((zzao) obj).zzb;
            }
            zzbl.setResult(new zzbm(status, jSONObject, mediaError));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestCompleted", e10);
        }
    }

    public final void zzb(long j10) {
        try {
            zzbl zzbl = this.zza;
            zzbl.setResult(new zzbk(zzbl, new Status(2103)));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestReplaced", e10);
        }
    }
}
