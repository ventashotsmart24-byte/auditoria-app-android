package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.taobao.accs.common.Constants;

class b {

    /* renamed from: e  reason: collision with root package name */
    private static volatile b f8649e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8650f = false;

    /* renamed from: a  reason: collision with root package name */
    OpenId f8651a = new OpenId("udid");

    /* renamed from: b  reason: collision with root package name */
    OpenId f8652b = new OpenId("oaid");

    /* renamed from: c  reason: collision with root package name */
    OpenId f8653c = new OpenId("aaid");

    /* renamed from: d  reason: collision with root package name */
    OpenId f8654d = new OpenId("vaid");

    /* renamed from: g  reason: collision with root package name */
    private SupportInfo f8655g = new SupportInfo();

    /* renamed from: h  reason: collision with root package name */
    private BroadcastReceiver f8656h;

    private b() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.content.Context r10, org.repackage.com.meizu.flyme.openidsdk.OpenId r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f8640c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a((java.lang.String) r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch:{ Exception -> 0x00a2 }
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r6 = r11.f8640c     // Catch:{ Exception -> 0x00a2 }
            r8 = 0
            r5[r8] = r6     // Catch:{ Exception -> 0x00a2 }
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a2 }
            if (r1 == 0) goto L_0x007e
            org.repackage.com.meizu.flyme.openidsdk.ValueData r2 = a((android.database.Cursor) r1)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r0 = r2.f8646a     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r11.a((java.lang.String) r0)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            long r3 = r2.f8648c     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r11.a((long) r3)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            int r3 = r2.f8647b     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r11.a((int) r3)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.<init>()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = r11.f8640c     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.append(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            int r11 = r11.f8641d     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.append(r11)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            a((java.lang.String) r11)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            int r11 = r2.f8647b     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L_0x0093
            r9.b(r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            boolean r11 = r9.a((android.content.Context) r10, (boolean) r8)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r11 != 0) goto L_0x0093
            boolean r10 = r9.a((android.content.Context) r10, (boolean) r7)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r10 = r11.concat(r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
        L_0x007a:
            a((java.lang.String) r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            goto L_0x0093
        L_0x007e:
            boolean r11 = r9.a((android.content.Context) r10, (boolean) r8)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            if (r11 == 0) goto L_0x0093
            boolean r10 = r9.a((android.content.Context) r10, (boolean) r7)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r10 = r11.concat(r10)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            goto L_0x007a
        L_0x0093:
            if (r1 == 0) goto L_0x00bf
            r1.close()
            goto L_0x00bf
        L_0x0099:
            r10 = move-exception
            r0 = r1
            goto L_0x00c0
        L_0x009c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L_0x00a4
        L_0x00a0:
            r10 = move-exception
            goto L_0x00c0
        L_0x00a2:
            r10 = move-exception
            r11 = r0
        L_0x00a4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x00a0 }
            r1.append(r10)     // Catch:{ all -> 0x00a0 }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x00a0 }
            a((java.lang.String) r10)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x00be
            r0.close()
        L_0x00be:
            r0 = r11
        L_0x00bf:
            return r0
        L_0x00c0:
            if (r0 == 0) goto L_0x00c5
            r0.close()
        L_0x00c5:
            goto L_0x00c7
        L_0x00c6:
            throw r10
        L_0x00c7:
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.b(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.OpenId):java.lang.String");
    }

    public final String a(Context context, OpenId openId) {
        String str;
        if (openId == null) {
            str = "getId, openId = null.";
        } else if (openId.a()) {
            return openId.f8639b;
        } else {
            if (a(context, true)) {
                return b(context, openId);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            a("getAppVersion, Exception : " + e10.getMessage());
            return null;
        }
    }

    private static ValueData a(Cursor cursor) {
        String str;
        ValueData valueData = new ValueData((String) null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (cursor.isClosed()) {
            str = "parseValue fail, cursor is closed.";
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                valueData.f8646a = cursor.getString(columnIndex);
            } else {
                a("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex(Constants.KEY_HTTP_CODE);
            if (columnIndex2 >= 0) {
                valueData.f8647b = cursor.getInt(columnIndex2);
            } else {
                a("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex(DialogManager.DIALOG_EXPIRED);
            if (columnIndex3 >= 0) {
                valueData.f8648c = cursor.getLong(columnIndex3);
            } else {
                a("parseExpired fail, index < 0.");
            }
            return valueData;
        }
        a(str);
        return valueData;
    }

    private synchronized void b(Context context) {
        if (this.f8656h == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            a aVar = new a();
            this.f8656h = aVar;
            context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", (Handler) null);
        }
    }

    public static final b a() {
        if (f8649e == null) {
            synchronized (b.class) {
                if (f8649e == null) {
                    f8649e = new b();
                }
            }
        }
        return f8649e;
    }

    public static void a(String str) {
    }

    public static void a(boolean z10) {
        f8650f = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (r7 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (r7 == null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a((java.lang.String) r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x0042 }
            r3 = 0
            r4 = 0
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = "supported"
            r5[r0] = r6     // Catch:{ Exception -> 0x0042 }
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0042 }
            if (r7 == 0) goto L_0x003a
            org.repackage.com.meizu.flyme.openidsdk.ValueData r1 = a((android.database.Cursor) r7)     // Catch:{ Exception -> 0x0042 }
            int r2 = r1.f8647b     // Catch:{ Exception -> 0x0042 }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r2) goto L_0x0035
            java.lang.String r2 = "0"
            java.lang.String r1 = r1.f8646a     // Catch:{ Exception -> 0x0042 }
            boolean r1 = r2.equals(r1)     // Catch:{ Exception -> 0x0042 }
            if (r1 == 0) goto L_0x0036
        L_0x0035:
            r0 = 1
        L_0x0036:
            r7.close()
            return r0
        L_0x003a:
            if (r7 == 0) goto L_0x005b
        L_0x003c:
            r7.close()
            goto L_0x005b
        L_0x0040:
            r8 = move-exception
            goto L_0x005c
        L_0x0042:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch:{ all -> 0x0040 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0040 }
            r1.append(r8)     // Catch:{ all -> 0x0040 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0040 }
            a((java.lang.String) r8)     // Catch:{ all -> 0x0040 }
            if (r7 == 0) goto L_0x005b
            goto L_0x003c
        L_0x005b:
            return r0
        L_0x005c:
            if (r7 == 0) goto L_0x0061
            r7.close()
        L_0x0061:
            goto L_0x0063
        L_0x0062:
            throw r8
        L_0x0063:
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.b.a(android.content.Context):boolean");
    }

    public final boolean a(Context context, boolean z10) {
        if (this.f8655g.a() && !z10) {
            return this.f8655g.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String a10 = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(a10)) {
            return false;
        }
        String b10 = b(packageManager, a10);
        if (!this.f8655g.a() || !this.f8655g.a(b10)) {
            this.f8655g.b(b10);
            boolean a11 = a(context);
            a("query support, result : ".concat(String.valueOf(a11)));
            this.f8655g.a(a11);
            return a11;
        }
        a("use same version cache, safeVersion : ".concat(String.valueOf(b10)));
        return this.f8655g.b();
    }
}
