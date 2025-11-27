package com.mobile.brasiltv.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

public abstract class z0 {
    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str2.hashCode();
            if (!str2.equals("China")) {
                if (str.length() < 6 || str.length() > 17) {
                    return false;
                }
                return true;
            } else if (str.length() == 11) {
                return Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$").matcher(str).matches();
            }
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r1 = " "
            if (r0 != 0) goto L_0x008a
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x008a
            r6.hashCode()
            int r0 = r6.hashCode()
            r2 = 0
            r3 = 2
            r4 = -1
            switch(r0) {
                case -771733562: goto L_0x0032;
                case 1997815692: goto L_0x0027;
                case 2011108078: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x003c
        L_0x001c:
            java.lang.String r0 = "Canada"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0025
            goto L_0x003c
        L_0x0025:
            r4 = 2
            goto L_0x003c
        L_0x0027:
            java.lang.String r0 = "Brazil"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0030
            goto L_0x003c
        L_0x0030:
            r4 = 1
            goto L_0x003c
        L_0x0032:
            java.lang.String r0 = "United States of America"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r4 = 0
        L_0x003c:
            switch(r4) {
                case 0: goto L_0x0061;
                case 1: goto L_0x0040;
                case 2: goto L_0x0061;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x008a
        L_0x0040:
            int r0 = r5.length()
            if (r0 <= r3) goto L_0x008a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.substring(r2, r3)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = r5.substring(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x008c
        L_0x0061:
            int r0 = r5.length()
            r3 = 3
            if (r0 <= r3) goto L_0x008a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "("
            r0.append(r4)
            java.lang.String r2 = r5.substring(r2, r3)
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            java.lang.String r2 = r5.substring(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x008c
        L_0x008a:
            java.lang.String r0 = ""
        L_0x008c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r5 = r0
        L_0x0094:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "+"
            r0.append(r2)
            r0.append(r6)
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.z0.b(java.lang.String, java.lang.String):java.lang.String");
    }
}
