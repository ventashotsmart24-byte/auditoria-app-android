package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* renamed from: a  reason: collision with root package name */
    private static Context f13631a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final CoreProtocol f13632a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f13631a == null && context != null) {
            f13631a = context.getApplicationContext();
        }
        return a.f13632a;
    }

    public void onConnectionAvailable() {
        q.a(f13631a).a();
    }

    public void onSenderIdle() {
        q.a(f13631a).b();
    }

    public void removeCacheData(Object obj) {
        q.a(f13631a).a(obj);
    }

    public JSONObject setupReportData(long j10) {
        return q.a(f13631a).a(j10);
    }

    public void workEvent(Object obj, int i10) {
        q.a(f13631a).a(obj, i10);
    }

    private CoreProtocol() {
    }
}
