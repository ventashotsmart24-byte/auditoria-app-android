package com.umeng.message.proguard;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.umeng.message.proguard.bz;

/* renamed from: com.umeng.message.proguard.do  reason: invalid class name */
final class Cdo {

    /* renamed from: a  reason: collision with root package name */
    eg f15825a;

    /* renamed from: b  reason: collision with root package name */
    a f15826b;

    /* renamed from: c  reason: collision with root package name */
    dp f15827c;

    /* renamed from: com.umeng.message.proguard.do$a */
    public interface a {
        void a();

        void a(View view);
    }

    public final boolean a() {
        return this.f15825a != null;
    }

    public final void b() {
        ViewGroup viewGroup;
        bz.a().b((bz.b) this.f15827c);
        eg egVar = this.f15825a;
        if (!(egVar == null || (viewGroup = (ViewGroup) egVar.getParent()) == null)) {
            viewGroup.removeView(this.f15825a);
        }
        this.f15827c = null;
        this.f15825a = null;
        this.f15826b = null;
    }

    public final void a(Activity activity) {
        ViewGroup b10;
        eg egVar = this.f15825a;
        if (egVar != null && (b10 = b(activity)) != null && egVar.getParent() != b10) {
            if (egVar.getParent() != null) {
                ((ViewGroup) egVar.getParent()).removeView(egVar);
            }
            if (activity.isFinishing()) {
                ce.b("FloatingIcon", "activity has finished skip.");
            } else if (ed.a(activity)) {
                ce.b("FloatingIcon", "activity window not match skipped.");
            } else if (!dt.a().a((Class<? extends Activity>) activity.getClass())) {
                b10.addView(egVar);
                ce.b("FloatingIcon", "onShow");
            }
        }
    }

    public static ViewGroup b(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return (ViewGroup) window.getDecorView().findViewById(16908290);
        } catch (Throwable unused) {
            return null;
        }
    }
}
