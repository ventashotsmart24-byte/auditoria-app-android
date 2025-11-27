package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.uyumao.sdk.UYMManager;
import java.lang.reflect.Method;

public class ZIDManager {

    /* renamed from: d  reason: collision with root package name */
    public static ZIDManager f16200d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f16201a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16202b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16203c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f16205b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f16204a = context;
            this.f16205b = iZIDCompletionCallback;
        }

        public void run() {
            String a10 = ZIDManager.a(ZIDManager.this, this.f16204a);
            if (TextUtils.isEmpty(a10)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f16205b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure(LelinkSourceSDK.FEEDBACK_PUSH_BLACK, "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f16205b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a10);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16207a;

        public b(Context context) {
            this.f16207a = context;
        }

        public void run() {
            ZIDManager.this.b(this.f16207a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f16209a;

        public c(Context context) {
            this.f16209a = context;
        }

        public void run() {
            ZIDManager.a(ZIDManager.this, this.f16209a);
        }
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences a10;
        SharedPreferences.Editor edit;
        String b10 = d.b(str);
        if (context != null && b10 != null && !TextUtils.isEmpty(b10) && (a10 = a.a(context)) != null && (edit = a10.edit()) != null) {
            edit.putString("inputDomain", b10).commit();
        }
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f16200d == null) {
                f16200d = new ZIDManager();
            }
            zIDManager = f16200d;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.6";
    }

    public final void a(Context context) {
        Object invoke;
        Class<UYMManager> cls = UYMManager.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null && (invoke = declaredMethod.invoke(cls, new Object[0])) != null) {
                Method declaredMethod2 = cls.getDeclaredMethod("init", new Class[]{Context.class});
                if (declaredMethod2 != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(invoke, new Object[]{context});
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084 A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0095 A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9 A[SYNTHETIC, Splitter:B:41:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9 A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9 A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012a A[Catch:{ all -> 0x0172 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "uabc"
            java.lang.String r1 = "aaid"
            r2 = 0
            r3 = 1
            java.lang.String r4 = com.umeng.umzid.d.c((android.content.Context) r14)     // Catch:{ JSONException -> 0x001f }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001f }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x001f }
            java.lang.String r4 = "ets"
            long r4 = r5.optLong(r4)     // Catch:{ JSONException -> 0x001f }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x001f }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x001f:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0023:
            r4 = 1
        L_0x0024:
            r5 = 0
            if (r4 != 0) goto L_0x0028
            return r5
        L_0x0028:
            boolean r4 = r13.f16202b
            if (r4 == 0) goto L_0x002d
            return r5
        L_0x002d:
            r13.f16202b = r3
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r6 = ""
            if (r14 == 0) goto L_0x0045
            android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r14)     // Catch:{ all -> 0x0172 }
            if (r7 == 0) goto L_0x0045
            java.lang.String r8 = "zdata"
            java.lang.String r7 = r7.getString(r8, r5)     // Catch:{ all -> 0x0172 }
            goto L_0x0046
        L_0x0045:
            r7 = r6
        L_0x0046:
            java.lang.String r8 = com.umeng.umzid.Spy.getID()     // Catch:{ all -> 0x0172 }
            java.lang.String r9 = "z"
            r4.put(r9, r8)     // Catch:{ all -> 0x0172 }
            java.lang.String r9 = "o_z"
            r4.put(r9, r7)     // Catch:{ all -> 0x0172 }
            if (r14 == 0) goto L_0x006d
            android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r14)     // Catch:{ all -> 0x0172 }
            if (r7 == 0) goto L_0x006d
            java.lang.String r9 = "oaid"
            java.lang.String r7 = r7.getString(r9, r6)     // Catch:{ all -> 0x0172 }
            boolean r9 = com.umeng.umzid.d.c((java.lang.String) r7)     // Catch:{ all -> 0x0172 }
            if (r9 == 0) goto L_0x006e
            java.lang.String r7 = com.umeng.umzid.d.a((java.lang.String) r7)     // Catch:{ all -> 0x0172 }
            goto L_0x006e
        L_0x006d:
            r7 = r6
        L_0x006e:
            java.lang.String r9 = com.umeng.umzid.d.f(r14)     // Catch:{ all -> 0x0172 }
            java.lang.String r10 = "o_o"
            r4.put(r10, r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = "o"
            r4.put(r7, r9)     // Catch:{ all -> 0x0172 }
            if (r14 == 0) goto L_0x0095
            android.content.SharedPreferences r7 = com.umeng.umzid.a.a(r14)     // Catch:{ all -> 0x0172 }
            if (r7 == 0) goto L_0x0095
            java.lang.String r10 = "mac"
            java.lang.String r7 = r7.getString(r10, r6)     // Catch:{ all -> 0x0172 }
            boolean r10 = com.umeng.umzid.d.c((java.lang.String) r7)     // Catch:{ all -> 0x0172 }
            if (r10 == 0) goto L_0x0096
            java.lang.String r7 = com.umeng.umzid.d.a((java.lang.String) r7)     // Catch:{ all -> 0x0172 }
            goto L_0x0096
        L_0x0095:
            r7 = r6
        L_0x0096:
            java.lang.String r10 = com.umeng.umzid.d.e(r14)     // Catch:{ all -> 0x0172 }
            java.lang.String r11 = "mc"
            r4.put(r11, r10)     // Catch:{ all -> 0x0172 }
            java.lang.String r11 = "o_mc"
            r4.put(r11, r7)     // Catch:{ all -> 0x0172 }
            r13.a((android.content.Context) r14, (org.json.JSONObject) r4)     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = com.umeng.umzid.d.d(r14)     // Catch:{ all -> 0x0172 }
            r4.put(r1, r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = com.umeng.umzid.d.c((android.content.Context) r14)     // Catch:{ all -> 0x0172 }
            r4.put(r0, r7)     // Catch:{ all -> 0x0172 }
            java.lang.String r7 = "resetToken"
            if (r14 == 0) goto L_0x00c3
            android.content.SharedPreferences r11 = com.umeng.umzid.a.a(r14)     // Catch:{ all -> 0x0172 }
            if (r11 == 0) goto L_0x00c3
            java.lang.String r6 = r11.getString(r7, r6)     // Catch:{ all -> 0x0172 }
        L_0x00c3:
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0172 }
            if (r11 != 0) goto L_0x00ce
            java.lang.String r11 = "rt"
            r4.put(r11, r6)     // Catch:{ all -> 0x0172 }
        L_0x00ce:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00f1 }
            r6.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r11 = "vpn_pxy"
            boolean r12 = com.umeng.umzid.d.i(r14)     // Catch:{ all -> 0x00ef }
            r6.put(r11, r12)     // Catch:{ all -> 0x00ef }
            java.lang.String r11 = "wifi_pxy"
            boolean r12 = com.umeng.umzid.d.j(r14)     // Catch:{ all -> 0x00ef }
            r6.put(r11, r12)     // Catch:{ all -> 0x00ef }
            java.lang.String r11 = "double"
            boolean r12 = com.umeng.umzid.d.g(r14)     // Catch:{ all -> 0x00ef }
            r6.put(r11, r12)     // Catch:{ all -> 0x00ef }
            goto L_0x00f7
        L_0x00ef:
            r11 = move-exception
            goto L_0x00f4
        L_0x00f1:
            r6 = move-exception
            r11 = r6
            r6 = r5
        L_0x00f4:
            r11.printStackTrace()     // Catch:{ all -> 0x0172 }
        L_0x00f7:
            if (r6 == 0) goto L_0x00fe
            java.lang.String r11 = "anti"
            r4.put(r11, r6)     // Catch:{ all -> 0x0172 }
        L_0x00fe:
            java.lang.String r6 = com.umeng.umzid.d.b((android.content.Context) r14)     // Catch:{ all -> 0x0172 }
            int r11 = r6.length()     // Catch:{ all -> 0x0172 }
            if (r11 <= 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            java.lang.String r6 = "https://utoken.umeng.com"
        L_0x010b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0172 }
            r11.<init>()     // Catch:{ all -> 0x0172 }
            r11.append(r6)     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = "/anti/updateZdata"
            r11.append(r6)     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = com.umeng.umzid.a.a((java.lang.String) r6, (java.lang.String) r4)     // Catch:{ all -> 0x0172 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0172 }
            if (r6 != 0) goto L_0x016f
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0172 }
            r6.<init>(r4)     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = "suc"
            boolean r4 = r6.optBoolean(r4)     // Catch:{ all -> 0x0172 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0172 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0172 }
            if (r4 != r3) goto L_0x016f
            com.umeng.umzid.d.f(r14, r8)     // Catch:{ all -> 0x0172 }
            com.umeng.umzid.d.a(r14, r10)     // Catch:{ all -> 0x0172 }
            com.umeng.umzid.d.b(r14, r9)     // Catch:{ all -> 0x0172 }
            java.lang.String r5 = r6.optString(r1)     // Catch:{ all -> 0x0172 }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0172 }
            if (r1 != 0) goto L_0x0155
            com.umeng.umzid.d.e(r14, r5)     // Catch:{ all -> 0x0172 }
        L_0x0155:
            java.lang.String r0 = r6.optString(r0)     // Catch:{ all -> 0x0172 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0172 }
            if (r1 != 0) goto L_0x0162
            com.umeng.umzid.d.d(r14, r0)     // Catch:{ all -> 0x0172 }
        L_0x0162:
            java.lang.String r0 = r6.optString(r7)     // Catch:{ all -> 0x0172 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0172 }
            if (r1 != 0) goto L_0x016f
            com.umeng.umzid.d.c(r14, r0)     // Catch:{ all -> 0x0172 }
        L_0x016f:
            r13.a(r14)     // Catch:{ all -> 0x0172 }
        L_0x0172:
            r13.f16202b = r2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String d10 = d.d(applicationContext);
        if (!TextUtils.isEmpty(d10)) {
            return d10;
        }
        c.a(new c(applicationContext));
        return "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a5, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.d.h(r4)     // Catch:{ all -> 0x00a6 }
            r3.f16203c = r0     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r3)
            return
        L_0x000b:
            if (r4 != 0) goto L_0x0018
            if (r6 == 0) goto L_0x0016
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch:{ all -> 0x00a6 }
        L_0x0016:
            monitor-exit(r3)
            return
        L_0x0018:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0029
            if (r6 == 0) goto L_0x0027
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch:{ all -> 0x00a6 }
        L_0x0027:
            monitor-exit(r3)
            return
        L_0x0029:
            android.content.Context r0 = r4.getApplicationContext()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x004c
            if (r5 == 0) goto L_0x004c
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x004c
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x004c
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x004c
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch:{ all -> 0x00a6 }
            r5.commit()     // Catch:{ all -> 0x00a6 }
        L_0x004c:
            java.lang.String r5 = com.umeng.umzid.d.d(r0)     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x0067
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch:{ all -> 0x00a6 }
            r1.<init>(r0)     // Catch:{ all -> 0x00a6 }
            com.umeng.umzid.c.a(r1)     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x006f
            r6.onSuccess(r5)     // Catch:{ all -> 0x00a6 }
            goto L_0x006f
        L_0x0067:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch:{ all -> 0x00a6 }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x00a6 }
            com.umeng.umzid.c.a(r5)     // Catch:{ all -> 0x00a6 }
        L_0x006f:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x007f
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch:{ all -> 0x00a6 }
        L_0x007f:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch:{ all -> 0x00a6 }
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0094 }
            goto L_0x0095
        L_0x0094:
        L_0x0095:
            if (r4 == 0) goto L_0x00a4
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch:{ all -> 0x00a6 }
            r4.commit()     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r3)
            return
        L_0x00a6:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[Catch:{ all -> 0x00d9, all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[Catch:{ all -> 0x00d9, all -> 0x00e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager r10, android.content.Context r11) {
        /*
            boolean r0 = r10.f16201a
            r1 = 0
            if (r0 == 0) goto L_0x0007
            goto L_0x00df
        L_0x0007:
            r0 = 1
            r10.f16201a = r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            java.lang.String r4 = com.umeng.umzid.Spy.getID()     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = "z"
            r2.put(r5, r4)     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = com.umeng.umzid.d.e(r11)     // Catch:{ all -> 0x00d9 }
            java.lang.String r6 = "mc"
            r2.put(r6, r5)     // Catch:{ all -> 0x00d9 }
            java.lang.String r6 = com.umeng.umzid.d.f(r11)     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = "o"
            r2.put(r7, r6)     // Catch:{ all -> 0x00d9 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x004e }
            r7.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r8 = "vpn_pxy"
            boolean r9 = com.umeng.umzid.d.i(r11)     // Catch:{ all -> 0x004c }
            r7.put(r8, r9)     // Catch:{ all -> 0x004c }
            java.lang.String r8 = "wifi_pxy"
            boolean r9 = com.umeng.umzid.d.j(r11)     // Catch:{ all -> 0x004c }
            r7.put(r8, r9)     // Catch:{ all -> 0x004c }
            java.lang.String r8 = "double"
            boolean r9 = com.umeng.umzid.d.g(r11)     // Catch:{ all -> 0x004c }
            r7.put(r8, r9)     // Catch:{ all -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r8 = move-exception
            goto L_0x0051
        L_0x004e:
            r7 = move-exception
            r8 = r7
            r7 = r1
        L_0x0051:
            r8.printStackTrace()     // Catch:{ all -> 0x00d9 }
        L_0x0054:
            if (r7 == 0) goto L_0x005b
            java.lang.String r8 = "anti"
            r2.put(r8, r7)     // Catch:{ all -> 0x00d9 }
        L_0x005b:
            r10.a((android.content.Context) r11, (org.json.JSONObject) r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = com.umeng.umzid.d.b((android.content.Context) r11)     // Catch:{ all -> 0x00d9 }
            int r8 = r7.length()     // Catch:{ all -> 0x00d9 }
            if (r8 <= 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            java.lang.String r7 = "https://utoken.umeng.com"
        L_0x006b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d9 }
            r8.<init>()     // Catch:{ all -> 0x00d9 }
            r8.append(r7)     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = "/anti/postZdata"
            r8.append(r7)     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = com.umeng.umzid.a.a((java.lang.String) r7, (java.lang.String) r2)     // Catch:{ all -> 0x00d9 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00d9 }
            if (r7 != 0) goto L_0x00d5
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x00d9 }
            r7.<init>(r2)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "suc"
            boolean r2 = r7.optBoolean(r2)     // Catch:{ all -> 0x00d9 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00d9 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00d9 }
            if (r2 != r0) goto L_0x00d5
            com.umeng.umzid.d.f(r11, r4)     // Catch:{ all -> 0x00d9 }
            com.umeng.umzid.d.a(r11, r5)     // Catch:{ all -> 0x00d9 }
            com.umeng.umzid.d.b(r11, r6)     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = "aaid"
            java.lang.String r1 = r7.optString(r0)     // Catch:{ all -> 0x00d9 }
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00b7
            com.umeng.umzid.d.e(r11, r1)     // Catch:{ all -> 0x00d9 }
        L_0x00b7:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r7.optString(r0)     // Catch:{ all -> 0x00d9 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00d9 }
            if (r2 != 0) goto L_0x00c6
            com.umeng.umzid.d.d(r11, r0)     // Catch:{ all -> 0x00d9 }
        L_0x00c6:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r7.optString(r0)     // Catch:{ all -> 0x00d9 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00d9 }
            if (r2 != 0) goto L_0x00d5
            com.umeng.umzid.d.c(r11, r0)     // Catch:{ all -> 0x00d9 }
        L_0x00d5:
            r10.a(r11)     // Catch:{ all -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x00e0 }
        L_0x00dd:
            r10.f16201a = r3
        L_0x00df:
            return r1
        L_0x00e0:
            r11 = move-exception
            r10.f16201a = r3
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad A[SYNTHETIC, Splitter:B:32:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018f A[Catch:{ all -> 0x01a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject a(android.content.Context r11, org.json.JSONObject r12) {
        /*
            r10 = this;
            java.lang.Class<android.content.Context> r0 = android.content.Context.class
            java.lang.Class<com.umeng.commonsdk.statistics.common.DeviceConfig> r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.class
            java.lang.String r2 = ""
            java.lang.String r3 = com.umeng.umzid.Spy.getVersion()
            java.lang.String r4 = "z_v"
            r12.putOpt(r4, r3)
            java.lang.String r3 = com.umeng.umzid.d.a((android.content.Context) r11)
            java.lang.String r4 = "a_id"
            r12.putOpt(r4, r3)
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            java.lang.String r4 = "os_v"
            r12.putOpt(r4, r3)
            r3 = 0
            if (r11 != 0) goto L_0x0023
            goto L_0x0050
        L_0x0023:
            android.content.res.Configuration r4 = new android.content.res.Configuration     // Catch:{ all -> 0x0035 }
            r4.<init>()     // Catch:{ all -> 0x0035 }
            r4.setToDefaults()     // Catch:{ all -> 0x0035 }
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch:{ all -> 0x0035 }
            android.provider.Settings.System.getConfiguration(r5, r4)     // Catch:{ all -> 0x0035 }
            java.util.Locale r4 = r4.locale     // Catch:{ all -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            r4 = r3
        L_0x0037:
            if (r4 != 0) goto L_0x003d
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0050 }
        L_0x003d:
            java.util.Calendar r4 = java.util.Calendar.getInstance(r4)     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x0050
            java.util.TimeZone r4 = r4.getTimeZone()     // Catch:{ all -> 0x0050 }
            int r4 = r4.getRawOffset()     // Catch:{ all -> 0x0050 }
            r5 = 3600000(0x36ee80, float:5.044674E-39)
            int r4 = r4 / r5
            goto L_0x0052
        L_0x0050:
            r4 = 8
        L_0x0052:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "tz"
            r12.putOpt(r5, r4)
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r5 = "m"
            r12.putOpt(r5, r4)
            r4 = 0
            r5 = 1
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = "getImeiNew"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x0086 }
            r7[r4] = r0     // Catch:{ all -> 0x0086 }
            java.lang.reflect.Method r6 = r1.getDeclaredMethod(r6, r7)     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0086
            r6.setAccessible(r5)     // Catch:{ all -> 0x0086 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x0086 }
            r7[r4] = r11     // Catch:{ all -> 0x0086 }
            java.lang.Object r6 = r6.invoke(r1, r7)     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0086
            boolean r7 = r6 instanceof java.lang.String     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0086
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r6 = r2
        L_0x0087:
            java.lang.String r7 = "im"
            r12.putOpt(r7, r6)
            java.lang.Class<android.os.Build> r6 = android.os.Build.class
            java.lang.String r7 = "getString"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00e5 }
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            r8[r4] = r9     // Catch:{ Exception -> 0x00e5 }
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch:{ Exception -> 0x00e5 }
            r6.setAccessible(r5)     // Catch:{ Exception -> 0x00e5 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r8 = "net.hostname"
            r7[r4] = r8     // Catch:{ Exception -> 0x00e5 }
            java.lang.Object r6 = r6.invoke(r3, r7)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e5 }
            if (r6 == 0) goto L_0x00e7
            boolean r7 = r6.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x00e3 }
            if (r7 != 0) goto L_0x00e7
            java.lang.String r7 = "MD5"
            java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ all -> 0x00e0 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x00e0 }
            r7.update(r6)     // Catch:{ all -> 0x00e0 }
            byte[] r6 = r7.digest()     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ all -> 0x00e0 }
            r7.<init>()     // Catch:{ all -> 0x00e0 }
            r8 = 0
        L_0x00ca:
            int r9 = r6.length     // Catch:{ all -> 0x00e0 }
            if (r8 >= r9) goto L_0x00db
            byte r9 = r6[r8]     // Catch:{ all -> 0x00e0 }
            r9 = r9 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)     // Catch:{ all -> 0x00e0 }
            r7.append(r9)     // Catch:{ all -> 0x00e0 }
            int r8 = r8 + 1
            goto L_0x00ca
        L_0x00db:
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00e0 }
            goto L_0x00e7
        L_0x00e0:
            r6 = r2
            goto L_0x00e7
        L_0x00e3:
            goto L_0x00e7
        L_0x00e5:
            r6 = r3
        L_0x00e7:
            java.lang.String r7 = "hn"
            r12.putOpt(r7, r6)
            java.lang.String r6 = "s_v"
            java.lang.String r7 = "1.8.6"
            r12.putOpt(r6, r7)
            if (r11 != 0) goto L_0x00f7
            r6 = r3
            goto L_0x00fb
        L_0x00f7:
            java.lang.String r6 = r11.getPackageName()
        L_0x00fb:
            java.lang.String r7 = "pkg"
            r12.putOpt(r7, r6)
            java.lang.String r6 = "s_t"
            java.lang.String r7 = "Android"
            r12.putOpt(r6, r7)
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r11)
            if (r6 == 0) goto L_0x0114
            java.lang.String r7 = "uuid"
            java.lang.String r6 = r6.getString(r7, r2)
            goto L_0x0115
        L_0x0114:
            r6 = r2
        L_0x0115:
            java.lang.String r7 = "uid"
            r12.putOpt(r7, r6)
            java.lang.String r6 = "s_id"
            java.lang.String r7 = "umeng"
            r12.putOpt(r6, r7)
            android.content.pm.PackageManager r6 = r11.getPackageManager()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r7 = r11.getPackageName()     // Catch:{ Exception -> 0x0130 }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r7, r4)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = r6.versionName     // Catch:{ Exception -> 0x0130 }
            goto L_0x0135
        L_0x0130:
            r6 = move-exception
            r6.printStackTrace()
            r6 = r3
        L_0x0135:
            java.lang.String r7 = "a_v"
            r12.putOpt(r7, r6)
            android.content.pm.PackageManager r6 = r11.getPackageManager()     // Catch:{ Exception -> 0x014b }
            android.content.pm.ApplicationInfo r7 = r11.getApplicationInfo()     // Catch:{ Exception -> 0x014b }
            java.lang.CharSequence r6 = r6.getApplicationLabel(r7)     // Catch:{ Exception -> 0x014b }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x014b }
            goto L_0x0150
        L_0x014b:
            r6 = move-exception
            r6.printStackTrace()
            r6 = r3
        L_0x0150:
            java.lang.String r7 = "a_n"
            r12.putOpt(r7, r6)
            android.content.res.Resources r6 = r11.getResources()     // Catch:{ Exception -> 0x0164 }
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch:{ Exception -> 0x0164 }
            java.util.Locale r6 = r6.locale     // Catch:{ Exception -> 0x0164 }
            java.lang.String r6 = r6.getCountry()     // Catch:{ Exception -> 0x0164 }
            goto L_0x0169
        L_0x0164:
            r6 = move-exception
            r6.printStackTrace()
            r6 = r3
        L_0x0169:
            java.lang.String r7 = "c"
            r12.putOpt(r7, r6)
            if (r11 == 0) goto L_0x017c
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r11)
            if (r6 == 0) goto L_0x017c
            java.lang.String r7 = "appkey"
            java.lang.String r3 = r6.getString(r7, r3)
        L_0x017c:
            java.lang.String r6 = "ak"
            r12.putOpt(r6, r3)
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW     // Catch:{ all -> 0x01a3 }
            java.lang.String r3 = "getIdfa"
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x01a3 }
            r6[r4] = r0     // Catch:{ all -> 0x01a3 }
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r3, r6)     // Catch:{ all -> 0x01a3 }
            if (r0 == 0) goto L_0x01a3
            r0.setAccessible(r5)     // Catch:{ all -> 0x01a3 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x01a3 }
            r3[r4] = r11     // Catch:{ all -> 0x01a3 }
            java.lang.Object r11 = r0.invoke(r1, r3)     // Catch:{ all -> 0x01a3 }
            if (r11 == 0) goto L_0x01a3
            boolean r0 = r11 instanceof java.lang.String     // Catch:{ all -> 0x01a3 }
            if (r0 == 0) goto L_0x01a3
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01a3 }
            r2 = r11
        L_0x01a3:
            java.lang.String r11 = "gd"
            r12.putOpt(r11, r2)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }
}
