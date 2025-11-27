package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.ag;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.bo;
import java.util.Calendar;

public class UmengSplashMessageActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15282a = "com.umeng.message.inapp.UmengSplashMessageActivity";

    /* renamed from: s  reason: collision with root package name */
    private static int f15283s = 2000;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static int f15284t = 1000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f15285b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ag f15286c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f15287d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15288e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f15289f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f15290g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15291h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f15292i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a f15293j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public UInAppMessage f15294k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public UInAppHandler f15295l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f15296m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f15297n = false;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f15298o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15299p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public long f15300q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public long f15301r;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public ag.a f15302u = new ag.a() {
        public final void a(Bitmap[] bitmapArr) {
            if (!UmengSplashMessageActivity.this.c()) {
                if (UmengSplashMessageActivity.this.f15292i != null) {
                    UmengSplashMessageActivity.this.f15292i.a();
                    a unused = UmengSplashMessageActivity.this.f15292i = null;
                }
                try {
                    if (bitmapArr.length == 1) {
                        UmengSplashMessageActivity.this.f15287d.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                boolean unused = UmengSplashMessageActivity.this.f15296m = true;
                                if (!TextUtils.equals("none", UmengSplashMessageActivity.this.f15294k.action_type)) {
                                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f15300q);
                                    aj.a((Context) UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, UmengSplashMessageActivity.this.f15294k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.f15301r, 0);
                                    UmengSplashMessageActivity.this.d();
                                    UmengSplashMessageActivity.this.f15295l.handleInAppMessage(UmengSplashMessageActivity.this.f15285b, UmengSplashMessageActivity.this.f15294k, 16);
                                    UmengSplashMessageActivity.this.finish();
                                }
                            }
                        });
                        UmengSplashMessageActivity.this.f15288e.setVisibility(8);
                        UmengSplashMessageActivity.this.f15287d.setImageBitmap(bitmapArr[0]);
                        UmengSplashMessageActivity.a((View) UmengSplashMessageActivity.this.f15287d);
                    }
                    if (bitmapArr.length == 2) {
                        UmengSplashMessageActivity.this.f15287d.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                boolean unused = UmengSplashMessageActivity.this.f15297n = true;
                                if (!TextUtils.equals("none", UmengSplashMessageActivity.this.f15294k.action_type)) {
                                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f15300q);
                                    aj.a((Context) UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, UmengSplashMessageActivity.this.f15294k.msg_type, 1, 0, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15298o), 0, (int) UmengSplashMessageActivity.this.f15301r, 0);
                                    UmengSplashMessageActivity.this.d();
                                    UmengSplashMessageActivity.this.f15295l.handleInAppMessage(UmengSplashMessageActivity.this.f15285b, UmengSplashMessageActivity.this.f15294k, 16);
                                    UmengSplashMessageActivity.this.finish();
                                }
                            }
                        });
                        UmengSplashMessageActivity.this.f15288e.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                boolean unused = UmengSplashMessageActivity.this.f15298o = true;
                                if (!TextUtils.equals("none", UmengSplashMessageActivity.this.f15294k.bottom_action_type)) {
                                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f15300q);
                                    aj.a((Context) UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, UmengSplashMessageActivity.this.f15294k.msg_type, 1, 0, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15297n), 1, 0, (int) UmengSplashMessageActivity.this.f15301r, 0);
                                    UmengSplashMessageActivity.this.d();
                                    UmengSplashMessageActivity.this.f15295l.handleInAppMessage(UmengSplashMessageActivity.this.f15285b, UmengSplashMessageActivity.this.f15294k, 17);
                                    UmengSplashMessageActivity.this.finish();
                                }
                            }
                        });
                        UmengSplashMessageActivity.this.f15287d.setImageBitmap(bitmapArr[0]);
                        UmengSplashMessageActivity.this.f15288e.setImageBitmap(bitmapArr[1]);
                        UmengSplashMessageActivity.a((View) UmengSplashMessageActivity.this.f15287d);
                        UmengSplashMessageActivity.a((View) UmengSplashMessageActivity.this.f15288e);
                    }
                    long unused2 = UmengSplashMessageActivity.this.f15300q = SystemClock.elapsedRealtime();
                    if (!UmengSplashMessageActivity.this.f15294k.display_button) {
                        UmengSplashMessageActivity.this.f15289f.setVisibility(8);
                    } else {
                        UmengSplashMessageActivity.this.f15289f.setVisibility(0);
                        UmengSplashMessageActivity.this.f15289f.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f15300q);
                                aj.a((Context) UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, UmengSplashMessageActivity.this.f15294k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15296m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15297n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15298o), 1, (int) UmengSplashMessageActivity.this.f15301r, 0);
                                UmengSplashMessageActivity.this.d();
                                UmengSplashMessageActivity.this.finish();
                            }
                        });
                    }
                    InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k);
                    InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, 1);
                    InAppMessageManager instance = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f15285b);
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    instance.b("KEY_LAST_SHOW_SPLASH_TS", sb.toString());
                    boolean unused3 = UmengSplashMessageActivity.this.f15290g = false;
                    UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                    a unused4 = umengSplashMessageActivity.f15293j = new a((long) (umengSplashMessageActivity.f15294k.display_time * 1000), (long) UmengSplashMessageActivity.f15284t);
                    UmengSplashMessageActivity.this.f15293j.b();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private final ae f15303v = new ae() {
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.umeng.message.entity.UInAppMessage r6) {
            /*
                r5 = this;
                com.umeng.message.inapp.UmengSplashMessageActivity r0 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r0 = r0.f15285b
                com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
                java.lang.String r0 = r0.a()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L_0x0023
                com.umeng.message.entity.UInAppMessage r1 = new com.umeng.message.entity.UInAppMessage     // Catch:{ JSONException -> 0x001f }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001f }
                r2.<init>(r0)     // Catch:{ JSONException -> 0x001f }
                r1.<init>(r2)     // Catch:{ JSONException -> 0x001f }
                goto L_0x0024
            L_0x001f:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0023:
                r1 = 0
            L_0x0024:
                if (r6 == 0) goto L_0x0056
                if (r1 == 0) goto L_0x0050
                java.lang.String r0 = r6.msg_id
                java.lang.String r2 = r1.msg_id
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0050
                java.io.File r0 = new java.io.File
                com.umeng.message.inapp.UmengSplashMessageActivity r2 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r2 = r2.f15285b
                java.lang.String r1 = r1.msg_id
                java.lang.String r1 = com.umeng.message.proguard.f.a((android.content.Context) r2, (java.lang.String) r1)
                r0.<init>(r1)
                com.umeng.message.inapp.UmengSplashMessageActivity r1 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r1 = r1.f15285b
                com.umeng.message.inapp.InAppMessageManager r1 = com.umeng.message.inapp.InAppMessageManager.getInstance(r1)
                r1.a((java.io.File) r0)
            L_0x0050:
                com.umeng.message.inapp.UmengSplashMessageActivity r0 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage unused = r0.f15294k = r6
                goto L_0x005d
            L_0x0056:
                if (r1 == 0) goto L_0x015c
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage unused = r6.f15294k = r1
            L_0x005d:
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r6 = r6.f15294k
                int r6 = r6.show_type
                r0 = 1
                if (r6 != r0) goto L_0x0086
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                boolean r6 = com.umeng.message.inapp.UmengSplashMessageActivity.u(r6)
                if (r6 != 0) goto L_0x0086
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r6 = r6.f15285b
                com.umeng.message.inapp.InAppMessageManager r6 = com.umeng.message.inapp.InAppMessageManager.getInstance(r6)
                com.umeng.message.inapp.UmengSplashMessageActivity r1 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r1 = r1.f15294k
                java.lang.String r1 = r1.msg_id
                r2 = 0
                r6.a((java.lang.String) r1, (int) r2)
            L_0x0086:
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r6 = r6.f15285b
                com.umeng.message.inapp.InAppMessageManager.getInstance(r6)
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r6 = r6.f15294k
                boolean r6 = com.umeng.message.inapp.InAppMessageManager.b((com.umeng.message.entity.UInAppMessage) r6)
                if (r6 == 0) goto L_0x015c
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r6 = r6.f15285b
                com.umeng.message.inapp.InAppMessageManager r6 = com.umeng.message.inapp.InAppMessageManager.getInstance(r6)
                com.umeng.message.inapp.UmengSplashMessageActivity r1 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r1 = r1.f15294k
                boolean r6 = r6.c((com.umeng.message.entity.UInAppMessage) r1)
                if (r6 != 0) goto L_0x00b3
                goto L_0x015c
            L_0x00b3:
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r6 = r6.f15294k
                int r6 = r6.msg_type
                r1 = 2
                if (r6 != 0) goto L_0x0104
                java.lang.String r6 = com.umeng.message.inapp.UmengSplashMessageActivity.f15282a
                java.lang.String r2 = "SPLASH_A"
                java.lang.String[] r2 = new java.lang.String[]{r2}
                com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r6, (int) r1, (java.lang.String[]) r2)
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r2 = new com.umeng.message.proguard.ag
                com.umeng.message.inapp.UmengSplashMessageActivity r3 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r3 = r3.f15285b
                com.umeng.message.inapp.UmengSplashMessageActivity r4 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r4 = r4.f15294k
                r2.<init>(r3, r4)
                com.umeng.message.proguard.ag unused = r6.f15286c = r2
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r6 = r6.f15286c
                com.umeng.message.inapp.UmengSplashMessageActivity r2 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag$a r2 = r2.f15302u
                r6.f15334a = r2
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r6 = r6.f15286c
                com.umeng.message.inapp.UmengSplashMessageActivity r2 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r2 = r2.f15294k
                java.lang.String r2 = r2.image_url
                java.lang.String[] r2 = new java.lang.String[]{r2}
                r6.execute(r2)
            L_0x0104:
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r6 = r6.f15294k
                int r6 = r6.msg_type
                if (r6 != r0) goto L_0x015c
                java.lang.String r6 = com.umeng.message.inapp.UmengSplashMessageActivity.f15282a
                java.lang.String r0 = "SPLASH_B"
                java.lang.String[] r0 = new java.lang.String[]{r0}
                com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r6, (int) r1, (java.lang.String[]) r0)
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r0 = new com.umeng.message.proguard.ag
                com.umeng.message.inapp.UmengSplashMessageActivity r1 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                android.app.Activity r1 = r1.f15285b
                com.umeng.message.inapp.UmengSplashMessageActivity r2 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r2 = r2.f15294k
                r0.<init>(r1, r2)
                com.umeng.message.proguard.ag unused = r6.f15286c = r0
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r6 = r6.f15286c
                com.umeng.message.inapp.UmengSplashMessageActivity r0 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag$a r0 = r0.f15302u
                r6.f15334a = r0
                com.umeng.message.inapp.UmengSplashMessageActivity r6 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.proguard.ag r6 = r6.f15286c
                com.umeng.message.inapp.UmengSplashMessageActivity r0 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r0 = r0.f15294k
                java.lang.String r0 = r0.image_url
                com.umeng.message.inapp.UmengSplashMessageActivity r1 = com.umeng.message.inapp.UmengSplashMessageActivity.this
                com.umeng.message.entity.UInAppMessage r1 = r1.f15294k
                java.lang.String r1 = r1.bottom_image_url
                java.lang.String[] r0 = new java.lang.String[]{r0, r1}
                r6.execute(r0)
            L_0x015c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.UmengSplashMessageActivity.AnonymousClass2.a(com.umeng.message.entity.UInAppMessage):void");
        }

        public final void b(UInAppMessage uInAppMessage) {
        }
    };

    public class a extends ai {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        public final void a(long j10) {
            if (!UmengSplashMessageActivity.this.f15290g) {
                UmengSplashMessageActivity.this.f15289f.setVisibility(0);
                TextView q10 = UmengSplashMessageActivity.this.f15289f;
                StringBuilder sb = new StringBuilder();
                double d10 = (double) j10;
                Double.isNaN(d10);
                double a10 = (double) UmengSplashMessageActivity.f15284t;
                Double.isNaN(a10);
                sb.append((int) Math.ceil((d10 * 1.0d) / a10));
                sb.append(" ");
                sb.append(UmengSplashMessageActivity.this.f15294k.display_name);
                q10.setText(sb.toString());
            }
        }

        public final void e() {
            if (!UmengSplashMessageActivity.this.c() || !UmengSplashMessageActivity.this.f15290g) {
                if (!UmengSplashMessageActivity.this.f15290g) {
                    aj.a((Context) UmengSplashMessageActivity.this.f15285b).a(UmengSplashMessageActivity.this.f15294k.msg_id, UmengSplashMessageActivity.this.f15294k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15296m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15297n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f15298o), 0, UmengSplashMessageActivity.this.f15294k.display_time * 1000, 0);
                }
                UmengSplashMessageActivity.this.d();
                UmengSplashMessageActivity.this.finish();
            }
        }
    }

    public static /* synthetic */ int a(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static /* synthetic */ boolean u(UmengSplashMessageActivity umengSplashMessageActivity) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(Long.parseLong(InAppMessageManager.getInstance(umengSplashMessageActivity.f15285b).a("KEY_LAST_SHOW_SPLASH_TS", "0")));
        Calendar instance2 = Calendar.getInstance();
        if (instance.get(6) == instance2.get(6) && instance.get(1) == instance2.get(1)) {
            return true;
        }
        return false;
    }

    public final void onBackPressed() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15285b = this;
        if ((getIntent().getFlags() & AutoStrategy.BITRATE_LOW) > 0) {
            finish();
        } else if (!onCustomPretreatment()) {
            setRequestedOrientation(1);
            FrameLayout frameLayout = new FrameLayout(this.f15285b);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(this.f15285b);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
            ImageView imageView = new ImageView(this.f15285b);
            this.f15287d = imageView;
            imageView.setLayoutParams(layoutParams);
            this.f15287d.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(this.f15287d);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
            ImageView imageView2 = new ImageView(this.f15285b);
            this.f15288e = imageView2;
            imageView2.setLayoutParams(layoutParams2);
            this.f15288e.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(this.f15288e);
            frameLayout.addView(linearLayout);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 5;
            layoutParams3.rightMargin = bo.a(30.0f);
            layoutParams3.topMargin = bo.a(20.0f);
            TextView textView = new TextView(this.f15285b);
            this.f15289f = textView;
            textView.setLayoutParams(layoutParams3);
            int a10 = bo.a(6.0f);
            int i10 = a10 / 3;
            this.f15289f.setPadding(a10, i10, a10, i10);
            this.f15289f.setTextSize(14.0f);
            this.f15289f.setBackgroundColor(Color.parseColor("#80000000"));
            this.f15289f.setTextColor(-1);
            this.f15289f.setVisibility(8);
            frameLayout.addView(this.f15289f);
            setContentView(frameLayout);
            if (InAppMessageManager.f15232a) {
                aj.a((Context) this).a(this.f15303v);
            } else if (System.currentTimeMillis() - Long.parseLong(InAppMessageManager.getInstance(this.f15285b).a("KEY_SPLASH_TS", "0")) > ((long) InAppMessageManager.f15233d)) {
                aj.a((Context) this).a(this.f15303v);
            } else {
                this.f15303v.a((UInAppMessage) null);
            }
            this.f15295l = InAppMessageManager.getInstance(this.f15285b).getInAppHandler();
            a aVar = new a((long) f15283s, (long) f15284t);
            this.f15292i = aVar;
            aVar.b();
        }
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    public final void onDestroy() {
        a aVar = this.f15292i;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f15293j;
        if (aVar2 != null) {
            aVar2.a();
        }
        ag agVar = this.f15286c;
        if (agVar != null) {
            agVar.f15334a = null;
        }
        this.f15299p = false;
        this.f15296m = false;
        this.f15297n = false;
        this.f15298o = false;
        super.onDestroy();
    }

    public final void onPause() {
        super.onPause();
        a aVar = this.f15292i;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f15293j != null) {
            this.f15301r += SystemClock.elapsedRealtime() - this.f15300q;
            this.f15293j.c();
        }
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f15292i;
        if (aVar != null) {
            aVar.d();
        }
        if (this.f15293j != null) {
            this.f15300q = SystemClock.elapsedRealtime();
            this.f15293j.d();
        }
    }

    public final void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: private */
    public synchronized boolean c() {
        boolean z10;
        z10 = this.f15299p;
        this.f15299p = true;
        return z10;
    }

    /* access modifiers changed from: private */
    public synchronized void d() {
        if (this.f15291h) {
            this.f15291h = false;
            Intent intent = new Intent();
            intent.setClassName(this.f15285b, InAppMessageManager.getInstance(this).f15237c);
            intent.setFlags(536870912);
            try {
                this.f15285b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ long a(UmengSplashMessageActivity umengSplashMessageActivity, long j10) {
        long j11 = umengSplashMessageActivity.f15301r + j10;
        umengSplashMessageActivity.f15301r = j11;
        return j11;
    }

    public static /* synthetic */ void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500);
        view.startAnimation(alphaAnimation);
    }

    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
