package com.umeng.ccg;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.ccg.c;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14563a = "iucc";

    /* renamed from: b  reason: collision with root package name */
    private static final String f14564b = bd.b().b(bd.C);

    /* renamed from: c  reason: collision with root package name */
    private static JSONObject f14565c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f14566d = {a.f14513f, a.f14514g, a.f14515h};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f14567e = {a.f14513f, a.f14514g, a.f14515h, a.f14516i};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static ArrayList<ac> f14568f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static ArrayList<ac> f14569g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static ArrayList<ac> f14570h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static ArrayList<ac> f14571i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static ab f14572j = null;

    /* renamed from: m  reason: collision with root package name */
    private static e f14573m = new e();

    /* renamed from: k  reason: collision with root package name */
    private volatile String f14574k = "";

    /* renamed from: l  reason: collision with root package name */
    private Map<String, b> f14575l = new HashMap();

    public static class a extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || !action.equals("android.intent.action.SCREEN_ON") || d.f14572j == null || !(d.f14572j instanceof ae)) {
                    return;
                }
                if (b(d.f14571i)) {
                    c.a(UMGlobalContext.getAppContext(), 304, d.a(), (Object) null, 1000 * a(d.f14571i));
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
            } catch (Throwable unused) {
            }
        }
    }

    public class b {

        /* renamed from: b  reason: collision with root package name */
        private JSONArray f14581b;

        /* renamed from: c  reason: collision with root package name */
        private String f14582c;

        public b(JSONArray jSONArray, String str) {
            this.f14581b = jSONArray;
            this.f14582c = str;
        }

        public JSONArray a() {
            return this.f14581b;
        }

        public String b() {
            return this.f14582c;
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f14583a;

        /* renamed from: b  reason: collision with root package name */
        public int f14584b;

        /* renamed from: c  reason: collision with root package name */
        public int f14585c;

        public c(String str, int i10, int i11) {
            this.f14583a = str;
            this.f14584b = i10;
            this.f14585c = i11;
        }
    }

    /* renamed from: com.umeng.ccg.d$d  reason: collision with other inner class name */
    public static class C0199d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f14587a = new d();

        private C0199d() {
        }
    }

    public static class e extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action)) {
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                        if (b(d.f14568f)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                            c.a(UMGlobalContext.getAppContext(), 301, d.a(), (Object) null, a(d.f14568f) * 1000);
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                        }
                    }
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                        if (b(d.f14569g)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                            c.a(UMGlobalContext.getAppContext(), 302, d.a(), (Object) null, a(d.f14569g) * 1000);
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                        }
                    }
                    if (action.equals("android.intent.action.USER_PRESENT")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                        if (b(d.f14570h)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                            c.a(UMGlobalContext.getAppContext(), 303, d.a(), (Object) null, a(d.f14570h) * 1000);
                            return;
                        }
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private boolean g() {
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            String string = a10.getString(au.f13785f, "");
            if (TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!as.a().keySet().equals(as.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                a10.edit().putString(au.f13785f, new JSONObject(as.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean i() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 == null || TextUtils.isEmpty(a10.getString(au.f13786g, ""))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ax.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ax.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f14563a, new UMImprintChangeCallback() {
            public void onImprintValueChanged(String str, String str2) {
                c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences a10 = au.a(context);
            if (a10 != null) {
                return Long.valueOf(a10.getLong(au.f13783d, 0));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences a10 = au.a(context);
            if (a10 != null) {
                return a10.getString(au.f13784e, "");
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(a.f14508a)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(a.f14508a);
                ab abVar = null;
                ab a10 = optJSONObject.has(a.f14509b) ? a(a.f14509b, optJSONObject.optJSONObject(a.f14509b)) : null;
                ab a11 = optJSONObject.has(a.f14510c) ? a(a.f14510c, optJSONObject.optJSONObject(a.f14510c)) : null;
                ab a12 = optJSONObject.has(a.f14511d) ? a(a.f14511d, optJSONObject.optJSONObject(a.f14511d)) : null;
                ab a13 = optJSONObject.has(a.f14512e) ? a(a.f14512e, optJSONObject.optJSONObject(a.f14512e)) : null;
                ab a14 = optJSONObject.has(a.f14513f) ? a(a.f14513f, optJSONObject.optJSONObject(a.f14513f)) : null;
                ab a15 = optJSONObject.has(a.f14514g) ? a(a.f14514g, optJSONObject.optJSONObject(a.f14514g)) : null;
                ab a16 = optJSONObject.has(a.f14515h) ? a(a.f14515h, optJSONObject.optJSONObject(a.f14515h)) : null;
                if (optJSONObject.has(a.f14516i)) {
                    abVar = a(a.f14516i, optJSONObject.optJSONObject(a.f14516i));
                    f14572j = abVar;
                }
                ArrayList arrayList = new ArrayList();
                if (a10 != null) {
                    arrayList.add(a10);
                }
                if (a11 != null) {
                    arrayList.add(a11);
                }
                if (a12 != null) {
                    arrayList.add(a12);
                }
                if (a13 != null) {
                    arrayList.add(a13);
                }
                if (a14 != null) {
                    arrayList.add(a14);
                }
                if (a15 != null) {
                    arrayList.add(a15);
                }
                if (a16 != null) {
                    arrayList.add(a16);
                }
                if (abVar != null) {
                    arrayList.add(abVar);
                }
                c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    public static d a() {
        return C0199d.f14587a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.umeng.analytics.pro.as.a((java.io.Closeable) r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject b(android.content.Context r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003a }
            java.io.File r2 = r5.getFilesDir()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = f14564b     // Catch:{ all -> 0x003a }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x003a }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0015
            monitor-exit(r4)
            return r0
        L_0x0015:
            java.io.FileInputStream r5 = r5.openFileInput(r3)     // Catch:{ all -> 0x0036 }
            byte[] r1 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r5)     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = com.umeng.commonsdk.UMConfigure.sAppkey     // Catch:{ all -> 0x0037 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0037 }
            byte[] r1 = com.umeng.analytics.pro.ax.a((byte[]) r1, (byte[]) r2)     // Catch:{ all -> 0x0037 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0037 }
            r3.<init>(r1)     // Catch:{ all -> 0x0037 }
            r2.<init>(r3)     // Catch:{ all -> 0x0037 }
            com.umeng.analytics.pro.as.a((java.io.Closeable) r5)     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = r2
            goto L_0x003a
        L_0x0036:
            r5 = r0
        L_0x0037:
            com.umeng.analytics.pro.as.a((java.io.Closeable) r5)     // Catch:{ all -> 0x003a }
        L_0x003a:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.b(android.content.Context):org.json.JSONObject");
    }

    public void a(Context context) {
        c.a(context, 105, a(), (Object) null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(Constants.KEY_HTTP_CODE)) {
            return false;
        }
        try {
            return 200 == Integer.valueOf(jSONObject.optInt(Constants.KEY_HTTP_CODE)).intValue() && jSONObject.has(a.f14508a) && jSONObject.has("ts");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r6, org.json.JSONObject r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.b((org.json.JSONObject) r7)     // Catch:{ all -> 0x0049 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0049 }
            byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = com.umeng.commonsdk.UMConfigure.sAppkey     // Catch:{ all -> 0x0049 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0049 }
            byte[] r7 = com.umeng.analytics.pro.ax.a((byte[]) r7, (byte[]) r2)     // Catch:{ all -> 0x0049 }
            if (r7 == 0) goto L_0x0047
            int r2 = r7.length     // Catch:{ all -> 0x0049 }
            r3 = 1
            if (r2 > r3) goto L_0x001e
            goto L_0x0047
        L_0x001e:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0049 }
            java.io.File r3 = r6.getFilesDir()     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = f14564b     // Catch:{ all -> 0x0049 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0049 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0049 }
            r3.<init>(r2)     // Catch:{ all -> 0x0049 }
            r3.write(r7)     // Catch:{ all -> 0x0042 }
            r3.flush()     // Catch:{ all -> 0x0042 }
            com.umeng.analytics.pro.as.a((java.io.Closeable) r3)     // Catch:{ all -> 0x0049 }
            r5.a((android.content.Context) r6, (java.lang.String) r8, (long) r0)     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "MobclickRT"
            java.lang.String r7 = "saveConfigFile success."
            com.umeng.commonsdk.debug.UMRTLog.i(r6, r7)     // Catch:{ all -> 0x0049 }
            goto L_0x0049
        L_0x0042:
            r6 = move-exception
            com.umeng.analytics.pro.as.a((java.io.Closeable) r3)     // Catch:{ all -> 0x0049 }
            throw r6     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r5)
            return
        L_0x0049:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(android.content.Context, org.json.JSONObject, java.lang.String):void");
    }

    private void b(String str) {
        String str2 = au.f13781b + str;
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            a10.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, ac acVar) {
        if (a.f14513f.equalsIgnoreCase(str)) {
            if (f14568f == null) {
                f14568f = new ArrayList<>();
            }
            f14568f.add(acVar);
        }
        if (a.f14514g.equalsIgnoreCase(str)) {
            if (f14569g == null) {
                f14569g = new ArrayList<>();
            }
            f14569g.add(acVar);
        }
        if (a.f14515h.equalsIgnoreCase(str)) {
            if (f14570h == null) {
                f14570h = new ArrayList<>();
            }
            f14570h.add(acVar);
        }
        if (a.f14516i.equalsIgnoreCase(str)) {
            if (f14571i == null) {
                f14571i = new ArrayList<>();
            }
            f14571i.add(acVar);
        }
    }

    private ab a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        ab abVar;
        JSONArray optJSONArray2;
        String str3 = str;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            try {
                if (jSONObject2.has(a.f14519l) && (optJSONArray = jSONObject2.optJSONArray(a.f14519l)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject3 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject3.has(a.f14520m);
                    boolean has2 = jSONObject3.has(a.f14523p);
                    boolean has3 = jSONObject3.has(a.f14524q);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject3.optInt(a.f14520m);
                        long optLong = jSONObject3.optLong(a.f14523p);
                        long optLong2 = jSONObject3.optLong(a.f14524q);
                        String optString = jSONObject3.optString(a.f14525r);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject3.has(a.f14521n)) {
                            JSONArray optJSONArray3 = jSONObject3.optJSONArray(a.f14521n);
                            HashSet hashSet = new HashSet();
                            if (optJSONArray3 != null) {
                                str2 = a.f14528u;
                                int i10 = 0;
                                for (int length = optJSONArray3.length(); i10 < length; length = length) {
                                    hashSet.add(Integer.valueOf(optJSONArray3.getInt(i10)));
                                    i10++;
                                }
                            } else {
                                str2 = a.f14528u;
                            }
                            if (hashSet.size() > 0) {
                                am amVar = new am(hashSet);
                                if (Arrays.asList(f14566d).contains(str3)) {
                                    a(str3, (ac) amVar);
                                } else {
                                    arrayList.add(amVar);
                                    if (a.f14516i.equalsIgnoreCase(str3)) {
                                        a(str3, (ac) amVar);
                                    }
                                }
                            }
                        } else {
                            str2 = a.f14528u;
                        }
                        if (jSONObject3.has(a.f14522o)) {
                            String optString2 = jSONObject3.optString(a.f14522o);
                            if (!TextUtils.isEmpty(optString2)) {
                                ak akVar = new ak(optString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i11 = 1; i11 <= 24; i11++) {
                                    if (akVar.a(i11)) {
                                        hashSet2.add(Integer.valueOf(i11));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ag agVar = new ag(hashSet2);
                                    if (Arrays.asList(f14566d).contains(str3)) {
                                        a(str3, (ac) agVar);
                                    } else {
                                        arrayList.add(agVar);
                                    }
                                    if (a.f14516i.equalsIgnoreCase(str3)) {
                                        a(str3, (ac) agVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new ai(optInt));
                        ah ahVar = new ah(str3, optLong);
                        String[] strArr = f14566d;
                        if (Arrays.asList(strArr).contains(str3)) {
                            a(str3, (ac) ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (a.f14516i.equalsIgnoreCase(str3)) {
                            a(str3, (ac) ahVar);
                        }
                        af afVar = new af(optLong2);
                        if (Arrays.asList(strArr).contains(str3)) {
                            a(str3, (ac) afVar);
                            arrayList.add(afVar);
                        } else {
                            arrayList.add(afVar);
                        }
                        if (a.f14516i.equalsIgnoreCase(str3)) {
                            a(str3, (ac) afVar);
                        }
                        if (a.f14512e.equals(str3)) {
                            abVar = new ad(str3, arrayList);
                        } else if (a.f14516i.equals(str3)) {
                            abVar = new ae(str3, arrayList);
                        } else {
                            abVar = new ab(str3, arrayList);
                        }
                        try {
                            abVar.b(str3, jSONObject3);
                            abVar.a(optString);
                            String str4 = "";
                            JSONObject jSONObject4 = jSONObject;
                            String str5 = str2;
                            if (jSONObject4.has(str5) && (optJSONArray2 = jSONObject4.optJSONArray(str5)) != null) {
                                Map<String, b> map = this.f14575l;
                                if (map != null && !map.containsKey(str3)) {
                                    this.f14575l.put(str3, new b(new JSONArray(optJSONArray2.toString()), optString));
                                }
                                int length2 = optJSONArray2.length();
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    str4 = str4 + optJSONArray2.getString(i12);
                                    if (i12 < length2 - 1) {
                                        str4 = str4 + ",";
                                    }
                                }
                            }
                            abVar.b(str4);
                        } catch (Throwable unused) {
                        }
                        return abVar;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j10) {
        SharedPreferences a10;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("@");
                if (split.length == 4 && (a10 = au.a(context)) != null) {
                    long parseLong = Long.parseLong(split[0]);
                    String str2 = split[1];
                    SharedPreferences.Editor edit = a10.edit();
                    edit.putLong(au.f13782c, j10);
                    edit.putLong(au.f13783d, parseLong);
                    edit.putString(au.f13784e, str2).commit();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j10 + "; s1 = " + parseLong + "; s2 = " + str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length == 4) {
                long parseLong = Long.parseLong(split[0]);
                String str2 = split[1];
                if (!TextUtils.isEmpty(this.f14574k)) {
                    String[] split2 = this.f14574k.split("@");
                    if (split2.length == 2) {
                        long parseLong2 = Long.parseLong(split2[0]);
                        String str3 = split2[1];
                        if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                            return;
                        }
                    }
                }
                SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
                if (a10 == null) {
                    return;
                }
                if (a10.getLong(au.f13782c, 0) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f14574k = String.valueOf(parseLong) + "@" + str2;
                    c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (!e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                    this.f14574k = String.valueOf(parseLong) + "@" + str2;
                    c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z10) {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                SharedPreferences.Editor edit = a10.edit();
                if (z10) {
                    edit.putString(au.f13786g, "1").commit();
                } else {
                    edit.putString(au.f13786g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(String str, int i10, int i11) {
        b bVar;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(a.B, i10);
            jSONObject.put("result", i11);
            if (!this.f14575l.containsKey(a.f14516i) || (bVar = this.f14575l.get(a.f14516i)) == null) {
                return null;
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), bVar.a(), bVar.b());
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(String str, String str2, String str3, long j10, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j10);
            jSONObject.put("tt", str);
            jSONObject.put(AgooConstants.MESSAGE_FLAG, str2);
            jSONObject.put("ss", str3);
            if (z10) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(Context context, String str, JSONObject jSONObject) {
        JSONObject a10;
        Object a11;
        JSONObject jSONObject2 = jSONObject;
        Class<String> cls = String.class;
        try {
            b(a.f14516i);
            final String str2 = "";
            if (jSONObject2.has("target")) {
                str2 = jSONObject2.optString("target");
            }
            if (TextUtils.isEmpty(str2)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> target is empty, ignore umc_cfg process");
                return;
            }
            final int optInt = jSONObject2.has(a.B) ? jSONObject2.optInt(a.B) : 0;
            if (optInt == 0) {
                JSONObject j10 = j();
                if (j10 != null && (a11 = aw.a(j10.optString(bt.aL), j10.optString("s"), new Class[]{cls}, context, new Object[]{j10.optString("a")})) != null && Build.VERSION.SDK_INT >= 23) {
                    Bundle bundle = new Bundle();
                    bundle.putString("ss", Base64.encodeToString(ax.a(DeviceConfig.getPackageName(context).getBytes(), UMUtils.genSin()), 0).trim());
                    aw.a(j10.optString("m"), j10.optString("x"), new Class[]{cls, cls, String[].class, Bundle.class, Activity.class, aw.a(j10.optString(bt.aJ)), Handler.class}, a11, new Object[]{str2, a.f14518k, null, bundle, null, new AccountManagerCallback<Bundle>() {
                        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                            int i10 = 1;
                            try {
                                Bundle result = accountManagerFuture.getResult();
                                i10 = 0;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
                            } catch (Throwable unused) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
                            }
                            c.a(UMGlobalContext.getAppContext(), c.f14559s, d.a(), new c(str2, optInt, i10));
                        }
                    }, null});
                }
            } else if (Build.VERSION.SDK_INT >= 23 && (a10 = a(str2, optInt, 0)) != null) {
                av.a(new aq(aq.f13760b, a10), 0, TimeUnit.SECONDS);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0490, code lost:
        if (r6 != null) goto L_0x049d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x049b, code lost:
        if (0 == 0) goto L_0x04a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x049d, code lost:
        r3.put("config", r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.Object r21, int r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "manual check iucc value: "
            java.lang.String r3 = "iucc"
            java.lang.String r4 = "result"
            java.lang.String r5 = ""
            r6 = 0
            r7 = 0
            java.lang.String r9 = "config"
            r10 = 0
            r11 = 1
            java.lang.String r12 = "MobclickRT"
            switch(r22) {
                case 101: goto L_0x052d;
                case 102: goto L_0x04ea;
                case 103: goto L_0x04b4;
                case 104: goto L_0x04ad;
                case 105: goto L_0x041f;
                case 106: goto L_0x03a8;
                case 107: goto L_0x036c;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.String r2 = "scene"
            java.lang.String r3 = "act_when"
            java.lang.String r4 = "screen_unlock"
            java.lang.String r5 = "screen_off"
            java.lang.String r9 = "screen_on"
            java.lang.String r13 = "umc_cfg"
            switch(r22) {
                case 201: goto L_0x035a;
                case 202: goto L_0x02c0;
                case 203: goto L_0x016d;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.String r3 = "https://aspect-upush.umeng.com/occa/v1/event/report"
            switch(r22) {
                case 301: goto L_0x011f;
                case 302: goto L_0x00d0;
                case 303: goto L_0x0081;
                case 304: goto L_0x004a;
                case 305: goto L_0x002e;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x05a3
        L_0x002e:
            com.umeng.ccg.d$c r0 = (com.umeng.ccg.d.c) r0     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r0.f14583a     // Catch:{ all -> 0x05a3 }
            int r3 = r0.f14584b     // Catch:{ all -> 0x05a3 }
            int r0 = r0.f14585c     // Catch:{ all -> 0x05a3 }
            org.json.JSONObject r0 = r1.a((java.lang.String) r2, (int) r3, (int) r0)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            com.umeng.analytics.pro.aq r2 = new com.umeng.analytics.pro.aq     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = "https://cnlogs.umeng.com/ext_event"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x05a3 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.av.a(r2, r7, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x004a:
            java.lang.String r0 = "recv INVOKE_APPACT_WHEN_SC_ON msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            boolean r0 = com.umeng.ccg.b.a((java.lang.String) r13)
            if (r0 != 0) goto L_0x005b
            java.lang.String r0 = "Local switch of [umc_cfg] is off, ignore this command."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            return
        L_0x005b:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            r3 = 304(0x130, float:4.26E-43)
            r0.put(r2, r3)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.ab r2 = f14572j     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r2.a()     // Catch:{ all -> 0x05a3 }
            org.json.JSONObject r0 = r2.a(r3, r0)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x007a
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r1.a((android.content.Context) r2, (java.lang.String) r13, (org.json.JSONObject) r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x007a:
            java.lang.String r0 = "appActAction.process return null !"
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x0081:
            java.lang.String r0 = "recv REPORT_SCREEN_UNLOCK msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            r1.b((java.lang.String) r4)     // Catch:{ all -> 0x05a3 }
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d$b r0 = (com.umeng.ccg.d.b) r0     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            org.json.JSONArray r4 = r0.a()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x05a3 }
            r5 = 2
            org.json.JSONObject r0 = com.umeng.analytics.pro.ao.a(r2, r5, r4, r0)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r2.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "screen_unlock event param: "
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x05a3 }
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.aq r2 = new com.umeng.analytics.pro.aq     // Catch:{ all -> 0x05a3 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x05a3 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.av.a(r2, r7, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x00d0:
            java.lang.String r0 = "recv REPORT_SCREEN_OFF msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            r1.b((java.lang.String) r5)     // Catch:{ all -> 0x05a3 }
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d$b r0 = (com.umeng.ccg.d.b) r0     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            org.json.JSONArray r4 = r0.a()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x05a3 }
            r5 = 3
            org.json.JSONObject r0 = com.umeng.analytics.pro.ao.a(r2, r5, r4, r0)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r2.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "screen_off event param: "
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x05a3 }
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.aq r2 = new com.umeng.analytics.pro.aq     // Catch:{ all -> 0x05a3 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x05a3 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.av.a(r2, r7, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x011f:
            java.lang.String r0 = "recv REPORT_SCREEN_ON msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            r1.b((java.lang.String) r9)     // Catch:{ all -> 0x05a3 }
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            boolean r0 = r0.containsKey(r9)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            java.util.Map<java.lang.String, com.umeng.ccg.d$b> r0 = r1.f14575l     // Catch:{ all -> 0x05a3 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d$b r0 = (com.umeng.ccg.d.b) r0     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            org.json.JSONArray r4 = r0.a()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x05a3 }
            org.json.JSONObject r0 = com.umeng.analytics.pro.ao.a(r2, r11, r4, r0)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r2.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "screen_on event param: "
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x05a3 }
            r2.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.aq r2 = new com.umeng.analytics.pro.aq     // Catch:{ all -> 0x05a3 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x05a3 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.av.a(r2, r7, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x016d:
            if (r0 == 0) goto L_0x05a3
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x05a3 }
            if (r2 == 0) goto L_0x05a3
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = "actionName"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r6.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "recv START_COLLECT msg. name is : "
            r6.append(r7)     // Catch:{ all -> 0x05a3 }
            r6.append(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r6)     // Catch:{ all -> 0x05a3 }
            boolean r6 = com.umeng.ccg.b.a((java.lang.String) r2)     // Catch:{ all -> 0x05a3 }
            if (r6 != 0) goto L_0x01af
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = "Local switch of ["
            r0.append(r3)     // Catch:{ all -> 0x05a3 }
            r0.append(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = "] is off, ignore this command."
            r0.append(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)     // Catch:{ all -> 0x05a3 }
            return
        L_0x01af:
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x05a3 }
            java.lang.String[] r7 = f14567e     // Catch:{ all -> 0x05a3 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x05a3 }
            boolean r7 = r7.contains(r2)     // Catch:{ all -> 0x05a3 }
            if (r7 == 0) goto L_0x0247
            boolean r6 = r9.equalsIgnoreCase(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "android.intent.action.SCREEN_ON"
            if (r6 == 0) goto L_0x01d5
            java.lang.String r6 = "register Intent.ACTION_SCREEN_ON"
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r6)     // Catch:{ all -> 0x05a3 }
            android.content.Context r6 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d$e r8 = f14573m     // Catch:{ all -> 0x05a3 }
            a((android.content.Context) r6, (java.lang.String) r7, (android.content.BroadcastReceiver) r8)     // Catch:{ all -> 0x05a3 }
        L_0x01d5:
            boolean r5 = r5.equalsIgnoreCase(r2)     // Catch:{ all -> 0x05a3 }
            if (r5 == 0) goto L_0x01eb
            java.lang.String r5 = "register Intent.ACTION_SCREEN_OFF"
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r5)     // Catch:{ all -> 0x05a3 }
            android.content.Context r5 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            java.lang.String r6 = "android.intent.action.SCREEN_OFF"
            com.umeng.ccg.d$e r8 = f14573m     // Catch:{ all -> 0x05a3 }
            a((android.content.Context) r5, (java.lang.String) r6, (android.content.BroadcastReceiver) r8)     // Catch:{ all -> 0x05a3 }
        L_0x01eb:
            boolean r4 = r4.equalsIgnoreCase(r2)     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x0201
            java.lang.String r4 = "register Intent.ACTION_USER_PRESENT"
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r4)     // Catch:{ all -> 0x05a3 }
            android.content.Context r4 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            java.lang.String r5 = "android.intent.action.USER_PRESENT"
            com.umeng.ccg.d$e r6 = f14573m     // Catch:{ all -> 0x05a3 }
            a((android.content.Context) r4, (java.lang.String) r5, (android.content.BroadcastReceiver) r6)     // Catch:{ all -> 0x05a3 }
        L_0x0201:
            boolean r4 = r13.equalsIgnoreCase(r2)     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x05a3
            int r4 = com.umeng.ccg.CcgAgent.getActUpFlag()     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r5.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r6 = "act up flag: "
            r5.append(r6)     // Catch:{ all -> 0x05a3 }
            r5.append(r4)     // Catch:{ all -> 0x05a3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r5)     // Catch:{ all -> 0x05a3 }
            if (r4 <= 0) goto L_0x0222
            return
        L_0x0222:
            boolean r4 = r0.has(r3)     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x05a3
            int r3 = r0.optInt(r3)     // Catch:{ all -> 0x05a3 }
            if (r3 != 0) goto L_0x0237
            android.content.Context r3 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r1.a((android.content.Context) r3, (java.lang.String) r2, (org.json.JSONObject) r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x0237:
            if (r3 != r11) goto L_0x05a3
            com.umeng.ccg.d$a r0 = new com.umeng.ccg.d$a     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            a((android.content.Context) r2, (java.lang.String) r7, (android.content.BroadcastReceiver) r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x0247:
            r1.b((java.lang.String) r2)     // Catch:{ all -> 0x05a3 }
            boolean r3 = com.umeng.ccg.CcgAgent.hasRegistedActionInfo()     // Catch:{ all -> 0x05a3 }
            if (r3 == 0) goto L_0x02b7
            java.lang.String r3 = "anti"
            com.umeng.ccg.ActionInfo r3 = com.umeng.ccg.CcgAgent.getActionInfo(r3)     // Catch:{ all -> 0x05a3 }
            if (r3 == 0) goto L_0x0259
            r10 = 1
        L_0x0259:
            java.lang.String r3 = "local_hit_sdk"
            java.lang.String r3 = r0.optString(r3)     // Catch:{ all -> 0x05a3 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x05a3 }
            if (r4 != 0) goto L_0x0293
            com.umeng.ccg.ActionInfo r4 = com.umeng.ccg.CcgAgent.getActionInfo(r3)     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x02ac
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r5.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "调用["
            r5.append(r7)     // Catch:{ all -> 0x05a3 }
            r5.append(r3)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = "] onCommand接口方法, 参数: "
            r5.append(r3)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x05a3 }
            r5.append(r3)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r3)     // Catch:{ all -> 0x05a3 }
            android.content.Context r3 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r4.onCommand(r3, r2, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x02ac
        L_0x0293:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = "忽略 本次采集项["
            r0.append(r3)     // Catch:{ all -> 0x05a3 }
            r0.append(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = "]采集请求."
            r0.append(r2)     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)     // Catch:{ all -> 0x05a3 }
        L_0x02ac:
            if (r10 != 0) goto L_0x05a3
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.as.a(r0, r6)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x02b7:
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.as.a(r0, r6)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x02c0:
            java.lang.String r4 = "recv COLLECTION_JUDGMENT msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r4)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            boolean r4 = r0 instanceof java.util.ArrayList     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x05a3
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x05a3 }
            int r4 = r0.size()     // Catch:{ all -> 0x05a3 }
            if (r4 <= 0) goto L_0x05a3
        L_0x02d3:
            if (r10 >= r4) goto L_0x05a3
            java.lang.Object r5 = r0.get(r10)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.ab r5 = (com.umeng.analytics.pro.ab) r5     // Catch:{ all -> 0x05a3 }
            java.lang.String r9 = r5.a()     // Catch:{ all -> 0x05a3 }
            boolean r11 = r13.equalsIgnoreCase(r9)     // Catch:{ all -> 0x05a3 }
            if (r11 == 0) goto L_0x02ef
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x05a3 }
            r6.<init>()     // Catch:{ all -> 0x05a3 }
            r11 = 202(0xca, float:2.83E-43)
            r6.put(r2, r11)     // Catch:{ all -> 0x05a3 }
        L_0x02ef:
            org.json.JSONObject r9 = r5.a(r9, r6)     // Catch:{ all -> 0x05a3 }
            if (r9 == 0) goto L_0x0354
            java.lang.String[] r11 = f14566d     // Catch:{ all -> 0x05a3 }
            java.util.List r11 = java.util.Arrays.asList(r11)     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = r5.a()     // Catch:{ all -> 0x05a3 }
            boolean r11 = r11.contains(r14)     // Catch:{ all -> 0x05a3 }
            r14 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r7 = "delay"
            if (r11 != 0) goto L_0x0310
            long r16 = r9.optLong(r7)     // Catch:{ all -> 0x05a3 }
            long r16 = r16 * r14
            goto L_0x0312
        L_0x0310:
            r16 = 0
        L_0x0312:
            java.lang.String r5 = r5.a()     // Catch:{ all -> 0x05a3 }
            boolean r5 = r13.equalsIgnoreCase(r5)     // Catch:{ all -> 0x05a3 }
            if (r5 == 0) goto L_0x0328
            int r5 = r9.optInt(r3)     // Catch:{ all -> 0x05a3 }
            if (r5 != 0) goto L_0x0328
            long r16 = r9.optLong(r7)     // Catch:{ all -> 0x05a3 }
            long r16 = r16 * r14
        L_0x0328:
            r14 = r16
            r9.remove(r7)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r5.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "send START_COLLECT msg, delayTs = "
            r5.append(r7)     // Catch:{ all -> 0x05a3 }
            r5.append(r14)     // Catch:{ all -> 0x05a3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r5)     // Catch:{ all -> 0x05a3 }
            android.content.Context r5 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r7 = 203(0xcb, float:2.84E-43)
            com.umeng.ccg.d r16 = a()     // Catch:{ all -> 0x05a3 }
            r18 = r14
            r14 = r5
            r15 = r7
            r17 = r9
            com.umeng.ccg.c.a(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x05a3 }
        L_0x0354:
            int r10 = r10 + 1
            r7 = 0
            goto L_0x02d3
        L_0x035a:
            java.lang.String r2 = "recv PARSE_CONFIG msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x05a3 }
            if (r2 == 0) goto L_0x05a3
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x05a3 }
            r1.c((org.json.JSONObject) r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x036c:
            if (r0 == 0) goto L_0x05a3
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ all -> 0x038d }
            if (r2 == 0) goto L_0x05a3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x038d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x038d }
            r2.<init>()     // Catch:{ all -> 0x038d }
            java.lang.String r3 = "[IMPRINT_IUCC_CHANGED] iucc : "
            r2.append(r3)     // Catch:{ all -> 0x038d }
            r2.append(r0)     // Catch:{ all -> 0x038d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x038d }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x038d }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x038d }
            goto L_0x05a3
        L_0x038d:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[imprint] process error "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.umeng.commonsdk.debug.UMRTLog.e(r12, r0)
            goto L_0x05a3
        L_0x03a8:
            if (r0 == 0) goto L_0x05a3
            boolean r7 = r0 instanceof org.json.JSONObject
            if (r7 == 0) goto L_0x05a3
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x05a3 }
            boolean r7 = r0.has(r4)     // Catch:{ all -> 0x05a3 }
            if (r7 == 0) goto L_0x03d4
            int r4 = r0.optInt(r4)     // Catch:{ all -> 0x05a3 }
            r4 = r4 & r11
            if (r4 == 0) goto L_0x03cf
            boolean r4 = r0.has(r9)     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x03cf
            org.json.JSONObject r0 = r0.optJSONObject(r9)     // Catch:{ all -> 0x05a3 }
            f14565c = r0     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x03cf
            com.umeng.ccg.CcgAgent.notifyConfigReady(r0)     // Catch:{ all -> 0x05a3 }
            r10 = 1
        L_0x03cf:
            if (r10 != 0) goto L_0x03d4
            com.umeng.ccg.CcgAgent.notifyConfigReady(r6)     // Catch:{ all -> 0x05a3 }
        L_0x03d4:
            boolean r0 = r20.g()     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x03f9
            java.lang.String r0 = "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志)."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)     // Catch:{ all -> 0x05a3 }
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r0, r3, r5)     // Catch:{ all -> 0x05a3 }
            r1.a((boolean) r11)     // Catch:{ all -> 0x05a3 }
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d r3 = a()     // Catch:{ all -> 0x05a3 }
            r4 = 101(0x65, float:1.42E-43)
            com.umeng.ccg.c.a(r2, r4, r3, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x03f9:
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r1.c((android.content.Context) r0)     // Catch:{ all -> 0x05a3 }
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r0, r3, r5)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r3.<init>()     // Catch:{ all -> 0x05a3 }
            r3.append(r2)     // Catch:{ all -> 0x05a3 }
            r3.append(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x041f:
            java.lang.String[] r0 = com.umeng.ccg.CcgAgent.getCollectItemList()
            int r2 = r0.length
            r3 = 0
        L_0x0425:
            if (r3 >= r2) goto L_0x0450
            r5 = r0[r3]
            java.util.ArrayList r7 = com.umeng.ccg.CcgAgent.getForbidSdkArray(r5)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r13 = "[forbid_sdk] 采集项: "
            r8.append(r13)
            r8.append(r5)
            java.lang.String r5 = "; 值: "
            r8.append(r5)
            java.lang.String r5 = r7.toString()
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r5)
            int r3 = r3 + 1
            goto L_0x0425
        L_0x0450:
            java.lang.String r0 = "[workEvent]: recv LOAD_CONFIG msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            r2 = 106(0x6a, float:1.49E-43)
            android.content.Context r3 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x0493 }
            org.json.JSONObject r6 = r1.b((android.content.Context) r3)     // Catch:{ all -> 0x0493 }
            if (r6 == 0) goto L_0x047f
            boolean r3 = r1.a((org.json.JSONObject) r6)     // Catch:{ all -> 0x0493 }
            if (r3 == 0) goto L_0x0475
            int r3 = r0.intValue()     // Catch:{ all -> 0x0493 }
            r3 = r3 | r11
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0493 }
            goto L_0x0488
        L_0x0475:
            int r3 = r0.intValue()     // Catch:{ all -> 0x0493 }
            r3 = r3 | r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0493 }
            goto L_0x0488
        L_0x047f:
            int r3 = r0.intValue()     // Catch:{ all -> 0x0493 }
            r3 = r3 | r10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0493 }
        L_0x0488:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r3.put(r4, r0)     // Catch:{ all -> 0x04a0 }
            if (r6 == 0) goto L_0x04a0
            goto L_0x049d
        L_0x0493:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r3.put(r4, r0)     // Catch:{ all -> 0x04a0 }
            if (r6 == 0) goto L_0x04a0
        L_0x049d:
            r3.put(r9, r6)     // Catch:{ all -> 0x04a0 }
        L_0x04a0:
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()
            com.umeng.ccg.d r4 = a()
            com.umeng.ccg.c.a(r0, r2, r4, r3)
            goto L_0x05a3
        L_0x04ad:
            java.lang.String r0 = "[workEvent]: recv FETCH_FAILED msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r0)
            goto L_0x05a3
        L_0x04b4:
            java.lang.String r2 = "[workEvent]: recv FETCH_SUCCESS msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()
            if (r0 == 0) goto L_0x05a3
            boolean r3 = r0 instanceof org.json.JSONObject
            if (r3 == 0) goto L_0x05a3
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x05a3 }
            org.json.JSONObject r3 = r0.optJSONObject(r9)     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "sourceIucc"
            java.lang.String r0 = r0.optString(r4)     // Catch:{ all -> 0x05a3 }
            if (r3 == 0) goto L_0x05a3
            boolean r4 = r20.i()     // Catch:{ all -> 0x05a3 }
            if (r4 == 0) goto L_0x04e2
            java.lang.String r4 = "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值"
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r4)     // Catch:{ all -> 0x05a3 }
            r20.h()     // Catch:{ all -> 0x05a3 }
            r1.a((boolean) r10)     // Catch:{ all -> 0x05a3 }
        L_0x04e2:
            r1.a((android.content.Context) r2, (org.json.JSONObject) r3, (java.lang.String) r0)     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.CcgAgent.notifyConfigChanged(r3)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x04ea:
            java.lang.String r2 = "[workEvent]: recv FETCH_RESPONSE msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)
            r1.f14574k = r5
            r2 = 104(0x68, float:1.46E-43)
            if (r0 == 0) goto L_0x0521
            boolean r3 = r0 instanceof org.json.JSONObject
            if (r3 == 0) goto L_0x0521
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x05a3 }
            org.json.JSONObject r3 = r0.optJSONObject(r9)     // Catch:{ all -> 0x05a3 }
            boolean r3 = r1.a((org.json.JSONObject) r3)     // Catch:{ all -> 0x05a3 }
            if (r3 == 0) goto L_0x0514
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d r3 = a()     // Catch:{ all -> 0x05a3 }
            r4 = 103(0x67, float:1.44E-43)
            com.umeng.ccg.c.a(r2, r4, r3, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x0514:
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.d r3 = a()     // Catch:{ all -> 0x05a3 }
            com.umeng.ccg.c.a(r0, r2, r3, r6)     // Catch:{ all -> 0x05a3 }
            goto L_0x05a3
        L_0x0521:
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()
            com.umeng.ccg.d r3 = a()
            com.umeng.ccg.c.a(r0, r2, r3, r6)
            goto L_0x05a3
        L_0x052d:
            if (r0 == 0) goto L_0x05a3
            boolean r4 = r0 instanceof java.lang.String
            if (r4 == 0) goto L_0x05a3
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: "
            r4.append(r6)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r4)
            android.content.Context r4 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()
            org.json.JSONObject r4 = com.umeng.analytics.pro.ao.a((android.content.Context) r4, (java.lang.String) r0)
            if (r4 == 0) goto L_0x0579
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r6.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "[imprint] send request. body: "
            r6.append(r7)     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x05a3 }
            r6.append(r7)     // Catch:{ all -> 0x05a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r6)     // Catch:{ all -> 0x05a3 }
            com.umeng.analytics.pro.ar r6 = new com.umeng.analytics.pro.ar     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "https://ucc.umeng.com/v2/inn/fetch"
            r6.<init>(r7, r4, r0)     // Catch:{ all -> 0x05a3 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x05a3 }
            r7 = 0
            com.umeng.analytics.pro.av.a(r6, r7, r0)     // Catch:{ all -> 0x05a3 }
        L_0x0579:
            boolean r0 = r20.i()     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x05a3
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            r1.c((android.content.Context) r0)     // Catch:{ all -> 0x05a3 }
            android.content.Context r0 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r0, r3, r5)     // Catch:{ all -> 0x05a3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a3 }
            r3.<init>()     // Catch:{ all -> 0x05a3 }
            r3.append(r2)     // Catch:{ all -> 0x05a3 }
            r3.append(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x05a3 }
            com.umeng.commonsdk.debug.UMRTLog.i(r12, r2)     // Catch:{ all -> 0x05a3 }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x05a3 }
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(java.lang.Object, int):void");
    }
}
