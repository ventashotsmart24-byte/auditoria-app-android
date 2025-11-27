package com.titans.entity;

import t9.i;

public final class CdnType {
    public static final String DIGITAL_TYPE_AWS = "4";
    public static final String DIGITAL_TYPE_ICDN = "1";
    public static final String DIGITAL_TYPE_PCDN = "5";
    public static final String DIGITAL_TYPE_PEERSTAR = "6";
    public static final String DIGITAL_TYPE_QINIU = "3";
    public static final String DIGITAL_TYPE_WANGSU = "2";
    public static final CdnType INSTANCE = new CdnType();
    public static final String TYPE_AWS = "aws";
    public static final String TYPE_ICDN = "icdn";
    public static final String TYPE_PCDN = "pcdn";
    public static final String TYPE_PEERSTAR = "peerstar";
    public static final String TYPE_QINIU = "qiniu";
    public static final String TYPE_WANGSU = "wangsu";

    private CdnType() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String transform(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "cdnDigital"
            t9.i.g(r2, r0)
            int r0 = r2.hashCode()
            switch(r0) {
                case 49: goto L_0x003d;
                case 50: goto L_0x0031;
                case 51: goto L_0x0025;
                case 52: goto L_0x000c;
                case 53: goto L_0x0019;
                case 54: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "6"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0016
            goto L_0x0049
        L_0x0016:
            java.lang.String r2 = "peerstar"
            goto L_0x004b
        L_0x0019:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0022
            goto L_0x0049
        L_0x0022:
            java.lang.String r2 = "pcdn"
            goto L_0x004b
        L_0x0025:
            java.lang.String r0 = "3"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002e
            goto L_0x0049
        L_0x002e:
            java.lang.String r2 = "qiniu"
            goto L_0x004b
        L_0x0031:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x003a
            goto L_0x0049
        L_0x003a:
            java.lang.String r2 = "wangsu"
            goto L_0x004b
        L_0x003d:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            java.lang.String r2 = "icdn"
            goto L_0x004b
        L_0x0049:
            java.lang.String r2 = "aws"
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titans.entity.CdnType.transform(java.lang.String):java.lang.String");
    }

    public final String transformOnDetectNull(String str) {
        boolean z10;
        i.g(str, "cdnDigital");
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "lslb";
        }
        return transform(str);
    }
}
