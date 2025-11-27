package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class zzhu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhw zze;

    public zzhu(zzhw zzhw, boolean z10, Uri uri, String str, String str2) {
        this.zze = zzhw;
        this.zza = z10;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[SYNTHETIC, Splitter:B:27:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce A[Catch:{ RuntimeException -> 0x0161 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[Catch:{ RuntimeException -> 0x0161 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhw r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzhx r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzhx r6 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzlb r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0161 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r8 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "utm_medium"
            java.lang.String r10 = "_cis"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            r13 = 0
            java.lang.String r14 = "gclid"
            if (r7 == 0) goto L_0x002e
        L_0x002c:
            r6 = r13
            goto L_0x0081
        L_0x002e:
            boolean r7 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "utm_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "dclid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "srsltid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0161 }
            if (r7 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0161 }
            r6.zza(r8)     // Catch:{ RuntimeException -> 0x0161 }
            goto L_0x002c
        L_0x006c:
            java.lang.String r7 = "https://google.com/search?"
            java.lang.String r7 = r7.concat(r5)     // Catch:{ RuntimeException -> 0x0161 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0161 }
            android.os.Bundle r6 = r6.zzs(r7)     // Catch:{ RuntimeException -> 0x0161 }
            if (r6 == 0) goto L_0x0081
            java.lang.String r7 = "referrer"
            r6.putString(r10, r7)     // Catch:{ RuntimeException -> 0x0161 }
        L_0x0081:
            java.lang.String r7 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x00c8
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzlb r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0161 }
            android.os.Bundle r0 = r0.zzs(r3)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r3 = "intent"
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0161 }
            boolean r3 = r0.containsKey(r14)     // Catch:{ RuntimeException -> 0x0161 }
            if (r3 != 0) goto L_0x00bc
            if (r6 == 0) goto L_0x00bc
            boolean r3 = r6.containsKey(r14)     // Catch:{ RuntimeException -> 0x0161 }
            if (r3 == 0) goto L_0x00bc
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r10 = r6.getString(r14)     // Catch:{ RuntimeException -> 0x0161 }
            r16 = 0
            r3[r16] = r10     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r10 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r15, r3)     // Catch:{ RuntimeException -> 0x0161 }
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0161 }
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzhx r3 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            r3.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzhx r3 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb     // Catch:{ RuntimeException -> 0x0161 }
            r3.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0161 }
        L_0x00c8:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 == 0) goto L_0x00d0
            goto L_0x0150
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzY     // Catch:{ RuntimeException -> 0x0161 }
            boolean r0 = r0.zzs(r13, r3)     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r3 = "_ldl"
            java.lang.String r10 = "auto"
            if (r0 == 0) goto L_0x011c
            if (r6 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0161 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0161 }
            goto L_0x0115
        L_0x0104:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0161 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0161 }
        L_0x0115:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            r4 = 1
            r0.zzW(r10, r3, r13, r4)     // Catch:{ RuntimeException -> 0x0161 }
            return
        L_0x011c:
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 == 0) goto L_0x0151
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 != 0) goto L_0x0144
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 != 0) goto L_0x0144
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 != 0) goto L_0x0144
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 != 0) goto L_0x0144
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 == 0) goto L_0x0151
        L_0x0144:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0161 }
            if (r0 != 0) goto L_0x0150
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            r4 = 1
            r0.zzW(r10, r3, r5, r4)     // Catch:{ RuntimeException -> 0x0161 }
        L_0x0150:
            return
        L_0x0151:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.zza     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0161 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0161 }
            r0.zza(r8)     // Catch:{ RuntimeException -> 0x0161 }
            return
        L_0x0161:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhx r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhu.run():void");
    }
}
