package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

public class bn implements be {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13896a = false;

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f13896a) {
            OpenIDSDK.a(context);
            this.f13896a = true;
        }
        boolean a10 = OpenIDSDK.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (!a10) {
            return null;
        }
        return OpenIDSDK.c(context);
    }
}
