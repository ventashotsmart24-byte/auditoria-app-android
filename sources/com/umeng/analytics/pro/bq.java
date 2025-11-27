package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.miui.deviceid.IdentifierManager;

class bq implements be {
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = IdentifierManager.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (!a10) {
            return null;
        }
        return IdentifierManager.b(context);
    }
}
