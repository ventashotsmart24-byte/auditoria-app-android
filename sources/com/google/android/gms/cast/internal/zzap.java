package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
public final class zzap extends zzd {
    public static final String zzb = CastUtils.zzc("com.google.cast.media");
    /* access modifiers changed from: private */
    public int zzA = -1;
    /* access modifiers changed from: private */
    public TaskCompletionSource<SessionState> zzB;
    @VisibleForTesting
    final zzat zzc;
    @VisibleForTesting
    final zzat zzd;
    @VisibleForTesting
    final zzat zze;
    @VisibleForTesting
    final zzat zzf;
    @VisibleForTesting
    final zzat zzg;
    @VisibleForTesting
    final zzat zzh;
    @VisibleForTesting
    final zzat zzi;
    @VisibleForTesting
    final zzat zzj;
    @VisibleForTesting
    final zzat zzk;
    @VisibleForTesting
    final zzat zzl;
    @VisibleForTesting
    final zzat zzm;
    @VisibleForTesting
    final zzat zzn;
    @VisibleForTesting
    final zzat zzo;
    @VisibleForTesting
    final zzat zzp;
    @VisibleForTesting
    final zzat zzq;
    @VisibleForTesting
    final zzat zzr;
    @VisibleForTesting
    final zzat zzs;
    @VisibleForTesting
    final zzat zzt;
    @VisibleForTesting
    final zzat zzu;
    @VisibleForTesting
    final zzat zzv;
    private long zzw;
    private MediaStatus zzx;
    /* access modifiers changed from: private */
    public Long zzy;
    /* access modifiers changed from: private */
    public zzam zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(String str) {
        super(zzb, "MediaControlChannel", (String) null);
        zzat zzat = new zzat(86400000);
        this.zzc = zzat;
        zzat zzat2 = new zzat(86400000);
        this.zzd = zzat2;
        zzat zzat3 = new zzat(86400000);
        this.zze = zzat3;
        zzat zzat4 = new zzat(86400000);
        this.zzf = zzat4;
        zzat zzat5 = new zzat(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        this.zzg = zzat5;
        zzat zzat6 = new zzat(86400000);
        this.zzh = zzat6;
        zzat zzat7 = new zzat(86400000);
        this.zzi = zzat7;
        zzat zzat8 = new zzat(86400000);
        this.zzj = zzat8;
        zzat zzat9 = new zzat(86400000);
        this.zzk = zzat9;
        zzat zzat10 = new zzat(86400000);
        this.zzl = zzat10;
        zzat zzat11 = new zzat(86400000);
        this.zzm = zzat11;
        zzat zzat12 = new zzat(86400000);
        this.zzn = zzat12;
        zzat zzat13 = new zzat(86400000);
        this.zzo = zzat13;
        zzat zzat14 = zzat13;
        zzat zzat15 = new zzat(86400000);
        this.zzp = zzat15;
        zzat zzat16 = zzat15;
        zzat zzat17 = new zzat(86400000);
        this.zzq = zzat17;
        zzat zzat18 = zzat17;
        zzat zzat19 = new zzat(86400000);
        this.zzs = zzat19;
        zzat zzat20 = zzat19;
        this.zzr = new zzat(86400000);
        zzat zzat21 = new zzat(86400000);
        this.zzt = zzat21;
        zzat zzat22 = zzat21;
        zzat zzat23 = new zzat(86400000);
        this.zzu = zzat23;
        zzat zzat24 = zzat23;
        zzat zzat25 = new zzat(86400000);
        this.zzv = zzat25;
        zzc(zzat);
        zzc(zzat2);
        zzc(zzat3);
        zzc(zzat4);
        zzc(zzat5);
        zzc(zzat6);
        zzc(zzat7);
        zzc(zzat8);
        zzc(zzat9);
        zzc(zzat10);
        zzc(zzat11);
        zzc(zzat12);
        zzc(zzat14);
        zzc(zzat16);
        zzc(zzat18);
        zzat zzat26 = zzat20;
        zzc(zzat26);
        zzc(zzat26);
        zzc(zzat22);
        zzc(zzat24);
        zzc(zzat25);
        zzV();
    }

    private final long zzT(double d10, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzw;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j10;
        }
        double d11 = (double) elapsedRealtime;
        Double.isNaN(d11);
        long j12 = j10 + ((long) (d11 * d10));
        if (j11 > 0 && j12 > j11) {
            return j11;
        }
        if (j12 >= 0) {
            return j12;
        }
        return 0;
    }

    private static zzao zzU(JSONObject jSONObject) {
        MediaError zza = MediaError.zza(jSONObject);
        zzao zzao = new zzao();
        zzao.zza = CastUtils.zzg(jSONObject, "customData");
        zzao.zzb = zza;
        return zzao;
    }

