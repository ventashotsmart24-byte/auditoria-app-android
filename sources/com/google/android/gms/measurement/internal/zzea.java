package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzea extends zzf {
    private final zzdz zza;
    private boolean zzb;

    public zzea(zzfr zzfr) {
        super(zzfr);
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        this.zza = new zzdz(this, zzau, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A[SYNTHETIC, Splitter:B:47:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzg()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            r3.put(r0, r4)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            r0.zzf()
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0028:
            if (r5 >= r4) goto L_0x012d
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.zzh()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00c2, all -> 0x00bf }
            if (r9 != 0) goto L_0x0035
            r1.zzb = r7     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            r11 = 0
            if (r10 == 0) goto L_0x0054
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0054
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            goto L_0x0121
        L_0x0050:
            r0 = move-exception
            goto L_0x00b9
        L_0x0052:
            r0 = move-exception
            goto L_0x00bd
        L_0x0054:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzfr r15 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzeh r15 = r15.zzay()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzef r15 = r15.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            r11 = 1
            long r13 = r13 + r11
            java.lang.String[] r4 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            int r4 = r9.delete(r0, r11, r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r11 = (long) r4     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4.zzd(r15, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009f:
            r9.insertOrThrow(r0, r8, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            r9.close()
            r2 = 1
            return r2
        L_0x00b2:
            r8 = r10
            goto L_0x00ea
        L_0x00b4:
            r0 = move-exception
            goto L_0x0122
        L_0x00b7:
            r0 = move-exception
            r10 = r8
        L_0x00b9:
            r8 = r9
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            r10 = r8
        L_0x00bd:
            r8 = r9
            goto L_0x00fd
        L_0x00bf:
            r0 = move-exception
            r9 = r8
            goto L_0x0122
        L_0x00c2:
            r0 = move-exception
            r10 = r8
        L_0x00c4:
            if (r8 == 0) goto L_0x00cf
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x00cf
            r8.endTransaction()     // Catch:{ all -> 0x011f }
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x00e6
            r10.close()
        L_0x00e6:
            if (r8 == 0) goto L_0x0119
            goto L_0x0116
        L_0x00e9:
            r9 = r8
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b4 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x00f5
            r8.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0119
            r9.close()
            goto L_0x0119
        L_0x00fb:
            r0 = move-exception
            r10 = r8
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x0114
            r10.close()
        L_0x0114:
            if (r8 == 0) goto L_0x0119
        L_0x0116:
            r8.close()
        L_0x0119:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x011f:
            r0 = move-exception
            r9 = r8
        L_0x0121:
            r8 = r10
        L_0x0122:
            if (r8 == 0) goto L_0x0127
            r8.close()
        L_0x0127:
            if (r9 == 0) goto L_0x012c
            r9.close()
        L_0x012c:
            throw r0
        L_0x012d:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzq(int, byte[]):boolean");
    }

    public final boolean zzf() {
        return false;
    }

    @VisibleForTesting
    public final SQLiteDatabase zzh() {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:59|60|61|62) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:74|75|76|77) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|48|49|196) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12.recycle();
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.recycle();
        r13 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0104 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x013c */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e5 A[SYNTHETIC, Splitter:B:122:0x01e5] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x020a A[SYNTHETIC, Splitter:B:150:0x020a] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x01e8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0257 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0257 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0257 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzi(int r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "rowid"
            java.lang.String r3 = "Error reading entries from local database"
            r23.zzg()
            boolean r0 = r1.zzb
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r23.zzl()
            if (r0 == 0) goto L_0x0279
            r6 = 5
            r7 = 0
            r8 = 0
            r9 = 5
        L_0x001e:
            if (r8 >= r6) goto L_0x0269
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r23.zzh()     // Catch:{ SQLiteFullException -> 0x023d, SQLiteDatabaseLockedException -> 0x022a, SQLiteException -> 0x0205, all -> 0x0202 }
            if (r15 != 0) goto L_0x002a
            r1.zzb = r10     // Catch:{ SQLiteFullException -> 0x01fd, SQLiteDatabaseLockedException -> 0x01f9, SQLiteException -> 0x01f4, all -> 0x01ef }
            return r4
        L_0x002a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01fd, SQLiteDatabaseLockedException -> 0x01f9, SQLiteException -> 0x01f4, all -> 0x01ef }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ all -> 0x01e0 }
            r13[r7] = r2     // Catch:{ all -> 0x01e0 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01e0 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r11 = r15
            r24 = r15
            r15 = r0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01dc }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x01d8 }
            r20 = -1
            if (r0 == 0) goto L_0x005b
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x01d8 }
            r11.close()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            goto L_0x0060
        L_0x005b:
            r11.close()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            r12 = r20
        L_0x0060:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            r14 = r0
            r15 = r11
            goto L_0x0073
        L_0x0071:
            r14 = r4
            r15 = r14
        L_0x0073:
            r0 = 3
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            r13[r7] = r2     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            java.lang.String r11 = "type"
            r13[r10] = r11     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            java.lang.String r11 = "entry"
            r12 = 2
            r13[r12] = r11     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            java.lang.String r16 = "messages"
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid asc"
            r11 = 100
            java.lang.String r22 = java.lang.Integer.toString(r11)     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
            r11 = r24
            r6 = 2
            r12 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r22
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x01d1, SQLiteException -> 0x01cd, all -> 0x01c9 }
        L_0x00a0:
            boolean r12 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r12 == 0) goto L_0x017e
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r12 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            byte[] r13 = r11.getBlob(r6)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r12 != 0) goto L_0x00e9
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r14 = r13.length     // Catch:{ ParseException -> 0x00d2 }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x00d2 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00d2 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r13 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ ParseException -> 0x00d2 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzaw r13 = (com.google.android.gms.measurement.internal.zzaw) r13     // Catch:{ ParseException -> 0x00d2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r13 == 0) goto L_0x00a0
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x00d0:
            r0 = move-exception
            goto L_0x00e5
        L_0x00d2:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x00d0 }
            java.lang.String r14 = "Failed to load event from local database"
            r13.zza(r14)     // Catch:{ all -> 0x00d0 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x00e5:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x00e9:
            if (r12 != r10) goto L_0x0121
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r14 = r13.length     // Catch:{ ParseException -> 0x0104 }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x0104 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x0104 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r13 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ ParseException -> 0x0104 }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x0104 }
            com.google.android.gms.measurement.internal.zzkw r13 = (com.google.android.gms.measurement.internal.zzkw) r13     // Catch:{ ParseException -> 0x0104 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x0117
        L_0x0102:
            r0 = move-exception
            goto L_0x011d
        L_0x0104:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x0102 }
            java.lang.String r14 = "Failed to load user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x0102 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r13 = r4
        L_0x0117:
            if (r13 == 0) goto L_0x00a0
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x011d:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x0121:
            if (r12 != r6) goto L_0x015a
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r14 = r13.length     // Catch:{ ParseException -> 0x013c }
            r12.unmarshall(r13, r7, r14)     // Catch:{ ParseException -> 0x013c }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x013c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzac> r13 = com.google.android.gms.measurement.internal.zzac.CREATOR     // Catch:{ ParseException -> 0x013c }
            java.lang.Object r13 = r13.createFromParcel(r12)     // Catch:{ ParseException -> 0x013c }
            com.google.android.gms.measurement.internal.zzac r13 = (com.google.android.gms.measurement.internal.zzac) r13     // Catch:{ ParseException -> 0x013c }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x014f
        L_0x013a:
            r0 = move-exception
            goto L_0x0156
        L_0x013c:
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x013a }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ all -> 0x013a }
            java.lang.String r14 = "Failed to load conditional user property from local database"
            r13.zza(r14)     // Catch:{ all -> 0x013a }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r13 = r4
        L_0x014f:
            if (r13 == 0) goto L_0x00a0
            r5.add(r13)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x0156:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x015a:
            if (r12 != r0) goto L_0x016d
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzk()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r13 = "Skipping app launch break"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x016d:
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r13 = "Unknown record type in local database"
            r12.zza(r13)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a0
        L_0x017e:
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r6 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r0[r7] = r6     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r6 = "messages"
            java.lang.String r12 = "rowid <= ?"
            r13 = r24
            int r0 = r13.delete(r6, r12, r0)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            int r6 = r5.size()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            if (r0 >= r6) goto L_0x01a5
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            java.lang.String r6 = "Fewer entries removed from local database than expected"
            r0.zza(r6)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
        L_0x01a5:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01fb, SQLiteException -> 0x01b4, all -> 0x01b2 }
            r11.close()
            r13.close()
            return r5
        L_0x01b2:
            r0 = move-exception
            goto L_0x01bc
        L_0x01b4:
            r0 = move-exception
            goto L_0x01f7
        L_0x01b6:
            r0 = move-exception
            goto L_0x0200
        L_0x01b9:
            r0 = move-exception
            r13 = r24
        L_0x01bc:
            r4 = r11
            goto L_0x01f1
        L_0x01be:
            r0 = move-exception
            r13 = r24
            goto L_0x01f7
        L_0x01c2:
            r13 = r24
            goto L_0x01fb
        L_0x01c5:
            r0 = move-exception
            r13 = r24
            goto L_0x0200
        L_0x01c9:
            r0 = move-exception
            r13 = r24
            goto L_0x01f1
        L_0x01cd:
            r0 = move-exception
            r13 = r24
            goto L_0x01f6
        L_0x01d1:
            r13 = r24
            goto L_0x01fa
        L_0x01d4:
            r0 = move-exception
            r13 = r24
            goto L_0x01ff
        L_0x01d8:
            r0 = move-exception
            r13 = r24
            goto L_0x01e3
        L_0x01dc:
            r0 = move-exception
            r13 = r24
            goto L_0x01e2
        L_0x01e0:
            r0 = move-exception
            r13 = r15
        L_0x01e2:
            r11 = r4
        L_0x01e3:
            if (r11 == 0) goto L_0x01e8
            r11.close()     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01fa, SQLiteException -> 0x01eb, all -> 0x01e9 }
        L_0x01e8:
            throw r0     // Catch:{ SQLiteFullException -> 0x01ed, SQLiteDatabaseLockedException -> 0x01fa, SQLiteException -> 0x01eb, all -> 0x01e9 }
        L_0x01e9:
            r0 = move-exception
            goto L_0x01f1
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f6
        L_0x01ed:
            r0 = move-exception
            goto L_0x01ff
        L_0x01ef:
            r0 = move-exception
            r13 = r15
        L_0x01f1:
            r15 = r13
            goto L_0x025e
        L_0x01f4:
            r0 = move-exception
            r13 = r15
        L_0x01f6:
            r11 = r4
        L_0x01f7:
            r15 = r13
            goto L_0x0208
        L_0x01f9:
            r13 = r15
        L_0x01fa:
            r11 = r4
        L_0x01fb:
            r15 = r13
            goto L_0x022c
        L_0x01fd:
            r0 = move-exception
            r13 = r15
        L_0x01ff:
            r11 = r4
        L_0x0200:
            r15 = r13
            goto L_0x0240
        L_0x0202:
            r0 = move-exception
            r15 = r4
            goto L_0x025e
        L_0x0205:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0208:
            if (r15 == 0) goto L_0x0213
            boolean r6 = r15.inTransaction()     // Catch:{ all -> 0x025c }
            if (r6 == 0) goto L_0x0213
            r15.endTransaction()     // Catch:{ all -> 0x025c }
        L_0x0213:
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ all -> 0x025c }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x025c }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x025c }
            r6.zzb(r3, r0)     // Catch:{ all -> 0x025c }
            r1.zzb = r10     // Catch:{ all -> 0x025c }
            if (r11 == 0) goto L_0x0227
            r11.close()
        L_0x0227:
            if (r15 == 0) goto L_0x0257
            goto L_0x0239
        L_0x022a:
            r11 = r4
            r15 = r11
        L_0x022c:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x025c }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x0237
            r11.close()
        L_0x0237:
            if (r15 == 0) goto L_0x0257
        L_0x0239:
            r15.close()
            goto L_0x0257
        L_0x023d:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0240:
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ all -> 0x025c }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x025c }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x025c }
            r6.zzb(r3, r0)     // Catch:{ all -> 0x025c }
            r1.zzb = r10     // Catch:{ all -> 0x025c }
            if (r11 == 0) goto L_0x0254
            r11.close()
        L_0x0254:
            if (r15 == 0) goto L_0x0257
            goto L_0x0239
        L_0x0257:
            int r8 = r8 + 1
            r6 = 5
            goto L_0x001e
        L_0x025c:
            r0 = move-exception
            r4 = r11
        L_0x025e:
            if (r4 == 0) goto L_0x0263
            r4.close()
        L_0x0263:
            if (r15 == 0) goto L_0x0268
            r15.close()
        L_0x0268:
            throw r0
        L_0x0269:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r4
        L_0x0279:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzi(int):java.util.List");
    }

    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = zzh.delete("messages", (String) null, (String[]) null)) > 0) {
                this.zzt.zzay().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzb("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    @VisibleForTesting
    public final boolean zzl() {
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        return zzau.getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i10 = 0;
            int i11 = 5;
            while (i10 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzh.beginTransaction();
                    zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return true;
                } catch (SQLiteFullException e10) {
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e10);
                    this.zzb = true;
                    if (sQLiteDatabase == null) {
                        i10++;
                    }
                    sQLiteDatabase.close();
                    i10++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i11);
                    i11 += 20;
                    if (sQLiteDatabase == null) {
                        i10++;
                    }
                    sQLiteDatabase.close();
                    i10++;
                } catch (SQLiteException e11) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e11);
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i10++;
                    } else {
                        i10++;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            this.zzt.zzay().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzac) {
        byte[] zzan = this.zzt.zzv().zzan(zzac);
        if (zzan.length <= 131072) {
            return zzq(2, zzan);
        }
        this.zzt.zzay().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzaw zzaw) {
        Parcel obtain = Parcel.obtain();
        zzax.zza(zzaw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzt.zzay().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzkw zzkw) {
        Parcel obtain = Parcel.obtain();
        zzkx.zza(zzkw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzt.zzay().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
