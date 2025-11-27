package com.umeng.message.proguard;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.ct;
import com.umeng.message.push.R;

public final class co extends cn {

    /* renamed from: c  reason: collision with root package name */
    final cv f15631c = new cv();

    /* renamed from: d  reason: collision with root package name */
    ej f15632d;

    /* renamed from: e  reason: collision with root package name */
    final cg f15633e = new cg();

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f15634f;

    /* renamed from: g  reason: collision with root package name */
    private bx.f f15635g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f15636h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15637i = true;

    public class a implements bx.f {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15644b;

        /* renamed from: c  reason: collision with root package name */
        private final bx.f f15645c;

        public a(boolean z10, bx.f fVar) {
            this.f15645c = fVar;
            this.f15644b = z10;
        }
    }

    public co(Context context, cl clVar) {
        super(context, clVar);
        this.f15634f = new FrameLayout(context);
    }

    public final View a() {
        return this.f15634f;
    }

    public final void b() {
        if (this.f15635g == null) {
            this.f15635g = new a(a(this.f15630b.f15625a), this.f15631c);
        }
        this.f15631c.f15704l = new bx.e() {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a() {
                /*
                    r5 = this;
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cv r1 = r0.f15631c
                    com.umeng.message.proguard.cl r0 = r0.f15630b
                    com.umeng.message.proguard.ck r0 = r0.f15625a
                    boolean r0 = com.umeng.message.proguard.co.a((com.umeng.message.proguard.ck) r0)
                    r2 = 0
                    r3 = 1
                    if (r0 != 0) goto L_0x0028
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cl r0 = r0.f15630b
                    com.umeng.message.proguard.ck r0 = r0.f15625a
                    org.json.JSONObject r0 = r0.f15606b
                    java.lang.String r4 = "video_loop"
                    int r0 = r0.optInt(r4, r3)
                    if (r0 != r3) goto L_0x0022
                    r0 = 1
                    goto L_0x0023
                L_0x0022:
                    r0 = 0
                L_0x0023:
                    if (r0 == 0) goto L_0x0026
                    goto L_0x0028
                L_0x0026:
                    r0 = 0
                    goto L_0x0029
                L_0x0028:
                    r0 = 1
                L_0x0029:
                    r1.f15697e = r0
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cl r0 = r0.f15630b
                    com.umeng.message.proguard.ck r0 = r0.f15625a
                    org.json.JSONObject r0 = r0.f15606b
                    java.lang.String r1 = "video_sound"
                    int r0 = r0.optInt(r1, r2)
                    if (r0 != 0) goto L_0x003c
                    r2 = 1
                L_0x003c:
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cv r0 = r0.f15631c
                    r0.b((boolean) r2)
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    r0.a((boolean) r2)
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cg r0 = r0.f15633e
                    r0.a()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.co.AnonymousClass1.a():void");
            }

            public final void b() {
                co.this.f15633e.b();
            }

            public final void c() {
                co.this.f15633e.c();
            }

            public final void d() {
                co.this.f15633e.d();
            }

            public final void a(String str) {
                co.this.f15633e.a(str);
            }
        };
        ct.a(true, this.f15630b.f15625a.l(), new ct.a() {
            public final void a() {
            }

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x008a */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC, Splitter:B:26:0x0084] */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x008e A[Catch:{ all -> 0x0098 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(java.lang.String r13) {
                /*
                    r12 = this;
                    java.lang.String r0 = "VideoPlayer"
                    com.umeng.message.proguard.co r1 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cv r1 = r1.f15631c
                    android.net.Uri r13 = android.net.Uri.parse(r13)
                    r1.f15693a = r13
                    int r2 = r1.f15699g
                    if (r2 > 0) goto L_0x00d0
                    r2 = 0
                    r3 = 0
                    r4 = 2
                    r5 = 1
                    android.media.MediaMetadataRetriever r6 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0040 }
                    r6.<init>()     // Catch:{ Exception -> 0x0040 }
                    java.lang.String r7 = r13.getPath()     // Catch:{ Exception -> 0x0040 }
                    r6.setDataSource(r7)     // Catch:{ Exception -> 0x0040 }
                    r7 = 18
                    java.lang.String r7 = r6.extractMetadata(r7)     // Catch:{ Exception -> 0x0040 }
                    r8 = 19
                    java.lang.String r8 = r6.extractMetadata(r8)     // Catch:{ Exception -> 0x003c }
                    r9 = 9
                    java.lang.String r2 = r6.extractMetadata(r9)     // Catch:{ Exception -> 0x0036 }
                    r6.release()     // Catch:{ Exception -> 0x0036 }
                    goto L_0x0055
                L_0x0036:
                    r6 = move-exception
                    r11 = r6
                    r6 = r2
                    r2 = r7
                    r7 = r11
                    goto L_0x0044
                L_0x003c:
                    r6 = move-exception
                    r8 = r2
                    r2 = r7
                    goto L_0x0042
                L_0x0040:
                    r6 = move-exception
                    r8 = r2
                L_0x0042:
                    r7 = r6
                    r6 = r8
                L_0x0044:
                    java.lang.Object[] r9 = new java.lang.Object[r4]
                    java.lang.String r10 = "prepare mmr error:"
                    r9[r3] = r10
                    java.lang.String r7 = r7.getMessage()
                    r9[r5] = r7
                    com.umeng.message.proguard.ce.d(r0, r9)
                    r7 = r2
                    r2 = r6
                L_0x0055:
                    r6 = 6
                    java.lang.Object[] r6 = new java.lang.Object[r6]
                    java.lang.String r9 = "prepare w:"
                    r6[r3] = r9
                    r6[r5] = r7
                    java.lang.String r9 = " h:"
                    r6[r4] = r9
                    r9 = 3
                    r6[r9] = r8
                    r9 = 4
                    java.lang.String r10 = " duration:"
                    r6[r9] = r10
                    r9 = 5
                    r6[r9] = r2
                    com.umeng.message.proguard.ce.a(r0, r6)
                    if (r7 == 0) goto L_0x0082
                    if (r8 == 0) goto L_0x0082
                    int r6 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0081 }
                    r1.f15702j = r6     // Catch:{ Exception -> 0x0081 }
                    int r6 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0081 }
                    r1.f15703k = r6     // Catch:{ Exception -> 0x0081 }
                    goto L_0x0082
                L_0x0081:
                L_0x0082:
                    if (r2 == 0) goto L_0x008a
                    int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x008a }
                    r1.f15699g = r2     // Catch:{ Exception -> 0x008a }
                L_0x008a:
                    int r2 = r1.f15699g     // Catch:{ all -> 0x0098 }
                    if (r2 <= 0) goto L_0x00a8
                    r1.f15698f = r5     // Catch:{ all -> 0x0098 }
                    com.umeng.message.proguard.bx$e r2 = r1.f15704l     // Catch:{ all -> 0x0098 }
                    if (r2 == 0) goto L_0x0097
                    r2.a()     // Catch:{ all -> 0x0098 }
                L_0x0097:
                    return
                L_0x0098:
                    r2 = move-exception
                    java.lang.Object[] r6 = new java.lang.Object[r4]
                    java.lang.String r7 = "prepare mmr ready error:"
                    r6[r3] = r7
                    java.lang.String r2 = r2.getMessage()
                    r6[r5] = r2
                    com.umeng.message.proguard.ce.d(r0, r6)
                L_0x00a8:
                    android.media.MediaPlayer r2 = new android.media.MediaPlayer     // Catch:{ all -> 0x00c0 }
                    r2.<init>()     // Catch:{ all -> 0x00c0 }
                    java.lang.String r13 = r13.getPath()     // Catch:{ all -> 0x00c0 }
                    r2.setDataSource(r13)     // Catch:{ all -> 0x00c0 }
                    com.umeng.message.proguard.cv$1 r13 = new com.umeng.message.proguard.cv$1     // Catch:{ all -> 0x00c0 }
                    r13.<init>()     // Catch:{ all -> 0x00c0 }
                    r2.setOnPreparedListener(r13)     // Catch:{ all -> 0x00c0 }
                    r2.prepare()     // Catch:{ all -> 0x00c0 }
                    return
                L_0x00c0:
                    r13 = move-exception
                    java.lang.Object[] r1 = new java.lang.Object[r4]
                    java.lang.String r2 = "prepare player error:"
                    r1[r3] = r2
                    java.lang.String r13 = r13.getMessage()
                    r1[r5] = r13
                    com.umeng.message.proguard.ce.d(r0, r1)
                L_0x00d0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.co.AnonymousClass2.a(java.lang.String):void");
            }
        });
    }

    public final void c() {
        boolean z10;
        boolean z11;
        float f10;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean a10 = a(this.f15630b.f15625a);
        if (this.f15632d == null) {
            ej ejVar = new ej(this.f15629a);
            this.f15632d = ejVar;
            ejVar.setVideoPlayer(this.f15631c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f15632d.setLayoutParams(layoutParams);
        }
        ViewParent parent = this.f15632d.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f15632d);
        }
        this.f15634f.addView(this.f15632d);
        if (this.f15637i && a10) {
            if (this.f15636h == null) {
                this.f15636h = new ImageView(this.f15629a);
                int a11 = ed.a(4.0f);
                int i14 = a11 * 10;
                int i15 = a11 * 3;
                int i16 = a11 * 2;
                this.f15636h.setPadding(i15, i15, i16, i16);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i14, i14);
                layoutParams2.gravity = BadgeDrawable.TOP_START;
                this.f15636h.setLayoutParams(layoutParams2);
                this.f15636h.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        cv cvVar = co.this.f15631c;
                        cvVar.b(!cvVar.f15696d);
                        co coVar = co.this;
                        coVar.a(coVar.f15631c.f15696d);
                    }
                });
            }
            a(this.f15631c.f15696d);
            ViewParent parent2 = this.f15636h.getParent();
            if (parent2 != null) {
                ((ViewGroup) parent2).removeView(this.f15636h);
            }
            this.f15634f.addView(this.f15636h);
        }
        bx.c a12 = bt.a(this.f15630b.f15625a);
        bx.c cVar = bx.c.INTERSTITIAL;
        boolean z12 = true;
        if (a12 == cVar) {
            DisplayMetrics displayMetrics = this.f15629a.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                z11 = true;
            } else {
                z11 = false;
            }
            cv cvVar = this.f15631c;
            int i17 = cvVar.f15702j;
            int i18 = cvVar.f15703k;
            if (i17 <= 0 || i18 <= 0) {
                f10 = 0.5625f;
            } else {
                f10 = (((float) i17) * 1.0f) / ((float) i18);
            }
            int a13 = ed.a(72.0f);
            int a14 = ed.a(144.0f);
            if (z11) {
                i11 = displayMetrics.widthPixels - a13;
                i10 = (int) (((float) i11) / f10);
                int i19 = displayMetrics.heightPixels;
                if (i10 > i19 - a14) {
                    i10 = i19 - a14;
                    i11 = (int) (((float) i10) * f10);
                }
                i12 = i11;
            } else {
                int i20 = displayMetrics.heightPixels - a14;
                int i21 = (int) (((float) i20) * f10);
                int i22 = displayMetrics.widthPixels;
                if (i21 > i22 - a13) {
                    i12 = i22 - a13;
                    i13 = i20;
                } else if (i21 > i20) {
                    i13 = i20;
                    i12 = i21;
                } else {
                    i12 = i20;
                    i10 = i12;
                    i11 = i21;
                }
                i11 = i12;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f15632d.getLayoutParams();
            layoutParams3.width = i11;
            layoutParams3.height = i10;
            this.f15632d.setLayoutParams(layoutParams3);
            this.f15634f.setLayoutParams(new FrameLayout.LayoutParams(i12, i10));
        }
        if (a12 != cVar) {
            if (this.f15630b.f15625a.f15606b.optInt("auto_play", 1) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                z12 = false;
            }
        }
        if (z12) {
            ct.a(false, this.f15630b.f15625a.l(), new ct.a() {
                public final void a() {
                }

                public final void a(String str) {
                    ej ejVar = co.this.f15632d;
                    if (ejVar != null) {
                        ejVar.post(new Runnable() {
                            public final void run() {
                                cv cvVar;
                                ej ejVar = co.this.f15632d;
                                if (ejVar != null && (cvVar = ejVar.f15923a) != null) {
                                    ejVar.f15924b = cvVar.b();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public final void d() {
        ck ckVar = this.f15630b.f15625a;
        int e10 = this.f15631c.e();
        ckVar.f15610f = e10;
        this.f15631c.a(e10);
        cv cvVar = this.f15631c;
        cr.a().a(true, ckVar, cvVar.f15700h, e10, cvVar.f15699g, cvVar.f15701i);
    }

    public final void e() {
        this.f15631c.b(true);
        a(true);
    }

    public final void f() {
        ck ckVar = this.f15630b.f15625a;
        int e10 = this.f15631c.e();
        this.f15631c.a(e10);
        cv cvVar = this.f15631c;
        boolean z10 = cvVar.f15700h;
        int i10 = cvVar.f15699g;
        long j10 = cvVar.f15701i;
        ckVar.f15610f = e10;
        cr.a().a(false, ckVar, z10, e10, i10, j10);
    }

    public static boolean a(ck ckVar) {
        bx.c a10 = bt.a(ckVar);
        if (a10 != null && a10 == bx.c.INTERSTITIAL) {
            return true;
        }
        return false;
    }

    public final void a(boolean z10) {
        ImageView imageView = this.f15636h;
        if (imageView != null) {
            imageView.setImageResource(z10 ? R.drawable.umeng_union_sound_off : R.drawable.umeng_union_sound_on);
        }
    }
}
