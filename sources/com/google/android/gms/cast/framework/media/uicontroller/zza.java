package com.google.android.gms.cast.framework.media.uicontroller;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.text.DateFormat;
import java.util.Date;

@ShowFirstParty
public final class zza {
    RemoteMediaClient zza;

    private zza() {
    }

    public static zza zzf() {
        return new zza();
    }

    private final MediaMetadata zzo() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || (mediaInfo = this.zza.getMediaInfo()) == null) {
            return null;
        }
        return mediaInfo.getMetadata();
    }

    private static final String zzp(long j10) {
        if (j10 >= 0) {
            return DateUtils.formatElapsedTime(j10 / 1000);
        }
        String valueOf = String.valueOf(DateUtils.formatElapsedTime((-j10) / 1000));
        if (valueOf.length() != 0) {
            return Operator.Operation.MINUS.concat(valueOf);
        }
        return new String(Operator.Operation.MINUS);
    }

    public final int zza() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return 0;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (!remoteMediaClient2.isLiveStream() && remoteMediaClient2.isLoadingNextItem()) {
            return 0;
        }
        int approximateStreamPosition = (int) (remoteMediaClient2.getApproximateStreamPosition() - zze());
        if (remoteMediaClient2.zzq()) {
            approximateStreamPosition = CastUtils.zza(approximateStreamPosition, zzd(), zzc());
        }
        return CastUtils.zza(approximateStreamPosition, 0, zzb());
    }

    public final int zzb() {
        MediaInfo media;
        RemoteMediaClient remoteMediaClient = this.zza;
        long j10 = 1;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            if (remoteMediaClient2.isLiveStream()) {
                Long zzi = zzi();
                if (zzi != null) {
                    j10 = zzi.longValue();
                } else {
                    Long zzg = zzg();
                    j10 = zzg != null ? zzg.longValue() : Math.max(remoteMediaClient2.getApproximateStreamPosition(), 1);
                }
            } else if (remoteMediaClient2.isLoadingNextItem()) {
                MediaQueueItem loadingItem = remoteMediaClient2.getLoadingItem();
                if (!(loadingItem == null || (media = loadingItem.getMedia()) == null)) {
                    j10 = Math.max(media.getStreamDuration(), 1);
                }
            } else {
                j10 = Math.max(remoteMediaClient2.getStreamDuration(), 1);
            }
        }
        return Math.max((int) (j10 - zze()), 1);
    }

    public final int zzc() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream()) {
            return zzb();
        }
        if (!this.zza.zzq()) {
            return 0;
        }
        return CastUtils.zza((int) (((Long) Preconditions.checkNotNull(zzg())).longValue() - zze()), 0, zzb());
    }

    public final int zzd() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzq()) {
            return 0;
        }
        return CastUtils.zza((int) (((Long) Preconditions.checkNotNull(zzh())).longValue() - zze()), 0, zzb());
    }

    public final long zze() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream()) {
            return 0;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        Long zzj = zzj();
        if (zzj != null) {
            return zzj.longValue();
        }
        Long zzh = zzh();
        if (zzh != null) {
            return zzh.longValue();
        }
        return remoteMediaClient2.getApproximateStreamPosition();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r3.zza;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long zzg() {
        /*
            r3 = this;
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            r1 = 0
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.hasMediaSession()
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            boolean r0 = r0.isLiveStream()
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            boolean r0 = r0.zzq()
            if (r0 != 0) goto L_0x001c
            goto L_0x0033
        L_0x001c:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            com.google.android.gms.cast.MediaStatus r2 = r0.getMediaStatus()
            if (r2 == 0) goto L_0x0033
            com.google.android.gms.cast.MediaLiveSeekableRange r2 = r2.getLiveSeekableRange()
            if (r2 == 0) goto L_0x0033
            long r0 = r0.getApproximateLiveSeekableRangeEnd()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.uicontroller.zza.zzg():java.lang.Long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r3.zza;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long zzh() {
        /*
            r3 = this;
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            r1 = 0
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.hasMediaSession()
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            boolean r0 = r0.isLiveStream()
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            boolean r0 = r0.zzq()
            if (r0 != 0) goto L_0x001c
            goto L_0x0033
        L_0x001c:
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r3.zza
            com.google.android.gms.cast.MediaStatus r2 = r0.getMediaStatus()
            if (r2 == 0) goto L_0x0033
            com.google.android.gms.cast.MediaLiveSeekableRange r2 = r2.getLiveSeekableRange()
            if (r2 == 0) goto L_0x0033
            long r0 = r0.getApproximateLiveSeekableRangeStart()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.uicontroller.zza.zzh():java.lang.Long");
    }

    public final Long zzi() {
        MediaMetadata zzo;
        Long zzj;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (zzo = zzo()) == null || !zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || (zzj = zzj()) == null) {
            return null;
        }
        return Long.valueOf(zzj.longValue() + zzo.getTimeMillis(MediaMetadata.KEY_SECTION_DURATION));
    }

    public final Long zzj() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            MediaInfo mediaInfo = remoteMediaClient2.getMediaInfo();
            MediaMetadata zzo = zzo();
            if (mediaInfo != null && zzo != null && zzo.containsKey(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA) && (zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || remoteMediaClient2.zzq())) {
                return Long.valueOf(zzo.getTimeMillis(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA));
            }
        }
        return null;
    }

    public final Long zzk() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (mediaInfo = this.zza.getMediaInfo()) == null || mediaInfo.getStartAbsoluteTime() == -1) {
            return null;
        }
        return Long.valueOf(mediaInfo.getStartAbsoluteTime());
    }

    public final String zzl(long j10) {
        int i10;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return null;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || zzk() == null) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        if (i10 - 1 == 1) {
            return DateFormat.getTimeInstance().format(new Date(((Long) Preconditions.checkNotNull(zzk())).longValue() + j10));
        } else if (!remoteMediaClient2.isLiveStream() || zzj() != null) {
            return zzp(j10 - zze());
        } else {
            return zzp(j10);
        }
    }

    public final boolean zzm() {
        return zzn(((long) zza()) + zze());
    }

    public final boolean zzn(long j10) {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.zzq() || (((long) zzc()) + zze()) - j10 >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            return false;
        }
        return true;
    }
}
