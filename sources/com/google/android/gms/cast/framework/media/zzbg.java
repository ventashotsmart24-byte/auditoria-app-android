package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.zzr;
import java.util.concurrent.atomic.AtomicLong;

final class zzbg implements zzaq {
    final /* synthetic */ RemoteMediaClient zza;
    private zzr zzb;
    private final AtomicLong zzc = new AtomicLong((CastUtils.zzb() & 65535) * NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);

    public zzbg(RemoteMediaClient remoteMediaClient) {
        this.zza = remoteMediaClient;
    }

    public final long zza() {
        return this.zzc.getAndIncrement();
    }

    public final void zzb(String str, String str2, long j10, String str3) {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzh(str, str2).addOnFailureListener(new zzbf(this, j10));
            return;
        }
        throw new IllegalStateException("Device is not connected");
    }

    public final void zzc(zzr zzr) {
        this.zzb = zzr;
    }
}
