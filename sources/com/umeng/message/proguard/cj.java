package com.umeng.message.proguard;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.bx;
import com.umeng.umzid.IZIDCompletionCallback;
import com.umeng.umzid.Spy;
import com.umeng.umzid.ZIDManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

final class cj extends ch {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f15599c = new AtomicInteger(0);

    /* renamed from: a  reason: collision with root package name */
    private final bx.c f15600a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f15601b = false;

    public cj(bx.c cVar) {
        this.f15600a = cVar;
    }

    private JSONObject b(cz czVar) {
        String str;
        String str2;
        cz czVar2 = czVar;
        if (this.f15601b) {
            ce.a("Load", "ad load too frequency");
            return null;
        }
        this.f15601b = true;
        try {
            if (dy.b()) {
                ce.d("Load", "silent mode skipped!");
                this.f15601b = false;
                return null;
            }
            if (czVar2 != null) {
                if (!TextUtils.isEmpty(czVar2.f15716a.f15545a)) {
                    Context a10 = de.a();
                    String appkey = UMUtils.getAppkey(a10);
                    if (TextUtils.isEmpty(appkey)) {
                        ce.d("Load", "appkey empty! please call UMConfigure.init(...)");
                        this.f15601b = false;
                        return null;
                    }
                    String zid = UMUtils.getZid(a10);
                    if (TextUtils.isEmpty(zid)) {
                        zid = a(a10, appkey);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("slot_id", czVar2.f15716a.f15545a);
                    jSONObject.put("v", "6.0");
                    jSONObject.put("ts", System.currentTimeMillis());
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(a10);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put(bt.Q, networkAccessMode[0]);
                    jSONObject.put(Constants.KEY_MODEL, ca.b());
                    jSONObject.put(Constants.KEY_BRAND, ca.c());
                    jSONObject.put("osv", Build.VERSION.RELEASE);
                    jSONObject.put("os", "android");
                    Point a11 = ed.a(a10);
                    jSONObject.put(BrowserInfo.KEY_WIDTH, a11.x);
                    jSONObject.put("h", a11.y);
                    String str3 = "Load";
                    jSONObject.put("s", (double) ed.a(a11));
                    jSONObject.put("app_ver", UMUtils.getAppVersionName(a10));
                    jSONObject.put("pkg_name", a10.getPackageName());
                    jSONObject.put("app_name", UMUtils.getAppName(a10));
                    jSONObject.put("app_key", appkey);
                    jSONObject.put("sdk_ver", "2.0.0");
                    jSONObject.put(bd.f13844d, a(a10));
                    boolean z10 = czVar2.f15718c;
                    jSONObject.put("render", 0);
                    if (!TextUtils.isEmpty(ca.a())) {
                        jSONObject.put("ui_ver", ca.a());
                    }
                    dt a12 = dt.a();
                    if (a12.f15882a.b("as") == 1) {
                        int b10 = a12.f15882a.b("an");
                        if (b10 > 0) {
                            AtomicInteger atomicInteger = f15599c;
                            if (atomicInteger.getAndIncrement() % b10 == 0) {
                                atomicInteger.set(1);
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                try {
                                    str = Spy.getTag(a10);
                                } catch (Throwable unused) {
                                    str = null;
                                }
                                if (str == null) {
                                    str2 = "";
                                } else {
                                    str2 = str;
                                }
                                ce.a(str3, "get tag consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                                jSONObject.put(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_AT, str2);
                            }
                        }
                    }
                    String b11 = a12.f15882a.b("et", "");
                    if (!TextUtils.isEmpty(b11)) {
                        jSONObject.put("et", b11);
                    }
                    jSONObject.put(bt.f13913g, ca.d(a10));
                    try {
                        jSONObject.put("oaid", ca.c(a10));
                        jSONObject.put("idfa", ca.a(a10));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("u2", ca.f(a10));
                    jSONObject.put("imei", ca.e(a10));
                    jSONObject.put("android_id", ca.b(a10));
                    if (zid == null) {
                        zid = "";
                    }
                    jSONObject.put(bt.al, zid);
                    jSONObject.put("b_mark", a());
                    jSONObject.put("u_mark", b());
                    JSONObject a13 = cc.a(jSONObject, bu.f15541a, appkey);
                    try {
                        a13.put("slot_id", czVar2.f15716a.f15545a);
                    } catch (Exception unused3) {
                    }
                    if (a13.optInt(Constants.KEY_HTTP_CODE, -1) == 0) {
                        String optString = a13.optString("et");
                        if (optString.length() > 2048) {
                            a12.a("");
                        } else if (!TextUtils.equals(optString, b11)) {
                            a12.a(optString);
                        }
                    }
                    if (z10) {
                        int optInt = a13.optInt("cfg_interval", -1);
                        if (optInt != -1) {
                            long j10 = (long) optInt;
                            if (j10 > 0) {
                                a12.f15882a.a(bt.f13907ba, j10);
                            }
                        }
                        int optInt2 = a13.optInt("cfg_start", -1);
                        if (optInt2 != -1) {
                            long j11 = (long) optInt2;
                            if (j11 > 0) {
                                a12.f15882a.a("delay", j11);
                            }
                        }
                    }
                    int optInt3 = a13.optInt("as");
                    int optInt4 = a13.optInt("an");
                    a12.f15882a.a("as", optInt3);
                    a12.f15882a.a("an", optInt4);
                    this.f15601b = false;
                    return a13;
                }
            }
            ce.d("Load", "config error! please setSlotId");
            this.f15601b = false;
            return null;
        } catch (Throwable th) {
            this.f15601b = false;
            throw th;
        }
    }

    public final ck a(cz czVar) {
        try {
            JSONObject b10 = b(czVar);
            if (b10 == null) {
                return new ck(this.f15600a, "request ad failure.");
            }
            int optInt = b10.optInt(Constants.KEY_HTTP_CODE, -1);
            if (optInt != 0) {
                String optString = b10.optString(Constant.KEY_MSG, "");
                ce.b("Load", "sid:", b10.optString("sid", ""), " code:", Integer.valueOf(optInt), " msg:", optString);
                return new ck(this.f15600a, "no ad, code:".concat(String.valueOf(optInt)));
            }
            int optInt2 = b10.optInt("after_clk");
            if (optInt2 > 0 && optInt2 <= 6) {
                if (optInt2 != 5) {
                    ck ckVar = new ck(b10);
                    if (!cr.a().b(ckVar)) {
                        ce.b("Load", "pre check false");
                        cr.a().b(ckVar, 2300);
                        return null;
                    }
                    bx.c cVar = ckVar.f15605a;
                    if (cVar == null) {
                        ce.b("Load", "ad type = null. error");
                        return null;
                    } else if (this.f15600a != cVar) {
                        ce.b("Load", "ad type not match req:" + this.f15600a + " resp:" + cVar);
                        return null;
                    } else {
                        ckVar.f15613i = System.currentTimeMillis();
                        return ckVar;
                    }
                }
            }
            ce.b("Load", "after_clk error:", Integer.valueOf(optInt2));
            return null;
        } catch (Throwable th) {
            ce.d("Load", "load ad ", th.getMessage());
            return null;
        }
    }

    private String a(Context context, String str) {
        final AtomicReference atomicReference = new AtomicReference();
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ZIDManager.getInstance().init(context, str, new IZIDCompletionCallback() {
                public final void onFailure(String str, String str2) {
                    try {
                        countDownLatch.countDown();
                    } catch (Throwable unused) {
                    }
                }

                public final void onSuccess(String str) {
                    try {
                        atomicReference.set(str);
                        countDownLatch.countDown();
                    } catch (Throwable unused) {
                    }
                }
            });
            countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
        return (String) atomicReference.get();
    }

    private static String a(Context context) {
        if (dy.a(context)) {
            return dy.a();
        }
        String str = null;
        try {
            Cursor query = context.getContentResolver().query(cy.b(context), (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null && query.moveToFirst()) {
                str = query.getString(query.getColumnIndex(bd.f13844d));
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    private static String a() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str = readLine;
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    private static Date a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "stat -c %x /data/data"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ all -> 0x0080 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0080 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0080 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ all -> 0x0080 }
            r3.<init>(r1)     // Catch:{ all -> 0x0080 }
            r2.<init>(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x007d
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)     // Catch:{ all -> 0x0080 }
            r3 = 0
            r4 = r1[r3]     // Catch:{ all -> 0x0080 }
            java.util.Date r4 = a((java.lang.String) r4)     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r5.<init>()     // Catch:{ all -> 0x0080 }
            long r6 = r4.getTime()     // Catch:{ all -> 0x0080 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            r5.append(r6)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = "."
            r5.append(r4)     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0080 }
            r4 = 1
            r1 = r1[r4]     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0052
            java.lang.String r4 = " "
            java.lang.String[] r1 = r1.split(r4)     // Catch:{ all -> 0x0080 }
            r1 = r1[r3]     // Catch:{ all -> 0x0080 }
            goto L_0x0054
        L_0x0052:
            java.lang.String r1 = ""
        L_0x0054:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0080 }
            if (r4 != 0) goto L_0x006e
            int r3 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x005e }
        L_0x005e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r1.<init>()     // Catch:{ all -> 0x0080 }
            r1.append(r0)     // Catch:{ all -> 0x0080 }
            r1.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0080 }
            goto L_0x007d
        L_0x006e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r1.<init>()     // Catch:{ all -> 0x0080 }
            r1.append(r0)     // Catch:{ all -> 0x0080 }
            r1.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0080 }
        L_0x007d:
            r2.close()     // Catch:{ all -> 0x0080 }
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cj.b():java.lang.String");
    }
}
