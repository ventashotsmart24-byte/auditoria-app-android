package com.mobile.brasiltv.activity;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b6.d3;
import b6.r3;
import b6.z;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseFloatViewEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.AutoText;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.KoocanNetTabLayout;
import com.mobile.brasiltv.view.NoScrollViewPager;
import com.mobile.brasiltv.view.OpenNotifyDialog;
import com.mobile.brasiltv.view.dialog.CouponDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.ForceBindDialog;
import com.mobile.brasiltv.view.dialog.ForceBindNormalDialog;
import com.mobile.brasiltv.view.dialog.ServiceExpirationTipDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.a1;
import f5.c1;
import f5.d1;
import f5.e1;
import f5.f1;
import f5.g1;
import f5.h1;
import f5.v0;
import f5.w0;
import f5.y0;
import f5.z0;
import g5.x0;
import h9.t;
import i6.g0;
import i6.u;
import i6.v;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.b1;
import org.greenrobot.eventbus.ThreadMode;

public final class MainAty extends f5.d implements v {
    public static final a A = new a((t9.g) null);
    public static String B = "";
    public static boolean C;
    public static boolean D;
    public static ArrayList E = new ArrayList();
    public static ArrayList F = new ArrayList();
    public static boolean G;
    public static boolean H = true;
    public static boolean I;
    public static float J = -1.0f;
    public static int K = 1;
    public static int L = 1;

    /* renamed from: l  reason: collision with root package name */
    public ServiceExpirationTipDialog f5935l;

    /* renamed from: m  reason: collision with root package name */
    public CouponDialog f5936m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5937n;

    /* renamed from: o  reason: collision with root package name */
    public z5.c f5938o = new z5.c();

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f5939p = h9.h.b(new b(this));

    /* renamed from: q  reason: collision with root package name */
    public final h9.g f5940q = h9.h.b(new l(this));

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f5941r = h9.h.b(j.f12034a);

    /* renamed from: s  reason: collision with root package name */
    public final h9.g f5942s = h9.h.b(k.f12035a);

    /* renamed from: t  reason: collision with root package name */
    public r3 f5943t;

    /* renamed from: u  reason: collision with root package name */
    public z f5944u;

    /* renamed from: v  reason: collision with root package name */
    public d3 f5945v;

    /* renamed from: w  reason: collision with root package name */
    public t6.c f5946w;

    /* renamed from: x  reason: collision with root package name */
    public t6.b f5947x;

    /* renamed from: y  reason: collision with root package name */
    public b1 f5948y;

    /* renamed from: z  reason: collision with root package name */
    public Map f5949z = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final ArrayList a() {
            return MainAty.F;
        }

        public final String b() {
            return MainAty.B;
        }

        public final float c() {
            return MainAty.J;
        }

        public final int d() {
            return MainAty.K;
        }

        public final int e() {
            return MainAty.L;
        }

        public final boolean f() {
            return MainAty.H;
        }

        public final ArrayList g() {
            return MainAty.E;
        }

        public final boolean h() {
            return MainAty.C;
        }

        public final boolean i() {
            return MainAty.I;
        }

        public final void j(boolean z10) {
            MainAty.G = z10;
        }

        public final void k(String str) {
            t9.i.g(str, "<set-?>");
            MainAty.B = str;
        }

        public final void l(float f10) {
            MainAty.J = f10;
        }

        public final void m(int i10) {
            MainAty.K = i10;
        }

        public final void n(int i10) {
            MainAty.L = i10;
        }

        public final void o(boolean z10) {
            MainAty.H = z10;
        }

        public final void p(boolean z10) {
            MainAty.C = z10;
        }

        public final void q(boolean z10) {
            MainAty.D = z10;
        }

