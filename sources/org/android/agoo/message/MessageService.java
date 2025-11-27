package org.android.agoo.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import c8.b;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.j;
import com.umeng.analytics.pro.bt;
import m7.f;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";

    /* renamed from: a  reason: collision with root package name */
    private static Context f8620a;

    /* renamed from: c  reason: collision with root package name */
    private static LruCache<String, Integer> f8621c;

    /* renamed from: b  reason: collision with root package name */
    private volatile SQLiteOpenHelper f8622b = null;

    public static class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "message_accs_db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        private String a() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table accs_message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state text,");
            stringBuffer.append("message text,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        private String b() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!j.a(super.getWritableDatabase().getPath(), 102400)) {
                return null;
            }
            return super.getWritableDatabase();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(b());
                    sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                    sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                    sQLiteDatabase.execSQL(a());
                } catch (Throwable th) {
                    ALog.e("MessageService", "messagedbhelper create", th, new Object[0]);
                }
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    ALog.e("MessageService", "MessageService onUpgrade is error", th, new Object[0]);
                    return;
                }
            }
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS accs_message");
                sQLiteDatabase.execSQL(a());
            } catch (Throwable th2) {
                ALog.e("MessageService", "MessageService onUpgrade is error", th2, new Object[0]);
            }
        }
    }

    public void a(Context context) {
        f8621c = new LruCache<>(100);
        f8620a = context;
        this.f8622b = new a(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x014b A[Catch:{ all -> 0x018e, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0164 A[SYNTHETIC, Splitter:B:68:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016c A[Catch:{ all -> 0x0168 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> b() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "3"
            java.lang.String r2 = "2"
            java.lang.String r3 = "0"
            java.lang.String r4 = "getUnReportMsg close cursor or db, e: "
            java.lang.String r5 = "MessageService"
            r6 = 0
            r7 = 0
            android.database.sqlite.SQLiteOpenHelper r8 = r1.f8622b     // Catch:{ all -> 0x013f }
            android.database.sqlite.SQLiteDatabase r8 = r8.getReadableDatabase()     // Catch:{ all -> 0x013f }
            if (r8 != 0) goto L_0x003b
            if (r8 == 0) goto L_0x003a
            r8.close()     // Catch:{ all -> 0x001c }
            goto L_0x003a
        L_0x001c:
            r0 = move-exception
            r2 = r0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L_0x003a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r2 = new java.lang.Object[r6]
            com.taobao.accs.utl.ALog.e(r5, r0, r2)
        L_0x003a:
            return r7
        L_0x003b:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x013c }
            r9.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "select * from accs_message where state = ? or state = ? or state = ?"
            r11 = 3
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ all -> 0x0139 }
            r11[r6] = r3     // Catch:{ all -> 0x0139 }
            r12 = 1
            r11[r12] = r2     // Catch:{ all -> 0x0139 }
            r12 = 2
            r11[r12] = r0     // Catch:{ all -> 0x0139 }
            android.database.Cursor r10 = r8.rawQuery(r10, r11)     // Catch:{ all -> 0x0139 }
            if (r10 == 0) goto L_0x010e
            java.lang.String r11 = "id"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = "state"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r13 = "message"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ all -> 0x010b }
            java.lang.String r14 = "create_time"
            int r14 = r10.getColumnIndex(r14)     // Catch:{ all -> 0x010b }
        L_0x006b:
            boolean r15 = r10.moveToNext()     // Catch:{ all -> 0x010b }
            if (r15 == 0) goto L_0x010e
            java.lang.String r15 = r10.getString(r13)     // Catch:{ all -> 0x010b }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x010b }
            if (r15 != 0) goto L_0x010e
            java.lang.String r15 = r10.getString(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r10.getString(r13)     // Catch:{ all -> 0x010b }
            com.taobao.accs.utl.ALog$Level r16 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x010b }
            boolean r16 = com.taobao.accs.utl.ALog.isPrintLog(r16)     // Catch:{ all -> 0x010b }
            if (r16 == 0) goto L_0x00c7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            r6.<init>()     // Catch:{ all -> 0x010b }
            r17 = r12
            java.lang.String r12 = "state: "
            r6.append(r12)     // Catch:{ all -> 0x010b }
            r6.append(r15)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = " ,cursor.message:"
            r6.append(r12)     // Catch:{ all -> 0x010b }
            r6.append(r7)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = " ,cursor.id:"
            r6.append(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = r10.getString(r11)     // Catch:{ all -> 0x010b }
            r6.append(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = " ,cursor.time:"
            r6.append(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r12 = r10.getString(r14)     // Catch:{ all -> 0x010b }
            r6.append(r12)     // Catch:{ all -> 0x010b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x010b }
            r18 = r11
            r12 = 0
            java.lang.Object[] r11 = new java.lang.Object[r12]     // Catch:{ all -> 0x010b }
            com.taobao.accs.utl.ALog.i(r5, r6, r11)     // Catch:{ all -> 0x010b }
            goto L_0x00cb
        L_0x00c7:
            r18 = r11
            r17 = r12
        L_0x00cb:
            boolean r6 = android.text.TextUtils.equals(r3, r15)     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x00d4
            java.lang.String r6 = "4"
            goto L_0x00e7
        L_0x00d4:
            boolean r6 = android.text.TextUtils.equals(r2, r15)     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x00dd
            java.lang.String r6 = "8"
            goto L_0x00e7
        L_0x00dd:
            boolean r6 = android.text.TextUtils.equals(r0, r15)     // Catch:{ all -> 0x010b }
            if (r6 == 0) goto L_0x00e6
            java.lang.String r6 = "9"
            goto L_0x00e7
        L_0x00e6:
            r6 = 0
        L_0x00e7:
            org.android.agoo.common.MsgDO r11 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x010b }
            r11.<init>()     // Catch:{ all -> 0x010b }
            boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x010b }
            if (r11 != 0) goto L_0x0103
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x010b }
            if (r11 != 0) goto L_0x0103
            org.android.agoo.common.MsgDO r6 = r1.b(r7, r6)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = "cache"
            r6.messageSource = r7     // Catch:{ all -> 0x010b }
            r9.add(r6)     // Catch:{ all -> 0x010b }
        L_0x0103:
            r12 = r17
            r11 = r18
            r6 = 0
            r7 = 0
            goto L_0x006b
        L_0x010b:
            r0 = move-exception
            r7 = r10
            goto L_0x0143
        L_0x010e:
            if (r10 == 0) goto L_0x0116
            r10.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0116
        L_0x0114:
            r0 = move-exception
            goto L_0x011b
        L_0x0116:
            r8.close()     // Catch:{ all -> 0x0114 }
            goto L_0x018d
        L_0x011b:
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r2 == 0) goto L_0x018d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.e(r5, r0, r2)
            goto L_0x018d
        L_0x0139:
            r0 = move-exception
            r7 = 0
            goto L_0x0143
        L_0x013c:
            r0 = move-exception
            r7 = 0
            goto L_0x0142
        L_0x013f:
            r0 = move-exception
            r7 = 0
            r8 = 0
        L_0x0142:
            r9 = 0
        L_0x0143:
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x018e }
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ all -> 0x018e }
            if (r2 == 0) goto L_0x0162
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r2.<init>()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "getUnReportMsg, e: "
            r2.append(r3)     // Catch:{ all -> 0x018e }
            r2.append(r0)     // Catch:{ all -> 0x018e }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x018e }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x018e }
            com.taobao.accs.utl.ALog.e(r5, r0, r3)     // Catch:{ all -> 0x018e }
        L_0x0162:
            if (r7 == 0) goto L_0x016a
            r7.close()     // Catch:{ all -> 0x0168 }
            goto L_0x016a
        L_0x0168:
            r0 = move-exception
            goto L_0x0170
        L_0x016a:
            if (r8 == 0) goto L_0x018d
            r8.close()     // Catch:{ all -> 0x0168 }
            goto L_0x018d
        L_0x0170:
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r2 == 0) goto L_0x018d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.e(r5, r0, r2)
        L_0x018d:
            return r9
        L_0x018e:
            r0 = move-exception
            r2 = r0
            if (r7 == 0) goto L_0x0198
            r7.close()     // Catch:{ all -> 0x0196 }
            goto L_0x0198
        L_0x0196:
            r0 = move-exception
            goto L_0x019e
        L_0x0198:
            if (r8 == 0) goto L_0x01bb
            r8.close()     // Catch:{ all -> 0x0196 }
            goto L_0x01bb
        L_0x019e:
            com.taobao.accs.utl.ALog$Level r3 = com.taobao.accs.utl.ALog.Level.E
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r3)
            if (r3 == 0) goto L_0x01bb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            com.taobao.accs.utl.ALog.e(r5, r0, r3)
        L_0x01bb:
            goto L_0x01bd
        L_0x01bc:
            throw r2
        L_0x01bd:
            goto L_0x01bc
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.b():java.util.ArrayList");
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("MessageService", "updateAccsMessage sqlite3--->[" + str + ",state=" + str2 + "]", new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                sQLiteDatabase = this.f8622b.getWritableDatabase();
                if (sQLiteDatabase != null) {
                    if (TextUtils.equals(str2, "1")) {
                        sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
                    } else {
                        sQLiteDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
                    }
                    sQLiteDatabase.close();
                } else if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c A[Catch:{ all -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d8 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dd A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.I
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            java.lang.String r1 = "MessageService"
            r2 = 0
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "addAccsMessage sqlite3--->["
            r0.append(r3)
            r0.append(r8)
            java.lang.String r3 = ",message="
            r0.append(r3)
            r0.append(r9)
            java.lang.String r3 = ",state="
            r0.append(r3)
            r0.append(r10)
            java.lang.String r3 = "]"
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.i(r1, r0, r3)
        L_0x0036:
            r0 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0092 }
            if (r3 != 0) goto L_0x0091
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0092 }
            if (r3 == 0) goto L_0x0044
            goto L_0x0091
        L_0x0044:
            android.database.sqlite.SQLiteOpenHelper r3 = r7.f8622b     // Catch:{ all -> 0x0092 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x0092 }
            if (r3 != 0) goto L_0x0052
            if (r3 == 0) goto L_0x0051
            r3.close()
        L_0x0051:
            return
        L_0x0052:
            java.lang.String r4 = "select count(1) from accs_message where id = ?"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch:{ all -> 0x008d }
            android.database.Cursor r0 = r3.rawQuery(r4, r5)     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x0074
            boolean r4 = r0.moveToFirst()     // Catch:{ all -> 0x008d }
            if (r4 == 0) goto L_0x0074
            int r4 = r0.getInt(r2)     // Catch:{ all -> 0x008d }
            if (r4 <= 0) goto L_0x0074
            r0.close()     // Catch:{ all -> 0x008d }
            r0.close()
            r3.close()
            return
        L_0x0074:
            java.lang.String r4 = "INSERT INTO accs_message VALUES(?,?,?,date('now'))"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x008d }
            r5[r2] = r8     // Catch:{ all -> 0x008d }
            r8 = 1
            r5[r8] = r10     // Catch:{ all -> 0x008d }
            r8 = 2
            r5[r8] = r9     // Catch:{ all -> 0x008d }
            r3.execSQL(r4, r5)     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x0089
            r0.close()
        L_0x0089:
            r3.close()
            goto L_0x00e0
        L_0x008d:
            r8 = move-exception
            r9 = r0
            r0 = r3
            goto L_0x0094
        L_0x0091:
            return
        L_0x0092:
            r8 = move-exception
            r9 = r0
        L_0x0094:
            com.taobao.accs.utl.ALog$Level r10 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x00e1 }
            boolean r10 = com.taobao.accs.utl.ALog.isPrintLog(r10)     // Catch:{ all -> 0x00e1 }
            if (r10 == 0) goto L_0x00be
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            r10.<init>()     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = "addAccsMessage error,e--->["
            r10.append(r3)     // Catch:{ all -> 0x00e1 }
            r10.append(r8)     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = "],ex="
            r10.append(r3)     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = r7.a((java.lang.Throwable) r8)     // Catch:{ all -> 0x00e1 }
            r10.append(r3)     // Catch:{ all -> 0x00e1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00e1 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00e1 }
            com.taobao.accs.utl.ALog.e(r1, r10, r2)     // Catch:{ all -> 0x00e1 }
        L_0x00be:
            com.taobao.accs.utl.UTMini r1 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x00e1 }
            r2 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r3 = "accs.add_agoo_message"
            android.content.Context r10 = f8620a     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = com.taobao.accs.utl.j.b(r10)     // Catch:{ all -> 0x00e1 }
            java.lang.String r5 = "addAccsMessageFailed"
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00e1 }
            r1.commitEvent(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e1 }
            if (r9 == 0) goto L_0x00db
            r9.close()
        L_0x00db:
            if (r0 == 0) goto L_0x00e0
            r0.close()
        L_0x00e0:
            return
        L_0x00e1:
            r8 = move-exception
            if (r9 == 0) goto L_0x00e7
            r9.close()
        L_0x00e7:
            if (r0 == 0) goto L_0x00ec
            r0.close()
        L_0x00ec:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    private MsgDO b(String str, String str2) {
        boolean z10;
        String str3 = str;
        ALog.Level level = ALog.Level.I;
        if (ALog.isPrintLog(level)) {
            ALog.i("MessageService", "msgRecevie,message--->[" + str3 + "],utdid=" + j.b(f8620a), new Object[0]);
        }
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(f8620a), "message==null");
            if (ALog.isPrintLog(level)) {
                ALog.i("MessageService", "handleMessage message==null,utdid=" + j.b(f8620a), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str3);
            int length = jSONArray.length();
            new Bundle();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    String string = jSONObject.getString(bt.aD);
                    String string2 = jSONObject.getString(bt.aI);
                    String string3 = jSONObject.getString(b.f11376b);
                    long j10 = jSONObject.getLong(f.f7907a);
                    if (!jSONObject.isNull("ext")) {
                        str4 = jSONObject.getString("ext");
                    }
                    int i11 = length - 1;
                    msgDO.msgIds = string2;
                    msgDO.extData = str4;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                    } else if (j10 == -1) {
                        msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                    } else if (!a(f8620a, string)) {
                        ALog.d("MessageService", "ondata checkpackage is del,pack=" + string, new Object[0]);
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", j.b(f8620a), "deletePack", string);
                        msgDO.removePacks = string;
                    } else {
                        String string4 = a(j10, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!f8620a.getPackageName().equals(string)) {
                            z10 = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z10 = false;
                        } else {
                            msgDO.errorCode = AgooConstants.ACK_PACK_ERROR;
                            ALog.e("MessageService", "error encrypted: " + string4, new Object[0]);
                        }
                        msgDO.agooFlag = z10;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    }
                }
                String str5 = str2;
            }
        } catch (Throwable th) {
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("MessageService", "createMsg is error,e: " + th, new Object[0]);
            }
        }
        return msgDO;
    }

    public void a(String str, String str2, String str3, int i10) {
        a(str, str2, str3, 1, -1, -1, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a1, code lost:
        com.taobao.accs.utl.UTMini.getInstance().commitEvent(org.android.agoo.common.AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", com.taobao.accs.utl.j.b(f8620a), "addMessageDBcloseFailed", r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013f A[Catch:{ all -> 0x01c4, all -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017c A[SYNTHETIC, Splitter:B:47:0x017c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, long r18, int r20, int r21) {
        /*
            r13 = this;
            r0 = r14
            java.lang.String r1 = "addMessage,db.close(),error,e--->["
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "add sqlite3--->["
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "MessageService"
            com.taobao.accs.utl.ALog.d(r6, r2, r5)
            r2 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = ""
            if (r5 == 0) goto L_0x002e
            r5 = -1
            r5 = r7
            r8 = -1
            goto L_0x0034
        L_0x002e:
            int r5 = r15.hashCode()     // Catch:{ all -> 0x0135 }
            r8 = r5
            r5 = r15
        L_0x0034:
            boolean r9 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x0135 }
            if (r9 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r7 = r16
        L_0x003d:
            android.util.LruCache<java.lang.String, java.lang.Integer> r9 = f8621c     // Catch:{ all -> 0x0135 }
            java.lang.Object r9 = r9.get(r14)     // Catch:{ all -> 0x0135 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0135 }
            if (r9 != 0) goto L_0x007c
            android.util.LruCache<java.lang.String, java.lang.Integer> r9 = f8621c     // Catch:{ all -> 0x0135 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0135 }
            r9.put(r14, r10)     // Catch:{ all -> 0x0135 }
            com.taobao.accs.utl.ALog$Level r9 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x0135 }
            boolean r9 = com.taobao.accs.utl.ALog.isPrintLog(r9)     // Catch:{ all -> 0x0135 }
            if (r9 == 0) goto L_0x007c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r9.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = "addMessage,messageId="
            r9.append(r10)     // Catch:{ all -> 0x0135 }
            r9.append(r14)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = ", mCache size:"
            r9.append(r10)     // Catch:{ all -> 0x0135 }
            android.util.LruCache<java.lang.String, java.lang.Integer> r10 = f8621c     // Catch:{ all -> 0x0135 }
            int r10 = r10.size()     // Catch:{ all -> 0x0135 }
            r9.append(r10)     // Catch:{ all -> 0x0135 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0135 }
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x0135 }
            com.taobao.accs.utl.ALog.i(r6, r9, r10)     // Catch:{ all -> 0x0135 }
        L_0x007c:
            r9 = r13
            android.database.sqlite.SQLiteOpenHelper r10 = r9.f8622b     // Catch:{ all -> 0x0133 }
            android.database.sqlite.SQLiteDatabase r2 = r10.getWritableDatabase()     // Catch:{ all -> 0x0133 }
            if (r2 != 0) goto L_0x00cf
            if (r2 == 0) goto L_0x00ce
            r2.close()     // Catch:{ all -> 0x008b }
            goto L_0x00ce
        L_0x008b:
            r0 = move-exception
            r2 = r0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.taobao.accs.utl.ALog.e(r6, r0, r1)
        L_0x00ac:
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()
            r1 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r3 = "accs.add_agoo_message"
            android.content.Context r4 = f8620a
            java.lang.String r4 = com.taobao.accs.utl.j.b(r4)
            java.lang.String r5 = "addMessageDBcloseFailed"
            java.lang.String r2 = r2.toString()
            r14 = r0
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r2
            r14.commitEvent(r15, r16, r17, r18, r19)
        L_0x00ce:
            return
        L_0x00cf:
            java.lang.String r10 = "INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))"
            r11 = 9
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0133 }
            r11[r4] = r0     // Catch:{ all -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x0133 }
            r12 = 1
            r11[r12] = r0     // Catch:{ all -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0133 }
            r8 = 2
            r11[r8] = r0     // Catch:{ all -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0133 }
            r8 = 3
            r11[r8] = r0     // Catch:{ all -> 0x0133 }
            java.lang.Long r0 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0133 }
            r8 = 4
            r11[r8] = r0     // Catch:{ all -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x0133 }
            r8 = 5
            r11[r8] = r0     // Catch:{ all -> 0x0133 }
            r0 = 6
            r11[r0] = r7     // Catch:{ all -> 0x0133 }
            r0 = 7
            r11[r0] = r5     // Catch:{ all -> 0x0133 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x0133 }
            r5 = 8
            r11[r5] = r0     // Catch:{ all -> 0x0133 }
            r2.execSQL(r10, r11)     // Catch:{ all -> 0x0133 }
            r2.close()     // Catch:{ all -> 0x0110 }
            goto L_0x01c3
        L_0x0110:
            r0 = move-exception
            r2 = r0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L_0x01a1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.taobao.accs.utl.ALog.e(r6, r0, r1)
            goto L_0x01a1
        L_0x0133:
            r0 = move-exception
            goto L_0x0137
        L_0x0135:
            r0 = move-exception
            r9 = r13
        L_0x0137:
            com.taobao.accs.utl.ALog$Level r5 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x01c4 }
            boolean r5 = com.taobao.accs.utl.ALog.isPrintLog(r5)     // Catch:{ all -> 0x01c4 }
            if (r5 == 0) goto L_0x0158
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r5.<init>()     // Catch:{ all -> 0x01c4 }
            java.lang.String r7 = "addMessage error,e--->["
            r5.append(r7)     // Catch:{ all -> 0x01c4 }
            r5.append(r0)     // Catch:{ all -> 0x01c4 }
            r5.append(r3)     // Catch:{ all -> 0x01c4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01c4 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x01c4 }
            com.taobao.accs.utl.ALog.e(r6, r5, r7)     // Catch:{ all -> 0x01c4 }
        L_0x0158:
            com.taobao.accs.utl.UTMini r5 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x01c4 }
            r7 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r8 = "accs.add_agoo_message"
            android.content.Context r10 = f8620a     // Catch:{ all -> 0x01c4 }
            java.lang.String r10 = com.taobao.accs.utl.j.b(r10)     // Catch:{ all -> 0x01c4 }
            java.lang.String r11 = "addMessageFailed"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01c4 }
            r14 = r5
            r15 = r7
            r16 = r8
            r17 = r10
            r18 = r11
            r19 = r0
            r14.commitEvent(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01c4 }
            if (r2 == 0) goto L_0x01c3
            r2.close()     // Catch:{ all -> 0x0180 }
            goto L_0x01c3
        L_0x0180:
            r0 = move-exception
            r2 = r0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L_0x01a1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.taobao.accs.utl.ALog.e(r6, r0, r1)
        L_0x01a1:
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()
            r1 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r3 = "accs.add_agoo_message"
            android.content.Context r4 = f8620a
            java.lang.String r4 = com.taobao.accs.utl.j.b(r4)
            java.lang.String r5 = "addMessageDBcloseFailed"
            java.lang.String r2 = r2.toString()
            r14 = r0
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r2
            r14.commitEvent(r15, r16, r17, r18, r19)
        L_0x01c3:
            return
        L_0x01c4:
            r0 = move-exception
            r5 = r0
            if (r2 == 0) goto L_0x020f
            r2.close()     // Catch:{ all -> 0x01cc }
            goto L_0x020f
        L_0x01cc:
            r0 = move-exception
            r2 = r0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.E
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)
            if (r0 == 0) goto L_0x01ed
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.taobao.accs.utl.ALog.e(r6, r0, r1)
        L_0x01ed:
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()
            r1 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r3 = "accs.add_agoo_message"
            android.content.Context r4 = f8620a
            java.lang.String r4 = com.taobao.accs.utl.j.b(r4)
            java.lang.String r6 = "addMessageDBcloseFailed"
            java.lang.String r2 = r2.toString()
            r14 = r0
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r6
            r19 = r2
            r14.commitEvent(r15, r16, r17, r18, r19)
        L_0x020f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String, java.lang.String, java.lang.String, int, long, int, int):void");
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f8622b.getWritableDatabase();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                sQLiteDatabase.execSQL("delete from accs_message where create_time< date('now','-1 day') ");
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused) {
                }
            } else if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Throwable unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0067 A[SYNTHETIC, Splitter:B:37:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006c A[Catch:{ all -> 0x006f }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = f8621c     // Catch:{ all -> 0x0064 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0064 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0064 }
            r3 = 1
            if (r2 == 0) goto L_0x002f
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x0064 }
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r4.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch:{ all -> 0x0064 }
            r4.append(r7)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0064 }
            com.taobao.accs.utl.ALog.e(r2, r4, r5)     // Catch:{ all -> 0x0064 }
        L_0x002d:
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            android.database.sqlite.SQLiteOpenHelper r4 = r6.f8622b     // Catch:{ all -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch:{ all -> 0x0061 }
            if (r4 != 0) goto L_0x003e
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ all -> 0x003d }
        L_0x003d:
            return r2
        L_0x003e:
            java.lang.String r5 = "select count(1) from message where id = ?"
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ all -> 0x0062 }
            android.database.Cursor r0 = r4.rawQuery(r5, r7)     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0057
            boolean r7 = r0.moveToFirst()     // Catch:{ all -> 0x0062 }
            if (r7 == 0) goto L_0x0057
            int r7 = r0.getInt(r1)     // Catch:{ all -> 0x0062 }
            if (r7 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ all -> 0x0070 }
        L_0x005d:
            r4.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0070
        L_0x0061:
            r4 = r0
        L_0x0062:
            r1 = r2
            goto L_0x0065
        L_0x0064:
            r4 = r0
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()     // Catch:{ all -> 0x006f }
        L_0x006a:
            if (r4 == 0) goto L_0x006f
            r4.close()     // Catch:{ all -> 0x006f }
        L_0x006f:
            r3 = r1
        L_0x0070:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.database.sqlite.SQLiteClosable] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081 A[SYNTHETIC, Splitter:B:39:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.util.LruCache<java.lang.String, java.lang.Integer> r2 = f8621c     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x007e }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x007e }
            r3 = 1
            if (r2 == 0) goto L_0x0035
            int r2 = r2.intValue()     // Catch:{ all -> 0x007e }
            if (r10 != r2) goto L_0x0035
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.E     // Catch:{ all -> 0x007e }
            boolean r2 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0033
            java.lang.String r2 = "MessageService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "hasMessageDuplicate,msgid="
            r4.append(r5)     // Catch:{ all -> 0x007e }
            r4.append(r9)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            com.taobao.accs.utl.ALog.e(r2, r4, r5)     // Catch:{ all -> 0x007e }
        L_0x0033:
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = 0
        L_0x0036:
            android.database.sqlite.SQLiteOpenHelper r4 = r8.f8622b     // Catch:{ all -> 0x007b }
            android.database.sqlite.SQLiteDatabase r4 = r4.getReadableDatabase()     // Catch:{ all -> 0x007b }
            if (r4 != 0) goto L_0x0044
            if (r4 == 0) goto L_0x0043
            r4.close()     // Catch:{ all -> 0x0043 }
        L_0x0043:
            return r2
        L_0x0044:
            java.lang.String r5 = "select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x007c }
            r6[r1] = r9     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r9.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r7 = ""
            r9.append(r7)     // Catch:{ all -> 0x007c }
            r9.append(r10)     // Catch:{ all -> 0x007c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x007c }
            r6[r3] = r9     // Catch:{ all -> 0x007c }
            android.database.Cursor r0 = r4.rawQuery(r5, r6)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0071
            boolean r9 = r0.moveToFirst()     // Catch:{ all -> 0x007c }
            if (r9 == 0) goto L_0x0071
            int r9 = r0.getInt(r1)     // Catch:{ all -> 0x007c }
            if (r9 <= 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r3 = r2
        L_0x0072:
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ all -> 0x008a }
        L_0x0077:
            r4.close()     // Catch:{ all -> 0x008a }
            goto L_0x008a
        L_0x007b:
            r4 = r0
        L_0x007c:
            r1 = r2
            goto L_0x007f
        L_0x007e:
            r4 = r0
        L_0x007f:
            if (r0 == 0) goto L_0x0084
            r0.close()     // Catch:{ all -> 0x0089 }
        L_0x0084:
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r3 = r1
        L_0x008a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String, int):boolean");
    }

    public static final boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private static Bundle a(long j10, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j10).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }
}
