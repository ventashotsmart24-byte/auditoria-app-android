package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzb;
import com.google.android.gms.cast.framework.media.widget.zzc;
import com.google.android.gms.cast.framework.media.widget.zze;
import java.util.ArrayList;
import java.util.List;

public final class zzas extends UIController implements RemoteMediaClient.ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final zza zzc;

    public zzas(CastSeekBar castSeekBar, long j10, zza zza2) {
        this.zza = castSeekBar;
        this.zzb = j10;
        this.zzc = zza2;
        zzc();
    }

    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    public final void onMediaStatusUpdated() {
        zzc();
    }

    public final void onProgressUpdated(long j10, long j11) {
        zzb();
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().addProgressListener(this, this.zzb);
        }
        zzc();
    }

    public final void onSessionEnded() {
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zzc();
    }

    public final void zza() {
        int i10;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        AdBreakClipInfo adBreakClipInfo = null;
        if (remoteMediaClient == null || !remoteMediaClient.isPlayingAd()) {
            CastSeekBar castSeekBar = this.zza;
            castSeekBar.zzb = null;
            castSeekBar.postInvalidate();
            return;
        }
        int approximateAdBreakClipPositionMs = (int) remoteMediaClient.getApproximateAdBreakClipPositionMs();
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        if (mediaStatus != null) {
            adBreakClipInfo = mediaStatus.getCurrentAdBreakClip();
        }
        if (adBreakClipInfo != null) {
            i10 = (int) adBreakClipInfo.getDurationInMs();
        } else {
            i10 = approximateAdBreakClipPositionMs;
        }
        if (approximateAdBreakClipPositionMs < 0) {
            approximateAdBreakClipPositionMs = 0;
        }
        if (i10 < 0) {
            i10 = 1;
        }
        if (approximateAdBreakClipPositionMs > i10) {
            i10 = approximateAdBreakClipPositionMs;
        }
        CastSeekBar castSeekBar2 = this.zza;
        castSeekBar2.zzb = new zzc(approximateAdBreakClipPositionMs, i10);
        castSeekBar2.postInvalidate();
    }

    public final void zzb() {
        int i10;
        int i11;
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        boolean z10 = true;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        zze zze = new zze();
        zze.zza = this.zzc.zza();
        zze.zzb = this.zzc.zzb();
        zze.zzc = (int) (-this.zzc.zze());
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !remoteMediaClient2.zzq()) {
            i10 = this.zzc.zza();
        } else {
            i10 = this.zzc.zzd();
        }
        zze.zzd = i10;
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        if (remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || !remoteMediaClient3.zzq()) {
            i11 = this.zzc.zza();
        } else {
            i11 = this.zzc.zzc();
        }
        zze.zze = i11;
        RemoteMediaClient remoteMediaClient4 = super.getRemoteMediaClient();
        if (remoteMediaClient4 == null || !remoteMediaClient4.hasMediaSession() || !remoteMediaClient4.zzq()) {
            z10 = false;
        }
        zze.zzf = z10;
        this.zza.zze(zze);
    }

    public final void zzc() {
        int i10;
        zzb();
        ArrayList arrayList = null;
        if (super.getRemoteMediaClient() == null) {
            this.zza.zzd((List<zzb>) null);
        } else {
            MediaInfo mediaInfo = super.getRemoteMediaClient().getMediaInfo();
            if (!super.getRemoteMediaClient().hasMediaSession() || super.getRemoteMediaClient().isLoadingNextItem() || mediaInfo == null) {
                this.zza.zzd((List<zzb>) null);
            } else {
                CastSeekBar castSeekBar = this.zza;
                List<AdBreakInfo> adBreaks = mediaInfo.getAdBreaks();
                if (adBreaks != null) {
                    arrayList = new ArrayList();
                    for (AdBreakInfo next : adBreaks) {
                        if (next != null) {
                            long playbackPositionInMs = next.getPlaybackPositionInMs();
                            if (playbackPositionInMs == -1000) {
                                i10 = this.zzc.zzb();
                            } else {
                                i10 = Math.min((int) (playbackPositionInMs - this.zzc.zze()), this.zzc.zzb());
                            }
                            if (i10 >= 0) {
                                arrayList.add(new zzb(i10, (int) next.getDurationInMs(), next.isExpanded()));
                            }
                        }
                    }
                }
                castSeekBar.zzd(arrayList);
            }
        }
        zza();
    }
}
