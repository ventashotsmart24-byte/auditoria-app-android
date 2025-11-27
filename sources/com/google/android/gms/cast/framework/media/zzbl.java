package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.zzan;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
abstract class zzbl extends BasePendingResult<RemoteMediaClient.MediaChannelResult> {
    private zzar zza;
    private final boolean zzb;
    final /* synthetic */ RemoteMediaClient zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbl(RemoteMediaClient remoteMediaClient, boolean z10) {
        super((GoogleApiClient) null);
        this.zzg = remoteMediaClient;
        this.zzb = z10;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbk(this, status);
    }

    public abstract void zza();

    public final zzar zzb() {
        if (this.zza == null) {
            this.zza = new zzbj(this);
        }
        return this.zza;
    }

    public final void zzc() {
        if (!this.zzb) {
            for (RemoteMediaClient.Listener onSendingRemoteMediaRequest : this.zzg.zzh) {
                onSendingRemoteMediaRequest.onSendingRemoteMediaRequest();
            }
            for (RemoteMediaClient.Callback onSendingRemoteMediaRequest2 : this.zzg.zza) {
                onSendingRemoteMediaRequest2.onSendingRemoteMediaRequest();
            }
        }
        try {
            synchronized (this.zzg.zzb) {
                zza();
            }
        } catch (zzan unused) {
            setResult(new zzbk(this, new Status(2100)));
        }
    }
}
