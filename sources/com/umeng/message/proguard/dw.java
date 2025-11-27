package com.umeng.message.proguard;

import android.view.View;
import android.view.ViewParent;

public final class dw {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.List<java.lang.Integer> a(android.view.View r18) {
        /*
            r0 = r18
            java.lang.Class<com.umeng.message.proguard.dw> r1 = com.umeng.message.proguard.dw.class
            monitor-enter(r1)
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00fa }
            r2.<init>()     // Catch:{ all -> 0x00fa }
            boolean r3 = com.umeng.message.proguard.dx.a()     // Catch:{ all -> 0x00fa }
            r4 = 1
            if (r3 != 0) goto L_0x0018
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00fa }
            r2.add(r3)     // Catch:{ all -> 0x00fa }
        L_0x0018:
            com.umeng.message.proguard.bz r3 = com.umeng.message.proguard.bz.a()     // Catch:{ all -> 0x00fa }
            android.app.Activity r5 = r3.b()     // Catch:{ all -> 0x00fa }
            r6 = 0
            if (r5 == 0) goto L_0x002a
            boolean r3 = r3.f15552a     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r3 = 0
            goto L_0x002b
        L_0x002a:
            r3 = 1
        L_0x002b:
            r5 = 2
            if (r3 == 0) goto L_0x0035
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00fa }
            r2.add(r3)     // Catch:{ all -> 0x00fa }
        L_0x0035:
            boolean r3 = b(r18)     // Catch:{ all -> 0x00fa }
            r7 = 3
            if (r3 != 0) goto L_0x0043
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00fa }
            r2.add(r3)     // Catch:{ all -> 0x00fa }
        L_0x0043:
            r3 = 4
            if (r0 != 0) goto L_0x0048
            r8 = 0
            goto L_0x007e
        L_0x0048:
            int r8 = r18.getWidth()     // Catch:{ all -> 0x00fa }
            r9 = 20
            if (r8 < r9) goto L_0x0058
            int r8 = r18.getHeight()     // Catch:{ all -> 0x00fa }
            if (r8 < r9) goto L_0x0058
            r8 = 1
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            if (r8 != 0) goto L_0x007e
            java.lang.String r9 = "Valid"
            java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = "expose invalid: w:"
            r10[r6] = r11     // Catch:{ all -> 0x00fa }
            int r11 = r18.getWidth()     // Catch:{ all -> 0x00fa }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00fa }
            r10[r4] = r11     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = " h:"
            r10[r5] = r11     // Catch:{ all -> 0x00fa }
            int r11 = r18.getHeight()     // Catch:{ all -> 0x00fa }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00fa }
            r10[r7] = r11     // Catch:{ all -> 0x00fa }
            com.umeng.message.proguard.ce.a(r9, r10)     // Catch:{ all -> 0x00fa }
        L_0x007e:
            if (r8 != 0) goto L_0x0087
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00fa }
            r2.add(r8)     // Catch:{ all -> 0x00fa }
        L_0x0087:
            r8 = 5
            if (r0 == 0) goto L_0x00ef
            int r9 = r18.getVisibility()     // Catch:{ all -> 0x00fa }
            if (r9 != 0) goto L_0x00ef
            android.view.ViewParent r9 = r18.getParent()     // Catch:{ all -> 0x00fa }
            if (r9 != 0) goto L_0x0097
            goto L_0x00ef
        L_0x0097:
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ all -> 0x00fa }
            r9.<init>()     // Catch:{ all -> 0x00fa }
            boolean r10 = r0.getGlobalVisibleRect(r9)     // Catch:{ all -> 0x00fa }
            if (r10 != 0) goto L_0x00a3
            goto L_0x00ef
        L_0x00a3:
            int r10 = r9.height()     // Catch:{ all -> 0x00fa }
            long r10 = (long) r10     // Catch:{ all -> 0x00fa }
            int r12 = r9.width()     // Catch:{ all -> 0x00fa }
            long r12 = (long) r12     // Catch:{ all -> 0x00fa }
            long r10 = r10 * r12
            int r12 = r18.getHeight()     // Catch:{ all -> 0x00fa }
            long r12 = (long) r12     // Catch:{ all -> 0x00fa }
            int r0 = r18.getWidth()     // Catch:{ all -> 0x00fa }
            long r14 = (long) r0     // Catch:{ all -> 0x00fa }
            long r12 = r12 * r14
            r14 = 50
            long r14 = r14 * r12
            r16 = 100
            long r14 = r14 / r16
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x00c9
            r0 = 1
            goto L_0x00ca
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            if (r0 != 0) goto L_0x00ee
            java.lang.String r14 = "Valid"
            r15 = 6
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x00fa }
            java.lang.String r16 = "expose invalid rect:"
            r15[r6] = r16     // Catch:{ all -> 0x00fa }
            r15[r4] = r9     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = " region:"
            r15[r5] = r4     // Catch:{ all -> 0x00fa }
            java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x00fa }
            r15[r7] = r4     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = " size:"
            r15[r3] = r4     // Catch:{ all -> 0x00fa }
            java.lang.Long r3 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x00fa }
            r15[r8] = r3     // Catch:{ all -> 0x00fa }
            com.umeng.message.proguard.ce.a(r14, r15)     // Catch:{ all -> 0x00fa }
        L_0x00ee:
            r6 = r0
        L_0x00ef:
            if (r6 != 0) goto L_0x00f8
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00fa }
            r2.add(r0)     // Catch:{ all -> 0x00fa }
        L_0x00f8:
            monitor-exit(r1)
            return r2
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dw.a(android.view.View):java.util.List");
    }

    private static boolean b(View view) {
        boolean z10;
        boolean z11;
        if (view == null) {
            return false;
        }
        if (view.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            do {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
                if (view.getVisibility() == 0) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
            } while (z10);
        }
        if (!z10) {
            ce.a("Valid", "expose invalid visible.");
        }
        return z10;
    }
}
