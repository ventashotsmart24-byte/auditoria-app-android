package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public final class zzdy extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    public zzdy(zzfr zzfr, long j10) {
        super(zzfr);
        this.zzg = j10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018b A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0194 A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01bc A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x024c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            android.content.Context r0 = r0.zzau()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzfr r1 = r11.zzt
            android.content.Context r1 = r1.zzau()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            java.lang.String r6 = "Unknown"
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r7.zzb(r8, r9)
        L_0x0032:
            r8 = r6
            goto L_0x009b
        L_0x0035:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003a }
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r7.zzb(r8, r9)
        L_0x004d:
            if (r5 != 0) goto L_0x0052
            java.lang.String r5 = "manual_install"
            goto L_0x005b
        L_0x0052:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x005b
            r5 = r3
        L_0x005b:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r7 = r7.zzau()     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r7 == 0) goto L_0x0032
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r9 != 0) goto L_0x007c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0085 }
            goto L_0x007d
        L_0x007c:
            r8 = r6
        L_0x007d:
            java.lang.String r6 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0082 }
            int r2 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0082 }
            goto L_0x009b
        L_0x0082:
            r7 = r6
            r6 = r8
            goto L_0x0086
        L_0x0085:
            r7 = r6
        L_0x0086:
            com.google.android.gms.measurement.internal.zzfr r8 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzd()
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r8.zzc(r9, r10, r6)
            r8 = r6
            r6 = r7
        L_0x009b:
            r11.zza = r0
            r11.zzd = r5
            r11.zzb = r6
            r11.zzc = r2
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r2 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzx()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c6
            r2 = 1
            goto L_0x00c7
        L_0x00c6:
            r2 = 0
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfr r6 = r11.zzt
            int r6 = r6.zza()
            switch(r6) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0141;
                case 2: goto L_0x0131;
                case 3: goto L_0x0121;
                case 4: goto L_0x0111;
                case 5: goto L_0x0101;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0160
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0160
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzl()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0160
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0111:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0121:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0160
        L_0x0131:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0141:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0160:
            r11.zzk = r3
            r11.zzl = r3
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            r7.zzaw()
            if (r2 == 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            r11.zzl = r2
        L_0x0173:
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01db }
            android.content.Context r2 = r2.zzau()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r7 = r7.zzz()     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r8 = "google_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzid.zzc(r2, r8, r7)     // Catch:{ IllegalStateException -> 0x01db }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01db }
            if (r5 == r7) goto L_0x018c
            r3 = r2
        L_0x018c:
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x01db }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01db }
            if (r2 != 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01db }
            android.content.Context r2 = r2.zzau()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzt     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r3 = r3.zzz()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ IllegalStateException -> 0x01db }
            android.content.res.Resources r5 = r2.getResources()     // Catch:{ IllegalStateException -> 0x01db }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IllegalStateException -> 0x01db }
            if (r7 != 0) goto L_0x01ae
            goto L_0x01b2
        L_0x01ae:
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzfj.zza(r2)     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01b2:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzfj.zzb(r2, r5, r3)     // Catch:{ IllegalStateException -> 0x01db }
            r11.zzl = r2     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01ba:
            if (r6 != 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.zza     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01db }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01db }
            if (r6 == 0) goto L_0x01d5
            java.lang.String r6 = r11.zzl     // Catch:{ IllegalStateException -> 0x01db }
            goto L_0x01d7
        L_0x01d5:
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01d7:
            r2.zzc(r3, r5, r6)     // Catch:{ IllegalStateException -> 0x01db }
            goto L_0x01ef
        L_0x01db:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r3.zzc(r5, r0, r2)
        L_0x01ef:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            r0.zzaw()
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzp(r2)
            if (r0 != 0) goto L_0x0206
            goto L_0x023b
        L_0x0206:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x021c
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzl()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x023d
        L_0x021c:
            java.util.Iterator r2 = r0.iterator()
        L_0x0220:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x023b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzfr r5 = r11.zzt
            com.google.android.gms.measurement.internal.zzlb r5 = r5.zzv()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r5.zzab(r6, r3)
            if (r3 != 0) goto L_0x0220
            goto L_0x023d
        L_0x023b:
            r11.zzh = r0
        L_0x023d:
            if (r1 == 0) goto L_0x024c
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            android.content.Context r0 = r0.zzau()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x024c:
            r11.zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzd():void");
    }

    public final boolean zzf() {
        return true;
    }

    public final int zzh() {
        zza();
        return this.zzj;
    }

    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0270  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq zzj(java.lang.String r37) {
        /*
            r36 = this;
            r1 = r36
            r36.zzg()
            com.google.android.gms.measurement.internal.zzq r33 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r36.zzl()
            java.lang.String r4 = r36.zzm()
            r36.zza()
            java.lang.String r5 = r1.zzb
            r36.zza()
            int r0 = r1.zzc
            long r6 = (long) r0
            r36.zza()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            r0.zzh()
            r36.zza()
            r36.zzg()
            long r9 = r1.zzf
            r2 = 0
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzlb r9 = r0.zzv()
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            android.content.Context r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            android.content.Context r10 = r10.zzau()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzlb.zzF()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzfr r0 = r9.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00ce
        L_0x0078:
            if (r13 == 0) goto L_0x00cd
            boolean r10 = r9.zzag(r0, r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzfr r10 = r9.zzt     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.Context r10 = r10.zzau()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bd }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r0 == 0) goto L_0x00ab
            int r10 = r0.length     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 <= 0) goto L_0x00ab
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            long r9 = com.google.android.gms.measurement.internal.zzlb.zzp(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            r15 = r9
            goto L_0x0076
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzfr r0 = r9.zzt     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            goto L_0x0076
        L_0x00bb:
            r15 = r11
            goto L_0x0076
        L_0x00bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzd()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            r1.zzf = r9
        L_0x00d0:
            r13 = r9
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            boolean r0 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzm()
            boolean r9 = r9.zzl
            r10 = 1
            r15 = r9 ^ 1
            r36.zzg()
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            boolean r9 = r9.zzJ()
            r11 = 0
            if (r9 != 0) goto L_0x00f2
        L_0x00ee:
            r20 = r11
            goto L_0x017a
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzpj.zzc()
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r9 = r9.zzf()
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzaa
            boolean r9 = r9.zzs(r11, r12)
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00ee
        L_0x0113:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt     // Catch:{ ClassNotFoundException -> 0x0177 }
            android.content.Context r9 = r9.zzau()     // Catch:{ ClassNotFoundException -> 0x0177 }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0177 }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x0177 }
            if (r9 != 0) goto L_0x0126
            goto L_0x00ee
        L_0x0126:
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<android.content.Context> r18 = android.content.Context.class
            r12[r2] = r18     // Catch:{ Exception -> 0x0167 }
            java.lang.String r11 = "getInstance"
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x0167 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt     // Catch:{ Exception -> 0x0167 }
            android.content.Context r10 = r10.zzau()     // Catch:{ Exception -> 0x0167 }
            r12[r2] = r10     // Catch:{ Exception -> 0x0167 }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x0167 }
            if (r11 != 0) goto L_0x0144
            goto L_0x0178
        L_0x0144:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x0157 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0157 }
            r20 = r9
            goto L_0x017a
        L_0x0157:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzl()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r10)
            goto L_0x0178
        L_0x0167:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzm()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r10)
            goto L_0x0178
        L_0x0177:
        L_0x0178:
            r20 = 0
        L_0x017a:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzt
            com.google.android.gms.measurement.internal.zzew r10 = r9.zzm()
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzc
            long r10 = r10.zza()
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0192
            long r9 = r9.zzc
            r12 = r3
            r22 = r9
            goto L_0x019b
        L_0x0192:
            r12 = r3
            long r2 = r9.zzc
            long r2 = java.lang.Math.min(r2, r10)
            r22 = r2
        L_0x019b:
            r36.zza()
            int r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            boolean r24 = r2.zzr()
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzm()
            r2.zzg()
            android.content.SharedPreferences r2 = r2.zza()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r25 = r2.getBoolean(r3, r9)
            r36.zza()
            java.lang.String r3 = r1.zzl
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzk(r9)
            if (r2 != 0) goto L_0x01d4
            r26 = 0
            goto L_0x01e0
        L_0x01d4:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r26 = r2
        L_0x01e0:
            long r9 = r1.zzg
            java.util.List r2 = r1.zzh
            r19 = r2
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzm()
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzc()
            java.lang.String r30 = r2.zzh()
            java.lang.String r2 = r1.zzi
            if (r2 != 0) goto L_0x021d
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            r21 = r3
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzap
            r27 = r9
            r9 = 0
            boolean r2 = r2.zzs(r9, r3)
            if (r2 == 0) goto L_0x0218
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzlb r2 = r2.zzv()
            java.lang.String r2 = r2.zzC()
            r1.zzi = r2
            goto L_0x0221
        L_0x0218:
            java.lang.String r2 = ""
            r1.zzi = r2
            goto L_0x0221
        L_0x021d:
            r21 = r3
            r27 = r9
        L_0x0221:
            java.lang.String r3 = r1.zzi
            com.google.android.gms.internal.measurement.zzpd.zzc()
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r2 = r2.zzf()
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzam
            r10 = 0
            boolean r2 = r2.zzs(r10, r9)
            if (r2 == 0) goto L_0x0270
            r36.zzg()
            long r9 = r1.zzn
            r16 = 0
            int r2 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r2 != 0) goto L_0x0243
            r16 = r3
            goto L_0x0264
        L_0x0243:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzav()
            long r9 = r2.currentTimeMillis()
            r16 = r3
            long r2 = r1.zzn
            long r9 = r9 - r2
            java.lang.String r2 = r1.zzm
            if (r2 == 0) goto L_0x0264
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r17 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r17 <= 0) goto L_0x0264
            java.lang.String r2 = r1.zzo
            if (r2 != 0) goto L_0x0264
            r36.zzo()
        L_0x0264:
            java.lang.String r2 = r1.zzm
            if (r2 != 0) goto L_0x026b
            r36.zzo()
        L_0x026b:
            java.lang.String r2 = r1.zzm
            r32 = r2
            goto L_0x0274
        L_0x0270:
            r16 = r3
            r32 = r10
        L_0x0274:
            r9 = 74029(0x1212d, double:3.6575E-319)
            r17 = 0
            r29 = 0
            r31 = r19
            r2 = r33
            r35 = r16
            r34 = r21
            r3 = r12
            r21 = r11
            r11 = r13
            r13 = r37
            r14 = r0
            r16 = r20
            r19 = r22
            r22 = r24
            r23 = r25
            r24 = r34
            r25 = r26
            r26 = r27
            r28 = r31
            r31 = r35
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    public final String zzk() {
        zza();
        return this.zzl;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final void zzo() {
        String str;
        String str2;
        zzg();
        if (!this.zzt.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            this.zzt.zzay().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzt.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzef zzc2 = this.zzt.zzay().zzc();
        Object[] objArr = new Object[1];
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        objArr[0] = str2;
        zzc2.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzt.zzav().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.zzo = str;
        return z10;
    }
}
