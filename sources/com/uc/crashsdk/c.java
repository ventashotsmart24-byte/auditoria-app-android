package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13554a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13555b = false;

    private void a(Activity activity, int i10) {
        if (1 == i10) {
            String unused = b.ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ad = "";
        }
        b.D();
        if (g.M()) {
            boolean unused3 = b.ac = true;
            synchronized (b.f13528ab) {
                b.f13528ab.put(activity, Integer.valueOf(i10));
                a(i10);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    public final void onActivityDestroyed(Activity activity) {
        if (g.M()) {
            boolean unused = b.ac = true;
            synchronized (b.f13528ab) {
                b.f13528ab.remove(activity);
                a(2);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r4) {
        /*
            r3 = this;
            boolean r0 = com.uc.crashsdk.e.u()
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "[LifeCycle] ignore state change while crashing"
            java.lang.String r0 = "crashsdk"
            com.uc.crashsdk.a.a.a(r0, r4)
            return
        L_0x000e:
            r0 = 1
            if (r0 != r4) goto L_0x0013
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 != 0) goto L_0x003d
            java.util.WeakHashMap r1 = com.uc.crashsdk.b.f13528ab
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0022:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            if (r2 == 0) goto L_0x0022
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 != r0) goto L_0x0022
            goto L_0x003e
        L_0x003d:
            r0 = r4
        L_0x003e:
            boolean r4 = r3.f13554a
            if (r4 == r0) goto L_0x0047
            com.uc.crashsdk.b.b((boolean) r0)
            r3.f13554a = r0
        L_0x0047:
            java.util.WeakHashMap r4 = com.uc.crashsdk.b.f13528ab
            boolean r4 = r4.isEmpty()
            boolean r0 = r3.f13555b
            if (r0 == r4) goto L_0x005a
            if (r4 == 0) goto L_0x0058
            com.uc.crashsdk.b.w()
        L_0x0058:
            r3.f13555b = r4
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.c.a(int):void");
    }
}
