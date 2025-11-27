package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.analytics.pro.k;
import com.umeng.message.proguard.bz;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.eh;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class dh {

    /* renamed from: a  reason: collision with root package name */
    private static long f15758a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Activity> f15759b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static WeakReference<da> f15760c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Callable<Void> f15761d = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void call() {
            try {
                dh.b(2051);
                cb.c(new Runnable() {
                    public final void run() {
                        da daVar;
                        cf cfVar;
                        da daVar2;
                        cf cfVar2;
                        da daVar3;
                        cf cfVar3;
                        try {
                            WeakReference a10 = dh.f15759b;
                            if (a10 != null) {
                                Activity activity = (Activity) a10.get();
                                if (activity != null) {
                                    if (!activity.isFinishing()) {
                                        dh.f15762e.a(activity);
                                        ce.a("Banner", "floating banner timeout!");
                                        WeakReference c10 = dh.f15760c;
                                        if (c10 != null && (daVar3 = (da) c10.get()) != null && (cfVar3 = daVar3.f15727a) != null) {
                                            cfVar3.b();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                ce.a("Banner", "floating banner timeout!");
                                WeakReference c11 = dh.f15760c;
                                if (c11 != null && (daVar2 = (da) c11.get()) != null && (cfVar2 = daVar2.f15727a) != null) {
                                    cfVar2.b();
                                }
                            }
                        } finally {
                            ce.a("Banner", "floating banner timeout!");
                            WeakReference c12 = dh.f15760c;
                            if (!(c12 == null || (daVar = (da) c12.get()) == null || (cfVar = daVar.f15727a) == null)) {
                                cfVar.b();
                            }
                        }
                    }
                });
                return null;
            } catch (Throwable th) {
                ce.d("Banner", "floating banner timeout error:", th.getMessage());
                return null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final di f15762e = new di();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static volatile Future<Void> f15763f;

    /* access modifiers changed from: private */
    public static void f() {
        Future<Void> future = f15763f;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        f15763f = null;
    }

    /* access modifiers changed from: private */
    public static void b(int i10) {
        dl dlVar;
        WeakReference<dl> weakReference = f15762e.f15783a;
        if (weakReference == null) {
            dlVar = null;
        } else {
            dlVar = weakReference.get();
        }
        if (dlVar != null) {
            eh.a onStatusListener = dlVar.f15791c.getOnStatusListener();
            ck ckVar = dlVar.f15789a.f15786a;
            if (onStatusListener != null && ckVar != null) {
                try {
                    ckVar.f15606b.put("exposed_duration", onStatusListener.e());
                    cr.a().a(ckVar, i10);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Activity activity) {
        Activity activity2;
        WeakReference<Activity> weakReference = f15759b;
        if (weakReference == null || (activity2 = weakReference.get()) == null || activity2 != activity) {
            return false;
        }
        return f15762e.a();
    }

    public static void a(dk dkVar, long j10, da daVar) {
        if (!bz.a().f15552a) {
            cr.a().b(dkVar.f15786a, CastStatusCodes.NOT_ALLOWED);
            return;
        }
        Activity b10 = bz.a().b();
        if (b10 == null || b10.isFinishing()) {
            cr.a().b(dkVar.f15786a, CastStatusCodes.APPLICATION_NOT_RUNNING);
        } else {
            a(b10, dkVar, j10, daVar);
        }
    }

    public static void b(Activity activity) {
        try {
            di diVar = f15762e;
            if (diVar.a()) {
                b(2053);
                diVar.a(activity);
            }
            f();
        } catch (Throwable th) {
            ce.a("Banner", "floating banner dismiss err:" + th.getMessage());
        }
        f15759b = null;
    }

    public static void a(Activity activity, dk dkVar, long j10, da daVar) {
        if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
            cr.a().b(dkVar.f15786a, CastStatusCodes.MESSAGE_TOO_LARGE);
            ce.a("Banner", "current activity not allow show ad:", activity.getClass().getName());
            return;
        }
        final Activity activity2 = activity;
        final dk dkVar2 = dkVar;
        final long j11 = j10;
        final da daVar2 = daVar;
        activity.getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                try {
                    Activity b10 = bz.a().b();
                    if (b10 == null || activity2 == b10) {
                        dh.b(activity2, dkVar2, j11, daVar2);
                        return;
                    }
                    ce.b("Banner", "activity not top skip.");
                    cr.a().b(dkVar2.f15786a, CastStatusCodes.APPLICATION_NOT_FOUND);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public static /* synthetic */ void b(Activity activity, dk dkVar, long j10, final da daVar) {
        if (activity != null && dkVar != null && daVar != null) {
            final ck ckVar = dkVar.f15786a;
            if (ed.a(activity)) {
                ce.a("Banner", "floating banner: activity window not match skipped.");
                cr.a().b(ckVar, 2010);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - f15758a;
            if (elapsedRealtime < 1000) {
                ce.b("Banner", "skipped floating banner show interval:", Long.valueOf(elapsedRealtime));
                cr.a().b(ckVar, CastStatusCodes.MESSAGE_SEND_BUFFER_TOO_FULL);
                return;
            }
            f15758a = SystemClock.elapsedRealtime();
            f();
            di diVar = f15762e;
            if (diVar.a()) {
                b(2052);
                diVar.a(activity);
            }
            dl dlVar = new dl(activity, dkVar);
            f15760c = new WeakReference<>(daVar);
            f15759b = new WeakReference<>(activity);
            dj djVar = new dj();
            final long j11 = j10;
            final dl dlVar2 = dlVar;
            final ck ckVar2 = ckVar;
            final da daVar2 = daVar;
            final dj djVar2 = djVar;
            final AnonymousClass2 r02 = new eh.a() {
                public final void a() {
                    dh.f();
                    long e10 = j11 - e();
                    if (e10 < 0) {
                        e10 = 0;
                    }
                    Future unused = dh.f15763f = cb.a(dh.f15761d, e10, TimeUnit.MILLISECONDS);
                }

                public final void b() {
                    dh.f();
                }

                public final void c() {
                    dlVar2.f15791c.post(new Runnable() {
                        public final void run() {
                            try {
                                cr.a().a(ckVar2, (cq.a) new cq.a() {
                                    public final void a() {
                                        cf cfVar = daVar2.f15727a;
                                        if (cfVar != null) {
                                            cfVar.a();
                                        }
                                    }

                                    public final void a(String str) {
                                        cf cfVar = daVar2.f15727a;
                                        if (cfVar != null) {
                                            cfVar.a(2010, str);
                                        }
                                    }
                                });
                                if (!ckVar2.f15606b.optBoolean("expose_verify", false)) {
                                    AnonymousClass2 r12 = AnonymousClass2.this;
                                    ef efVar = dlVar2.f15791c;
                                    ckVar2.f15611g = efVar.getWidth();
                                    ckVar2.f15612h = efVar.getHeight();
                                    List<Integer> a10 = dw.a(efVar);
                                    if (!a10.isEmpty()) {
                                        for (Integer intValue : a10) {
                                            cr.a().c(ckVar2, intValue.intValue());
                                        }
                                    }
                                    ckVar2.f15606b.put("expose_verify", true);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                public final void d() {
                    bz.a().b((bz.b) djVar2);
                }
            };
            AnonymousClass3 r13 = new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        ce.a("Banner", "floating banner closed!");
                        Activity activity = (Activity) view.getContext();
                        if (activity != null) {
                            dh.f();
                            dh.b((int) k.f14288b);
                            dh.f15762e.a(activity);
                            cf cfVar = da.this.f15727a;
                            if (cfVar != null) {
                                cfVar.b();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            dlVar.f15791c.setDismissListener(r13);
            dlVar.f15790b.setOnClickListener(r13);
            dlVar.f15791c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(final View view) {
                    try {
                        ce.a("Banner", "floating banner clicked.");
                        Activity activity = (Activity) view.getContext();
                        if (activity != null) {
                            dh.f();
                            dh.f15762e.a(activity);
                            ck.this.f15606b.put("clicked", true);
                            ck.this.f15606b.put("exposed_duration", r02.e());
                            ck ckVar = ck.this;
                            eh.a aVar = r02;
                            ckVar.f15617m = aVar.f15905g;
                            ckVar.f15618n = aVar.f15907i;
                            ckVar.f15619o = aVar.f15906h;
                            ckVar.f15620p = aVar.f15908j;
                            ckVar.f15621q = aVar.f15909k;
                            ckVar.f15622r = aVar.f15910l;
                            ckVar.f15623s = aVar.f15911m;
                            ckVar.f15624t = aVar.f15912n;
                            dy.a(de.a(), ck.this, (cq.a) new cq.a() {
                                public final void a() {
                                    cf cfVar = daVar.f15727a;
                                    if (cfVar != null) {
                                        cfVar.a(view);
                                    }
                                }

                                public final void a(String str) {
                                    cf cfVar = daVar.f15727a;
                                    if (cfVar != null) {
                                        cfVar.a(IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK, str);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            dlVar.f15791c.setOnStatusListener(r02);
            dlVar.f15792d = new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        ce.a("Banner", "floating banner closed.");
                        Activity activity = (Activity) view.getContext();
                        if (activity != null) {
                            dh.f();
                            dh.b(2054);
                            dh.f15762e.a(activity);
                            cf cfVar = da.this.f15727a;
                            if (cfVar != null) {
                                cfVar.b();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            if (diVar.a(dlVar, activity)) {
                bz.a().a((bz.b) djVar);
                ef efVar = dlVar.f15791c;
                efVar.setAlpha(0.0f);
                efVar.measure(-2, -2);
                efVar.animate().translationX(0.0f).translationY((float) (efVar.getMeasuredHeight() * -1)).setDuration(1).setListener(new AnimatorListenerAdapter(efVar) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ View f15885a;

                    {
                        this.f15885a = r1;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        try {
                            this.f15885a.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }
}
