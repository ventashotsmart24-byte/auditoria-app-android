package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.dlna.DLNAControllerImp;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaStatusCreator")
@SafeParcelable.Reserved({1})
@VisibleForTesting
public class MediaStatus extends AbstractSafeParcelable {
    public static final long COMMAND_DISLIKE = 32768;
    public static final long COMMAND_EDIT_TRACKS = 4096;
    public static final long COMMAND_FOLLOW = 65536;
    public static final long COMMAND_LIKE = 16384;
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_PLAYBACK_RATE = 8192;
    public static final long COMMAND_QUEUE_NEXT = 64;
    public static final long COMMAND_QUEUE_PREVIOUS = 128;
    public static final long COMMAND_QUEUE_REPEAT = 3072;
    public static final long COMMAND_QUEUE_REPEAT_ALL = 1024;
    public static final long COMMAND_QUEUE_REPEAT_ONE = 2048;
    public static final long COMMAND_QUEUE_SHUFFLE = 256;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_AD = 512;
    @Deprecated
    public static final long COMMAND_SKIP_BACKWARD = 32;
    @Deprecated
    public static final long COMMAND_SKIP_FORWARD = 16;
    @ShowFirstParty
    @KeepForSdk
    public static final long COMMAND_STREAM_TRANSFER = 262144;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final long COMMAND_UNFOLLOW = 131072;
    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<MediaStatus> CREATOR = new zzci();
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_LOADING = 5;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private static final Logger zzw = new Logger("MediaStatus");
    @SafeParcelable.Field(getter = "getMediaInfo", id = 2)
    @VisibleForTesting
    MediaInfo zza;
    @SafeParcelable.Field(getter = "getMediaSessionId", id = 3)
    @VisibleForTesting
    long zzb;
    @SafeParcelable.Field(getter = "getCurrentItemId", id = 4)
    @VisibleForTesting
    int zzc;
    @SafeParcelable.Field(getter = "getPlaybackRate", id = 5)
    @VisibleForTesting
    double zzd;
    @SafeParcelable.Field(getter = "getPlayerState", id = 6)
    @VisibleForTesting
    int zze;
    @SafeParcelable.Field(getter = "getIdleReason", id = 7)
    @VisibleForTesting
    int zzf;
    @SafeParcelable.Field(getter = "getStreamPosition", id = 8)
    @VisibleForTesting
    long zzg;
    @SafeParcelable.Field(id = 9)
    long zzh;
    @SafeParcelable.Field(getter = "getStreamVolume", id = 10)
    @VisibleForTesting
    double zzi;
    @SafeParcelable.Field(getter = "isMute", id = 11)
    @VisibleForTesting
    boolean zzj;
    @SafeParcelable.Field(getter = "getActiveTrackIds", id = 12)
    @VisibleForTesting
    long[] zzk;
    @SafeParcelable.Field(getter = "getLoadingItemId", id = 13)
    @VisibleForTesting
    int zzl;
    @SafeParcelable.Field(getter = "getPreloadedItemId", id = 14)
    @VisibleForTesting
    int zzm;
    @SafeParcelable.Field(id = 15)
    String zzn;
    @VisibleForTesting
    JSONObject zzo;
    @SafeParcelable.Field(id = 16)
    int zzp;
    @SafeParcelable.Field(id = 17)
    final List<MediaQueueItem> zzq;
    @SafeParcelable.Field(getter = "isPlayingAd", id = 18)
    @VisibleForTesting
    boolean zzr;
    @SafeParcelable.Field(getter = "getAdBreakStatus", id = 19)
    @VisibleForTesting
    AdBreakStatus zzs;
    @SafeParcelable.Field(getter = "getVideoInfo", id = 20)
    @VisibleForTesting
    VideoInfo zzt;
    @SafeParcelable.Field(getter = "getLiveSeekableRange", id = 21)
    @VisibleForTesting
    MediaLiveSeekableRange zzu;
    @SafeParcelable.Field(getter = "getQueueData", id = 22)
    @VisibleForTesting
    MediaQueueData zzv;
    private final SparseArray<Integer> zzx;
    private final Writer zzy;

    @KeepForSdk
    public static class Builder {
        private MediaInfo zza;
        private long zzb;
        private int zzc = 0;
        private double zzd;
        private int zze = 0;
        private int zzf = 0;
        private long zzg;
        private long zzh;
        private double zzi;
        private boolean zzj;
        private long[] zzk;
        private int zzl = 0;
        private int zzm = 0;
        private JSONObject zzn;
        private int zzo = 0;
        private final List<MediaQueueItem> zzp = new ArrayList();
        private boolean zzq;
        private AdBreakStatus zzr;
        private VideoInfo zzs;
        private MediaLiveSeekableRange zzt;
        private MediaQueueData zzu;

