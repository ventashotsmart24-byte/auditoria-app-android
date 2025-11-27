package com.google.android.gms.cast.internal.media;

import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MediaCommon {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.RecentlyNullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Integer mediaRepeatModeFromString(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r6.hashCode()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1118317585: goto L_0x002e;
                case -962896020: goto L_0x0024;
                case 1645938909: goto L_0x001a;
                case 1645952171: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0038
        L_0x0010:
            java.lang.String r1 = "REPEAT_OFF"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 0
            goto L_0x0039
        L_0x001a:
            java.lang.String r1 = "REPEAT_ALL"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 1
            goto L_0x0039
        L_0x0024:
            java.lang.String r1 = "REPEAT_SINGLE"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 2
            goto L_0x0039
        L_0x002e:
            java.lang.String r1 = "REPEAT_ALL_AND_SHUFFLE"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0038
            r6 = 3
            goto L_0x0039
        L_0x0038:
            r6 = -1
        L_0x0039:
            if (r6 == 0) goto L_0x0051
            if (r6 == r5) goto L_0x004c
            if (r6 == r4) goto L_0x0047
            if (r6 == r3) goto L_0x0042
            return r0
        L_0x0042:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            return r6
        L_0x0047:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            return r6
        L_0x004c:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            return r6
        L_0x0051:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.media.MediaCommon.mediaRepeatModeFromString(java.lang.String):java.lang.Integer");
    }

    @RecentlyNullable
    public static String zza(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return "REPEAT_OFF";
        }
        if (intValue == 1) {
            return "REPEAT_ALL";
        }
        if (intValue == 2) {
            return "REPEAT_SINGLE";
        }
        if (intValue != 3) {
            return null;
        }
        return "REPEAT_ALL_AND_SHUFFLE";
    }
}
