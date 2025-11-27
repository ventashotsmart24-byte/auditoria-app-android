package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.ah;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class InAppMessageManager {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15232a = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f15233d = 1800000;

    /* renamed from: e  reason: collision with root package name */
    public static int f15234e = 1000;

    /* renamed from: f  reason: collision with root package name */
    private static InAppMessageManager f15235f;

    /* renamed from: b  reason: collision with root package name */
    public final Context f15236b;

    /* renamed from: c  reason: collision with root package name */
    String f15237c;

    /* renamed from: g  reason: collision with root package name */
    private UInAppHandler f15238g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final bd f15239h = new bd("in_app");

    private InAppMessageManager(Context context) {
        this.f15236b = context.getApplicationContext();
        this.f15238g = new UmengInAppClickHandler();
    }

    private int d(String str) {
        return Integer.parseInt(a(str, "0"));
    }

    public static InAppMessageManager getInstance(Context context) {
        if (f15235f == null) {
            synchronized (InAppMessageManager.class) {
                if (f15235f == null) {
                    f15235f = new InAppMessageManager(context);
                }
            }
        }
        return f15235f;
    }

    public final long c(String str) {
        return Long.parseLong(a("KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str)), "0"));
    }

    public UInAppHandler getInAppHandler() {
        return this.f15238g;
    }

    public void setInAppHandler(UInAppHandler uInAppHandler) {
        this.f15238g = uInAppHandler;
    }

    public void setInAppMsgDebugMode(boolean z10) {
        f15232a = z10;
    }

    public void setMainActivityPath(String str) {
        this.f15237c = str;
    }

    public void setPlainTextSize(int i10, int i11, int i12) {
        if (i10 <= 0 || i11 <= 0 || i12 <= 0) {
            UMLog.mutlInfo("InAppMessageManager", 0, "纯文本字体大小不能小于0");
            return;
        }
        b("KEY_PLAIN_TEXT_SIZE", i10 + "," + i11 + "," + i12);
    }

    public void showCardMessage(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        if (f.b()) {
            UPLog.i("InAppMessageManager", "showCardMessage failed, silent mode!");
            return;
        }
        ah ahVar = new ah(activity, str, iUmengInAppMsgCloseCallback);
        if (TextUtils.isEmpty(ahVar.f15339c.trim())) {
            UMLog.mutlInfo(ah.f15337a, 0, "插屏消息的标签不能为空");
        } else if (!ahVar.a(ahVar.f15339c)) {
            UMLog.mutlInfo(ah.f15337a, 0, "插屏消息的最大标签数为 10");
        } else if (f15232a) {
            aj.a(ahVar.f15338b).a(ahVar.f15339c, ahVar);
        } else if (System.currentTimeMillis() - Long.parseLong(getInstance(ahVar.f15338b).a("KEY_CARD_TS_".concat(String.valueOf(ahVar.f15339c)), "0")) > ((long) f15233d)) {
            aj.a(ahVar.f15338b).a(ahVar.f15339c, ahVar);
        } else {
            ahVar.b((UInAppMessage) null);
        }
    }

    public final void a(UInAppMessage uInAppMessage) {
        if (uInAppMessage == null) {
            b("KEY_LAST_SPLASH_ID", "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_SPLASH_ID", uInAppMessage.getRaw().toString());
        }
    }

    public final void b(String str) {
        String concat = "KEY_LAST_SHOW_CARD_TS_".concat(String.valueOf(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        b(concat, sb.toString());
    }

    public final boolean c(UInAppMessage uInAppMessage) {
        if (uInAppMessage.show_times != 0 && d(uInAppMessage.msg_id) >= uInAppMessage.show_times) {
            return false;
        }
        return true;
    }

    public static boolean b(UInAppMessage uInAppMessage) {
        try {
            if (System.currentTimeMillis() < new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(uInAppMessage.expire_time).getTime()) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final String a() {
        return a("KEY_LAST_SPLASH_ID", "");
    }

    public final void a(UInAppMessage uInAppMessage, String str) {
        if (uInAppMessage == null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
        } else if (uInAppMessage.getRaw() != null) {
            b("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), uInAppMessage.getRaw().toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r1 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (r1 != null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.umeng.message.proguard.af> b() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r9.f15236b     // Catch:{ Exception -> 0x0036 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ Exception -> 0x0036 }
            android.content.Context r2 = r9.f15236b     // Catch:{ Exception -> 0x0036 }
            android.net.Uri r4 = com.umeng.message.proguard.h.e(r2)     // Catch:{ Exception -> 0x0036 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0021
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            if (r2 == 0) goto L_0x0031
            com.umeng.message.proguard.af r2 = new com.umeng.message.proguard.af     // Catch:{ Exception -> 0x0036 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0036 }
            r0.add(r2)     // Catch:{ Exception -> 0x0036 }
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0022
        L_0x0031:
            if (r1 == 0) goto L_0x003f
            goto L_0x003c
        L_0x0034:
            r0 = move-exception
            goto L_0x0040
        L_0x0036:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x003f
        L_0x003c:
            r1.close()
        L_0x003f:
            return r0
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()
        L_0x0045:
            goto L_0x0047
        L_0x0046:
            throw r0
        L_0x0047:
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.InAppMessageManager.b():java.util.ArrayList");
    }

    public final String a(String str) {
        return a("KEY_LAST_CARD_ID_".concat(String.valueOf(str)), "");
    }

    public final void a(String str, int i10) {
        if (i10 == 0) {
            b(str, "0");
        }
        if (i10 == 1) {
            b(str, String.valueOf(d(str) + 1));
        }
    }

    public final String a(String str, String str2) {
        return this.f15239h.b(str, str2);
    }

    public final void a(final File file) {
        b.c(new Runnable() {
            public final void run() {
                File file = file;
                if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (!file2.isDirectory()) {
                            file2.delete();
                        }
                    }
                    file.delete();
                }
            }
        });
    }

    public static /* synthetic */ af a(InAppMessageManager inAppMessageManager, String str) {
        Cursor query = inAppMessageManager.f15236b.getContentResolver().query(h.e(inAppMessageManager.f15236b), (String[]) null, "MsgId=?", new String[]{str}, (String) null);
        af afVar = query != null ? query.moveToFirst() : false ? new af(query) : null;
        if (query != null) {
            query.close();
        }
        return afVar;
    }

    public final void b(final String str, final String str2) {
        b.c(new Runnable() {
            public final void run() {
                try {
                    InAppMessageManager.this.f15239h.a(str, str2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
