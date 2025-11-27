package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

public class DataBaseOperation {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8676a = "VMS_SDK_DB";

    /* renamed from: b  reason: collision with root package name */
    private static final String f8677b = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8678c = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: d  reason: collision with root package name */
    private static final String f8679d = "value";

    /* renamed from: e  reason: collision with root package name */
    private static final String f8680e = "OAID";

    /* renamed from: f  reason: collision with root package name */
    private static final String f8681f = "AAID";

    /* renamed from: g  reason: collision with root package name */
    private static final String f8682g = "VAID";

    /* renamed from: h  reason: collision with root package name */
    private static final String f8683h = "OAIDBLACK";

    /* renamed from: i  reason: collision with root package name */
    private static final String f8684i = "OAIDSTATUS";

    /* renamed from: j  reason: collision with root package name */
    private static final String f8685j = "STATISTICS";

    /* renamed from: k  reason: collision with root package name */
    private static final int f8686k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f8687l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f8688m = 2;

    /* renamed from: n  reason: collision with root package name */
    private static final int f8689n = 3;

    /* renamed from: o  reason: collision with root package name */
    private static final int f8690o = 4;

    /* renamed from: p  reason: collision with root package name */
    private static final int f8691p = 5;

    /* renamed from: q  reason: collision with root package name */
    private static final int f8692q = 6;

    /* renamed from: r  reason: collision with root package name */
    private static final int f8693r = 7;

    /* renamed from: s  reason: collision with root package name */
    private static final String f8694s = "UDID";

    /* renamed from: t  reason: collision with root package name */
    private Context f8695t;

    public DataBaseOperation(Context context) {
        this.f8695t = context;
    }

    public boolean a(int i10, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        if (i10 == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i10 != 7) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            int bulkInsert = this.f8695t.getContentResolver().bulkInsert(uri, contentValuesArr);
            StringBuilder sb = new StringBuilder();
            sb.append("insert:");
            sb.append(bulkInsert);
            if (bulkInsert != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            Log.e(f8676a, "return insert is error");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r8 != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r8.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009f, code lost:
        if (r8 != null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e A[SYNTHETIC, Splitter:B:22:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0064
            r1 = 1
            if (r8 == r1) goto L_0x004e
            r1 = 2
            if (r8 == r1) goto L_0x0038
            r1 = 3
            if (r8 == r1) goto L_0x0031
            r1 = 4
            if (r8 == r1) goto L_0x001b
            r9 = 5
            if (r8 == r9) goto L_0x0014
            r2 = r0
            goto L_0x006b
        L_0x0014:
            java.lang.String r8 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L_0x006a
        L_0x001b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L_0x006a
        L_0x0031:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L_0x006a
        L_0x0038:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L_0x006a
        L_0x004e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L_0x006a
        L_0x0064:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L_0x006a:
            r2 = r8
        L_0x006b:
            if (r2 != 0) goto L_0x006e
            return r0
        L_0x006e:
            android.content.Context r8 = r7.f8695t     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            if (r8 == 0) goto L_0x008f
            boolean r9 = r8.moveToNext()     // Catch:{ Exception -> 0x0098 }
            if (r9 == 0) goto L_0x008f
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ Exception -> 0x0098 }
            r0 = r9
        L_0x008f:
            if (r8 == 0) goto L_0x00a2
        L_0x0091:
            r8.close()
            goto L_0x00a2
        L_0x0095:
            r9 = move-exception
            goto L_0x00a5
        L_0x0097:
            r8 = r0
        L_0x0098:
            java.lang.String r9 = "VMS_SDK_DB"
            java.lang.String r1 = "return cursor is error"
            android.util.Log.e(r9, r1)     // Catch:{ all -> 0x00a3 }
            if (r8 == 0) goto L_0x00a2
            goto L_0x0091
        L_0x00a2:
            return r0
        L_0x00a3:
            r9 = move-exception
            r0 = r8
        L_0x00a5:
            if (r0 == 0) goto L_0x00aa
            r0.close()
        L_0x00aa:
            goto L_0x00ac
        L_0x00ab:
            throw r9
        L_0x00ac:
            goto L_0x00ab
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.DataBaseOperation.a(int, java.lang.String):java.lang.String");
    }

    public boolean a(int i10, String str, String str2, String str3) {
        Uri uri;
        if (i10 != 6) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            int delete = this.f8695t.getContentResolver().delete(uri, "packageName=? and uid=?", new String[]{str2, str3});
            StringBuilder sb = new StringBuilder();
            sb.append("delete:");
            sb.append(delete);
            if (delete != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            Log.e(f8676a, "return delete is error");
        }
    }
}
