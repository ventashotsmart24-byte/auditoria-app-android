package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.ct;
import com.umeng.message.proguard.eh;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class dq extends dc {

    /* renamed from: h  reason: collision with root package name */
    static WeakReference<dr> f15833h;

    public dq(cz czVar) {
        super(czVar);
    }

    public static /* synthetic */ void a(dq dqVar, Activity activity, ck ckVar, da daVar, cl clVar) {
        dq dqVar2 = dqVar;
        final ck ckVar2 = ckVar;
        final da daVar2 = daVar;
        final cl clVar2 = clVar;
        if (activity.isFinishing()) {
            ce.b("Interstitial", "activity has finished skip.");
            cr.a().b(ckVar2, 2013);
        } else if (ed.a(activity)) {
            ce.b("Interstitial", "activity window not match skipped.");
            cr.a().b(ckVar2, 2011);
        } else {
            final dr drVar = new dr(activity, clVar2);
            AnonymousClass3 r14 = new eh.a() {
                public final void a(Configuration configuration) {
                    int i10;
                    dr drVar = drVar;
                    int i11 = drVar.f15872e;
                    if (i11 != -1 && (i10 = configuration.orientation) != i11) {
                        drVar.f15872e = i10;
                        try {
                            drVar.f15870c.b();
                            ViewGroup.LayoutParams layoutParams = drVar.f15870c.a().getLayoutParams();
                            drVar.f15871d.getLayoutParams().width = layoutParams.width;
                            drVar.f15871d.requestLayout();
                            drVar.f15871d.invalidate();
                        } catch (Throwable th) {
                            ce.d("Interstitial", "onConfigurationChanged:", th.getMessage());
                        }
                    }
                }

                public final void c() {
                    eh ehVar = drVar.f15868a;
                    if (ehVar != null) {
                        ehVar.post(new Runnable() {
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
                                        AnonymousClass3 r12 = AnonymousClass3.this;
                                        eh ehVar = drVar.f15868a;
                                        ckVar2.f15611g = ehVar.getWidth();
                                        ckVar2.f15612h = ehVar.getHeight();
                                        List<Integer> a10 = dw.a(ehVar);
                                        if (!a10.isEmpty()) {
                                            for (Integer intValue : a10) {
                                                cr.a().c(ckVar2, intValue.intValue());
                                            }
                                        }
                                        ckVar2.f15606b.put("expose_verify", true);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }

                public final void d() {
                }
            };
            eh ehVar = drVar.f15868a;
            if (ehVar != null) {
                ehVar.setOnStatusListener(r14);
            }
            drVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    daVar2.b();
                    cn cnVar = clVar2.f15626b;
                    if (cnVar != null) {
                        cnVar.d();
                    }
                }
            });
            final ck ckVar3 = ckVar;
            final AnonymousClass3 r32 = r14;
            final cl clVar3 = clVar;
            final da daVar3 = daVar;
            final dr drVar2 = drVar;
            AnonymousClass5 r02 = new View.OnClickListener() {
                public final void onClick(final View view) {
                    try {
                        ckVar3.f15606b.put("clicked", true);
                        ckVar3.f15606b.put("exposed_duration", r32.e());
                        cn cnVar = clVar3.f15626b;
                        if (cnVar != null) {
                            cnVar.e();
                        }
                        cn cnVar2 = clVar3.f15626b;
                        if (cnVar2 != null) {
                            cnVar2.f();
                        }
                        ck ckVar = ckVar3;
                        eh.a aVar = r32;
                        ckVar.f15617m = aVar.f15905g;
                        ckVar.f15618n = aVar.f15907i;
                        ckVar.f15619o = aVar.f15906h;
                        ckVar.f15620p = aVar.f15908j;
                        ckVar.f15621q = aVar.f15909k;
                        ckVar.f15622r = aVar.f15910l;
                        ckVar.f15623s = aVar.f15911m;
                        ckVar.f15624t = aVar.f15912n;
                        dy.a(de.a(), ckVar3, (cq.a) new cq.a() {
                            public final void a() {
                                cf cfVar = daVar3.f15727a;
                                if (cfVar != null) {
                                    cfVar.a(view);
                                }
                            }

                            public final void a(String str) {
                                cf cfVar = daVar3.f15727a;
                                if (cfVar != null) {
                                    cfVar.a(IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK, str);
                                }
                            }
                        });
                        dq.f15833h = null;
                        drVar2.dismiss();
                    } catch (Throwable unused) {
                    }
                }
            };
            LinearLayout linearLayout = drVar.f15871d;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(r02);
            }
            final dr drVar3 = drVar;
            final ck ckVar4 = ckVar;
            final AnonymousClass3 r42 = r14;
            final da daVar4 = daVar;
            AnonymousClass6 r03 = new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        dq.f15833h = null;
                        drVar3.dismiss();
                        ckVar4.f15606b.put("exposed_duration", r42.e());
                        cr.a().a(ckVar4, 2210);
                        cf cfVar = daVar4.f15727a;
                        if (cfVar != null) {
                            cfVar.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            ImageView imageView = drVar.f15869b;
            if (imageView != null) {
                imageView.setOnClickListener(r03);
            }
            drVar.f15873f = r03;
            if (f15833h != null) {
                ce.b("Interstitial", "sDialogRef not null");
                dr drVar4 = f15833h.get();
                if (drVar4 != null && drVar4.isShowing()) {
                    ce.b("Interstitial", "dismiss last");
                    View.OnClickListener onClickListener = drVar4.f15873f;
                    if (onClickListener != null) {
                        onClickListener.onClick((View) null);
                    }
                }
            }
            drVar.show();
            f15833h = new WeakReference<>(drVar);
        }
    }

    public final ck b() {
        ck a10 = ci.a(this.f15730b).a(this.f15729a);
        if (a10 == null) {
            ce.b("Interstitial", "type:", this.f15730b, " request failed.");
            throw new cd("request failed. code:2000");
        } else if (a10.f15608d != 0) {
            throw new cd(a10.f15607c);
        } else if (!a10.f15609e || bs.a(a10.a()) == bs.f15537f) {
            return a10;
        } else {
            throw new cd("interstitial style error:" + a10.a());
        }
    }

    public final bx.a b(final ck ckVar) {
        Bitmap bitmap;
        Context a10 = de.a();
        if (ckVar.f15609e) {
            String l10 = ckVar.l();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            ct.a(true, l10, new ct.a() {
                public final void a(String str) {
                }

                public final void a() {
                    atomicBoolean.set(false);
                }
            });
            if (atomicBoolean.get()) {
                bitmap = null;
            } else {
                ce.b("Interstitial", "video download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("video download failed.");
            }
        } else {
            bitmap = cc.a(a10, ckVar.b());
            if (bitmap == null) {
                ce.b("Interstitial", "image download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("image download failed.");
            }
        }
        final cl clVar = new cl(ckVar);
        if (ckVar.f15609e) {
            clVar.f15626b = new co(a10, clVar);
        } else {
            clVar.f15626b = new cm(a10, clVar);
        }
        cn cnVar = clVar.f15626b;
        if (cnVar != null) {
            cnVar.a(bitmap);
        }
        cn cnVar2 = clVar.f15626b;
        if (cnVar2 != null) {
            cnVar2.b();
        }
        return new da() {

            /* renamed from: e  reason: collision with root package name */
            private boolean f15839e = false;

            /* JADX WARNING: Can't wrap try/catch for region: R(7:32|33|34|35|(1:37)|38|39) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009b */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5 A[Catch:{ all -> 0x0138, all -> 0x014b }] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:65:0x0125=Splitter:B:65:0x0125, B:29:0x0088=Splitter:B:29:0x0088, B:34:0x009b=Splitter:B:34:0x009b, B:25:0x007c=Splitter:B:25:0x007c} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(final android.app.Activity r9) {
                /*
                    r8 = this;
                    boolean r0 = r8.f15839e
                    r1 = 2010(0x7da, float:2.817E-42)
                    r2 = 0
                    java.lang.String r3 = "Interstitial"
                    r4 = 1
                    if (r0 == 0) goto L_0x001b
                    java.lang.Object[] r9 = new java.lang.Object[r4]
                    java.lang.String r0 = "already called show."
                    r9[r2] = r0
                    com.umeng.message.proguard.ce.d(r3, r9)
                    com.umeng.message.proguard.cf r9 = r8.f15727a
                    if (r9 == 0) goto L_0x001a
                    r9.a(r1, r0)
                L_0x001a:
                    return
                L_0x001b:
                    r0 = 2
                    com.umeng.message.proguard.dq r5 = com.umeng.message.proguard.dq.this     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.cz r5 = r5.f15729a     // Catch:{ all -> 0x0138 }
                    boolean r5 = r5.f15718c     // Catch:{ all -> 0x0138 }
                    r6 = 2013(0x7dd, float:2.821E-42)
                    if (r5 == 0) goto L_0x0088
                    com.umeng.message.proguard.bz r9 = com.umeng.message.proguard.bz.a()     // Catch:{ all -> 0x0138 }
                    boolean r9 = r9.f15552a     // Catch:{ all -> 0x0138 }
                    if (r9 != 0) goto L_0x003c
                    com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r1 = r9     // Catch:{ all -> 0x0138 }
                    r5 = 2014(0x7de, float:2.822E-42)
                    r9.b(r1, r5)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x003c:
                    com.umeng.message.proguard.bz r9 = com.umeng.message.proguard.bz.a()     // Catch:{ all -> 0x0138 }
                    android.app.Activity r9 = r9.b()     // Catch:{ all -> 0x0138 }
                    if (r9 == 0) goto L_0x007c
                    boolean r5 = r9.isFinishing()     // Catch:{ all -> 0x0138 }
                    if (r5 == 0) goto L_0x004d
                    goto L_0x007c
                L_0x004d:
                    com.umeng.message.proguard.dt r5 = com.umeng.message.proguard.dt.a()     // Catch:{ all -> 0x0138 }
                    java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0138 }
                    boolean r5 = r5.a((java.lang.Class<? extends android.app.Activity>) r7)     // Catch:{ all -> 0x0138 }
                    if (r5 == 0) goto L_0x0088
                    com.umeng.message.proguard.cq r1 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r5 = r9     // Catch:{ all -> 0x0138 }
                    r6 = 2015(0x7df, float:2.824E-42)
                    r1.b(r5, r6)     // Catch:{ all -> 0x0138 }
                    java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0138 }
                    java.lang.String r5 = "current activity not allow show ad:"
                    r1[r2] = r5     // Catch:{ all -> 0x0138 }
                    java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0138 }
                    java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x0138 }
                    r1[r4] = r9     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ce.a(r3, r1)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x007c:
                    com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r1 = r9     // Catch:{ all -> 0x0138 }
                    r9.b(r1, r6)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x0088:
                    com.umeng.message.proguard.dq r5 = com.umeng.message.proguard.dq.this     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r7 = r9     // Catch:{ all -> 0x0138 }
                    boolean r5 = r5.a(r7)     // Catch:{ all -> 0x0138 }
                    if (r5 == 0) goto L_0x00cb
                    com.umeng.message.proguard.ck r9 = r9     // Catch:{ Exception -> 0x009b }
                    org.json.JSONObject r9 = r9.f15606b     // Catch:{ Exception -> 0x009b }
                    java.lang.String r5 = "exposed_timeout"
                    r9.put(r5, r4)     // Catch:{ Exception -> 0x009b }
                L_0x009b:
                    com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r5 = r9     // Catch:{ all -> 0x0138 }
                    r6 = 2012(0x7dc, float:2.82E-42)
                    r9.b(r5, r6)     // Catch:{ all -> 0x0138 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
                    java.lang.String r5 = "expose invalid! timeout config:"
                    r9.<init>(r5)     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r5 = r9     // Catch:{ all -> 0x0138 }
                    int r5 = r5.h()     // Catch:{ all -> 0x0138 }
                    r9.append(r5)     // Catch:{ all -> 0x0138 }
                    java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0138 }
                    java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0138 }
                    r5[r2] = r9     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ce.d(r3, r5)     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.cf r5 = r8.f15727a     // Catch:{ all -> 0x0138 }
                    if (r5 == 0) goto L_0x00c8
                    r5.a(r1, r9)     // Catch:{ all -> 0x0138 }
                L_0x00c8:
                    r8.f15839e = r4
                    return
                L_0x00cb:
                    com.umeng.message.proguard.dq r1 = com.umeng.message.proguard.dq.this     // Catch:{ all -> 0x0138 }
                    java.lang.ref.WeakReference<android.app.Activity> r1 = r1.f15732d     // Catch:{ all -> 0x0138 }
                    if (r1 == 0) goto L_0x00d8
                    java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0138 }
                    android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ all -> 0x0138 }
                    goto L_0x00d9
                L_0x00d8:
                    r1 = 0
                L_0x00d9:
                    java.lang.String r5 = "activity has finished skip."
                    if (r9 == 0) goto L_0x0109
                    boolean r1 = r9.isFinishing()     // Catch:{ all -> 0x0138 }
                    if (r1 == 0) goto L_0x00f6
                    java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0138 }
                    r9[r2] = r5     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ce.b(r3, r9)     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r1 = r9     // Catch:{ all -> 0x0138 }
                    r9.b(r1, r6)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x00f6:
                    android.view.Window r1 = r9.getWindow()     // Catch:{ all -> 0x0138 }
                    android.view.View r1 = r1.getDecorView()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.dq$2$1 r5 = new com.umeng.message.proguard.dq$2$1     // Catch:{ all -> 0x0138 }
                    r5.<init>(r9, r8)     // Catch:{ all -> 0x0138 }
                    r1.post(r5)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x0109:
                    if (r1 == 0) goto L_0x0125
                    boolean r9 = r1.isFinishing()     // Catch:{ all -> 0x0138 }
                    if (r9 == 0) goto L_0x0112
                    goto L_0x0125
                L_0x0112:
                    android.view.Window r9 = r1.getWindow()     // Catch:{ all -> 0x0138 }
                    android.view.View r9 = r9.getDecorView()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.dq$2$2 r5 = new com.umeng.message.proguard.dq$2$2     // Catch:{ all -> 0x0138 }
                    r5.<init>(r1, r8)     // Catch:{ all -> 0x0138 }
                    r9.post(r5)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x0125:
                    java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0138 }
                    r9[r2] = r5     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ce.b(r3, r9)     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.cq r9 = com.umeng.message.proguard.cr.a()     // Catch:{ all -> 0x0138 }
                    com.umeng.message.proguard.ck r1 = r9     // Catch:{ all -> 0x0138 }
                    r9.b(r1, r6)     // Catch:{ all -> 0x0138 }
                    r8.f15839e = r4
                    return
                L_0x0138:
                    r9 = move-exception
                    java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x014b }
                    java.lang.String r1 = "show error:"
                    r0[r2] = r1     // Catch:{ all -> 0x014b }
                    java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x014b }
                    r0[r4] = r9     // Catch:{ all -> 0x014b }
                    com.umeng.message.proguard.ce.a(r3, r0)     // Catch:{ all -> 0x014b }
                    r8.f15839e = r4
                    return
                L_0x014b:
                    r9 = move-exception
                    r8.f15839e = r4
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dq.AnonymousClass2.a(android.app.Activity):void");
            }
        };
    }
}
