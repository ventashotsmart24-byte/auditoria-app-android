package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

class bl implements be {
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = OpenIdHelper.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (!a10) {
            return null;
        }
        return OpenIdHelper.b(context);
    }
}
