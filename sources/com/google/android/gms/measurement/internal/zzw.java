package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzft;

final class zzw {
    final /* synthetic */ zzaa zza;
    private zzft zzb;
    private Long zzc;
    private long zzd;

    public /* synthetic */ zzw(zzaa zzaa, zzv zzv) {
        this.zza = zzaa;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f0, code lost:
        if (r8 == null) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzft zza(java.lang.String r14, com.google.android.gms.internal.measurement.zzft r15) {
        /*
            r13 = this;
            java.lang.String r0 = r15.zzh()
            java.util.List r1 = r15.zzi()
            com.google.android.gms.measurement.internal.zzaa r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            r2.zzu()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r2)
            r6 = r3
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x0225
            java.lang.String r3 = "_ep"
            boolean r3 = r0.equals(r3)
            r4 = 0
            if (r3 == 0) goto L_0x01d9
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            com.google.android.gms.measurement.internal.zzaa r0 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r0 = r0.zzf
            r0.zzu()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r7 = 0
            if (r3 == 0) goto L_0x004f
            com.google.android.gms.measurement.internal.zzaa r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r15 = "Extra parameter without an event name. eventId"
            r14.zzb(r15, r6)
            return r7
        L_0x004f:
            com.google.android.gms.internal.measurement.zzft r3 = r13.zzb
            if (r3 == 0) goto L_0x0065
            java.lang.Long r3 = r13.zzc
            if (r3 == 0) goto L_0x0065
            long r8 = r6.longValue()
            java.lang.Long r3 = r13.zzc
            long r10 = r3.longValue()
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x011d
        L_0x0065:
            com.google.android.gms.measurement.internal.zzaa r3 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r3 = r3.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzi()
            r3.zzg()
            r3.zzW()
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            r10 = 0
            r9[r10] = r14     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            java.lang.String r11 = r6.toString()     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            r12 = 1
            r9[r12] = r11     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            java.lang.String r11 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            android.database.Cursor r8 = r8.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x00de, all -> 0x00db }
            boolean r9 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x00d9 }
            if (r9 != 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzfr r9 = r3.zzt     // Catch:{ SQLiteException -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ SQLiteException -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ SQLiteException -> 0x00d9 }
            java.lang.String r10 = "Main event not found"
            r9.zza(r10)     // Catch:{ SQLiteException -> 0x00d9 }
            goto L_0x00f2
        L_0x00a0:
            byte[] r9 = r8.getBlob(r10)     // Catch:{ SQLiteException -> 0x00d9 }
            long r10 = r8.getLong(r12)     // Catch:{ SQLiteException -> 0x00d9 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteException -> 0x00d9 }
            com.google.android.gms.internal.measurement.zzfs r11 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzll r9 = com.google.android.gms.measurement.internal.zzkv.zzl(r11, r9)     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzkf r9 = r9.zzaC()     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzft r9 = (com.google.android.gms.internal.measurement.zzft) r9     // Catch:{ IOException -> 0x00c4 }
            android.util.Pair r3 = android.util.Pair.create(r9, r10)     // Catch:{ SQLiteException -> 0x00d9 }
            r8.close()
            goto L_0x00f6
        L_0x00c4:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfr r10 = r3.zzt     // Catch:{ SQLiteException -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ SQLiteException -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ SQLiteException -> 0x00d9 }
            java.lang.String r11 = "Failed to merge main event. appId, eventId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)     // Catch:{ SQLiteException -> 0x00d9 }
            r10.zzd(r11, r12, r6, r9)     // Catch:{ SQLiteException -> 0x00d9 }
            goto L_0x00f2
        L_0x00d9:
            r9 = move-exception
            goto L_0x00e1
        L_0x00db:
            r14 = move-exception
            goto L_0x01d3
        L_0x00de:
            r8 = move-exception
            r9 = r8
            r8 = r7
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x01d1 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x01d1 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x01d1 }
            java.lang.String r10 = "Error selecting main event"
            r3.zzb(r10, r9)     // Catch:{ all -> 0x01d1 }
            if (r8 == 0) goto L_0x00f5
        L_0x00f2:
            r8.close()
        L_0x00f5:
            r3 = r7
        L_0x00f6:
            if (r3 == 0) goto L_0x01bf
            java.lang.Object r8 = r3.first
            if (r8 != 0) goto L_0x00fe
            goto L_0x01bf
        L_0x00fe:
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8
            r13.zzb = r8
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r7 = r3.longValue()
            r13.zzd = r7
            com.google.android.gms.measurement.internal.zzaa r3 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r3 = r3.zzf
            r3.zzu()
            com.google.android.gms.internal.measurement.zzft r3 = r13.zzb
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkv.zzC(r3, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r13.zzc = r2
        L_0x011d:
            long r2 = r13.zzd
            r7 = -1
            long r2 = r2 + r7
            r13.zzd = r2
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzaa r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r2.zzi()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r3.zzb(r4, r14)
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0150 }
            java.lang.String[] r14 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x0150 }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            r3.execSQL(r4, r14)     // Catch:{ SQLiteException -> 0x0150 }
            goto L_0x0171
        L_0x0150:
            r14 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zzb(r3, r14)
            goto L_0x0171
        L_0x0161:
            com.google.android.gms.measurement.internal.zzaa r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzam r4 = r2.zzi()
            long r7 = r13.zzd
            com.google.android.gms.internal.measurement.zzft r9 = r13.zzb
            r5 = r14
            r4.zzJ(r5, r6, r7, r9)
        L_0x0171:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.measurement.zzft r2 = r13.zzb
            java.util.List r2 = r2.zzi()
            java.util.Iterator r2 = r2.iterator()
        L_0x0180:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01a1
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3
            com.google.android.gms.measurement.internal.zzaa r4 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r4 = r4.zzf
            r4.zzu()
            java.lang.String r4 = r3.zzg()
            com.google.android.gms.internal.measurement.zzfx r4 = com.google.android.gms.measurement.internal.zzkv.zzB(r15, r4)
            if (r4 != 0) goto L_0x0180
            r14.add(r3)
            goto L_0x0180
        L_0x01a1:
            boolean r2 = r14.isEmpty()
            if (r2 != 0) goto L_0x01ad
            r14.addAll(r1)
            r1 = r14
            goto L_0x0225
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzaa r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r14.zzb(r2, r0)
            goto L_0x0225
        L_0x01bf:
            com.google.android.gms.measurement.internal.zzaa r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r15 = "Extra parameter without existing main event. eventName, eventId"
            r14.zzc(r15, r0, r6)
            return r7
        L_0x01d1:
            r14 = move-exception
            r7 = r8
        L_0x01d3:
            if (r7 == 0) goto L_0x01d8
            r7.close()
        L_0x01d8:
            throw r14
        L_0x01d9:
            r13.zzc = r6
            r13.zzb = r15
            com.google.android.gms.measurement.internal.zzaa r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            r2.zzu()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r3)
            if (r3 == 0) goto L_0x01f1
            r2 = r3
        L_0x01f1:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r13.zzd = r2
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x020f
            com.google.android.gms.measurement.internal.zzaa r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r14.zzb(r2, r0)
            goto L_0x0225
        L_0x020f:
            com.google.android.gms.measurement.internal.zzaa r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzam r7 = r2.zzi()
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            r9 = r2
            java.lang.Long r9 = (java.lang.Long) r9
            long r10 = r13.zzd
            r8 = r14
            r12 = r15
            r7.zzJ(r8, r9, r10, r12)
        L_0x0225:
            com.google.android.gms.internal.measurement.zzkb r14 = r15.zzby()
            com.google.android.gms.internal.measurement.zzfs r14 = (com.google.android.gms.internal.measurement.zzfs) r14
            r14.zzi(r0)
            r14.zzg()
            r14.zzd(r1)
            com.google.android.gms.internal.measurement.zzkf r14 = r14.zzaC()
            com.google.android.gms.internal.measurement.zzft r14 = (com.google.android.gms.internal.measurement.zzft) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zza(java.lang.String, com.google.android.gms.internal.measurement.zzft):com.google.android.gms.internal.measurement.zzft");
    }
}
