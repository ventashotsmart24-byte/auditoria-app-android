package com.efs.sdk.base.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Long> f5140a = new HashMap<String, Long>() {
        {
            put("flow_5min", 300000L);
            put("flow_hour", 3600000L);
            put("flow_day", 86400000L);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Long> f5141b = new HashMap<String, Long>() {
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", 2097152L);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Map<String, AtomicInteger> f5142c;

    /* renamed from: d  reason: collision with root package name */
    private volatile SharedPreferences f5143d;

    /* renamed from: e  reason: collision with root package name */
    private volatile SharedPreferences.Editor f5144e;

    /* renamed from: f  reason: collision with root package name */
    private Context f5145f;

    /* renamed from: g  reason: collision with root package name */
    private String f5146g;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f5147a = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c a() {
        return a.f5147a;
    }

    private void b() {
        try {
            c();
        } catch (Throwable th) {
            Log.e("efs.flow", "init sharedpreferences error", th);
        }
    }

    private void c() {
        if (this.f5143d == null) {
            synchronized (c.class) {
                if (this.f5143d == null) {
                    this.f5143d = SharedPreferencesUtils.getSharedPreferences(this.f5145f, this.f5146g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.f5144e == null) {
            synchronized (c.class) {
                if (this.f5144e == null) {
                    this.f5144e = this.f5143d.edit();
                }
            }
        }
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i10 = message.what;
        if (i10 == 0) {
            b();
            if (this.f5143d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            } else if (this.f5144e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
            } else {
                String valueOf = String.valueOf(message.obj);
                long j10 = (long) message.arg1;
                String netStatus = GlobalInfoManager.getInstance().getNetStatus();
                for (String next : f5140a.keySet()) {
                    String concat = "curr_time_".concat(String.valueOf(next));
                    if (!this.f5143d.contains(concat)) {
                        this.f5144e.putLong(concat, System.currentTimeMillis());
                    }
                    for (String next2 : a(next, valueOf, netStatus)) {
                        this.f5144e.putLong(next2, this.f5143d.getLong(next2, 0) + j10);
                    }
                }
                this.f5144e.apply();
            }
        } else if (i10 != 1) {
            Log.w("efs.flow", "flow stat listener not support action '" + message.what + "'");
        } else {
            String valueOf2 = String.valueOf(message.obj);
            long j11 = (long) message.arg1;
            b();
            if (this.f5143d == null) {
                Log.w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            } else if (this.f5144e == null) {
                Log.w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            } else {
                String concat2 = "curr_time_".concat(valueOf2);
                if (Math.abs(System.currentTimeMillis() - this.f5143d.getLong(concat2, System.currentTimeMillis())) >= j11) {
                    for (String next3 : this.f5143d.getAll().keySet()) {
                        if (next3.startsWith(valueOf2)) {
                            this.f5144e.putLong(next3, 0);
                        }
                    }
                    this.f5144e.putLong(concat2, System.currentTimeMillis());
                    this.f5144e.apply();
                    this.f5142c.clear();
                }
            }
        }
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper());
        this.f5142c = new ConcurrentHashMap(5);
        this.f5145f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.f5146g = ControllerCenter.getGlobalEnvStruct().getAppid();
        b();
        File c10 = com.efs.sdk.base.core.util.a.c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (c10.exists()) {
            FileUtil.delete(c10);
        }
    }

    public final boolean a(String str, long j10) {
        String netStatus = GlobalInfoManager.getInstance().getNetStatus();
        boolean z10 = true;
        for (Map.Entry next : f5140a.entrySet()) {
            long longValue = ((Long) next.getValue()).longValue();
            z10 = a((String) next.getKey(), longValue, str, netStatus, j10);
            if (!z10) {
                break;
            }
        }
        return z10;
    }

    private boolean a(String str, long j10, String str2, String str3, long j11) {
        String str4 = str;
        long j12 = j11;
        b();
        if (this.f5143d == null) {
            Log.w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> a10 = a(str4, str2, str3);
        Map<String, String> c10 = b.a().c();
        for (String next : a10) {
            if (Math.abs(System.currentTimeMillis() - this.f5143d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j10) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str4;
                obtain.arg1 = Long.valueOf(j10).intValue();
                sendMessage(obtain);
            }
            long a11 = a(c10, str4, next);
            long j13 = this.f5143d.getLong(next, 0);
            if (j13 + j12 > a11) {
                Log.i("efs.flow", "flow limit, key: " + next + ", max: " + a11 + ", now: " + j13 + ", size: " + j12);
                a(next);
                return false;
            }
        }
        return true;
    }

    private void a(String str) {
        if (!this.f5142c.containsKey(str) || this.f5142c.get(str) == null || this.f5142c.get(str).get() <= 10) {
            f.a.f5270a.a(b.a().f5225d.mConfigVersion, str);
            if (str.equals("flow_day")) {
                f.a.f5270a.a(b.a().f5225d.mConfigVersion);
            }
            if (!this.f5142c.containsKey(str)) {
                this.f5142c.put(str, new AtomicInteger());
            }
            this.f5142c.get(str).incrementAndGet();
        }
    }

    private static long a(Map<String, String> map, String str, String str2) {
        long longValue = f5141b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return longValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            Log.w("efs.flow", "get max flow error", th);
            return longValue;
        }
    }

    private static List<String> a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }
}
