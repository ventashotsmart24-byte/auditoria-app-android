package com.efs.sdk.base.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.a.b;
import com.efs.sdk.base.core.util.a.d;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile long f5120b = -1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5121a;

    /* renamed from: com.efs.sdk.base.core.a.a$a  reason: collision with other inner class name */
    public static class C0074a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f5122a = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a a() {
        return C0074a.f5122a;
    }

    public static long b() {
        if (f5120b == -1) {
            return System.currentTimeMillis();
        }
        return SystemClock.elapsedRealtime() + f5120b;
    }

    private a() {
        this.f5121a = true;
    }

    public final HttpResponse a(String str, c cVar, File file, boolean z10) {
        String b10 = cVar.b();
        String a10 = a(str, cVar);
        if (this.f5121a) {
            Log.i("efs.px.api", "Upload file, url is ".concat(String.valueOf(a10)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b10);
        d a11 = new d(a10).a((Map<String, String>) hashMap);
        a11.f5309a.f5304d = file;
        d a12 = a11.a("type", cVar.f5131h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f5138o);
        return a12.a("size", sb.toString()).a("flow_limit", Boolean.toString(z10)).a((AbsHttpListener) d.a()).a().b();
    }

    public final HttpResponse a(String str, c cVar, byte[] bArr, boolean z10) {
        String b10 = cVar.b();
        String a10 = a(str, cVar);
        if (this.f5121a) {
            Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(a10)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b10);
        d a11 = new d(a10).a((Map<String, String>) hashMap);
        b bVar = a11.f5309a;
        bVar.f5303c = bArr;
        bVar.f5307g = true;
        d a12 = a11.a("type", cVar.f5131h);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f5138o);
        return a12.a("size", sb.toString()).a("flow_limit", Boolean.toString(z10)).a((AbsHttpListener) d.a()).a().b();
    }

    private static String a(String str, c cVar) {
        byte b10 = cVar.f5130g;
        String str2 = b10 != 1 ? b10 != 2 ? b10 != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs";
        return str + str2;
    }

    public static void a(HttpResponse httpResponse) {
        if (httpResponse != null && httpResponse.succ && !TextUtils.isEmpty(httpResponse.data)) {
            try {
                JSONObject jSONObject = new JSONObject(httpResponse.data);
                String optString = jSONObject.optString(Constants.KEY_HTTP_CODE, "-1");
                httpResponse.setBizCode(optString);
                if (!"0".equals(optString)) {
                    httpResponse.succ = false;
                }
                if (jSONObject.has("cver")) {
                    ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
                }
                long j10 = jSONObject.getLong("stm") * 1000;
                if (Math.abs(j10 - b()) > 1500000) {
                    f5120b = j10 - SystemClock.elapsedRealtime();
                }
            } catch (Throwable th) {
                Log.e("efs.px.api", "checkPxReturn error", th);
            }
        }
    }
}
