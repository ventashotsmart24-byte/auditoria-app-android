package com.efs.sdk.base.core.a;

import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.c;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

public final class d extends AbsHttpListener {

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f5139a = new d((byte) 0);
    }

    public /* synthetic */ d(byte b10) {
        this();
    }

    private static void b(HttpResponse httpResponse) {
        f.a.f5270a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    private static void c(HttpResponse httpResponse) {
        int parseInt;
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(str)) > b.a().f5225d.mConfigVersion) {
                b.a().a(parseInt);
            }
        }
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        HttpResponse httpResponse = (HttpResponse) obj;
        if (httpResponse != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((Map) httpResponse.extra).putAll(bVar.f5306f);
            bVar.f5306f.clear();
            a.a();
            a.a(httpResponse);
        }
    }

    public final void onError(HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse != null) {
            b(httpResponse);
            c(httpResponse);
        }
    }

    public final void onSuccess(HttpResponse httpResponse) {
        String str;
        int i10;
        if (!((Map) httpResponse.extra).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) httpResponse.extra).get("flow_limit"))) {
            if (((Map) httpResponse.extra).containsKey("type")) {
                str = (String) ((Map) httpResponse.extra).get("type");
            } else {
                str = "";
            }
            if (((Map) httpResponse.extra).containsKey("size")) {
                String str2 = (String) ((Map) httpResponse.extra).get("size");
                if (!TextUtils.isEmpty(str2)) {
                    i10 = Integer.parseInt(str2);
                    com.efs.sdk.base.core.b.c a10 = com.efs.sdk.base.core.b.c.a();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i10;
                    a10.sendMessage(obtain);
                }
            }
            i10 = 0;
            com.efs.sdk.base.core.b.c a102 = com.efs.sdk.base.core.b.c.a();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i10;
            a102.sendMessage(obtain2);
        }
        b(httpResponse);
        f.a.f5270a.f5268c.f5261b.incrementAndGet();
        c(httpResponse);
        a(httpResponse);
    }

    private d() {
    }

    public static d a() {
        return a.f5139a;
    }

    private static void a(HttpResponse httpResponse) {
        String str;
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                str = "upload result : " + "false";
            } else {
                str = "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString();
            }
            Log.i("efs.px.api", str);
        }
    }
}
