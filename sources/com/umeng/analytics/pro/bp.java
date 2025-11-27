package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.vivo.identifier.IdentifierManager;

public class bp implements be {
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a10 = IdentifierManager.a(context);
        bs.a("getOAID", "isSupported", Boolean.valueOf(a10));
        if (!a10) {
            return null;
        }
        return IdentifierManager.b(context);
    }
}
