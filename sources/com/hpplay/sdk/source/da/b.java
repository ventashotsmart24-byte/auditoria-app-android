package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.log.SourceLog;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11776a = "DaClientLoader";

    /* renamed from: b  reason: collision with root package name */
    private static final String f11777b = "com.hpplay.sdk.source.da.DaClientImpl";

    public static j a(Context context) {
        try {
            j newInstance = DaClientImpl.class.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            SourceLog.i(f11776a, "com.hpplay.sdk.source.da.DaClientImpl initializ success");
            return newInstance;
        } catch (Exception e10) {
            SourceLog.w(f11776a, (Throwable) e10);
            return null;
        }
    }
}
