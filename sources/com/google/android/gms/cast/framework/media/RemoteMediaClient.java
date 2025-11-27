package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadOptions;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.zzan;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzco;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class RemoteMediaClient implements Cast.MessageReceivedCallback {
    @RecentlyNonNull
    public static final String NAMESPACE = zzap.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    @VisibleForTesting
    final List<Callback> zza = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public final Handler zzc = new zzco(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final zzap zzd;
    private final zzbg zze;
    private final MediaQueue zzf;
    private zzr zzg;
    /* access modifiers changed from: private */
    public final List<Listener> zzh = new CopyOnWriteArrayList();
    private final Map<ProgressListener, zzbq> zzi = new ConcurrentHashMap();
    private final Map<Long, zzbq> zzj = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public ParseAdsInfoCallback zzk;

    public static abstract class Callback {
        public void onAdBreakStatusUpdated() {
        }

        public void onMediaError(@RecentlyNonNull MediaError mediaError) {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onStatusUpdated() {
        }

        public void zza(@RecentlyNonNull int[] iArr) {
        }

        public void zzb(@RecentlyNonNull int[] iArr, int i10) {
        }

        public void zzc(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr) {
        }

        public void zzd(@RecentlyNonNull int[] iArr) {
        }

        public void zze(@RecentlyNonNull List<Integer> list, @RecentlyNonNull List<Integer> list2, int i10) {
        }

        public void zzf(@RecentlyNonNull int[] iArr) {
        }

        public void zzg() {
        }
    }

    @Deprecated
    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        @RecentlyNullable
        JSONObject getCustomData();

        @RecentlyNullable
        MediaError getMediaError();
    }

    public interface ParseAdsInfoCallback {
        @RecentlyNonNull
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(@RecentlyNonNull MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(@RecentlyNonNull MediaStatus mediaStatus);
    }

    public interface ProgressListener {
        void onProgressUpdated(long j10, long j11);
    }

    public RemoteMediaClient(zzap zzap) {
        zzbg zzbg = new zzbg(this);
        this.zze = zzbg;
        zzap zzap2 = (zzap) Preconditions.checkNotNull(zzap);
        this.zzd = zzap2;
        zzap2.zzS(new zzbo(this, (zzbn) null));
        zzap2.zzh(zzbg);
        this.zzf = new MediaQueue(this, 20, 20);
    }

    @RecentlyNonNull
    public static PendingResult<MediaChannelResult> zzd(int i10, String str) {
        zzbi zzbi = new zzbi();
        zzbi.setResult(new zzbh(zzbi, new Status(i10, str)));
        return zzbi;
    }

    public static /* bridge */ /* synthetic */ void zzl(RemoteMediaClient remoteMediaClient) {
        for (zzbq next : remoteMediaClient.zzj.values()) {
            if (remoteMediaClient.hasMediaSession() && !next.zzi()) {
                next.zzf();
            } else if (!remoteMediaClient.hasMediaSession() && next.zzi()) {
                next.zzg();
            }
            if (next.zzi() && (remoteMediaClient.isBuffering() || remoteMediaClient.zzp() || remoteMediaClient.isPaused() || remoteMediaClient.isLoadingNextItem())) {
                remoteMediaClient.zzr(next.zzb);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzr(Set<ProgressListener> set) {
        MediaInfo media;
        HashSet<ProgressListener> hashSet = new HashSet<>(set);
        if (isPlaying() || isPaused() || isBuffering() || zzp()) {
            for (ProgressListener onProgressUpdated : hashSet) {
                onProgressUpdated.onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
            }
        } else if (isLoadingNextItem()) {
            MediaQueueItem loadingItem = getLoadingItem();
            if (loadingItem != null && (media = loadingItem.getMedia()) != null) {
                for (ProgressListener onProgressUpdated2 : hashSet) {
                    onProgressUpdated2.onProgressUpdated(0, media.getStreamDuration());
                }
            }
        } else {
            for (ProgressListener onProgressUpdated3 : hashSet) {
                onProgressUpdated3.onProgressUpdated(0, 0);
            }
        }
    }

    private final boolean zzs() {
        return this.zzg != null;
    }

    private static final zzbl zzt(zzbl zzbl) {
        try {
            zzbl.zzc();
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Throwable unused) {
            zzbl.setResult(new zzbk(zzbl, new Status(2100)));
        }
        return zzbl;
    }

    @Deprecated
    public void addListener(@RecentlyNonNull Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.add(listener);
        }
    }

    public boolean addProgressListener(@RecentlyNonNull ProgressListener progressListener, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (progressListener == null || this.zzi.containsKey(progressListener)) {
            return false;
        }
        Map<Long, zzbq> map = this.zzj;
        Long valueOf = Long.valueOf(j10);
        zzbq zzbq = map.get(valueOf);
        if (zzbq == null) {
            zzbq = new zzbq(this, j10);
            this.zzj.put(valueOf, zzbq);
        }
        zzbq.zzd(progressListener);
        this.zzi.put(progressListener, zzbq);
        if (!hasMediaSession()) {
            return true;
        }
        zzbq.zzf();
        return true;
    }

    public long getApproximateAdBreakClipPositionMs() {
        long zzj2;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzj2 = this.zzd.zzj();
        }
        return zzj2;
    }

    public long getApproximateLiveSeekableRangeEnd() {
        long zzk2;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzk2 = this.zzd.zzk();
        }
        return zzk2;
    }

    public long getApproximateLiveSeekableRangeStart() {
        long zzl;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzl = this.zzd.zzl();
        }
        return zzl;
    }

    public long getApproximateStreamPosition() {
        long zzm;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzm = this.zzd.zzm();
        }
        return zzm;
    }

    @RecentlyNullable
    public MediaQueueItem getCurrentItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId());
    }

    public int getIdleReason() {
        int i10;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            if (mediaStatus != null) {
                i10 = mediaStatus.getIdleReason();
            } else {
                i10 = 0;
            }
        }
        return i10;
    }

    @RecentlyNullable
    public MediaQueueItem getLoadingItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    @RecentlyNullable
    public MediaInfo getMediaInfo() {
        MediaInfo zzK;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzK = this.zzd.zzK();
        }
        return zzK;
    }

    @RecentlyNonNull
    public MediaQueue getMediaQueue() {
        MediaQueue mediaQueue;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaQueue = this.zzf;
        }
        return mediaQueue;
    }

    @RecentlyNullable
    public MediaStatus getMediaStatus() {
        MediaStatus zzL;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzL = this.zzd.zzL();
        }
        return zzL;
    }

    @RecentlyNonNull
    public String getNamespace() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzd.zze();
    }

    public int getPlayerState() {
        int i10;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            if (mediaStatus != null) {
                i10 = mediaStatus.getPlayerState();
            } else {
                i10 = 1;
            }
        }
        return i10;
    }

    @RecentlyNullable
    public MediaQueueItem getPreloadedItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getPreloadedItemId());
    }

    public long getStreamDuration() {
        long zzo;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzo = this.zzd.zzo();
        }
        return zzo;
    }

    public boolean hasMediaSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (isBuffering() || zzp() || isPlaying() || isPaused() || isLoadingNextItem()) {
            return true;
        }
        return false;
    }

    public boolean isBuffering() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || mediaStatus.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    public boolean isLiveStream() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || mediaInfo.getStreamType() != 2) {
            return false;
        }
        return true;
    }

    public boolean isLoadingNextItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) {
            return false;
        }
        return true;
    }

    public boolean isPaused() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return false;
        }
        if (mediaStatus.getPlayerState() == 3) {
            return true;
        }
        if (!isLiveStream() || getIdleReason() != 2) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || mediaStatus.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public boolean isPlayingAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || !mediaStatus.isPlayingAd()) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo) {
        return load(mediaInfo, new MediaLoadOptions.Builder().build());
    }

    public void onMessageReceived(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this.zzd.zzQ(str2);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause() {
        return pause((JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play() {
        return play((JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueAppendItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, @RecentlyNonNull JSONObject jSONObject) {
        return queueInsertItems(new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzai zzai = new zzai(this, mediaQueueItem, i10, j10, jSONObject);
        zzt(zzai);
        return zzai;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertItems(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzah zzah = new zzah(this, mediaQueueItemArr, i10, jSONObject);
        zzt(zzah);
        return zzah;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(int i10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzar zzar = new zzar(this, i10, j10, jSONObject);
        zzt(zzar);
        return zzar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzag zzag = new zzag(this, mediaQueueItemArr, i10, i11, j10, jSONObject);
        zzt(zzag);
        return zzag;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(int i10, int i11, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzas zzas = new zzas(this, i10, i11, jSONObject);
        zzt(zzas);
        return zzas;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzao zzao = new zzao(this, jSONObject);
        zzt(zzao);
        return zzao;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzan zzan = new zzan(this, jSONObject);
        zzt(zzan);
        return zzan;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItem(int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzaq zzaq = new zzaq(this, i10, jSONObject);
        zzt(zzaq);
        return zzaq;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItems(@RecentlyNonNull int[] iArr, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzak zzak = new zzak(this, iArr, jSONObject);
        zzt(zzak);
        return zzak;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueReorderItems(@RecentlyNonNull int[] iArr, int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzal zzal = new zzal(this, iArr, i10, jSONObject);
        zzt(zzal);
        return zzal;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueSetRepeatMode(int i10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzap zzap = new zzap(this, i10, jSONObject);
        zzt(zzap);
        return zzap;
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public PendingResult<MediaChannelResult> queueShuffle(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzam zzam = new zzam(this, jSONObject);
        zzt(zzam);
        return zzam;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueUpdateItems(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzaj zzaj = new zzaj(this, mediaQueueItemArr, jSONObject);
        zzt(zzaj);
        return zzaj;
    }

    public void registerCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.add(callback);
        }
    }

    @Deprecated
    public void removeListener(@RecentlyNonNull Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.remove(listener);
        }
    }

    public void removeProgressListener(@RecentlyNonNull ProgressListener progressListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbq remove = this.zzi.remove(progressListener);
        if (remove != null) {
            remove.zze(progressListener);
            if (!remove.zzh()) {
                this.zzj.remove(Long.valueOf(remove.zzb()));
                remove.zzg();
            }
        }
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzad zzad = new zzad(this);
        zzt(zzad);
        return zzad;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10) {
        return seek(j10, 0, (JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setActiveMediaTracks(@RecentlyNonNull long[] jArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzae zzae = new zzae(this, jArr);
        zzt(zzae);
        return zzae;
    }

    public void setParseAdsInfoCallback(@RecentlyNonNull ParseAdsInfoCallback parseAdsInfoCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzk = parseAdsInfoCallback;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setPlaybackRate(double d10) {
        return setPlaybackRate(d10, (JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(boolean z10) {
        return setStreamMute(z10, (JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(double d10) {
        return setStreamVolume(d10, (JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzaf zzaf = new zzaf(this, textTrackStyle);
        zzt(zzaf);
        return zzaf;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> skipAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzac zzac = new zzac(this);
        zzt(zzac);
        return zzac;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop() {
        return stop((JSONObject) null);
    }

    public void togglePlayback() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == 2) {
            pause();
        } else {
            play();
        }
    }

    public void unregisterCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.remove(callback);
        }
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zze(String str, List list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzax zzax = new zzax(this, true, str, (List) null);
        zzt(zzax);
        return zzax;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzf(int i10, int i11, int i12) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzav zzav = new zzav(this, true, i10, i11, i12);
        zzt(zzav);
        return zzav;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzg() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzat zzat = new zzat(this, true);
        zzt(zzat);
        return zzat;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzh(@RecentlyNonNull int[] iArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzau zzau = new zzau(this, true, iArr);
        zzt(zzau);
        return zzau;
    }

    @RecentlyNonNull
    public final Task<SessionState> zzi(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return Tasks.forException(new zzan());
        }
        SessionState sessionState = null;
        if (((MediaStatus) Preconditions.checkNotNull(getMediaStatus())).isMediaCommandSupported(MediaStatus.COMMAND_STREAM_TRANSFER)) {
            return this.zzd.zzN((JSONObject) null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        MediaInfo mediaInfo = getMediaInfo();
        MediaStatus mediaStatus = getMediaStatus();
        if (!(mediaInfo == null || mediaStatus == null)) {
            MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
            builder.setMediaInfo(mediaInfo);
            builder.setCurrentTime(getApproximateStreamPosition());
            builder.setQueueData(mediaStatus.getQueueData());
            builder.setPlaybackRate(mediaStatus.getPlaybackRate());
            builder.setActiveTrackIds(mediaStatus.getActiveTrackIds());
            builder.setCustomData(mediaStatus.getCustomData());
            MediaLoadRequestData build = builder.build();
            SessionState.Builder builder2 = new SessionState.Builder();
            builder2.setLoadRequestData(build);
            sessionState = builder2.build();
        }
        taskCompletionSource.setResult(sessionState);
        return taskCompletionSource.getTask();
    }

    public final void zzn() {
        zzr zzr = this.zzg;
        if (zzr != null) {
            zzr.zzi(getNamespace(), this);
            requestStatus();
        }
    }

    public final void zzo(zzr zzr) {
        zzr zzr2 = this.zzg;
        if (zzr2 != zzr) {
            if (zzr2 != null) {
                this.zzd.zzf();
                this.zzf.zzl();
                zzr2.zzg(getNamespace());
                this.zze.zzc((zzr) null);
                this.zzc.removeCallbacksAndMessages((Object) null);
            }
            this.zzg = zzr;
            if (zzr != null) {
                this.zze.zzc(zzr);
            }
        }
    }

    public final boolean zzp() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || mediaStatus.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public final boolean zzq() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!isLiveStream()) {
            return true;
        }
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null || !mediaStatus.isMediaCommandSupported(2) || mediaStatus.getLiveSeekableRange() == null) {
            return false;
        }
        return true;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, @RecentlyNonNull MediaLoadOptions mediaLoadOptions) {
        MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
        builder.setMediaInfo(mediaInfo);
        builder.setAutoplay(Boolean.valueOf(mediaLoadOptions.getAutoplay()));
        builder.setCurrentTime(mediaLoadOptions.getPlayPosition());
        builder.setPlaybackRate(mediaLoadOptions.getPlaybackRate());
        builder.setActiveTrackIds(mediaLoadOptions.getActiveTrackIds());
        builder.setCustomData(mediaLoadOptions.getCustomData());
        builder.setCredentials(mediaLoadOptions.getCredentials());
        builder.setCredentialsType(mediaLoadOptions.getCredentialsType());
        return load(builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzay zzay = new zzay(this, jSONObject);
        zzt(zzay);
        return zzay;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzba zzba = new zzba(this, jSONObject);
        zzt(zzba);
        return zzba;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10, int i10) {
        return seek(j10, i10, (JSONObject) null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setPlaybackRate(double d10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzbe zzbe = new zzbe(this, d10, jSONObject);
        zzt(zzbe);
        return zzbe;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(boolean z10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzbd zzbd = new zzbd(this, z10, jSONObject);
        zzt(zzbd);
        return zzbd;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(double d10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzbc zzbc = new zzbc(this, d10, jSONObject);
        zzt(zzbc);
        return zzbc;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzaz zzaz = new zzaz(this, jSONObject);
        zzt(zzaz);
        return zzaz;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10, int i10, JSONObject jSONObject) {
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j10);
        builder.setResumeState(i10);
        builder.setCustomData(jSONObject);
        return seek(builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, @RecentlyNonNull JSONObject jSONObject) {
        return queueInsertAndPlayItem(mediaQueueItem, i10, -1, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(int i10, @RecentlyNonNull JSONObject jSONObject) {
        return queueJumpToItem(i10, -1, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, @RecentlyNonNull JSONObject jSONObject) {
        return queueLoad(mediaQueueItemArr, i10, i11, -1, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> seek(@RecentlyNonNull MediaSeekOptions mediaSeekOptions) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzbb zzbb = new zzbb(this, mediaSeekOptions);
        zzt(zzbb);
        return zzbb;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, @RecentlyNonNull long[] jArr, @RecentlyNonNull JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        builder.setActiveTrackIds(jArr);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaLoadRequestData mediaLoadRequestData) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, (String) null);
        }
        zzaw zzaw = new zzaw(this, mediaLoadRequestData);
        zzt(zzaw);
        return zzaw;
    }
}
