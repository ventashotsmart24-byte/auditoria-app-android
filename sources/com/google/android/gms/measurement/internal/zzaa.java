package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class zzaa extends zzkh {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzkt zzkt) {
        super(zzkt);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i10, int i11) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i10));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v150, resolved type: androidx.collection.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: androidx.collection.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: androidx.collection.a} */
    /* JADX WARNING: type inference failed for: r26v22 */
    /* JADX WARNING: type inference failed for: r26v23 */
    /* JADX WARNING: type inference failed for: r26v42 */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02de, code lost:
        if (r5 != null) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x076f, code lost:
        r0 = e;
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0771, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0772, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0774, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0775, code lost:
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0781, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0782, code lost:
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0785, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0786, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0788, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0789, code lost:
        r26 = r7;
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x07a5, code lost:
        r5.close();
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x07af, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0939, code lost:
        if (r9 == null) goto L_0x093c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0a58, code lost:
        if (r8 != false) goto L_0x0a63;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:457:0x05be, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:458:0x05be, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:459:0x05be, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:461:0x05be, code lost:
        r26 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0174, code lost:
        if (r5 != null) goto L_0x0152;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x05f6  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0771 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:260:0x06fe] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0785 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:252:0x06dc] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x07a5  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x07af  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x07c9  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x085c  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0944  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0a80  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0b18  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b5 A[Catch:{ SQLiteException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c1 A[SYNTHETIC, Splitter:B:65:0x01c1] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0251  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r64, java.util.List r65, java.util.List r66, java.lang.Long r67, java.lang.Long r68) {
        /*
            r63 = this;
            r10 = r63
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r64)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            r0 = r64
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.a r0 = new androidx.collection.a
            r0.<init>()
            r10.zzc = r0
            r0 = r67
            r10.zzd = r0
            r0 = r68
            r10.zze = r0
            java.util.Iterator r0 = r65.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzW
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzV
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r16 = "data"
            java.lang.String r7 = "audience_id"
            r6 = 2
            if (r15 == 0) goto L_0x017d
            if (r14 == 0) goto L_0x017d
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.a r4 = new androidx.collection.a
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r2.zzh()
            java.lang.String[] r0 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            r0[r12] = r7     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            r0[r13] = r16     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String[] r21 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String r18 = "event_filters"
            java.lang.String r20 = "app_id=?"
            r22 = 0
            r23 = 0
            r24 = 0
            r19 = r0
            android.database.Cursor r5 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 == 0) goto L_0x014e
        L_0x00f4:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.internal.measurement.zzej r13 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x012e }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x012e }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012e }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x012e }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x012e }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0158 }
            if (r13 != 0) goto L_0x010f
            goto L_0x0140
        L_0x010f:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r17 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.util.List r17 = (java.util.List) r17     // Catch:{ SQLiteException -> 0x0158 }
            if (r17 != 0) goto L_0x0128
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0158 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0158 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x012a
        L_0x0128:
            r12 = r17
        L_0x012a:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x0140
        L_0x012e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r12 = r2.zzt     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0158 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0158 }
        L_0x0140:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 != 0) goto L_0x014b
            r5.close()
            r12 = r4
            goto L_0x017e
        L_0x014b:
            r12 = 0
            r13 = 1
            goto L_0x00f4
        L_0x014e:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0158 }
        L_0x0152:
            r5.close()
            goto L_0x017d
        L_0x0156:
            r0 = move-exception
            goto L_0x0177
        L_0x0158:
            r0 = move-exception
            goto L_0x015f
        L_0x015a:
            r0 = move-exception
            r5 = 0
            goto L_0x0177
        L_0x015d:
            r0 = move-exception
            r5 = 0
        L_0x015f:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0156 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0156 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0156 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0156 }
            if (r5 == 0) goto L_0x017d
            goto L_0x0152
        L_0x0177:
            if (r5 == 0) goto L_0x017c
            r5.close()
        L_0x017c:
            throw r0
        L_0x017d:
            r12 = r0
        L_0x017e:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r17 = r2.zzh()
            java.lang.String[] r0 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r4 = 0
            r0[r4] = r7     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r4 = 1
            r0[r4] = r11     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            java.lang.String[] r21 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            java.lang.String r18 = "audience_filter_values"
            java.lang.String r20 = "app_id=?"
            r22 = 0
            r23 = 0
            r24 = 0
            r19 = r0
            android.database.Cursor r4 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x021c }
            if (r0 != 0) goto L_0x01c1
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x021c }
            r4.close()
            r13 = r0
            r20 = r7
            goto L_0x0245
        L_0x01c1:
            androidx.collection.a r5 = new androidx.collection.a     // Catch:{ SQLiteException -> 0x021c }
            r5.<init>()     // Catch:{ SQLiteException -> 0x021c }
        L_0x01c6:
            r13 = 0
            int r17 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x021c }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x021c }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zzf()     // Catch:{ IOException -> 0x01ec }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x01ec }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01ec }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x01ec }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x01ec }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x021c }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x021c }
            r19 = r5
            r20 = r7
            goto L_0x0208
        L_0x01ec:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r13 = r2.zzt     // Catch:{ SQLiteException -> 0x021c }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ SQLiteException -> 0x021c }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x021c }
            java.lang.String r6 = "Failed to merge filter results. appId, audienceId, error"
            r19 = r5
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x021c }
            r20 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x021a }
            r13.zzd(r6, r5, r7, r0)     // Catch:{ SQLiteException -> 0x021a }
        L_0x0208:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x021a }
            if (r0 != 0) goto L_0x0214
            r4.close()
            r13 = r19
            goto L_0x0245
        L_0x0214:
            r5 = r19
            r7 = r20
            r6 = 2
            goto L_0x01c6
        L_0x021a:
            r0 = move-exception
            goto L_0x0228
        L_0x021c:
            r0 = move-exception
            r20 = r7
            goto L_0x0228
        L_0x0220:
            r0 = move-exception
            r5 = 0
            goto L_0x0b16
        L_0x0224:
            r0 = move-exception
            r20 = r7
            r4 = 0
        L_0x0228:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0b14 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0b14 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0b14 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0b14 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b14 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b14 }
            if (r4 == 0) goto L_0x0244
            r4.close()
        L_0x0244:
            r13 = r0
        L_0x0245:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0251
            r12 = r8
            r13 = r9
            r28 = r20
            goto L_0x05ea
        L_0x0251:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0447
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r0.zzi()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.a r0 = new androidx.collection.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String[] r6 = new java.lang.String[]{r4, r4}     // Catch:{ SQLiteException -> 0x02c5, all -> 0x02c1 }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02c5, all -> 0x02c1 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02bf }
            if (r6 == 0) goto L_0x02b7
        L_0x0288:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02bf }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02bf }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02bf }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02bf }
            if (r7 != 0) goto L_0x02a1
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02bf }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02bf }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02bf }
        L_0x02a1:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02bf }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02bf }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02bf }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02bf }
            if (r6 != 0) goto L_0x0288
        L_0x02b3:
            r5.close()
            goto L_0x02e1
        L_0x02b7:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02bf }
            goto L_0x02b3
        L_0x02bc:
            r0 = move-exception
            goto L_0x0441
        L_0x02bf:
            r0 = move-exception
            goto L_0x02c7
        L_0x02c1:
            r0 = move-exception
            r5 = 0
            goto L_0x0441
        L_0x02c5:
            r0 = move-exception
            r5 = 0
        L_0x02c7:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x02bc }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x02bc }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x02bc }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x02bc }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02bc }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02bc }
            if (r5 == 0) goto L_0x02e1
            goto L_0x02b3
        L_0x02e1:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.a r1 = new androidx.collection.a
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x02f6
        L_0x02f2:
            r21 = r8
            goto L_0x043f
        L_0x02f6:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x02fe:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02f2
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgi r6 = (com.google.android.gms.internal.measurement.zzgi) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x042e
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0328
            goto L_0x042e
        L_0x0328:
            com.google.android.gms.measurement.internal.zzkt r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r5 = r5.zzu()
            r17 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzq(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x042a
            com.google.android.gms.internal.measurement.zzkb r5 = r6.zzby()
            com.google.android.gms.internal.measurement.zzgh r5 = (com.google.android.gms.internal.measurement.zzgh) r5
            r5.zzf()
            r5.zzb(r0)
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()
            r19 = r3
            java.util.List r3 = r6.zzn()
            java.util.List r0 = r0.zzq(r3, r7)
            r5.zzh()
            r5.zzd(r0)
            com.google.android.gms.internal.measurement.zzoc.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzas
            r21 = r8
            r8 = 0
            boolean r0 = r0.zzs(r8, r3)
            if (r0 == 0) goto L_0x03de
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x0381:
            boolean r22 = r3.hasNext()
            if (r22 == 0) goto L_0x03a6
            java.lang.Object r22 = r3.next()
            r8 = r22
            com.google.android.gms.internal.measurement.zzfr r8 = (com.google.android.gms.internal.measurement.zzfr) r8
            int r22 = r8.zza()
            r23 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            boolean r3 = r7.contains(r3)
            if (r3 != 0) goto L_0x03a2
            r0.add(r8)
        L_0x03a2:
            r3 = r23
            r8 = 0
            goto L_0x0381
        L_0x03a6:
            r5.zze()
            r5.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzm()
            java.util.Iterator r3 = r3.iterator()
        L_0x03b9:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x03d7
            java.lang.Object r6 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r6 = (com.google.android.gms.internal.measurement.zzgk) r6
            int r8 = r6.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x03b9
            r0.add(r6)
            goto L_0x03b9
        L_0x03d7:
            r5.zzg()
            r5.zzc(r0)
            goto L_0x041c
        L_0x03de:
            r0 = 0
        L_0x03df:
            int r3 = r6.zza()
            if (r0 >= r3) goto L_0x03fd
            com.google.android.gms.internal.measurement.zzfr r3 = r6.zze(r0)
            int r3 = r3.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x03fa
            r5.zzi(r0)
        L_0x03fa:
            int r0 = r0 + 1
            goto L_0x03df
        L_0x03fd:
            r0 = 0
        L_0x03fe:
            int r3 = r6.zzc()
            if (r0 >= r3) goto L_0x041c
            com.google.android.gms.internal.measurement.zzgk r3 = r6.zzi(r0)
            int r3 = r3.zzb()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0419
            r5.zzj(r0)
        L_0x0419:
            int r0 = r0 + 1
            goto L_0x03fe
        L_0x041c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzkf r3 = r5.zzaC()
            com.google.android.gms.internal.measurement.zzgi r3 = (com.google.android.gms.internal.measurement.zzgi) r3
            r1.put(r0, r3)
            goto L_0x0437
        L_0x042a:
            r0 = r17
            goto L_0x02fe
        L_0x042e:
            r17 = r0
            r19 = r3
            r21 = r8
            r1.put(r5, r6)
        L_0x0437:
            r0 = r17
            r3 = r19
            r8 = r21
            goto L_0x02fe
        L_0x043f:
            r0 = r1
            goto L_0x044a
        L_0x0441:
            if (r5 == 0) goto L_0x0446
            r5.close()
        L_0x0446:
            throw r0
        L_0x0447:
            r21 = r8
            r0 = r13
        L_0x044a:
            java.util.Iterator r17 = r2.iterator()
        L_0x044e:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x05e5
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r19 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.a r7 = new androidx.collection.a
            r7.<init>()
            if (r1 == 0) goto L_0x04b6
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0480
            goto L_0x04b6
        L_0x0480:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x0488:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04b6
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x0488
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x04b1
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x04b2
        L_0x04b1:
            r3 = 0
        L_0x04b2:
            r7.put(r4, r3)
            goto L_0x0488
        L_0x04b6:
            androidx.collection.a r8 = new androidx.collection.a
            r8.<init>()
            if (r1 == 0) goto L_0x0502
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x04c4
            goto L_0x0502
        L_0x04c4:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x04cc:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0502
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x04cc
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x04cc
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x04cc
        L_0x0502:
            r23 = r0
            if (r1 == 0) goto L_0x0551
            r0 = 0
        L_0x0507:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x0551
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x0543
            com.google.android.gms.measurement.internal.zzfr r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x0545
            r5.set(r0)
            goto L_0x054c
        L_0x0543:
            r22 = r9
        L_0x0545:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x054c:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x0507
        L_0x0551:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            if (r15 == 0) goto L_0x05be
            if (r14 == 0) goto L_0x05be
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x05be
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x05be
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x0573
            goto L_0x05be
        L_0x0573:
            java.util.Iterator r0 = r0.iterator()
        L_0x0577:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05be
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x059f
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x059f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x05b0
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x05b0:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0577
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0577
        L_0x05be:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r63
            r28 = r20
            r18 = r12
            r12 = r21
            r64 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            r1.put(r2, r0)
            r9 = r13
            r12 = r18
            r0 = r23
            r13 = r64
            goto L_0x044e
        L_0x05e5:
            r13 = r9
            r28 = r20
            r12 = r21
        L_0x05ea:
            boolean r0 = r65.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05f6
        L_0x05f2:
            r25 = r11
            goto L_0x0854
        L_0x05f6:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.a r4 = new androidx.collection.a
            r4.<init>()
            java.util.Iterator r5 = r65.iterator()
        L_0x0605:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x05f2
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzft r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x0605
            com.google.android.gms.measurement.internal.zzkt r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r7 = r7.zzi()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzas r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x066e
            com.google.android.gms.measurement.internal.zzfr r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r29 = r7
            java.lang.String r31 = r0.zzh()
            r32 = 1
            r34 = 1
            r36 = 1
            long r38 = r0.zzd()
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r30 = r8
            r29.<init>(r30, r31, r32, r34, r36, r38, r40, r42, r43, r44, r45)
            goto L_0x06a3
        L_0x066e:
            com.google.android.gms.measurement.internal.zzas r7 = new com.google.android.gms.measurement.internal.zzas
            r46 = r7
            java.lang.String r0 = r14.zza
            r47 = r0
            java.lang.String r0 = r14.zzb
            r48 = r0
            long r8 = r14.zzc
            r17 = 1
            long r49 = r8 + r17
            long r8 = r14.zzd
            long r51 = r8 + r17
            long r8 = r14.zze
            long r53 = r8 + r17
            long r8 = r14.zzf
            r55 = r8
            long r8 = r14.zzg
            r57 = r8
            java.lang.Long r0 = r14.zzh
            r59 = r0
            java.lang.Long r0 = r14.zzi
            r60 = r0
            java.lang.Long r0 = r14.zzj
            r61 = r0
            java.lang.Boolean r0 = r14.zzk
            r62 = r0
            r46.<init>(r47, r48, r49, r51, r53, r55, r57, r59, r60, r61, r62)
        L_0x06a3:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r0 = r0.zzi()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07b3
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r15 = r0.zzi()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r64 = r2
            androidx.collection.a r2 = new androidx.collection.a
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r15.zzh()
            r65 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0788, all -> 0x0785 }
            r5 = r28
            r18 = 0
            r0[r18] = r5     // Catch:{ SQLiteException -> 0x0781, all -> 0x0785 }
            r18 = 1
            r0[r18] = r16     // Catch:{ SQLiteException -> 0x0781, all -> 0x0785 }
            java.lang.String[] r21 = new java.lang.String[]{r3, r14}     // Catch:{ SQLiteException -> 0x0781, all -> 0x0785 }
            java.lang.String r18 = "event_filters"
            java.lang.String r20 = "app_id=? AND event_name=?"
            r22 = 0
            r23 = 0
            r24 = 0
            r19 = r0
            r25 = r11
            android.database.Cursor r11 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x077b, all -> 0x0785 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0774, all -> 0x0771 }
            if (r0 == 0) goto L_0x0763
            r28 = r5
        L_0x0706:
            r5 = 1
            byte[] r0 = r11.getBlob(r5)     // Catch:{ SQLiteException -> 0x0761, all -> 0x0771 }
            com.google.android.gms.internal.measurement.zzej r5 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x073f }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r5, r0)     // Catch:{ IOException -> 0x073f }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x073f }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x073f }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x073f }
            r5 = 0
            int r17 = r11.getInt(r5)     // Catch:{ SQLiteException -> 0x0761, all -> 0x0771 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x0761, all -> 0x0771 }
            java.lang.Object r17 = r2.get(r5)     // Catch:{ SQLiteException -> 0x0761, all -> 0x0771 }
            java.util.List r17 = (java.util.List) r17     // Catch:{ SQLiteException -> 0x0761, all -> 0x0771 }
            if (r17 != 0) goto L_0x0737
            r26 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            r2.put(r5, r7)     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            goto L_0x073b
        L_0x0737:
            r26 = r7
            r7 = r17
        L_0x073b:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            goto L_0x0753
        L_0x073f:
            r0 = move-exception
            r26 = r7
            com.google.android.gms.measurement.internal.zzfr r5 = r15.zzt     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            r5.zzc(r13, r7, r0)     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
        L_0x0753:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            if (r0 != 0) goto L_0x075e
            r11.close()
            r0 = r2
            goto L_0x07a8
        L_0x075e:
            r7 = r26
            goto L_0x0706
        L_0x0761:
            r0 = move-exception
            goto L_0x0777
        L_0x0763:
            r28 = r5
            r26 = r7
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x076f, all -> 0x0771 }
            r11.close()
            goto L_0x07a8
        L_0x076f:
            r0 = move-exception
            goto L_0x0779
        L_0x0771:
            r0 = move-exception
            r5 = r11
            goto L_0x07ad
        L_0x0774:
            r0 = move-exception
            r28 = r5
        L_0x0777:
            r26 = r7
        L_0x0779:
            r5 = r11
            goto L_0x078e
        L_0x077b:
            r0 = move-exception
            r28 = r5
            r26 = r7
            goto L_0x078d
        L_0x0781:
            r0 = move-exception
            r28 = r5
            goto L_0x0789
        L_0x0785:
            r0 = move-exception
            r5 = 0
            goto L_0x07ad
        L_0x0788:
            r0 = move-exception
        L_0x0789:
            r26 = r7
            r25 = r11
        L_0x078d:
            r5 = 0
        L_0x078e:
            com.google.android.gms.measurement.internal.zzfr r2 = r15.zzt     // Catch:{ all -> 0x07ac }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x07ac }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x07ac }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x07ac }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x07ac }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x07ac }
            if (r5 == 0) goto L_0x07a8
            r5.close()
        L_0x07a8:
            r4.put(r14, r0)
            goto L_0x07bb
        L_0x07ac:
            r0 = move-exception
        L_0x07ad:
            if (r5 == 0) goto L_0x07b2
            r5.close()
        L_0x07b2:
            throw r0
        L_0x07b3:
            r64 = r2
            r65 = r5
            r26 = r7
            r25 = r11
        L_0x07bb:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07c3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x084b
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x07ed
            com.google.android.gms.measurement.internal.zzfr r3 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x07c3
        L_0x07ed:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x07f8:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x083e
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r14 = r10.zzd
            java.lang.Long r15 = r10.zze
            int r7 = r7.zzb()
            boolean r24 = r10.zzf(r3, r7)
            r17 = r11
            r18 = r14
            r19 = r15
            r20 = r6
            r21 = r8
            r23 = r26
            boolean r7 = r17.zzd(r18, r19, r20, r21, r23, r24)
            if (r7 == 0) goto L_0x0835
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x07f8
        L_0x0835:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x083e:
            if (r7 != 0) goto L_0x07c3
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x07c3
        L_0x084b:
            r2 = r64
            r5 = r65
            r11 = r25
            r3 = 0
            goto L_0x0605
        L_0x0854:
            boolean r0 = r66.isEmpty()
            if (r0 == 0) goto L_0x085c
            goto L_0x0a66
        L_0x085c:
            androidx.collection.a r2 = new androidx.collection.a
            r2.<init>()
            java.util.Iterator r3 = r66.iterator()
        L_0x0865:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0a66
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0948
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.a r8 = new androidx.collection.a
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r17 = r6.zzh()
            r9 = 2
            java.lang.String[] r0 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0921, all -> 0x091e }
            r9 = 0
            r0[r9] = r28     // Catch:{ SQLiteException -> 0x0921, all -> 0x091e }
            r9 = 1
            r0[r9] = r16     // Catch:{ SQLiteException -> 0x0921, all -> 0x091e }
            java.lang.String[] r21 = new java.lang.String[]{r7, r5}     // Catch:{ SQLiteException -> 0x0921, all -> 0x091e }
            java.lang.String r18 = "property_filters"
            java.lang.String r20 = "app_id=? AND property_name=?"
            r22 = 0
            r23 = 0
            r24 = 0
            r19 = r0
            android.database.Cursor r9 = r17.query(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0921, all -> 0x091e }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x091b }
            if (r0 == 0) goto L_0x0910
        L_0x08be:
            r11 = 1
            byte[] r0 = r9.getBlob(r11)     // Catch:{ SQLiteException -> 0x091b }
            com.google.android.gms.internal.measurement.zzes r13 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x08f0 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x08f0 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x08f0 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x08f0 }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x08f0 }
            r13 = 0
            int r14 = r9.getInt(r13)     // Catch:{ SQLiteException -> 0x0919 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x0919 }
            java.lang.Object r15 = r8.get(r14)     // Catch:{ SQLiteException -> 0x0919 }
            java.util.List r15 = (java.util.List) r15     // Catch:{ SQLiteException -> 0x0919 }
            if (r15 != 0) goto L_0x08ec
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0919 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x0919 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x0919 }
        L_0x08ec:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x0919 }
            goto L_0x0905
        L_0x08f0:
            r0 = move-exception
            r13 = 0
            com.google.android.gms.measurement.internal.zzfr r14 = r6.zzt     // Catch:{ SQLiteException -> 0x0919 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()     // Catch:{ SQLiteException -> 0x0919 }
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x0919 }
            java.lang.String r15 = "Failed to merge filter"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ SQLiteException -> 0x0919 }
            r14.zzc(r15, r11, r0)     // Catch:{ SQLiteException -> 0x0919 }
        L_0x0905:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0919 }
            if (r0 != 0) goto L_0x08be
            r9.close()
            r0 = r8
            goto L_0x093c
        L_0x0910:
            r13 = 0
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0919 }
        L_0x0915:
            r9.close()
            goto L_0x093c
        L_0x0919:
            r0 = move-exception
            goto L_0x0924
        L_0x091b:
            r0 = move-exception
            r13 = 0
            goto L_0x0924
        L_0x091e:
            r0 = move-exception
            r5 = 0
            goto L_0x0942
        L_0x0921:
            r0 = move-exception
            r13 = 0
            r9 = 0
        L_0x0924:
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt     // Catch:{ all -> 0x0940 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0940 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x0940 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0940 }
            r6.zzc(r12, r7, r0)     // Catch:{ all -> 0x0940 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0940 }
            if (r9 == 0) goto L_0x093c
            goto L_0x0915
        L_0x093c:
            r2.put(r5, r0)
            goto L_0x0949
        L_0x0940:
            r0 = move-exception
            r5 = r9
        L_0x0942:
            if (r5 == 0) goto L_0x0947
            r5.close()
        L_0x0947:
            throw r0
        L_0x0948:
            r13 = 0
        L_0x0949:
            java.util.Set r5 = r0.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0951:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0865
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set r7 = r10.zzb
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x097c
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            r0.zzb(r1, r8)
            goto L_0x0865
        L_0x097c:
            java.lang.Object r7 = r0.get(r8)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x0987:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0a58
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzet r8 = (com.google.android.gms.internal.measurement.zzet) r8
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            java.lang.String r9 = r9.zzq()
            r11 = 2
            boolean r9 = android.util.Log.isLoggable(r9, r11)
            if (r9 == 0) goto L_0x09ee
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            boolean r15 = r8.zzj()
            if (r15 == 0) goto L_0x09c1
            int r15 = r8.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09c2
        L_0x09c1:
            r15 = 0
        L_0x09c2:
            com.google.android.gms.measurement.internal.zzfr r11 = r10.zzt
            com.google.android.gms.measurement.internal.zzec r11 = r11.zzj()
            java.lang.String r13 = r8.zze()
            java.lang.String r11 = r11.zzf(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r9.zzd(r13, r14, r15, r11)
            com.google.android.gms.measurement.internal.zzfr r9 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()
            com.google.android.gms.measurement.internal.zzkt r11 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r11 = r11.zzu()
            java.lang.String r11 = r11.zzp(r8)
            java.lang.String r13 = "Filter definition"
            r9.zzb(r13, r11)
        L_0x09ee:
            boolean r9 = r8.zzj()
            if (r9 == 0) goto L_0x0a2e
            int r9 = r8.zza()
            r11 = 256(0x100, float:3.59E-43)
            if (r9 <= r11) goto L_0x09fd
            goto L_0x0a2e
        L_0x09fd:
            com.google.android.gms.measurement.internal.zzz r9 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r11 = r10.zza
            r9.<init>(r10, r11, r6, r8)
            java.lang.Long r11 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r8 = r8.zza()
            boolean r8 = r10.zzf(r6, r8)
            boolean r8 = r9.zzd(r11, r13, r4, r8)
            if (r8 == 0) goto L_0x0a24
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.measurement.internal.zzu r11 = r10.zzd(r11)
            r11.zzc(r9)
            r13 = 0
            goto L_0x0987
        L_0x0a24:
            java.util.Set r7 = r10.zzb
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0a58
        L_0x0a2e:
            com.google.android.gms.measurement.internal.zzfr r7 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzk()
            java.lang.String r9 = r10.zza
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)
            boolean r11 = r8.zzj()
            if (r11 == 0) goto L_0x0a4d
            int r8 = r8.zza()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0a4e
        L_0x0a4d:
            r8 = 0
        L_0x0a4e:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r11 = "Invalid property filter ID. appId, id"
            r7.zzc(r11, r9, r8)
            goto L_0x0a5a
        L_0x0a58:
            if (r8 != 0) goto L_0x0a63
        L_0x0a5a:
            java.util.Set r7 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
        L_0x0a63:
            r13 = 0
            goto L_0x0951
        L_0x0a66:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a7a:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b13
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfp r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzkt r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzam r3 = r3.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgi r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbu()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r7 = r28
            r6.put(r7, r4)
            r4 = r25
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0af8 }
            java.lang.String r8 = "audience_filter_values"
            r9 = 5
            r11 = 0
            long r8 = r0.insertWithOnConflict(r8, r11, r6, r9)     // Catch:{ SQLiteException -> 0x0af6 }
            r12 = -1
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b0d
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ SQLiteException -> 0x0af6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0af6 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0af6 }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ SQLiteException -> 0x0af6 }
            r0.zzb(r6, r8)     // Catch:{ SQLiteException -> 0x0af6 }
            goto L_0x0b0d
        L_0x0af6:
            r0 = move-exception
            goto L_0x0afa
        L_0x0af8:
            r0 = move-exception
            r11 = 0
        L_0x0afa:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()
            java.lang.String r6 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)
            r3.zzc(r6, r5, r0)
        L_0x0b0d:
            r25 = r4
            r28 = r7
            goto L_0x0a7a
        L_0x0b13:
            return r1
        L_0x0b14:
            r0 = move-exception
            r5 = r4
        L_0x0b16:
            if (r5 == 0) goto L_0x0b1b
            r5.close()
        L_0x0b1b:
            goto L_0x0b1d
        L_0x0b1c:
            throw r0
        L_0x0b1d:
            goto L_0x0b1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean zzb() {
        return false;
    }
}
