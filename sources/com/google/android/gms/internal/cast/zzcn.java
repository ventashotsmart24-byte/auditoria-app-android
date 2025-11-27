package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public final class zzcn {
    public static final int zza;

    static {
        int i10;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            i10 = 67108864;
        } else {
            i10 = 0;
        }
        zza = i10;
        if (i11 < 31 && i11 >= 30) {
            String str = Build.VERSION.CODENAME;
            if (str.length() == 1 && str.charAt(0) >= 'S') {
                str.charAt(0);
            }
        }
    }

    public static PendingIntent zza(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getActivity(context, i10, intent, i11);
    }

    public static PendingIntent zzb(Context context, int i10, Intent intent, int i11) {
        return PendingIntent.getBroadcast(context, i10, intent, i11);
    }
}