    private final void zzV() {
        this.zzw = 0;
        this.zzx = null;
        for (zzat zzc2 : zza()) {
            zzc2.zzc(CastStatusCodes.CANCELED);
        }
    }

    private final void zzW(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.zzA = jSONObject.optInt("sequenceNumber", -1);
        } else {
            this.zza.w(str.concat(" message is missing a sequence number."), new Object[0]);
        }
    }

    private final void zzX() {
        zzam zzam = this.zzz;
        if (zzam != null) {
            zzam.zzc();
        }
    }

    private final void zzY() {
        zzam zzam = this.zzz;
        if (zzam != null) {
            zzam.zzd();
        }
    }

    private final void zzZ() {
        zzam zzam = this.zzz;
        if (zzam != null) {
            zzam.zzk();
        }
    }

    private final void zzaa() {
        zzam zzam = this.zzz;
        if (zzam != null) {
            zzam.zzm();
        }
    }

    private final boolean zzab() {
        return this.zzA != -1;
    }

    private static int[] zzac(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            iArr[i10] = jSONArray.getInt(i10);
        }
        return iArr;
    }

    public final long zzA(zzar zzar, int i10, long j10, MediaQueueItem[] mediaQueueItemArr, int i11, boolean z10, Integer num, JSONObject jSONObject) {
        int i12 = i10;
        long j11 = j10;
        MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        int i13 = i11;
        JSONObject jSONObject2 = jSONObject;
        if (j11 == -1 || j11 >= 0) {
            JSONObject jSONObject3 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject3.put("requestId", zzd2);
                jSONObject3.put("type", "QUEUE_UPDATE");
                jSONObject3.put("mediaSessionId", zzn());
                if (i12 != 0) {
                    jSONObject3.put("currentItemId", i12);
                }
                if (i13 != 0) {
                    jSONObject3.put("jump", i13);
                }
                if (mediaQueueItemArr2 != null && mediaQueueItemArr2.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i14 = 0; i14 < mediaQueueItemArr2.length; i14++) {
                        jSONArray.put(i14, mediaQueueItemArr2[i14].toJson());
                    }
                    jSONObject3.put("items", jSONArray);
                }
                if (z10) {
                    jSONObject3.put("shuffle", true);
                }
                String zza = MediaCommon.zza(num);
                if (zza != null) {
                    jSONObject3.put("repeatMode", zza);
                }
                if (j11 != -1) {
                    jSONObject3.put("currentTime", CastUtils.millisecToSec(j10));
                }
                if (jSONObject2 != null) {
                    jSONObject3.put("customData", jSONObject2);
                }
                if (zzab()) {
                    jSONObject3.put("sequenceNumber", this.zzA);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject3.toString(), zzd2, (String) null);
            this.zzn.zzb(zzd2, new zzal(this, zzar));
            return zzd2;
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("playPosition cannot be negative: ");
        sb.append(j11);
        throw new IllegalArgumentException(sb.toString());
    }

    public final long zzB(zzar zzar) {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "GET_STATUS");
            MediaStatus mediaStatus = this.zzx;
            if (mediaStatus != null) {
                jSONObject.put("mediaSessionId", mediaStatus.zzb());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzj.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzC(zzar zzar, MediaSeekOptions mediaSeekOptions) {
        long j10;
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        if (mediaSeekOptions.isSeekToInfinite()) {
            j10 = 4294967296000L;
        } else {
            j10 = mediaSeekOptions.getPosition();
        }
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("currentTime", CastUtils.millisecToSec(j10));
            if (mediaSeekOptions.getResumeState() == 1) {
                jSONObject.put("resumeState", "PLAYBACK_START");
            } else if (mediaSeekOptions.getResumeState() == 2) {
                jSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (mediaSeekOptions.getCustomData() != null) {
                jSONObject.put("customData", mediaSeekOptions.getCustomData());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzy = Long.valueOf(j10);
        this.zzg.zzb(zzd2, new zzaj(this, zzar));
        return zzd2;
    }

    public final long zzD(zzar zzar, long[] jArr) {
        if (jArr != null) {
            JSONObject jSONObject = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject.put("requestId", zzd2);
                jSONObject.put("type", "EDIT_TRACKS_INFO");
                jSONObject.put("mediaSessionId", zzn());
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < jArr.length; i10++) {
                    jSONArray.put(i10, jArr[i10]);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            } catch (JSONException unused) {
            }
            zzg(jSONObject.toString(), zzd2, (String) null);
            this.zzk.zzb(zzd2, zzar);
            return zzd2;
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public final long zzE(zzar zzar, double d10, JSONObject jSONObject) {
        if (this.zzx != null) {
            JSONObject jSONObject2 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject2.put("requestId", zzd2);
                jSONObject2.put("type", "SET_PLAYBACK_RATE");
                jSONObject2.put("playbackRate", d10);
                Preconditions.checkNotNull(this.zzx, "mediaStatus should not be null");
                jSONObject2.put("mediaSessionId", this.zzx.zzb());
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject2.toString(), zzd2, (String) null);
            this.zzt.zzb(zzd2, zzar);
            return zzd2;
        }
        throw new zzan();
    }

    public final long zzF(zzar zzar, boolean z10, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z10);
            jSONObject2.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzi.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzG(zzar zzar, double d10, JSONObject jSONObject) {
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d10);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(FirebaseAnalytics.Param.LEVEL, d10);
            jSONObject2.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzh.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzH(zzar zzar, TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            JSONObject jSONObject = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject.put("requestId", zzd2);
                jSONObject.put("type", "EDIT_TRACKS_INFO");
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
                jSONObject.put("mediaSessionId", zzn());
            } catch (JSONException unused) {
            }
            zzg(jSONObject.toString(), zzd2, (String) null);
            this.zzl.zzb(zzd2, zzar);
            return zzd2;
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public final long zzI(zzar zzar) {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException e10) {
            this.zza.w(String.format(Locale.ROOT, "Error creating SkipAd message: %s", new Object[]{e10.getMessage()}), new Object[0]);
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzu.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzJ(zzar zzar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzf.zzb(zzd2, zzar);
        return zzd2;
    }

    public final MediaInfo zzK() {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getMediaInfo();
    }

    public final MediaStatus zzL() {
        return this.zzx;
    }

    public final Task<SessionState> zzN(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "STORE_SESSION");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("assistant_supported", true);
            jSONObject3.put("display_supported", true);
            jSONObject3.put("is_group", false);
            jSONObject2.put("targetDeviceCapabilities", jSONObject3);
        } catch (JSONException e10) {
            this.zza.w(e10, "store session failed to create JSON message", new Object[0]);
        }
        try {
            zzg(jSONObject2.toString(), zzd2, (String) null);
            this.zzv.zzb(zzd2, new zzak(this));
            TaskCompletionSource<SessionState> taskCompletionSource = new TaskCompletionSource<>();
            this.zzB = taskCompletionSource;
            return taskCompletionSource.getTask();
        } catch (IllegalStateException e11) {
            return Tasks.forException(e11);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0283 A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02a0 A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02b0 A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02bd A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02c7 A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02ce A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02d5 A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02dc A[Catch:{ JSONException -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ed A[Catch:{ JSONException -> 0x031e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzQ(java.lang.String r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "insertBefore"
            com.google.android.gms.cast.internal.Logger r3 = r1.zza
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            r5[r6] = r2
            java.lang.String r7 = "message received: %s"
            r3.d(r7, r5)
            r3 = 2
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x031e }
            r5.<init>(r2)     // Catch:{ JSONException -> 0x031e }
            java.lang.String r7 = "type"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x031e }
            java.lang.String r8 = "requestId"
            r9 = -1
            long r8 = r5.optLong(r8, r9)     // Catch:{ JSONException -> 0x031e }
            int r10 = r7.hashCode()     // Catch:{ JSONException -> 0x031e }
            java.lang.String r11 = "QUEUE_ITEM_IDS"
            java.lang.String r12 = "QUEUE_CHANGE"
            java.lang.String r13 = "QUEUE_ITEMS"
            r14 = 3
            switch(r10) {
                case -1830647528: goto L_0x008d;
                case -1790231854: goto L_0x0084;
                case -1125000185: goto L_0x007a;
                case -262628938: goto L_0x0070;
                case -61993624: goto L_0x0065;
                case 66247144: goto L_0x005b;
                case 154411710: goto L_0x0053;
                case 431600379: goto L_0x0049;
                case 823510221: goto L_0x003f;
                case 2107149050: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0097
        L_0x0037:
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0097
            r7 = 6
            goto L_0x0098
        L_0x003f:
            java.lang.String r10 = "MEDIA_STATUS"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 0
            goto L_0x0098
        L_0x0049:
            java.lang.String r10 = "INVALID_PLAYER_STATE"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 1
            goto L_0x0098
        L_0x0053:
            boolean r7 = r7.equals(r12)
            if (r7 == 0) goto L_0x0097
            r7 = 7
            goto L_0x0098
        L_0x005b:
            java.lang.String r10 = "ERROR"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 5
            goto L_0x0098
        L_0x0065:
            java.lang.String r10 = "SESSION_STATE"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 9
            goto L_0x0098
        L_0x0070:
            java.lang.String r10 = "LOAD_FAILED"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 2
            goto L_0x0098
        L_0x007a:
            java.lang.String r10 = "INVALID_REQUEST"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 4
            goto L_0x0098
        L_0x0084:
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0097
            r7 = 8
            goto L_0x0098
        L_0x008d:
            java.lang.String r10 = "LOAD_CANCELLED"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0097
            r7 = 3
            goto L_0x0098
        L_0x0097:
            r7 = -1
        L_0x0098:
            java.lang.String r10 = "itemIds"
            r15 = 0
            switch(r7) {
                case 0: goto L_0x0246;
                case 1: goto L_0x021f;
                case 2: goto L_0x0213;
                case 3: goto L_0x0207;
                case 4: goto L_0x01e0;
                case 5: goto L_0x01b2;
                case 6: goto L_0x0196;
                case 7: goto L_0x00f2;
                case 8: goto L_0x00bb;
                case 9: goto L_0x00a0;
                default: goto L_0x009e;
            }
        L_0x009e:
            goto L_0x031d
        L_0x00a0:
            com.google.android.gms.cast.internal.zzat r0 = r1.zzv     // Catch:{ JSONException -> 0x031e }
            r0.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.cast.SessionState> r0 = r1.zzB     // Catch:{ JSONException -> 0x031e }
            if (r0 == 0) goto L_0x031d
            java.lang.String r0 = "sessionState"
            org.json.JSONObject r0 = com.google.android.gms.cast.internal.CastUtils.zzg(r5, r0)     // Catch:{ JSONException -> 0x031e }
            if (r0 == 0) goto L_0x031d
            com.google.android.gms.cast.SessionState r0 = com.google.android.gms.cast.SessionState.fromJson(r0)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.cast.SessionState> r5 = r1.zzB     // Catch:{ JSONException -> 0x031e }
            r5.setResult(r0)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x00bb:
            com.google.android.gms.cast.internal.zzat r0 = r1.zzr     // Catch:{ JSONException -> 0x031e }
            r0.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x031e }
            r1.zzW(r5, r13)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            if (r0 == 0) goto L_0x031d
            java.lang.String r0 = "items"
            org.json.JSONArray r0 = r5.getJSONArray(r0)     // Catch:{ JSONException -> 0x031e }
            int r5 = r0.length()     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.MediaQueueItem[] r5 = new com.google.android.gms.cast.MediaQueueItem[r5]     // Catch:{ JSONException -> 0x031e }
            r7 = 0
        L_0x00d4:
            int r8 = r0.length()     // Catch:{ JSONException -> 0x031e }
            if (r7 >= r8) goto L_0x00ec
            com.google.android.gms.cast.MediaQueueItem$Builder r8 = new com.google.android.gms.cast.MediaQueueItem$Builder     // Catch:{ JSONException -> 0x031e }
            org.json.JSONObject r9 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x031e }
            r8.<init>((org.json.JSONObject) r9)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.MediaQueueItem r8 = r8.build()     // Catch:{ JSONException -> 0x031e }
            r5[r7] = r8     // Catch:{ JSONException -> 0x031e }
            int r7 = r7 + 1
            goto L_0x00d4
        L_0x00ec:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r0.zzg(r5)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x00f2:
            com.google.android.gms.cast.internal.zzat r7 = r1.zzs     // Catch:{ JSONException -> 0x031e }
            r7.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x031e }
            r1.zzW(r5, r12)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r7 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x031d
            java.lang.String r7 = "changeType"
            java.lang.String r7 = r5.getString(r7)     // Catch:{ JSONException -> 0x031e }
            org.json.JSONArray r8 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x031e }
            int[] r8 = zzac(r8)     // Catch:{ JSONException -> 0x031e }
            int r9 = r5.optInt(r0, r6)     // Catch:{ JSONException -> 0x031e }
            if (r8 == 0) goto L_0x031d
            int r11 = r7.hashCode()     // Catch:{ JSONException -> 0x031e }
            switch(r11) {
                case -2130463047: goto L_0x0138;
                case -1881281404: goto L_0x012e;
                case -1785516855: goto L_0x0124;
                case 1122976047: goto L_0x011a;
                default: goto L_0x0119;
            }
        L_0x0119:
            goto L_0x0142
        L_0x011a:
            java.lang.String r11 = "ITEMS_CHANGE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0142
            r15 = 1
            goto L_0x0143
        L_0x0124:
            java.lang.String r11 = "UPDATE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0142
            r15 = 3
            goto L_0x0143
        L_0x012e:
            java.lang.String r11 = "REMOVE"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0142
            r15 = 2
            goto L_0x0143
        L_0x0138:
            java.lang.String r11 = "INSERT"
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0142
            r15 = 0
            goto L_0x0143
        L_0x0142:
            r15 = -1
        L_0x0143:
            if (r15 == 0) goto L_0x0190
            if (r15 == r4) goto L_0x018a
            if (r15 == r3) goto L_0x0184
            if (r15 == r14) goto L_0x014d
            goto L_0x031d
        L_0x014d:
            org.json.JSONArray r7 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x031e }
            int[] r7 = zzac(r7)     // Catch:{ JSONException -> 0x031e }
            java.lang.String r8 = "A list of item IDs is expected in a QUEUE UPDATE message."
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7, r8)     // Catch:{ JSONException -> 0x031e }
            java.lang.String r8 = "reorderItemIds"
            org.json.JSONArray r8 = r5.optJSONArray(r8)     // Catch:{ JSONException -> 0x031e }
            if (r8 == 0) goto L_0x017e
            java.util.List r7 = com.google.android.gms.cast.internal.CastUtils.zzf(r7)     // Catch:{ JSONException -> 0x031e }
            int r0 = r5.optInt(r0, r6)     // Catch:{ JSONException -> 0x031e }
            int[] r5 = zzac(r8)     // Catch:{ JSONException -> 0x031e }
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ JSONException -> 0x031e }
            int[] r5 = (int[]) r5     // Catch:{ JSONException -> 0x031e }
            java.util.List r5 = com.google.android.gms.cast.internal.CastUtils.zzf(r5)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r8 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r8.zzi(r7, r5, r0)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x017e:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r0.zze(r7)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x0184:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r0.zzh(r8)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x018a:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r0.zzj(r8)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x0190:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r0.zzf(r8, r9)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x0196:
            com.google.android.gms.cast.internal.zzat r0 = r1.zzq     // Catch:{ JSONException -> 0x031e }
            r0.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x031e }
            r1.zzW(r5, r11)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            if (r0 == 0) goto L_0x031d
            org.json.JSONArray r0 = r5.getJSONArray(r10)     // Catch:{ JSONException -> 0x031e }
            int[] r0 = zzac(r0)     // Catch:{ JSONException -> 0x031e }
            if (r0 == 0) goto L_0x031d
            com.google.android.gms.cast.internal.zzam r5 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r5.zze(r0)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x01b2:
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x031e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x031e }
        L_0x01ba:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x01d0
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r7 = (com.google.android.gms.cast.internal.zzat) r7     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzao r10 = zzU(r5)     // Catch:{ JSONException -> 0x031e }
            r11 = 2100(0x834, float:2.943E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x031e }
            goto L_0x01ba
        L_0x01d0:
            com.google.android.gms.cast.internal.zzam r0 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            if (r0 != 0) goto L_0x01d6
            goto L_0x031d
        L_0x01d6:
            com.google.android.gms.cast.MediaError r0 = com.google.android.gms.cast.MediaError.zza(r5)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r5 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            r5.zzb(r0)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x01e0:
            com.google.android.gms.cast.internal.Logger r0 = r1.zza     // Catch:{ JSONException -> 0x031e }
            java.lang.String r7 = "received unexpected error: Invalid Request."
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x031e }
            r0.w(r7, r10)     // Catch:{ JSONException -> 0x031e }
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x031e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x031e }
        L_0x01f1:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x031d
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r7 = (com.google.android.gms.cast.internal.zzat) r7     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzao r10 = zzU(r5)     // Catch:{ JSONException -> 0x031e }
            r11 = 2001(0x7d1, float:2.804E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x031e }
            goto L_0x01f1
        L_0x0207:
            com.google.android.gms.cast.internal.zzat r0 = r1.zzc     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzao r5 = zzU(r5)     // Catch:{ JSONException -> 0x031e }
            r7 = 2101(0x835, float:2.944E-42)
            r0.zzd(r8, r7, r5)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x0213:
            com.google.android.gms.cast.internal.zzat r0 = r1.zzc     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzao r5 = zzU(r5)     // Catch:{ JSONException -> 0x031e }
            r7 = 2100(0x834, float:2.943E-42)
            r0.zzd(r8, r7, r5)     // Catch:{ JSONException -> 0x031e }
            return
        L_0x021f:
            com.google.android.gms.cast.internal.Logger r0 = r1.zza     // Catch:{ JSONException -> 0x031e }
            java.lang.String r7 = "received unexpected error: Invalid Player State."
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x031e }
            r0.w(r7, r10)     // Catch:{ JSONException -> 0x031e }
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x031e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x031e }
        L_0x0230:
            boolean r7 = r0.hasNext()     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x031d
            java.lang.Object r7 = r0.next()     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r7 = (com.google.android.gms.cast.internal.zzat) r7     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzao r10 = zzU(r5)     // Catch:{ JSONException -> 0x031e }
            r11 = 2100(0x834, float:2.943E-42)
            r7.zzd(r8, r11, r10)     // Catch:{ JSONException -> 0x031e }
            goto L_0x0230
        L_0x0246:
            java.lang.String r0 = "status"
            org.json.JSONArray r0 = r5.getJSONArray(r0)     // Catch:{ JSONException -> 0x031e }
            int r5 = r0.length()     // Catch:{ JSONException -> 0x031e }
            if (r5 <= 0) goto L_0x02f7
            org.json.JSONObject r0 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r5 = r1.zzc     // Catch:{ JSONException -> 0x031e }
            boolean r5 = r5.zzf(r8)     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r7 = r1.zzh     // Catch:{ JSONException -> 0x031e }
            boolean r7 = r7.zze()     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x026f
            com.google.android.gms.cast.internal.zzat r7 = r1.zzh     // Catch:{ JSONException -> 0x031e }
            boolean r7 = r7.zzf(r8)     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x026d
            goto L_0x026f
        L_0x026d:
            r7 = 1
            goto L_0x0281
        L_0x026f:
            com.google.android.gms.cast.internal.zzat r7 = r1.zzi     // Catch:{ JSONException -> 0x031e }
            boolean r7 = r7.zze()     // Catch:{ JSONException -> 0x031e }
            if (r7 == 0) goto L_0x0280
            com.google.android.gms.cast.internal.zzat r7 = r1.zzi     // Catch:{ JSONException -> 0x031e }
            boolean r7 = r7.zzf(r8)     // Catch:{ JSONException -> 0x031e }
            if (r7 != 0) goto L_0x0280
            goto L_0x026d
        L_0x0280:
            r7 = 0
        L_0x0281:
            if (r5 != 0) goto L_0x028d
            com.google.android.gms.cast.MediaStatus r5 = r1.zzx     // Catch:{ JSONException -> 0x031e }
            if (r5 != 0) goto L_0x0288
            goto L_0x028d
        L_0x0288:
            int r0 = r5.zza(r0, r7)     // Catch:{ JSONException -> 0x031e }
            goto L_0x029c
        L_0x028d:
            com.google.android.gms.cast.MediaStatus r5 = new com.google.android.gms.cast.MediaStatus     // Catch:{ JSONException -> 0x031e }
            r5.<init>(r0)     // Catch:{ JSONException -> 0x031e }
            r1.zzx = r5     // Catch:{ JSONException -> 0x031e }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
            r0 = 127(0x7f, float:1.78E-43)
        L_0x029c:
            r5 = r0 & 1
            if (r5 == 0) goto L_0x02ac
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
            r5 = -1
            r1.zzA = r5     // Catch:{ JSONException -> 0x031e }
            r16.zzaa()     // Catch:{ JSONException -> 0x031e }
        L_0x02ac:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x02b9
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
            r16.zzaa()     // Catch:{ JSONException -> 0x031e }
        L_0x02b9:
            r5 = r0 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x02c3
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
        L_0x02c3:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x02ca
            r16.zzX()     // Catch:{ JSONException -> 0x031e }
        L_0x02ca:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x02d1
            r16.zzZ()     // Catch:{ JSONException -> 0x031e }
        L_0x02d1:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x02d8
            r16.zzY()     // Catch:{ JSONException -> 0x031e }
        L_0x02d8:
            r5 = r0 & 32
            if (r5 == 0) goto L_0x02e9
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzam r5 = r1.zzz     // Catch:{ JSONException -> 0x031e }
            if (r5 == 0) goto L_0x02e9
            r5.zza()     // Catch:{ JSONException -> 0x031e }
        L_0x02e9:
            r0 = r0 & 64
            if (r0 == 0) goto L_0x0305
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x031e }
            r1.zzw = r10     // Catch:{ JSONException -> 0x031e }
            r16.zzaa()     // Catch:{ JSONException -> 0x031e }
            goto L_0x0305
        L_0x02f7:
            r1.zzx = r15     // Catch:{ JSONException -> 0x031e }
            r16.zzaa()     // Catch:{ JSONException -> 0x031e }
            r16.zzX()     // Catch:{ JSONException -> 0x031e }
            r16.zzZ()     // Catch:{ JSONException -> 0x031e }
            r16.zzY()     // Catch:{ JSONException -> 0x031e }
        L_0x0305:
            java.util.List r0 = r16.zza()     // Catch:{ JSONException -> 0x031e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x031e }
        L_0x030d:
            boolean r5 = r0.hasNext()     // Catch:{ JSONException -> 0x031e }
            if (r5 == 0) goto L_0x031d
            java.lang.Object r5 = r0.next()     // Catch:{ JSONException -> 0x031e }
            com.google.android.gms.cast.internal.zzat r5 = (com.google.android.gms.cast.internal.zzat) r5     // Catch:{ JSONException -> 0x031e }
            r5.zzd(r8, r6, r15)     // Catch:{ JSONException -> 0x031e }
            goto L_0x030d
        L_0x031d:
            return
        L_0x031e:
            r0 = move-exception
            com.google.android.gms.cast.internal.Logger r5 = r1.zza
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = r0.getMessage()
            r3[r6] = r0
            r3[r4] = r2
            java.lang.String r0 = "Message is malformed (%s); ignoring: %s"
            r5.w(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzap.zzQ(java.lang.String):void");
    }

    public final void zzR(long j10, int i10) {
        for (zzat zzd2 : zza()) {
            zzd2.zzd(j10, i10, (Object) null);
        }
    }

    public final void zzS(zzam zzam) {
        this.zzz = zzam;
    }

    public final void zzf() {
        zzb();
        zzV();
    }

    public final long zzj() {
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        double d10;
        if (this.zzw == 0 || (mediaStatus = this.zzx) == null || (adBreakStatus = mediaStatus.getAdBreakStatus()) == null) {
            return 0;
        }
        double playbackRate = this.zzx.getPlaybackRate();
        if (playbackRate == 0.0d) {
            playbackRate = 1.0d;
        }
        if (this.zzx.getPlayerState() != 2) {
            d10 = 0.0d;
        } else {
            d10 = playbackRate;
        }
        return zzT(d10, adBreakStatus.getCurrentBreakClipTimeInMs(), 0);
    }

    public final long zzk() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0;
        }
        long endTime = liveSeekableRange.getEndTime();
        if (!liveSeekableRange.isLiveDone()) {
            return zzT(1.0d, endTime, -1);
        }
        return endTime;
    }

    public final long zzl() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0;
        }
        long startTime = liveSeekableRange.getStartTime();
        if (liveSeekableRange.isMovingWindow()) {
            startTime = zzT(1.0d, startTime, -1);
        }
        if (liveSeekableRange.isLiveDone()) {
            return Math.min(startTime, liveSeekableRange.getEndTime());
        }
        return startTime;
    }

    public final long zzm() {
        MediaStatus mediaStatus;
        MediaInfo zzK = zzK();
        if (zzK == null || (mediaStatus = this.zzx) == null) {
            return 0;
        }
        Long l10 = this.zzy;
        if (l10 != null) {
            if (l10.equals(4294967296000L)) {
                if (this.zzx.getLiveSeekableRange() != null) {
                    return Math.min(l10.longValue(), zzk());
                }
                if (zzo() >= 0) {
                    return Math.min(l10.longValue(), zzo());
                }
            }
            return l10.longValue();
        } else if (this.zzw == 0) {
            return 0;
        } else {
            double playbackRate = mediaStatus.getPlaybackRate();
            long streamPosition = this.zzx.getStreamPosition();
            int playerState = this.zzx.getPlayerState();
            if (playbackRate == 0.0d || playerState != 2) {
                return streamPosition;
            }
            return zzT(playbackRate, streamPosition, zzK.getStreamDuration());
        }
    }

    public final long zzn() {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus != null) {
            return mediaStatus.zzb();
        }
        throw new zzan();
    }

    public final long zzo() {
        MediaInfo zzK = zzK();
        if (zzK != null) {
            return zzK.getStreamDuration();
        }
        return 0;
    }

    public final long zzp(zzar zzar, MediaLoadRequestData mediaLoadRequestData) {
        if (mediaLoadRequestData.getMediaInfo() == null && mediaLoadRequestData.getQueueData() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject json = mediaLoadRequestData.toJson();
        if (json != null) {
            long zzd2 = zzd();
            try {
                json.put("requestId", zzd2);
                json.put("type", "LOAD");
            } catch (JSONException unused) {
            }
            zzg(json.toString(), zzd2, (String) null);
            this.zzc.zzb(zzd2, zzar);
            return zzd2;
        }
        throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
    }

    public final long zzq(zzar zzar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzd.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzr(zzar zzar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zze.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzs(String str, List list) {
        long zzd2 = zzd();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "PRECACHE");
            jSONObject.put("precacheData", str);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        return zzd2;
    }

    public final long zzt(zzar zzar, int i10, int i11, int i12) {
        if (i11 > 0 && i12 == 0) {
            i12 = 0;
        } else if (i11 != 0 || i12 <= 0) {
            throw new IllegalArgumentException("Exactly one of nextCount and prevCount must be positive and the other must be zero");
        }
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEM_RANGE");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("itemId", i10);
            if (i11 > 0) {
                jSONObject.put("nextCount", i11);
            }
            if (i12 > 0) {
                jSONObject.put("prevCount", i12);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzs.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzu(zzar zzar) {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzq.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzv(zzar zzar, int[] iArr) {
        JSONObject jSONObject = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject.put("requestId", zzd2);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int put : iArr) {
                jSONArray.put(put);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd2, (String) null);
        this.zzr.zzb(zzd2, zzar);
        return zzd2;
    }

    public final long zzw(zzar zzar, MediaQueueItem[] mediaQueueItemArr, int i10, int i11, int i12, long j10, JSONObject jSONObject) {
        MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        int i13 = i10;
        long j11 = j10;
        JSONObject jSONObject2 = jSONObject;
        if (mediaQueueItemArr2 == null || mediaQueueItemArr2.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        } else if (j11 == -1 || j11 >= 0) {
            JSONObject jSONObject3 = new JSONObject();
            long zzd2 = zzd();
            try {
                jSONObject3.put("requestId", zzd2);
                jSONObject3.put("type", "QUEUE_INSERT");
                jSONObject3.put("mediaSessionId", zzn());
                JSONArray jSONArray = new JSONArray();
                for (int i14 = 0; i14 < mediaQueueItemArr2.length; i14++) {
                    jSONArray.put(i14, mediaQueueItemArr2[i14].toJson());
                }
                jSONObject3.put("items", jSONArray);
                if (i13 != 0) {
                    jSONObject3.put("insertBefore", i13);
                }
                if (i12 != -1) {
                    jSONObject3.put("currentItemIndex", 0);
                }
                if (j11 != -1) {
                    jSONObject3.put("currentTime", CastUtils.millisecToSec(j10));
                }
                if (jSONObject2 != null) {
                    jSONObject3.put("customData", jSONObject2);
                }
                if (zzab()) {
                    jSONObject3.put("sequenceNumber", this.zzA);
                }
            } catch (JSONException unused) {
            }
            zzg(jSONObject3.toString(), zzd2, (String) null);
            this.zzm.zzb(zzd2, new zzal(this, zzar));
            return zzd2;
        } else {
            StringBuilder sb = new StringBuilder(54);
            sb.append("playPosition can not be negative: ");
            sb.append(j11);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final long zzx(zzar zzar, MediaQueueItem[] mediaQueueItemArr, int i10, int i11, long j10, JSONObject jSONObject) {
        int length;
        if (mediaQueueItemArr == null || (length = mediaQueueItemArr.length) == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i10 < 0 || i10 >= length) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Invalid startIndex: ");
            sb.append(i10);
            throw new IllegalArgumentException(sb.toString());
        } else if (j10 == -1 || j10 >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzd2 = zzd();
            this.zzc.zzb(zzd2, zzar);
            try {
                jSONObject2.put("requestId", zzd2);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < mediaQueueItemArr.length; i12++) {
                    jSONArray.put(i12, mediaQueueItemArr[i12].toJson());
                }
                jSONObject2.put("items", jSONArray);
                String zza = MediaCommon.zza(Integer.valueOf(i11));
                if (zza != null) {
                    jSONObject2.put("repeatMode", zza);
                    jSONObject2.put("startIndex", i10);
                    if (j10 != -1) {
                        jSONObject2.put("currentTime", CastUtils.millisecToSec(j10));
                    }
                    if (jSONObject != null) {
                        jSONObject2.put("customData", jSONObject);
                    }
                    if (zzab()) {
                        jSONObject2.put("sequenceNumber", this.zzA);
                    }
                    zzg(jSONObject2.toString(), zzd2, (String) null);
                    return zzd2;
                }
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid repeat mode: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            } catch (JSONException unused) {
            }
        } else {
            StringBuilder sb3 = new StringBuilder(54);
            sb3.append("playPosition can not be negative: ");
            sb3.append(j10);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public final long zzy(zzar zzar, int[] iArr, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < iArr.length; i10++) {
                jSONArray.put(i10, iArr[i10]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzo.zzb(zzd2, new zzal(this, zzar));
        return zzd2;
    }

    public final long zzz(zzar zzar, int[] iArr, int i10, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd2 = zzd();
        try {
            jSONObject2.put("requestId", zzd2);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < iArr.length; i11++) {
                jSONArray.put(i11, iArr[i11]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i10 != 0) {
                jSONObject2.put("insertBefore", i10);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd2, (String) null);
        this.zzp.zzb(zzd2, new zzal(this, zzar));
        return zzd2;
    }
}
