package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.sdk.source.browser.a.b;
import com.hpplay.sdk.source.browser.b;
import com.hpplay.sdk.source.browser.c;
import com.hpplay.sdk.source.browser.d;
import com.mobile.brasiltv.view.RoundedDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends RelativeLayout {
    private static final int A = 60000;

    /* renamed from: b  reason: collision with root package name */
    private static final String f11693b = "BrowserDeviceView";

    /* renamed from: k  reason: collision with root package name */
    private static final long f11694k = 3000;
    private Runnable B;
    private b C;
    private final AdapterView.OnItemClickListener D;

    /* renamed from: a  reason: collision with root package name */
    public HeaderView f11695a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f11696c;

    /* renamed from: d  reason: collision with root package name */
    private ListView f11697d;

    /* renamed from: e  reason: collision with root package name */
    private FooterView f11698e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f11699f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f11700g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public c f11701h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public DeviceAdapter f11702i = null;

    /* renamed from: j  reason: collision with root package name */
    private long f11703j = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11704l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11705m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11706n;

    /* renamed from: o  reason: collision with root package name */
    private NotFoundView f11707o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public NetWorkView f11708p;

    /* renamed from: q  reason: collision with root package name */
    private FailView f11709q;

    /* renamed from: r  reason: collision with root package name */
    private String f11710r;

    /* renamed from: s  reason: collision with root package name */
    private String f11711s;

    /* renamed from: t  reason: collision with root package name */
    private String f11712t;

    /* renamed from: u  reason: collision with root package name */
    private String f11713u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public List<com.hpplay.sdk.source.browser.a.a> f11714v;

    /* renamed from: w  reason: collision with root package name */
    private AnimationDrawable f11715w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f11716x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public com.hpplay.sdk.source.browser.a.a f11717y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public Handler f11718z;

    public a(Context context, String str) {
        super(context);
        boolean z10 = false;
        this.f11705m = false;
        this.f11706n = false;
        this.f11710r = null;
        this.f11711s = null;
        this.f11712t = null;
        this.f11714v = new ArrayList();
        this.f11716x = -1;
        this.f11717y = null;
        this.f11718z = new Handler(Looper.getMainLooper());
        this.B = new Runnable() {
            public void run() {
                if (a.this.f11702i != null) {
                    a.this.h();
                }
            }
        };
        this.C = new b() {
            public void a(String str) {
                a.this.c(str);
            }
        };
        this.D = new AdapterView.OnItemClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
            /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x0058  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "onItemClick position:"
                    r4.append(r5)
                    r4.append(r3)
                    java.lang.String r5 = ",adapterView:"
                    r4.append(r5)
                    r4.append(r1)
                    java.lang.String r1 = ", view:"
                    r4.append(r1)
                    r4.append(r2)
                    java.lang.String r1 = r4.toString()
                    java.lang.String r2 = "BrowserDeviceView"
                    com.hpplay.common.log.LeLog.i(r2, r1)
                    com.hpplay.sdk.source.browser.view.a r1 = com.hpplay.sdk.source.browser.view.a.this
                    int unused = r1.f11716x = r3
                    com.hpplay.sdk.source.browser.view.a r1 = com.hpplay.sdk.source.browser.view.a.this
                    java.util.List r1 = r1.f11714v
                    if (r1 == 0) goto L_0x004a
                    com.hpplay.sdk.source.browser.view.a r1 = com.hpplay.sdk.source.browser.view.a.this     // Catch:{ Exception -> 0x0046 }
                    java.util.List r1 = r1.f11714v     // Catch:{ Exception -> 0x0046 }
                    com.hpplay.sdk.source.browser.view.a r3 = com.hpplay.sdk.source.browser.view.a.this     // Catch:{ Exception -> 0x0046 }
                    int r3 = r3.f11716x     // Catch:{ Exception -> 0x0046 }
                    java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0046 }
                    com.hpplay.sdk.source.browser.a.a r1 = (com.hpplay.sdk.source.browser.a.a) r1     // Catch:{ Exception -> 0x0046 }
                    goto L_0x004b
                L_0x0046:
                    r1 = move-exception
                    com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r1)
                L_0x004a:
                    r1 = 0
                L_0x004b:
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.a.a unused = r2.f11717y = r1
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.view.DeviceAdapter r2 = r2.f11702i
                    if (r2 == 0) goto L_0x006a
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.view.DeviceAdapter r2 = r2.f11702i
                    r2.a(r1)
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.view.DeviceAdapter r2 = r2.f11702i
                    r2.notifyDataSetChanged()
                L_0x006a:
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.c r2 = r2.f11701h
                    if (r2 == 0) goto L_0x0081
                    com.hpplay.sdk.source.browser.view.a r2 = com.hpplay.sdk.source.browser.view.a.this
                    com.hpplay.sdk.source.browser.c r2 = r2.f11701h
                    com.hpplay.sdk.source.browser.view.a r3 = com.hpplay.sdk.source.browser.view.a.this
                    int r3 = r3.f11716x
                    r2.onSelect(r3, r1)
                L_0x0081:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.browser.view.a.AnonymousClass5.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        };
        LeLog.i(f11693b, "BrowserDeviceView,bannerData " + str);
        this.f11696c = context;
        this.f11713u = str;
        com.hpplay.sdk.source.browser.b.b.d(context);
        this.f11704l = context.getResources().getConfiguration().orientation == 2 ? true : z10;
        setClickable(true);
        b();
        i();
    }

    private List<b.a> getBannerData() {
        com.hpplay.sdk.source.browser.a.b bVar;
        List<b.a> list;
        if (TextUtils.isEmpty(this.f11713u)) {
            LeLog.w(f11693b, "getBannerData,data is invalid");
            return null;
        }
        LeLog.w(f11693b, "getBannerData,mBannerData:" + this.f11713u);
        try {
            bVar = com.hpplay.sdk.source.browser.a.b.a(this.f11713u);
        } catch (Exception e10) {
            LeLog.w(f11693b, (Throwable) e10);
            bVar = null;
        }
        if (bVar != null && (list = bVar.f11598b) != null && list.size() > 0) {
            return bVar.f11598b;
        }
        LeLog.w(f11693b, "getBannerData,data is null");
        return null;
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.hpplay.sdk.source.browser.b.b.d(this.f11696c);
        if (configuration.orientation == 2) {
            this.f11704l = true;
        } else {
            this.f11704l = false;
        }
        m();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void setBusinessCallback(c cVar) {
        this.f11701h = cVar;
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        LeLog.i(f11693b, "initView");
        setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f11699f = new ImageView(this.f11696c);
        if (this.f11704l) {
            layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 48.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 48.0d));
            layoutParams.setMargins(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 24.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 28.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 24.0d));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 48.0d));
            layoutParams.setMargins(com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 28.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 24.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 28.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 24.0d));
        }
        layoutParams.addRule(9);
        this.f11699f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f();
            }
        });
        addView(this.f11699f, layoutParams);
        Glide.with(this.f11696c).load(b.f11740e).into(this.f11699f);
        this.f11700g = new ImageView(this.f11696c);
        if (this.f11704l) {
            layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 48.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 48.0d));
            layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 21.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 19.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 21.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 21.0d));
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 48.0d));
            layoutParams2.setMargins(com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 21.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 19.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 21.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 21.0d));
        }
        layoutParams2.addRule(11);
        addView(this.f11700g, layoutParams2);
        this.f11700g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.i();
            }
        });
        Glide.with(this.f11696c).load(b.f11744i).into(this.f11700g);
        if (this.f11695a == null) {
            this.f11695a = new HeaderView(this.f11696c);
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        int a10 = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 32.0d);
        layoutParams4.rightMargin = a10;
        layoutParams4.leftMargin = a10;
        layoutParams4.topMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 108.0d);
        if (this.f11704l) {
            layoutParams4.width = com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 986.0d);
            layoutParams4.height = -2;
            if (!b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                layoutParams4.addRule(14);
            }
        }
        this.f11695a.setLayoutParams(layoutParams4);
        this.f11695a.setId(com.hpplay.sdk.source.browser.b.c.a());
        addView(this.f11695a);
        FooterView footerView = new FooterView(this.f11696c);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 70.0d));
        layoutParams5.addRule(12);
        if (this.f11704l) {
            layoutParams5.bottomMargin = com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 22.0d);
            if (!b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                layoutParams5.addRule(14);
            }
        } else {
            layoutParams5.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 320.0d);
        }
        addView(footerView, layoutParams5);
        this.f11698e = footerView;
        footerView.setCallback(this.C);
        ListView listView = new ListView(this.f11696c);
        this.f11697d = listView;
        listView.setId(com.hpplay.sdk.source.browser.b.c.a());
        this.f11697d.setBackgroundDrawable(getDefaultBackgroundDrawable());
        DeviceAdapter deviceAdapter = new DeviceAdapter(this.f11696c, this.f11714v);
        this.f11702i = deviceAdapter;
        this.f11697d.setAdapter(deviceAdapter);
        this.f11697d.setOnItemClickListener(this.D);
        if (this.f11704l) {
            layoutParams3 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 986.0d), -2);
            layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 75.0d);
            if (!b("SDK_UI_LIST_BANNER_HORIZONTAL")) {
                layoutParams3.addRule(14);
            } else {
                int b10 = com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 32.0d);
                layoutParams3.rightMargin = b10;
                layoutParams3.leftMargin = b10;
            }
        } else {
            layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 400.0d);
            int a11 = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 32.0d);
            layoutParams3.rightMargin = a11;
            layoutParams3.leftMargin = a11;
        }
        layoutParams3.addRule(3, this.f11695a.getId());
        addView(this.f11697d, layoutParams3);
        c();
    }

    private void c() {
        String str;
        final String str2;
        LeLog.i(f11693b, "addBanner");
        List<b.a> bannerData = getBannerData();
        if (bannerData == null) {
            LeLog.w(f11693b, "addBanner,data is null");
            return;
        }
        ImageView imageView = new ImageView(this.f11696c);
        imageView.setId(com.hpplay.sdk.source.browser.b.c.a());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (this.f11704l) {
            String[] a10 = a("SDK_UI_LIST_BANNER_HORIZONTAL", bannerData);
            if (a10 != null && a10.length >= 2) {
                str = a10[0];
                str2 = a10[1];
                RelativeLayout relativeLayout = new RelativeLayout(this.f11696c);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 542.0d), -1);
                layoutParams.addRule(3, this.f11700g.getId());
                layoutParams.addRule(11);
                layoutParams.rightMargin = com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 32.0d);
                addView(relativeLayout, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 542.0d), com.hpplay.sdk.source.browser.b.b.b(this.f11696c, 542.0d));
                layoutParams2.addRule(15);
                relativeLayout.addView(imageView, layoutParams2);
            } else {
                return;
            }
        } else {
            String[] a11 = a("SDK_UI_LIST_BANNER", bannerData);
            if (a11 != null && a11.length >= 2) {
                str = a11[0];
                str2 = a11[1];
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 160.0d));
                layoutParams3.addRule(12);
                layoutParams3.bottomMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 24.0d);
                layoutParams3.leftMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 24.0d);
                layoutParams3.rightMargin = com.hpplay.sdk.source.browser.b.b.a(this.f11696c, 24.0d);
                addView(imageView, layoutParams3);
            } else {
                return;
            }
        }
        LeLog.i(f11693b, "addBanner,imageUrl:" + str + ", clickUrl:" + str2);
        if (!TextUtils.isEmpty(str)) {
            Glide.with(this.f11696c).load(str).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE).into(imageView);
        }
        if (TextUtils.isEmpty(str2)) {
            LeLog.w(f11693b, "value is invalid");
        } else {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        a.this.f11696c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                    } catch (Exception e10) {
                        LeLog.w(a.f11693b, (Throwable) e10);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        e();
        j();
        this.f11705m = true;
        this.f11707o = new NotFoundView(this.f11696c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, this.f11695a.getId());
        layoutParams.addRule(5, this.f11695a.getId());
        layoutParams.addRule(7, this.f11695a.getId());
        layoutParams.addRule(12);
        addView(this.f11707o, layoutParams);
        this.f11707o.setCallback(this.C);
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            this.f11705m = false;
            removeView(this.f11707o);
            this.f11707o = null;
        } catch (Exception e10) {
            LeLog.w(f11693b, (Throwable) e10);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        LeLog.i(f11693b, "onViewDestroy");
        a();
        c cVar = this.f11701h;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    private void g() {
        HeaderView headerView = this.f11695a;
        if (headerView != null) {
            headerView.a();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        HeaderView headerView = this.f11695a;
        if (headerView != null) {
            headerView.b();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        LeLog.i(f11693b, "refreshDeviceList");
        if (System.currentTimeMillis() - this.f11703j >= f11694k) {
            e();
            j();
            a((List<com.hpplay.sdk.source.browser.a.a>) null);
            if (!com.hpplay.sdk.source.browser.b.c.a(this.f11696c)) {
                a("网络异常", "请检查\n大屏和手机端网络后重试");
                return;
            }
            this.f11703j = System.currentTimeMillis();
            a((View) this.f11700g);
            this.f11705m = false;
            this.f11706n = false;
            c cVar = this.f11701h;
            if (cVar != null) {
                cVar.onRefresh();
            }
            DeviceAdapter deviceAdapter = this.f11702i;
            if (deviceAdapter != null) {
                deviceAdapter.a((com.hpplay.sdk.source.browser.a.a) null);
            }
            this.f11718z.removeCallbacks(this.B);
            this.f11718z.postDelayed(this.B, 60000);
            g();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            this.f11706n = false;
            removeView(this.f11709q);
            this.f11709q = null;
        } catch (Exception e10) {
            LeLog.w(f11693b, (Throwable) e10);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        removeView(this.f11698e);
    }

    private void l() {
        if (this.f11697d.getAdapter().getCount() <= 1) {
            NetWorkView netWorkView = this.f11708p;
            if ((netWorkView == null || netWorkView.getChildCount() <= 0) && this.f11702i != null) {
                this.f11718z.post(new Runnable() {
                    public void run() {
                        if (a.this.f11702i.getCount() <= 0) {
                            a.this.k();
                            a.this.d();
                        }
                    }
                });
            }
        }
    }

    private void m() {
        this.f11699f = null;
        this.f11697d = null;
        b((View) this.f11700g);
        this.f11700g = null;
        removeAllViews();
        b();
        DeviceAdapter deviceAdapter = this.f11702i;
        if (deviceAdapter != null) {
            deviceAdapter.a(this.f11717y);
        }
        if (this.f11705m) {
            l();
        }
        if (this.f11706n) {
            a(this.f11711s, this.f11712t);
        }
        NetWorkView netWorkView = this.f11708p;
        if (netWorkView != null && netWorkView.getChildCount() > 0) {
            c(this.f11710r);
        }
    }

    public void a(String str) {
        if (!this.f11704l || !TextUtils.isEmpty(this.f11713u)) {
            this.f11713u = str;
            c();
            return;
        }
        LeLog.i(f11693b, "updateBannerData,ignore");
        this.f11713u = str;
    }

    private String[] a(String str, List<b.a> list) {
        String[] strArr = new String[2];
        Iterator<b.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b.a next = it.next();
            if (str.equalsIgnoreCase(next.f11599a)) {
                strArr[0] = next.f11601c;
                strArr[1] = next.f11608j;
                break;
            }
        }
        return strArr;
    }

    private void a(View view) {
        LeLog.i(f11693b, "rotateView view:" + view);
        if (view != null) {
            view.clearAnimation();
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(3);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            view.startAnimation(rotateAnimation);
        }
    }

    public void a(final String str, final String str2) {
        if (this.f11702i != null) {
            this.f11718z.post(new Runnable() {
                public void run() {
                    a.this.b(str, str2);
                }
            });
        }
    }

    public void a(final List<com.hpplay.sdk.source.browser.a.a> list) {
        this.f11718z.post(new Runnable() {
            public void run() {
                try {
                    List list = list;
                    if (list != null && list.size() > 0) {
                        a.this.e();
                    }
                    if (a.this.f11714v != null) {
                        a.this.f11714v.clear();
                        if (list != null) {
                            a.this.f11714v.addAll(list);
                        }
                    }
                } catch (Exception e10) {
                    LeLog.w(a.f11693b, (Throwable) e10);
                }
                if (a.this.f11702i != null) {
                    a.this.f11702i.notifyDataSetChanged();
                }
            }
        });
    }

    public void a(int i10) {
        l();
    }

    public void a() {
        this.f11718z.removeCallbacks(this.B);
        this.f11718z.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        this.f11710r = str;
        if (this.f11708p == null) {
            this.f11708p = new NetWorkView(this.f11696c);
        }
        this.f11708p.setCallback(new d() {
            public void a() {
                a.this.f11718z.post(new Runnable() {
                    public void run() {
                        if (a.this.f11708p != null && a.this.f11708p.getParent() != null) {
                            try {
                                ((ViewGroup) a.this.f11708p.getParent()).removeView(a.this.f11708p);
                                NetWorkView unused = a.this.f11708p = null;
                            } catch (Exception e10) {
                                LeLog.w(a.f11693b, (Throwable) e10);
                            }
                        }
                    }
                });
            }
        });
        addView(this.f11708p, new RelativeLayout.LayoutParams(-1, -1));
        this.f11708p.a(str);
    }

    private boolean b(String str) {
        String[] a10;
        List<b.a> bannerData = getBannerData();
        if (bannerData != null && (a10 = a(str, bannerData)) != null && a10.length >= 2 && !TextUtils.isEmpty(a10[0])) {
            return true;
        }
        return false;
    }

    private void b(View view) {
        LeLog.i(f11693b, "stopRotate view:" + view);
        if (view != null) {
            view.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2) {
        e();
        j();
        this.f11706n = true;
        this.f11711s = str;
        this.f11712t = str2;
        this.f11709q = new FailView(this.f11696c, str, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f11709q.setBackgroundColor(Integer.MIN_VALUE);
        addView(this.f11709q, layoutParams);
        this.f11709q.setCallback(new d() {
            public void a() {
                a.this.f11718z.post(new Runnable() {
                    public void run() {
                        a.this.j();
                    }
                });
            }
        });
    }
}
