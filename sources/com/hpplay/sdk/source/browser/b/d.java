package com.hpplay.sdk.source.browser.b;

import android.os.Build;
import android.os.Process;
import com.hpplay.common.log.LeLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11619a = "WebViewUtils";

    public static void a() {
        Method method;
        int myUid = Process.myUid();
        LeLog.i(f11619a, "init process uid:" + myUid);
        if (myUid != 1000) {
            LeLog.i(f11619a, "hookWebView, app is not system app");
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewFactory");
            Field declaredField = cls.getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            Object obj = declaredField.get((Object) null);
            if (obj != null) {
                LeLog.i(f11619a, "sProviderInstance isn't null");
                return;
            }
            if (i10 > 22) {
                method = cls.getDeclaredMethod("getProviderClass", new Class[0]);
            } else if (i10 == 22) {
                method = cls.getDeclaredMethod("getFactoryClass", new Class[0]);
            } else {
                LeLog.i(f11619a, "Don't need to Hook WebView");
                return;
            }
            method.setAccessible(true);
            Class cls2 = (Class) method.invoke(cls, new Object[0]);
            Class<?> cls3 = Class.forName("android.webkit.WebViewDelegate");
            Constructor<?> declaredConstructor = cls3.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            if (i10 < 26) {
                Constructor constructor = cls2.getConstructor(new Class[]{cls3});
                if (constructor != null) {
                    constructor.setAccessible(true);
                    obj = constructor.newInstance(new Object[]{declaredConstructor.newInstance(new Object[0])});
                }
            } else {
                Field declaredField2 = cls.getDeclaredField("CHROMIUM_WEBVIEW_FACTORY_METHOD");
                declaredField2.setAccessible(true);
                String str = (String) declaredField2.get((Object) null);
                if (str == null) {
                    str = "create";
                }
                Method method2 = cls2.getMethod(str, new Class[]{cls3});
                if (method2 != null) {
                    obj = method2.invoke((Object) null, new Object[]{declaredConstructor.newInstance(new Object[0])});
                }
            }
            if (obj != null) {
                declaredField.set("sProviderInstance", obj);
                LeLog.i(f11619a, "Hook success!");
                return;
            }
            LeLog.i(f11619a, "Hook failed!");
        } catch (Exception e10) {
            LeLog.w(f11619a, "hookWebView exception: " + e10);
        }
    }
}
