package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzam extends zzkh {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzal zzj;
    /* access modifiers changed from: private */
    public final zzkd zzk = new zzkd(this.zzt.zzav());

    public zzam(zzkt zzkt) {
        super(zzkt);
        this.zzt.zzf();
        this.zzj = new zzal(this, this.zzt.zzau(), "google_app_measurement.db");
    }

    public static final void zzV(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zzh().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Database error", str, e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaa(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzh().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j11 = rawQuery.getLong(0);
                rawQuery.close();
                return j11;
            }
            rawQuery.close();
            return j10;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Database error", str, e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzA(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzd("Error deleting user property. appId", zzeh.zzn(str), this.zzt.zzj().zzf(str2), e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0331, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0345, code lost:
        if (zzh().insertWithOnConflict("property_filters", (java.lang.String) null, r11, 5) != -1) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0347, code lost:
        r1.zzt.zzay().zzd().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x035b, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x035f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1.zzt.zzay().zzd().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03aa, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0178, code lost:
        r11 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0184, code lost:
        if (r11.hasNext() == false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0190, code lost:
        if (((com.google.android.gms.internal.measurement.zzet) r11.next()).zzj() != false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        r1.zzt.zzay().zzk().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzeh.zzn(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ab, code lost:
        r11 = r0.zzg().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c1, code lost:
        if (r11.hasNext() == false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r12 = (com.google.android.gms.internal.measurement.zzek) r11.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01dd, code lost:
        if (r12.zzg().isEmpty() == false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01df, code lost:
        r0 = r1.zzt.zzay().zzk();
        r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f7, code lost:
        if (r12.zzp() == false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f9, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0204, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0206, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r20));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0211, code lost:
        r3 = r12.zzbu();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022a, code lost:
        if (r12.zzp() == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022c, code lost:
        r9 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0235, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0236, code lost:
        r7.put("filter_id", r9);
        r7.put("event_name", r12.zzg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0246, code lost:
        if (r12.zzq() == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0248, code lost:
        r9 = java.lang.Boolean.valueOf(r12.zzn());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0251, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0252, code lost:
        r7.put("session_scoped", r9);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0266, code lost:
        if (zzh().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0268, code lost:
        r1.zzt.zzay().zzd().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzeh.zzn(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027b, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0297, code lost:
        r21 = r7;
        r0 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a5, code lost:
        if (r0.hasNext() == false) goto L_0x03aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a7, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzet) r0.next();
        zzW();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c1, code lost:
        if (r3.zze().isEmpty() == false) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c3, code lost:
        r0 = r1.zzt.zzay().zzk();
        r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24);
        r9 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02db, code lost:
        if (r3.zzj() == false) goto L_0x02e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02dd, code lost:
        r3 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e6, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02e7, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r9, java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f0, code lost:
        r7 = r3.zzbu();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r2);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0307, code lost:
        if (r3.zzj() == false) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0309, code lost:
        r12 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0312, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0313, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.zze());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0325, code lost:
        if (r3.zzk() == false) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0327, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0330, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzei r9 = (com.google.android.gms.internal.measurement.zzei) r9
            com.google.android.gms.internal.measurement.zzkb r9 = r9.zzby()
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            int r11 = r9.zza()
            if (r11 == 0) goto L_0x009d
            r11 = 0
        L_0x002b:
            int r12 = r9.zza()
            if (r11 >= r12) goto L_0x009d
            com.google.android.gms.internal.measurement.zzek r12 = r9.zze(r11)
            com.google.android.gms.internal.measurement.zzkb r12 = r12.zzby()
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12
            com.google.android.gms.internal.measurement.zzkb r13 = r12.zzau()
            com.google.android.gms.internal.measurement.zzej r13 = (com.google.android.gms.internal.measurement.zzej) r13
            java.lang.String r14 = r12.zze()
            java.lang.String r14 = com.google.android.gms.measurement.internal.zzgo.zzb(r14)
            if (r14 == 0) goto L_0x0050
            r13.zzb(r14)
            r14 = 1
            goto L_0x0051
        L_0x0050:
            r14 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r10 = r12.zza()
            if (r15 >= r10) goto L_0x0088
            com.google.android.gms.internal.measurement.zzem r10 = r12.zzd(r15)
            java.lang.String r7 = r10.zze()
            r16 = r12
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzgp.zza
            r17 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgp.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzid.zzb(r7, r12, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzkb r7 = r10.zzby()
            com.google.android.gms.internal.measurement.zzel r7 = (com.google.android.gms.internal.measurement.zzel) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzkf r4 = r7.zzaC()
            com.google.android.gms.internal.measurement.zzem r4 = (com.google.android.gms.internal.measurement.zzem) r4
            r13.zzc(r15, r4)
            r14 = 1
        L_0x0081:
            int r15 = r15 + 1
            r12 = r16
            r4 = r17
            goto L_0x0052
        L_0x0088:
            r17 = r4
            if (r14 == 0) goto L_0x0098
            r9.zzc(r11, r13)
            com.google.android.gms.internal.measurement.zzkf r4 = r9.zzaC()
            com.google.android.gms.internal.measurement.zzei r4 = (com.google.android.gms.internal.measurement.zzei) r4
            r3.set(r8, r4)
        L_0x0098:
            int r11 = r11 + 1
            r4 = r17
            goto L_0x002b
        L_0x009d:
            r17 = r4
            int r4 = r9.zzb()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zzb()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzet r7 = r9.zzf(r4)
            java.lang.String r10 = r7.zze()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgq.zza
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzgq.zzb
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzid.zzb(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzkb r7 = r7.zzby()
            com.google.android.gms.internal.measurement.zzes r7 = (com.google.android.gms.internal.measurement.zzes) r7
            r7.zza(r10)
            r9.zzd(r4, r7)
            com.google.android.gms.internal.measurement.zzkf r7 = r9.zzaC()
            com.google.android.gms.internal.measurement.zzei r7 = (com.google.android.gms.internal.measurement.zzei) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r17
            goto L_0x0012
        L_0x00dc:
            r17 = r4
            r23.zzW()
            r23.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.zzh()
            r4.beginTransaction()
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            android.database.sqlite.SQLiteDatabase r7 = r23.zzh()     // Catch:{ all -> 0x0491 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0491 }
            r7.delete(r6, r0, r8)     // Catch:{ all -> 0x0491 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0491 }
            r7.delete(r5, r0, r8)     // Catch:{ all -> 0x0491 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0491 }
        L_0x0110:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0491 }
            if (r0 == 0) goto L_0x03b0
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ all -> 0x0491 }
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0491 }
            boolean r10 = r0.zzk()     // Catch:{ all -> 0x0491 }
            if (r10 != 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            r0.zzb(r8, r9)     // Catch:{ all -> 0x0491 }
            goto L_0x0110
        L_0x0142:
            int r10 = r0.zza()     // Catch:{ all -> 0x0491 }
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0491 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0491 }
        L_0x014e:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0491 }
            if (r12 == 0) goto L_0x0178
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0491 }
            boolean r12 = r12.zzp()     // Catch:{ all -> 0x0491 }
            if (r12 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r0.zzc(r8, r9, r10)     // Catch:{ all -> 0x0491 }
            goto L_0x0110
        L_0x0178:
            java.util.List r11 = r0.zzh()     // Catch:{ all -> 0x0491 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0491 }
        L_0x0180:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0491 }
            if (r12 == 0) goto L_0x01ab
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzet r12 = (com.google.android.gms.internal.measurement.zzet) r12     // Catch:{ all -> 0x0491 }
            boolean r12 = r12.zzj()     // Catch:{ all -> 0x0491 }
            if (r12 != 0) goto L_0x0180
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r0.zzc(r8, r9, r10)     // Catch:{ all -> 0x0491 }
            goto L_0x0110
        L_0x01ab:
            java.util.List r11 = r0.zzg()     // Catch:{ all -> 0x0491 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0491 }
        L_0x01b3:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = "data"
            java.lang.String r13 = "session_scoped"
            java.lang.String r14 = "filter_id"
            java.lang.String r9 = "audience_id"
            java.lang.String r15 = "app_id"
            if (r12 == 0) goto L_0x0297
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzek r12 = (com.google.android.gms.internal.measurement.zzek) r12     // Catch:{ all -> 0x0491 }
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)     // Catch:{ all -> 0x0491 }
            java.lang.String r21 = r12.zzg()     // Catch:{ all -> 0x0491 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0491 }
            if (r21 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            boolean r13 = r12.zzp()     // Catch:{ all -> 0x0491 }
            if (r13 == 0) goto L_0x0204
            int r12 = r12.zzb()     // Catch:{ all -> 0x0491 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0491 }
            r20 = r12
            goto L_0x0206
        L_0x0204:
            r20 = 0
        L_0x0206:
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x0491 }
            r0.zzd(r8, r9, r11, r12)     // Catch:{ all -> 0x0491 }
            r21 = r7
            goto L_0x0373
        L_0x0211:
            byte[] r3 = r12.zzbu()     // Catch:{ all -> 0x0491 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0491 }
            r7.<init>()     // Catch:{ all -> 0x0491 }
            r7.put(r15, r2)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r7.put(r9, r15)     // Catch:{ all -> 0x0491 }
            boolean r9 = r12.zzp()     // Catch:{ all -> 0x0491 }
            if (r9 == 0) goto L_0x0235
            int r9 = r12.zzb()     // Catch:{ all -> 0x0491 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0491 }
            goto L_0x0236
        L_0x0235:
            r9 = 0
        L_0x0236:
            r7.put(r14, r9)     // Catch:{ all -> 0x0491 }
            java.lang.String r9 = "event_name"
            java.lang.String r14 = r12.zzg()     // Catch:{ all -> 0x0491 }
            r7.put(r9, r14)     // Catch:{ all -> 0x0491 }
            boolean r9 = r12.zzq()     // Catch:{ all -> 0x0491 }
            if (r9 == 0) goto L_0x0251
            boolean r9 = r12.zzn()     // Catch:{ all -> 0x0491 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0491 }
            goto L_0x0252
        L_0x0251:
            r9 = 0
        L_0x0252:
            r7.put(r13, r9)     // Catch:{ all -> 0x0491 }
            r7.put(r8, r3)     // Catch:{ all -> 0x0491 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ SQLiteException -> 0x0281 }
            r8 = 5
            r9 = 0
            long r7 = r3.insertWithOnConflict(r5, r9, r7, r8)     // Catch:{ SQLiteException -> 0x0281 }
            r12 = -1
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x027b
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ SQLiteException -> 0x0281 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0281 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0281 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ SQLiteException -> 0x0281 }
            r3.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0281 }
        L_0x027b:
            r3 = r25
            r7 = r21
            goto L_0x01b3
        L_0x0281:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0491 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0491 }
            goto L_0x0373
        L_0x0297:
            r21 = r7
            java.util.List r0 = r0.zzh()     // Catch:{ all -> 0x0491 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0491 }
        L_0x02a1:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0491 }
            if (r3 == 0) goto L_0x03aa
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzet r3 = (com.google.android.gms.internal.measurement.zzet) r3     // Catch:{ all -> 0x0491 }
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0491 }
            java.lang.String r7 = r3.zze()     // Catch:{ all -> 0x0491 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0491 }
            if (r7 == 0) goto L_0x02f0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0491 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            boolean r11 = r3.zzj()     // Catch:{ all -> 0x0491 }
            if (r11 == 0) goto L_0x02e6
            int r3 = r3.zza()     // Catch:{ all -> 0x0491 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0491 }
            goto L_0x02e7
        L_0x02e6:
            r3 = 0
        L_0x02e7:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0491 }
            r0.zzd(r7, r8, r9, r3)     // Catch:{ all -> 0x0491 }
            goto L_0x0373
        L_0x02f0:
            byte[] r7 = r3.zzbu()     // Catch:{ all -> 0x0491 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ all -> 0x0491 }
            r11.<init>()     // Catch:{ all -> 0x0491 }
            r11.put(r15, r2)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r11.put(r9, r12)     // Catch:{ all -> 0x0491 }
            boolean r12 = r3.zzj()     // Catch:{ all -> 0x0491 }
            if (r12 == 0) goto L_0x0312
            int r12 = r3.zza()     // Catch:{ all -> 0x0491 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0491 }
            goto L_0x0313
        L_0x0312:
            r12 = 0
        L_0x0313:
            r11.put(r14, r12)     // Catch:{ all -> 0x0491 }
            java.lang.String r12 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zze()     // Catch:{ all -> 0x0491 }
            r11.put(r12, r0)     // Catch:{ all -> 0x0491 }
            boolean r0 = r3.zzk()     // Catch:{ all -> 0x0491 }
            if (r0 == 0) goto L_0x0330
            boolean r0 = r3.zzi()     // Catch:{ all -> 0x0491 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0491 }
            goto L_0x0331
        L_0x0330:
            r0 = 0
        L_0x0331:
            r11.put(r13, r0)     // Catch:{ all -> 0x0491 }
            r11.put(r8, r7)     // Catch:{ all -> 0x0491 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ SQLiteException -> 0x035f }
            r3 = 0
            r7 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r11, r7)     // Catch:{ SQLiteException -> 0x035f }
            r18 = -1
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x035f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x035f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x035f }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ SQLiteException -> 0x035f }
            r0.zzb(r3, r7)     // Catch:{ SQLiteException -> 0x035f }
            goto L_0x0373
        L_0x035b:
            r0 = r22
            goto L_0x02a1
        L_0x035f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0491 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0491 }
        L_0x0373:
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zzh()     // Catch:{ all -> 0x0491 }
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0491 }
            r3 = 0
            r7[r3] = r2     // Catch:{ all -> 0x0491 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r8 = 1
            r7[r8] = r3     // Catch:{ all -> 0x0491 }
            r3 = r17
            r0.delete(r6, r3, r7)     // Catch:{ all -> 0x0491 }
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x0491 }
            r8 = 0
            r7[r8] = r2     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0491 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0491 }
            r0.delete(r5, r3, r7)     // Catch:{ all -> 0x0491 }
            r17 = r3
            r7 = r21
            r3 = r25
            goto L_0x0110
        L_0x03aa:
            r3 = r25
            r7 = r21
            goto L_0x0110
        L_0x03b0:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0491 }
            r0.<init>()     // Catch:{ all -> 0x0491 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0491 }
        L_0x03ba:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0491 }
            if (r6 == 0) goto L_0x03da
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.internal.measurement.zzei r6 = (com.google.android.gms.internal.measurement.zzei) r6     // Catch:{ all -> 0x0491 }
            boolean r7 = r6.zzk()     // Catch:{ all -> 0x0491 }
            if (r7 == 0) goto L_0x03d5
            int r6 = r6.zza()     // Catch:{ all -> 0x0491 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0491 }
            goto L_0x03d6
        L_0x03d5:
            r9 = r3
        L_0x03d6:
            r0.add(r9)     // Catch:{ all -> 0x0491 }
            goto L_0x03ba
        L_0x03da:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0491 }
            r23.zzW()     // Catch:{ all -> 0x0491 }
            r23.zzg()     // Catch:{ all -> 0x0491 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zzh()     // Catch:{ all -> 0x0491 }
            java.lang.String[] r5 = new java.lang.String[]{r24}     // Catch:{ SQLiteException -> 0x0476 }
            java.lang.String r6 = "select count(1) from audience_filter_values where app_id=?"
            long r5 = r1.zzZ(r6, r5)     // Catch:{ SQLiteException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzfr r7 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzag r7 = r7.zzf()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzE     // Catch:{ all -> 0x0491 }
            int r7 = r7.zze(r2, r8)     // Catch:{ all -> 0x0491 }
            r8 = 2000(0x7d0, float:2.803E-42)
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0491 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0491 }
            long r8 = (long) r7     // Catch:{ all -> 0x0491 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x040f
            goto L_0x048a
        L_0x040f:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0491 }
            r5.<init>()     // Catch:{ all -> 0x0491 }
            r6 = 0
        L_0x0415:
            int r8 = r0.size()     // Catch:{ all -> 0x0491 }
            if (r6 >= r8) goto L_0x0431
            java.lang.Object r8 = r0.get(r6)     // Catch:{ all -> 0x0491 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0491 }
            if (r8 == 0) goto L_0x048a
            int r8 = r8.intValue()     // Catch:{ all -> 0x0491 }
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0491 }
            r5.add(r8)     // Catch:{ all -> 0x0491 }
            int r6 = r6 + 1
            goto L_0x0415
        L_0x0431:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0491 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0491 }
            r5.<init>()     // Catch:{ all -> 0x0491 }
            java.lang.String r6 = "("
            r5.append(r6)     // Catch:{ all -> 0x0491 }
            r5.append(r0)     // Catch:{ all -> 0x0491 }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x0491 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0491 }
            r0.<init>()     // Catch:{ all -> 0x0491 }
            java.lang.String r6 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r0.append(r6)     // Catch:{ all -> 0x0491 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0491 }
            r0.append(r5)     // Catch:{ all -> 0x0491 }
            java.lang.String r5 = " order by rowid desc limit -1 offset ?)"
            r0.append(r5)     // Catch:{ all -> 0x0491 }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0491 }
            r6 = 0
            r5[r6] = r2     // Catch:{ all -> 0x0491 }
            java.lang.String r2 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0491 }
            r6 = 1
            r5[r6] = r2     // Catch:{ all -> 0x0491 }
            java.lang.String r2 = "audience_filter_values"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0491 }
            r3.delete(r2, r0, r5)     // Catch:{ all -> 0x0491 }
            goto L_0x048a
        L_0x0476:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0491 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0491 }
            r3.zzc(r5, r2, r0)     // Catch:{ all -> 0x0491 }
        L_0x048a:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0491 }
            r4.endTransaction()
            return
        L_0x0491:
            r0 = move-exception
            r4.endTransaction()
            goto L_0x0497
        L_0x0496:
            throw r0
        L_0x0497:
            goto L_0x0496
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzB(java.lang.String, java.util.List):void");
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    public final void zzD(zzh zzh2) {
        Preconditions.checkNotNull(zzh2);
        zzg();
        zzW();
        String zzt = zzh2.zzt();
        Preconditions.checkNotNull(zzt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzt);
        contentValues.put("app_instance_id", zzh2.zzu());
        contentValues.put("gmp_app_id", zzh2.zzy());
        contentValues.put("resettable_device_id_hash", zzh2.zzA());
        contentValues.put("last_bundle_index", Long.valueOf(zzh2.zzo()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzh2.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzh2.zzn()));
        contentValues.put("app_version", zzh2.zzw());
        contentValues.put("app_store", zzh2.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzh2.zzm()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzh2.zzj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzh2.zzai()));
        contentValues.put("day", Long.valueOf(zzh2.zzi()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzh2.zzg()));
        contentValues.put("daily_events_count", Long.valueOf(zzh2.zzf()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzh2.zzd()));
        contentValues.put("config_fetched_time", Long.valueOf(zzh2.zzc()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzh2.zzl()));
        contentValues.put("app_version_int", Long.valueOf(zzh2.zzb()));
        contentValues.put("firebase_instance_id", zzh2.zzx());
        contentValues.put("daily_error_events_count", Long.valueOf(zzh2.zze()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzh2.zzh()));
        contentValues.put("health_monitor_sample", zzh2.zzz());
        zzh2.zza();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzh2.zzah()));
        contentValues.put("admob_app_id", zzh2.zzr());
        contentValues.put("dynamite_version", Long.valueOf(zzh2.zzk()));
        contentValues.put("session_stitching_token", zzh2.zzB());
        List zzC = zzh2.zzC();
        if (zzC != null) {
            if (zzC.isEmpty()) {
                this.zzt.zzay().zzk().zzb("Safelisted events should not be an empty list. appId", zzt);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzC));
            }
        }
        zznt.zzc();
        if (this.zzt.zzf().zzs((String) null, zzdu.zzai) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase zzh3 = zzh();
            if (((long) zzh3.update("apps", contentValues, "app_id = ?", new String[]{zzt})) == 0 && zzh3.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.zzt.zzay().zzd().zzb("Failed to insert/update app (got -1). appId", zzeh.zzn(zzt));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing app. appId", zzeh.zzn(zzt), e10);
        }
    }

    public final void zzE(zzas zzas) {
        long j10;
        Preconditions.checkNotNull(zzas);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzas.zza);
        contentValues.put("name", zzas.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzas.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzas.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzas.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzas.zzg));
        contentValues.put("last_bundled_day", zzas.zzh);
        contentValues.put("last_sampled_complex_event_id", zzas.zzi);
        contentValues.put("last_sampling_rate", zzas.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzas.zze));
        Boolean bool = zzas.zzk;
        if (bool == null || !bool.booleanValue()) {
            j10 = null;
        } else {
            j10 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j10);
        try {
            if (zzh().insertWithOnConflict(f.ax, (String) null, contentValues, 5) == -1) {
                this.zzt.zzay().zzd().zzb("Failed to insert/update event aggregates (got -1). appId", zzeh.zzn(zzas.zza));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing event aggregates. appId", zzeh.zzn(zzas.zza), e10);
        }
    }

    public final boolean zzF() {
        if (zzZ("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzG() {
        if (zzZ("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzH() {
        if (zzZ("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public final boolean zzI() {
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        return zzau.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zzJ(String str, Long l10, long j10, zzft zzft) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzft);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l10);
        byte[] zzbu = zzft.zzbu();
        this.zzt.zzay().zzj().zzc("Saving complex main event, appId, data size", this.zzt.zzj().zzd(str), Integer.valueOf(zzbu.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(SourceDataReport.KEY_ERREPORT_EVENTID, l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", zzbu);
        try {
            if (zzh().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert complex main event (got -1). appId", zzeh.zzn(str));
            return false;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing complex main event. appId", zzeh.zzn(str), e10);
            return false;
        }
    }

    public final boolean zzK(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zzW();
        String str = zzac.zza;
        Preconditions.checkNotNull(str);
        if (zzp(str, zzac.zzc.zzb) == null) {
            long zzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzt.zzf();
            if (zzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzac.zzb);
        contentValues.put("name", zzac.zzc.zzb);
        zzV(contentValues, "value", Preconditions.checkNotNull(zzac.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzac.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzac.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzac.zzh));
        contentValues.put("timed_out_event", this.zzt.zzv().zzan(zzac.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzac.zzd));
        contentValues.put("triggered_event", this.zzt.zzv().zzan(zzac.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzac.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzac.zzj));
        contentValues.put("expired_event", this.zzt.zzv().zzan(zzac.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert/update conditional user property (got -1)", zzeh.zzn(str));
            return true;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing conditional user property", zzeh.zzn(str), e10);
            return true;
        }
    }

    public final boolean zzL(zzky zzky) {
        Preconditions.checkNotNull(zzky);
        zzg();
        zzW();
        if (zzp(zzky.zza, zzky.zzc) == null) {
            if (zzlb.zzai(zzky.zzc)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzky.zza}) >= ((long) this.zzt.zzf().zzf(zzky.zza, zzdu.zzF, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzky.zzc)) {
                long zzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzky.zza, zzky.zzb});
                this.zzt.zzf();
                if (zzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzky.zza);
        contentValues.put("origin", zzky.zzb);
        contentValues.put("name", zzky.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzky.zzd));
        zzV(contentValues, "value", zzky.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzt.zzay().zzd().zzb("Failed to insert/update user property (got -1). appId", zzeh.zzn(zzky.zza));
            return true;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error storing user property. appId", zzeh.zzn(zzky.zza), e10);
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0040=Splitter:B:13:0x0040, B:31:0x008c=Splitter:B:31:0x008c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzU(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzkq r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r20.zzg()
            r20.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.zzh()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r5 = ""
            r13 = 2
            r14 = -1
            r12 = 1
            r11 = 0
            if (r4 == 0) goto L_0x0073
            int r4 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r4 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r4[r11] = r6     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r4[r12] = r6     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r4 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r4[r11] = r6     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
        L_0x003a:
            int r6 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0040
            java.lang.String r5 = "rowid <= ? and "
        L_0x0040:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r5 = r6.toString()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            android.database.Cursor r4 = r0.rawQuery(r5, r4)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0070 }
            if (r5 != 0) goto L_0x0064
            r4.close()
            return
        L_0x0064:
            java.lang.String r3 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0070 }
            r4.close()     // Catch:{ SQLiteException -> 0x0070 }
            goto L_0x00b7
        L_0x0070:
            r0 = move-exception
            goto L_0x0214
        L_0x0073:
            int r4 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0082
            java.lang.String[] r4 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r4[r11] = r3     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r4[r12] = r6     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            goto L_0x0086
        L_0x0082:
            java.lang.String[] r4 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
        L_0x0086:
            int r6 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x008c
            java.lang.String r5 = " and rowid <= ?"
        L_0x008c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r5 = " order by rowid limit 1;"
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            java.lang.String r5 = r6.toString()     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            android.database.Cursor r4 = r0.rawQuery(r5, r4)     // Catch:{ SQLiteException -> 0x0212, all -> 0x0210 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0070 }
            if (r5 != 0) goto L_0x00b0
            r4.close()
            return
        L_0x00b0:
            java.lang.String r5 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0070 }
            r4.close()     // Catch:{ SQLiteException -> 0x0070 }
        L_0x00b7:
            r16 = r4
            r10 = r5
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x020c, all -> 0x0208 }
            java.lang.String r4 = "metadata"
            r6[r11] = r4     // Catch:{ SQLiteException -> 0x020c, all -> 0x0208 }
            java.lang.String[] r8 = new java.lang.String[]{r3, r10}     // Catch:{ SQLiteException -> 0x020c, all -> 0x0208 }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r9 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r13 = r10
            r10 = r17
            r14 = 0
            r11 = r18
            r15 = 1
            r12 = r19
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x020c, all -> 0x0208 }
            boolean r4 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            if (r4 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r12.close()
            return
        L_0x00fa:
            byte[] r4 = r12.getBlob(r14)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.internal.measurement.zzgc r5 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ IOException -> 0x01e3 }
            com.google.android.gms.internal.measurement.zzll r4 = com.google.android.gms.measurement.internal.zzkv.zzl(r5, r4)     // Catch:{ IOException -> 0x01e3 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ IOException -> 0x01e3 }
            com.google.android.gms.internal.measurement.zzkf r4 = r4.zzaC()     // Catch:{ IOException -> 0x01e3 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ IOException -> 0x01e3 }
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            if (r5 == 0) goto L_0x0127
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
        L_0x0127:
            r12.close()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r2.zza = r4     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r11 = 3
            r4 = -1
            int r6 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0146
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r5[r14] = r3     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r5[r15] = r13     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r7 = 2
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            goto L_0x014c
        L_0x0146:
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r5 = new java.lang.String[]{r3, r13}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
        L_0x014c:
            r7 = r4
            r8 = r5
            r4 = 4
            java.lang.String[] r6 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r4 = "rowid"
            r6[r14] = r4     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r4 = "name"
            r6[r15] = r4     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r4 = "timestamp"
            r5 = 2
            r6[r5] = r4     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r4 = "data"
            r6[r11] = r4     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r5 = "raw_events"
            r9 = 0
            r10 = 0
            java.lang.String r13 = "rowid"
            r16 = 0
            r4 = r0
            r15 = 3
            r11 = r13
            r13 = r12
            r12 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0070 }
            if (r0 == 0) goto L_0x01cc
        L_0x017a:
            long r5 = r4.getLong(r14)     // Catch:{ SQLiteException -> 0x0070 }
            byte[] r0 = r4.getBlob(r15)     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x01ac }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r7, r0)     // Catch:{ IOException -> 0x01ac }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ IOException -> 0x01ac }
            r7 = 1
            java.lang.String r8 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x0070 }
            r0.zzi(r8)     // Catch:{ SQLiteException -> 0x0070 }
            r8 = 2
            long r9 = r4.getLong(r8)     // Catch:{ SQLiteException -> 0x0070 }
            r0.zzm(r9)     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0     // Catch:{ SQLiteException -> 0x0070 }
            boolean r0 = r2.zza(r5, r0)     // Catch:{ SQLiteException -> 0x0070 }
            if (r0 != 0) goto L_0x01c2
            r4.close()
            return
        L_0x01ac:
            r0 = move-exception
            r7 = 1
            r8 = 2
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0070 }
            r5.zzc(r6, r9, r0)     // Catch:{ SQLiteException -> 0x0070 }
        L_0x01c2:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0070 }
            if (r0 != 0) goto L_0x017a
            r4.close()
            return
        L_0x01cc:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0070 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0070 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0070 }
            r0.zzb(r2, r5)     // Catch:{ SQLiteException -> 0x0070 }
            r4.close()
            return
        L_0x01e3:
            r0 = move-exception
            r13 = r12
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fc }
            r13.close()
            return
        L_0x01fc:
            r0 = move-exception
            goto L_0x0202
        L_0x01fe:
            r0 = move-exception
            goto L_0x0206
        L_0x0200:
            r0 = move-exception
            r13 = r12
        L_0x0202:
            r3 = r13
            goto L_0x022f
        L_0x0204:
            r0 = move-exception
            r13 = r12
        L_0x0206:
            r4 = r13
            goto L_0x0214
        L_0x0208:
            r0 = move-exception
            r3 = r16
            goto L_0x022f
        L_0x020c:
            r0 = move-exception
            r4 = r16
            goto L_0x0214
        L_0x0210:
            r0 = move-exception
            goto L_0x022f
        L_0x0212:
            r0 = move-exception
            r4 = r3
        L_0x0214:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x022d }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x022d }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x022d }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x022d }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x022d }
            if (r4 == 0) goto L_0x022c
            r4.close()
        L_0x022c:
            return
        L_0x022d:
            r0 = move-exception
            r3 = r4
        L_0x022f:
            if (r3 == 0) goto L_0x0234
            r3.close()
        L_0x0234:
            goto L_0x0236
        L_0x0235:
            throw r0
        L_0x0236:
            goto L_0x0235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzU(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzkq):void");
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            return zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzd("Error deleting conditional property", zzeh.zzn(str), this.zzt.zzj().zzf(str2), e10);
            return 0;
        }
    }

    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    public final long zzc(String str, String str2) {
        String str3 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh2 = zzh();
        zzh2.beginTransaction();
        long j10 = 0;
        try {
            long zzaa = zzaa("select " + "first_open_count" + " from app2 where app_id=?", new String[]{str}, -1);
            if (zzaa == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zzh2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzt.zzay().zzd().zzc("Failed to insert column (got -1). appId", zzeh.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                zzaa = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put("first_open_count", Long.valueOf(1 + zzaa));
                if (((long) zzh2.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.zzt.zzay().zzd().zzc("Failed to update column (got 0). appId", zzeh.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                zzh2.setTransactionSuccessful();
                zzh2.endTransaction();
                return zzaa;
            } catch (SQLiteException e10) {
                e = e10;
                j10 = zzaa;
                try {
                    this.zzt.zzay().zzd().zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e);
                    zzh2.endTransaction();
                    return j10;
                } catch (Throwable th) {
                    zzh2.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e11) {
            e = e11;
            this.zzt.zzay().zzd().zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e);
            zzh2.endTransaction();
            return j10;
        }
    }

    public final long zzd() {
        return zzaa("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zze() {
        return zzaa("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zzf(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @VisibleForTesting
    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzk().zzb("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzW()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zzh()     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            java.lang.String r3 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r3, r2)     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r2 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzfr r8 = r7.zzt     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzj()     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00b9 }
            r1.close()
            return r0
        L_0x002e:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.internal.measurement.zzfs r3 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzll r2 = com.google.android.gms.measurement.internal.zzkv.zzl(r3, r2)     // Catch:{ IOException -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ IOException -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzkf r2 = r2.zzaC()     // Catch:{ IOException -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ IOException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzkt r8 = r7.zzf     // Catch:{ SQLiteException -> 0x00b9 }
            r8.zzu()     // Catch:{ SQLiteException -> 0x00b9 }
            java.util.List r8 = r2.zzi()     // Catch:{ SQLiteException -> 0x00b9 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00b9 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00b9 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00b9 }
        L_0x0055:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r3 == 0) goto L_0x009d
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x00b9 }
            boolean r5 = r3.zzu()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r5 == 0) goto L_0x0073
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x00b9 }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00b9 }
            goto L_0x0055
        L_0x0073:
            boolean r5 = r3.zzv()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r5 == 0) goto L_0x0081
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00b9 }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00b9 }
            goto L_0x0055
        L_0x0081:
            boolean r5 = r3.zzy()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r5 == 0) goto L_0x008f
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00b9 }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00b9 }
            goto L_0x0055
        L_0x008f:
            boolean r5 = r3.zzw()     // Catch:{ SQLiteException -> 0x00b9 }
            if (r5 == 0) goto L_0x0055
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x00b9 }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00b9 }
            goto L_0x0055
        L_0x009d:
            r1.close()
            return r2
        L_0x00a1:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r7.zzt     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00b9 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x00b9 }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00b9 }
            r1.close()
            return r0
        L_0x00b9:
            r8 = move-exception
            goto L_0x00bf
        L_0x00bb:
            r8 = move-exception
            goto L_0x00d6
        L_0x00bd:
            r8 = move-exception
            r1 = r0
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzfr r2 = r7.zzt     // Catch:{ all -> 0x00d4 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x00d4 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00d4 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x00d3
            r1.close()
        L_0x00d3:
            return r0
        L_0x00d4:
            r8 = move-exception
            r0 = r1
        L_0x00d6:
            if (r0 == 0) goto L_0x00db
            r0.close()
        L_0x00db:
            goto L_0x00dd
        L_0x00dc:
            throw r8
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzi(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0196 A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x019a A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01e9 A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01ec A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01fb A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x023e A[Catch:{ SQLiteException -> 0x0255 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0278  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzh zzj(java.lang.String r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r23.zzg()
            r23.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r23.zzh()     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            r0 = 29
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "app_instance_id"
            r12 = 0
            r6[r12] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "gmp_app_id"
            r13 = 1
            r6[r13] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "resettable_device_id_hash"
            r14 = 2
            r6[r14] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "last_bundle_index"
            r15 = 3
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r11 = 4
            r6[r11] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r10 = 5
            r6[r10] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "app_version"
            r9 = 6
            r6[r9] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "app_store"
            r8 = 7
            r6[r8] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "gmp_version"
            r7 = 8
            r6[r7] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "dev_cert_hash"
            r5 = 9
            r6[r5] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "measurement_enabled"
            r15 = 10
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "day"
            r15 = 11
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "daily_public_events_count"
            r15 = 12
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "daily_events_count"
            r15 = 13
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "daily_conversions_count"
            r15 = 14
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "config_fetched_time"
            r15 = 15
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "failed_config_fetch_time"
            r15 = 16
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "app_version_int"
            r15 = 17
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "firebase_instance_id"
            r16 = 18
            r6[r16] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "daily_error_events_count"
            r16 = 19
            r6[r16] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "daily_realtime_events_count"
            r16 = 20
            r6[r16] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "health_monitor_sample"
            r16 = 21
            r6[r16] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "android_id"
            r16 = 22
            r6[r16] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "adid_reporting_enabled"
            r15 = 23
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "admob_app_id"
            r17 = 24
            r6[r17] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "dynamite_version"
            r15 = 25
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "safelisted_events"
            r15 = 26
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "ga_app_id"
            r18 = 27
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r0 = "session_stitching_token"
            r18 = 28
            r6[r18] = r0     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String[] r0 = new java.lang.String[]{r24}     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            java.lang.String r18 = "apps"
            java.lang.String r19 = "app_id=?"
            r20 = 0
            r21 = 0
            r22 = 0
            r15 = 9
            r5 = r18
            r15 = 8
            r7 = r19
            r15 = 7
            r8 = r0
            r0 = 6
            r9 = r20
            r15 = 5
            r10 = r21
            r0 = 4
            r11 = r22
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0259, all -> 0x0257 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0255 }
            if (r5 != 0) goto L_0x00eb
            r4.close()
            return r3
        L_0x00eb:
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzkt r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzq()     // Catch:{ SQLiteException -> 0x0255 }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x0255 }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzH(r6)     // Catch:{ SQLiteException -> 0x0255 }
            java.lang.String r6 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzW(r6)     // Catch:{ SQLiteException -> 0x0255 }
            java.lang.String r6 = r4.getString(r14)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzae(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzaa(r6)     // Catch:{ SQLiteException -> 0x0255 }
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzab(r6)     // Catch:{ SQLiteException -> 0x0255 }
            long r6 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzZ(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 6
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzJ(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 7
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzI(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 8
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzX(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 9
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzS(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 10
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r6 != 0) goto L_0x0154
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r0 == 0) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            r0 = 0
            goto L_0x0155
        L_0x0154:
            r0 = 1
        L_0x0155:
            r5.zzac(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 11
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzR(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 12
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzP(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 13
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzO(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 14
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzM(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 15
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzL(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 16
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzU(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 17
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r6 == 0) goto L_0x019a
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x019f
        L_0x019a:
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0255 }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x0255 }
        L_0x019f:
            r5.zzK(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 18
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzV(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 19
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzN(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 20
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzQ(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 21
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzY(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 23
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r6 != 0) goto L_0x01d4
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r0 == 0) goto L_0x01d5
        L_0x01d4:
            r12 = 1
        L_0x01d5:
            r5.zzG(r12)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 24
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzF(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 25
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r6 == 0) goto L_0x01ec
            r6 = 0
            goto L_0x01f0
        L_0x01ec:
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0255 }
        L_0x01f0:
            r5.zzT(r6)     // Catch:{ SQLiteException -> 0x0255 }
            r0 = 26
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0255 }
            if (r6 != 0) goto L_0x020d
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x0255 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzaf(r0)     // Catch:{ SQLiteException -> 0x0255 }
        L_0x020d:
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzdt r6 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ SQLiteException -> 0x0255 }
            boolean r0 = r0.zzs(r3, r6)     // Catch:{ SQLiteException -> 0x0255 }
            if (r0 == 0) goto L_0x0235
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzdt r6 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ SQLiteException -> 0x0255 }
            boolean r0 = r0.zzs(r2, r6)     // Catch:{ SQLiteException -> 0x0255 }
            if (r0 == 0) goto L_0x0235
            r0 = 28
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0255 }
            r5.zzag(r0)     // Catch:{ SQLiteException -> 0x0255 }
        L_0x0235:
            r5.zzD()     // Catch:{ SQLiteException -> 0x0255 }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0255 }
            if (r0 == 0) goto L_0x0251
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0255 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0255 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ SQLiteException -> 0x0255 }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0255 }
        L_0x0251:
            r4.close()
            return r5
        L_0x0255:
            r0 = move-exception
            goto L_0x025b
        L_0x0257:
            r0 = move-exception
            goto L_0x0276
        L_0x0259:
            r0 = move-exception
            r4 = r3
        L_0x025b:
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ all -> 0x0274 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0274 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0274 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r24)     // Catch:{ all -> 0x0274 }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x0274 }
            if (r4 == 0) goto L_0x0273
            r4.close()
        L_0x0273:
            return r3
        L_0x0274:
            r0 = move-exception
            r3 = r4
        L_0x0276:
            if (r3 == 0) goto L_0x027b
            r3.close()
        L_0x027b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzac zzk(java.lang.String r37, java.lang.String r38) {
        /*
            r36 = this;
            r1 = r36
            r8 = r38
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r37)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r38)
            r36.zzg()
            r36.zzW()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r36.zzh()     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            r0 = 11
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "origin"
            r2 = 0
            r12[r2] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "value"
            r3 = 1
            r12[r3] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "active"
            r4 = 2
            r12[r4] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "trigger_event_name"
            r5 = 3
            r12[r5] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "trigger_timeout"
            r6 = 4
            r12[r6] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "timed_out_event"
            r7 = 5
            r12[r7] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "creation_timestamp"
            r15 = 6
            r12[r15] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "triggered_event"
            r14 = 7
            r12[r14] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "triggered_timestamp"
            r13 = 8
            r12[r13] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "time_to_live"
            r11 = 9
            r12[r11] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r0 = "expired_event"
            r7 = 10
            r12[r7] = r0     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String[] r0 = new java.lang.String[]{r37, r38}     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            java.lang.String r16 = "conditional_properties"
            java.lang.String r17 = "app_id=? and name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r7 = 9
            r11 = r16
            r7 = 8
            r13 = r17
            r7 = 7
            r14 = r0
            r0 = 6
            r15 = r18
            r16 = r19
            r17 = r20
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x012d, all -> 0x012b }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0129 }
            if (r11 != 0) goto L_0x0080
            r10.close()
            return r9
        L_0x0080:
            java.lang.String r11 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x0129 }
            if (r11 != 0) goto L_0x0088
            java.lang.String r11 = ""
        L_0x0088:
            r23 = r11
            java.lang.Object r11 = r1.zzq(r10, r3)     // Catch:{ SQLiteException -> 0x0129 }
            int r4 = r10.getInt(r4)     // Catch:{ SQLiteException -> 0x0129 }
            if (r4 == 0) goto L_0x0097
            r27 = 1
            goto L_0x0099
        L_0x0097:
            r27 = 0
        L_0x0099:
            java.lang.String r28 = r10.getString(r5)     // Catch:{ SQLiteException -> 0x0129 }
            long r30 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkt r2 = r1.zzf     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkv r2 = r2.zzu()     // Catch:{ SQLiteException -> 0x0129 }
            r3 = 5
            byte[] r3 = r10.getBlob(r3)     // Catch:{ SQLiteException -> 0x0129 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r4 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ SQLiteException -> 0x0129 }
            android.os.Parcelable r2 = r2.zzh(r3, r4)     // Catch:{ SQLiteException -> 0x0129 }
            r29 = r2
            com.google.android.gms.measurement.internal.zzaw r29 = (com.google.android.gms.measurement.internal.zzaw) r29     // Catch:{ SQLiteException -> 0x0129 }
            long r25 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkt r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0129 }
            byte[] r2 = r10.getBlob(r7)     // Catch:{ SQLiteException -> 0x0129 }
            android.os.Parcelable r0 = r0.zzh(r2, r4)     // Catch:{ SQLiteException -> 0x0129 }
            r32 = r0
            com.google.android.gms.measurement.internal.zzaw r32 = (com.google.android.gms.measurement.internal.zzaw) r32     // Catch:{ SQLiteException -> 0x0129 }
            r0 = 8
            long r5 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0129 }
            r0 = 9
            long r33 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkt r0 = r1.zzf     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()     // Catch:{ SQLiteException -> 0x0129 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0129 }
            android.os.Parcelable r0 = r0.zzh(r2, r4)     // Catch:{ SQLiteException -> 0x0129 }
            r35 = r0
            com.google.android.gms.measurement.internal.zzaw r35 = (com.google.android.gms.measurement.internal.zzaw) r35     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzkw r24 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x0129 }
            r2 = r24
            r3 = r38
            r4 = r5
            r6 = r11
            r7 = r23
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ SQLiteException -> 0x0129 }
            r21 = r0
            r22 = r37
            r21.<init>(r22, r23, r24, r25, r27, r28, r29, r30, r32, r33, r35)     // Catch:{ SQLiteException -> 0x0129 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0129 }
            if (r2 == 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0129 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r37)     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0129 }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ SQLiteException -> 0x0129 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ SQLiteException -> 0x0129 }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0129 }
        L_0x0125:
            r10.close()
            return r0
        L_0x0129:
            r0 = move-exception
            goto L_0x012f
        L_0x012b:
            r0 = move-exception
            goto L_0x0154
        L_0x012d:
            r0 = move-exception
            r10 = r9
        L_0x012f:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r37)     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ all -> 0x0152 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0152 }
            if (r10 == 0) goto L_0x0151
            r10.close()
        L_0x0151:
            return r9
        L_0x0152:
            r0 = move-exception
            r9 = r10
        L_0x0154:
            if (r9 == 0) goto L_0x0159
            r9.close()
        L_0x0159:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final zzak zzl(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return zzm(j10, str, 1, false, false, z12, false, z14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzak zzm(long r24, java.lang.String r26, long r27, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "daily_realtime_events_count"
            java.lang.String r2 = "daily_error_events_count"
            java.lang.String r3 = "daily_conversions_count"
            java.lang.String r4 = "daily_public_events_count"
            java.lang.String r5 = "daily_events_count"
            java.lang.String r6 = "day"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            r23.zzg()
            r23.zzW()
            java.lang.String[] r7 = new java.lang.String[]{r26}
            com.google.android.gms.measurement.internal.zzak r8 = new com.google.android.gms.measurement.internal.zzak
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r15 = r23.zzh()     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r10 = 6
            java.lang.String[] r12 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r14 = 0
            r12[r14] = r6     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r13 = 1
            r12[r13] = r5     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r11 = 2
            r12[r11] = r4     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r10 = 3
            r12[r10] = r3     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r9 = 4
            r12[r9] = r2     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            r9 = 5
            r12[r9] = r0     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            java.lang.String[] r16 = new java.lang.String[]{r26}     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            java.lang.String r17 = "apps"
            java.lang.String r18 = "app_id=?"
            r19 = 0
            r20 = 0
            r21 = 0
            r9 = 3
            r10 = r15
            r9 = 2
            r11 = r17
            r9 = 1
            r13 = r18
            r9 = 0
            r14 = r16
            r22 = r15
            r15 = r19
            r16 = r20
            r17 = r21
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x011d, all -> 0x011a }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            if (r11 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.String r2 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r26)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r0.zzb(r2, r3)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r10.close()
            return r8
        L_0x007b:
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            int r9 = (r11 > r24 ? 1 : (r11 == r24 ? 0 : -1))
            if (r9 != 0) goto L_0x00a6
            r9 = 1
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r8.zzb = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9 = 2
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r8.zza = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9 = 3
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r8.zzc = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9 = 4
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r8.zzd = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9 = 5
            long r11 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r8.zze = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00a6:
            if (r29 == 0) goto L_0x00ae
            long r11 = r8.zzb     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r11 + r27
            r8.zzb = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00ae:
            if (r30 == 0) goto L_0x00b6
            long r11 = r8.zza     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r11 + r27
            r8.zza = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00b6:
            if (r31 == 0) goto L_0x00be
            long r11 = r8.zzc     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r11 + r27
            r8.zzc = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00be:
            if (r32 == 0) goto L_0x00c6
            long r11 = r8.zzd     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r11 + r27
            r8.zzd = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00c6:
            if (r33 == 0) goto L_0x00ce
            long r11 = r8.zze     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r11 + r27
            r8.zze = r11     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
        L_0x00ce:
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.<init>()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r11 = java.lang.Long.valueOf(r24)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r6, r11)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r8.zza     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r6 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r4, r6)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r11 = r8.zzb     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r5, r4)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r4 = r8.zzc     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r3, r4)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r3 = r8.zzd     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r2, r3)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            long r2 = r8.zze     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r9.put(r0, r2)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.String r0 = "apps"
            java.lang.String r2 = "app_id=?"
            r3 = r22
            r3.update(r0, r9, r2, r7)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            r10.close()
            return r8
        L_0x0114:
            r0 = move-exception
            r9 = r10
            goto L_0x0139
        L_0x0117:
            r0 = move-exception
            r9 = r10
            goto L_0x011f
        L_0x011a:
            r0 = move-exception
            r9 = 0
            goto L_0x0139
        L_0x011d:
            r0 = move-exception
            r9 = 0
        L_0x011f:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0138 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0138 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0138 }
            java.lang.String r3 = "Error updating daily counts. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r26)     // Catch:{ all -> 0x0138 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0138 }
            if (r9 == 0) goto L_0x0137
            r9.close()
        L_0x0137:
            return r8
        L_0x0138:
            r0 = move-exception
        L_0x0139:
            if (r9 == 0) goto L_0x013e
            r9.close()
        L_0x013e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzm(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzak");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzas zzn(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzg()
            r29.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r29.zzh()     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            r11 = 0
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            r5 = r0
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.String[] r7 = new java.lang.String[]{r30, r31}     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.String r4 = "events"
            java.lang.String r6 = "app_id=? and name=?"
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0104 }
            if (r0 != 0) goto L_0x0055
            r3.close()
            return r2
        L_0x0055:
            long r15 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x0104 }
            r0 = 1
            long r17 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0104 }
            r4 = 2
            long r21 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r4 = 3
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r6 = 0
            if (r5 == 0) goto L_0x006f
            r23 = r6
            goto L_0x0075
        L_0x006f:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r23 = r4
        L_0x0075:
            r4 = 4
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 == 0) goto L_0x007f
            r25 = r2
            goto L_0x0089
        L_0x007f:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r25 = r4
        L_0x0089:
            r4 = 5
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 == 0) goto L_0x0093
            r26 = r2
            goto L_0x009d
        L_0x0093:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r26 = r4
        L_0x009d:
            r4 = 6
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 == 0) goto L_0x00a7
            r27 = r2
            goto L_0x00b1
        L_0x00a7:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r27 = r4
        L_0x00b1:
            r4 = 7
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 != 0) goto L_0x00ca
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r8 = 1
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x00c3
            r11 = 1
        L_0x00c3:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)     // Catch:{ SQLiteException -> 0x0104 }
            r28 = r0
            goto L_0x00cc
        L_0x00ca:
            r28 = r2
        L_0x00cc:
            r0 = 8
            boolean r4 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0104 }
            if (r4 == 0) goto L_0x00d7
            r19 = r6
            goto L_0x00dd
        L_0x00d7:
            long r4 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0104 }
            r19 = r4
        L_0x00dd:
            com.google.android.gms.measurement.internal.zzas r0 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ SQLiteException -> 0x0104 }
            r12 = r0
            r13 = r30
            r14 = r31
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)     // Catch:{ SQLiteException -> 0x0104 }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0104 }
            if (r4 == 0) goto L_0x0100
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r30)     // Catch:{ SQLiteException -> 0x0104 }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x0104 }
        L_0x0100:
            r3.close()
            return r0
        L_0x0104:
            r0 = move-exception
            goto L_0x010a
        L_0x0106:
            r0 = move-exception
            goto L_0x0131
        L_0x0108:
            r0 = move-exception
            r3 = r2
        L_0x010a:
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ all -> 0x012f }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x012f }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x012f }
            java.lang.String r5 = "Error querying events. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r30)     // Catch:{ all -> 0x012f }
            com.google.android.gms.measurement.internal.zzfr r7 = r1.zzt     // Catch:{ all -> 0x012f }
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()     // Catch:{ all -> 0x012f }
            r8 = r31
            java.lang.String r7 = r7.zzd(r8)     // Catch:{ all -> 0x012f }
            r4.zzd(r5, r6, r7, r0)     // Catch:{ all -> 0x012f }
            if (r3 == 0) goto L_0x012e
            r3.close()
        L_0x012e:
            return r2
        L_0x012f:
            r0 = move-exception
            r2 = r3
        L_0x0131:
            if (r2 == 0) goto L_0x0136
            r2.close()
        L_0x0136:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzn(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzas");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzky zzp(java.lang.String r15, java.lang.String r16) {
        /*
            r14 = this;
            r1 = r14
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r16)
            r14.zzg()
            r14.zzW()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r14.zzh()     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            r0 = 3
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            java.lang.String r0 = "set_timestamp"
            r11 = 0
            r5[r11] = r0     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            java.lang.String r0 = "value"
            r12 = 1
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            java.lang.String r0 = "origin"
            r13 = 2
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            java.lang.String[] r7 = new java.lang.String[]{r15, r16}     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            java.lang.String r4 = "user_attributes"
            java.lang.String r6 = "app_id=? and name=?"
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0079, all -> 0x0077 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0075 }
            if (r0 != 0) goto L_0x003d
            r3.close()
            return r2
        L_0x003d:
            long r8 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.Object r10 = r14.zzq(r3, r12)     // Catch:{ SQLiteException -> 0x0075 }
            if (r10 != 0) goto L_0x004b
            r3.close()
            return r2
        L_0x004b:
            java.lang.String r6 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.gms.measurement.internal.zzky r0 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ SQLiteException -> 0x0075 }
            r4 = r0
            r5 = r15
            r7 = r16
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0075 }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0075 }
            if (r4 == 0) goto L_0x0071
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r5 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r15)     // Catch:{ SQLiteException -> 0x0075 }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x0075 }
        L_0x0071:
            r3.close()
            return r0
        L_0x0075:
            r0 = move-exception
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            goto L_0x00a2
        L_0x0079:
            r0 = move-exception
            r3 = r2
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00a0 }
            java.lang.String r5 = "Error querying user property. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r15)     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzfr r7 = r1.zzt     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()     // Catch:{ all -> 0x00a0 }
            r8 = r16
            java.lang.String r7 = r7.zzf(r8)     // Catch:{ all -> 0x00a0 }
            r4.zzd(r5, r6, r7, r0)     // Catch:{ all -> 0x00a0 }
            if (r3 == 0) goto L_0x009f
            r3.close()
        L_0x009f:
            return r2
        L_0x00a0:
            r0 = move-exception
            r2 = r3
        L_0x00a2:
            if (r2 == 0) goto L_0x00a7
            r2.close()
        L_0x00a7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzp(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzky");
    }

    @VisibleForTesting
    public final Object zzq(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            this.zzt.zzay().zzd().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i10));
            }
            if (type == 3) {
                return cursor.getString(i10);
            }
            if (type != 4) {
                this.zzt.zzay().zzd().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzt.zzay().zzd().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zzh()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0022, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0025
        L_0x0020:
            r0 = move-exception
            goto L_0x003e
        L_0x0022:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0025:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzt     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzr():java.lang.String");
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(Operator.Operation.MULTIPLY));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzt(java.lang.String r42, java.lang.String[] r43) {
        /*
            r41 = this;
            r1 = r41
            r41.zzg()
            r41.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1001"
            android.database.sqlite.SQLiteDatabase r2 = r41.zzh()     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "app_id"
            r12 = 0
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "origin"
            r13 = 1
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "name"
            r14 = 2
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "value"
            r15 = 3
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "active"
            r9 = 4
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "trigger_event_name"
            r8 = 5
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "trigger_timeout"
            r7 = 6
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "timed_out_event"
            r6 = 7
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "creation_timestamp"
            r11 = 8
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "triggered_event"
            r11 = 9
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "triggered_timestamp"
            r11 = 10
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "time_to_live"
            r11 = 11
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r5 = "expired_event"
            r11 = 12
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            java.lang.String r21 = "rowid"
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            r5.zzf()     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            r22 = 0
            r23 = 0
            r5 = r42
            r11 = 7
            r6 = r43
            r11 = 6
            r7 = r22
            r11 = 5
            r8 = r23
            r11 = 4
            r9 = r21
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x016e, all -> 0x016b }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            if (r3 == 0) goto L_0x0161
        L_0x0082:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r4.zzf()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            java.lang.String r5 = "Read more than the max allowed conditional properties, ignoring extra"
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r6.zzf()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r3.zzb(r5, r4)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            goto L_0x015a
        L_0x00a9:
            java.lang.String r3 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            java.lang.String r10 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            java.lang.String r5 = r2.getString(r14)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            java.lang.Object r8 = r1.zzq(r2, r15)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            int r4 = r2.getInt(r11)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            if (r4 == 0) goto L_0x00c3
            r9 = 5
            r23 = 1
            goto L_0x00c6
        L_0x00c3:
            r9 = 5
            r23 = 0
        L_0x00c6:
            java.lang.String r25 = r2.getString(r9)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r6 = 6
            long r26 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkt r4 = r1.zzf     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkv r4 = r4.zzu()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r7 = 7
            byte[] r6 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r7 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            android.os.Parcelable r4 = r4.zzh(r6, r7)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r28 = r4
            com.google.android.gms.measurement.internal.zzaw r28 = (com.google.android.gms.measurement.internal.zzaw) r28     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r6 = 8
            long r29 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkt r4 = r1.zzf     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkv r4 = r4.zzu()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r11 = 9
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            android.os.Parcelable r4 = r4.zzh(r6, r7)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r31 = r4
            com.google.android.gms.measurement.internal.zzaw r31 = (com.google.android.gms.measurement.internal.zzaw) r31     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r6 = 10
            long r18 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r4 = 11
            long r32 = r2.getLong(r4)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkt r4 = r1.zzf     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkv r4 = r4.zzu()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r11 = 12
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            android.os.Parcelable r4 = r4.zzh(r6, r7)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r34 = r4
            com.google.android.gms.measurement.internal.zzaw r34 = (com.google.android.gms.measurement.internal.zzaw) r34     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzkw r21 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r35 = 11
            r4 = r21
            r36 = 10
            r37 = 8
            r38 = 7
            r39 = 6
            r6 = r18
            r40 = 5
            r9 = r10
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzac r4 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r16 = r4
            r17 = r3
            r18 = r10
            r19 = r21
            r20 = r29
            r22 = r23
            r23 = r25
            r24 = r28
            r25 = r26
            r27 = r31
            r28 = r32
            r30 = r34
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0165 }
            if (r3 != 0) goto L_0x015e
        L_0x015a:
            r2.close()
            return r0
        L_0x015e:
            r11 = 4
            goto L_0x0082
        L_0x0161:
            r2.close()
            return r0
        L_0x0165:
            r0 = move-exception
            r11 = r2
            goto L_0x018a
        L_0x0168:
            r0 = move-exception
            r11 = r2
            goto L_0x0170
        L_0x016b:
            r0 = move-exception
            r11 = 0
            goto L_0x018a
        L_0x016e:
            r0 = move-exception
            r11 = 0
        L_0x0170:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0189 }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x0189 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0189 }
            if (r11 == 0) goto L_0x0188
            r11.close()
        L_0x0188:
            return r0
        L_0x0189:
            r0 = move-exception
        L_0x018a:
            if (r11 == 0) goto L_0x018f
            r11.close()
        L_0x018f:
            goto L_0x0191
        L_0x0190:
            throw r0
        L_0x0191:
            goto L_0x0190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzt(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final List zzu(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.zzt.zzf();
            Cursor query = zzh().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = query.getLong(2);
                    Object zzq = zzq(query, 3);
                    if (zzq == null) {
                        this.zzt.zzay().zzd().zzb("Read invalid user property value, ignoring it. appId", zzeh.zzn(str));
                    } else {
                        arrayList.add(new zzky(str, str2, string, j10, zzq));
                    }
                } while (query.moveToNext());
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzc("Error querying user properties. appId", zzeh.zzn(str), e10);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011e, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0120, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0121, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0123, code lost:
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013f, code lost:
        r12.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzv(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r23
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzg()
            r20.zzW()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0120, all -> 0x011d }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x0120, all -> 0x011d }
            r14 = r21
            r3.add(r14)     // Catch:{ SQLiteException -> 0x011b, all -> 0x011d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x011b, all -> 0x011d }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x011b, all -> 0x011d }
            boolean r5 = android.text.TextUtils.isEmpty(r22)     // Catch:{ SQLiteException -> 0x011b, all -> 0x011d }
            if (r5 != 0) goto L_0x0037
            r15 = r22
            r3.add(r15)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            goto L_0x0039
        L_0x0037:
            r15 = r22
        L_0x0039:
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            if (r5 != 0) goto L_0x0058
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
        L_0x0058:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            android.database.sqlite.SQLiteDatabase r3 = r20.zzh()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r5 = "user_attributes"
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r8 = "name"
            r10 = 0
            r6[r10] = r8     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r8 = "set_timestamp"
            r9 = 1
            r6[r9] = r8     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r8 = "value"
            r12 = 2
            r6[r12] = r8     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r8 = "origin"
            r6[r13] = r8     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            java.lang.String r17 = "rowid"
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r4.zzf()     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            r18 = 0
            r19 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r18
            r13 = 1
            r9 = r19
            r12 = 0
            r10 = r17
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0119, all -> 0x011d }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            if (r4 != 0) goto L_0x00a9
            r3.close()
            return r2
        L_0x00a9:
            int r4 = r2.size()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzt     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r5.zzf()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r5) goto L_0x00cf
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzt     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r6.zzf()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r0.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            goto L_0x010f
        L_0x00cf:
            java.lang.String r7 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            long r8 = r3.getLong(r13)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r11 = 2
            java.lang.Object r10 = r1.zzq(r3, r11)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r6 = 3
            java.lang.String r15 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            if (r10 != 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzt     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r21)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r4.zzd(r5, r7, r15, r0)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r16 = 3
            goto L_0x0108
        L_0x00f9:
            com.google.android.gms.measurement.internal.zzky r5 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r4 = r5
            r11 = r5
            r5 = r21
            r16 = 3
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            r2.add(r11)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
        L_0x0108:
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0113 }
            if (r4 == 0) goto L_0x010f
            goto L_0x00a9
        L_0x010f:
            r3.close()
            return r2
        L_0x0113:
            r0 = move-exception
            r12 = r3
            goto L_0x0144
        L_0x0116:
            r0 = move-exception
            r12 = r3
            goto L_0x0126
        L_0x0119:
            r0 = move-exception
            goto L_0x0125
        L_0x011b:
            r0 = move-exception
            goto L_0x0123
        L_0x011d:
            r0 = move-exception
            r12 = 0
            goto L_0x0144
        L_0x0120:
            r0 = move-exception
            r14 = r21
        L_0x0123:
            r15 = r22
        L_0x0125:
            r12 = 0
        L_0x0126:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x0143 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0143 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0143 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r21)     // Catch:{ all -> 0x0143 }
            r2.zzd(r3, r4, r15, r0)     // Catch:{ all -> 0x0143 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0143 }
            if (r12 == 0) goto L_0x0142
            r12.close()
        L_0x0142:
            return r0
        L_0x0143:
            r0 = move-exception
        L_0x0144:
            if (r12 == 0) goto L_0x0149
            r12.close()
        L_0x0149:
            goto L_0x014b
        L_0x014a:
            throw r0
        L_0x014b:
            goto L_0x014a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzv(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    public final void zzx() {
        zzW();
        zzh().endTransaction();
    }

    @VisibleForTesting
    public final void zzy(List list) {
        zzg();
        zzW();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzI()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzZ("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                this.zzt.zzay().zzk().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                this.zzt.zzay().zzd().zzb("Error incrementing retry count. error", e10);
            }
        }
    }

    public final void zzz() {
        zzg();
        zzW();
        if (zzI()) {
            long zza2 = this.zzf.zzs().zza.zza();
            long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            this.zzt.zzf();
            if (abs > ((Long) zzdu.zzx.zza((Object) null)).longValue()) {
                this.zzf.zzs().zza.zzb(elapsedRealtime);
                zzg();
                zzW();
                if (zzI()) {
                    SQLiteDatabase zzh2 = zzh();
                    String valueOf = String.valueOf(this.zzt.zzav().currentTimeMillis());
                    this.zzt.zzf();
                    int delete = zzh2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzag.zzA())});
                    if (delete > 0) {
                        this.zzt.zzay().zzj().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
