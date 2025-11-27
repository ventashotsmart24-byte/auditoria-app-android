package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f5457a = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private static g f5458c;

    /* renamed from: b  reason: collision with root package name */
    private b f5459b = new b();

    private g() {
    }

    public static g c() {
        if (f5458c == null) {
            f5458c = new g();
        }
        return f5458c;
    }

    public final void a(f.b bVar) {
        String str;
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar2 = this.f5459b;
        try {
            String a10 = bVar.a();
            bVar2.f5448a.put(bVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            c a11 = a.a().a(a10);
            String b10 = bVar.b();
            if (!TextUtils.isEmpty(b10)) {
                a11.f5471d = b10;
            }
            a11.f5472e = bVar.c();
            HashMap hashMap = new HashMap();
            int e10 = bVar.e();
            for (int i10 = 0; i10 < e10; i10++) {
                hashMap.put(bVar.a(i10), bVar.b(i10));
            }
            a11.f5473f = b.a(bVar);
            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                String str2 = a11.f5472e;
                if ((str2 == null || !str2.equalsIgnoreCase("get")) && (str = a11.f5472e) != null && str.equalsIgnoreCase("post") && a11.f5473f < 10240) {
                    if (!hashMap.containsKey("Content-Type")) {
                        if (!hashMap.containsKey("content-type")) {
                            return;
                        }
                    }
                    String str3 = (String) hashMap.get("Content-Type");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = (String) hashMap.get("content-type");
                    }
                    if (str3 == null) {
                        return;
                    }
                    if (str3.contains("application/json") || str3.contains("application/x-www-form-urlencoded")) {
                        a11.f5474g = new String(bVar.d());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f5457a.getAndIncrement());
    }

    public final void a(f.d dVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.f5459b;
        Log.i("NetTrace-Interceptor", "save response");
        String a10 = dVar.a();
        if (bVar.f5448a != null) {
            a.a().a(a10).f5475h = dVar.b();
        }
    }

    public final InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
