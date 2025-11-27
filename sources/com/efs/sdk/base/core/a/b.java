package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.concurrent.c;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

public final class b extends AbsHttpListener {

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f5123a = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) {
        HttpResponse httpResponse = (HttpResponse) obj;
        if (httpResponse != null) {
            a.a();
            a.a(httpResponse);
        }
    }

    public final void onError(HttpResponse httpResponse) {
        if (httpResponse != null) {
            a(httpResponse);
        }
    }

    public final void onSuccess(HttpResponse httpResponse) {
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(str);
                f a10 = f.a.f5270a;
                if (a10.f5267b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "config_coverage", a10.f5266a.f5260c);
                    bVar.put("cver", Integer.valueOf(parseInt));
                    a10.f5267b.send(bVar);
                }
            }
        }
    }

    private b() {
    }

    public static b a() {
        return a.f5123a;
    }

    private static void a(HttpResponse httpResponse) {
        f.a.f5270a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
