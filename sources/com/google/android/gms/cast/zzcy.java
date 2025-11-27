package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

final class zzcy extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcy(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, int i11, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = i11;
        this.zzc = jSONObject;
    }

    public final void zza(zzw zzw) {
        int zza2 = RemoteMediaPlayer.zza(this.zzd, this.zza);
        int i10 = 0;
        if (zza2 == -1) {
            setResult(new zzdk(this, new Status(0)));
            return;
        }
        int i11 = this.zzb;
        if (i11 < 0) {
            setResult(new zzdk(this, new Status((int) CastStatusCodes.INVALID_REQUEST, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(this.zzb)}))));
        } else if (zza2 == i11) {
            setResult(new zzdk(this, new Status(0)));
        } else {
            MediaStatus mediaStatus = this.zzd.getMediaStatus();
            if (mediaStatus == null) {
                setResult(new zzdk(this, new Status((int) CastStatusCodes.INVALID_REQUEST, String.format(Locale.ROOT, "Invalid request: Invalid MediaStatus", new Object[0]))));
                return;
            }
            int i12 = this.zzb;
            if (i12 > zza2) {
                i12++;
            }
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i12);
            if (queueItem != null) {
                i10 = queueItem.getItemId();
            }
            this.zzd.zzb.zzz(zzb(), new int[]{this.zza}, i10, this.zzc);
        }
    }
}
