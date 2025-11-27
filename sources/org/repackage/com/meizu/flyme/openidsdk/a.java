package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;

final class a extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r0 == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0086
            if (r6 != 0) goto L_0x0006
            goto L_0x0086
        L_0x0006:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = "shouldUpdateId, notifyFlag : "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r2.concat(r3)
            org.repackage.com.meizu.flyme.openidsdk.b.a((java.lang.String) r2)
            r2 = 1
            if (r0 != r2) goto L_0x002f
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L_0x0046
        L_0x002d:
            r1 = 1
            goto L_0x0046
        L_0x002f:
            r3 = 2
            if (r0 != r3) goto L_0x0043
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L_0x0046
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L_0x0046
        L_0x0043:
            if (r0 != 0) goto L_0x0046
            goto L_0x002d
        L_0x0046:
            if (r1 != 0) goto L_0x0049
            return
        L_0x0049:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            org.repackage.com.meizu.flyme.openidsdk.b r6 = org.repackage.com.meizu.flyme.openidsdk.b.a()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x005e
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f8652b
            goto L_0x0080
        L_0x005e:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0069
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f8654d
            goto L_0x0080
        L_0x0069:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0074
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f8653c
            goto L_0x0080
        L_0x0074:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x007f
            org.repackage.com.meizu.flyme.openidsdk.OpenId r5 = r6.f8651a
            goto L_0x0080
        L_0x007f:
            r5 = 0
        L_0x0080:
            if (r5 != 0) goto L_0x0083
            return
        L_0x0083:
            r5.b()
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.a.onReceive(android.content.Context, android.content.Intent):void");
    }
}
