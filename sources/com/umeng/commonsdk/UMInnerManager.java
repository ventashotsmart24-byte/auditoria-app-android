package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

public class UMInnerManager {
    private static Class<?> innerImplClazz;
    private static Method sendInternalMethod;

    static {
        Class<UMInnerImpl> cls = UMInnerImpl.class;
        try {
            int i10 = UMInnerImpl.f14616a;
            innerImplClazz = cls;
            Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", new Class[]{Context.class});
            if (declaredMethod != null) {
                sendInternalMethod = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    public static void sendInnerPackage(Context context) {
        Method method;
        if (context != null && UMUtils.isMainProgress(context)) {
            if (SdkVersion.SDK_TYPE != 1) {
                Class<?> cls = innerImplClazz;
                if (cls != null && (method = sendInternalMethod) != null) {
                    try {
                        method.invoke(cls, new Object[]{context});
                    } catch (Throwable unused) {
                    }
                }
            } else {
                UMConfigureInternation.sendInternal(context);
            }
        }
    }
}
