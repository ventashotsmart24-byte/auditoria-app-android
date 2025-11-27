package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;

public class l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f13230a = "l";

    /* renamed from: b  reason: collision with root package name */
    private static volatile l f13231b = null;

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<a> f13232c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static ArrayList<b> f13233d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Application f13234e = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f13235j = false;

    /* renamed from: f  reason: collision with root package name */
    private int f13236f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13237g;

    /* renamed from: h  reason: collision with root package name */
    private int f13238h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f13239i = 1;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private String f13240a;

        /* renamed from: b  reason: collision with root package name */
        private int f13241b;

        /* renamed from: c  reason: collision with root package name */
        private long f13242c = t.a(l.f13234e);

        public a(String str, int i10) {
            this.f13240a = str;
            this.f13241b = i10;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ALog.e(l.f13230a, "click report", "lastActiveTime", Long.valueOf(this.f13242c), "currentActiveTime", Long.valueOf(currentTimeMillis));
            long j10 = this.f13242c;
            if (j10 == 0 || UtilityImpl.a(j10, currentTimeMillis)) {
                this.f13241b |= 8;
            }
            TaobaoRegister.clickMessage(l.f13234e, this.f13240a, (String) null, this.f13241b, this.f13242c);
        }
    }

    public interface b {
        void a();

        void b();
    }

    private l() {
        f13232c = new ArrayList<>();
        f13233d = new ArrayList<>();
    }

    public static l a() {
        if (f13231b == null) {
            synchronized (l.class) {
                if (f13231b == null) {
                    f13231b = new l();
                }
            }
        }
        return f13231b;
    }

    public void b() {
        ArrayList<a> arrayList = f13232c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f13232c.clear();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i10 = this.f13236f;
        if ((i10 & 1) != 1) {
            this.f13236f = i10 | 1 | 2;
        } else if ((i10 & 2) == 2) {
            this.f13236f = i10 & -3;
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f13237g) {
            t.a(f13234e, System.currentTimeMillis());
            if (!f13235j) {
                f13235j = true;
            }
        }
        this.f13237g = false;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        int i10 = this.f13238h;
        this.f13238h = i10 + 1;
        if (i10 == 0) {
            ALog.i(f13230a, "onActivityStarted back to force", new Object[0]);
            this.f13237g = true;
            this.f13239i = 1;
            ThreadPoolExecutorFactory.execute(new m(this));
        }
    }

    public void onActivityStopped(Activity activity) {
        int i10 = this.f13238h - 1;
        this.f13238h = i10;
        if (i10 == 0) {
            this.f13239i = 0;
            ThreadPoolExecutorFactory.execute(new n(this));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f13233d.add(bVar);
        }
    }
}
