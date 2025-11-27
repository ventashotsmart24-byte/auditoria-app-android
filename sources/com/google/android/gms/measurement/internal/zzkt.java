package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.a;
import anet.channel.entity.ConnType;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.common.net.HttpHeaders;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzkt implements zzgm {
    private static volatile zzkt zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzie zzD;
    private String zzE;
    private final zzla zzF = new zzko(this);
    @VisibleForTesting
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private zzam zze;
    private zzep zzf;
    private zzkf zzg;
    private zzaa zzh;
    private final zzkv zzi;
    private zzic zzj;
    private zzjo zzk;
    private final zzki zzl;
    private zzez zzm;
    /* access modifiers changed from: private */
    public final zzfr zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    public zzkt(zzku zzku, zzfr zzfr) {
        Preconditions.checkNotNull(zzku);
        this.zzn = zzfr.zzp(zzku.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzki(this);
        zzkv zzkv = new zzkv(this);
        zzkv.zzX();
        this.zzi = zzkv;
        zzen zzen = new zzen(this);
        zzen.zzX();
        this.zzd = zzen;
        zzfi zzfi = new zzfi(this);
        zzfi.zzX();
        this.zzc = zzfi;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkj(this, zzku));
    }

    @VisibleForTesting
    public static final void zzaa(zzfs zzfs, int i10, String str) {
        List zzp2 = zzfs.zzp();
        int i11 = 0;
        while (i11 < zzp2.size()) {
            if (!"_err".equals(((zzfx) zzp2.get(i11)).zzg())) {
                i11++;
            } else {
                return;
            }
        }
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i10).longValue());
        zzfw zze3 = zzfx.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfs.zzf((zzfx) zze2.zzaC());
        zzfs.zzf((zzfx) zze3.zzaC());
    }

    @VisibleForTesting
    public static final void zzab(zzfs zzfs, String str) {
        List zzp2 = zzfs.zzp();
        for (int i10 = 0; i10 < zzp2.size(); i10++) {
            if (str.equals(((zzfx) zzp2.get(i10)).zzg())) {
                zzfs.zzh(i10);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null || zzad.booleanValue()) {
            String zzy2 = zzj2.zzy();
            String zzw2 = zzj2.zzw();
            long zzb2 = zzj2.zzb();
            String zzv2 = zzj2.zzv();
            long zzm2 = zzj2.zzm();
            long zzj3 = zzj2.zzj();
            boolean zzai = zzj2.zzai();
            String zzx2 = zzj2.zzx();
            zzj2.zza();
            zzh zzh2 = zzj2;
            return new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzh2.zzah(), false, zzh2.zzr(), zzh2.zzq(), zzh2.zzk(), zzh2.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
        return null;
    }

    private final Boolean zzad(zzh zzh2) {
        try {
            if (zzh2.zzb() != -2147483648L) {
                if (zzh2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzh2.zzt(), 0).versionName;
                String zzw2 = zzh2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    @VisibleForTesting
    private final void zzaf(zzgc zzgc, long j10, boolean z10) {
        String str;
        zzky zzky;
        String str2;
        zzgc zzgc2 = zzgc;
        boolean z11 = z10;
        if (true != z11) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzky zzp2 = zzam.zzp(zzgc.zzap(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzky = new zzky(zzgc.zzap(), ConnType.PK_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(j10));
        } else {
            zzky = new zzky(zzgc.zzap(), ConnType.PK_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j10));
        }
        zzgl zzd2 = zzgm.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) zzky.zze).longValue());
        zzgm zzgm = (zzgm) zzd2.zzaC();
        int zza2 = zzkv.zza(zzgc2, str);
        if (zza2 >= 0) {
            zzgc2.zzam(zza2, zzgm);
        } else {
            zzgc2.zzm(zzgm);
        }
        if (j10 > 0) {
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzL(zzky);
            if (true != z11) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzay().zzj().zzc("Updated engagement user property. scope, value", str2, zzky.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfo r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zza
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0255
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzam r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018f
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzkv r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzw(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018f
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018f
            r1 = 0
        L_0x0152:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzB
            r5 = 0
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r6 = 0
            int r2 = java.lang.Math.max(r6, r2)
            r11 = 20
            int r2 = java.lang.Math.min(r11, r2)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzA
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Long r2 = (java.lang.Long) r2
            long r11 = r2.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            r13 = 1
            long r13 = r13 << r1
            long r11 = r11 * r13
            long r7 = r7 + r11
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018f
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018f:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0238
            com.google.android.gms.measurement.internal.zzen r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkv r9 = r0.zzi
            zzal(r9)
            boolean r9 = r9.zzw(r1, r5)
            if (r9 != 0) goto L_0x01ca
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0201
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r1 = com.google.android.gms.measurement.internal.zzdu.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0201:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r1.zzb(r2, r3)
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zzd(r7)
            return
        L_0x021b:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0238:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0b69, code lost:
        if (r11 > (com.google.android.gms.measurement.internal.zzag.zzA() + r9)) goto L_0x0b6b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03a0 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0464 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04b4 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x080d A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0857 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x087a A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x08f1 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x08f3 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x08fb A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0927 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0b59 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0be0 A[Catch:{ NumberFormatException -> 0x07d2, all -> 0x0cfd }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0bfc A[Catch:{ SQLiteException -> 0x0c14 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:68:0x01e1=Splitter:B:68:0x01e1, B:418:0x0ceb=Splitter:B:418:0x0ceb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r43, long r44) {
        /*
            r42 = this;
            r1 = r42
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzkq r4 = new com.google.android.gms.measurement.internal.zzkq     // Catch:{ all -> 0x0cfd }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r5)     // Catch:{ all -> 0x0cfd }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0cfd }
            r7 = r44
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0cfd }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0ceb
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x002e
            goto L_0x0ceb
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.zza     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x0cfd }
            r5.zzr()     // Catch:{ all -> 0x0cfd }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0cfd }
            int r12 = r12.size()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r9
            r18 = r10
            if (r8 >= r12) goto L_0x0531
            java.util.List r10 = r4.zzc     // Catch:{ all -> 0x0cfd }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkb r10 = r10.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfs r10 = (com.google.android.gms.internal.measurement.zzfs) r10     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfi r12 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0cfd }
            r21 = r2
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r12.zzr(r9, r2)     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00f5
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r15 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x0cfd }
            r2.zzc(r6, r7, r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0cfd }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0cfd }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0cfd }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzlb r22 = r42.zzv()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzla r2 = r1.zzF     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r24 = r6.zzx()     // Catch:{ all -> 0x0cfd }
            r25 = 11
            java.lang.String r26 = "_ev"
            java.lang.String r27 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            r28 = 0
            r23 = r2
            r22.zzN(r23, r24, r25, r26, r27, r28)     // Catch:{ all -> 0x0cfd }
        L_0x00e8:
            r23 = r3
            r3 = r5
            r7 = r8
            r15 = r16
            r9 = r17
            r10 = r18
            r5 = -1
            goto L_0x0528
        L_0x00f5:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgo.zza(r3)     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0cfd }
            if (r2 == 0) goto L_0x016b
            r10.zzi(r3)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = "Renaming ad_impression to _ai"
            r2.zza(r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x0cfd }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x0cfd }
            if (r2 == 0) goto L_0x016b
            r2 = 0
        L_0x0123:
            int r12 = r10.zza()     // Catch:{ all -> 0x0cfd }
            if (r2 >= r12) goto L_0x016b
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r22 = r10.zzn(r2)     // Catch:{ all -> 0x0cfd }
            r23 = r3
            java.lang.String r3 = r22.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r3 = r12.equals(r3)     // Catch:{ all -> 0x0cfd }
            if (r3 == 0) goto L_0x0166
            com.google.android.gms.internal.measurement.zzfx r3 = r10.zzn(r2)     // Catch:{ all -> 0x0cfd }
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0cfd }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0cfd }
            if (r3 != 0) goto L_0x0166
            java.lang.String r3 = "admob"
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r2)     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzh()     // Catch:{ all -> 0x0cfd }
            boolean r3 = r3.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0cfd }
            if (r3 == 0) goto L_0x0166
            com.google.android.gms.measurement.internal.zzeh r3 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzl()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r3.zza(r12)     // Catch:{ all -> 0x0cfd }
        L_0x0166:
            int r2 = r2 + 1
            r3 = r23
            goto L_0x0123
        L_0x016b:
            r23 = r3
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.zzq(r3, r12)     // Catch:{ all -> 0x0cfd }
            java.lang.String r3 = "_c"
            if (r2 != 0) goto L_0x01d8
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r12)     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x0cfd }
            r22 = r8
            int r8 = r12.hashCode()     // Catch:{ all -> 0x0cfd }
            r24 = r11
            r11 = 94660(0x171c4, float:1.32647E-40)
            r25 = r7
            r7 = 2
            if (r8 == r11) goto L_0x01bf
            r11 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r11) goto L_0x01b5
            r11 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r11) goto L_0x01ab
            goto L_0x01c9
        L_0x01ab:
            java.lang.String r8 = "_ui"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01c9
            r8 = 1
            goto L_0x01ca
        L_0x01b5:
            java.lang.String r8 = "_ug"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01c9
            r8 = 2
            goto L_0x01ca
        L_0x01bf:
            java.lang.String r8 = "_in"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01c9
            r8 = 0
            goto L_0x01ca
        L_0x01c9:
            r8 = -1
        L_0x01ca:
            if (r8 == 0) goto L_0x01de
            r11 = 1
            if (r8 == r11) goto L_0x01de
            if (r8 == r7) goto L_0x01de
            r26 = r5
            r27 = r13
            r2 = 0
            goto L_0x039e
        L_0x01d8:
            r25 = r7
            r22 = r8
            r24 = r11
        L_0x01de:
            r7 = 0
            r8 = 0
            r11 = 0
        L_0x01e1:
            int r12 = r10.zza()     // Catch:{ all -> 0x0cfd }
            r26 = r5
            java.lang.String r5 = "_r"
            if (r7 >= r12) goto L_0x0245
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r7)     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r12 = r3.equals(r12)     // Catch:{ all -> 0x0cfd }
            if (r12 == 0) goto L_0x0215
            com.google.android.gms.internal.measurement.zzfx r5 = r10.zzn(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0cfd }
            r27 = r13
            r12 = 1
            r5.zzi(r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0cfd }
            r10.zzk(r7, r5)     // Catch:{ all -> 0x0cfd }
            r8 = 1
            goto L_0x023e
        L_0x0215:
            r27 = r13
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r7)     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.equals(r12)     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x023e
            com.google.android.gms.internal.measurement.zzfx r5 = r10.zzn(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0cfd }
            r11 = 1
            r5.zzi(r11)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0cfd }
            r10.zzk(r7, r5)     // Catch:{ all -> 0x0cfd }
            r11 = 1
        L_0x023e:
            int r7 = r7 + 1
            r5 = r26
            r13 = r27
            goto L_0x01e1
        L_0x0245:
            r27 = r13
            if (r8 != 0) goto L_0x0275
            if (r2 == 0) goto L_0x0275
            com.google.android.gms.measurement.internal.zzeh r7 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r13 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x0cfd }
            r7.zzb(r8, r12)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r7 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0cfd }
            r7.zzj(r3)     // Catch:{ all -> 0x0cfd }
            r12 = 1
            r7.zzi(r12)     // Catch:{ all -> 0x0cfd }
            r10.zze(r7)     // Catch:{ all -> 0x0cfd }
        L_0x0275:
            if (r11 != 0) goto L_0x02a1
            com.google.android.gms.measurement.internal.zzeh r7 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfr r11 = r1.zzn     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzec r11 = r11.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = r11.zzd(r12)     // Catch:{ all -> 0x0cfd }
            r7.zzb(r8, r11)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r7 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0cfd }
            r7.zzj(r5)     // Catch:{ all -> 0x0cfd }
            r11 = 1
            r7.zzi(r11)     // Catch:{ all -> 0x0cfd }
            r10.zze(r7)     // Catch:{ all -> 0x0cfd }
        L_0x02a1:
            com.google.android.gms.measurement.internal.zzam r7 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            long r29 = r42.zza()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r31 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 1
            r28 = r7
            com.google.android.gms.measurement.internal.zzak r7 = r28.zzl(r29, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0cfd }
            long r7 = r7.zze     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzag r11 = r42.zzg()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0cfd }
            int r11 = r11.zze(r12, r13)     // Catch:{ all -> 0x0cfd }
            long r11 = (long) r11     // Catch:{ all -> 0x0cfd }
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x02db
            zzab(r10, r5)     // Catch:{ all -> 0x0cfd }
            goto L_0x02dd
        L_0x02db:
            r16 = 1
        L_0x02dd:
            java.lang.String r5 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r5 = com.google.android.gms.measurement.internal.zzlb.zzai(r5)     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x039e
            if (r2 == 0) goto L_0x039e
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r5)     // Catch:{ all -> 0x0cfd }
            long r29 = r42.zza()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r7 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r31 = r7.zzx()     // Catch:{ all -> 0x0cfd }
            r32 = 0
            r33 = 0
            r34 = 1
            r35 = 0
            r36 = 0
            r28 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r28.zzl(r29, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0cfd }
            long r7 = r5.zzc     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzag r5 = r42.zzg()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r11 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzm     // Catch:{ all -> 0x0cfd }
            int r5 = r5.zze(r11, r12)     // Catch:{ all -> 0x0cfd }
            long r11 = (long) r5     // Catch:{ all -> 0x0cfd }
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x039e
            com.google.android.gms.measurement.internal.zzeh r5 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ all -> 0x0cfd }
            r5.zzb(r7, r8)     // Catch:{ all -> 0x0cfd }
            r5 = 0
            r7 = 0
            r8 = 0
            r11 = -1
        L_0x033a:
            int r12 = r10.zza()     // Catch:{ all -> 0x0cfd }
            if (r7 >= r12) goto L_0x0364
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r7)     // Catch:{ all -> 0x0cfd }
            java.lang.String r13 = r12.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r13 = r3.equals(r13)     // Catch:{ all -> 0x0cfd }
            if (r13 == 0) goto L_0x0356
            com.google.android.gms.internal.measurement.zzkb r5 = r12.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0cfd }
            r11 = r7
            goto L_0x0361
        L_0x0356:
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r12 = r9.equals(r12)     // Catch:{ all -> 0x0cfd }
            if (r12 == 0) goto L_0x0361
            r8 = 1
        L_0x0361:
            int r7 = r7 + 1
            goto L_0x033a
        L_0x0364:
            if (r8 == 0) goto L_0x036d
            if (r5 == 0) goto L_0x036c
            r10.zzh(r11)     // Catch:{ all -> 0x0cfd }
            goto L_0x039e
        L_0x036c:
            r5 = 0
        L_0x036d:
            if (r5 == 0) goto L_0x0387
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzau()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0cfd }
            r5.zzj(r9)     // Catch:{ all -> 0x0cfd }
            r7 = 10
            r5.zzi(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0cfd }
            r10.zzk(r11, r5)     // Catch:{ all -> 0x0cfd }
            goto L_0x039e
        L_0x0387:
            com.google.android.gms.measurement.internal.zzeh r5 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ all -> 0x0cfd }
            r5.zzb(r7, r8)     // Catch:{ all -> 0x0cfd }
        L_0x039e:
            if (r2 == 0) goto L_0x0457
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0cfd }
            java.util.List r5 = r10.zzp()     // Catch:{ all -> 0x0cfd }
            r2.<init>(r5)     // Catch:{ all -> 0x0cfd }
            r5 = 0
            r7 = -1
            r8 = -1
        L_0x03ac:
            int r9 = r2.size()     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = "currency"
            java.lang.String r12 = "value"
            if (r5 >= r9) goto L_0x03dc
            java.lang.Object r9 = r2.get(r5)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r9 = (com.google.android.gms.internal.measurement.zzfx) r9     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0cfd }
            if (r9 == 0) goto L_0x03c8
            r7 = r5
            goto L_0x03d9
        L_0x03c8:
            java.lang.Object r9 = r2.get(r5)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r9 = (com.google.android.gms.internal.measurement.zzfx) r9     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0cfd }
            if (r9 == 0) goto L_0x03d9
            r8 = r5
        L_0x03d9:
            int r5 = r5 + 1
            goto L_0x03ac
        L_0x03dc:
            r5 = -1
            if (r7 != r5) goto L_0x03e1
            goto L_0x0458
        L_0x03e1:
            java.lang.Object r5 = r2.get(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0cfd }
            if (r5 != 0) goto L_0x0412
            java.lang.Object r5 = r2.get(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0cfd }
            if (r5 != 0) goto L_0x0412
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0cfd }
            r10.zzh(r7)     // Catch:{ all -> 0x0cfd }
            zzab(r10, r3)     // Catch:{ all -> 0x0cfd }
            r2 = 18
            zzaa(r10, r2, r12)     // Catch:{ all -> 0x0cfd }
            goto L_0x0457
        L_0x0412:
            r5 = -1
            if (r8 != r5) goto L_0x0416
            goto L_0x043e
        L_0x0416:
            java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x0cfd }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0cfd }
            int r8 = r2.length()     // Catch:{ all -> 0x0cfd }
            r9 = 3
            if (r8 != r9) goto L_0x043e
            r8 = 0
        L_0x0428:
            int r9 = r2.length()     // Catch:{ all -> 0x0cfd }
            if (r8 >= r9) goto L_0x0458
            int r9 = r2.codePointAt(r8)     // Catch:{ all -> 0x0cfd }
            boolean r12 = java.lang.Character.isLetter(r9)     // Catch:{ all -> 0x0cfd }
            if (r12 == 0) goto L_0x043e
            int r9 = java.lang.Character.charCount(r9)     // Catch:{ all -> 0x0cfd }
            int r8 = r8 + r9
            goto L_0x0428
        L_0x043e:
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r8)     // Catch:{ all -> 0x0cfd }
            r10.zzh(r7)     // Catch:{ all -> 0x0cfd }
            zzab(r10, r3)     // Catch:{ all -> 0x0cfd }
            r2 = 19
            zzaa(r10, r2, r11)     // Catch:{ all -> 0x0cfd }
            goto L_0x0458
        L_0x0457:
            r5 = -1
        L_0x0458:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x0cfd }
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04b4
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r2 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r6)     // Catch:{ all -> 0x0cfd }
            if (r2 != 0) goto L_0x04b1
            if (r27 == 0) goto L_0x04a9
            long r2 = r27.zzc()     // Catch:{ all -> 0x0cfd }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            long r2 = r2 - r11
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0cfd }
            int r6 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x04a9
            com.google.android.gms.internal.measurement.zzkb r2 = r27.zzau()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0cfd }
            boolean r3 = r1.zzaj(r10, r2)     // Catch:{ all -> 0x0cfd }
            if (r3 == 0) goto L_0x049e
            r3 = r26
            r3.zzS(r14, r2)     // Catch:{ all -> 0x0cfd }
            r11 = r24
            r2 = 0
            r13 = 0
            goto L_0x04a5
        L_0x049e:
            r3 = r26
            r2 = r10
            r11 = r17
            r13 = r27
        L_0x04a5:
            r18 = r2
            goto L_0x0512
        L_0x04a9:
            r3 = r26
            r18 = r10
            r11 = r17
            goto L_0x0510
        L_0x04b1:
            r3 = r26
            goto L_0x050d
        L_0x04b4:
            r3 = r26
            java.lang.String r2 = "_vs"
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0cfd }
            if (r2 == 0) goto L_0x050d
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r2 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0cfd }
            r9 = r25
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r9)     // Catch:{ all -> 0x0cfd }
            if (r2 != 0) goto L_0x050d
            if (r18 == 0) goto L_0x0506
            long r11 = r18.zzc()     // Catch:{ all -> 0x0cfd }
            long r19 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            long r11 = r11 - r19
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0cfd }
            int r2 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0506
            com.google.android.gms.internal.measurement.zzkb r2 = r18.zzau()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0cfd }
            boolean r6 = r1.zzaj(r2, r10)     // Catch:{ all -> 0x0cfd }
            if (r6 == 0) goto L_0x04fe
            r7 = r24
            r3.zzS(r7, r2)     // Catch:{ all -> 0x0cfd }
            r2 = 0
            r18 = 0
            goto L_0x0503
        L_0x04fe:
            r7 = r24
            r2 = r10
            r14 = r17
        L_0x0503:
            r13 = r2
            r11 = r7
            goto L_0x0512
        L_0x0506:
            r7 = r24
            r11 = r7
            r13 = r10
            r14 = r17
            goto L_0x0512
        L_0x050d:
            r7 = r24
            r11 = r7
        L_0x0510:
            r13 = r27
        L_0x0512:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r6 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r6 = (com.google.android.gms.internal.measurement.zzft) r6     // Catch:{ all -> 0x0cfd }
            r7 = r22
            r2.set(r7, r6)     // Catch:{ all -> 0x0cfd }
            int r9 = r17 + 1
            r3.zzk(r10)     // Catch:{ all -> 0x0cfd }
            r15 = r16
            r10 = r18
        L_0x0528:
            int r8 = r7 + 1
            r5 = r3
            r2 = r21
            r3 = r23
            goto L_0x0040
        L_0x0531:
            r21 = r2
            r3 = r5
            r9 = r7
            r7 = 0
            r10 = r7
            r5 = r17
            r2 = 0
        L_0x053b:
            if (r2 >= r5) goto L_0x058b
            com.google.android.gms.internal.measurement.zzft r12 = r3.zze(r2)     // Catch:{ all -> 0x0cfd }
            java.lang.String r13 = r12.zzh()     // Catch:{ all -> 0x0cfd }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0cfd }
            if (r13 == 0) goto L_0x055e
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r13)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r13 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r6)     // Catch:{ all -> 0x0cfd }
            if (r13 == 0) goto L_0x055e
            r3.zzA(r2)     // Catch:{ all -> 0x0cfd }
            int r5 = r5 + -1
            int r2 = r2 + -1
            goto L_0x0588
        L_0x055e:
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r13)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r12 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r9)     // Catch:{ all -> 0x0cfd }
            if (r12 == 0) goto L_0x0588
            boolean r13 = r12.zzw()     // Catch:{ all -> 0x0cfd }
            if (r13 == 0) goto L_0x0578
            long r12 = r12.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0cfd }
            goto L_0x0579
        L_0x0578:
            r12 = 0
        L_0x0579:
            if (r12 == 0) goto L_0x0588
            long r13 = r12.longValue()     // Catch:{ all -> 0x0cfd }
            int r17 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r17 <= 0) goto L_0x0588
            long r12 = r12.longValue()     // Catch:{ all -> 0x0cfd }
            long r10 = r10 + r12
        L_0x0588:
            r12 = 1
            int r2 = r2 + r12
            goto L_0x053b
        L_0x058b:
            r2 = 0
            r1.zzaf(r3, r10, r2)     // Catch:{ all -> 0x0cfd }
            java.util.List r2 = r3.zzas()     // Catch:{ all -> 0x0cfd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0cfd }
        L_0x0597:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "_se"
            if (r5 == 0) goto L_0x05bd
            java.lang.String r5 = "_s"
            java.lang.Object r9 = r2.next()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r9 = (com.google.android.gms.internal.measurement.zzft) r9     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzh()     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.equals(r9)     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0597
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = r3.zzap()     // Catch:{ all -> 0x0cfd }
            r2.zzA(r5, r6)     // Catch:{ all -> 0x0cfd }
        L_0x05bd:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzkv.zza(r3, r2)     // Catch:{ all -> 0x0cfd }
            if (r2 < 0) goto L_0x05ca
            r2 = 1
            r1.zzaf(r3, r10, r2)     // Catch:{ all -> 0x0cfd }
            goto L_0x05ea
        L_0x05ca:
            int r2 = com.google.android.gms.measurement.internal.zzkv.zza(r3, r6)     // Catch:{ all -> 0x0cfd }
            if (r2 < 0) goto L_0x05ea
            r3.zzB(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r2 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r6 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0cfd }
            r2.zzb(r5, r6)     // Catch:{ all -> 0x0cfd }
        L_0x05ea:
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r5.zza(r6)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkt r5 = r2.zzf     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r5)     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r3.zzap()     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.zzn(r6)     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0681
            com.google.android.gms.measurement.internal.zzkt r5 = r2.zzf     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r5 = r5.zze     // Catch:{ all -> 0x0cfd }
            zzal(r5)     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r3.zzap()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzh r5 = r5.zzj(r6)     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0681
            boolean r5 = r5.zzah()     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0681
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r5 = r5.zze()     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0681
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzc()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r5.zza(r6)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgl r5 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0cfd }
            r6 = r21
            r5.zzf(r6)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zzg()     // Catch:{ all -> 0x0cfd }
            long r9 = r2.zza()     // Catch:{ all -> 0x0cfd }
            r5.zzg(r9)     // Catch:{ all -> 0x0cfd }
            r9 = 1
            r5.zze(r9)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r2 = r5.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2     // Catch:{ all -> 0x0cfd }
            r5 = 0
        L_0x0663:
            int r9 = r3.zzb()     // Catch:{ all -> 0x0cfd }
            if (r5 >= r9) goto L_0x067e
            com.google.android.gms.internal.measurement.zzgm r9 = r3.zzao(r5)     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzf()     // Catch:{ all -> 0x0cfd }
            boolean r9 = r6.equals(r9)     // Catch:{ all -> 0x0cfd }
            if (r9 == 0) goto L_0x067b
            r3.zzam(r5, r2)     // Catch:{ all -> 0x0cfd }
            goto L_0x0681
        L_0x067b:
            int r5 = r5 + 1
            goto L_0x0663
        L_0x067e:
            r3.zzm(r2)     // Catch:{ all -> 0x0cfd }
        L_0x0681:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.zzai(r5)     // Catch:{ all -> 0x0cfd }
            r5 = -9223372036854775808
            r3.zzQ(r5)     // Catch:{ all -> 0x0cfd }
            r2 = 0
        L_0x068f:
            int r5 = r3.zza()     // Catch:{ all -> 0x0cfd }
            if (r2 >= r5) goto L_0x06c2
            com.google.android.gms.internal.measurement.zzft r5 = r3.zze(r2)     // Catch:{ all -> 0x0cfd }
            long r9 = r5.zzd()     // Catch:{ all -> 0x0cfd }
            long r11 = r3.zzd()     // Catch:{ all -> 0x0cfd }
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x06ac
            long r9 = r5.zzd()     // Catch:{ all -> 0x0cfd }
            r3.zzai(r9)     // Catch:{ all -> 0x0cfd }
        L_0x06ac:
            long r9 = r5.zzd()     // Catch:{ all -> 0x0cfd }
            long r11 = r3.zzc()     // Catch:{ all -> 0x0cfd }
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x06bf
            long r5 = r5.zzd()     // Catch:{ all -> 0x0cfd }
            r3.zzQ(r5)     // Catch:{ all -> 0x0cfd }
        L_0x06bf:
            int r2 = r2 + 1
            goto L_0x068f
        L_0x06c2:
            r3.zzz()     // Catch:{ all -> 0x0cfd }
            r3.zzo()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzaa r9 = r1.zzh     // Catch:{ all -> 0x0cfd }
            zzal(r9)     // Catch:{ all -> 0x0cfd }
            java.lang.String r10 = r3.zzap()     // Catch:{ all -> 0x0cfd }
            java.util.List r11 = r3.zzas()     // Catch:{ all -> 0x0cfd }
            java.util.List r12 = r3.zzat()     // Catch:{ all -> 0x0cfd }
            long r5 = r3.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r13 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0cfd }
            long r5 = r3.zzc()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0cfd }
            java.util.List r2 = r9.zza(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0cfd }
            r3.zzf(r2)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzag r2 = r42.zzg()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r5 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            boolean r2 = r2.zzw(r5)     // Catch:{ all -> 0x0cfd }
            if (r2 == 0) goto L_0x0a3c
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0cfd }
            r2.<init>()     // Catch:{ all -> 0x0cfd }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0cfd }
            r5.<init>()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzlb r6 = r42.zzv()     // Catch:{ all -> 0x0cfd }
            java.security.SecureRandom r6 = r6.zzG()     // Catch:{ all -> 0x0cfd }
            r9 = 0
        L_0x0713:
            int r10 = r3.zza()     // Catch:{ all -> 0x0cfd }
            if (r9 >= r10) goto L_0x0a03
            com.google.android.gms.internal.measurement.zzft r10 = r3.zze(r9)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkb r10 = r10.zzby()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfs r10 = (com.google.android.gms.internal.measurement.zzfs) r10     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07b6
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r11)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0cfd }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkv.zzC(r11, r14)     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0cfd }
            java.lang.Object r14 = r2.get(r11)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r14 = (com.google.android.gms.measurement.internal.zzas) r14     // Catch:{ all -> 0x0cfd }
            if (r14 != 0) goto L_0x076a
            com.google.android.gms.measurement.internal.zzam r14 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r14)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0cfd }
            r7 = r17
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r14 = r14.zzn(r15, r7)     // Catch:{ all -> 0x0cfd }
            if (r14 == 0) goto L_0x076a
            r2.put(r11, r14)     // Catch:{ all -> 0x0cfd }
        L_0x076a:
            if (r14 == 0) goto L_0x07a9
            java.lang.Long r7 = r14.zzi     // Catch:{ all -> 0x0cfd }
            if (r7 != 0) goto L_0x07a9
            java.lang.Long r7 = r14.zzj     // Catch:{ all -> 0x0cfd }
            if (r7 == 0) goto L_0x0788
            long r7 = r7.longValue()     // Catch:{ all -> 0x0cfd }
            r17 = 1
            int r11 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x0788
            com.google.android.gms.measurement.internal.zzkv r7 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            java.lang.Long r7 = r14.zzj     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r7)     // Catch:{ all -> 0x0cfd }
        L_0x0788:
            java.lang.Boolean r7 = r14.zzk     // Catch:{ all -> 0x0cfd }
            if (r7 == 0) goto L_0x07a0
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0cfd }
            if (r7 == 0) goto L_0x07a0
            com.google.android.gms.measurement.internal.zzkv r7 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            r7 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r12, r11)     // Catch:{ all -> 0x0cfd }
        L_0x07a0:
            com.google.android.gms.internal.measurement.zzkf r7 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0cfd }
            r5.add(r7)     // Catch:{ all -> 0x0cfd }
        L_0x07a9:
            r3.zzS(r9, r10)     // Catch:{ all -> 0x0cfd }
        L_0x07ac:
            r24 = r4
            r23 = r6
            r7 = r9
            r6 = r3
            r3 = 1
            goto L_0x09f8
        L_0x07b6:
            com.google.android.gms.measurement.internal.zzfi r7 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r7.zza(r8, r11)     // Catch:{ all -> 0x0cfd }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0cfd }
            if (r14 != 0) goto L_0x07e7
            long r7 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07d2 }
            goto L_0x07e9
        L_0x07d2:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ all -> 0x0cfd }
            r7.zzc(r14, r8, r11)     // Catch:{ all -> 0x0cfd }
        L_0x07e7:
            r7 = 0
        L_0x07e9:
            com.google.android.gms.measurement.internal.zzlb r11 = r42.zzv()     // Catch:{ all -> 0x0cfd }
            long r14 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            long r14 = r11.zzr(r14, r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0cfd }
            r45 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0cfd }
            r17 = r7
            java.lang.String r7 = "_dbg"
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0cfd }
            if (r8 != 0) goto L_0x0841
            java.util.List r8 = r11.zzi()     // Catch:{ all -> 0x0cfd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0cfd }
        L_0x0815:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0cfd }
            if (r11 == 0) goto L_0x0841
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x0cfd }
            r23 = r8
            java.lang.String r8 = r11.zzg()     // Catch:{ all -> 0x0cfd }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0cfd }
            if (r8 == 0) goto L_0x083e
            long r7 = r11.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0cfd }
            boolean r7 = r12.equals(r7)     // Catch:{ all -> 0x0cfd }
            if (r7 != 0) goto L_0x083c
            goto L_0x0841
        L_0x083c:
            r11 = 1
            goto L_0x0855
        L_0x083e:
            r8 = r23
            goto L_0x0815
        L_0x0841:
            com.google.android.gms.measurement.internal.zzfi r7 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            int r7 = r7.zzc(r8, r11)     // Catch:{ all -> 0x0cfd }
            r11 = r7
        L_0x0855:
            if (r11 > 0) goto L_0x087a
            com.google.android.gms.measurement.internal.zzeh r7 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0cfd }
            r7.zzc(r8, r12, r11)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r7 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0cfd }
            r5.add(r7)     // Catch:{ all -> 0x0cfd }
            r3.zzS(r9, r10)     // Catch:{ all -> 0x0cfd }
            goto L_0x07ac
        L_0x087a:
            java.lang.String r7 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r7 = r2.get(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r7 = (com.google.android.gms.measurement.internal.zzas) r7     // Catch:{ all -> 0x0cfd }
            if (r7 != 0) goto L_0x08da
            com.google.android.gms.measurement.internal.zzam r7 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r7)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzn(r8, r12)     // Catch:{ all -> 0x0cfd }
            if (r7 != 0) goto L_0x08da
            com.google.android.gms.measurement.internal.zzeh r7 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0cfd }
            r23 = r14
            java.lang.String r14 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            r7.zzc(r8, r12, r14)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r26 = r8.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.String r27 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            r28 = 1
            r30 = 1
            r32 = 1
            long r34 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r25 = r7
            r25.<init>(r26, r27, r28, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x0cfd }
            goto L_0x08dc
        L_0x08da:
            r23 = r14
        L_0x08dc:
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r8)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r8 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8     // Catch:{ all -> 0x0cfd }
            java.lang.String r12 = "_eid"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzkv.zzC(r8, r12)     // Catch:{ all -> 0x0cfd }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0cfd }
            if (r8 == 0) goto L_0x08f3
            r12 = 1
            goto L_0x08f4
        L_0x08f3:
            r12 = 0
        L_0x08f4:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0cfd }
            r14 = 1
            if (r11 != r14) goto L_0x0927
            com.google.android.gms.internal.measurement.zzkf r8 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8     // Catch:{ all -> 0x0cfd }
            r5.add(r8)     // Catch:{ all -> 0x0cfd }
            boolean r8 = r12.booleanValue()     // Catch:{ all -> 0x0cfd }
            if (r8 == 0) goto L_0x0922
            java.lang.Long r8 = r7.zzi     // Catch:{ all -> 0x0cfd }
            if (r8 != 0) goto L_0x0916
            java.lang.Long r8 = r7.zzj     // Catch:{ all -> 0x0cfd }
            if (r8 != 0) goto L_0x0916
            java.lang.Boolean r8 = r7.zzk     // Catch:{ all -> 0x0cfd }
            if (r8 == 0) goto L_0x0922
        L_0x0916:
            r8 = 0
            com.google.android.gms.measurement.internal.zzas r7 = r7.zza(r8, r8, r8)     // Catch:{ all -> 0x0cfd }
            java.lang.String r8 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            r2.put(r8, r7)     // Catch:{ all -> 0x0cfd }
        L_0x0922:
            r3.zzS(r9, r10)     // Catch:{ all -> 0x0cfd }
            goto L_0x07ac
        L_0x0927:
            int r14 = r6.nextInt(r11)     // Catch:{ all -> 0x0cfd }
            if (r14 != 0) goto L_0x0969
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r8)     // Catch:{ all -> 0x0cfd }
            long r14 = (long) r11     // Catch:{ all -> 0x0cfd }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r8)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x0cfd }
            r5.add(r11)     // Catch:{ all -> 0x0cfd }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0cfd }
            if (r11 == 0) goto L_0x094e
            r11 = 0
            com.google.android.gms.measurement.internal.zzas r7 = r7.zza(r11, r8, r11)     // Catch:{ all -> 0x0cfd }
        L_0x094e:
            java.lang.String r8 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            r14 = r23
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzb(r11, r14)     // Catch:{ all -> 0x0cfd }
            r2.put(r8, r7)     // Catch:{ all -> 0x0cfd }
            r24 = r4
            r23 = r6
            r7 = r9
            r6 = r3
            r3 = 1
            goto L_0x09f5
        L_0x0969:
            r14 = r23
            r23 = r6
            java.lang.Long r6 = r7.zzh     // Catch:{ all -> 0x0cfd }
            if (r6 == 0) goto L_0x097e
            long r17 = r6.longValue()     // Catch:{ all -> 0x0cfd }
            r26 = r3
            r24 = r4
            r27 = r8
            r25 = r9
            goto L_0x0994
        L_0x097e:
            com.google.android.gms.measurement.internal.zzlb r6 = r42.zzv()     // Catch:{ all -> 0x0cfd }
            r26 = r3
            r24 = r4
            long r3 = r10.zzb()     // Catch:{ all -> 0x0cfd }
            r27 = r8
            r25 = r9
            r8 = r17
            long r17 = r6.zzr(r3, r8)     // Catch:{ all -> 0x0cfd }
        L_0x0994:
            int r3 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x09db
            com.google.android.gms.measurement.internal.zzkv r3 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r3)     // Catch:{ all -> 0x0cfd }
            r3 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0cfd }
            r8 = r45
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r8, r6)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkv r6 = r1.zzi     // Catch:{ all -> 0x0cfd }
            zzal(r6)     // Catch:{ all -> 0x0cfd }
            long r8 = (long) r11     // Catch:{ all -> 0x0cfd }
            java.lang.Long r6 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r6)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r8 = r10.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8     // Catch:{ all -> 0x0cfd }
            r5.add(r8)     // Catch:{ all -> 0x0cfd }
            boolean r8 = r12.booleanValue()     // Catch:{ all -> 0x0cfd }
            if (r8 == 0) goto L_0x09cb
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0cfd }
            r9 = 0
            com.google.android.gms.measurement.internal.zzas r7 = r7.zza(r9, r6, r8)     // Catch:{ all -> 0x0cfd }
        L_0x09cb:
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            long r8 = r10.zzc()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzb(r8, r14)     // Catch:{ all -> 0x0cfd }
            r2.put(r6, r7)     // Catch:{ all -> 0x0cfd }
            goto L_0x09f1
        L_0x09db:
            r3 = 1
            boolean r6 = r12.booleanValue()     // Catch:{ all -> 0x0cfd }
            if (r6 == 0) goto L_0x09f1
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x0cfd }
            r8 = r27
            r9 = 0
            com.google.android.gms.measurement.internal.zzas r7 = r7.zza(r8, r9, r9)     // Catch:{ all -> 0x0cfd }
            r2.put(r6, r7)     // Catch:{ all -> 0x0cfd }
        L_0x09f1:
            r7 = r25
            r6 = r26
        L_0x09f5:
            r6.zzS(r7, r10)     // Catch:{ all -> 0x0cfd }
        L_0x09f8:
            int r9 = r7 + 1
            r3 = r6
            r6 = r23
            r4 = r24
            r7 = 0
            goto L_0x0713
        L_0x0a03:
            r6 = r3
            r24 = r4
            int r3 = r5.size()     // Catch:{ all -> 0x0cfd }
            int r4 = r6.zza()     // Catch:{ all -> 0x0cfd }
            if (r3 >= r4) goto L_0x0a16
            r6.zzr()     // Catch:{ all -> 0x0cfd }
            r6.zzg(r5)     // Catch:{ all -> 0x0cfd }
        L_0x0a16:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0cfd }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0cfd }
        L_0x0a1e:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0cfd }
            if (r3 == 0) goto L_0x0a39
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0cfd }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r4)     // Catch:{ all -> 0x0cfd }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzas r3 = (com.google.android.gms.measurement.internal.zzas) r3     // Catch:{ all -> 0x0cfd }
            r4.zzE(r3)     // Catch:{ all -> 0x0cfd }
            goto L_0x0a1e
        L_0x0a39:
            r2 = r24
            goto L_0x0a3e
        L_0x0a3c:
            r6 = r3
            r2 = r4
        L_0x0a3e:
            com.google.android.gms.internal.measurement.zzgd r3 = r2.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r4)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzh r4 = r4.zzj(r3)     // Catch:{ all -> 0x0cfd }
            if (r4 != 0) goto L_0x0a67
            com.google.android.gms.measurement.internal.zzeh r4 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r2.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0cfd }
            r4.zzb(r5, r7)     // Catch:{ all -> 0x0cfd }
            goto L_0x0ac3
        L_0x0a67:
            int r5 = r6.zza()     // Catch:{ all -> 0x0cfd }
            if (r5 <= 0) goto L_0x0ac3
            long r7 = r4.zzn()     // Catch:{ all -> 0x0cfd }
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0a7b
            r6.zzab(r7)     // Catch:{ all -> 0x0cfd }
            goto L_0x0a7e
        L_0x0a7b:
            r6.zzv()     // Catch:{ all -> 0x0cfd }
        L_0x0a7e:
            long r9 = r4.zzp()     // Catch:{ all -> 0x0cfd }
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0a89
            goto L_0x0a8a
        L_0x0a89:
            r7 = r9
        L_0x0a8a:
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0a92
            r6.zzac(r7)     // Catch:{ all -> 0x0cfd }
            goto L_0x0a95
        L_0x0a92:
            r6.zzw()     // Catch:{ all -> 0x0cfd }
        L_0x0a95:
            r4.zzE()     // Catch:{ all -> 0x0cfd }
            long r7 = r4.zzo()     // Catch:{ all -> 0x0cfd }
            int r5 = (int) r7     // Catch:{ all -> 0x0cfd }
            r6.zzI(r5)     // Catch:{ all -> 0x0cfd }
            long r7 = r6.zzd()     // Catch:{ all -> 0x0cfd }
            r4.zzab(r7)     // Catch:{ all -> 0x0cfd }
            long r7 = r6.zzc()     // Catch:{ all -> 0x0cfd }
            r4.zzZ(r7)     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = r4.zzs()     // Catch:{ all -> 0x0cfd }
            if (r5 == 0) goto L_0x0ab8
            r6.zzW(r5)     // Catch:{ all -> 0x0cfd }
            goto L_0x0abb
        L_0x0ab8:
            r6.zzs()     // Catch:{ all -> 0x0cfd }
        L_0x0abb:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r5)     // Catch:{ all -> 0x0cfd }
            r5.zzD(r4)     // Catch:{ all -> 0x0cfd }
        L_0x0ac3:
            int r4 = r6.zza()     // Catch:{ all -> 0x0cfd }
            if (r4 <= 0) goto L_0x0c47
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzn     // Catch:{ all -> 0x0cfd }
            r4.zzaw()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfi r4 = r1.zzc     // Catch:{ all -> 0x0cfd }
            zzal(r4)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r5 = r2.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzff r4 = r4.zze(r5)     // Catch:{ all -> 0x0cfd }
            r7 = -1
            if (r4 == 0) goto L_0x0af0
            boolean r5 = r4.zzs()     // Catch:{ all -> 0x0cfd }
            if (r5 != 0) goto L_0x0ae8
            goto L_0x0af0
        L_0x0ae8:
            long r4 = r4.zzc()     // Catch:{ all -> 0x0cfd }
            r6.zzK(r4)     // Catch:{ all -> 0x0cfd }
            goto L_0x0b17
        L_0x0af0:
            com.google.android.gms.internal.measurement.zzgd r4 = r2.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r4 = r4.zzF()     // Catch:{ all -> 0x0cfd }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0cfd }
            if (r4 == 0) goto L_0x0b00
            r6.zzK(r7)     // Catch:{ all -> 0x0cfd }
            goto L_0x0b17
        L_0x0b00:
            com.google.android.gms.measurement.internal.zzeh r4 = r42.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r2.zza     // Catch:{ all -> 0x0cfd }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0cfd }
            r4.zzb(r5, r9)     // Catch:{ all -> 0x0cfd }
        L_0x0b17:
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r4)     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzkf r5 = r6.zzaC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5     // Catch:{ all -> 0x0cfd }
            r4.zzg()     // Catch:{ all -> 0x0cfd }
            r4.zzW()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0cfd }
            boolean r6 = r5.zzbe()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x0cfd }
            r4.zzz()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.util.Clock r6 = r6.zzav()     // Catch:{ all -> 0x0cfd }
            long r9 = r6.currentTimeMillis()     // Catch:{ all -> 0x0cfd }
            long r11 = r5.zzk()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x0cfd }
            r6.zzf()     // Catch:{ all -> 0x0cfd }
            long r13 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0cfd }
            long r13 = r9 - r13
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x0b6b
            long r11 = r5.zzk()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x0cfd }
            r6.zzf()     // Catch:{ all -> 0x0cfd }
            long r13 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x0cfd }
            long r13 = r13 + r9
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0b8e
        L_0x0b6b:
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r12)     // Catch:{ all -> 0x0cfd }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0cfd }
            long r13 = r5.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0cfd }
            r6.zzd(r11, r12, r9, r10)     // Catch:{ all -> 0x0cfd }
        L_0x0b8e:
            byte[] r6 = r5.zzbu()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzkt r9 = r4.zzf     // Catch:{ IOException -> 0x0c2e }
            com.google.android.gms.measurement.internal.zzkv r9 = r9.zzi     // Catch:{ IOException -> 0x0c2e }
            zzal(r9)     // Catch:{ IOException -> 0x0c2e }
            byte[] r6 = r9.zzy(r6)     // Catch:{ IOException -> 0x0c2e }
            com.google.android.gms.measurement.internal.zzfr r9 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0cfd }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r6.length     // Catch:{ all -> 0x0cfd }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0cfd }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0cfd }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0cfd }
            r9.<init>()     // Catch:{ all -> 0x0cfd }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            r9.put(r10, r11)     // Catch:{ all -> 0x0cfd }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r5.zzk()     // Catch:{ all -> 0x0cfd }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0cfd }
            r9.put(r10, r11)     // Catch:{ all -> 0x0cfd }
            java.lang.String r10 = "data"
            r9.put(r10, r6)     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0cfd }
            r9.put(r6, r10)     // Catch:{ all -> 0x0cfd }
            boolean r6 = r5.zzbk()     // Catch:{ all -> 0x0cfd }
            if (r6 == 0) goto L_0x0bed
            java.lang.String r6 = "retry_count"
            int r10 = r5.zze()     // Catch:{ all -> 0x0cfd }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0cfd }
            r9.put(r6, r10)     // Catch:{ all -> 0x0cfd }
        L_0x0bed:
            android.database.sqlite.SQLiteDatabase r6 = r4.zzh()     // Catch:{ SQLiteException -> 0x0c14 }
            java.lang.String r10 = "queue"
            r11 = 0
            long r9 = r6.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c14 }
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0c47
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ SQLiteException -> 0x0c14 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0c14 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0c14 }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r5.zzx()     // Catch:{ SQLiteException -> 0x0c14 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x0c14 }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0c14 }
            goto L_0x0c47
        L_0x0c14:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x0cfd }
            r4.zzc(r7, r5, r6)     // Catch:{ all -> 0x0cfd }
            goto L_0x0c47
        L_0x0c2e:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0cfd }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x0cfd }
            r4.zzc(r7, r5, r6)     // Catch:{ all -> 0x0cfd }
        L_0x0c47:
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r4)     // Catch:{ all -> 0x0cfd }
            java.util.List r2 = r2.zzb     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0cfd }
            r4.zzg()     // Catch:{ all -> 0x0cfd }
            r4.zzW()     // Catch:{ all -> 0x0cfd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0cfd }
            r6 = 0
        L_0x0c5f:
            int r7 = r2.size()     // Catch:{ all -> 0x0cfd }
            if (r6 >= r7) goto L_0x0c7c
            if (r6 == 0) goto L_0x0c6c
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0cfd }
        L_0x0c6c:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0cfd }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0cfd }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0cfd }
            r5.append(r7)     // Catch:{ all -> 0x0cfd }
            int r6 = r6 + 1
            goto L_0x0c5f
        L_0x0c7c:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0cfd }
            android.database.sqlite.SQLiteDatabase r6 = r4.zzh()     // Catch:{ all -> 0x0cfd }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0cfd }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0cfd }
            int r6 = r2.size()     // Catch:{ all -> 0x0cfd }
            if (r5 == r6) goto L_0x0cb1
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0cfd }
            int r2 = r2.size()     // Catch:{ all -> 0x0cfd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0cfd }
            r4.zzc(r6, r5, r2)     // Catch:{ all -> 0x0cfd }
        L_0x0cb1:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ all -> 0x0cfd }
            java.lang.String[] r5 = new java.lang.String[]{r3, r3}     // Catch:{ SQLiteException -> 0x0cc4 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r4.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0cc4 }
            goto L_0x0cd9
        L_0x0cc4:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0cfd }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0cfd }
            r2.zzc(r5, r3, r4)     // Catch:{ all -> 0x0cfd }
        L_0x0cd9:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            r2.zzC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0ceb:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0cfd }
            zzal(r2)     // Catch:{ all -> 0x0cfd }
            r2.zzC()     // Catch:{ all -> 0x0cfd }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0cfd:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            goto L_0x0d09
        L_0x0d08:
            throw r2
        L_0x0d09:
            goto L_0x0d08
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzam = this.zze;
        zzal(zzam);
        if (zzam.zzF()) {
            return true;
        }
        zzam zzam2 = this.zze;
        zzal(zzam2);
        if (!TextUtils.isEmpty(zzam2.zzr())) {
            return true;
        }
        return false;
    }

    private final boolean zzaj(zzfs zzfs, zzfs zzfs2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB2 = zzkv.zzB((zzft) zzfs.zzaC(), "_sc");
        String str2 = null;
        if (zzB2 == null) {
            str = null;
        } else {
            str = zzB2.zzh();
        }
        zzal(this.zzi);
        zzfx zzB3 = zzkv.zzB((zzft) zzfs2.zzaC(), "_pc");
        if (zzB3 != null) {
            str2 = zzB3.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB4 = zzkv.zzB((zzft) zzfs.zzaC(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzal(this.zzi);
        zzfx zzB5 = zzkv.zzB((zzft) zzfs2.zzaC(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzal(this.zzi);
        zzkv.zzz(zzfs2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzkv.zzz(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        if (!TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq)) {
            return true;
        }
        return false;
    }

    private static final zzkh zzal(zzkh zzkh) {
        if (zzkh == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkh.zzY()) {
            return zzkh;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkh.getClass())));
        }
    }

    public static zzkt zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                if (zzb == null) {
                    zzb = new zzkt((zzku) Preconditions.checkNotNull(new zzku(context)), (zzfr) null);
                }
            }
        }
        return zzb;
    }

    public static /* bridge */ /* synthetic */ void zzy(zzkt zzkt, zzku zzku) {
        zzkt.zzaz().zzg();
        zzkt.zzm = new zzez(zzkt);
        zzam zzam = new zzam(zzkt);
        zzam.zzX();
        zzkt.zze = zzam;
        zzkt.zzg().zzq((zzaf) Preconditions.checkNotNull(zzkt.zzc));
        zzjo zzjo = new zzjo(zzkt);
        zzjo.zzX();
        zzkt.zzk = zzjo;
        zzaa zzaa = new zzaa(zzkt);
        zzaa.zzX();
        zzkt.zzh = zzaa;
        zzic zzic = new zzic(zzkt);
        zzic.zzX();
        zzkt.zzj = zzic;
        zzkf zzkf = new zzkf(zzkt);
        zzkf.zzX();
        zzkt.zzg = zzkf;
        zzkt.zzf = new zzep(zzkt);
        if (zzkt.zzr != zzkt.zzs) {
            zzkt.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzkt.zzr), Integer.valueOf(zzkt.zzs));
        }
        zzkt.zzo = true;
    }

    @VisibleForTesting
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i10 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i10 = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e10) {
                        zzay().zzd().zzb("Failed to read from channel", e10);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i10 > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                } else if (i10 < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e11) {
                            zzay().zzd().zzb("Failed to write to channel", e11);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                }
            }
        }
    }

    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzC(String str, zzgc zzgc) {
        int zza2;
        int indexOf;
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        Set zzk2 = zzfi.zzk(str);
        if (zzk2 != null) {
            zzgc.zzi(zzk2);
        }
        zzfi zzfi2 = this.zzc;
        zzal(zzfi2);
        if (zzfi2.zzv(str)) {
            zzgc.zzp();
        }
        zzfi zzfi3 = this.zzc;
        zzal(zzfi3);
        if (zzfi3.zzy(str)) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String zzar = zzgc.zzar();
                if (!TextUtils.isEmpty(zzar) && (indexOf = zzar.indexOf(".")) != -1) {
                    zzgc.zzY(zzar.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        zzfi zzfi4 = this.zzc;
        zzal(zzfi4);
        if (zzfi4.zzz(str) && (zza2 = zzkv.zza(zzgc, bx.f13988d)) != -1) {
            zzgc.zzB(zza2);
        }
        zzfi zzfi5 = this.zzc;
        zzal(zzfi5);
        if (zzfi5.zzx(str)) {
            zzgc.zzq();
        }
        zzfi zzfi6 = this.zzc;
        zzal(zzfi6);
        if (zzfi6.zzu(str)) {
            zzgc.zzn();
            zzks zzks = (zzks) this.zzC.get(str);
            if (zzks == null || zzks.zzb + zzg().zzi(str, zzdu.zzR) < zzav().elapsedRealtime()) {
                zzks = new zzks(this);
                this.zzC.put(str, zzks);
            }
            zzgc.zzR(zzks.zza);
        }
        zzfi zzfi7 = this.zzc;
        zzal(zzfi7);
        if (zzfi7.zzw(str)) {
            zzgc.zzy();
        }
    }

    public final void zzD(zzh zzh2) {
        a aVar;
        a aVar2;
        zzaz().zzg();
        if (!TextUtils.isEmpty(zzh2.zzy()) || !TextUtils.isEmpty(zzh2.zzr())) {
            zzki zzki = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzy2 = zzh2.zzy();
            if (TextUtils.isEmpty(zzy2)) {
                zzy2 = zzh2.zzr();
            }
            a aVar3 = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzdu.zzd.zza((Object) null)).encodedAuthority((String) zzdu.zze.zza((Object) null)).path("config/app/".concat(String.valueOf(zzy2))).appendQueryParameter(DispatchConstants.PLATFORM, "android");
            zzki.zzt.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzh2.zzt());
                URL url = new URL(uri);
                zzay().zzj().zzb("Fetching remote configuration", str);
                zzfi zzfi = this.zzc;
                zzal(zzfi);
                zzff zze2 = zzfi.zze(str);
                zzfi zzfi2 = this.zzc;
                zzal(zzfi2);
                String zzh3 = zzfi2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh3)) {
                        aVar2 = new a();
                        aVar2.put(HttpHeaders.IF_MODIFIED_SINCE, zzh3);
                    } else {
                        aVar2 = null;
                    }
                    zzox.zzc();
                    if (zzg().zzs((String) null, zzdu.zzao)) {
                        zzfi zzfi3 = this.zzc;
                        zzal(zzfi3);
                        String zzf2 = zzfi3.zzf(str);
                        if (!TextUtils.isEmpty(zzf2)) {
                            if (aVar2 == null) {
                                aVar2 = new a();
                            }
                            aVar3 = aVar2;
                            aVar3.put(HttpHeaders.IF_NONE_MATCH, zzf2);
                        }
                    }
                    aVar = aVar2;
                    this.zzt = true;
                    zzen zzen = this.zzd;
                    zzal(zzen);
                    zzkl zzkl = new zzkl(this);
                    zzen.zzg();
                    zzen.zzW();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(zzkl);
                    zzen.zzt.zzaz().zzo(new zzem(zzen, str, url, (byte[]) null, aVar, zzkl));
                }
                aVar = aVar3;
                this.zzt = true;
                zzen zzen2 = this.zzd;
                zzal(zzen2);
                zzkl zzkl2 = new zzkl(this);
                zzen2.zzg();
                zzen2.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzkl2);
                zzen2.zzt.zzaz().zzo(new zzem(zzen2, str, url, (byte[]) null, aVar, zzkl2));
            } catch (MalformedURLException unused) {
                zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(zzh2.zzt()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(zzh2.zzt()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    public final void zzE(zzaw zzaw, zzq zzq2) {
        zzaw zzaw2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j10 = zzaw.zzd;
        zzei zzb2 = zzei.zzb(zzaw);
        zzaz().zzg();
        zzie zzie = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zzie = this.zzD;
        }
        zzlb.zzK(zzie, zzb2.zzd, false);
        zzaw zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzkv.zzA(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzaw2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzaw2 = new zzaw(zza2.zza, new zzau(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                Preconditions.checkNotEmpty(str2);
                zzam2.zzg();
                zzam2.zzW();
                if (j10 < 0) {
                    zzam2.zzt.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    list = Collections.emptyList();
                } else {
                    list = zzam2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzay().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzaw zzaw3 = zzac.zzg;
                        if (zzaw3 != null) {
                            zzY(new zzaw(zzaw3, j10), zzq3);
                        }
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str2, zzac.zzc.zzb);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                Preconditions.checkNotEmpty(str2);
                zzam4.zzg();
                zzam4.zzW();
                if (j10 < 0) {
                    zzam4.zzt.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzam4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList<zzaw> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzay().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        zzam zzam5 = this.zze;
                        zzal(zzam5);
                        zzam5.zzA(str2, zzac2.zzc.zzb);
                        zzaw zzaw4 = zzac2.zzk;
                        if (zzaw4 != null) {
                            arrayList.add(zzaw4);
                        }
                        zzam zzam6 = this.zze;
                        zzal(zzam6);
                        zzam6.zza(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzaw zzaw5 : arrayList) {
                    zzY(new zzaw(zzaw5, j10), zzq3);
                }
                zzam zzam7 = this.zze;
                zzal(zzam7);
                String str3 = zzaw2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzam7.zzg();
                zzam7.zzW();
                if (j10 < 0) {
                    zzam7.zzt.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzam7.zzt.zzj().zzd(str3), Long.valueOf(j10));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzam7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList<zzaw> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzkw zzkw = zzac3.zzc;
                        zzky zzky = new zzky((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzkw.zzb, j10, Preconditions.checkNotNull(zzkw.zza()));
                        zzam zzam8 = this.zze;
                        zzal(zzam8);
                        if (zzam8.zzL(zzky)) {
                            zzay().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzac3.zza), this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        }
                        zzaw zzaw6 = zzac3.zzi;
                        if (zzaw6 != null) {
                            arrayList2.add(zzaw6);
                        }
                        zzac3.zzc = new zzkw(zzky);
                        zzac3.zze = true;
                        zzam zzam9 = this.zze;
                        zzal(zzam9);
                        zzam9.zzK(zzac3);
                    }
                }
                zzY(zzaw2, zzq3);
                for (zzaw zzaw7 : arrayList2) {
                    zzY(new zzaw(zzaw7, j10), zzq3);
                }
                zzam zzam10 = this.zze;
                zzal(zzam10);
                zzam10.zzC();
            } finally {
                zzam zzam11 = this.zze;
                zzal(zzam11);
                zzam11.zzx();
            }
        }
    }

    public final void zzF(zzaw zzaw, String str) {
        zzaw zzaw2 = zzaw;
        String str2 = str;
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(zzj2);
        if (zzad == null) {
            if (!"_ui".equals(zzaw2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        String zzy2 = zzj2.zzy();
        String zzw2 = zzj2.zzw();
        long zzb2 = zzj2.zzb();
        String zzv2 = zzj2.zzv();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        boolean zzai = zzj2.zzai();
        String zzx2 = zzj2.zzx();
        zzj2.zza();
        zzq zzq2 = r2;
        zzh zzh2 = zzj2;
        zzq zzq3 = new zzq(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzai, false, zzx2, 0, 0, 0, zzh2.zzah(), false, zzh2.zzr(), zzh2.zzq(), zzh2.zzk(), zzh2.zzC(), (String) null, zzh(str2).zzh(), "", (String) null);
        zzG(zzaw2, zzq2);
    }

    public final void zzG(zzaw zzaw, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzei zzb2 = zzei.zzb(zzaw);
        zzlb zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzam zzam = this.zze;
        zzal(zzam);
        zzv2.zzL(bundle, zzam.zzi(zzq2.zza));
        zzv().zzM(zzb2, zzg().zzd(zzq2.zza));
        zzaw zza2 = zzb2.zza();
        if ("_cmp".equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzkw("_lgclid", zza2.zzd, zzg2, ConnType.PK_AUTO), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    public final void zzH() {
        this.zzs++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105 A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011c A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139 A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0147 A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0169 A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016d A[Catch:{ all -> 0x0186, all -> 0x0190 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzfo r0 = r8.zzaz()
            r0.zzg()
            r8.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x0190 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzeh r1 = r8.zzay()     // Catch:{ all -> 0x0190 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()     // Catch:{ all -> 0x0190 }
            int r2 = r12.length     // Catch:{ all -> 0x0190 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0190 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0190 }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x0190 }
            zzal(r1)     // Catch:{ all -> 0x0190 }
            r1.zzw()     // Catch:{ all -> 0x0190 }
            com.google.android.gms.measurement.internal.zzam r1 = r8.zze     // Catch:{ all -> 0x0186 }
            zzal(r1)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzj(r9)     // Catch:{ all -> 0x0186 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0043
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0043
            if (r10 != r4) goto L_0x0047
            r10 = 304(0x130, float:4.26E-43)
        L_0x0043:
            if (r11 != 0) goto L_0x0047
            r3 = 1
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ all -> 0x0186 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0186 }
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0186 }
            goto L_0x0170
        L_0x005d:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00bb
            if (r10 != r5) goto L_0x0064
            goto L_0x00bb
        L_0x0064:
            com.google.android.gms.common.util.Clock r12 = r8.zzav()     // Catch:{ all -> 0x0186 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            r1.zzU(r12)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzam r12 = r8.zze     // Catch:{ all -> 0x0186 }
            zzal(r12)     // Catch:{ all -> 0x0186 }
            r12.zzD(r1)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzeh r12 = r8.zzay()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzj()     // Catch:{ all -> 0x0186 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0186 }
            r12.zzc(r13, r1, r11)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0186 }
            zzal(r11)     // Catch:{ all -> 0x0186 }
            r11.zzl(r9)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzd     // Catch:{ all -> 0x0186 }
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0186 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            r9.zzb(r11)     // Catch:{ all -> 0x0186 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a7
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b6
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzb     // Catch:{ all -> 0x0186 }
            com.google.android.gms.common.util.Clock r10 = r8.zzav()     // Catch:{ all -> 0x0186 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            r9.zzb(r10)     // Catch:{ all -> 0x0186 }
        L_0x00b6:
            r8.zzag()     // Catch:{ all -> 0x0186 }
            goto L_0x0170
        L_0x00bb:
            r11 = 0
            if (r13 == 0) goto L_0x00c7
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r3 = r13.get(r3)     // Catch:{ all -> 0x0186 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0186 }
            goto L_0x00c8
        L_0x00c7:
            r3 = r11
        L_0x00c8:
            if (r3 == 0) goto L_0x00d7
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0186 }
            if (r6 != 0) goto L_0x00d7
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0186 }
            goto L_0x00d8
        L_0x00d7:
            r3 = r11
        L_0x00d8:
            com.google.android.gms.internal.measurement.zzox.zzc()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzag r6 = r8.zzg()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzao     // Catch:{ all -> 0x0186 }
            boolean r6 = r6.zzs(r11, r7)     // Catch:{ all -> 0x0186 }
            if (r6 == 0) goto L_0x0102
            if (r13 == 0) goto L_0x00f2
            java.lang.String r6 = "ETag"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x0186 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0186 }
            goto L_0x00f3
        L_0x00f2:
            r13 = r11
        L_0x00f3:
            if (r13 == 0) goto L_0x0102
            boolean r6 = r13.isEmpty()     // Catch:{ all -> 0x0186 }
            if (r6 != 0) goto L_0x0102
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0186 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0186 }
            goto L_0x0103
        L_0x0102:
            r13 = r11
        L_0x0103:
            if (r10 == r5) goto L_0x0111
            if (r10 != r4) goto L_0x0108
            goto L_0x0111
        L_0x0108:
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0186 }
            zzal(r11)     // Catch:{ all -> 0x0186 }
            r11.zzt(r9, r12, r3, r13)     // Catch:{ all -> 0x0186 }
            goto L_0x0124
        L_0x0111:
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0186 }
            zzal(r12)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.internal.measurement.zzff r12 = r12.zze(r9)     // Catch:{ all -> 0x0186 }
            if (r12 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0186 }
            zzal(r12)     // Catch:{ all -> 0x0186 }
            r12.zzt(r9, r11, r11, r11)     // Catch:{ all -> 0x0186 }
        L_0x0124:
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0186 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            r1.zzL(r11)     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzam r11 = r8.zze     // Catch:{ all -> 0x0186 }
            zzal(r11)     // Catch:{ all -> 0x0186 }
            r11.zzD(r1)     // Catch:{ all -> 0x0186 }
            if (r10 != r5) goto L_0x0147
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzl()     // Catch:{ all -> 0x0186 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0186 }
            goto L_0x0158
        L_0x0147:
            com.google.android.gms.measurement.internal.zzeh r9 = r8.zzay()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0186 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0186 }
            r9.zzc(r11, r10, r2)     // Catch:{ all -> 0x0186 }
        L_0x0158:
            com.google.android.gms.measurement.internal.zzen r9 = r8.zzd     // Catch:{ all -> 0x0186 }
            zzal(r9)     // Catch:{ all -> 0x0186 }
            boolean r9 = r9.zza()     // Catch:{ all -> 0x0186 }
            if (r9 == 0) goto L_0x016d
            boolean r9 = r8.zzai()     // Catch:{ all -> 0x0186 }
            if (r9 == 0) goto L_0x016d
            r8.zzX()     // Catch:{ all -> 0x0186 }
            goto L_0x0170
        L_0x016d:
            r8.zzag()     // Catch:{ all -> 0x0186 }
        L_0x0170:
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x0186 }
            zzal(r9)     // Catch:{ all -> 0x0186 }
            r9.zzC()     // Catch:{ all -> 0x0186 }
            com.google.android.gms.measurement.internal.zzam r9 = r8.zze     // Catch:{ all -> 0x0190 }
            zzal(r9)     // Catch:{ all -> 0x0190 }
            r9.zzx()     // Catch:{ all -> 0x0190 }
            r8.zzt = r0
            r8.zzae()
            return
        L_0x0186:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzam r10 = r8.zze     // Catch:{ all -> 0x0190 }
            zzal(r10)     // Catch:{ all -> 0x0190 }
            r10.zzx()     // Catch:{ all -> 0x0190 }
            throw r9     // Catch:{ all -> 0x0190 }
        L_0x0190:
            r9 = move-exception
            r8.zzt = r0
            r8.zzae()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void zzJ(boolean z10) {
        zzag();
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    public final void zzK(int i10, Throwable th, byte[] bArr, String str) {
        zzam zzam;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i10 == 503 || i10 == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzam2 = this.zze;
            zzal(zzam2);
            zzam2.zzy(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    for (Long l10 : list) {
                        try {
                            zzam = this.zze;
                            zzal(zzam);
                            long longValue = l10.longValue();
                            zzam.zzg();
                            zzam.zzW();
                            if (zzam.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e10) {
                            zzam.zzt.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e10);
                            throw e10;
                        } catch (SQLiteException e11) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l10)) {
                                throw e11;
                            }
                        }
                    }
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                    this.zzz = null;
                    zzen zzen = this.zzd;
                    zzal(zzen);
                    if (!zzen.zza() || !zzai()) {
                        this.zzA = -1;
                        zzag();
                    } else {
                        zzX();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e12) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e12);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzae();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzam zzam22 = this.zze;
        zzal(zzam22);
        zzam22.zzy(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x03f1 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x041d A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0432 A[SYNTHETIC, Splitter:B:140:0x0432] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04d6 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04f1 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0551 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0140 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ff A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0203 A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x025d A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x026c A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027c A[Catch:{ NameNotFoundException -> 0x0441, all -> 0x057f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfo r8 = r24.zzaz()
            r8.zzg()
            r24.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzak(r25)
            if (r8 == 0) goto L_0x0589
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze
            zzal(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzh r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzy()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzL(r9)
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzD(r8)
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc
            zzal(r8)
            java.lang.String r11 = r2.zza
            r8.zzm(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r24.zzd(r25)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r24.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfr r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzeh r13 = r24.zzay()
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze
            zzal(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r9)     // Catch:{ all -> 0x057f }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x057f }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzky r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x057f }
            if (r9 == 0) goto L_0x00c5
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x057f }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x057f }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r21 = r3
            r22 = r4
            r3 = 1
            goto L_0x0117
        L_0x00c5:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x057f }
            if (r10 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x057f }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x057f }
            if (r15 == r13) goto L_0x00d8
            r19 = 0
            goto L_0x00da
        L_0x00d8:
            r19 = 1
        L_0x00da:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x057f }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x057f }
            if (r9 == 0) goto L_0x00fb
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x057f }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x057f }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x057f }
            if (r9 != 0) goto L_0x0117
        L_0x00fb:
            r1.zzW(r10, r2)     // Catch:{ all -> 0x057f }
            goto L_0x0117
        L_0x00ff:
            r21 = r3
            r22 = r4
            r3 = 1
            if (r9 == 0) goto L_0x0117
            com.google.android.gms.measurement.internal.zzkw r9 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x057f }
            r1.zzP(r9, r2)     // Catch:{ all -> 0x057f }
        L_0x0117:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r9)     // Catch:{ all -> 0x057f }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x057f }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x057f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x057f }
            if (r9 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.zzlb r13 = r24.zzv()     // Catch:{ all -> 0x057f }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x057f }
            java.lang.String r15 = r9.zzy()     // Catch:{ all -> 0x057f }
            java.lang.String r3 = r2.zzq     // Catch:{ all -> 0x057f }
            java.lang.String r4 = r9.zzr()     // Catch:{ all -> 0x057f }
            boolean r3 = r13.zzam(r14, r15, r3, r4)     // Catch:{ all -> 0x057f }
            if (r3 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.zzeh r3 = r24.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.zzt()     // Catch:{ all -> 0x057f }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x057f }
            r3.zzb(r4, r13)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r3)     // Catch:{ all -> 0x057f }
            java.lang.String r4 = r9.zzt()     // Catch:{ all -> 0x057f }
            r3.zzW()     // Catch:{ all -> 0x057f }
            r3.zzg()     // Catch:{ all -> 0x057f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x057f }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x01e7 }
            java.lang.String[] r13 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x01e7 }
            java.lang.String r14 = "events"
            int r14 = r9.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            java.lang.String r15 = "user_attributes"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r15
            com.google.android.gms.internal.measurement.zzoi.zzc()     // Catch:{ SQLiteException -> 0x01e7 }
            com.google.android.gms.measurement.internal.zzfr r15 = r3.zzt     // Catch:{ SQLiteException -> 0x01e7 }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01e7 }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzat     // Catch:{ SQLiteException -> 0x01e7 }
            r23 = r6
            r6 = 0
            boolean r10 = r15.zzs(r6, r10)     // Catch:{ SQLiteException -> 0x01e5 }
            if (r10 == 0) goto L_0x01cf
            java.lang.String r6 = "default_event_params"
            int r0 = r9.delete(r6, r0, r13)     // Catch:{ SQLiteException -> 0x01e5 }
            int r14 = r14 + r0
        L_0x01cf:
            if (r14 <= 0) goto L_0x01fd
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ SQLiteException -> 0x01e5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01e5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01e5 }
            java.lang.String r6 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01e5 }
            r0.zzc(r6, r4, r9)     // Catch:{ SQLiteException -> 0x01e5 }
            goto L_0x01fd
        L_0x01e5:
            r0 = move-exception
            goto L_0x01ea
        L_0x01e7:
            r0 = move-exception
            r23 = r6
        L_0x01ea:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r6 = "Error deleting application data. appId, error"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x057f }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x057f }
        L_0x01fd:
            r9 = 0
            goto L_0x0201
        L_0x01ff:
            r23 = r6
        L_0x0201:
            if (r9 == 0) goto L_0x0258
            long r3 = r9.zzb()     // Catch:{ all -> 0x057f }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021a
            long r3 = r9.zzb()     // Catch:{ all -> 0x057f }
            long r13 = r2.zzj     // Catch:{ all -> 0x057f }
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021a
            r0 = 1
            goto L_0x021b
        L_0x021a:
            r0 = 0
        L_0x021b:
            java.lang.String r3 = r9.zzw()     // Catch:{ all -> 0x057f }
            long r9 = r9.zzb()     // Catch:{ all -> 0x057f }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0236
            if (r3 == 0) goto L_0x0236
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x057f }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x057f }
            if (r4 != 0) goto L_0x0236
            r15 = 1
            goto L_0x0237
        L_0x0236:
            r15 = 0
        L_0x0237:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x0258
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x057f }
            r0.<init>()     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x057f }
            r15.<init>(r0)     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x057f }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x057f }
        L_0x0258:
            r24.zzd(r25)     // Catch:{ all -> 0x057f }
            if (r8 != 0) goto L_0x026c
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r0)     // Catch:{ all -> 0x057f }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x057f }
            r15 = 0
            goto L_0x027a
        L_0x026c:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r0)     // Catch:{ all -> 0x057f }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x057f }
            r15 = 1
        L_0x027a:
            if (r0 != 0) goto L_0x0551
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x0509
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x057f }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x057f }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x057f }
            r0.zzg()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzez r0 = r1.zzm     // Catch:{ all -> 0x057f }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x057f }
            r8 = r0
            com.google.android.gms.measurement.internal.zzez r8 = (com.google.android.gms.measurement.internal.zzez) r8     // Catch:{ all -> 0x057f }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x057f }
            if (r0 == 0) goto L_0x03ac
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x057f }
            if (r9 == 0) goto L_0x02be
            goto L_0x03ac
        L_0x02be:
            com.google.android.gms.measurement.internal.zzfr r9 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfo r9 = r9.zzaz()     // Catch:{ all -> 0x057f }
            r9.zzg()     // Catch:{ all -> 0x057f }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x057f }
            if (r9 != 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x057f }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x057f }
        L_0x02dc:
            r14 = 1
            r15 = 0
            goto L_0x03bd
        L_0x02e0:
            com.google.android.gms.measurement.internal.zzey r9 = new com.google.android.gms.measurement.internal.zzey     // Catch:{ all -> 0x057f }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()     // Catch:{ all -> 0x057f }
            r0.zzg()     // Catch:{ all -> 0x057f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x057f }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x057f }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r13.<init>(r5, r14)     // Catch:{ all -> 0x057f }
            r0.setComponent(r13)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfr r13 = r8.zza     // Catch:{ all -> 0x057f }
            android.content.Context r13 = r13.zzau()     // Catch:{ all -> 0x057f }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x057f }
            if (r13 != 0) goto L_0x031b
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x057f }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x057f }
            goto L_0x02dc
        L_0x031b:
            r15 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r15)     // Catch:{ all -> 0x057f }
            if (r13 == 0) goto L_0x039b
            boolean r14 = r13.isEmpty()     // Catch:{ all -> 0x057f }
            if (r14 != 0) goto L_0x039b
            java.lang.Object r13 = r13.get(r15)     // Catch:{ all -> 0x057f }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x057f }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x057f }
            if (r13 == 0) goto L_0x0399
            java.lang.String r14 = r13.packageName     // Catch:{ all -> 0x057f }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x057f }
            if (r13 == 0) goto L_0x0388
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x057f }
            if (r5 == 0) goto L_0x0388
            boolean r5 = r8.zza()     // Catch:{ all -> 0x057f }
            if (r5 == 0) goto L_0x0388
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x057f }
            r5.<init>(r0)     // Catch:{ all -> 0x057f }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzfr r13 = r8.zza     // Catch:{ RuntimeException -> 0x0372 }
            android.content.Context r13 = r13.zzau()     // Catch:{ RuntimeException -> 0x0372 }
            r14 = 1
            boolean r0 = r0.bindService(r13, r5, r9, r14)     // Catch:{ RuntimeException -> 0x0370 }
            com.google.android.gms.measurement.internal.zzfr r5 = r8.zza     // Catch:{ RuntimeException -> 0x0370 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ RuntimeException -> 0x0370 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0370 }
            java.lang.String r9 = "Install Referrer Service is"
            java.lang.String r13 = "available"
            java.lang.String r16 = "not available"
            if (r14 == r0) goto L_0x036c
            r13 = r16
        L_0x036c:
            r5.zzb(r9, r13)     // Catch:{ RuntimeException -> 0x0370 }
            goto L_0x03bd
        L_0x0370:
            r0 = move-exception
            goto L_0x0374
        L_0x0372:
            r0 = move-exception
            r14 = 1
        L_0x0374:
            com.google.android.gms.measurement.internal.zzfr r5 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x057f }
            r5.zzb(r8, r0)     // Catch:{ all -> 0x057f }
            goto L_0x03bd
        L_0x0388:
            r14 = 1
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x057f }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x057f }
            goto L_0x03bd
        L_0x0399:
            r14 = 1
            goto L_0x03bd
        L_0x039b:
            r14 = 1
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x057f }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x057f }
            goto L_0x03bd
        L_0x03ac:
            r14 = 1
            r15 = 0
            com.google.android.gms.measurement.internal.zzfr r0 = r8.zza     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x057f }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x057f }
        L_0x03bd:
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x057f }
            r0.zzg()     // Catch:{ all -> 0x057f }
            r24.zzB()     // Catch:{ all -> 0x057f }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x057f }
            r5.<init>()     // Catch:{ all -> 0x057f }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x057f }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x057f }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x057f }
            r6 = r23
            r5.putLong(r6, r8)     // Catch:{ all -> 0x057f }
            r10 = r22
            r5.putLong(r10, r8)     // Catch:{ all -> 0x057f }
            r13 = r21
            r5.putLong(r13, r8)     // Catch:{ all -> 0x057f }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x057f }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x057f }
            if (r0 == 0) goto L_0x03f4
            r5.putLong(r3, r8)     // Catch:{ all -> 0x057f }
        L_0x03f4:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x057f }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x057f }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r0)     // Catch:{ all -> 0x057f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x057f }
            r0.zzg()     // Catch:{ all -> 0x057f }
            r0.zzW()     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.zzc(r3, r4)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x057f }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x057f }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x057f }
            if (r0 != 0) goto L_0x0432
            com.google.android.gms.measurement.internal.zzeh r0 = r24.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x057f }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x057f }
        L_0x042e:
            r3 = 0
            goto L_0x04ed
        L_0x0432:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0441 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x0441 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0441 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r15)     // Catch:{ NameNotFoundException -> 0x0441 }
            goto L_0x0454
        L_0x0441:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r4 = r24.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r15 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x057f }
            r4.zzc(r15, r14, r0)     // Catch:{ all -> 0x057f }
            r0 = 0
        L_0x0454:
            if (r0 == 0) goto L_0x04a7
            long r14 = r0.firstInstallTime     // Catch:{ all -> 0x057f }
            r16 = 0
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x04a7
            r21 = r3
            long r3 = r0.lastUpdateTime     // Catch:{ all -> 0x057f }
            int r0 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0488
            com.google.android.gms.measurement.internal.zzag r0 = r24.zzg()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzab     // Catch:{ all -> 0x057f }
            r4 = 0
            boolean r0 = r0.zzs(r4, r3)     // Catch:{ all -> 0x057f }
            if (r0 == 0) goto L_0x0482
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0480
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x057f }
            r8 = 0
        L_0x0480:
            r15 = 0
            goto L_0x048a
        L_0x0482:
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x057f }
            goto L_0x0480
        L_0x0488:
            r4 = 0
            r15 = 1
        L_0x048a:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_fi"
            r3 = 1
            if (r3 == r15) goto L_0x0494
            r15 = 0
            goto L_0x0496
        L_0x0494:
            r15 = 1
        L_0x0496:
            java.lang.Long r17 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x057f }
            java.lang.String r18 = "auto"
            r7 = r13
            r13 = r0
            r4 = 0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x057f }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x057f }
            goto L_0x04ac
        L_0x04a7:
            r21 = r3
            r7 = r13
            r3 = 1
            r4 = 0
        L_0x04ac:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04bf }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04bf }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04bf }
            r13 = r21
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r13, r4)     // Catch:{ NameNotFoundException -> 0x04bd }
            goto L_0x04d4
        L_0x04bd:
            r0 = move-exception
            goto L_0x04c2
        L_0x04bf:
            r0 = move-exception
            r13 = r21
        L_0x04c2:
            com.google.android.gms.measurement.internal.zzeh r4 = r24.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x057f }
            r4.zzc(r14, r13, r0)     // Catch:{ all -> 0x057f }
            r0 = 0
        L_0x04d4:
            if (r0 == 0) goto L_0x042e
            int r4 = r0.flags     // Catch:{ all -> 0x057f }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04e0
            r3 = 1
            r5.putLong(r10, r3)     // Catch:{ all -> 0x057f }
        L_0x04e0:
            int r0 = r0.flags     // Catch:{ all -> 0x057f }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x042e
            r3 = 1
            r5.putLong(r7, r3)     // Catch:{ all -> 0x057f }
            goto L_0x042e
        L_0x04ed:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04f4
            r5.putLong(r6, r8)     // Catch:{ all -> 0x057f }
        L_0x04f4:
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x057f }
            r15.<init>(r5)     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x057f }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x057f }
            goto L_0x056e
        L_0x0509:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x057f }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x057f }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzfo r0 = r24.zzaz()     // Catch:{ all -> 0x057f }
            r0.zzg()     // Catch:{ all -> 0x057f }
            r24.zzB()     // Catch:{ all -> 0x057f }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x057f }
            r0.<init>()     // Catch:{ all -> 0x057f }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x057f }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x057f }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x057f }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x057f }
            if (r4 == 0) goto L_0x053c
            r0.putLong(r3, r7)     // Catch:{ all -> 0x057f }
        L_0x053c:
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x057f }
            r15.<init>(r0)     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x057f }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x057f }
            goto L_0x056e
        L_0x0551:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x057f }
            if (r0 == 0) goto L_0x056e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x057f }
            r0.<init>()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x057f }
            r15.<init>(r0)     // Catch:{ all -> 0x057f }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x057f }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x057f }
        L_0x056e:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x057f }
            zzal(r0)     // Catch:{ all -> 0x057f }
            r0.zzC()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze
            zzal(r0)
            r0.zzx()
            return
        L_0x057f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            throw r0
        L_0x0589:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    public final void zzM() {
        this.zzr++;
    }

    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    public final void zzO(zzac zzac, zzq zzq2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzac zzk2 = zzam2.zzk(str, zzac.zzc.zzb);
                    if (zzk2 != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        zzam zzam3 = this.zze;
                        zzal(zzam3);
                        zzam3.zza(str, zzac.zzc.zzb);
                        if (zzk2.zze) {
                            zzam zzam4 = this.zze;
                            zzal(zzam4);
                            zzam4.zzA(str, zzac.zzc.zzb);
                        }
                        zzaw zzaw = zzac.zzk;
                        if (zzaw != null) {
                            zzau zzau = zzaw.zzb;
                            if (zzau != null) {
                                bundle = zzau.zzc();
                            } else {
                                bundle = null;
                            }
                            zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzac.zzk)).zza, bundle, zzk2.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzC();
                } finally {
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    zzam6.zzx();
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    public final void zzP(zzkw zzkw, zzq zzq2) {
        long j10;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(zzkw.zzb) || zzq2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkw.zzb));
                zzam zzam = this.zze;
                zzal(zzam);
                zzam.zzw();
                try {
                    zzd(zzq2);
                    if (bx.f13988d.equals(zzkw.zzb)) {
                        zzam zzam2 = this.zze;
                        zzal(zzam2);
                        zzam2.zzA((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    zzam3.zzA((String) Preconditions.checkNotNull(zzq2.zza), zzkw.zzb);
                    zzam zzam4 = this.zze;
                    zzal(zzam4);
                    zzam4.zzC();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkw.zzb));
                } finally {
                    zzam zzam5 = this.zze;
                    zzal(zzam5);
                    zzam5.zzx();
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = zzav().currentTimeMillis();
                if (true != zzq2.zzr.booleanValue()) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                zzW(new zzkw("_npa", currentTimeMillis, Long.valueOf(j10), ConnType.PK_AUTO), zzq2);
            }
        }
    }

    @VisibleForTesting
    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzam = this.zze;
        zzal(zzam);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        zzam.zzg();
        zzam.zzW();
        try {
            SQLiteDatabase zzh2 = zzam.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete(f.ax, "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzam.zzt.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            zzam.zzt.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e10);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    public final void zzR(String str, zzie zzie) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzie != null) {
            this.zzE = str;
            this.zzD = zzie;
        }
    }

    public final void zzS() {
        zzaz().zzg();
        zzam zzam = this.zze;
        zzal(zzam);
        zzam.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z10 = false;
            zzac2.zze = false;
            zzam zzam = this.zze;
            zzal(zzam);
            zzam.zzw();
            try {
                zzam zzam2 = this.zze;
                zzal(zzam2);
                zzac zzk2 = zzam2.zzk((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzac2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzac2.zzb = zzk2.zzb;
                    zzac2.zzd = zzk2.zzd;
                    zzac2.zzh = zzk2.zzh;
                    zzac2.zzf = zzk2.zzf;
                    zzac2.zzi = zzk2.zzi;
                    zzac2.zze = true;
                    zzkw zzkw = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw.zzb, zzk2.zzc.zzc, zzkw.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzkw zzkw2 = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw2.zzb, zzac2.zzd, zzkw2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z10 = true;
                }
                if (zzac2.zze) {
                    zzkw zzkw3 = zzac2.zzc;
                    zzky zzky = new zzky((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzkw3.zzb, zzkw3.zzc, Preconditions.checkNotNull(zzkw3.zza()));
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzL(zzky)) {
                        zzay().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                    }
                    if (z10 && zzac2.zzi != null) {
                        zzY(new zzaw(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                zzam zzam4 = this.zze;
                zzal(zzam4);
                if (zzam4.zzK(zzac2)) {
                    zzay().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                zzam zzam5 = this.zze;
                zzal(zzam5);
                zzam5.zzC();
            } finally {
                zzam zzam6 = this.zze;
                zzal(zzam6);
                zzam6.zzx();
            }
        }
    }

    public final void zzV(String str, zzai zzai) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzai);
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzai);
        zzam.zzg();
        zzam.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzai.zzh());
        try {
            if (zzam.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzam.zzt.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e10) {
            zzam.zzt.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e10);
        }
    }

    public final void zzW(zzkw zzkw, zzq zzq2) {
        long j10;
        int i10;
        int i11;
        zzkw zzkw2 = zzkw;
        zzq zzq3 = zzq2;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzkw2.zzb);
            if (zzl2 != 0) {
                zzlb zzv2 = zzv();
                String str = zzkw2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzkw2.zzb;
                if (str2 != null) {
                    i11 = str2.length();
                } else {
                    i11 = 0;
                }
                zzv().zzN(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, i11);
                return;
            }
            int zzd2 = zzv().zzd(zzkw2.zzb, zzkw.zza());
            if (zzd2 != 0) {
                zzlb zzv3 = zzv();
                String str3 = zzkw2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzkw.zza();
                if (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) {
                    i10 = 0;
                } else {
                    i10 = zza2.toString().length();
                }
                zzv().zzN(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, i10);
                return;
            }
            Object zzB2 = zzv().zzB(zzkw2.zzb, zzkw.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzkw2.zzb)) {
                    long j11 = zzkw2.zzc;
                    String str4 = zzkw2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    zzam zzam = this.zze;
                    zzal(zzam);
                    zzky zzp2 = zzam.zzp(str5, "_sno");
                    if (zzp2 != null) {
                        Object obj = zzp2.zze;
                        if (obj instanceof Long) {
                            j10 = ((Long) obj).longValue();
                            zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzq3);
                        }
                    }
                    if (zzp2 != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp2.zze);
                    }
                    zzam zzam2 = this.zze;
                    zzal(zzam2);
                    zzas zzn2 = zzam2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j10 = zzn2.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j10));
                    } else {
                        j10 = 0;
                    }
                    zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzq3);
                }
                zzky zzky = new zzky((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzkw2.zzf), zzkw2.zzb, zzkw2.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzky.zzc), zzB2);
                zzam zzam3 = this.zze;
                zzal(zzam3);
                zzam3.zzw();
                try {
                    if (bx.f13988d.equals(zzky.zzc)) {
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzky zzp3 = zzam4.zzp(zzq3.zza, bx.f13988d);
                        if (zzp3 != null && !zzky.zze.equals(zzp3.zze)) {
                            zzam zzam5 = this.zze;
                            zzal(zzam5);
                            zzam5.zzA(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    zzam zzam6 = this.zze;
                    zzal(zzam6);
                    boolean zzL = zzam6.zzL(zzky);
                    zzam zzam7 = this.zze;
                    zzal(zzam7);
                    zzam7.zzC();
                    if (!zzL) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzky.zzc), zzky.zze);
                        zzv().zzN(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzam zzam8 = this.zze;
                    zzal(zzam8);
                    zzam8.zzx();
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:212|213) */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0217, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0218, code lost:
        r8.zzt.zzay().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0272, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0562, code lost:
        if (r11 != null) goto L_0x053f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        if (r11 != null) goto L_0x0108;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:212:0x04e3 */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x029b A[SYNTHETIC, Splitter:B:143:0x029b] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02a4 A[Catch:{ all -> 0x012c, all -> 0x0587 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04fa A[Catch:{ all -> 0x012c, all -> 0x0587 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x056c A[Catch:{ all -> 0x012c, all -> 0x0587 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0583 A[SYNTHETIC, Splitter:B:252:0x0583] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0130 A[Catch:{ all -> 0x012c, all -> 0x0587 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:140:0x0282=Splitter:B:140:0x0282, B:203:0x0464=Splitter:B:203:0x0464, B:242:0x0566=Splitter:B:242:0x0566, B:55:0x0117=Splitter:B:55:0x0117, B:47:0x0108=Splitter:B:47:0x0108, B:58:0x0129=Splitter:B:58:0x0129, B:130:0x026f=Splitter:B:130:0x026f, B:226:0x053f=Splitter:B:226:0x053f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0587 }
            r0.zzaw()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzjm r0 = r0.zzt()     // Catch:{ all -> 0x0587 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0587 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0587 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0587 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0587 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0587 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0587 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x0587 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzag()     // Catch:{ all -> 0x0587 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()     // Catch:{ all -> 0x0587 }
            r0.zzg()     // Catch:{ all -> 0x0587 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0587 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0587 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0587 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzen r0 = r1.zzd     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0587 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0587 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0587 }
            r22.zzag()     // Catch:{ all -> 0x0587 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x0587 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzP     // Catch:{ all -> 0x0587 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0587 }
            r22.zzg()     // Catch:{ all -> 0x0587 }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0587 }
            long r10 = r4 - r10
            r8 = 0
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0587 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzjo r0 = r1.zzk     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc     // Catch:{ all -> 0x0587 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0587 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ all -> 0x0587 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0587 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0587 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0587 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0587 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0587 }
            r7 = -1
            if (r0 != 0) goto L_0x04fe
            long r10 = r1.zzA     // Catch:{ all -> 0x0587 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzam r10 = r1.zze     // Catch:{ all -> 0x0587 }
            zzal(r10)     // Catch:{ all -> 0x0587 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r0 != 0) goto L_0x010c
        L_0x0108:
            r11.close()     // Catch:{ all -> 0x0587 }
            goto L_0x0129
        L_0x010c:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0111 }
            goto L_0x0108
        L_0x0111:
            r0 = move-exception
            goto L_0x0117
        L_0x0113:
            r0 = move-exception
            goto L_0x012e
        L_0x0115:
            r0 = move-exception
            r11 = r9
        L_0x0117:
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzt     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ all -> 0x012c }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x012c }
            if (r11 == 0) goto L_0x0129
            goto L_0x0108
        L_0x0129:
            r1.zzA = r7     // Catch:{ all -> 0x0587 }
            goto L_0x0134
        L_0x012c:
            r0 = move-exception
            r9 = r11
        L_0x012e:
            if (r9 == 0) goto L_0x0133
            r9.close()     // Catch:{ all -> 0x0587 }
        L_0x0133:
            throw r0     // Catch:{ all -> 0x0587 }
        L_0x0134:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzf     // Catch:{ all -> 0x0587 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzg     // Catch:{ all -> 0x0587 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0587 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0587 }
            zzal(r8)     // Catch:{ all -> 0x0587 }
            r8.zzg()     // Catch:{ all -> 0x0587 }
            r8.zzW()     // Catch:{ all -> 0x0587 }
            if (r0 <= 0) goto L_0x015b
            r10 = 1
            goto L_0x015c
        L_0x015b:
            r10 = 0
        L_0x015c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0587 }
            if (r7 <= 0) goto L_0x0163
            r10 = 1
            goto L_0x0164
        L_0x0163:
            r10 = 0
        L_0x0164:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0587 }
            r10 = 2
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "rowid"
            r13[r3] = r12     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "data"
            r13[r2] = r12     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "retry_count"
            r13[r10] = r12     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String[] r15 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027e, all -> 0x027a }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0276 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0276 }
            r11.close()     // Catch:{ all -> 0x0587 }
            r20 = r4
            goto L_0x029e
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0276 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0276 }
            r13 = 0
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0276 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzkt r2 = r8.zzf     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzkv r2 = r2.zzi     // Catch:{ IOException -> 0x0248 }
            zzal(r2)     // Catch:{ IOException -> 0x0248 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0233 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0233 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0233 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0233 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0233 }
            r3.<init>()     // Catch:{ IOException -> 0x0233 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0233 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0231 }
            if (r4 > 0) goto L_0x022c
            r0.close()     // Catch:{ IOException -> 0x0231 }
            r9.close()     // Catch:{ IOException -> 0x0231 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0231 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0274 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0274 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026f
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzll r2 = com.google.android.gms.measurement.internal.zzkv.zzl(r2, r0)     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0217 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0274 }
            if (r4 != 0) goto L_0x0203
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x0274 }
        L_0x0203:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0274 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0274 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0274 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0274 }
            goto L_0x025e
        L_0x0217:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0274 }
            goto L_0x025e
        L_0x022c:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0231 }
            goto L_0x01cf
        L_0x0231:
            r0 = move-exception
            goto L_0x0236
        L_0x0233:
            r0 = move-exception
            r20 = r4
        L_0x0236:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ IOException -> 0x0246 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0246 }
            throw r0     // Catch:{ IOException -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024b
        L_0x0248:
            r0 = move-exception
            r20 = r4
        L_0x024b:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0274 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0274 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0274 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0274 }
        L_0x025e:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0274 }
            if (r0 == 0) goto L_0x026f
            if (r13 <= r7) goto L_0x0267
            goto L_0x026f
        L_0x0267:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            r10 = 2
            goto L_0x01ab
        L_0x026f:
            r11.close()     // Catch:{ all -> 0x0587 }
            r0 = r12
            goto L_0x029e
        L_0x0274:
            r0 = move-exception
            goto L_0x0282
        L_0x0276:
            r0 = move-exception
            r20 = r4
            goto L_0x0282
        L_0x027a:
            r0 = move-exception
            r9 = 0
            goto L_0x04f8
        L_0x027e:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0282:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ all -> 0x04f6 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x04f6 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x04f6 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x04f6 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x04f6 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04f6 }
            if (r11 == 0) goto L_0x029e
            r11.close()     // Catch:{ all -> 0x0587 }
        L_0x029e:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0587 }
            if (r2 != 0) goto L_0x057a
            com.google.android.gms.measurement.internal.zzai r2 = r1.zzh(r6)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0587 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x0587 }
            if (r2 == 0) goto L_0x0305
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0587 }
        L_0x02b4:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0587 }
            if (r3 == 0) goto L_0x02d3
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0587 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0587 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x0587 }
            java.lang.String r4 = r3.zzJ()     // Catch:{ all -> 0x0587 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0587 }
            if (r4 != 0) goto L_0x02b4
            java.lang.String r2 = r3.zzJ()     // Catch:{ all -> 0x0587 }
            goto L_0x02d4
        L_0x02d3:
            r2 = 0
        L_0x02d4:
            if (r2 == 0) goto L_0x0305
            r3 = 0
        L_0x02d7:
            int r4 = r0.size()     // Catch:{ all -> 0x0587 }
            if (r3 >= r4) goto L_0x0305
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0587 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0587 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x0587 }
            java.lang.String r5 = r4.zzJ()     // Catch:{ all -> 0x0587 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0587 }
            if (r5 == 0) goto L_0x02f2
            goto L_0x0302
        L_0x02f2:
            java.lang.String r4 = r4.zzJ()     // Catch:{ all -> 0x0587 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0587 }
            if (r4 != 0) goto L_0x0302
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0587 }
            goto L_0x0305
        L_0x0302:
            int r3 = r3 + 1
            goto L_0x02d7
        L_0x0305:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x0587 }
            int r3 = r0.size()     // Catch:{ all -> 0x0587 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0587 }
            int r5 = r0.size()     // Catch:{ all -> 0x0587 }
            r4.<init>(r5)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x0587 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0587 }
            if (r5 == 0) goto L_0x032e
            com.google.android.gms.measurement.internal.zzai r5 = r1.zzh(r6)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzah r7 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0587 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x0587 }
            if (r5 == 0) goto L_0x032e
            r5 = 1
            goto L_0x032f
        L_0x032e:
            r5 = 0
        L_0x032f:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r6)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0587 }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r6)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0587 }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x0587 }
            r11 = 0
            boolean r9 = r9.zzs(r11, r10)     // Catch:{ all -> 0x0587 }
            if (r9 == 0) goto L_0x0361
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x0587 }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x0587 }
            if (r9 == 0) goto L_0x0361
            r9 = 1
            goto L_0x0362
        L_0x0361:
            r9 = 0
        L_0x0362:
            r10 = 0
        L_0x0363:
            if (r10 >= r3) goto L_0x03e1
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0587 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0587 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzkb r11 = r11.zzby()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0587 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0587 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0587 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0587 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0587 }
            r4.add(r12)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x0587 }
            r12.zzh()     // Catch:{ all -> 0x0587 }
            r12 = 74029(0x1212d, double:3.6575E-319)
            r11.zzal(r12)     // Catch:{ all -> 0x0587 }
            r12 = r20
            r11.zzak(r12)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x0587 }
            r14.zzaw()     // Catch:{ all -> 0x0587 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x0587 }
            if (r5 != 0) goto L_0x03a2
            r11.zzq()     // Catch:{ all -> 0x0587 }
        L_0x03a2:
            if (r7 != 0) goto L_0x03aa
            r11.zzx()     // Catch:{ all -> 0x0587 }
            r11.zzt()     // Catch:{ all -> 0x0587 }
        L_0x03aa:
            if (r8 != 0) goto L_0x03af
            r11.zzn()     // Catch:{ all -> 0x0587 }
        L_0x03af:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x0587 }
            if (r9 != 0) goto L_0x03b7
            r11.zzy()     // Catch:{ all -> 0x0587 }
        L_0x03b7:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzdt r15 = com.google.android.gms.measurement.internal.zzdu.zzT     // Catch:{ all -> 0x0587 }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x0587 }
            if (r14 == 0) goto L_0x03d9
            com.google.android.gms.internal.measurement.zzkf r14 = r11.zzaC()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x0587 }
            byte[] r14 = r14.zzbu()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzkv r15 = r1.zzi     // Catch:{ all -> 0x0587 }
            zzal(r15)     // Catch:{ all -> 0x0587 }
            long r14 = r15.zzd(r14)     // Catch:{ all -> 0x0587 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0587 }
        L_0x03d9:
            r2.zza(r11)     // Catch:{ all -> 0x0587 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x0363
        L_0x03e1:
            r12 = r20
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x0587 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0587 }
            if (r0 == 0) goto L_0x0403
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzkf r5 = r2.zzaC()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x0587 }
            r11 = r0
            goto L_0x0404
        L_0x0403:
            r11 = 0
        L_0x0404:
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x0587 }
            byte[] r14 = r0.zzbu()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzki r0 = r1.zzl     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzkt r0 = r0.zzf     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzc     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = r0.zzi(r6)     // Catch:{ all -> 0x0587 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0587 }
            if (r5 != 0) goto L_0x045b
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x0587 }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x0587 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0587 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0587 }
            android.net.Uri$Builder r7 = r5.buildUpon()     // Catch:{ all -> 0x0587 }
            java.lang.String r5 = r5.getAuthority()     // Catch:{ all -> 0x0587 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0587 }
            r8.<init>()     // Catch:{ all -> 0x0587 }
            r8.append(r0)     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = "."
            r8.append(r0)     // Catch:{ all -> 0x0587 }
            r8.append(r5)     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0587 }
            r7.authority(r0)     // Catch:{ all -> 0x0587 }
            android.net.Uri r0 = r7.build()     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0587 }
            goto L_0x0464
        L_0x045b:
            com.google.android.gms.measurement.internal.zzdt r0 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x0587 }
            r5 = 0
            java.lang.Object r0 = r0.zza(r5)     // Catch:{ all -> 0x0587 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0587 }
        L_0x0464:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04e3 }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x04e3 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04e3 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04e3 }
            java.util.List r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x04e3 }
            if (r7 == 0) goto L_0x0484
            com.google.android.gms.measurement.internal.zzeh r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x04e3 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04e3 }
            goto L_0x048b
        L_0x0484:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04e3 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04e3 }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x04e3 }
        L_0x048b:
            com.google.android.gms.measurement.internal.zzjo r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04e3 }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x04e3 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x049f
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x04e3 }
            java.lang.String r4 = r2.zzx()     // Catch:{ MalformedURLException -> 0x04e3 }
        L_0x049f:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x04e3 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04e3 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04e3 }
            r2.zzd(r3, r4, r7, r11)     // Catch:{ MalformedURLException -> 0x04e3 }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzen r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x04e3 }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzkk r2 = new com.google.android.gms.measurement.internal.zzkk     // Catch:{ MalformedURLException -> 0x04e3 }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04e3 }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04e3 }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzt     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzfo r3 = r3.zzaz()     // Catch:{ MalformedURLException -> 0x04e3 }
            com.google.android.gms.measurement.internal.zzem r4 = new com.google.android.gms.measurement.internal.zzem     // Catch:{ MalformedURLException -> 0x04e3 }
            r15 = 0
            r10 = r4
            r12 = r6
            r13 = r5
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04e3 }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x04e3 }
            goto L_0x057a
        L_0x04e3:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0587 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0587 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0587 }
            goto L_0x057a
        L_0x04f6:
            r0 = move-exception
            r9 = r11
        L_0x04f8:
            if (r9 == 0) goto L_0x04fd
            r9.close()     // Catch:{ all -> 0x0587 }
        L_0x04fd:
            throw r0     // Catch:{ all -> 0x0587 }
        L_0x04fe:
            r12 = r4
            r5 = r9
            r1.zzA = r7     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0587 }
            zzal(r2)     // Catch:{ all -> 0x0587 }
            r22.zzg()     // Catch:{ all -> 0x0587 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x0587 }
            long r3 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x0587 }
            r2.zzW()     // Catch:{ all -> 0x0587 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x0551, all -> 0x054e }
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0551, all -> 0x054e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0551, all -> 0x054e }
            r4 = 0
            r6[r4] = r3     // Catch:{ SQLiteException -> 0x0551, all -> 0x054e }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x0551, all -> 0x054e }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x054c }
            if (r0 != 0) goto L_0x0543
            com.google.android.gms.measurement.internal.zzfr r0 = r2.zzt     // Catch:{ SQLiteException -> 0x054c }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x054c }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x054c }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x054c }
        L_0x053f:
            r11.close()     // Catch:{ all -> 0x0587 }
            goto L_0x0565
        L_0x0543:
            r3 = 0
            java.lang.String r9 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x054c }
            r11.close()     // Catch:{ all -> 0x0587 }
            goto L_0x0566
        L_0x054c:
            r0 = move-exception
            goto L_0x0553
        L_0x054e:
            r0 = move-exception
            r9 = r5
            goto L_0x0581
        L_0x0551:
            r0 = move-exception
            r11 = r5
        L_0x0553:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x057f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x057f }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x057f }
            if (r11 == 0) goto L_0x0565
            goto L_0x053f
        L_0x0565:
            r9 = r5
        L_0x0566:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0587 }
            if (r0 != 0) goto L_0x057a
            com.google.android.gms.measurement.internal.zzam r0 = r1.zze     // Catch:{ all -> 0x0587 }
            zzal(r0)     // Catch:{ all -> 0x0587 }
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzj(r9)     // Catch:{ all -> 0x0587 }
            if (r0 == 0) goto L_0x057a
            r1.zzD(r0)     // Catch:{ all -> 0x0587 }
        L_0x057a:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x057f:
            r0 = move-exception
            r9 = r11
        L_0x0581:
            if (r9 == 0) goto L_0x0586
            r9.close()     // Catch:{ all -> 0x0587 }
        L_0x0586:
            throw r0     // Catch:{ all -> 0x0587 }
        L_0x0587:
            r0 = move-exception
            r2 = 0
            r1.zzv = r2
            r22.zzae()
            goto L_0x0590
        L_0x058f:
            throw r0
        L_0x0590:
            goto L_0x058f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzX():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:225:0x072c, code lost:
        if (r14.isEmpty() != false) goto L_0x072e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0355 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0382  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04e5 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0525 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x059e A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05e9 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x05f6 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0603 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x063c A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x064d A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x068e A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x06a9 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0731 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0777 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x07bf A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x07d9 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0865 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0884 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0917 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x09c3 A[Catch:{ SQLiteException -> 0x09de }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x09d9  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0924 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016b A[SYNTHETIC, Splitter:B:45:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d2 A[SYNTHETIC, Splitter:B:61:0x01d2] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e2 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02ac A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02ef A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02f2 A[Catch:{ NumberFormatException -> 0x0716, all -> 0x0a5a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzaw r37, com.google.android.gms.measurement.internal.zzq r38) {
        /*
            r36 = this;
            r1 = r36
            r2 = r37
            r3 = r38
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r38)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfo r10 = r36.zzaz()
            r10.zzg()
            r36.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzkv.zzA(r37, r38)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0a65
            com.google.android.gms.measurement.internal.zzfi r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeh r3 = r36.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF
            r14 = 11
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r36.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r36.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeh r3 = r36.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzei r2 = com.google.android.gms.measurement.internal.zzei.zzb(r37)
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r36.zzg()
            int r12 = r12.zzd(r10)
            r11.zzM(r2, r12)
            com.google.android.gms.measurement.internal.zzaw r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeh r11 = r36.zzay()
            java.lang.String r11 = r11.zzq()
            r12 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r12)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzeh r11 = r36.zzay()
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r13 = r13.zzj()
            java.lang.String r13 = r13.zzc(r2)
            java.lang.String r14 = "Logging event"
            r11.zzb(r14, r13)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze
            zzal(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x014a
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a5a }
            if (r9 != 0) goto L_0x014a
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r9 = 0
            goto L_0x014b
        L_0x014a:
            r9 = 1
        L_0x014b:
            java.lang.String r11 = "_iap"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r11 = r11.equals(r14)     // Catch:{ all -> 0x0a5a }
            if (r11 != 0) goto L_0x015f
            if (r9 == 0) goto L_0x0159
            r9 = 1
            goto L_0x015f
        L_0x0159:
            r31 = r4
            r4 = r15
            r9 = 0
            goto L_0x02dc
        L_0x015f:
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.String r14 = "currency"
            java.lang.String r11 = r11.zzg(r14)     // Catch:{ all -> 0x0a5a }
            java.lang.String r14 = "value"
            if (r9 == 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.Double r9 = r9.zzd(r14)     // Catch:{ all -> 0x0a5a }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a5a }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x0192
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.Long r9 = r9.zze(r14)     // Catch:{ all -> 0x0a5a }
            long r8 = r9.longValue()     // Catch:{ all -> 0x0a5a }
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r17 = r8 * r19
        L_0x0192:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r14 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r14 > 0) goto L_0x01ac
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r14 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r14 < 0) goto L_0x01ac
            long r8 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a5a }
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0a5a }
            if (r13 == 0) goto L_0x01dc
            long r8 = -r8
            goto L_0x01dc
        L_0x01ac:
            com.google.android.gms.measurement.internal.zzeh r2 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0a5a }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a5a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            r2.zzC()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzau r8 = r2.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.Long r8 = r8.zze(r14)     // Catch:{ all -> 0x0a5a }
            long r8 = r8.longValue()     // Catch:{ all -> 0x0a5a }
        L_0x01dc:
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a5a }
            if (r13 != 0) goto L_0x0159
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = r11.toUpperCase(r13)     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = "[A-Z]{3}"
            boolean r13 = r11.matches(r13)     // Catch:{ all -> 0x0a5a }
            if (r13 == 0) goto L_0x0159
            java.lang.String r13 = "_ltv_"
            java.lang.String r14 = r13.concat(r11)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r11)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r11 = r11.zzp(r10, r14)     // Catch:{ all -> 0x0a5a }
            if (r11 == 0) goto L_0x0230
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a5a }
            boolean r13 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a5a }
            if (r13 != 0) goto L_0x0208
            goto L_0x0230
        L_0x0208:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a5a }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r18 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.util.Clock r17 = r36.zzav()     // Catch:{ all -> 0x0a5a }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0a5a }
            long r11 = r11 + r8
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a5a }
            r11 = r18
            r12 = r10
            r8 = 0
            r9 = 0
            r31 = r4
            r4 = r15
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a5a }
        L_0x022c:
            r8 = r18
            goto L_0x02a1
        L_0x0230:
            r31 = r4
            r4 = r15
            r13 = 0
            r15 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r11)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r13 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzD     // Catch:{ all -> 0x0a5a }
            int r12 = r13.zze(r10, r12)     // Catch:{ all -> 0x0a5a }
            int r12 = r12 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a5a }
            r11.zzg()     // Catch:{ all -> 0x0a5a }
            r11.zzW()     // Catch:{ all -> 0x0a5a }
            android.database.sqlite.SQLiteDatabase r13 = r11.zzh()     // Catch:{ SQLiteException -> 0x026e }
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x026e }
            r17 = 0
            r15[r17] = r10     // Catch:{ SQLiteException -> 0x026c }
            r18 = 1
            r15[r18] = r10     // Catch:{ SQLiteException -> 0x026c }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteException -> 0x026c }
            r18 = 2
            r15[r18] = r12     // Catch:{ SQLiteException -> 0x026c }
            java.lang.String r12 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r13.execSQL(r12, r15)     // Catch:{ SQLiteException -> 0x026c }
            goto L_0x0285
        L_0x026c:
            r0 = move-exception
            goto L_0x0271
        L_0x026e:
            r0 = move-exception
            r17 = 0
        L_0x0271:
            r12 = r0
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzt     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            r11.zzc(r13, r15, r12)     // Catch:{ all -> 0x0a5a }
        L_0x0285:
            com.google.android.gms.measurement.internal.zzky r18 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.util.Clock r11 = r36.zzav()     // Catch:{ all -> 0x0a5a }
            long r19 = r11.currentTimeMillis()     // Catch:{ all -> 0x0a5a }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a5a }
            r11 = r18
            r12 = r10
            r9 = 0
            r15 = r19
            r17 = r8
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a5a }
            goto L_0x022c
        L_0x02a1:
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r11)     // Catch:{ all -> 0x0a5a }
            boolean r11 = r11.zzL(r8)     // Catch:{ all -> 0x0a5a }
            if (r11 != 0) goto L_0x02dc
            com.google.android.gms.measurement.internal.zzeh r11 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzec r14 = r14.zzj()     // Catch:{ all -> 0x0a5a }
            java.lang.String r15 = r8.zzc     // Catch:{ all -> 0x0a5a }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0a5a }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a5a }
            r11.zzd(r12, r13, r14, r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a5a }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a5a }
        L_0x02dc:
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r8 = com.google.android.gms.measurement.internal.zzlb.zzai(r8)     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r4 = r4.equals(r11)     // Catch:{ all -> 0x0a5a }
            r36.zzv()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x0a5a }
            if (r11 != 0) goto L_0x02f2
            r16 = 0
            goto L_0x0312
        L_0x02f2:
            com.google.android.gms.measurement.internal.zzat r12 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a5a }
            r12.<init>(r11)     // Catch:{ all -> 0x0a5a }
            r16 = 0
        L_0x02f9:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a5a }
            if (r13 == 0) goto L_0x0312
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0a5a }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a5a }
            if (r14 == 0) goto L_0x02f9
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a5a }
            int r13 = r13.length     // Catch:{ all -> 0x0a5a }
            long r13 = (long) r13     // Catch:{ all -> 0x0a5a }
            long r16 = r16 + r13
            goto L_0x02f9
        L_0x0312:
            r22 = 1
            long r16 = r16 + r22
            com.google.android.gms.measurement.internal.zzam r11 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r11)     // Catch:{ all -> 0x0a5a }
            long r12 = r36.zza()     // Catch:{ all -> 0x0a5a }
            r20 = 1
            r21 = 0
            r24 = 0
            r33 = r5
            r34 = r6
            r5 = 0
            r14 = r10
            r15 = r16
            r17 = r20
            r18 = r8
            r19 = r21
            r20 = r4
            r21 = r24
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a5a }
            long r12 = r11.zzb     // Catch:{ all -> 0x0a5a }
            r36.zzg()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzj     // Catch:{ all -> 0x0a5a }
            java.lang.Object r14 = r14.zza(r9)     // Catch:{ all -> 0x0a5a }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a5a }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a5a }
            long r14 = (long) r14     // Catch:{ all -> 0x0a5a }
            long r12 = r12 - r14
            r14 = 1000(0x3e8, double:4.94E-321)
            int r16 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r16 <= 0) goto L_0x0382
            long r12 = r12 % r14
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0371
            com.google.android.gms.measurement.internal.zzeh r2 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            long r5 = r11.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a5a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a5a }
        L_0x0371:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            r2.zzC()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0382:
            if (r8 == 0) goto L_0x03de
            long r12 = r11.zza     // Catch:{ all -> 0x0a5a }
            r36.zzg()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzl     // Catch:{ all -> 0x0a5a }
            java.lang.Object r14 = r14.zza(r9)     // Catch:{ all -> 0x0a5a }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a5a }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a5a }
            long r14 = (long) r14     // Catch:{ all -> 0x0a5a }
            long r12 = r12 - r14
            int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x03de
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r14
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03b9
            com.google.android.gms.measurement.internal.zzeh r3 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            long r6 = r11.zza     // Catch:{ all -> 0x0a5a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a5a }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0a5a }
        L_0x03b9:
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a5a }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0a5a }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            r2.zzC()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x03de:
            r12 = 1000000(0xf4240, float:1.401298E-39)
            if (r4 == 0) goto L_0x042e
            long r13 = r11.zzd     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r4 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            java.lang.String r15 = r3.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzk     // Catch:{ all -> 0x0a5a }
            int r4 = r4.zze(r15, r9)     // Catch:{ all -> 0x0a5a }
            int r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0a5a }
            r9 = 0
            int r4 = java.lang.Math.max(r9, r4)     // Catch:{ all -> 0x0a5a }
            r21 = r10
            long r9 = (long) r4     // Catch:{ all -> 0x0a5a }
            long r13 = r13 - r9
            int r4 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0430
            int r2 = (r13 > r22 ? 1 : (r13 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x041d
            com.google.android.gms.measurement.internal.zzeh r2 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r21)     // Catch:{ all -> 0x0a5a }
            long r5 = r11.zzd     // Catch:{ all -> 0x0a5a }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a5a }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a5a }
        L_0x041d:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            r2.zzC()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x042e:
            r21 = r10
        L_0x0430:
            com.google.android.gms.measurement.internal.zzau r4 = r2.zzb     // Catch:{ all -> 0x0a5a }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzlb r9 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = "_o"
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x0a5a }
            r9.zzO(r4, r10, r11)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzlb r9 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            r10 = r21
            boolean r9 = r9.zzae(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.String r15 = "_r"
            if (r9 == 0) goto L_0x0463
            com.google.android.gms.measurement.internal.zzlb r9 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = "_dbg"
            r9.zzO(r4, r13, r11)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzlb r9 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            r9.zzO(r4, r15, r11)     // Catch:{ all -> 0x0a5a }
        L_0x0463:
            java.lang.String r9 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a5a }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0489
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r9)     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r9 = r9.zzp(r11, r7)     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0489
            java.lang.Object r11 = r9.zze     // Catch:{ all -> 0x0a5a }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a5a }
            if (r11 == 0) goto L_0x0489
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a5a }
            r11.zzO(r4, r7, r9)     // Catch:{ all -> 0x0a5a }
        L_0x0489:
            com.google.android.gms.measurement.internal.zzam r7 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r7)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a5a }
            r7.zzg()     // Catch:{ all -> 0x0a5a }
            r7.zzW()     // Catch:{ all -> 0x0a5a }
            android.database.sqlite.SQLiteDatabase r9 = r7.zzh()     // Catch:{ SQLiteException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzfr r11 = r7.zzt     // Catch:{ SQLiteException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzag r11 = r11.zzf()     // Catch:{ SQLiteException -> 0x04c8 }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzo     // Catch:{ SQLiteException -> 0x04c8 }
            int r11 = r11.zze(r10, r13)     // Catch:{ SQLiteException -> 0x04c8 }
            int r11 = java.lang.Math.min(r12, r11)     // Catch:{ SQLiteException -> 0x04c8 }
            r14 = 0
            int r11 = java.lang.Math.max(r14, r11)     // Catch:{ SQLiteException -> 0x04c4 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x04c4 }
            java.lang.String[] r11 = new java.lang.String[]{r10, r11}     // Catch:{ SQLiteException -> 0x04c4 }
            java.lang.String r12 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r13 = r34
            int r7 = r9.delete(r13, r12, r11)     // Catch:{ SQLiteException -> 0x04c2 }
            long r11 = (long) r7
            goto L_0x04e1
        L_0x04c2:
            r0 = move-exception
            goto L_0x04cc
        L_0x04c4:
            r0 = move-exception
            r13 = r34
            goto L_0x04cc
        L_0x04c8:
            r0 = move-exception
            r13 = r34
            r14 = 0
        L_0x04cc:
            r9 = r0
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = "Error deleting over the limit events. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            r7.zzc(r11, r12, r9)     // Catch:{ all -> 0x0a5a }
            r11 = r5
        L_0x04e1:
            int r7 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x04fa
            com.google.android.gms.measurement.internal.zzeh r7 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()     // Catch:{ all -> 0x0a5a }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a5a }
            r7.zzc(r9, r14, r11)     // Catch:{ all -> 0x0a5a }
        L_0x04fa:
            com.google.android.gms.measurement.internal.zzar r7 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0a5a }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x0a5a }
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0a5a }
            long r5 = r2.zzd     // Catch:{ all -> 0x0a5a }
            r18 = 0
            r11 = r7
            r2 = r13
            r13 = r9
            r9 = r14
            r32 = 0
            r14 = r10
            r35 = r2
            r2 = r15
            r15 = r9
            r16 = r5
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.zzfr) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r4)     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzn(r10, r5)     // Catch:{ all -> 0x0a5a }
            if (r4 != 0) goto L_0x059e
            com.google.android.gms.measurement.internal.zzam r4 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r4)     // Catch:{ all -> 0x0a5a }
            long r4 = r4.zzf(r10)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r6 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a5a }
            long r11 = (long) r6     // Catch:{ all -> 0x0a5a }
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 < 0) goto L_0x0580
            if (r8 == 0) goto L_0x0580
            com.google.android.gms.measurement.internal.zzeh r2 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = r5.zzd(r6)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r6 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a5a }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzlb r11 = r36.zzv()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzla r12 = r1.zzF     // Catch:{ all -> 0x0a5a }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            return
        L_0x0580:
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x0a5a }
            java.lang.String r13 = r7.zzb     // Catch:{ all -> 0x0a5a }
            long r5 = r7.zzd     // Catch:{ all -> 0x0a5a }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a5a }
            goto L_0x05ac
        L_0x059e:
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn     // Catch:{ all -> 0x0a5a }
            long r8 = r4.zzf     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zza(r5, r8)     // Catch:{ all -> 0x0a5a }
            long r5 = r7.zzd     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzc(r5)     // Catch:{ all -> 0x0a5a }
        L_0x05ac:
            com.google.android.gms.measurement.internal.zzam r5 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r5)     // Catch:{ all -> 0x0a5a }
            r5.zzE(r4)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfo r4 = r36.zzaz()     // Catch:{ all -> 0x0a5a }
            r4.zzg()     // Catch:{ all -> 0x0a5a }
            r36.zzB()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r38)     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x0a5a }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.internal.measurement.zzgc r4 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ all -> 0x0a5a }
            r5 = 1
            r4.zzad(r5)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = "android"
            r4.zzZ(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x05ee
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a5a }
            r4.zzD(r6)     // Catch:{ all -> 0x0a5a }
        L_0x05ee:
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x05fb
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x0a5a }
            r4.zzF(r6)     // Catch:{ all -> 0x0a5a }
        L_0x05fb:
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x0608
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x0a5a }
            r4.zzG(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0608:
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r6 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x0a5a }
            r9 = 0
            boolean r6 = r6.zzs(r9, r8)     // Catch:{ all -> 0x0a5a }
            if (r6 == 0) goto L_0x0633
            com.google.android.gms.measurement.internal.zzag r6 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x0a5a }
            boolean r6 = r6.zzs(r8, r9)     // Catch:{ all -> 0x0a5a }
            if (r6 == 0) goto L_0x0633
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x0633
            java.lang.String r6 = r3.zzx     // Catch:{ all -> 0x0a5a }
            r4.zzah(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0633:
            long r8 = r3.zzj     // Catch:{ all -> 0x0a5a }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0640
            int r6 = (int) r8     // Catch:{ all -> 0x0a5a }
            r4.zzH(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0640:
            long r8 = r3.zze     // Catch:{ all -> 0x0a5a }
            r4.zzV(r8)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x0652
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x0a5a }
            r4.zzU(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0652:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a5a }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r6 = r1.zzh(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r8 = com.google.android.gms.measurement.internal.zzai.zzb(r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzc(r8)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r6.zzh()     // Catch:{ all -> 0x0a5a }
            r4.zzL(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r4.zzaq()     // Catch:{ all -> 0x0a5a }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0a5a }
            if (r6 == 0) goto L_0x0686
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x0686
            java.lang.String r6 = r3.zzq     // Catch:{ all -> 0x0a5a }
            r4.zzC(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0686:
            long r8 = r3.zzf     // Catch:{ all -> 0x0a5a }
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0691
            r4.zzM(r8)     // Catch:{ all -> 0x0a5a }
        L_0x0691:
            long r8 = r3.zzs     // Catch:{ all -> 0x0a5a }
            r4.zzP(r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzkv r6 = r1.zzi     // Catch:{ all -> 0x0a5a }
            zzal(r6)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzkt r8 = r6.zzf     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzn     // Catch:{ all -> 0x0a5a }
            android.content.Context r8 = r8.zzau()     // Catch:{ all -> 0x0a5a }
            java.util.Map r8 = com.google.android.gms.measurement.internal.zzdu.zzc(r8)     // Catch:{ all -> 0x0a5a }
            if (r8 == 0) goto L_0x072e
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x06b1
            goto L_0x072e
        L_0x06b1:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a5a }
            r14.<init>()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzO     // Catch:{ all -> 0x0a5a }
            r10 = 0
            java.lang.Object r9 = r9.zza(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0a5a }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0a5a }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0a5a }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0a5a }
        L_0x06cb:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x0a5a }
            if (r10 == 0) goto L_0x0728
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x0a5a }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0a5a }
            java.lang.Object r11 = r10.getKey()     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0a5a }
            java.lang.String r12 = "measurement.id."
            boolean r11 = r11.startsWith(r12)     // Catch:{ all -> 0x0a5a }
            if (r11 == 0) goto L_0x06cb
            java.lang.Object r10 = r10.getValue()     // Catch:{ NumberFormatException -> 0x0716 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0716 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x0716 }
            if (r10 == 0) goto L_0x06cb
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x0716 }
            r14.add(r10)     // Catch:{ NumberFormatException -> 0x0716 }
            int r10 = r14.size()     // Catch:{ NumberFormatException -> 0x0716 }
            if (r10 < r9) goto L_0x06cb
            com.google.android.gms.measurement.internal.zzfr r10 = r6.zzt     // Catch:{ NumberFormatException -> 0x0716 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ NumberFormatException -> 0x0716 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ NumberFormatException -> 0x0716 }
            java.lang.String r11 = "Too many experiment IDs. Number of IDs"
            int r12 = r14.size()     // Catch:{ NumberFormatException -> 0x0716 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x0716 }
            r10.zzb(r11, r12)     // Catch:{ NumberFormatException -> 0x0716 }
            goto L_0x0728
        L_0x0716:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.zzfr r11 = r6.zzt     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzk()     // Catch:{ all -> 0x0a5a }
            java.lang.String r12 = "Experiment ID NumberFormatException"
            r11.zzb(r12, r10)     // Catch:{ all -> 0x0a5a }
            goto L_0x06cb
        L_0x0728:
            boolean r6 = r14.isEmpty()     // Catch:{ all -> 0x0a5a }
            if (r6 == 0) goto L_0x072f
        L_0x072e:
            r14 = 0
        L_0x072f:
            if (r14 == 0) goto L_0x0734
            r4.zzh(r14)     // Catch:{ all -> 0x0a5a }
        L_0x0734:
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a5a }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r6 = r1.zzh(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r3.zzv     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r8 = com.google.android.gms.measurement.internal.zzai.zzb(r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzc(r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x0a5a }
            boolean r9 = r6.zzi(r8)     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0780
            boolean r9 = r3.zzo     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0780
            com.google.android.gms.measurement.internal.zzjo r9 = r1.zzk     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a5a }
            android.util.Pair r9 = r9.zzd(r10, r6)     // Catch:{ all -> 0x0a5a }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a5a }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a5a }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a5a }
            if (r10 != 0) goto L_0x0780
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a5a }
            if (r10 == 0) goto L_0x0780
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a5a }
            r4.zzae(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x0780
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a5a }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a5a }
            r4.zzX(r9)     // Catch:{ all -> 0x0a5a }
        L_0x0780:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a5a }
            r9.zzu()     // Catch:{ all -> 0x0a5a }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0a5a }
            r4.zzN(r9)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a5a }
            r9.zzu()     // Catch:{ all -> 0x0a5a }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a5a }
            r4.zzY(r9)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a5a }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0a5a }
            int r10 = (int) r9     // Catch:{ all -> 0x0a5a }
            r4.zzaj(r10)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzg()     // Catch:{ all -> 0x0a5a }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0a5a }
            r4.zzan(r9)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a5a }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0a5a }
            if (r9 == 0) goto L_0x07cc
            r4.zzap()     // Catch:{ all -> 0x0a5a }
            r9 = 0
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a5a }
            if (r10 != 0) goto L_0x07cc
            r4.zzO(r9)     // Catch:{ all -> 0x0a5a }
        L_0x07cc:
            com.google.android.gms.measurement.internal.zzam r9 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r9)     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzj(r10)     // Catch:{ all -> 0x0a5a }
            if (r9 != 0) goto L_0x083c
            com.google.android.gms.measurement.internal.zzh r9 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x0a5a }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a5a }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r1.zzw(r6)     // Catch:{ all -> 0x0a5a }
            r9.zzH(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a5a }
            r9.zzV(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a5a }
            r9.zzW(r10)     // Catch:{ all -> 0x0a5a }
            boolean r8 = r6.zzi(r8)     // Catch:{ all -> 0x0a5a }
            if (r8 == 0) goto L_0x0806
            com.google.android.gms.measurement.internal.zzjo r8 = r1.zzk     // Catch:{ all -> 0x0a5a }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a5a }
            boolean r11 = r3.zzo     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r8.zzf(r10, r11)     // Catch:{ all -> 0x0a5a }
            r9.zzae(r8)     // Catch:{ all -> 0x0a5a }
        L_0x0806:
            r10 = 0
            r9.zzaa(r10)     // Catch:{ all -> 0x0a5a }
            r9.zzab(r10)     // Catch:{ all -> 0x0a5a }
            r9.zzZ(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a5a }
            r9.zzJ(r8)     // Catch:{ all -> 0x0a5a }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a5a }
            r9.zzK(r10)     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a5a }
            r9.zzI(r8)     // Catch:{ all -> 0x0a5a }
            long r10 = r3.zze     // Catch:{ all -> 0x0a5a }
            r9.zzX(r10)     // Catch:{ all -> 0x0a5a }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a5a }
            r9.zzS(r10)     // Catch:{ all -> 0x0a5a }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x0a5a }
            r9.zzac(r8)     // Catch:{ all -> 0x0a5a }
            long r10 = r3.zzs     // Catch:{ all -> 0x0a5a }
            r9.zzT(r10)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r8 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r8)     // Catch:{ all -> 0x0a5a }
            r8.zzD(r9)     // Catch:{ all -> 0x0a5a }
        L_0x083c:
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a5a }
            boolean r6 = r6.zzi(r8)     // Catch:{ all -> 0x0a5a }
            if (r6 == 0) goto L_0x085b
            java.lang.String r6 = r9.zzu()     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x085b
            java.lang.String r6 = r9.zzu()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0a5a }
            r4.zzE(r6)     // Catch:{ all -> 0x0a5a }
        L_0x085b:
            java.lang.String r6 = r9.zzx()     // Catch:{ all -> 0x0a5a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a5a }
            if (r6 != 0) goto L_0x0872
            java.lang.String r6 = r9.zzx()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0a5a }
            r4.zzT(r6)     // Catch:{ all -> 0x0a5a }
        L_0x0872:
            com.google.android.gms.measurement.internal.zzam r6 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a5a }
            java.util.List r3 = r6.zzu(r3)     // Catch:{ all -> 0x0a5a }
            r14 = 0
        L_0x087e:
            int r6 = r3.size()     // Catch:{ all -> 0x0a5a }
            if (r14 >= r6) goto L_0x08b4
            com.google.android.gms.internal.measurement.zzgl r6 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r8 = r3.get(r14)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r8 = (com.google.android.gms.measurement.internal.zzky) r8     // Catch:{ all -> 0x0a5a }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x0a5a }
            r6.zzf(r8)     // Catch:{ all -> 0x0a5a }
            java.lang.Object r8 = r3.get(r14)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r8 = (com.google.android.gms.measurement.internal.zzky) r8     // Catch:{ all -> 0x0a5a }
            long r8 = r8.zzd     // Catch:{ all -> 0x0a5a }
            r6.zzg(r8)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x0a5a }
            zzal(r8)     // Catch:{ all -> 0x0a5a }
            java.lang.Object r9 = r3.get(r14)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzky r9 = (com.google.android.gms.measurement.internal.zzky) r9     // Catch:{ all -> 0x0a5a }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a5a }
            r8.zzu(r6, r9)     // Catch:{ all -> 0x0a5a }
            r4.zzl(r6)     // Catch:{ all -> 0x0a5a }
            int r14 = r14 + 1
            goto L_0x087e
        L_0x08b4:
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ IOException -> 0x0a10 }
            zzal(r3)     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.internal.measurement.zzkf r6 = r4.zzaC()     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.internal.measurement.zzgd r6 = (com.google.android.gms.internal.measurement.zzgd) r6     // Catch:{ IOException -> 0x0a10 }
            r3.zzg()     // Catch:{ IOException -> 0x0a10 }
            r3.zzW()     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ IOException -> 0x0a10 }
            java.lang.String r8 = r6.zzx()     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ IOException -> 0x0a10 }
            byte[] r8 = r6.zzbu()     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.measurement.internal.zzkt r9 = r3.zzf     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.measurement.internal.zzkv r9 = r9.zzi     // Catch:{ IOException -> 0x0a10 }
            zzal(r9)     // Catch:{ IOException -> 0x0a10 }
            long r9 = r9.zzd(r8)     // Catch:{ IOException -> 0x0a10 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a10 }
            r11.<init>()     // Catch:{ IOException -> 0x0a10 }
            java.lang.String r12 = r6.zzx()     // Catch:{ IOException -> 0x0a10 }
            r13 = r33
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0a10 }
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x0a10 }
            r14 = r31
            r11.put(r14, r12)     // Catch:{ IOException -> 0x0a10 }
            java.lang.String r12 = "metadata"
            r11.put(r12, r8)     // Catch:{ IOException -> 0x0a10 }
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x09f6 }
            java.lang.String r12 = "raw_events_metadata"
            r15 = 4
            r5 = 0
            r8.insertWithOnConflict(r12, r5, r11, r15)     // Catch:{ SQLiteException -> 0x09f6 }
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r3)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzau r4 = r7.zzf     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzat r5 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x0a5a }
            r5.<init>(r4)     // Catch:{ all -> 0x0a5a }
        L_0x0911:
            boolean r4 = r5.hasNext()     // Catch:{ all -> 0x0a5a }
            if (r4 == 0) goto L_0x0924
            java.lang.String r4 = r5.next()     // Catch:{ all -> 0x0a5a }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0a5a }
            if (r4 == 0) goto L_0x0911
        L_0x0921:
            r30 = 1
            goto L_0x0964
        L_0x0924:
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = r7.zzb     // Catch:{ all -> 0x0a5a }
            boolean r2 = r2.zzq(r4, r5)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r15 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r15)     // Catch:{ all -> 0x0a5a }
            long r16 = r36.zza()     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = r7.zza     // Catch:{ all -> 0x0a5a }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r4
            com.google.android.gms.measurement.internal.zzak r4 = r15.zzl(r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0a5a }
            if (r2 == 0) goto L_0x0962
            long r4 = r4.zze     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzag r2 = r36.zzg()     // Catch:{ all -> 0x0a5a }
            java.lang.String r6 = r7.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0a5a }
            int r2 = r2.zze(r6, r8)     // Catch:{ all -> 0x0a5a }
            long r11 = (long) r2     // Catch:{ all -> 0x0a5a }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0962
            goto L_0x0921
        L_0x0962:
            r30 = 0
        L_0x0964:
            r3.zzg()     // Catch:{ all -> 0x0a5a }
            r3.zzW()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5a }
            java.lang.String r2 = r7.zza     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzkt r2 = r3.zzf     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzkv r2 = r2.zzi     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.internal.measurement.zzft r2 = r2.zzj(r7)     // Catch:{ all -> 0x0a5a }
            byte[] r2 = r2.zzbu()     // Catch:{ all -> 0x0a5a }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0a5a }
            r4.<init>()     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0a5a }
            r4.put(r13, r5)     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = "name"
            java.lang.String r6 = r7.zzb     // Catch:{ all -> 0x0a5a }
            r4.put(r5, r6)     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = "timestamp"
            long r11 = r7.zzd     // Catch:{ all -> 0x0a5a }
            java.lang.Long r6 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a5a }
            r4.put(r5, r6)     // Catch:{ all -> 0x0a5a }
            java.lang.Long r5 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0a5a }
            r4.put(r14, r5)     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = "data"
            r4.put(r5, r2)     // Catch:{ all -> 0x0a5a }
            java.lang.String r2 = "realtime"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x0a5a }
            r4.put(r2, r5)     // Catch:{ all -> 0x0a5a }
            android.database.sqlite.SQLiteDatabase r2 = r3.zzh()     // Catch:{ SQLiteException -> 0x09de }
            r5 = r35
            r6 = 0
            long r4 = r2.insert(r5, r6, r4)     // Catch:{ SQLiteException -> 0x09de }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x09d9
            com.google.android.gms.measurement.internal.zzfr r2 = r3.zzt     // Catch:{ SQLiteException -> 0x09de }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x09de }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x09de }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.zza     // Catch:{ SQLiteException -> 0x09de }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ SQLiteException -> 0x09de }
            r2.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x09de }
            goto L_0x0a27
        L_0x09d9:
            r4 = 0
            r1.zza = r4     // Catch:{ all -> 0x0a5a }
            goto L_0x0a27
        L_0x09de:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.zza     // Catch:{ all -> 0x0a5a }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x0a5a }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0a5a }
            goto L_0x0a27
        L_0x09f6:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ IOException -> 0x0a10 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ IOException -> 0x0a10 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r6.zzx()     // Catch:{ IOException -> 0x0a10 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ IOException -> 0x0a10 }
            r3.zzc(r5, r6, r2)     // Catch:{ IOException -> 0x0a10 }
            throw r2     // Catch:{ IOException -> 0x0a10 }
        L_0x0a10:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzeh r3 = r36.zzay()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0a5a }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r4.zzap()     // Catch:{ all -> 0x0a5a }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x0a5a }
            r3.zzc(r5, r4, r2)     // Catch:{ all -> 0x0a5a }
        L_0x0a27:
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze     // Catch:{ all -> 0x0a5a }
            zzal(r2)     // Catch:{ all -> 0x0a5a }
            r2.zzC()     // Catch:{ all -> 0x0a5a }
            com.google.android.gms.measurement.internal.zzam r2 = r1.zze
            zzal(r2)
            r2.zzx()
            r36.zzag()
            com.google.android.gms.measurement.internal.zzeh r2 = r36.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0a5a:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzam r3 = r1.zze
            zzal(r3)
            r3.zzx()
            throw r2
        L_0x0a65:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzY(com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzq):void");
    }

    @VisibleForTesting
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzt.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e10) {
                zzay().zzd().zzb("Failed to acquire storage lock", e10);
                return false;
            } catch (IOException e11) {
                zzay().zzd().zzb("Failed to access storage lock file", e11);
                return false;
            } catch (OverlappingFileLockException e12) {
                zzay().zzk().zzb("Storage lock already acquired", e12);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjo zzjo = this.zzk;
        zzjo.zzW();
        zzjo.zzg();
        long zza2 = zzjo.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjo.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzjo.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzab zzaw() {
        throw null;
    }

    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    public final zzh zzd(zzq zzq2) {
        String str;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        if (!zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new zzks(this, zzq2.zzw));
        }
        zzam zzam = this.zze;
        zzal(zzam);
        zzh zzj2 = zzam.zzj(zzq2.zza);
        zzai zzc2 = zzh(zzq2.zza).zzc(zzai.zzb(zzq2.zzv));
        zzah zzah = zzah.AD_STORAGE;
        if (zzc2.zzi(zzah)) {
            str = this.zzk.zzf(zzq2.zza, zzq2.zzo);
        } else {
            str = "";
        }
        if (zzj2 == null) {
            zzj2 = new zzh(this.zzn, zzq2.zza);
            if (zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
                zzj2.zzH(zzw(zzc2));
            }
            if (zzc2.zzi(zzah)) {
                zzj2.zzae(str);
            }
        } else if (zzc2.zzi(zzah) && str != null && !str.equals(zzj2.zzA())) {
            zzj2.zzae(str);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzc2).first)) {
                zzj2.zzH(zzw(zzc2));
                zzam zzam2 = this.zze;
                zzal(zzam2);
                if (zzam2.zzp(zzq2.zza, bx.f13988d) != null) {
                    zzam zzam3 = this.zze;
                    zzal(zzam3);
                    if (zzam3.zzp(zzq2.zza, "_lair") == null) {
                        zzky zzky = new zzky(zzq2.zza, ConnType.PK_AUTO, "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzam4 = this.zze;
                        zzal(zzam4);
                        zzam4.zzL(zzky);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
            zzj2.zzH(zzw(zzc2));
        }
        zzj2.zzW(zzq2.zzb);
        zzj2.zzF(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            zzj2.zzV(zzq2.zzk);
        }
        long j10 = zzq2.zze;
        if (j10 != 0) {
            zzj2.zzX(j10);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            zzj2.zzJ(zzq2.zzc);
        }
        zzj2.zzK(zzq2.zzj);
        String str2 = zzq2.zzd;
        if (str2 != null) {
            zzj2.zzI(str2);
        }
        zzj2.zzS(zzq2.zzf);
        zzj2.zzac(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            zzj2.zzY(zzq2.zzg);
        }
        zzj2.zzG(zzq2.zzo);
        zzj2.zzad(zzq2.zzr);
        zzj2.zzT(zzq2.zzs);
        zzpd.zzc();
        if (zzg().zzs((String) null, zzdu.zzal) && zzg().zzs(zzq2.zza, zzdu.zzan)) {
            zzj2.zzag(zzq2.zzx);
        }
        zznt.zzc();
        if (zzg().zzs((String) null, zzdu.zzaj)) {
            zzj2.zzaf(zzq2.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs((String) null, zzdu.zzai)) {
                zzj2.zzaf((List) null);
            }
        }
        if (zzj2.zzaj()) {
            zzam zzam5 = this.zze;
            zzal(zzam5);
            zzam5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaa zzf() {
        zzaa zzaa = this.zzh;
        zzal(zzaa);
        return zzaa;
    }

    public final zzag zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    public final zzai zzh(String str) {
        String str2;
        zzai zzai = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzai2 = (zzai) this.zzB.get(str);
        if (zzai2 != null) {
            return zzai2;
        }
        zzam zzam = this.zze;
        zzal(zzam);
        Preconditions.checkNotNull(str);
        zzam.zzg();
        zzam.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzam.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            zzai zzb2 = zzai.zzb(str2);
            zzV(str, zzb2);
            return zzb2;
        } catch (SQLiteException e10) {
            zzam.zzt.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzam = this.zze;
        zzal(zzam);
        return zzam;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzen = this.zzd;
        zzal(zzen);
        return zzen;
    }

    public final zzep zzm() {
        zzep zzep = this.zzf;
        if (zzep != null) {
            return zzep;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        return zzfi;
    }

    public final zzfr zzq() {
        return this.zzn;
    }

    public final zzic zzr() {
        zzic zzic = this.zzj;
        zzal(zzic);
        return zzic;
    }

    public final zzjo zzs() {
        return this.zzk;
    }

    public final zzkv zzu() {
        zzkv zzkv = this.zzi;
        zzal(zzkv);
        return zzkv;
    }

    public final zzlb zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    public final String zzw(zzai zzai) {
        if (!zzai.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaz().zzh(new zzkm(this, zzq2)).get(NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzq2.zza), e10);
            return null;
        }
    }

    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
