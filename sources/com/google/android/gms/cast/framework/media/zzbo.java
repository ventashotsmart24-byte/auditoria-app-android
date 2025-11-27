package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.zzam;
import java.util.List;

final class zzbo implements zzam {
    final /* synthetic */ RemoteMediaClient zza;

    public /* synthetic */ zzbo(RemoteMediaClient remoteMediaClient, zzbn zzbn) {
        this.zza = remoteMediaClient;
    }

    private final void zzn() {
        MediaStatus mediaStatus;
        if (this.zza.zzk != null && (mediaStatus = this.zza.getMediaStatus()) != null) {
            mediaStatus.getWriter().setIsPlayingAd(this.zza.zzk.parseIsPlayingAdFromMediaStatus(mediaStatus));
            List<AdBreakInfo> parseAdBreaksFromMediaStatus = this.zza.zzk.parseAdBreaksFromMediaStatus(mediaStatus);
            MediaInfo mediaInfo = this.zza.getMediaInfo();
            if (mediaInfo != null) {
                mediaInfo.getWriter().setAdBreaks(parseAdBreaksFromMediaStatus);
            }
        }
    }

    public final void zza() {
        for (RemoteMediaClient.Listener onAdBreakStatusUpdated : this.zza.zzh) {
            onAdBreakStatusUpdated.onAdBreakStatusUpdated();
        }
        for (RemoteMediaClient.Callback onAdBreakStatusUpdated2 : this.zza.zza) {
            onAdBreakStatusUpdated2.onAdBreakStatusUpdated();
        }
    }

    public final void zzb(MediaError mediaError) {
        for (RemoteMediaClient.Callback onMediaError : this.zza.zza) {
            onMediaError.onMediaError(mediaError);
        }
    }

    public final void zzc() {
        zzn();
        for (RemoteMediaClient.Listener onMetadataUpdated : this.zza.zzh) {
            onMetadataUpdated.onMetadataUpdated();
        }
        for (RemoteMediaClient.Callback onMetadataUpdated2 : this.zza.zza) {
            onMetadataUpdated2.onMetadataUpdated();
        }
    }

    public final void zzd() {
        for (RemoteMediaClient.Listener onPreloadStatusUpdated : this.zza.zzh) {
            onPreloadStatusUpdated.onPreloadStatusUpdated();
        }
        for (RemoteMediaClient.Callback onPreloadStatusUpdated2 : this.zza.zza) {
            onPreloadStatusUpdated2.onPreloadStatusUpdated();
        }
    }

    public final void zze(int[] iArr) {
        for (RemoteMediaClient.Callback zza2 : this.zza.zza) {
            zza2.zza(iArr);
        }
    }

    public final void zzf(int[] iArr, int i10) {
        for (RemoteMediaClient.Callback zzb : this.zza.zza) {
            zzb.zzb(iArr, i10);
        }
    }

    public final void zzg(MediaQueueItem[] mediaQueueItemArr) {
        for (RemoteMediaClient.Callback zzc : this.zza.zza) {
            zzc.zzc(mediaQueueItemArr);
        }
    }

    public final void zzh(int[] iArr) {
        for (RemoteMediaClient.Callback zzd : this.zza.zza) {
            zzd.zzd(iArr);
        }
    }

    public final void zzi(List<Integer> list, List<Integer> list2, int i10) {
        for (RemoteMediaClient.Callback zze : this.zza.zza) {
            zze.zze(list, list2, i10);
        }
    }

    public final void zzj(int[] iArr) {
        for (RemoteMediaClient.Callback zzf : this.zza.zza) {
            zzf.zzf(iArr);
        }
    }

    public final void zzk() {
        for (RemoteMediaClient.Listener onQueueStatusUpdated : this.zza.zzh) {
            onQueueStatusUpdated.onQueueStatusUpdated();
        }
        for (RemoteMediaClient.Callback onQueueStatusUpdated2 : this.zza.zza) {
            onQueueStatusUpdated2.onQueueStatusUpdated();
        }
    }

    public final void zzl() {
        for (RemoteMediaClient.Callback zzg : this.zza.zza) {
            zzg.zzg();
        }
    }

    public final void zzm() {
        zzn();
        RemoteMediaClient.zzl(this.zza);
        for (RemoteMediaClient.Listener onStatusUpdated : this.zza.zzh) {
            onStatusUpdated.onStatusUpdated();
        }
        for (RemoteMediaClient.Callback onStatusUpdated2 : this.zza.zza) {
            onStatusUpdated2.onStatusUpdated();
        }
    }
}
