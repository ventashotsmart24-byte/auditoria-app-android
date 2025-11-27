package com.efs.sdk.launch;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f5361a;

    /* renamed from: b  reason: collision with root package name */
    private static long f5362b;

    /* renamed from: c  reason: collision with root package name */
    private static long f5363c;

    /* renamed from: d  reason: collision with root package name */
    private static long f5364d;

    /* renamed from: e  reason: collision with root package name */
    private static long f5365e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f5366f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f5367g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f5368h;

    /* renamed from: i  reason: collision with root package name */
    private static long f5369i;

    /* renamed from: j  reason: collision with root package name */
    private static long f5370j;

    /* renamed from: k  reason: collision with root package name */
    private static int f5371k;

    /* renamed from: l  reason: collision with root package name */
    private static List<EfsJSONLog> f5372l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private static Map<String, Long[]> f5373m = new HashMap();

    public static void a(Activity activity, String str, boolean z10) {
        long currentTimeMillis;
        Context applicationContext;
        String name;
        int i10;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        String str2 = str;
        if (TextUtils.equals(str2, LaunchManager.PAGE_ON_CREATE)) {
            if (z10) {
                boolean z11 = LaunchManager.isDebug;
                f5364d = System.currentTimeMillis();
            }
        } else if (TextUtils.equals(str2, LaunchManager.PAGE_ON_RE_START)) {
            if (z10 && f5371k == 0) {
                boolean z12 = LaunchManager.isDebug;
                f5365e = System.currentTimeMillis();
                f5367g = true;
            }
        } else if (TextUtils.equals(str2, LaunchManager.PAGE_ON_START)) {
            if (z10) {
                boolean z13 = LaunchManager.isDebug;
                f5371k++;
                f5368h = true;
            }
        } else if (TextUtils.equals(str2, LaunchManager.PAGE_ON_RESUME)) {
            if (!z10) {
                boolean z14 = LaunchManager.isDebug;
                if (f5366f) {
                    f5366f = false;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j19 = currentTimeMillis2 - f5363c;
                    if (LaunchManager.isDebug) {
                        "loadTime is ".concat(String.valueOf(j19));
                    }
                    long j20 = currentTimeMillis2 - f5361a;
                    if (LaunchManager.isDebug) {
                        "======>>>>>> coldTime is ".concat(String.valueOf(j20));
                    }
                    boolean z15 = !c.d(activity.getApplicationContext());
                    if (LaunchManager.isDebug) {
                        "type is ".concat(String.valueOf(z15));
                    }
                    a(activity.getApplicationContext(), z15 ? 1 : 0, activity.getClass().getName(), j20, f5361a, f5362b, f5369i, f5363c, f5370j, currentTimeMillis2, j19, 0, 0, f5373m);
                } else if (f5371k == 1) {
                    if (f5367g) {
                        f5367g = false;
                        j18 = System.currentTimeMillis() - f5365e;
                        if (LaunchManager.isDebug) {
                            "======>>>>>> hotTime is ".concat(String.valueOf(j18));
                        }
                        applicationContext = activity.getApplicationContext();
                        name = activity.getClass().getName();
                        i10 = 2;
                        j10 = 0;
                        j11 = 0;
                        j12 = 0;
                        j13 = 0;
                        j14 = 0;
                        j15 = 0;
                        j16 = 0;
                        j17 = 0;
                        currentTimeMillis = 0;
                    } else if (f5368h) {
                        currentTimeMillis = System.currentTimeMillis() - f5364d;
                        if (LaunchManager.isDebug) {
                            "======>>>>>> warmTime is ".concat(String.valueOf(currentTimeMillis));
                        }
                        applicationContext = activity.getApplicationContext();
                        name = activity.getClass().getName();
                        i10 = 3;
                        j10 = 0;
                        j11 = 0;
                        j12 = 0;
                        j13 = 0;
                        j14 = 0;
                        j15 = 0;
                        j16 = 0;
                        j17 = 0;
                        j18 = 0;
                    }
                    a(applicationContext, i10, name, j10, j11, j12, j13, j14, j15, j16, j17, j18, currentTimeMillis, f5373m);
                }
                f5368h = false;
            }
        } else if (TextUtils.equals(str2, LaunchManager.PAGE_ON_STOP) && z10) {
            boolean z16 = LaunchManager.isDebug;
            f5371k--;
        }
    }

    public static void b(String str, long j10) {
        Map<String, Long[]> map = f5373m;
        if (map != null && map.containsKey(str)) {
            Long[] lArr = f5373m.get(str);
            lArr[1] = Long.valueOf(j10);
            f5373m.put(str, lArr);
        } else if (LaunchManager.isDebug) {
            Log.e("LaunchTrace", "--->>> method name non-existent or over quantity !");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x032b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r23, int r24, java.lang.String r25, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, java.util.Map<java.lang.String, java.lang.Long[]> r46) {
        /*
            r0 = r24
            r1 = r25
            r2 = r30
            r4 = r34
            boolean r6 = com.efs.sdk.launch.LaunchManager.isInit()
            java.lang.String r7 = "cache launch report --->>> "
            java.lang.String r9 = "startperf"
            java.lang.String r11 = "userExtra"
            java.lang.String r12 = "wl_page"
            java.lang.String r13 = "wd_pagetm"
            java.lang.String r14 = "wd_page"
            java.lang.String r15 = "wl_build"
            java.lang.String r10 = "wd_buildtm"
            java.lang.String r8 = "wd_build"
            java.lang.String r4 = "wl_init"
            java.lang.String r5 = "wd_inittm"
            java.lang.String r2 = "wd_init"
            java.lang.String r3 = "0.0.7.umeng"
            r17 = r7
            java.lang.String r7 = "l_version"
            r18 = r11
            java.lang.String r11 = "w_url"
            r19 = r12
            java.lang.String r12 = "w_type"
            r20 = r13
            java.lang.String r13 = "wl_avgv"
            if (r6 == 0) goto L_0x016b
            com.efs.sdk.launch.LaunchConfigManager r6 = com.efs.sdk.launch.LaunchManager.getLaunchConfigManager()
            if (r6 == 0) goto L_0x0044
            boolean r6 = r6.enableTracer()
            if (r6 != 0) goto L_0x004a
        L_0x0044:
            boolean r6 = com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()
            if (r6 == 0) goto L_0x0168
        L_0x004a:
            com.efs.sdk.base.protocol.record.EfsJSONLog r6 = new com.efs.sdk.base.protocol.record.EfsJSONLog
            r6.<init>(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r24)
            r6.put(r12, r9)
            r6.put(r11, r1)
            r6.put(r7, r3)
            if (r0 == 0) goto L_0x0076
            r1 = 1
            if (r0 != r1) goto L_0x0062
            goto L_0x0076
        L_0x0062:
            r1 = 2
            if (r0 != r1) goto L_0x006e
            java.lang.Long r0 = java.lang.Long.valueOf(r42)
        L_0x0069:
            r6.put(r13, r0)
            goto L_0x010d
        L_0x006e:
            r1 = 3
            if (r0 != r1) goto L_0x010d
            java.lang.Long r0 = java.lang.Long.valueOf(r44)
            goto L_0x0069
        L_0x0076:
            java.lang.Long r0 = java.lang.Long.valueOf(r26)
            r6.put(r13, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r28)
            r6.put(r2, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r30)
            r6.put(r5, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r32)
            r6.put(r4, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r30)
            r6.put(r8, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r34)
            r6.put(r10, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r36)
            r6.put(r15, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r34)
            r6.put(r14, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r38)
            r1 = r20
            r6.put(r1, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r40)
            r1 = r19
            r6.put(r1, r0)
            if (r46 == 0) goto L_0x010d
            boolean r0 = r46.isEmpty()
            if (r0 != 0) goto L_0x010d
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.Set r1 = r46.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00d5:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0108
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.Long[] r2 = (java.lang.Long[]) r2
            if (r3 == 0) goto L_0x00d5
            if (r2 == 0) goto L_0x00d5
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0106 }
            r4.<init>()     // Catch:{ all -> 0x0106 }
            r5 = 0
            r7 = r2[r5]     // Catch:{ all -> 0x0106 }
            r4.put(r7)     // Catch:{ all -> 0x0106 }
            r5 = 1
            r2 = r2[r5]     // Catch:{ all -> 0x0106 }
            r4.put(r2)     // Catch:{ all -> 0x0106 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0106 }
            goto L_0x00d5
        L_0x0106:
            goto L_0x00d5
        L_0x0108:
            r2 = r18
            r6.put(r2, r0)
        L_0x010d:
            java.lang.String r0 = com.efs.sdk.launch.c.a(r23)
            boolean r1 = com.efs.sdk.launch.LaunchManager.isDebug
            if (r1 == 0) goto L_0x011e
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "umid is "
            r2.concat(r1)
        L_0x011e:
            if (r0 == 0) goto L_0x0142
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0142
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
            if (r0 == 0) goto L_0x0138
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "send current launch report --->>> "
            r0.<init>(r1)
            java.lang.String r1 = r6.generateString()
            r0.append(r1)
        L_0x0138:
            com.efs.sdk.base.EfsReporter r0 = com.efs.sdk.launch.LaunchManager.getReporter()
            if (r0 == 0) goto L_0x0141
            r0.send(r6)
        L_0x0141:
            return
        L_0x0142:
            java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> r0 = f5372l
            if (r0 == 0) goto L_0x0165
            int r0 = r0.size()
            r1 = 3
            if (r0 >= r1) goto L_0x0165
            java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> r0 = f5372l
            r0.add(r6)
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
            if (r0 == 0) goto L_0x0167
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r17
            r0.<init>(r1)
            java.lang.String r1 = r6.generateString()
        L_0x0161:
            r0.append(r1)
            return
        L_0x0165:
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
        L_0x0167:
            return
        L_0x0168:
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
            return
        L_0x016b:
            r6 = r20
            r22 = r18
            r18 = r9
            r9 = r19
            r19 = r22
            if (r0 != 0) goto L_0x0225
            boolean r16 = com.efs.sdk.launch.LaunchManager.isDebug
            r20 = r9
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            r9.put(r12, r0)     // Catch:{ all -> 0x0220 }
            r9.put(r11, r1)     // Catch:{ all -> 0x0220 }
            r9.put(r7, r3)     // Catch:{ all -> 0x0220 }
            r0 = r26
            r9.put(r13, r0)     // Catch:{ all -> 0x0220 }
            r0 = r28
            r9.put(r2, r0)     // Catch:{ all -> 0x0220 }
            r0 = r30
            r9.put(r5, r0)     // Catch:{ all -> 0x0220 }
            r2 = r32
            r9.put(r4, r2)     // Catch:{ all -> 0x0220 }
            r9.put(r8, r0)     // Catch:{ all -> 0x0220 }
            r0 = r34
            r9.put(r10, r0)     // Catch:{ all -> 0x0220 }
            r2 = r36
            r9.put(r15, r2)     // Catch:{ all -> 0x0220 }
            r9.put(r14, r0)     // Catch:{ all -> 0x0220 }
            r0 = r38
            r9.put(r6, r0)     // Catch:{ all -> 0x0220 }
            r0 = r40
            r2 = r20
            r9.put(r2, r0)     // Catch:{ all -> 0x0220 }
            if (r46 == 0) goto L_0x0204
            boolean r0 = r46.isEmpty()     // Catch:{ all -> 0x0220 }
            if (r0 != 0) goto L_0x0204
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0220 }
            r0.<init>()     // Catch:{ all -> 0x0220 }
            java.util.Set r1 = r46.entrySet()     // Catch:{ all -> 0x0220 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0220 }
        L_0x01ce:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0220 }
            if (r2 == 0) goto L_0x01ff
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0220 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0220 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0220 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0220 }
            java.lang.Long[] r2 = (java.lang.Long[]) r2     // Catch:{ all -> 0x0220 }
            if (r3 == 0) goto L_0x01ce
            if (r2 == 0) goto L_0x01ce
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x01ce }
            r4.<init>()     // Catch:{ all -> 0x01ce }
            r5 = 0
            r6 = r2[r5]     // Catch:{ all -> 0x01ce }
            r4.put(r6)     // Catch:{ all -> 0x01ce }
            r5 = 1
            r2 = r2[r5]     // Catch:{ all -> 0x01ce }
            r4.put(r2)     // Catch:{ all -> 0x01ce }
            r0.put(r3, r4)     // Catch:{ all -> 0x01ce }
            goto L_0x01ce
        L_0x01ff:
            r4 = r19
            r9.put(r4, r0)     // Catch:{ all -> 0x0220 }
        L_0x0204:
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0220 }
            r1 = r23
            com.efs.sdk.launch.c.a(r1, r0)     // Catch:{ all -> 0x0220 }
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug     // Catch:{ all -> 0x0220 }
            if (r0 == 0) goto L_0x021f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = "no init, cache first launch, content is "
            r0.<init>(r1)     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r9.toString()     // Catch:{ all -> 0x0220 }
            r0.append(r1)     // Catch:{ all -> 0x0220 }
        L_0x021f:
            return
        L_0x0220:
            r0 = move-exception
            r0.printStackTrace()
            return
        L_0x0225:
            r22 = r4
            r4 = r2
            r2 = r9
            r9 = r22
            boolean r20 = com.efs.sdk.launch.LaunchManager.isDebug
            if (r20 == 0) goto L_0x023d
            r20 = r2
            java.lang.String r2 = "no init, cache launch, type is "
            r21 = r6
            java.lang.String r6 = java.lang.String.valueOf(r24)
            r2.concat(r6)
            goto L_0x0241
        L_0x023d:
            r20 = r2
            r21 = r6
        L_0x0241:
            com.efs.sdk.base.protocol.record.EfsJSONLog r2 = new com.efs.sdk.base.protocol.record.EfsJSONLog
            r6 = r18
            r2.<init>(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r24)
            r2.put(r12, r6)
            r2.put(r11, r1)
            r2.put(r7, r3)
            r1 = 1
            if (r0 != r1) goto L_0x02f6
            java.lang.Long r0 = java.lang.Long.valueOf(r26)
            r2.put(r13, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r28)
            r2.put(r4, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r30)
            r2.put(r5, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r32)
            r2.put(r9, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r30)
            r2.put(r8, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r34)
            r2.put(r10, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r36)
            r2.put(r15, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r34)
            r2.put(r14, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r38)
            r1 = r21
            r2.put(r1, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r40)
            r1 = r20
            r2.put(r1, r0)
            if (r46 == 0) goto L_0x02f4
            boolean r0 = r46.isEmpty()
            if (r0 != 0) goto L_0x02f4
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.util.Set r1 = r46.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x02b7:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x02ef
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.Long[] r3 = (java.lang.Long[]) r3
            if (r4 == 0) goto L_0x02ec
            if (r3 == 0) goto L_0x02ec
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x02e8 }
            r5.<init>()     // Catch:{ all -> 0x02e8 }
            r6 = 0
            r7 = r3[r6]     // Catch:{ all -> 0x02e9 }
            r5.put(r7)     // Catch:{ all -> 0x02e9 }
            r7 = 1
            r3 = r3[r7]     // Catch:{ all -> 0x02ea }
            r5.put(r3)     // Catch:{ all -> 0x02ea }
            r0.put(r4, r5)     // Catch:{ all -> 0x02ea }
            goto L_0x02b7
        L_0x02e8:
            r6 = 0
        L_0x02e9:
            r7 = 1
        L_0x02ea:
            goto L_0x02b7
        L_0x02ec:
            r6 = 0
            r7 = 1
            goto L_0x02b7
        L_0x02ef:
            r3 = r19
            r2.put(r3, r0)
        L_0x02f4:
            r1 = 3
            goto L_0x030b
        L_0x02f6:
            r1 = 2
            if (r0 != r1) goto L_0x0301
            java.lang.Long r0 = java.lang.Long.valueOf(r42)
            r2.put(r13, r0)
            goto L_0x02f4
        L_0x0301:
            r1 = 3
            if (r0 != r1) goto L_0x030b
            java.lang.Long r0 = java.lang.Long.valueOf(r44)
            r2.put(r13, r0)
        L_0x030b:
            java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> r0 = f5372l
            if (r0 == 0) goto L_0x032b
            int r0 = r0.size()
            if (r0 >= r1) goto L_0x032b
            java.util.List<com.efs.sdk.base.protocol.record.EfsJSONLog> r0 = f5372l
            r0.add(r2)
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
            if (r0 == 0) goto L_0x032d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r17
            r0.<init>(r1)
            java.lang.String r1 = r2.generateString()
            goto L_0x0161
        L_0x032b:
            boolean r0 = com.efs.sdk.launch.LaunchManager.isDebug
        L_0x032d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.launch.b.a(android.content.Context, int, java.lang.String, long, long, long, long, long, long, long, long, long, long, java.util.Map):void");
    }

    public static void a(Context context, String str) {
        boolean z10 = LaunchManager.isDebug;
        if (str == null || TextUtils.isEmpty(str)) {
            str = c.a(context);
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(UMCrash.KEY_HEADER_UMID, str);
            if (LaunchManager.getReporter() != null) {
                LaunchManager.getReporter().addPublicParams(hashMap);
            }
            String b10 = c.b(context);
            if (b10 != null && !TextUtils.isEmpty(b10)) {
                try {
                    JSONObject jSONObject = new JSONObject(b10);
                    jSONObject.put(UMCrash.KEY_HEADER_UMID, str);
                    if (a(jSONObject)) {
                        c.c(context);
                    }
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
            List<EfsJSONLog> list = f5372l;
            if (list != null && list.size() > 0) {
                for (EfsJSONLog next : f5372l) {
                    if (next != null) {
                        if (LaunchManager.isDebug) {
                            new StringBuilder("send cache launch report --->>> ").append(next.generateString());
                        }
                        EfsReporter reporter = LaunchManager.getReporter();
                        if (reporter != null) {
                            reporter.send(next);
                        }
                    }
                }
                f5372l.clear();
                f5372l = null;
            }
        }
    }

    public static void a(String str, long j10) {
        Map<String, Long[]> map = f5373m;
        if (map != null && !map.containsKey(str) && f5373m.size() < 10) {
            Long[] lArr = new Long[2];
            lArr[0] = Long.valueOf(j10);
            f5373m.put(str, lArr);
        } else if (LaunchManager.isDebug) {
            Log.e("LaunchTrace", "--->>> method name already exists or over quantity !");
        }
    }

    public static void a(String str, boolean z10) {
        if (TextUtils.equals(str, LaunchManager.APP_CONSTRUCT)) {
            return;
        }
        if (TextUtils.equals(str, LaunchManager.APP_ATTACH_BASE_CONTEXT)) {
            if (z10) {
                f5361a = System.currentTimeMillis();
                f5366f = true;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            f5362b = currentTimeMillis;
            f5369i = currentTimeMillis - f5361a;
            if (LaunchManager.isDebug) {
                new StringBuilder("initTime is ").append(f5369i);
            }
        } else if (TextUtils.equals(str, LaunchManager.APP_ON_CREATE) && !z10) {
            long currentTimeMillis2 = System.currentTimeMillis();
            f5363c = currentTimeMillis2;
            f5370j = currentTimeMillis2 - f5362b;
            if (LaunchManager.isDebug) {
                new StringBuilder("buildTime is ").append(f5370j);
            }
        }
    }

    private static boolean a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_STARTPERF);
            efsJSONLog.put("w_type", jSONObject2.opt("w_type"));
            efsJSONLog.put("w_url", jSONObject2.opt("w_url"));
            efsJSONLog.put("l_version", jSONObject2.opt("l_version"));
            efsJSONLog.put("wl_avgv", jSONObject2.opt("wl_avgv"));
            efsJSONLog.put("wd_init", jSONObject2.opt("wd_init"));
            efsJSONLog.put("wd_inittm", jSONObject2.opt("wd_inittm"));
            efsJSONLog.put("wl_init", jSONObject2.opt("wl_init"));
            efsJSONLog.put("wd_build", jSONObject2.opt("wd_build"));
            efsJSONLog.put("wd_buildtm", jSONObject2.opt("wd_buildtm"));
            efsJSONLog.put("wl_build", jSONObject2.opt("wl_build"));
            efsJSONLog.put("wd_page", jSONObject2.opt("wd_page"));
            efsJSONLog.put("wd_pagetm", jSONObject2.opt("wd_pagetm"));
            efsJSONLog.put("wl_page", jSONObject2.opt("wl_page"));
            String str = "userExtra";
            efsJSONLog.put(str, jSONObject2.opt(str));
            if (LaunchManager.isDebug) {
                new StringBuilder("send cache cold launch report --->>> ").append(efsJSONLog.generateString());
            }
            EfsReporter reporter = LaunchManager.getReporter();
            if (reporter == null) {
                return false;
            }
            reporter.send(efsJSONLog);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
