package com.umeng.message.proguard;

import android.os.Build;

public final class az {
    public static void a(ad adVar) {
        if (Build.VERSION.SDK_INT >= 23 && adVar != null && adVar.f15320b != null) {
            Object obj = adVar.f15321c;
            if (obj instanceof c) {
                ((c) obj).c();
            }
            adVar.f15321c = null;
        }
    }
}
