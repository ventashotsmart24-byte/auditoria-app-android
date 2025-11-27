package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdi implements zzaq {
    final /* synthetic */ RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc = 0;

    public zzdi(RemoteMediaPlayer remoteMediaPlayer) {
        this.zza = remoteMediaPlayer;
    }

    public final long zza() {
        long j10 = this.zzc + 1;
        this.zzc = j10;
        return j10;
    }

    public final void zzb(String str, String str2, long j10, String str3) {
        GoogleApiClient googleApiClient = this.zzb;
        if (googleApiClient != null) {
            Cast.CastApi.sendMessage(googleApiClient, str, str2).setResultCallback(new zzdh(this, j10));
            return;
        }
        throw new IllegalStateException("No GoogleApiClient available");
    }

    public final void zzc(GoogleApiClient googleApiClient) {
        this.zzb = googleApiClient;
    }
}
