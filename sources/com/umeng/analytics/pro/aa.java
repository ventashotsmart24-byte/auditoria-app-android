package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.d;
import java.util.ArrayList;
import java.util.List;

public class aa {

    /* renamed from: c  reason: collision with root package name */
    private static volatile aa f13701c;

    /* renamed from: a  reason: collision with root package name */
    private y f13702a = new z();

    /* renamed from: b  reason: collision with root package name */
    private String f13703b;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f13704d;

    /* renamed from: e  reason: collision with root package name */
    private String f13705e;

    public interface a {
        void a(String str, long j10, long j11, long j12);

        void a(String str, String str2, long j10, long j11, long j12);
    }

    private aa() {
    }

    public static aa a() {
        if (f13701c == null) {
            synchronized (aa.class) {
                if (f13701c == null) {
                    f13701c = new aa();
                }
            }
        }
        return f13701c;
    }

    private String f(Context context) {
        Context context2 = context;
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(w.f14445d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h10 = h(context);
        long i10 = i(context);
        String str = this.f13703b;
        long a10 = w.a(context);
        long j10 = a10 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a10);
        if (!FieldManager.allow(d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        long j11 = i10;
        long j12 = h10;
        long j13 = j10;
        String str2 = str;
        a(j11, j12, j13, str2, false);
        this.f13703b = this.f13702a.a(context2);
        a(j11, j12, j13, str2, true);
        this.f13702a.a(context2, this.f13703b);
        return this.f13703b;
    }

    private boolean g(Context context) {
        if (!TextUtils.isEmpty(this.f13703b) && k.a(context).a(this.f13703b) > 0) {
            return true;
        }
        return false;
    }

    private long h(Context context) {
        return a(context, w.f14447f);
    }

    private long i(Context context) {
        return a(context, w.f14442a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j10 = sharedPreferences.getLong(w.f14446e, 0);
            long j11 = sharedPreferences.getLong(w.f14447f, 0);
            if (FieldManager.allow(d.E) && j10 > 0 && j11 == 0) {
                long a10 = w.a(appContext);
                if (a10 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j11 = j10 + (a10 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j11 - j10));
            return this.f13702a.a(j10, j11);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.f13702a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f13703b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f13703b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f13703b)) {
            try {
                this.f13703b = PreferenceWrapper.getDefault(context).getString("session_id", (String) null);
            } catch (Exception unused) {
            }
        }
        return this.f13703b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f13703b)) {
            this.f13703b = d(context);
        }
        if (TextUtils.isEmpty(this.f13703b) || j(context) || g(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|(2:10|11)|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String b(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r2 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r2)     // Catch:{ all -> 0x0021 }
            if (r2 != 0) goto L_0x000b
            java.lang.String r2 = ""
            monitor-exit(r1)
            return r2
        L_0x000b:
            java.lang.String r0 = r1.d(r2)     // Catch:{ all -> 0x0021 }
            r1.f13703b = r0     // Catch:{ all -> 0x0021 }
            boolean r0 = r1.e(r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001d
            java.lang.String r2 = r1.f(r2)     // Catch:{ Exception -> 0x001d }
            r1.f13703b = r2     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            java.lang.String r2 = r1.f13703b     // Catch:{ all -> 0x0021 }
            monitor-exit(r1)
            return r2
        L_0x0021:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.aa.b(android.content.Context):java.lang.String");
    }

    public void a(long j10) {
        this.f13702a.a(j10);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (aa.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(w.f14445d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar != null && (list = this.f13704d) != null && list.size() != 0) {
            this.f13704d.remove(aVar);
        }
    }

    public String a(Context context, long j10) {
        if (TextUtils.isEmpty(this.f13705e)) {
            String str = "SUB" + j10;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", new Object[]{0}));
            this.f13705e = sb.toString();
        }
        return this.f13705e;
    }

    private long a(Context context, String str) {
        long j10;
        try {
            j10 = PreferenceWrapper.getDefault(context).getLong(str, 0);
        } catch (Exception unused) {
            j10 = 0;
        }
        return j10 <= 0 ? System.currentTimeMillis() : j10;
    }

    private void a(long j10, long j11, long j12, String str, boolean z10) {
        List<a> list = this.f13704d;
        if (list != null) {
            for (a next : list) {
                if (z10) {
                    try {
                        next.a(str, this.f13703b, j10, j11, j12);
                    } catch (Exception unused) {
                    }
                } else {
                    next.a(this.f13703b, j10, j11, j12);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (this.f13704d == null) {
                this.f13704d = new ArrayList();
            }
            if (!this.f13704d.contains(aVar)) {
                this.f13704d.add(aVar);
            }
        }
    }
}
