package com.uyumao;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.uyumao.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements g.a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f16253a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f16254b = true;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f16255c = true;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f16256d = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f16257e = true;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f16258f = true;

    /* renamed from: g  reason: collision with root package name */
    public static Context f16259g = null;

    /* renamed from: h  reason: collision with root package name */
    public static JSONObject f16260h = null;

    /* renamed from: i  reason: collision with root package name */
    public static JSONObject f16261i = null;

    /* renamed from: j  reason: collision with root package name */
    public static JSONObject f16262j = null;

    /* renamed from: k  reason: collision with root package name */
    public static JSONObject f16263k = null;

    /* renamed from: l  reason: collision with root package name */
    public static volatile boolean f16264l = false;

    /* renamed from: m  reason: collision with root package name */
    public static Map<String, Integer> f16265m;

    /* renamed from: n  reason: collision with root package name */
    public static LocationListener f16266n = new a();

    public static class a implements LocationListener {
        public void onLocationChanged(Location location) {
            double d10;
            boolean unused = d.f16264l = true;
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                long time = location.getTime();
                double d11 = 0.0d;
                if (location.hasAltitude()) {
                    d10 = location.getAltitude();
                } else {
                    d10 = 0.0d;
                }
                if (location.hasSpeed()) {
                    d11 = (double) location.getSpeed();
                }
                JSONObject jSONObject = new JSONObject();
                d.f16262j = jSONObject;
                jSONObject.put("lat", latitude);
                d.f16262j.put("lng", longitude);
                d.f16262j.put("alt", d10);
                d.f16262j.put("acc", d11);
                d.f16262j.put("lts", time);
                g.a(d.f16259g, 203, e.f16270a, d.f16263k);
            } catch (Throwable unused2) {
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16267a;

        public b(d dVar, String str) {
            this.f16267a = str;
        }

        public void run() {
            k.a(d.f16259g, "https://yumao.puata.info/cc_info", this.f16267a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16268a;

        public c(d dVar, String str) {
            this.f16268a = str;
        }

        public void run() {
            k.a(d.f16259g, "https://yumao.puata.info/cc_info", this.f16268a);
        }
    }

    /* renamed from: com.uyumao.d$d  reason: collision with other inner class name */
    public class C0213d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16269a;

        public C0213d(d dVar, String str) {
            this.f16269a = str;
        }

        public void run() {
            k.a(d.f16259g, "https://yumao.puata.info/cc_info", this.f16269a);
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final d f16270a = new d();
    }

    static {
        HashMap hashMap = new HashMap();
        f16265m = hashMap;
        hashMap.put(com.umeng.ccg.a.f14509b, 101);
        f16265m.put(com.umeng.ccg.a.f14510c, 102);
        f16265m.put(com.umeng.ccg.a.f14511d, 103);
        f16265m.put(com.umeng.ccg.a.f14512e, 104);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                String optString = jSONObject2.optString(com.umeng.ccg.a.f14525r);
                String optString2 = jSONObject2.optString(com.umeng.ccg.a.f14528u);
                jSONObject.put(com.umeng.ccg.a.f14525r, optString);
                String[] split = optString2.split(",");
                JSONArray jSONArray = new JSONArray();
                for (String put : split) {
                    jSONArray.put(put);
                }
                jSONObject.put(com.umeng.ccg.a.f14528u, jSONArray);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fc A[Catch:{ all -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012f A[Catch:{ all -> 0x0136 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r8) {
        /*
            java.lang.String r0 = "2G/3G"
            org.json.JSONObject r1 = f16260h
            if (r1 == 0) goto L_0x000f
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x000f
            org.json.JSONObject r8 = f16260h
            return r8
        L_0x000f:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0136 }
            r1.<init>()     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "os"
            java.lang.String r3 = "Android"
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "dm"
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x0136 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "av"
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "umid"
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getUMId(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "ov"
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0136 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "chn"
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getChannel(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0136 }
            java.lang.String[] r2 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r8)     // Catch:{ all -> 0x0136 }
            java.lang.String r3 = ""
            java.lang.String r4 = "puid"
            r5 = 1
            if (r2 == 0) goto L_0x0061
            java.lang.String[] r2 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r8)     // Catch:{ all -> 0x0136 }
            int r2 = r2.length     // Catch:{ all -> 0x0136 }
            r6 = 2
            if (r2 != r6) goto L_0x0061
            java.lang.String[] r2 = com.umeng.commonsdk.utils.UMUtils.getActiveUser(r8)     // Catch:{ all -> 0x0136 }
            r2 = r2[r5]     // Catch:{ all -> 0x0136 }
            r1.put(r4, r2)     // Catch:{ all -> 0x0136 }
            goto L_0x0064
        L_0x0061:
            r1.put(r4, r3)     // Catch:{ all -> 0x0136 }
        L_0x0064:
            java.lang.String r2 = "zid"
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getZid(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "sv"
            java.lang.String r4 = com.uyumao.sdk.UYMManager.getSdkVersion()     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "ak"
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "idfa"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "db"
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "aid"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "oaid"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "imei"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "boa"
            java.lang.String r4 = android.os.Build.BOARD     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "mant"
            long r6 = android.os.Build.TIME     // Catch:{ all -> 0x0136 }
            r1.put(r2, r6)     // Catch:{ all -> 0x0136 }
            java.lang.String[] r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r8)     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "ct"
            r6 = 0
            r7 = r2[r6]     // Catch:{ all -> 0x0136 }
            r1.put(r4, r7)     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "lang"
            r2 = r2[r5]     // Catch:{ all -> 0x0136 }
            r1.put(r4, r2)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "tz"
            int r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "pkg"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "disn"
            java.lang.String r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r8)     // Catch:{ all -> 0x0136 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0136 }
            java.lang.String[] r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r8)     // Catch:{ all -> 0x0136 }
            java.lang.String r4 = "Wi-Fi"
            r7 = r2[r6]     // Catch:{ all -> 0x0136 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x0136 }
            java.lang.String r7 = "ac"
            if (r4 == 0) goto L_0x00fc
            java.lang.String r0 = "wifi"
            r1.put(r7, r0)     // Catch:{ all -> 0x0136 }
            goto L_0x010d
        L_0x00fc:
            r4 = r2[r6]     // Catch:{ all -> 0x0136 }
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0136 }
            if (r4 == 0) goto L_0x0108
            r1.put(r7, r0)     // Catch:{ all -> 0x0136 }
            goto L_0x010d
        L_0x0108:
            java.lang.String r0 = "unknown"
            r1.put(r7, r0)     // Catch:{ all -> 0x0136 }
        L_0x010d:
            r0 = r2[r5]     // Catch:{ all -> 0x0136 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0136 }
            if (r0 != 0) goto L_0x011c
            java.lang.String r0 = "ast"
            r2 = r2[r5]     // Catch:{ all -> 0x0136 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0136 }
        L_0x011c:
            int r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkType(r8)     // Catch:{ all -> 0x0136 }
            java.lang.String r2 = "nt"
            r1.put(r2, r0)     // Catch:{ all -> 0x0136 }
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(r8)     // Catch:{ all -> 0x0136 }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0136 }
            if (r0 != 0) goto L_0x0134
            java.lang.String r0 = "device_token"
            r1.put(r0, r8)     // Catch:{ all -> 0x0136 }
        L_0x0134:
            f16260h = r1     // Catch:{ all -> 0x0136 }
        L_0x0136:
            org.json.JSONObject r8 = f16260h
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.d.a(android.content.Context):org.json.JSONObject");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:97|98|99|100|(2:102|103)|(1:105)|106|108|109|167) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:118|119|120|121|122|123|124|125|127|128|168) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:34|(3:37|38|(2:42|(1:44)(3:45|(1:47)(1:48)|50)))|51|52|156) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:69|70|71|72|(2:73|74)|75|77|78|166) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ad, code lost:
        if (r5.contains(r3) != false) goto L_0x00af;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x016f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x010d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:127:0x01b0=Splitter:B:127:0x01b0, B:51:0x00b2=Splitter:B:51:0x00b2, B:77:0x010d=Splitter:B:77:0x010d, B:108:0x016f=Splitter:B:108:0x016f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "network"
            java.lang.String r4 = "gps"
            r5 = 202(0xca, float:2.83E-43)
            java.lang.String r6 = "location"
            java.lang.String r7 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String r8 = "android.permission.ACCESS_FINE_LOCATION"
            r9 = 203(0xcb, float:2.84E-43)
            r10 = 0
            if (r2 == r5) goto L_0x01bf
            r11 = 0
            if (r2 == r9) goto L_0x017f
            switch(r2) {
                case 101: goto L_0x011e;
                case 102: goto L_0x00ce;
                case 103: goto L_0x0059;
                case 104: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x01f0
        L_0x0020:
            boolean r2 = f16258f
            if (r2 != 0) goto L_0x0025
            return
        L_0x0025:
            if (r1 == 0) goto L_0x01f0
            boolean r2 = r1 instanceof org.json.JSONObject
            if (r2 == 0) goto L_0x01f0
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x01f0 }
            java.lang.ref.WeakReference<java.util.concurrent.Future<?>> r2 = com.uyumao.e.f16273c     // Catch:{ all -> 0x01f0 }
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x01f0 }
            java.util.concurrent.Future r2 = (java.util.concurrent.Future) r2     // Catch:{ all -> 0x01f0 }
            if (r2 == 0) goto L_0x0047
            boolean r3 = r2.isDone()     // Catch:{ all -> 0x01f0 }
            if (r3 != 0) goto L_0x0047
            boolean r2 = r2.isCancelled()     // Catch:{ all -> 0x01f0 }
            if (r2 != 0) goto L_0x0047
            goto L_0x01f0
        L_0x0047:
            com.uyumao.r r2 = new com.uyumao.r     // Catch:{ all -> 0x01f0 }
            r2.<init>(r1)     // Catch:{ all -> 0x01f0 }
            java.util.concurrent.Future r1 = com.uyumao.s.a(r2)     // Catch:{ all -> 0x01f0 }
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x01f0 }
            r2.<init>(r1)     // Catch:{ all -> 0x01f0 }
            com.uyumao.e.f16273c = r2     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x0059:
            java.lang.Boolean r2 = com.uyumao.e.b()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0064
            return
        L_0x0064:
            if (r1 == 0) goto L_0x01f0
            boolean r2 = r1 instanceof org.json.JSONObject
            if (r2 == 0) goto L_0x01f0
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x01f0 }
            f16263k = r1     // Catch:{ all -> 0x01f0 }
            boolean r1 = f16254b     // Catch:{ all -> 0x01f0 }
            if (r1 == 0) goto L_0x007a
            android.content.Context r1 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r1 = com.uyumao.e.b((android.content.Context) r1)     // Catch:{ all -> 0x01f0 }
            f16261i = r1     // Catch:{ all -> 0x01f0 }
        L_0x007a:
            boolean r1 = f16253a     // Catch:{ all -> 0x01f0 }
            if (r1 == 0) goto L_0x00c3
            android.content.Context r1 = f16259g     // Catch:{ all -> 0x01f0 }
            android.location.LocationListener r2 = f16266n     // Catch:{ all -> 0x01f0 }
            if (r1 == 0) goto L_0x00b2
            if (r2 != 0) goto L_0x0087
            goto L_0x00b2
        L_0x0087:
            boolean r5 = com.uyumao.e.a((android.content.Context) r1, (java.lang.String) r8)     // Catch:{ all -> 0x00b2 }
            if (r5 == 0) goto L_0x00b2
            boolean r5 = com.uyumao.e.a((android.content.Context) r1, (java.lang.String) r7)     // Catch:{ all -> 0x00b2 }
            if (r5 == 0) goto L_0x00b2
            java.lang.Object r1 = r1.getSystemService(r6)     // Catch:{ all -> 0x00b2 }
            android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ all -> 0x00b2 }
            if (r1 != 0) goto L_0x009c
            goto L_0x00b2
        L_0x009c:
            r5 = 1
            java.util.List r5 = r1.getProviders(r5)     // Catch:{ all -> 0x00b2 }
            boolean r6 = r5.contains(r4)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x00a9
            r3 = r4
            goto L_0x00af
        L_0x00a9:
            boolean r4 = r5.contains(r3)     // Catch:{ all -> 0x00b2 }
            if (r4 == 0) goto L_0x00b2
        L_0x00af:
            r1.requestSingleUpdate(r3, r2, r10)     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            android.content.Context r11 = f16259g     // Catch:{ all -> 0x01f0 }
            r13 = 202(0xca, float:2.83E-43)
            com.uyumao.d r14 = com.uyumao.d.e.f16270a     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r15 = f16263k     // Catch:{ all -> 0x01f0 }
            r16 = 30000(0x7530, double:1.4822E-319)
            r12 = 256(0x100, float:3.59E-43)
            com.uyumao.g.a(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x00c3:
            android.content.Context r1 = f16259g     // Catch:{ all -> 0x01f0 }
            com.uyumao.d r2 = com.uyumao.d.e.f16270a     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r3 = f16263k     // Catch:{ all -> 0x01f0 }
            com.uyumao.g.a(r1, r9, r2, r3)     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x00ce:
            java.lang.Boolean r2 = com.uyumao.e.b()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00d9
            return
        L_0x00d9:
            boolean r2 = f16257e
            if (r2 != 0) goto L_0x00de
            return
        L_0x00de:
            if (r1 == 0) goto L_0x01f0
            boolean r2 = r1 instanceof org.json.JSONObject
            if (r2 == 0) goto L_0x01f0
            android.content.Context r2 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONArray r2 = com.uyumao.e.a((android.content.Context) r2)     // Catch:{ all -> 0x01f0 }
            if (r2 == 0) goto L_0x011d
            int r3 = r2.length()     // Catch:{ all -> 0x01f0 }
            if (r3 > 0) goto L_0x00f3
            goto L_0x011d
        L_0x00f3:
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x01f0 }
            android.content.Context r3 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r3 = a((android.content.Context) r3)     // Catch:{ all -> 0x01f0 }
            a((org.json.JSONObject) r3, (org.json.JSONObject) r1)     // Catch:{ all -> 0x01f0 }
            java.lang.String r1 = "bs"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x010d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010d }
            r4.<init>(r3)     // Catch:{ all -> 0x010d }
            r4.put(r1, r2)     // Catch:{ all -> 0x010c }
        L_0x010c:
            r10 = r4
        L_0x010d:
            java.lang.String r1 = r10.toString()     // Catch:{ all -> 0x01f0 }
            com.uyumao.d$c r2 = new com.uyumao.d$c     // Catch:{ all -> 0x01f0 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x01f0 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01f0 }
            com.uyumao.s.a(r2, r11, r1)     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x011d:
            return
        L_0x011e:
            java.lang.Boolean r2 = com.uyumao.e.b()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0129
            return
        L_0x0129:
            if (r1 == 0) goto L_0x01f0
            boolean r2 = r1 instanceof org.json.JSONObject
            if (r2 == 0) goto L_0x01f0
            boolean r2 = f16255c     // Catch:{ all -> 0x01f0 }
            if (r2 == 0) goto L_0x013a
            android.content.Context r2 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONArray r2 = com.uyumao.e.e(r2)     // Catch:{ all -> 0x01f0 }
            goto L_0x013b
        L_0x013a:
            r2 = r10
        L_0x013b:
            boolean r3 = f16256d     // Catch:{ all -> 0x01f0 }
            if (r3 == 0) goto L_0x0146
            android.content.Context r3 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONArray r3 = com.uyumao.e.f(r3)     // Catch:{ all -> 0x01f0 }
            goto L_0x0147
        L_0x0146:
            r3 = r10
        L_0x0147:
            if (r2 != 0) goto L_0x014c
            if (r3 != 0) goto L_0x014c
            return
        L_0x014c:
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x01f0 }
            android.content.Context r4 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r4 = a((android.content.Context) r4)     // Catch:{ all -> 0x01f0 }
            a((org.json.JSONObject) r4, (org.json.JSONObject) r1)     // Catch:{ all -> 0x01f0 }
            java.lang.String r1 = "wifi"
            java.lang.String r5 = "wifi_list"
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x016f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016f }
            r6.<init>(r4)     // Catch:{ all -> 0x016f }
            if (r2 == 0) goto L_0x0169
            r6.put(r1, r2)     // Catch:{ all -> 0x016e }
        L_0x0169:
            if (r3 == 0) goto L_0x016e
            r6.put(r5, r3)     // Catch:{ all -> 0x016e }
        L_0x016e:
            r10 = r6
        L_0x016f:
            java.lang.String r1 = r10.toString()     // Catch:{ all -> 0x01f0 }
            com.uyumao.d$b r2 = new com.uyumao.d$b     // Catch:{ all -> 0x01f0 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x01f0 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01f0 }
            com.uyumao.s.a(r2, r11, r1)     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x017f:
            org.json.JSONObject r2 = f16261i
            if (r2 != 0) goto L_0x0188
            org.json.JSONObject r2 = f16262j
            if (r2 != 0) goto L_0x0188
            return
        L_0x0188:
            if (r1 == 0) goto L_0x01f0
            boolean r1 = r1 instanceof org.json.JSONObject
            if (r1 == 0) goto L_0x01f0
            android.content.Context r1 = f16259g     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r1 = a((android.content.Context) r1)     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r2 = f16263k     // Catch:{ all -> 0x01f0 }
            a((org.json.JSONObject) r1, (org.json.JSONObject) r2)     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r2 = f16261i     // Catch:{ all -> 0x01f0 }
            org.json.JSONObject r3 = f16262j     // Catch:{ all -> 0x01f0 }
            org.json.JSONArray r2 = com.uyumao.e.a((org.json.JSONObject) r2, (org.json.JSONObject) r3)     // Catch:{ all -> 0x01f0 }
            java.lang.String r3 = "lbs"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x01b0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01b0 }
            r4.<init>(r1)     // Catch:{ all -> 0x01b0 }
            r4.put(r3, r2)     // Catch:{ all -> 0x01af }
        L_0x01af:
            r10 = r4
        L_0x01b0:
            java.lang.String r1 = r10.toString()     // Catch:{ all -> 0x01f0 }
            com.uyumao.d$d r2 = new com.uyumao.d$d     // Catch:{ all -> 0x01f0 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x01f0 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x01f0 }
            com.uyumao.s.a(r2, r11, r1)     // Catch:{ all -> 0x01f0 }
            goto L_0x01f0
        L_0x01bf:
            boolean r1 = f16264l
            if (r1 == 0) goto L_0x01c4
            return
        L_0x01c4:
            android.content.Context r1 = f16259g
            android.location.LocationListener r2 = f16266n
            if (r1 == 0) goto L_0x01e5
            if (r2 != 0) goto L_0x01cd
            goto L_0x01e5
        L_0x01cd:
            boolean r3 = com.uyumao.e.a((android.content.Context) r1, (java.lang.String) r8)     // Catch:{ all -> 0x01e5 }
            if (r3 == 0) goto L_0x01e5
            boolean r3 = com.uyumao.e.a((android.content.Context) r1, (java.lang.String) r7)     // Catch:{ all -> 0x01e5 }
            if (r3 == 0) goto L_0x01e5
            java.lang.Object r1 = r1.getSystemService(r6)     // Catch:{ all -> 0x01e5 }
            android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ all -> 0x01e5 }
            if (r1 != 0) goto L_0x01e2
            goto L_0x01e5
        L_0x01e2:
            r1.removeUpdates(r2)     // Catch:{ all -> 0x01e5 }
        L_0x01e5:
            f16262j = r10
            android.content.Context r1 = f16259g
            com.uyumao.d r2 = com.uyumao.d.e.f16270a
            org.json.JSONObject r3 = f16263k
            com.uyumao.g.a(r1, r9, r2, r3)
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.d.a(java.lang.Object, int):void");
    }
}