        @RecentlyNonNull
        @KeepForSdk
        public MediaStatus build() {
            MediaStatus mediaStatus = r1;
            MediaStatus mediaStatus2 = new MediaStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, (String) null, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu);
            MediaStatus mediaStatus3 = mediaStatus;
            mediaStatus3.zzo = this.zzn;
            return mediaStatus3;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setActiveTrackIds(@RecentlyNonNull long[] jArr) {
            this.zzk = jArr;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdBreakStatus(@RecentlyNonNull AdBreakStatus adBreakStatus) {
            this.zzr = adBreakStatus;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setCurrentItemId(int i10) {
            this.zzc = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setCustomData(@RecentlyNonNull JSONObject jSONObject) {
            this.zzn = jSONObject;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIdleReason(int i10) {
            this.zzf = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIsMute(boolean z10) {
            this.zzj = z10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIsPlayingAd(boolean z10) {
            this.zzq = z10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setLiveSeekableRange(@RecentlyNonNull MediaLiveSeekableRange mediaLiveSeekableRange) {
            this.zzt = mediaLiveSeekableRange;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setLoadingItemId(int i10) {
            this.zzl = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.zza = mediaInfo;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setMediaSessionId(long j10) {
            this.zzb = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPlaybackRate(double d10) {
            this.zzd = d10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPlayerState(int i10) {
            this.zze = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPreloadedItemId(int i10) {
            this.zzm = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueData(@RecentlyNonNull MediaQueueData mediaQueueData) {
            this.zzu = mediaQueueData;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueItems(@RecentlyNonNull List<MediaQueueItem> list) {
            this.zzp.clear();
            this.zzp.addAll(list);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueRepeatMode(int i10) {
            this.zzo = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setStreamPosition(long j10) {
            this.zzg = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setStreamVolume(double d10) {
            this.zzi = d10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setSupportedMediaCommands(long j10) {
            this.zzh = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setVideoInfo(@RecentlyNonNull VideoInfo videoInfo) {
            this.zzs = videoInfo;
            return this;
        }
    }

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @KeepForSdk
        public void setActiveTrackIds(long[] jArr) {
            MediaStatus.this.zzk = jArr;
        }

        @KeepForSdk
        public void setAdBreakStatus(AdBreakStatus adBreakStatus) {
            MediaStatus.this.zzs = adBreakStatus;
        }

        @KeepForSdk
        public void setCurrentItemId(int i10) {
            MediaStatus.this.zzc = i10;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject) {
            MediaStatus mediaStatus = MediaStatus.this;
            mediaStatus.zzo = jSONObject;
            mediaStatus.zzn = null;
        }

        @KeepForSdk
        public void setIdleReason(int i10) {
            MediaStatus.this.zzf = i10;
        }

        @KeepForSdk
        public void setIsPlayingAd(boolean z10) {
            MediaStatus.this.zzr = z10;
        }

        @KeepForSdk
        public void setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange) {
            MediaStatus.this.zzu = mediaLiveSeekableRange;
        }

        @KeepForSdk
        public void setLoadingItemId(int i10) {
            MediaStatus.this.zzl = i10;
        }

        @KeepForSdk
        public void setMediaInfo(MediaInfo mediaInfo) {
            MediaStatus.this.zza = mediaInfo;
        }

        @KeepForSdk
        public void setMute(boolean z10) {
            MediaStatus.this.zzj = z10;
        }

        @KeepForSdk
        public void setPlaybackRate(double d10) {
            MediaStatus.this.zzd = d10;
        }

        @KeepForSdk
        public void setPlayerState(int i10) {
            MediaStatus.this.zze = i10;
        }

        @KeepForSdk
        public void setPreloadedItemId(int i10) {
            MediaStatus.this.zzm = i10;
        }

        @KeepForSdk
        public void setQueueData(MediaQueueData mediaQueueData) {
            MediaStatus.this.zzv = mediaQueueData;
        }

        @KeepForSdk
        public void setQueueItems(List<MediaQueueItem> list) {
            MediaStatus.this.zze(list);
        }

        @KeepForSdk
        public void setQueueRepeatMode(int i10) {
            MediaStatus.this.zzp = i10;
        }

        @KeepForSdk
        public void setStreamPosition(long j10) {
            MediaStatus.this.zzg = j10;
        }

        @KeepForSdk
        public void setStreamVolume(double d10) {
            MediaStatus.this.zzi = d10;
        }

        @KeepForSdk
        public void setSupportedMediaCommands(long j10) {
            MediaStatus.this.zzh = j10;
        }

        @KeepForSdk
        public void setVideoInfo(VideoInfo videoInfo) {
            MediaStatus.this.zzt = videoInfo;
        }
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public MediaStatus(@SafeParcelable.Param(id = 2) MediaInfo mediaInfo, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 5) double d10, @SafeParcelable.Param(id = 6) int i11, @SafeParcelable.Param(id = 7) int i12, @SafeParcelable.Param(id = 8) long j11, @SafeParcelable.Param(id = 9) long j12, @SafeParcelable.Param(id = 10) double d11, @SafeParcelable.Param(id = 11) boolean z10, @SafeParcelable.Param(id = 12) long[] jArr, @SafeParcelable.Param(id = 13) int i13, @SafeParcelable.Param(id = 14) int i14, @SafeParcelable.Param(id = 15) String str, @SafeParcelable.Param(id = 16) int i15, @SafeParcelable.Param(id = 17) List<MediaQueueItem> list, @SafeParcelable.Param(id = 18) boolean z11, @SafeParcelable.Param(id = 19) AdBreakStatus adBreakStatus, @SafeParcelable.Param(id = 20) VideoInfo videoInfo, @SafeParcelable.Param(id = 21) MediaLiveSeekableRange mediaLiveSeekableRange, @SafeParcelable.Param(id = 22) MediaQueueData mediaQueueData) {
        String str2 = str;
        List<MediaQueueItem> list2 = list;
        this.zzq = new ArrayList();
        this.zzx = new SparseArray<>();
        this.zzy = new Writer();
        this.zza = mediaInfo;
        this.zzb = j10;
        this.zzc = i10;
        this.zzd = d10;
        this.zze = i11;
        this.zzf = i12;
        this.zzg = j11;
        this.zzh = j12;
        this.zzi = d11;
        this.zzj = z10;
        this.zzk = jArr;
        this.zzl = i13;
        this.zzm = i14;
        this.zzn = str2;
        if (str2 != null) {
            try {
                this.zzo = new JSONObject(str2);
            } catch (JSONException unused) {
                this.zzo = null;
                this.zzn = null;
            }
        } else {
            this.zzo = null;
        }
        this.zzp = i15;
        if (list2 != null && !list.isEmpty()) {
            zze(list2);
        }
        this.zzr = z11;
        this.zzs = adBreakStatus;
        this.zzt = videoInfo;
        this.zzu = mediaLiveSeekableRange;
        this.zzv = mediaQueueData;
    }

    /* access modifiers changed from: private */
    public final void zze(List<MediaQueueItem> list) {
        this.zzq.clear();
        this.zzx.clear();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                MediaQueueItem mediaQueueItem = list.get(i10);
                this.zzq.add(mediaQueueItem);
                this.zzx.put(mediaQueueItem.getItemId(), Integer.valueOf(i10));
            }
        }
    }

    private static final boolean zzf(int i10, int i11, int i12, int i13) {
        if (i10 != 1) {
            return false;
        }
        if (i11 != 1) {
            if (i11 == 2) {
                return i13 != 2;
            }
            if (i11 != 3) {
                return true;
            }
        }
        return i12 == 0;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        if (this.zzo != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (mediaStatus.zzo != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 == z11 && this.zzb == mediaStatus.zzb && this.zzc == mediaStatus.zzc && this.zzd == mediaStatus.zzd && this.zze == mediaStatus.zze && this.zzf == mediaStatus.zzf && this.zzg == mediaStatus.zzg && this.zzi == mediaStatus.zzi && this.zzj == mediaStatus.zzj && this.zzl == mediaStatus.zzl && this.zzm == mediaStatus.zzm && this.zzp == mediaStatus.zzp && Arrays.equals(this.zzk, mediaStatus.zzk) && CastUtils.zzh(Long.valueOf(this.zzh), Long.valueOf(mediaStatus.zzh)) && CastUtils.zzh(this.zzq, mediaStatus.zzq) && CastUtils.zzh(this.zza, mediaStatus.zza) && (((jSONObject = this.zzo) == null || (jSONObject2 = mediaStatus.zzo) == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzr == mediaStatus.isPlayingAd() && CastUtils.zzh(this.zzs, mediaStatus.zzs) && CastUtils.zzh(this.zzt, mediaStatus.zzt) && CastUtils.zzh(this.zzu, mediaStatus.zzu) && Objects.equal(this.zzv, mediaStatus.zzv))) {
            return true;
        }
        return false;
    }

    @RecentlyNullable
    public long[] getActiveTrackIds() {
        return this.zzk;
    }

    @RecentlyNullable
    public AdBreakStatus getAdBreakStatus() {
        return this.zzs;
    }

    @RecentlyNullable
    public AdBreakInfo getCurrentAdBreak() {
        MediaInfo mediaInfo;
        List<AdBreakInfo> adBreaks;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakId = adBreakStatus.getBreakId();
        if (!TextUtils.isEmpty(breakId) && (mediaInfo = this.zza) != null && (adBreaks = mediaInfo.getAdBreaks()) != null && !adBreaks.isEmpty()) {
            for (AdBreakInfo next : adBreaks) {
                if (breakId.equals(next.getId())) {
                    return next;
                }
            }
        }
        return null;
    }

    @RecentlyNullable
    public AdBreakClipInfo getCurrentAdBreakClip() {
        MediaInfo mediaInfo;
        List<AdBreakClipInfo> adBreakClips;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakClipId = adBreakStatus.getBreakClipId();
        if (!TextUtils.isEmpty(breakClipId) && (mediaInfo = this.zza) != null && (adBreakClips = mediaInfo.getAdBreakClips()) != null && !adBreakClips.isEmpty()) {
            for (AdBreakClipInfo next : adBreakClips) {
                if (breakClipId.equals(next.getId())) {
                    return next;
                }
            }
        }
        return null;
    }

    public int getCurrentItemId() {
        return this.zzc;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzo;
    }

    public int getIdleReason() {
        return this.zzf;
    }

    @RecentlyNonNull
    public Integer getIndexById(int i10) {
        return this.zzx.get(i10);
    }

    @RecentlyNullable
    public MediaQueueItem getItemById(int i10) {
        Integer num = this.zzx.get(i10);
        if (num == null) {
            return null;
        }
        return this.zzq.get(num.intValue());
    }

    @RecentlyNullable
    public MediaQueueItem getItemByIndex(int i10) {
        if (i10 < 0 || i10 >= this.zzq.size()) {
            return null;
        }
        return this.zzq.get(i10);
    }

    @RecentlyNullable
    public MediaLiveSeekableRange getLiveSeekableRange() {
        return this.zzu;
    }

    public int getLoadingItemId() {
        return this.zzl;
    }

    @RecentlyNullable
    public MediaInfo getMediaInfo() {
        return this.zza;
    }

    public double getPlaybackRate() {
        return this.zzd;
    }

    public int getPlayerState() {
        return this.zze;
    }

    public int getPreloadedItemId() {
        return this.zzm;
    }

    @RecentlyNullable
    public MediaQueueData getQueueData() {
        return this.zzv;
    }

    @RecentlyNullable
    public MediaQueueItem getQueueItem(int i10) {
        return getItemByIndex(i10);
    }

    @RecentlyNullable
    public MediaQueueItem getQueueItemById(int i10) {
        return getItemById(i10);
    }

    public int getQueueItemCount() {
        return this.zzq.size();
    }

    @RecentlyNonNull
    public List<MediaQueueItem> getQueueItems() {
        return this.zzq;
    }

    public int getQueueRepeatMode() {
        return this.zzp;
    }

    public long getStreamPosition() {
        return this.zzg;
    }

    public double getStreamVolume() {
        return this.zzi;
    }

    @KeepForSdk
    public long getSupportedMediaCommands() {
        return this.zzh;
    }

    @RecentlyNullable
    public VideoInfo getVideoInfo() {
        return this.zzt;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Writer getWriter() {
        return this.zzy;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Double.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(Arrays.hashCode(this.zzk)), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), String.valueOf(this.zzo), Integer.valueOf(this.zzp), this.zzq, Boolean.valueOf(this.zzr), this.zzs, this.zzt, this.zzu, this.zzv);
    }

    public boolean isMediaCommandSupported(long j10) {
        return (j10 & this.zzh) != 0;
    }

    public boolean isMute() {
        return this.zzj;
    }

    public boolean isPlayingAd() {
        return this.zzr;
    }

    @RecentlyNonNull
    @KeepForSdk
    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mediaSessionId", this.zzb);
            int i10 = this.zze;
            String str2 = "IDLE";
            if (i10 != 1) {
                if (i10 == 2) {
                    str2 = DLNAControllerImp.PLAYING;
                } else if (i10 == 3) {
                    str2 = "PAUSED";
                } else if (i10 == 4) {
                    str2 = "BUFFERING";
                } else if (i10 == 5) {
                    str2 = "LOADING";
                }
            }
            jSONObject.put("playerState", str2);
            JSONArray jSONArray = null;
            if (this.zze == 1) {
                int i11 = this.zzf;
                if (i11 == 1) {
                    str = "FINISHED";
                } else if (i11 == 2) {
                    str = "CANCELLED";
                } else if (i11 == 3) {
                    str = "INTERRUPTED";
                } else if (i11 != 4) {
                    str = null;
                } else {
                    str = MediaError.ERROR_TYPE_ERROR;
                }
                jSONObject.putOpt("idleReason", str);
            }
            jSONObject.put("playbackRate", this.zzd);
            jSONObject.put("currentTime", CastUtils.millisecToSec(this.zzg));
            jSONObject.put("supportedMediaCommands", this.zzh);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.Param.LEVEL, this.zzi);
            jSONObject2.put("muted", this.zzj);
            jSONObject.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject2);
            if (this.zzk != null) {
                jSONArray = new JSONArray();
                for (long put : this.zzk) {
                    jSONArray.put(put);
                }
            }
            jSONObject.putOpt("activeTrackIds", jSONArray);
            jSONObject.putOpt("customData", this.zzo);
            MediaInfo mediaInfo = this.zza;
            if (mediaInfo != null) {
                jSONObject.putOpt("media", mediaInfo.zza());
            }
            int i12 = this.zzc;
            if (i12 != 0) {
                jSONObject.put("currentItemId", i12);
            }
            int i13 = this.zzm;
            if (i13 != 0) {
                jSONObject.put("preloadedItemId", i13);
            }
            int i14 = this.zzl;
            if (i14 != 0) {
                jSONObject.put("loadingItemId", i14);
            }
            AdBreakStatus adBreakStatus = this.zzs;
            if (adBreakStatus != null) {
                jSONObject.putOpt("breakStatus", adBreakStatus.zzb());
            }
            VideoInfo videoInfo = this.zzt;
            if (videoInfo != null) {
                jSONObject.putOpt("videoInfo", videoInfo.zzb());
            }
            MediaQueueData mediaQueueData = this.zzv;
            if (mediaQueueData != null) {
                jSONObject.putOpt("queueData", mediaQueueData.zza());
            }
            MediaLiveSeekableRange mediaLiveSeekableRange = this.zzu;
            if (mediaLiveSeekableRange != null) {
                jSONObject.putOpt("liveSeekableRange", mediaLiveSeekableRange.zzb());
            }
            jSONObject.putOpt("repeatMode", MediaCommon.zza(Integer.valueOf(this.zzp)));
            List<MediaQueueItem> list = this.zzq;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (MediaQueueItem json : this.zzq) {
                    jSONArray2.put(json.toJson());
                }
                jSONObject.put("items", jSONArray2);
            }
            return jSONObject;
        } catch (JSONException e10) {
            zzw.e(e10, "Error transforming MediaStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        String str;
        JSONObject jSONObject = this.zzo;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zzn = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i10, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, getCurrentItemId());
        SafeParcelWriter.writeDouble(parcel, 5, getPlaybackRate());
        SafeParcelWriter.writeInt(parcel, 6, getPlayerState());
        SafeParcelWriter.writeInt(parcel, 7, getIdleReason());
        SafeParcelWriter.writeLong(parcel, 8, getStreamPosition());
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeDouble(parcel, 10, getStreamVolume());
        SafeParcelWriter.writeBoolean(parcel, 11, isMute());
        SafeParcelWriter.writeLongArray(parcel, 12, getActiveTrackIds(), false);
        SafeParcelWriter.writeInt(parcel, 13, getLoadingItemId());
        SafeParcelWriter.writeInt(parcel, 14, getPreloadedItemId());
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeTypedList(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, isPlayingAd());
        SafeParcelWriter.writeParcelable(parcel, 19, getAdBreakStatus(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 20, getVideoInfo(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 21, getLiveSeekableRange(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getQueueData(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02d8, code lost:
        if (r15 == false) goto L_0x02f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018c, code lost:
        if (r13.zzk != null) goto L_0x018e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0386  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(@androidx.annotation.RecentlyNonNull org.json.JSONObject r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "extendedStatus"
            org.json.JSONObject r1 = r14.optJSONObject(r0)
            r2 = 0
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ JSONException -> 0x004c }
            r3.<init>()     // Catch:{ JSONException -> 0x004c }
            java.util.Iterator r4 = r14.keys()     // Catch:{ JSONException -> 0x004c }
        L_0x0012:
            boolean r5 = r4.hasNext()     // Catch:{ JSONException -> 0x004c }
            if (r5 == 0) goto L_0x0022
            java.lang.Object r5 = r4.next()     // Catch:{ JSONException -> 0x004c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x004c }
            r3.add(r5)     // Catch:{ JSONException -> 0x004c }
            goto L_0x0012
        L_0x0022:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004c }
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x004c }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ JSONException -> 0x004c }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ JSONException -> 0x004c }
            r4.<init>(r14, r3)     // Catch:{ JSONException -> 0x004c }
            java.util.Iterator r3 = r1.keys()     // Catch:{ JSONException -> 0x004c }
        L_0x0033:
            boolean r5 = r3.hasNext()     // Catch:{ JSONException -> 0x004c }
            if (r5 == 0) goto L_0x0047
            java.lang.Object r5 = r3.next()     // Catch:{ JSONException -> 0x004c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x004c }
            java.lang.Object r6 = r1.get(r5)     // Catch:{ JSONException -> 0x004c }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x004c }
            goto L_0x0033
        L_0x0047:
            r4.remove(r0)     // Catch:{ JSONException -> 0x004c }
            r14 = r4
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            java.lang.String r0 = "mediaSessionId"
            long r0 = r14.getLong(r0)
            long r3 = r13.zzb
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x005e
            r13.zzb = r0
            r0 = 1
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            java.lang.String r1 = "playerState"
            boolean r3 = r14.has(r1)
            r4 = 2
            if (r3 == 0) goto L_0x00e7
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r3 = "IDLE"
            boolean r3 = r1.equals(r3)
            r6 = 3
            r7 = 4
            if (r3 == 0) goto L_0x0078
            r1 = 1
            goto L_0x00a1
        L_0x0078:
            java.lang.String r3 = "PLAYING"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0082
            r1 = 2
            goto L_0x00a1
        L_0x0082:
            java.lang.String r3 = "PAUSED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x008c
            r1 = 3
            goto L_0x00a1
        L_0x008c:
            java.lang.String r3 = "BUFFERING"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0096
            r1 = 4
            goto L_0x00a1
        L_0x0096:
            java.lang.String r3 = "LOADING"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00a0
            r1 = 5
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            int r3 = r13.zze
            if (r1 == r3) goto L_0x00a9
            r13.zze = r1
            r0 = r0 | 2
        L_0x00a9:
            if (r1 != r5) goto L_0x00e7
            java.lang.String r1 = "idleReason"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x00e7
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r3 = "CANCELLED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00c1
            r6 = 2
            goto L_0x00df
        L_0x00c1:
            java.lang.String r3 = "INTERRUPTED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00ca
            goto L_0x00df
        L_0x00ca:
            java.lang.String r3 = "FINISHED"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x00d4
            r6 = 1
            goto L_0x00df
        L_0x00d4:
            java.lang.String r3 = "ERROR"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00de
            r6 = 4
            goto L_0x00df
        L_0x00de:
            r6 = 0
        L_0x00df:
            int r1 = r13.zzf
            if (r6 == r1) goto L_0x00e7
            r13.zzf = r6
            r0 = r0 | 2
        L_0x00e7:
            java.lang.String r1 = "playbackRate"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x00fd
            double r6 = r14.getDouble(r1)
            double r8 = r13.zzd
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00fd
            r13.zzd = r6
            r0 = r0 | 2
        L_0x00fd:
            java.lang.String r1 = "currentTime"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x0119
            double r6 = r14.getDouble(r1)
            long r6 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((double) r6)
            long r8 = r13.zzg
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0117
            r13.zzg = r6
            r0 = r0 | 2
        L_0x0117:
            r0 = r0 | 128(0x80, float:1.794E-43)
        L_0x0119:
            java.lang.String r1 = "supportedMediaCommands"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x012f
            long r6 = r14.getLong(r1)
            long r8 = r13.zzh
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012f
            r13.zzh = r6
            r0 = r0 | 2
        L_0x012f:
            java.lang.String r1 = "volume"
            boolean r3 = r14.has(r1)
            if (r3 == 0) goto L_0x015b
            if (r15 != 0) goto L_0x015b
            org.json.JSONObject r15 = r14.getJSONObject(r1)
            java.lang.String r1 = "level"
            double r6 = r15.getDouble(r1)
            double r8 = r13.zzi
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x014d
            r13.zzi = r6
            r0 = r0 | 2
        L_0x014d:
            java.lang.String r1 = "muted"
            boolean r15 = r15.getBoolean(r1)
            boolean r1 = r13.zzj
            if (r15 == r1) goto L_0x015b
            r13.zzj = r15
            r0 = r0 | 2
        L_0x015b:
            java.lang.String r15 = "activeTrackIds"
            boolean r1 = r14.has(r15)
            r3 = 0
            if (r1 == 0) goto L_0x0169
            org.json.JSONArray r15 = r14.getJSONArray(r15)
            goto L_0x016a
        L_0x0169:
            r15 = r3
        L_0x016a:
            long[] r15 = com.google.android.gms.cast.internal.CastUtils.zzj(r15)
            if (r15 == 0) goto L_0x018a
            long[] r1 = r13.zzk
            if (r1 != 0) goto L_0x0175
            goto L_0x018e
        L_0x0175:
            int r1 = r1.length
            int r6 = r15.length
            if (r1 != r6) goto L_0x018e
            r1 = 0
        L_0x017a:
            int r6 = r15.length
            if (r1 >= r6) goto L_0x0192
            long[] r6 = r13.zzk
            r7 = r6[r1]
            r9 = r15[r1]
            int r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r6 != 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x017a
        L_0x018a:
            long[] r1 = r13.zzk
            if (r1 == 0) goto L_0x0192
        L_0x018e:
            r13.zzk = r15
            r0 = r0 | 2
        L_0x0192:
            java.lang.String r15 = "customData"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01a4
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r13.zzo = r15
            r13.zzn = r3
            r0 = r0 | 2
        L_0x01a4:
            java.lang.String r15 = "media"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01cd
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            com.google.android.gms.cast.MediaInfo r1 = new com.google.android.gms.cast.MediaInfo
            r1.<init>((org.json.JSONObject) r15)
            com.google.android.gms.cast.MediaInfo r6 = r13.zza
            if (r6 == 0) goto L_0x01bf
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x01c3
        L_0x01bf:
            r13.zza = r1
            r0 = r0 | 2
        L_0x01c3:
            java.lang.String r1 = "metadata"
            boolean r15 = r15.has(r1)
            if (r15 == 0) goto L_0x01cd
            r0 = r0 | 4
        L_0x01cd:
            java.lang.String r15 = "currentItemId"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x01e1
            int r15 = r14.getInt(r15)
            int r1 = r13.zzc
            if (r1 == r15) goto L_0x01e1
            r13.zzc = r15
            r0 = r0 | 2
        L_0x01e1:
            java.lang.String r15 = "preloadedItemId"
            int r15 = r14.optInt(r15, r2)
            int r1 = r13.zzm
            if (r1 == r15) goto L_0x01ef
            r13.zzm = r15
            r0 = r0 | 16
        L_0x01ef:
            java.lang.String r15 = "loadingItemId"
            int r15 = r14.optInt(r15, r2)
            int r1 = r13.zzl
            if (r1 == r15) goto L_0x01fd
            r13.zzl = r15
            r0 = r0 | 2
        L_0x01fd:
            com.google.android.gms.cast.MediaInfo r15 = r13.zza
            if (r15 != 0) goto L_0x0203
            r15 = -1
            goto L_0x0207
        L_0x0203:
            int r15 = r15.getStreamType()
        L_0x0207:
            int r1 = r13.zze
            int r6 = r13.zzf
            int r7 = r13.zzl
            boolean r15 = zzf(r1, r6, r7, r15)
            if (r15 != 0) goto L_0x02db
            java.lang.String r15 = "repeatMode"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x0240
            java.lang.String r15 = r14.getString(r15)
            java.lang.Integer r15 = com.google.android.gms.cast.internal.media.MediaCommon.mediaRepeatModeFromString(r15)
            if (r15 != 0) goto L_0x0228
            int r15 = r13.zzp
            goto L_0x022c
        L_0x0228:
            int r15 = r15.intValue()
        L_0x022c:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            int r1 = r13.zzp
            int r6 = r15.intValue()
            if (r1 == r6) goto L_0x0240
            int r15 = r15.intValue()
            r13.zzp = r15
            r15 = 1
            goto L_0x0241
        L_0x0240:
            r15 = 0
        L_0x0241:
            java.lang.String r1 = "items"
            boolean r6 = r14.has(r1)
            if (r6 == 0) goto L_0x02d8
            org.json.JSONArray r1 = r14.getJSONArray(r1)
            int r6 = r1.length()
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            r8 = 0
        L_0x0257:
            if (r8 >= r6) goto L_0x026d
            org.json.JSONObject r9 = r1.getJSONObject(r8)
            java.lang.String r10 = "itemId"
            int r9 = r9.getInt(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7.put(r8, r9)
            int r8 = r8 + 1
            goto L_0x0257
        L_0x026d:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 0
        L_0x0273:
            if (r9 >= r6) goto L_0x02c8
            java.lang.Object r10 = r7.get(r9)
            java.lang.Integer r10 = (java.lang.Integer) r10
            org.json.JSONObject r11 = r1.getJSONObject(r9)
            int r12 = r10.intValue()
            com.google.android.gms.cast.MediaQueueItem r12 = r13.getItemById(r12)
            if (r12 == 0) goto L_0x02a0
            boolean r11 = r12.fromJson(r11)
            r15 = r15 | r11
            r8.add(r12)
            int r10 = r10.intValue()
            java.lang.Integer r10 = r13.getIndexById(r10)
            int r10 = r10.intValue()
            if (r9 == r10) goto L_0x02c5
            goto L_0x02c4
        L_0x02a0:
            int r15 = r10.intValue()
            int r10 = r13.zzc
            if (r15 != r10) goto L_0x02bc
            com.google.android.gms.cast.MediaInfo r15 = r13.zza
            if (r15 == 0) goto L_0x02bc
            com.google.android.gms.cast.MediaQueueItem$Builder r10 = new com.google.android.gms.cast.MediaQueueItem$Builder
            r10.<init>((com.google.android.gms.cast.MediaInfo) r15)
            com.google.android.gms.cast.MediaQueueItem r15 = r10.build()
            r15.fromJson(r11)
            r8.add(r15)
            goto L_0x02c4
        L_0x02bc:
            com.google.android.gms.cast.MediaQueueItem r15 = new com.google.android.gms.cast.MediaQueueItem
            r15.<init>(r11)
            r8.add(r15)
        L_0x02c4:
            r15 = 1
        L_0x02c5:
            int r9 = r9 + 1
            goto L_0x0273
        L_0x02c8:
            java.util.List<com.google.android.gms.cast.MediaQueueItem> r1 = r13.zzq
            int r1 = r1.size()
            if (r1 == r6) goto L_0x02d2
            r1 = 0
            goto L_0x02d3
        L_0x02d2:
            r1 = 1
        L_0x02d3:
            r1 = r1 ^ r5
            r15 = r15 | r1
            r13.zze(r8)
        L_0x02d8:
            if (r15 == 0) goto L_0x02f7
            goto L_0x02f5
        L_0x02db:
            r13.zzc = r2
            r13.zzl = r2
            r13.zzm = r2
            java.util.List<com.google.android.gms.cast.MediaQueueItem> r15 = r13.zzq
            boolean r15 = r15.isEmpty()
            if (r15 != 0) goto L_0x02f7
            r13.zzp = r2
            java.util.List<com.google.android.gms.cast.MediaQueueItem> r15 = r13.zzq
            r15.clear()
            android.util.SparseArray<java.lang.Integer> r15 = r13.zzx
            r15.clear()
        L_0x02f5:
            r0 = r0 | 8
        L_0x02f7:
            java.lang.String r15 = "breakStatus"
            org.json.JSONObject r15 = r14.optJSONObject(r15)
            com.google.android.gms.cast.AdBreakStatus r15 = com.google.android.gms.cast.AdBreakStatus.zza(r15)
            com.google.android.gms.cast.AdBreakStatus r1 = r13.zzs
            if (r1 != 0) goto L_0x0307
            if (r15 != 0) goto L_0x030f
        L_0x0307:
            if (r1 == 0) goto L_0x0324
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0324
        L_0x030f:
            if (r15 == 0) goto L_0x031e
            java.lang.String r1 = r15.getBreakId()
            if (r1 != 0) goto L_0x031d
            java.lang.String r1 = r15.getBreakClipId()
            if (r1 == 0) goto L_0x031e
        L_0x031d:
            r2 = 1
        L_0x031e:
            r13.zzr = r2
            r13.zzs = r15
            r0 = r0 | 32
        L_0x0324:
            java.lang.String r15 = "videoInfo"
            org.json.JSONObject r15 = r14.optJSONObject(r15)
            com.google.android.gms.cast.VideoInfo r15 = com.google.android.gms.cast.VideoInfo.zza(r15)
            com.google.android.gms.cast.VideoInfo r1 = r13.zzt
            if (r1 != 0) goto L_0x0334
            if (r15 != 0) goto L_0x033c
        L_0x0334:
            if (r1 == 0) goto L_0x0340
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x0340
        L_0x033c:
            r13.zzt = r15
            r0 = r0 | 64
        L_0x0340:
            java.lang.String r15 = "breakInfo"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x0355
            com.google.android.gms.cast.MediaInfo r1 = r13.zza
            if (r1 == 0) goto L_0x0355
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r1.zzs(r15)
            r0 = r0 | 2
        L_0x0355:
            java.lang.String r15 = "queueData"
            boolean r1 = r14.has(r15)
            if (r1 == 0) goto L_0x036f
            com.google.android.gms.cast.MediaQueueData$Builder r1 = new com.google.android.gms.cast.MediaQueueData$Builder
            r1.<init>()
            org.json.JSONObject r15 = r14.getJSONObject(r15)
            r1.zza(r15)
            com.google.android.gms.cast.MediaQueueData r15 = r1.build()
            r13.zzv = r15
        L_0x036f:
            java.lang.String r15 = "liveSeekableRange"
            boolean r15 = r14.has(r15)
            if (r15 == 0) goto L_0x0386
            java.lang.String r15 = "liveSeekableRange"
            org.json.JSONObject r14 = r14.optJSONObject(r15)
            com.google.android.gms.cast.MediaLiveSeekableRange r14 = com.google.android.gms.cast.MediaLiveSeekableRange.zza(r14)
            r13.zzu = r14
            r14 = r0 | 2
            goto L_0x038f
        L_0x0386:
            com.google.android.gms.cast.MediaLiveSeekableRange r14 = r13.zzu
            if (r14 == 0) goto L_0x038c
            r0 = r0 | 2
        L_0x038c:
            r13.zzu = r3
            r14 = r0
        L_0x038f:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza(org.json.JSONObject, int):int");
    }

    public final long zzb() {
        return this.zzb;
    }

    public final boolean zzd() {
        int i10;
        MediaInfo mediaInfo = this.zza;
        if (mediaInfo == null) {
            i10 = -1;
        } else {
            i10 = mediaInfo.getStreamType();
        }
        return zzf(this.zze, this.zzf, this.zzl, i10);
    }

    @KeepForSdk
    public MediaStatus(@RecentlyNonNull JSONObject jSONObject) {
        this((MediaInfo) null, 0, 0, 0.0d, 0, 0, 0, 0, 0.0d, false, (long[]) null, 0, 0, (String) null, 0, (List<MediaQueueItem>) null, false, (AdBreakStatus) null, (VideoInfo) null, (MediaLiveSeekableRange) null, (MediaQueueData) null);
        zza(jSONObject, 0);
    }
}
