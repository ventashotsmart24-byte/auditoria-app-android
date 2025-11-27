package com.efs.sdk.h5pagesdk;

import android.content.Context;
import android.view.View;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

public class H5Manager {
    public static final String TAG = "H5Manager";

    /* renamed from: g  reason: collision with root package name */
    private static EfsReporter f5338g = null;

    /* renamed from: h  reason: collision with root package name */
    private static H5ConfigMananger f5339h = null;
    public static boolean isDebug = true;

    public static H5ConfigMananger getH5ConfigMananger() {
        return f5339h;
    }

    public static EfsReporter getReporter() {
        return f5338g;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init H5 manager error! parameter is null!");
            return;
        }
        f5338g = efsReporter;
        f5339h = new H5ConfigMananger(context, efsReporter);
    }

    public static void setWebView(View view) {
        H5ConfigMananger h5ConfigMananger;
        if (view == null || (h5ConfigMananger = f5339h) == null) {
            if (isDebug) {
                Log.e(TAG, "webView为null，或H5功能未初始化完成");
            }
        } else if (h5ConfigMananger.isH5TracerEnable() || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            UApmJSBridge uApmJSBridge = new UApmJSBridge();
            try {
                Class<?> cls = view.getClass();
                try {
                    Object invoke = cls.getMethod("getSettings", new Class[0]).invoke(view, new Object[0]);
                    if (invoke != null) {
                        invoke.getClass().getMethod("setJavaScriptEnabled", new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{Boolean.TRUE});
                    }
                } catch (Throwable unused) {
                }
                cls.getMethod("addJavascriptInterface", new Class[]{Object.class, String.class}).invoke(view, new Object[]{uApmJSBridge, "UAPM_JSBridge"});
            } catch (Throwable unused2) {
            }
        } else if (isDebug) {
            Log.d(TAG, "未注入JavascriptInterface：H5命中状态=" + f5339h.isH5TracerEnable() + "; 集成测试状态=" + IntegrationTestingUtil.isIntegrationTestingInPeriod());
        }
    }
}
