package com.umeng.message;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.y;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

public class MessageSharedPrefs {

    /* renamed from: d  reason: collision with root package name */
    private static volatile MessageSharedPrefs f15209d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f15210a;

    /* renamed from: b  reason: collision with root package name */
    public final bd f15211b = new bd("push");

    /* renamed from: c  reason: collision with root package name */
    public Boolean f15212c = null;

    private MessageSharedPrefs(Context context) {
        this.f15210a = context.getApplicationContext();
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f15209d == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f15209d == null) {
                    f15209d = new MessageSharedPrefs(context);
                }
            }
        }
        return f15209d;
    }

    private void setMessageAppKey(String str) {
        if (!f.b(this.f15210a)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UPLog.e("Prefs", "appkey is empty!");
            return;
        }
        this.f15211b.a("appkey", str);
    }

    private void setMessageAppSecret(String str) {
        if (!f.b(this.f15210a)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UPLog.e("Prefs", "message secret is empty!");
            return;
        }
        this.f15211b.a("message_secret", str);
    }

    private void setMessageChannel(String str) {
        if (f.b(this.f15210a)) {
            this.f15211b.a("channel", str);
        }
    }

    public final boolean a() {
        long j10;
        Throwable th;
        try {
            j10 = this.f15211b.b(com.umeng.analytics.pro.f.f14201p, 0);
            if (j10 > 0) {
                try {
                    UPLog.i("Prefs", "today first start:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j10)));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j10 = 0;
            UPLog.e("Prefs", th);
            return f.a(j10);
        }
        return f.a(j10);
    }

    public final int b() {
        return this.f15211b.b("notification_number", 5);
    }

    public final String c() {
        return this.f15211b.b("appkey", "");
    }

    public final int d() {
        return this.f15211b.b("tag_remain", 64);
    }

    public final String e() {
        String b10 = this.f15211b.b("service_class", "");
        if (!TextUtils.isEmpty(b10)) {
            try {
                Class.forName(b10);
                return b10;
            } catch (Throwable unused) {
                UPLog.e("Prefs", "custom service not exist:", b10, "if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    public final String f() {
        return this.f15211b.b("last_click_msg_id", "");
    }

    public final int g() {
        return this.f15211b.b("mute_duration", 60);
    }

    public final String h() {
        return this.f15211b.b("res_pkg", "");
    }

    public final int i() {
        return this.f15211b.b("notification_vibrate", 0);
    }

    public final int j() {
        return this.f15211b.b("notification_light", 0);
    }

    public final int k() {
        return this.f15211b.b("notification_sound", 0);
    }

    public final String l() {
        return this.f15211b.b("device_token", "");
    }

    public final boolean m() {
        return this.f15211b.b("l_u_e", false);
    }

    public final long n() {
        return this.f15211b.b("smart_lc", 0);
    }

    public final int o() {
        return this.f15211b.b("re_pop_cfg", 0);
    }

    public final int p() {
        Calendar instance = Calendar.getInstance();
        int i10 = instance.get(1);
        int i11 = instance.get(6);
        String format = String.format(Locale.getDefault(), "%d.%d.", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)});
        String b10 = this.f15211b.b("re_pop_times", "");
        if (b10.startsWith(format)) {
            try {
                return Integer.parseInt(b10.replace(format, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final long q() {
        return this.f15211b.b("ia_last", 0);
    }

    public final long r() {
        return Math.max(0, this.f15211b.b("ia_ttl", 0));
    }

    public final int s() {
        Calendar instance = Calendar.getInstance();
        int i10 = instance.get(1);
        int i11 = instance.get(6);
        String format = String.format(Locale.getDefault(), "%d.%d.", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)});
        String b10 = this.f15211b.b("ia_times", "");
        if (b10.startsWith(format)) {
            try {
                return Integer.parseInt(b10.replace(format, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final void b(String str) {
        bd bdVar = this.f15211b;
        bdVar.a(str + bt.f13907ba);
        bd bdVar2 = this.f15211b;
        bdVar2.a(str + "ts");
    }

    public final void c(String str) {
        this.f15211b.a("last_click_msg_id", str);
    }

    public final void b(long j10) {
        this.f15211b.a("ia_ttl", j10);
    }

    public final void a(String str, String str2, int i10, long j10) {
        String str3 = str;
        String str4 = str2;
        Cursor cursor = null;
        try {
            Application a10 = y.a();
            try {
                this.f15210a.getContentResolver().delete(h.a(this.f15210a), "type=?", new String[]{str2});
            } catch (Exception e10) {
                UPLog.e("Prefs", (Throwable) e10);
            }
            String[] strArr = {str3, str4, String.valueOf(i10)};
            cursor = a10.getContentResolver().query(h.a(a10), (String[]) null, "alias=? and type=? and exclusive=?", strArr, "time desc");
            ContentValues contentValues = new ContentValues();
            contentValues.put(AgooConstants.MESSAGE_TIME, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("ttl", Long.valueOf(j10));
            contentValues.put("type", str4);
            contentValues.put("alias", str);
            contentValues.put("exclusive", Integer.valueOf(i10));
            if (cursor == null || cursor.getCount() <= 0) {
                this.f15210a.getContentResolver().insert(h.a(a10), contentValues);
            } else {
                this.f15210a.getContentResolver().update(h.a(a10), contentValues, "alias=? and type=? and exclusive=?", strArr);
            }
        } catch (Exception e11) {
            UPLog.e("Prefs", (Throwable) e11);
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                UPLog.e("Prefs", th);
            }
        }
    }

    public final void b(int i10) {
        this.f15211b.a("ia_count", i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e A[SYNTHETIC, Splitter:B:27:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b A[SYNTHETIC, Splitter:B:35:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "alias"
            java.lang.String r1 = "Prefs"
            r2 = 0
            java.lang.String r6 = "type=? and exclusive=?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r3 = 0
            r7[r3] = r11     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r11 = 1
            r7[r11] = r10     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r8 = "time desc"
            android.content.Context r10 = r9.f15210a     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.content.Context r4 = r9.f15210a     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.net.Uri r4 = com.umeng.message.proguard.h.a(r4)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r5[r3] = r0     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r3 = r10
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            if (r10 == 0) goto L_0x004a
            int r11 = r10.getCount()     // Catch:{ Exception -> 0x0048 }
            if (r11 > 0) goto L_0x0034
            goto L_0x004a
        L_0x0034:
            r10.moveToFirst()     // Catch:{ Exception -> 0x0048 }
            int r11 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x0048 }
            r10.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r10 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r10)
        L_0x0047:
            return r11
        L_0x0048:
            r11 = move-exception
            goto L_0x0059
        L_0x004a:
            if (r10 == 0) goto L_0x0054
            r10.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r10 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r10)
        L_0x0054:
            return r2
        L_0x0055:
            r11 = move-exception
            goto L_0x0069
        L_0x0057:
            r11 = move-exception
            r10 = r2
        L_0x0059:
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r11)     // Catch:{ all -> 0x0067 }
            if (r10 == 0) goto L_0x0066
            r10.close()     // Catch:{ all -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r10 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r10)
        L_0x0066:
            return r2
        L_0x0067:
            r11 = move-exception
            r2 = r10
        L_0x0069:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r10 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r1, (java.lang.Throwable) r10)
        L_0x0073:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110 A[SYNTHETIC, Splitter:B:47:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011e A[SYNTHETIC, Splitter:B:55:0x011e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r25, java.lang.String r26, java.lang.String r27) {
        /*
            r24 = this;
            r1 = r24
            r0 = r26
            r2 = r27
            java.lang.String r3 = "ttl"
            java.lang.String r4 = "alias"
            java.lang.String r5 = "type"
            java.lang.String r6 = "Prefs"
            r7 = 0
            java.lang.String r12 = "type=? and alias=? and exclusive=?"
            r15 = 3
            java.lang.String[] r13 = new java.lang.String[r15]     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r13[r7] = r2     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r16 = 1
            r13[r16] = r0     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r9 = java.lang.String.valueOf(r25)     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r14 = 2
            r13[r14] = r9     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r11 = 6
            java.lang.Object[] r9 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r9[r7] = r5     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r9[r16] = r2     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r9[r14] = r4     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r9[r15] = r0     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            java.lang.String r10 = "exclusive"
            r17 = 4
            r9[r17] = r10     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r18 = 5
            r9[r18] = r10     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            com.umeng.message.common.UPLog.i(r6, r9)     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            android.content.Context r9 = r1.f15210a     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            android.content.Context r10 = r1.f15210a     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            android.net.Uri r10 = com.umeng.message.proguard.h.a(r10)     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            r19 = 0
            r20 = 0
            r21 = 6
            r11 = r19
            r8 = 2
            r14 = r20
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0109, all -> 0x0105 }
            if (r9 != 0) goto L_0x0066
            if (r9 == 0) goto L_0x0065
            r9.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            r2 = r0
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0065:
            return r7
        L_0x0066:
            int r10 = r9.getCount()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r12 = "count"
            r11[r7] = r12     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r11[r16] = r12     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            com.umeng.message.common.UPLog.i(r6, r11)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r10 > 0) goto L_0x0085
            r9.close()     // Catch:{ all -> 0x007f }
            goto L_0x0084
        L_0x007f:
            r0 = move-exception
            r2 = r0
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0084:
            return r7
        L_0x0085:
            r9.moveToFirst()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            int r10 = r9.getColumnIndex(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            int r11 = r9.getColumnIndex(r4)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r11 = r9.getString(r11)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            int r12 = r9.getColumnIndex(r3)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            long r12 = r9.getLong(r12)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r14 = "time"
            int r14 = r9.getColumnIndex(r14)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            long r19 = r9.getLong(r14)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            long r22 = r22 - r19
            long r19 = java.lang.Math.abs(r22)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r12
            int r14 = (r19 > r22 ? 1 : (r19 == r22 ? 0 : -1))
            if (r14 >= 0) goto L_0x00be
            r14 = 1
            goto L_0x00bf
        L_0x00be:
            r14 = 0
        L_0x00bf:
            r15 = 8
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r15[r7] = r5     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r15[r16] = r10     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r15[r8] = r4     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r4 = 3
            r15[r4] = r11     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.String r4 = "alive"
            r15[r17] = r4     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r14)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r15[r18] = r4     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r15[r21] = r3     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            java.lang.Long r3 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            r4 = 7
            r15[r4] = r3     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            com.umeng.message.common.UPLog.i(r6, r15)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r14 == 0) goto L_0x00fa
            boolean r2 = android.text.TextUtils.equals(r10, r2)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r2 == 0) goto L_0x00fa
            boolean r0 = android.text.TextUtils.equals(r0, r11)     // Catch:{ Exception -> 0x0102, all -> 0x00fe }
            if (r0 == 0) goto L_0x00fa
            r9.close()     // Catch:{ all -> 0x00f4 }
            goto L_0x00f9
        L_0x00f4:
            r0 = move-exception
            r2 = r0
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x00f9:
            return r16
        L_0x00fa:
            r9.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0119
        L_0x00fe:
            r0 = move-exception
            r2 = r0
            r8 = r9
            goto L_0x011c
        L_0x0102:
            r0 = move-exception
            r8 = r9
            goto L_0x010b
        L_0x0105:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x011c
        L_0x0109:
            r0 = move-exception
            r8 = 0
        L_0x010b:
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x011a }
            if (r8 == 0) goto L_0x0119
            r8.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0119
        L_0x0114:
            r0 = move-exception
            r2 = r0
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0119:
            return r7
        L_0x011a:
            r0 = move-exception
            r2 = r0
        L_0x011c:
            if (r8 == 0) goto L_0x0127
            r8.close()     // Catch:{ all -> 0x0122 }
            goto L_0x0127
        L_0x0122:
            r0 = move-exception
            r3 = r0
            com.umeng.message.common.UPLog.e((java.lang.String) r6, (java.lang.Throwable) r3)
        L_0x0127:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String, java.lang.String):boolean");
    }

    public final void a(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Set<String> b10 = this.f15211b.b("tags", (Set<String>) new HashSet());
            b10.addAll(Arrays.asList(strArr));
            this.f15211b.a("tags", b10);
        }
    }

    public final void a(long j10) {
        a("smart_", j10);
    }

    public final void a(String str, long j10) {
        bd bdVar = this.f15211b;
        bdVar.a(str + bt.f13907ba, j10);
        bd bdVar2 = this.f15211b;
        bdVar2.a(str + "ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        bd bdVar = this.f15211b;
        long b10 = bdVar.b(str + bt.f13907ba, 0);
        if (b10 <= 0) {
            return true;
        }
        bd bdVar2 = this.f15211b;
        if (Math.abs(System.currentTimeMillis() - bdVar2.b(str + "ts", 0)) / 1000 >= b10) {
            return true;
        }
        return false;
    }

    public final void a(int i10) {
        this.f15211b.a("tag_remain", i10);
    }
}
