package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzdr;
import com.google.android.gms.internal.cast.zzdu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaInfoCreator")
@SafeParcelable.Reserved({1})
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzbu();
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1;
    public static final long zza = CastUtils.secToMillisec(-1);
    @SafeParcelable.Field(id = 9)
    String zzb;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getContentId", id = 2)
    public String zzc;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStreamType", id = 3)
    public int zzd;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getContentType", id = 4)
    public String zze;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getMetadata", id = 5)
    public MediaMetadata zzf;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStreamDuration", id = 6)
    public long zzg;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getMediaTracks", id = 7)
    public List<MediaTrack> zzh;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getTextTrackStyle", id = 8)
    public TextTrackStyle zzi;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAdBreaks", id = 10)
    public List<AdBreakInfo> zzj;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAdBreakClips", id = 11)
    public List<AdBreakClipInfo> zzk;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getEntity", id = 12)
    public String zzl;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getVmapAdsRequest", id = 13)
    public VastAdsRequest zzm;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getStartAbsoluteTime", id = 14)
    public long zzn;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAtvEntity", id = 15)
    public String zzo;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getContentUrl", id = 16)
    public String zzp;
    /* access modifiers changed from: private */
    @HlsSegmentFormat
    @SafeParcelable.Field(getter = "getHlsSegmentFormat", id = 17)
    public String zzq;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getHlsVideoSegmentFormat", id = 18)
    @HlsVideoSegmentFormat
    public String zzr;
    /* access modifiers changed from: private */
    public JSONObject zzs;
    private final Writer zzt;

    public static class Builder {
        private final MediaInfo zza;

        public Builder(@RecentlyNonNull String str) {
            this.zza = new MediaInfo(str);
        }

        @RecentlyNonNull
        public MediaInfo build() {
            return this.zza;
        }

        @RecentlyNonNull
        public Builder setAdBreakClips(@RecentlyNonNull List<AdBreakClipInfo> list) {
            this.zza.getWriter().setAdBreakClips(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setAdBreaks(@RecentlyNonNull List<AdBreakInfo> list) {
            this.zza.getWriter().setAdBreaks(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setAtvEntity(@RecentlyNonNull String str) {
            this.zza.zzo = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setContentType(@RecentlyNonNull String str) {
            this.zza.getWriter().setContentType(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setContentUrl(@RecentlyNonNull String str) {
            this.zza.getWriter().setContentUrl(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomData(@RecentlyNonNull JSONObject jSONObject) {
            this.zza.getWriter().setCustomData(jSONObject);
            return this;
        }

        @RecentlyNonNull
        public Builder setEntity(@RecentlyNonNull String str) {
            this.zza.getWriter().setEntity(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setHlsSegmentFormat(@HlsSegmentFormat String str) {
            this.zza.getWriter().setHlsSegmentFormat(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String str) {
            this.zza.getWriter().setHlsVideoSegmentFormat(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaTracks(@RecentlyNonNull List<MediaTrack> list) {
            this.zza.getWriter().setMediaTracks(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setMetadata(@RecentlyNonNull MediaMetadata mediaMetadata) {
            this.zza.getWriter().setMetadata(mediaMetadata);
            return this;
        }

        @RecentlyNonNull
        public Builder setStreamDuration(long j10) {
            this.zza.getWriter().setStreamDuration(j10);
            return this;
        }

        @RecentlyNonNull
        public Builder setStreamType(int i10) {
            this.zza.getWriter().setStreamType(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
            this.zza.getWriter().setTextTrackStyle(textTrackStyle);
            return this;
        }

        @RecentlyNonNull
        public Builder setVmapAdsRequest(@RecentlyNonNull VastAdsRequest vastAdsRequest) {
            this.zza.getWriter().setVmapAdsRequest(vastAdsRequest);
            return this;
        }

        public Builder(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.zza = new MediaInfo(str, str2);
        }
    }

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @KeepForSdk
        public void setAdBreakClips(List<AdBreakClipInfo> list) {
            MediaInfo.this.zzk = list;
        }

        @KeepForSdk
        public void setAdBreaks(List<AdBreakInfo> list) {
            MediaInfo.this.zzj = list;
        }

        @KeepForSdk
        public void setContentId(@RecentlyNonNull String str) {
            MediaInfo.this.zzc = str;
        }

        @KeepForSdk
        public void setContentType(String str) {
            MediaInfo.this.zze = str;
        }

        @KeepForSdk
        public void setContentUrl(String str) {
            MediaInfo.this.zzp = str;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject) {
            MediaInfo.this.zzs = jSONObject;
        }

        @KeepForSdk
        public void setEntity(String str) {
            MediaInfo.this.zzl = str;
        }

        @KeepForSdk
        public void setHlsSegmentFormat(@HlsSegmentFormat String str) {
            MediaInfo.this.zzq = str;
        }

        @KeepForSdk
        public void setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String str) {
            MediaInfo.this.zzr = str;
        }

        @KeepForSdk
        public void setMediaTracks(List<MediaTrack> list) {
            MediaInfo.this.zzh = list;
        }

        @KeepForSdk
        public void setMetadata(MediaMetadata mediaMetadata) {
            MediaInfo.this.zzf = mediaMetadata;
        }

        @KeepForSdk
        public void setStartAbsoluteTime(long j10) {
            if (j10 >= 0 || j10 == -1) {
                MediaInfo.this.zzn = j10;
                return;
            }
            throw new IllegalArgumentException("Invalid start absolute time");
        }

        @KeepForSdk
        public void setStreamDuration(long j10) {
            if (j10 >= 0 || j10 == -1) {
                MediaInfo.this.zzg = j10;
                return;
            }
            throw new IllegalArgumentException("Invalid stream duration");
        }

        @KeepForSdk
        public void setStreamType(int i10) {
            if (i10 < -1 || i10 > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            MediaInfo.this.zzd = i10;
        }

        @KeepForSdk
        public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
            MediaInfo.this.zzi = textTrackStyle;
        }

        @KeepForSdk
        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            MediaInfo.this.zzm = vastAdsRequest;
        }
    }

    public MediaInfo(String str) {
        this(str, -1, (String) null, (MediaMetadata) null, -1, (List<MediaTrack>) null, (TextTrackStyle) null, (String) null, (List<AdBreakInfo>) null, (List<AdBreakClipInfo>) null, (String) null, (VastAdsRequest) null, -1, (String) null, (String) null, (String) null, (String) null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.zzs;
        if (jSONObject != null) {
            z10 = false;
        } else {
            z10 = true;
        }
        JSONObject jSONObject2 = mediaInfo.zzs;
        if (jSONObject2 != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 != z11) {
            return false;
        }
        if ((jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zzh(this.zzc, mediaInfo.zzc) && this.zzd == mediaInfo.zzd && CastUtils.zzh(this.zze, mediaInfo.zze) && CastUtils.zzh(this.zzf, mediaInfo.zzf) && this.zzg == mediaInfo.zzg && CastUtils.zzh(this.zzh, mediaInfo.zzh) && CastUtils.zzh(this.zzi, mediaInfo.zzi) && CastUtils.zzh(this.zzj, mediaInfo.zzj) && CastUtils.zzh(this.zzk, mediaInfo.zzk) && CastUtils.zzh(this.zzl, mediaInfo.zzl) && CastUtils.zzh(this.zzm, mediaInfo.zzm) && this.zzn == mediaInfo.zzn && CastUtils.zzh(this.zzo, mediaInfo.zzo) && CastUtils.zzh(this.zzp, mediaInfo.zzp) && CastUtils.zzh(this.zzq, mediaInfo.zzq) && CastUtils.zzh(this.zzr, mediaInfo.zzr)) {
            return true;
        }
        return false;
    }

    @RecentlyNullable
    public List<AdBreakClipInfo> getAdBreakClips() {
        List<AdBreakClipInfo> list = this.zzk;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNullable
    public List<AdBreakInfo> getAdBreaks() {
        List<AdBreakInfo> list = this.zzj;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNonNull
    public String getContentId() {
        return this.zzc;
    }

    @RecentlyNullable
    public String getContentType() {
        return this.zze;
    }

    @RecentlyNullable
    public String getContentUrl() {
        return this.zzp;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzs;
    }

    @RecentlyNullable
    public String getEntity() {
        return this.zzl;
    }

    @HlsSegmentFormat
    @RecentlyNullable
    public String getHlsSegmentFormat() {
        return this.zzq;
    }

    @RecentlyNullable
    @HlsVideoSegmentFormat
    public String getHlsVideoSegmentFormat() {
        return this.zzr;
    }

    @RecentlyNullable
    public List<MediaTrack> getMediaTracks() {
        return this.zzh;
    }

    @RecentlyNullable
    public MediaMetadata getMetadata() {
        return this.zzf;
    }

    public long getStartAbsoluteTime() {
        return this.zzn;
    }

    public long getStreamDuration() {
        return this.zzg;
    }

    public int getStreamType() {
        return this.zzd;
    }

    @RecentlyNullable
    public TextTrackStyle getTextTrackStyle() {
        return this.zzi;
    }

    @RecentlyNullable
    public VastAdsRequest getVmapAdsRequest() {
        return this.zzm;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Writer getWriter() {
        return this.zzt;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzf, Long.valueOf(this.zzg), String.valueOf(this.zzs), this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, Long.valueOf(this.zzn), this.zzo, this.zzq, this.zzr);
    }

    public void setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
        this.zzi = textTrackStyle;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        String str;
        JSONObject jSONObject = this.zzs;
        if (jSONObject == null) {
            str = null;
        } else {
            str = jSONObject.toString();
        }
        this.zzb = str;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i10, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i10, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i10, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzc);
            jSONObject.putOpt("contentUrl", this.zzp);
            int i10 = this.zzd;
            if (i10 == 1) {
                str = "BUFFERED";
            } else if (i10 != 2) {
                str = "NONE";
            } else {
                str = "LIVE";
            }
            jSONObject.put("streamType", str);
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            MediaMetadata mediaMetadata = this.zzf;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.zza());
            }
            long j10 = this.zzg;
            if (j10 <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", CastUtils.millisecToSec(j10));
            }
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack zza2 : this.zzh) {
                    jSONArray.put(zza2.zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.zzi;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.zzs;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str3 = this.zzl;
            if (str3 != null) {
                jSONObject.put("entity", str3);
            }
            if (this.zzj != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AdBreakInfo zza3 : this.zzj) {
                    jSONArray2.put(zza3.zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.zzk != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AdBreakClipInfo zza4 : this.zzk) {
                    jSONArray3.put(zza4.zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.zzm;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j11 = this.zzn;
            if (j11 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j11));
            }
            jSONObject.putOpt("atvEntity", this.zzo);
            String str4 = this.zzq;
            if (str4 != null) {
                jSONObject.put("hlsSegmentFormat", str4);
            }
            String str5 = this.zzr;
            if (str5 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str5);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4 A[LOOP:0: B:3:0x0022->B:23:0x00a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x017b A[LOOP:2: B:29:0x00cb->B:55:0x017b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0182 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzs(org.json.JSONObject r40) {
        /*
            r39 = this;
            r1 = r39
            r2 = r40
            java.lang.String r3 = "whenSkippable"
            java.lang.String r0 = "breaks"
            boolean r4 = r2.has(r0)
            java.lang.String r5 = "duration"
            java.lang.String r6 = "id"
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x00b5
            org.json.JSONArray r4 = r2.getJSONArray(r0)
            java.util.ArrayList r10 = new java.util.ArrayList
            int r0 = r4.length()
            r10.<init>(r0)
            r11 = 0
        L_0x0022:
            int r0 = r4.length()
            if (r11 >= r0) goto L_0x00ae
            org.json.JSONObject r0 = r4.getJSONObject(r11)
            android.os.Parcelable$Creator<com.google.android.gms.cast.AdBreakInfo> r12 = com.google.android.gms.cast.AdBreakInfo.CREATOR
            if (r0 != 0) goto L_0x0033
        L_0x0030:
            r0 = 0
            goto L_0x00a2
        L_0x0033:
            boolean r12 = r0.has(r6)
            if (r12 == 0) goto L_0x0030
            java.lang.String r12 = "position"
            boolean r13 = r0.has(r12)
            if (r13 != 0) goto L_0x0042
            goto L_0x0030
        L_0x0042:
            java.lang.String r17 = r0.getString(r6)     // Catch:{ JSONException -> 0x0091 }
            long r12 = r0.getLong(r12)     // Catch:{ JSONException -> 0x0091 }
            long r15 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r12 = "isWatched"
            boolean r20 = r0.optBoolean(r12)     // Catch:{ JSONException -> 0x0091 }
            long r12 = r0.optLong(r5)     // Catch:{ JSONException -> 0x0091 }
            long r18 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r12 = "breakClipIds"
            org.json.JSONArray r12 = r0.optJSONArray(r12)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ JSONException -> 0x0091 }
            if (r12 == 0) goto L_0x007c
            int r13 = r12.length()     // Catch:{ JSONException -> 0x0091 }
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ JSONException -> 0x0091 }
            r14 = 0
        L_0x006d:
            int r9 = r12.length()     // Catch:{ JSONException -> 0x0091 }
            if (r14 >= r9) goto L_0x007c
            java.lang.String r9 = r12.getString(r14)     // Catch:{ JSONException -> 0x0091 }
            r13[r14] = r9     // Catch:{ JSONException -> 0x0091 }
            int r14 = r14 + 1
            goto L_0x006d
        L_0x007c:
            r21 = r13
            java.lang.String r9 = "isEmbedded"
            boolean r22 = r0.optBoolean(r9)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = "expanded"
            boolean r23 = r0.optBoolean(r9)     // Catch:{ JSONException -> 0x0091 }
            com.google.android.gms.cast.AdBreakInfo r0 = new com.google.android.gms.cast.AdBreakInfo     // Catch:{ JSONException -> 0x0091 }
            r14 = r0
            r14.<init>(r15, r17, r18, r20, r21, r22, r23)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x00a2
        L_0x0091:
            r0 = move-exception
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.Object[] r12 = new java.lang.Object[r7]
            java.lang.String r0 = r0.getMessage()
            r12[r8] = r0
            java.lang.String r0 = "Error while creating an AdBreakInfo from JSON: %s"
            java.lang.String.format(r9, r0, r12)
            goto L_0x0030
        L_0x00a2:
            if (r0 == 0) goto L_0x00ab
            r10.add(r0)
            int r11 = r11 + 1
            goto L_0x0022
        L_0x00ab:
            r10.clear()
        L_0x00ae:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r10)
            r1.zzj = r0
        L_0x00b5:
            java.lang.String r0 = "breakClips"
            boolean r4 = r2.has(r0)
            if (r4 == 0) goto L_0x018c
            org.json.JSONArray r2 = r2.getJSONArray(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r0 = r2.length()
            r4.<init>(r0)
            r9 = 0
        L_0x00cb:
            int r0 = r2.length()
            if (r9 >= r0) goto L_0x0185
            org.json.JSONObject r0 = r2.getJSONObject(r9)
            android.os.Parcelable$Creator<com.google.android.gms.cast.AdBreakClipInfo> r10 = com.google.android.gms.cast.AdBreakClipInfo.CREATOR
            if (r0 != 0) goto L_0x00dc
        L_0x00d9:
            r0 = 0
            goto L_0x0179
        L_0x00dc:
            boolean r10 = r0.has(r6)
            if (r10 != 0) goto L_0x00e3
            goto L_0x00d9
        L_0x00e3:
            java.lang.String r25 = r0.getString(r6)     // Catch:{ JSONException -> 0x0167 }
            long r10 = r0.optLong(r5)     // Catch:{ JSONException -> 0x0167 }
            long r27 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r10)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r10 = "clickThroughUrl"
            java.lang.String r31 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r10 = "contentUrl"
            java.lang.String r29 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r10 = "mimeType"
            java.lang.String r10 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x0167 }
            if (r10 != 0) goto L_0x0109
            java.lang.String r10 = "contentType"
            java.lang.String r10 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x0167 }
        L_0x0109:
            r30 = r10
            java.lang.String r10 = "title"
            java.lang.String r26 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r10)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r10 = "customData"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r11 = "contentId"
            java.lang.String r33 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r11 = "posterUrl"
            java.lang.String r34 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x0167 }
            boolean r11 = r0.has(r3)     // Catch:{ JSONException -> 0x0167 }
            if (r11 == 0) goto L_0x0139
            java.lang.Object r11 = r0.get(r3)     // Catch:{ JSONException -> 0x0167 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ JSONException -> 0x0167 }
            int r11 = r11.intValue()     // Catch:{ JSONException -> 0x0167 }
            long r11 = (long) r11     // Catch:{ JSONException -> 0x0167 }
            long r11 = com.google.android.gms.cast.internal.CastUtils.secToMillisec((long) r11)     // Catch:{ JSONException -> 0x0167 }
            goto L_0x013b
        L_0x0139:
            r11 = -1
        L_0x013b:
            r35 = r11
            java.lang.String r11 = "hlsSegmentFormat"
            java.lang.String r37 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r0, r11)     // Catch:{ JSONException -> 0x0167 }
            java.lang.String r11 = "vastAdsRequest"
            org.json.JSONObject r0 = r0.optJSONObject(r11)     // Catch:{ JSONException -> 0x0167 }
            com.google.android.gms.cast.VastAdsRequest r38 = com.google.android.gms.cast.VastAdsRequest.fromJson(r0)     // Catch:{ JSONException -> 0x0167 }
            com.google.android.gms.cast.AdBreakClipInfo r0 = new com.google.android.gms.cast.AdBreakClipInfo     // Catch:{ JSONException -> 0x0167 }
            if (r10 == 0) goto L_0x015f
            int r11 = r10.length()     // Catch:{ JSONException -> 0x0167 }
            if (r11 != 0) goto L_0x0158
            goto L_0x015f
        L_0x0158:
            java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x0167 }
            r32 = r10
            goto L_0x0161
        L_0x015f:
            r32 = 0
        L_0x0161:
            r24 = r0
            r24.<init>(r25, r26, r27, r29, r30, r31, r32, r33, r34, r35, r37, r38)     // Catch:{ JSONException -> 0x0167 }
            goto L_0x0179
        L_0x0167:
            r0 = move-exception
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.Object[] r11 = new java.lang.Object[r7]
            java.lang.String r0 = r0.getMessage()
            r11[r8] = r0
            java.lang.String r0 = "Error while creating an AdBreakClipInfo from JSON: %s"
            java.lang.String.format(r10, r0, r11)
            goto L_0x00d9
        L_0x0179:
            if (r0 == 0) goto L_0x0182
            r4.add(r0)
            int r9 = r9 + 1
            goto L_0x00cb
        L_0x0182:
            r4.clear()
        L_0x0185:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r4)
            r1.zzk = r0
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.zzs(org.json.JSONObject):void");
    }

    @SafeParcelable.Constructor
    public MediaInfo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) MediaMetadata mediaMetadata, @SafeParcelable.Param(id = 6) long j10, @SafeParcelable.Param(id = 7) List<MediaTrack> list, @SafeParcelable.Param(id = 8) TextTrackStyle textTrackStyle, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) List<AdBreakInfo> list2, @SafeParcelable.Param(id = 11) List<AdBreakClipInfo> list3, @SafeParcelable.Param(id = 12) String str4, @SafeParcelable.Param(id = 13) VastAdsRequest vastAdsRequest, @SafeParcelable.Param(id = 14) long j11, @SafeParcelable.Param(id = 15) String str5, @SafeParcelable.Param(id = 16) String str6, @HlsSegmentFormat @SafeParcelable.Param(id = 17) String str7, @SafeParcelable.Param(id = 18) @HlsVideoSegmentFormat String str8) {
        String str9 = str3;
        this.zzt = new Writer();
        this.zzc = str;
        this.zzd = i10;
        this.zze = str2;
        this.zzf = mediaMetadata;
        this.zzg = j10;
        this.zzh = list;
        this.zzi = textTrackStyle;
        this.zzb = str9;
        if (str9 != null) {
            try {
                this.zzs = new JSONObject(str3);
            } catch (JSONException unused) {
                this.zzs = null;
                this.zzb = null;
            }
        } else {
            this.zzs = null;
        }
        this.zzj = list2;
        this.zzk = list3;
        this.zzl = str4;
        this.zzm = vastAdsRequest;
        this.zzn = j11;
        this.zzo = str5;
        this.zzp = str6;
        this.zzq = str7;
        this.zzr = str8;
    }

    public MediaInfo(String str, String str2) {
        this(str, -1, (String) null, (MediaMetadata) null, -1, (List<MediaTrack>) null, (TextTrackStyle) null, (String) null, (List<AdBreakInfo>) null, (List<AdBreakClipInfo>) null, str2, (VastAdsRequest) null, -1, (String) null, (String) null, (String) null, (String) null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    public MediaInfo(JSONObject jSONObject) {
        this(jSONObject.optString("contentId"), -1, (String) null, (MediaMetadata) null, -1, (List<MediaTrack>) null, (TextTrackStyle) null, (String) null, (List<AdBreakInfo>) null, (List<AdBreakClipInfo>) null, (String) null, (VastAdsRequest) null, -1, (String) null, (String) null, (String) null, (String) null);
        MediaInfo mediaInfo;
        int i10;
        int i11;
        zzdu zzdu;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("streamType", "NONE");
        if ("NONE".equals(optString)) {
            mediaInfo = this;
            mediaInfo.zzd = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(optString)) {
                mediaInfo.zzd = 1;
            } else if ("LIVE".equals(optString)) {
                mediaInfo.zzd = 2;
            } else {
                mediaInfo.zzd = -1;
            }
        }
        mediaInfo.zze = CastUtils.optStringOrNull(jSONObject2, "contentType");
        if (jSONObject2.has("metadata")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject3.getInt("metadataType"));
            mediaInfo.zzf = mediaMetadata;
            mediaMetadata.zzc(jSONObject3);
        }
        mediaInfo.zzg = -1;
        if (jSONObject2.has("duration") && !jSONObject2.isNull("duration")) {
            double optDouble = jSONObject2.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                mediaInfo.zzg = CastUtils.secToMillisec(optDouble);
            }
        }
        if (jSONObject2.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("tracks");
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject4 = jSONArray.getJSONObject(i12);
                String str = MediaTrack.ROLE_ALTERNATE;
                long j10 = jSONObject4.getLong("trackId");
                String optString2 = jSONObject4.optString("type");
                if ("TEXT".equals(optString2)) {
                    i10 = 1;
                } else if ("AUDIO".equals(optString2)) {
                    i10 = 2;
                } else {
                    i10 = "VIDEO".equals(optString2) ? 3 : 0;
                }
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject4, "trackContentId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject4, "trackContentType");
                String optStringOrNull3 = CastUtils.optStringOrNull(jSONObject4, "name");
                String optStringOrNull4 = CastUtils.optStringOrNull(jSONObject4, "language");
                if (jSONObject4.has("subtype")) {
                    String string = jSONObject4.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i11 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i11 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i11 = 3;
                    } else {
                        i11 = "CHAPTERS".equals(string) ? 4 : "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i11 = 0;
                }
                if (jSONObject4.has("roles")) {
                    zzdr zzi2 = zzdu.zzi();
                    JSONArray jSONArray2 = jSONObject4.getJSONArray("roles");
                    for (int i13 = 0; i13 < jSONArray2.length(); i13++) {
                        zzi2.zzb(jSONArray2.optString(i13));
                    }
                    zzdu = zzi2.zzc();
                } else {
                    zzdu = null;
                }
                arrayList.add(new MediaTrack(j10, i10, optStringOrNull, optStringOrNull2, optStringOrNull3, optStringOrNull4, i11, zzdu, jSONObject4.optJSONObject("customData")));
            }
            mediaInfo.zzh = new ArrayList(arrayList);
        } else {
            mediaInfo.zzh = null;
        }
        if (jSONObject2.has("textTrackStyle")) {
            JSONObject jSONObject5 = jSONObject2.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject5);
            mediaInfo.zzi = textTrackStyle;
        } else {
            mediaInfo.zzi = null;
        }
        zzs(jSONObject);
        mediaInfo.zzs = jSONObject2.optJSONObject("customData");
        mediaInfo.zzl = CastUtils.optStringOrNull(jSONObject2, "entity");
        mediaInfo.zzo = CastUtils.optStringOrNull(jSONObject2, "atvEntity");
        mediaInfo.zzm = VastAdsRequest.fromJson(jSONObject2.optJSONObject("vmapAdsRequest"));
        if (jSONObject2.has("startAbsoluteTime") && !jSONObject2.isNull("startAbsoluteTime")) {
            double optDouble2 = jSONObject2.optDouble("startAbsoluteTime");
            if (!Double.isNaN(optDouble2) && !Double.isInfinite(optDouble2) && optDouble2 >= 0.0d) {
                mediaInfo.zzn = CastUtils.secToMillisec(optDouble2);
            }
        }
        if (jSONObject2.has("contentUrl")) {
            mediaInfo.zzp = jSONObject2.optString("contentUrl");
        }
        mediaInfo.zzq = CastUtils.optStringOrNull(jSONObject2, "hlsSegmentFormat");
        mediaInfo.zzr = CastUtils.optStringOrNull(jSONObject2, "hlsVideoSegmentFormat");
    }
}
