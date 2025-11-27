package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.InputDevice;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.q;
import t9.i;

public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final g1 f12561a = new g1();

    public final boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.touchscreen");
    }

    public final boolean b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        i.f(configuration, "context.resources.configuration");
        if (configuration.touchscreen != 1) {
            return true;
        }
        return false;
    }

    public final boolean c(Context context) {
        for (int device : InputDevice.getDeviceIds()) {
            InputDevice device2 = InputDevice.getDevice(device);
            if (device2 != null && (device2.getSources() & q.a.f14389b) == 4098) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(Context context) {
        i.g(context, f.X);
        if (!a(context) || !b(context) || !c(context)) {
            return false;
        }
        return true;
    }
}
