package com.google.android.gms.internal.base;

import android.os.Build;

final class zan {
    public static boolean zaa() {
        if (Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T') {
            return true;
        }
        return false;
    }
}
