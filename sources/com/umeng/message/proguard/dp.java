package com.umeng.message.proguard;

import android.app.Activity;
import android.view.ViewGroup;
import com.umeng.message.proguard.bz;

final class dp extends bz.b {

    /* renamed from: a  reason: collision with root package name */
    final Cdo f15830a;

    public dp(Cdo doVar) {
        this.f15830a = doVar;
    }

    public final String a() {
        return "fi";
    }

    public final void b(Activity activity) {
        eg egVar;
        ViewGroup b10;
        try {
            if (this.f15830a.a() && (egVar = this.f15830a.f15825a) != null && (b10 = Cdo.b(activity)) != null && egVar.getParent() == b10) {
                ((ViewGroup) egVar.getParent()).removeView(egVar);
                ce.b("FloatingIcon", "onHidden");
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(final Activity activity) {
        try {
            if (this.f15830a.a() && !(activity instanceof cx)) {
                activity.getWindow().getDecorView().post(new Runnable() {
                    public final void run() {
                        try {
                            dp.this.f15830a.a(activity);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