        public final void r(boolean z10) {
            MainAty.I = z10;
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12026a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MainAty mainAty) {
            super(0);
            this.f12026a = mainAty;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f12026a));
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12027a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MainAty mainAty) {
            super(1);
            this.f12027a = mainAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "granted");
            if (!bool.booleanValue()) {
                this.f12027a.s4();
            }
        }
    }

    public static final class d implements w5.n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12028a;

        public d(MainAty mainAty) {
            this.f12028a = mainAty;
        }

        public void a(InAppMsg inAppMsg) {
            t9.i.g(inAppMsg, Constant.KEY_MSG);
            if (t9.i.b(d6.b.f6366a.l(), inAppMsg.getUserId())) {
                w5.m mVar = w5.m.f19701a;
                if (mVar.v(inAppMsg, mVar.B()) || mVar.v(inAppMsg, mVar.A())) {
                    this.f12028a.l4();
                }
            }
        }
    }

    public static final class e implements w5.n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12029a;

        public e(MainAty mainAty) {
            this.f12029a = mainAty;
        }

        public void a(InAppMsg inAppMsg) {
            t9.i.g(inAppMsg, Constant.KEY_MSG);
            if (t9.i.b(d6.b.f6366a.l(), inAppMsg.getUserId())) {
                w5.m mVar = w5.m.f19701a;
                if (mVar.v(inAppMsg, mVar.x()) || mVar.v(inAppMsg, mVar.y()) || mVar.v(inAppMsg, mVar.z())) {
                    this.f12029a.l4();
                }
            }
        }
    }

    public static final class f implements v5.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12030a;

        public f(MainAty mainAty) {
            this.f12030a = mainAty;
        }

        public static final void c(MainAty mainAty) {
            t9.i.g(mainAty, "this$0");
            v5.g gVar = v5.g.f19670a;
            if (gVar.n() + gVar.k() + gVar.l() == 0) {
                ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).hideMsg(2);
            } else {
                ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).showDot(2);
            }
        }

        public void a() {
            ((KoocanNetTabLayout) this.f12030a.g3(R$id.mainAtyTab)).post(new h1(this.f12030a));
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f12031a = new g();

        public g() {
            super(1);
        }

        public final void b(Integer num) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f12032a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final class i implements OnTabSelectListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12033a;

        public i(MainAty mainAty) {
            this.f12033a = mainAty;
        }

        public void onTabReselect(int i10) {
        }

        public void onTabSelect(int i10) {
            this.f12033a.z4(i10);
            if (i10 == 0) {
                ((NoScrollViewPager) this.f12033a.g3(R$id.mainViewPager)).setCurrentItem(0, false);
                b0.N(this.f12033a);
                com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
                if (hVar.o() && hVar.s()) {
                    ((ImageView) this.f12033a.g3(R$id.ivCastFloat)).setVisibility(0);
                }
            } else if (i10 == 1) {
                ((NoScrollViewPager) this.f12033a.g3(R$id.mainViewPager)).setCurrentItem(1, false);
                b0.O(this.f12033a, MainAty.A.c());
                com.mobile.brasiltv.utils.h hVar2 = com.mobile.brasiltv.utils.h.f12562a;
                if (hVar2.o() && hVar2.s()) {
                    ((ImageView) this.f12033a.g3(R$id.ivCastFloat)).setVisibility(8);
                }
            } else if (i10 == 2) {
                this.f12033a.k4();
                ((NoScrollViewPager) this.f12033a.g3(R$id.mainViewPager)).setCurrentItem(2, false);
                b0.N(this.f12033a);
                com.mobile.brasiltv.utils.h hVar3 = com.mobile.brasiltv.utils.h.f12562a;
                if (hVar3.o() && hVar3.s()) {
                    ((ImageView) this.f12033a.g3(R$id.ivCastFloat)).setVisibility(0);
                }
            }
            this.f12033a.M3();
        }
    }

    public static final class j extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f12034a = new j();

        public j() {
            super(0);
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            return new ArrayList();
        }
    }

    public static final class k extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final k f12035a = new k();

        public k() {
            super(0);
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            return new ArrayList();
        }
    }

    public static final class l extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12036a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(MainAty mainAty) {
            super(0);
            this.f12036a = mainAty;
        }

        /* renamed from: b */
        public final x0 invoke() {
            androidx.fragment.app.o supportFragmentManager = this.f12036a.getSupportFragmentManager();
            t9.i.f(supportFragmentManager, "supportFragmentManager");
            return new x0(supportFragmentManager, this.f12036a.Q3(), this.f12036a.R3());
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12037a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(MainAty mainAty) {
            super(1);
            this.f12037a = mainAty;
        }

        public final void b(List list) {
            t9.i.g(list, "it");
            if (b0.I(list)) {
                w5.m.f19701a.W(this.f12037a.Q1(), (InAppMsg) list.get(0));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class n extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12038a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(MainAty mainAty) {
            super(0);
            this.f12038a = mainAty;
        }

        public final void invoke() {
            i1.K(this.f12038a.Q1(), "freeForceBind");
            b0.c0(this.f12038a, EmailAty.class);
        }
    }

    public static final class o extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12039a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(MainAty mainAty) {
            super(0);
            this.f12039a = mainAty;
        }

        public final void invoke() {
            b0.c0(this.f12039a, LoginAty.class);
        }
    }

    public static final class p extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12040a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(MainAty mainAty) {
            super(0);
            this.f12040a = mainAty;
        }

        public final void invoke() {
            i1.K(this.f12040a.Q1(), "forceBind");
            b0.c0(this.f12040a, EmailAty.class);
        }
    }

    public static final class q implements OpenNotifyDialog.NotificationListener {
        public void onOpen(Dialog dialog) {
            t9.i.g(dialog, "dialog");
            b0.j(dialog);
        }
    }

    public static final class r extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainAty f12041a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(MainAty mainAty) {
            super(1);
            this.f12041a = mainAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                ((KoocanNetTabLayout) this.f12041a.g3(R$id.mainAtyTab)).updateTabStyles();
            }
        }
    }

    public static final class s extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final s f12042a = new s();

        public s() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final void H3(StandardDialog standardDialog, View view) {
        t9.i.g(standardDialog, "$dialog");
        b0.j(standardDialog);
    }

    public static final void I3(MainAty mainAty, StandardDialog standardDialog, View view) {
        t9.i.g(mainAty, "this$0");
        t9.i.g(standardDialog, "$dialog");
        mainAty.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        standardDialog.dismiss();
        Object systemService = mainAty.Q1().getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        mainAty.finish();
    }

    public static final void K3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y3(MainAty mainAty, View view) {
        t9.i.g(mainAty, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.s()) {
            ((ImageView) mainAty.g3(R$id.ivCastFloat)).setVisibility(8);
            ((KoocanNetTabLayout) mainAty.g3(R$id.mainAtyTab)).setCurrentTab(1);
            ((NoScrollViewPager) mainAty.g3(R$id.mainViewPager)).setCurrentItem(1, false);
            return;
        }
        Intent intent = new Intent(mainAty, PlayAty.class);
        g0.a aVar = g0.f17324b0;
        intent.putExtra(aVar.j(), hVar.n());
        intent.putExtra(aVar.a(), hVar.b());
        intent.putExtra(aVar.f(), hVar.j());
        intent.putExtra(aVar.b(), hVar.c());
        intent.putExtra(aVar.i(), hVar.m());
        intent.putExtra(aVar.c(), hVar.q());
        intent.putExtra(aVar.d(), hVar.r());
        intent.putExtra(aVar.e(), hVar.i());
        intent.putExtra(aVar.k(), true);
        mainAty.startActivity(intent);
    }

    public static final void c4(MainAty mainAty, View view) {
        t9.i.g(mainAty, "this$0");
        int i10 = R$id.mTvNotice;
        ((AutoText) mainAty.g3(i10)).setText("");
        ((AutoText) mainAty.g3(i10)).stopScroll();
        ((AutoLinearLayout) mainAty.g3(R$id.mLayoutNotice)).setVisibility(8);
        ((NoScrollViewPager) mainAty.g3(R$id.mainViewPager)).setPadding(0, 0, 0, 0);
    }

    public static final void e4(MainAty mainAty, ObservableEmitter observableEmitter) {
        int i10;
        int i11;
        t9.i.g(mainAty, "this$0");
        t9.i.g(observableEmitter, "it");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        s6.a aVar = s6.a.f9335a;
        String c10 = aVar.a().c();
        if (t9.i.b(c10, "pt")) {
            i10 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0);
        } else if (t9.i.b(c10, "es")) {
            i10 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 2);
        } else {
            i10 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0);
        }
        subtitleManager.setMGlobalAudioLanguage(i10);
        String c11 = aVar.a().c();
        if (t9.i.b(c11, "pt")) {
            i11 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0);
        } else if (t9.i.b(c11, "es")) {
            i11 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 2);
        } else {
            i11 = n0.f12601a.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0);
        }
        subtitleManager.setMGlobalLanguage(i11);
        n0 n0Var = n0.f12601a;
        subtitleManager.setMGlobalSize(n0Var.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_SIZE, 0));
        subtitleManager.setMGlobalColor(n0Var.d(mainAty, SubtitleManager.GLOBAL_SUBTITLE_COLOR, 0));
        subtitleManager.setMGlobalSwitch(n0Var.b(mainAty, SubtitleManager.GLOBAL_SUBTITLE_SWITCH, true));
        observableEmitter.onNext(0);
    }

    public static final void f4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q4(MainAty mainAty) {
        CouponDialog couponDialog;
        t9.i.g(mainAty, "this$0");
        CouponDialog couponDialog2 = mainAty.f5936m;
        boolean z10 = false;
        if (couponDialog2 != null && couponDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (couponDialog = mainAty.f5936m) != null) {
            couponDialog.dismiss();
        }
        CouponDialog couponDialog3 = new CouponDialog(mainAty);
        mainAty.f5936m = couponDialog3;
        couponDialog3.show();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        r4 = a3.e.a(r4, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        if (r4 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r4 = com.mobile.brasiltv.utils.b0.W(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        r3 = a3.e.a(r3, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        if (r3 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r3 = com.mobile.brasiltv.utils.b0.W(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        r4 = a3.e.a(r4, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e5, code lost:
        if (r4 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        r4 = com.mobile.brasiltv.utils.b0.W(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ec, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010e, code lost:
        r0 = a3.e.a(r3, "key_poster");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r0 == null) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0114, code lost:
        r3 = com.mobile.brasiltv.utils.b0.W(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0119, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Boolean w4(com.mobile.brasiltv.activity.MainAty r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "key_poster"
            java.lang.String r2 = "this$0"
            t9.i.g(r10, r2)
            int r2 = com.mobile.brasiltv.R$id.mainAtyTab
            android.view.View r2 = r10.g3(r2)
            com.mobile.brasiltv.view.KoocanNetTabLayout r2 = (com.mobile.brasiltv.view.KoocanNetTabLayout) r2
            java.util.ArrayList r2 = r2.getTabData()
            int r3 = r2.size()
            r4 = 2
            if (r3 >= r4) goto L_0x001f
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L_0x001f:
            a7.d r3 = a7.d.f10697a
            mobile.com.requestframe.utils.response.ChildColumnList r4 = com.mobile.brasiltv.bean.RootColumnId.mainColumn
            java.util.List r4 = r4.getPosterList()
            java.lang.String r5 = r3.g()
            java.lang.String r4 = r3.n(r4, r5)
            mobile.com.requestframe.utils.response.ChildColumnList r5 = com.mobile.brasiltv.bean.RootColumnId.mainColumn
            java.util.List r5 = r5.getPosterList()
            java.lang.String r6 = r3.h()
            java.lang.String r3 = r3.n(r5, r6)
            r5 = 0
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r10)     // Catch:{ Exception -> 0x006a }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x006a }
            if (r7 == 0) goto L_0x004f
            if (r4 != 0) goto L_0x005b
            java.lang.String r4 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x006a }
            goto L_0x005b
        L_0x004f:
            java.lang.String r4 = a3.e.a(r4, r1)     // Catch:{ Exception -> 0x006a }
            if (r4 == 0) goto L_0x005a
            com.bumptech.glide.load.model.GlideUrl r4 = com.mobile.brasiltv.utils.b0.W(r4)     // Catch:{ Exception -> 0x006a }
            goto L_0x005b
        L_0x005a:
            r4 = r5
        L_0x005b:
            com.bumptech.glide.RequestBuilder r4 = r6.load((java.lang.Object) r4)     // Catch:{ Exception -> 0x006a }
            com.bumptech.glide.request.FutureTarget r4 = r4.submit()     // Catch:{ Exception -> 0x006a }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x006a }
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ Exception -> 0x006a }
            goto L_0x006b
        L_0x006a:
            r4 = r5
        L_0x006b:
            com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r10)     // Catch:{ Exception -> 0x0097 }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0097 }
            if (r7 == 0) goto L_0x007c
            if (r3 != 0) goto L_0x0088
            java.lang.String r3 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0088
        L_0x007c:
            java.lang.String r3 = a3.e.a(r3, r1)     // Catch:{ Exception -> 0x0097 }
            if (r3 == 0) goto L_0x0087
            com.bumptech.glide.load.model.GlideUrl r3 = com.mobile.brasiltv.utils.b0.W(r3)     // Catch:{ Exception -> 0x0097 }
            goto L_0x0088
        L_0x0087:
            r3 = r5
        L_0x0088:
            com.bumptech.glide.RequestBuilder r3 = r6.load((java.lang.Object) r3)     // Catch:{ Exception -> 0x0097 }
            com.bumptech.glide.request.FutureTarget r3 = r3.submit()     // Catch:{ Exception -> 0x0097 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0097 }
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3     // Catch:{ Exception -> 0x0097 }
            goto L_0x0099
        L_0x0097:
            r3 = r5
        L_0x0099:
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x00b2
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r8 = r2.get(r6)
            com.mobile.brasiltv.bean.MainTabEntity r8 = (com.mobile.brasiltv.bean.MainTabEntity) r8
            r8.setSelectedDrawable(r4)
            java.lang.Object r4 = r2.get(r6)
            com.mobile.brasiltv.bean.MainTabEntity r4 = (com.mobile.brasiltv.bean.MainTabEntity) r4
            r4.setUnSelectDrawable(r3)
            r6 = 1
        L_0x00b2:
            a7.d r3 = a7.d.f10697a
            mobile.com.requestframe.utils.response.ChildColumnList r4 = com.mobile.brasiltv.bean.RootColumnId.tvColumn
            java.util.List r4 = r4.getPosterList()
            java.lang.String r8 = r3.g()
            java.lang.String r4 = r3.n(r4, r8)
            mobile.com.requestframe.utils.response.ChildColumnList r8 = com.mobile.brasiltv.bean.RootColumnId.tvColumn
            java.util.List r8 = r8.getPosterList()
            java.lang.String r9 = r3.h()
            java.lang.String r3 = r3.n(r8, r9)
            com.bumptech.glide.RequestManager r8 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r10)     // Catch:{ Exception -> 0x00fc }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00fc }
            if (r9 == 0) goto L_0x00e1
            if (r4 != 0) goto L_0x00ed
            java.lang.String r4 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x00fc }
            goto L_0x00ed
        L_0x00e1:
            java.lang.String r4 = a3.e.a(r4, r1)     // Catch:{ Exception -> 0x00fc }
            if (r4 == 0) goto L_0x00ec
            com.bumptech.glide.load.model.GlideUrl r4 = com.mobile.brasiltv.utils.b0.W(r4)     // Catch:{ Exception -> 0x00fc }
            goto L_0x00ed
        L_0x00ec:
            r4 = r5
        L_0x00ed:
            com.bumptech.glide.RequestBuilder r4 = r8.load((java.lang.Object) r4)     // Catch:{ Exception -> 0x00fc }
            com.bumptech.glide.request.FutureTarget r4 = r4.submit()     // Catch:{ Exception -> 0x00fc }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x00fc }
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch:{ Exception -> 0x00fc }
            goto L_0x00fd
        L_0x00fc:
            r4 = r5
        L_0x00fd:
            com.bumptech.glide.RequestManager r10 = com.bumptech.glide.Glide.with((androidx.fragment.app.e) r10)     // Catch:{ Exception -> 0x012a }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x012a }
            if (r8 == 0) goto L_0x010e
            if (r3 != 0) goto L_0x011a
            java.lang.String r3 = a3.e.a(r0, r1)     // Catch:{ Exception -> 0x012a }
            goto L_0x011a
        L_0x010e:
            java.lang.String r0 = a3.e.a(r3, r1)     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x0119
            com.bumptech.glide.load.model.GlideUrl r3 = com.mobile.brasiltv.utils.b0.W(r0)     // Catch:{ Exception -> 0x012a }
            goto L_0x011a
        L_0x0119:
            r3 = r5
        L_0x011a:
            com.bumptech.glide.RequestBuilder r10 = r10.load((java.lang.Object) r3)     // Catch:{ Exception -> 0x012a }
            com.bumptech.glide.request.FutureTarget r10 = r10.submit()     // Catch:{ Exception -> 0x012a }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x012a }
            android.graphics.drawable.Drawable r10 = (android.graphics.drawable.Drawable) r10     // Catch:{ Exception -> 0x012a }
            r5 = r10
            goto L_0x012b
        L_0x012a:
        L_0x012b:
            if (r4 == 0) goto L_0x0142
            if (r5 == 0) goto L_0x0142
            java.lang.Object r10 = r2.get(r7)
            com.mobile.brasiltv.bean.MainTabEntity r10 = (com.mobile.brasiltv.bean.MainTabEntity) r10
            r10.setSelectedDrawable(r4)
            java.lang.Object r10 = r2.get(r7)
            com.mobile.brasiltv.bean.MainTabEntity r10 = (com.mobile.brasiltv.bean.MainTabEntity) r10
            r10.setUnSelectDrawable(r5)
            goto L_0x0143
        L_0x0142:
            r7 = r6
        L_0x0143:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.MainAty.w4(com.mobile.brasiltv.activity.MainAty):java.lang.Boolean");
    }

    public static final void x4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void G3() {
        if (Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0) == 1) {
            i1.B(Q1());
            StandardDialog standardDialog = new StandardDialog(this);
            String string = getResources().getString(R.string.tips);
            t9.i.f(string, "resources.getString(R.string.tips)");
            String string2 = getResources().getString(R.string.open_not_keep_activities);
            t9.i.f(string2, "resources.getString(R.st…open_not_keep_activities)");
            String string3 = getResources().getString(R.string.later);
            String string4 = getResources().getString(R.string.go_to_setting);
            t9.i.f(string4, "resources.getString(R.string.go_to_setting)");
            standardDialog.setDialogConfig(string, string2, string3, string4, new c1(standardDialog), new d1(this, standardDialog));
            b0.S(standardDialog, DialogManager.DIALOG_NO_KEEP_ACTIVITIES);
        }
    }

    public final void J3() {
        if (D && !q5.i.f19305a.j(Q1())) {
            if (Build.VERSION.SDK_INT >= 33) {
                new c8.b(this).o("android.permission.POST_NOTIFICATIONS").subscribe(new e1(new c(this)));
            } else {
                s4();
            }
            D = false;
        }
    }

    public final void L3() {
        Configuration configuration;
        Configuration configuration2;
        if (getRequestedOrientation() != 1) {
            Resources resources = getResources();
            boolean z10 = false;
            if (!(resources == null || (configuration2 = resources.getConfiguration()) == null || configuration2.orientation != 1)) {
                z10 = true;
            }
            if (!z10) {
                Resources resources2 = getResources();
                if (resources2 != null) {
                    configuration = resources2.getConfiguration();
                } else {
                    configuration = null;
                }
                if (configuration != null) {
                    configuration.orientation = 1;
                }
                setRequestedOrientation(1);
            }
        }
    }

    public final void M3() {
        if (this.f5937n) {
            int currentTab = ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab();
            if (currentTab == 0) {
                O3();
            } else if (currentTab != 2) {
                w5.m.f19701a.X();
            } else {
                N3();
            }
        }
    }

    public final void N3() {
        w5.m mVar = w5.m.f19701a;
        mVar.X();
        mVar.Z(w6.i.f9510g.H(), i9.j.h(mVar.B(), mVar.A()));
        mVar.R(new d(this));
        l4();
    }

    public final void O3() {
        w5.m mVar = w5.m.f19701a;
        mVar.X();
        mVar.Z(w6.i.f9510g.H(), i9.j.h(mVar.x(), mVar.y(), mVar.z()));
        mVar.R(new e(this));
        l4();
    }

    public final int P3() {
        return ((Number) this.f5939p.getValue()).intValue();
    }

    public final ArrayList Q3() {
        return (ArrayList) this.f5941r.getValue();
    }

    public void R2() {
        o4(new b1(this, this));
        C = true;
        ha.b bVar = ha.b.f17320a;
        if (TextUtils.isEmpty(bVar.a())) {
            bVar.b("setModuleBridging");
        }
        L3();
        G3();
        J3();
        a4();
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setTextVisible(false);
        i4();
        h4();
        n4(this);
        m4();
        X3();
        b4();
        Z3();
        d4();
    }

    public final ArrayList R3() {
        return (ArrayList) this.f5942s.getValue();
    }

    public final x0 S3() {
        return (x0) this.f5940q.getValue();
    }

    public int T2() {
        return R.layout.aty_main;
    }

    /* renamed from: T3 */
    public b1 S2() {
        b1 b1Var = this.f5948y;
        if (b1Var != null) {
            return b1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void U3(Configuration configuration) {
        if (configuration.orientation == 2) {
            ((AutoLinearLayout) g3(R$id.mLayoutNotice)).setVisibility(8);
            boolean z10 = false;
            ((NoScrollViewPager) g3(R$id.mainViewPager)).setPadding(0, 0, 0, 0);
            int i10 = R$id.mTvNotice;
            CharSequence text = ((AutoText) g3(i10)).getText();
            t9.i.f(text, "mTvNotice.text");
            if (text.length() > 0) {
                z10 = true;
            }
            if (z10) {
                ((AutoText) g3(i10)).pauseScroll();
                return;
            }
            return;
        }
        z4(((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab());
    }

    public final void V3() {
        int i10 = R$id.mainAtyTab;
        ViewGroup.LayoutParams layoutParams = ((KoocanNetTabLayout) g3(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = 0;
        ((KoocanNetTabLayout) g3(i10)).setLayoutParams(layoutParams2);
    }

    public final void W3() {
        ((AutoLinearLayout) g3(R$id.mLayoutNotice)).setVisibility(8);
        ((AutoText) g3(R$id.mTvNotice)).stopScroll();
    }

    public final void X3() {
        ((ImageView) g3(R$id.ivCastFloat)).setOnClickListener(new a1(this));
    }

    public void Y(int i10, String str) {
        ServiceExpirationTipDialog serviceExpirationTipDialog;
        t9.i.g(str, "hintContent");
        ServiceExpirationTipDialog serviceExpirationTipDialog2 = this.f5935l;
        boolean z10 = false;
        if (serviceExpirationTipDialog2 != null && serviceExpirationTipDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (serviceExpirationTipDialog = this.f5935l) != null) {
            serviceExpirationTipDialog.dismiss();
        }
        ServiceExpirationTipDialog serviceExpirationTipDialog3 = new ServiceExpirationTipDialog(this, i10, str);
        this.f5935l = serviceExpirationTipDialog3;
        b0.S(serviceExpirationTipDialog3, DialogManager.DIALOG_EXPIRED);
    }

    public final void Z3() {
        v5.g.f19670a.o(new f(this));
    }

    public void a2(int i10) {
        b0.S(new ForceBindNormalDialog(Q1(), i10, new n(this)), DialogManager.DIALOG_FORCE_BIND);
    }

    public final void a4() {
        this.f5943t = new r3();
        this.f5944u = new z();
        this.f5945v = new d3();
        ArrayList Q3 = Q3();
        r3 r3Var = this.f5943t;
        d3 d3Var = null;
        if (r3Var == null) {
            t9.i.w("mVodFragment");
            r3Var = null;
        }
        Q3.add(r3Var);
        ArrayList Q32 = Q3();
        z zVar = this.f5944u;
        if (zVar == null) {
            t9.i.w("mLiveFragment");
            zVar = null;
        }
        Q32.add(zVar);
        ArrayList Q33 = Q3();
        d3 d3Var2 = this.f5945v;
        if (d3Var2 == null) {
            t9.i.w("mMine1Fragment");
        } else {
            d3Var = d3Var2;
        }
        Q33.add(d3Var);
        R3().addAll(i9.j.c(b0.A(this, R.string.nav_button_home), b0.A(this, R.string.nav_button_live), b0.A(this, R.string.nav_button_mine)));
    }

    public void attachBaseContext(Context context) {
        t9.i.g(context, "newBase");
        super.attachBaseContext(context);
        String language = Locale.getDefault().getLanguage();
        t9.i.f(language, "getDefault().language");
        B = language;
        b0.U(this, "cur record language: " + B);
    }

    public final void b4() {
        ((ImageView) g3(R$id.mIvCloseNotice)).setOnClickListener(new f5.b1(this));
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void castPlayEvent(CastPlaySuccessEvent castPlaySuccessEvent) {
        t9.i.g(castPlaySuccessEvent, "event");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        hVar.C(t9.i.b(castPlaySuccessEvent.getFromType(), "LIVE"));
        if (((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() != 1 || !hVar.s()) {
            ((ImageView) g3(R$id.ivCastFloat)).setVisibility(0);
        } else {
            ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
        }
        if (hVar.s()) {
            hVar.y("");
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void castToCloseOtherPlay(CastToCloseOtherPlayEvent castToCloseOtherPlayEvent) {
        t9.i.g(castToCloseOtherPlayEvent, "event");
        if (t9.i.b(castToCloseOtherPlayEvent.getFromType(), "LIVE")) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
            if (!hVar.s()) {
                ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
                if (!castToCloseOtherPlayEvent.getStop()) {
                    return;
                }
                if (t9.i.b(hVar.a(), hVar.k())) {
                    if (hVar.t()) {
                        com.mobile.brasiltv.utils.g.f12519a.G();
                        return;
                    }
                    return;
                } else if (t9.i.b(hVar.a(), hVar.l())) {
                    this.f5938o.r();
                    return;
                } else {
                    return;
                }
            }
        }
        if (t9.i.b(castToCloseOtherPlayEvent.getFromType(), "VOD")) {
            com.mobile.brasiltv.utils.h hVar2 = com.mobile.brasiltv.utils.h.f12562a;
            if (hVar2.s()) {
                ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
                if (!castToCloseOtherPlayEvent.getStop()) {
                    return;
                }
                if (t9.i.b(hVar2.a(), hVar2.k())) {
                    if (hVar2.t()) {
                        com.mobile.brasiltv.utils.g.f12519a.G();
                    }
                } else if (t9.i.b(hVar2.a(), hVar2.l())) {
                    this.f5938o.r();
                }
            }
        }
    }

    public final void d4() {
        Observable.create(new v0(this)).compose(p0.b()).subscribe(new y0(g.f12031a), new z0(h.f12032a));
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void disConnectEvent(CastToCloseFloatViewEvent castToCloseFloatViewEvent) {
        t9.i.g(castToCloseFloatViewEvent, "event");
        ((ImageView) g3(R$id.ivCastFloat)).setVisibility(8);
        com.mobile.brasiltv.utils.h.f12562a.v(false);
    }

    public View g3(int i10) {
        Map map = this.f5949z;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoCRMessage(GotoCREvent gotoCREvent) {
        t9.i.g(gotoCREvent, "event");
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(0);
        ((NoScrollViewPager) g3(R$id.mainViewPager)).setCurrentItem(0);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoHomeTabMessage(GotoHomeTabEvent gotoHomeTabEvent) {
        t9.i.g(gotoHomeTabEvent, "event");
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(gotoHomeTabEvent.getTab());
        ((NoScrollViewPager) g3(R$id.mainViewPager)).setCurrentItem(gotoHomeTabEvent.getTab());
    }

    public final void h4() {
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setOnTabSelectListener(new i(this));
    }

    public void i4() {
        ArrayList E0 = S2().E0();
        int i10 = R$id.mainAtyTab;
        ((KoocanNetTabLayout) g3(i10)).setTabData(E0);
        ((KoocanNetTabLayout) g3(i10)).setCurrentTab(0);
    }

    public final void j4() {
        int i10 = R$id.mainViewPager;
        ((NoScrollViewPager) g3(i10)).setAdapter(S3());
        ((NoScrollViewPager) g3(i10)).setOffscreenPageLimit(S3().getCount());
        ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).setCurrentTab(0);
        ((NoScrollViewPager) g3(i10)).setCurrentItem(0);
    }

    public void k0() {
        boolean z10;
        CouponDialog couponDialog;
        ServiceExpirationTipDialog serviceExpirationTipDialog;
        ServiceExpirationTipDialog serviceExpirationTipDialog2 = this.f5935l;
        boolean z11 = true;
        if (serviceExpirationTipDialog2 == null || !serviceExpirationTipDialog2.isShowing()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && (serviceExpirationTipDialog = this.f5935l) != null) {
            b0.j(serviceExpirationTipDialog);
        }
        CouponDialog couponDialog2 = this.f5936m;
        if (couponDialog2 == null || !couponDialog2.isShowing()) {
            z11 = false;
        }
        if (z11 && (couponDialog = this.f5936m) != null) {
            couponDialog.dismiss();
        }
        W3();
        d3 d3Var = this.f5945v;
        if (d3Var != null) {
            if (d3Var == null) {
                t9.i.w("mMine1Fragment");
                d3Var = null;
            }
            d3Var.w3();
        }
    }

    public void k2() {
        n2();
    }

    public final void k4() {
        if (this.f5937n && ((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() == 2) {
            d3 d3Var = this.f5945v;
            if (d3Var == null) {
                t9.i.w("mMine1Fragment");
                d3Var = null;
            }
            d3Var.Q3();
        }
    }

    public final void l4() {
        w5.m.f19701a.M(new m(this));
    }

    public void m1() {
        b0.S(new ForceBindDialog(Q1(), new o(this), new p(this)), DialogManager.DIALOG_FORCE_BIND);
    }

    public final void m4() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f5947x = new t6.b();
            Q1().registerReceiver(this.f5947x, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
        }
    }

    public final void n4(Context context) {
        this.f5946w = new t6.c();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        if (Build.VERSION.SDK_INT >= 26) {
            Intent unused = context.registerReceiver(this.f5946w, intentFilter, 4);
        } else {
            context.registerReceiver(this.f5946w, intentFilter);
        }
    }

    public void o4(b1 b1Var) {
        t9.i.g(b1Var, "<set-?>");
        this.f5948y = b1Var;
    }

    public void onBackPressed() {
        z zVar = this.f5944u;
        z zVar2 = null;
        if (zVar == null) {
            t9.i.w("mLiveFragment");
            zVar = null;
        }
        if (zVar.J3()) {
            z zVar3 = this.f5944u;
            if (zVar3 == null) {
                t9.i.w("mLiveFragment");
            } else {
                zVar2 = zVar3;
            }
            zVar2.I3();
            return;
        }
        S2().o0();
    }

    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        getResources().getConfiguration().orientation = configuration.orientation;
        U3(configuration);
    }

    public void onDestroy() {
        DialogManager.INSTANCE.clear();
        super.onDestroy();
        u4(this);
        t4();
    }

    public void onError() {
        ((KoocanEmptyView) g3(R$id.loadingView)).setVisibility(8);
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (((KoocanNetTabLayout) g3(R$id.mainAtyTab)).getCurrentTab() == 1 && ((ImageView) g3(R$id.ivCastFloat)).getVisibility() == 0 && com.mobile.brasiltv.utils.h.f12562a.s()) {
            if (i10 == 24) {
                com.mobile.brasiltv.utils.g0.f12538a.a();
                return true;
            } else if (i10 == 25) {
                com.mobile.brasiltv.utils.g0.f12538a.o();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        b0.U(this, "onNewIntent");
    }

    public void onPause() {
        super.onPause();
        if (((AutoLinearLayout) g3(R$id.mLayoutNotice)).getVisibility() == 0) {
            ((AutoText) g3(R$id.mTvNotice)).pauseScroll();
        }
    }

    public void onRestart() {
        super.onRestart();
        xa.c.c().j(new VodPageRestartEvent());
    }

    public void onRestoreInstanceState(Bundle bundle) {
        t9.i.g(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        SplashAty.f12202s.b(bundle.getBoolean("enterSplashPage", false));
    }

    public void onResume() {
        super.onResume();
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) g3(R$id.mLayoutNotice);
        boolean z10 = false;
        if (autoLinearLayout != null && autoLinearLayout.getVisibility() == 0) {
            z10 = true;
        }
        if (z10) {
            ((AutoText) g3(R$id.mTvNotice)).resumeScroll();
        }
        k4();
        M3();
    }

    public void onSaveInstanceState(Bundle bundle) {
        t9.i.g(bundle, "outState");
        bundle.putBoolean("enterSplashPage", SplashAty.f12202s.a());
        super.onSaveInstanceState(bundle);
    }

    public void p0() {
        this.f5937n = true;
        j4();
        v4();
        M3();
    }

    /* renamed from: p4 */
    public void Y0(u uVar) {
        t9.i.g(uVar, "presenter");
    }

    public final void r4() {
        int i10 = R$id.mainAtyTab;
        ViewGroup.LayoutParams layoutParams = ((KoocanNetTabLayout) g3(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = s0.a(this, 55.0f);
        ((KoocanNetTabLayout) g3(i10)).setLayoutParams(layoutParams2);
    }

    public void s() {
        ((KoocanEmptyView) g3(R$id.loadingView)).setVisibility(8);
    }

    public void s2(String str) {
        int i10;
        t9.i.g(str, "info");
        int i11 = R$id.mLayoutNotice;
        ViewGroup.LayoutParams layoutParams = ((AutoLinearLayout) g3(i11)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, P3(), 0, 0);
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) g3(R$id.mainViewPager);
        int i12 = R$id.mainAtyTab;
        if (((KoocanNetTabLayout) g3(i12)).getCurrentTab() == 2) {
            i10 = 0;
        } else {
            i10 = P3();
        }
        noScrollViewPager.setPadding(0, i10, 0, 0);
        ((AutoLinearLayout) g3(i11)).setVisibility(0);
        int i13 = R$id.mTvNotice;
        ((AutoText) g3(i13)).setText(str);
        ((AutoText) g3(i13)).setTextColor(getResources().getColor(R.color.color_important));
        ((AutoText) g3(i13)).setTextSize((float) AutoUtils.getPercentWidthSize(24));
        ((AutoText) g3(i13)).setContentPaddingLeft(50);
        ((AutoText) g3(i13)).startScroll();
        if (((KoocanNetTabLayout) g3(i12)).getCurrentTab() == 2) {
            W3();
        }
    }

    public final void s4() {
        b0.S(new OpenNotifyDialog(this, new q()), DialogManager.DIALOG_OPEN_NOTIFY);
    }

    public final void t4() {
        if (this.f5947x != null) {
            Q1().unregisterReceiver(this.f5947x);
        }
    }

    public final void u4(Context context) {
        t6.c cVar = this.f5946w;
        if (cVar != null) {
            context.unregisterReceiver(cVar);
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        t9.i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    public void v1() {
        runOnUiThread(new f5.x0(this));
    }

    public final void v4() {
        Observable.fromCallable(new f1(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g1(new r(this)), new w0(s.f12042a));
    }

    public final void z4(int i10) {
        boolean z10;
        int i11;
        int i12;
        int i13 = R$id.mTvNotice;
        CharSequence text = ((AutoText) g3(i13)).getText();
        t9.i.f(text, "mTvNotice.text");
        if (text.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i14 = R$id.mLayoutNotice;
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) g3(i14);
            if (i10 == 2) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            autoLinearLayout.setVisibility(i11);
            NoScrollViewPager noScrollViewPager = (NoScrollViewPager) g3(R$id.mainViewPager);
            if (i10 == 2) {
                i12 = 0;
            } else {
                i12 = P3();
            }
            noScrollViewPager.setPadding(0, i12, 0, 0);
            if (((AutoLinearLayout) g3(i14)).getVisibility() == 0) {
                ((AutoText) g3(i13)).resumeScroll();
            } else {
                ((AutoText) g3(i13)).pauseScroll();
            }
        }
    }
}
