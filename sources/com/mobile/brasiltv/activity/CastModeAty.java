package com.mobile.brasiltv.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.mediarouter.app.MediaRouteButton;
import com.advertlib.bean.AdInfo;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CastExperienceModelToPlayEvent;
import com.mobile.brasiltv.bean.event.CastToFinishModeAtyEvent;
import com.mobile.brasiltv.bean.event.GoogleCastToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.r;
import f5.s;
import f5.u;
import f5.v;
import f5.w;
import h9.t;
import java.util.LinkedHashMap;
import java.util.Map;
import na.f;
import s1.m;
import s1.q;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import w6.i;
import z5.c;

public final class CastModeAty extends f5.c implements c.b, c.C0299c {

    /* renamed from: v  reason: collision with root package name */
    public static final a f5905v = new a((g) null);

    /* renamed from: k  reason: collision with root package name */
    public String f5906k = "";

    /* renamed from: l  reason: collision with root package name */
    public boolean f5907l;

    /* renamed from: m  reason: collision with root package name */
    public String f5908m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f5909n = "";

    /* renamed from: o  reason: collision with root package name */
    public boolean f5910o;

    /* renamed from: p  reason: collision with root package name */
    public z5.c f5911p;

    /* renamed from: q  reason: collision with root package name */
    public CastContext f5912q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5913r = true;

    /* renamed from: s  reason: collision with root package name */
    public ObjectAnimator f5914s;

    /* renamed from: t  reason: collision with root package name */
    public final c f5915t = new c(this);

    /* renamed from: u  reason: collision with root package name */
    public Map f5916u = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CastModeAty f11973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdInfo f11974b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CastModeAty castModeAty, AdInfo adInfo) {
            super(1);
            this.f11973a = castModeAty;
            this.f11974b = adInfo;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return t.f17319a;
        }

        public final void invoke(boolean z10) {
            if (!z10) {
                ((TextView) this.f11973a.X2(R$id.mTvAdFlag)).setVisibility(8);
                return;
            }
            if (this.f11974b.isShowFlag()) {
                ((TextView) this.f11973a.X2(R$id.mTvAdFlag)).setVisibility(0);
            } else {
                ((TextView) this.f11973a.X2(R$id.mTvAdFlag)).setVisibility(8);
            }
            ((AutoFrameLayout) this.f11973a.X2(R$id.mAflAdWrapper)).setVisibility(0);
            q qVar = q.f9311a;
            Context Q1 = this.f11973a.Q1();
            String m10 = d6.b.f6366a.m(this.f11973a.Q1());
            a6.a aVar = a6.a.f10646a;
            qVar.j(Q1, m10, aVar.a(), this.f11974b);
            m.f9270a.d0(this.f11973a.Q1(), aVar.a(), this.f11974b.getAd_id());
        }
    }

    public static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CastModeAty f11975a;

        public c(CastModeAty castModeAty) {
            this.f11975a = castModeAty;
        }

        public void handleMessage(Message message) {
            i.g(message, Constant.KEY_MSG);
            super.handleMessage(message);
            if (message.what == 1) {
                this.f11975a.a3();
            }
        }
    }

    public static final void e3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        b0.l(castModeAty);
    }

    public static final void f3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        int i10 = R$id.mTvRealChromeCast;
        if (((MediaRouteButton) castModeAty.X2(i10)).getVisibility() == 0) {
            i1.j(castModeAty, w6.i.f9510g.H(), "CHROME_CAST");
            ((MediaRouteButton) castModeAty.X2(i10)).performClick();
            return;
        }
        ((TextView) castModeAty.X2(R$id.mTvMockChromeCast)).performClick();
    }

    public static final void g3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        if (castModeAty.f5913r) {
            castModeAty.r3();
        } else {
            castModeAty.m3();
        }
    }

    public static final void h3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        i1.j(castModeAty, w6.i.f9510g.H(), "DLNA");
    }

    public static final void j3(AdInfo adInfo, CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        if (i.b(adInfo.getAction_type(), "1") && !TextUtils.isEmpty(adInfo.getAction())) {
            b0.j0(castModeAty.Q1(), adInfo.getAction(), false, true, false, false, 24, (Object) null);
            q.f9311a.h(castModeAty.Q1(), d6.b.f6366a.m(castModeAty.Q1()), a6.a.f10646a.a(), adInfo);
        } else if (i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            b0.m(castModeAty.Q1());
        }
    }

    public static final void p3(CastModeAty castModeAty, View view) {
        i.g(castModeAty, "this$0");
        b0.l(castModeAty);
    }

    public void D0(CastSession castSession, String str) {
        Z2();
        h hVar = h.f12562a;
        hVar.w(hVar.l());
        if (i.b(this.f5906k, "EXPERIENCE")) {
            xa.c.c().j(new CastExperienceModelToPlayEvent(false));
        } else if (i.b(this.f5906k, "LIVE") || i.b(this.f5906k, "VOD")) {
            xa.c.c().j(new GoogleCastToPlayEvent(this.f5906k));
        } else if (this.f5907l) {
            b0.c0(this, ExperienceCastPlayAty.class);
        }
        finish();
    }

    public void K0(CastSession castSession, int i10) {
    }

    public void P0() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    public void V0(CastSession castSession) {
        Z2();
        s3();
    }

    public View X2(int i10) {
        Map map = this.f5916u;
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

    public void Z(CastSession castSession, boolean z10) {
    }

    public final void Z2() {
        this.f5910o = false;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(8);
        ((TextView) X2(R$id.mTvChromeCastHint)).setVisibility(8);
        b3();
        this.f5915t.removeMessages(1);
    }

    public final void a3() {
        this.f5910o = false;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(8);
        b3();
        o3();
    }

    public void b1(CastSession castSession, int i10) {
        Z2();
    }

    public final void b3() {
        ObjectAnimator objectAnimator = this.f5914s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f5914s = null;
    }

    public final void c3() {
        if (this.f5913r) {
            Z2();
        }
    }

    public final void d3() {
        ((TitleView) X2(R$id.mTitleView)).setTvMenuClickListener(new r(this));
        ((AutoFrameLayout) X2(R$id.mTvChromeCastWrapper)).setOnClickListener(new s(this));
        ((TextView) X2(R$id.mTvMockChromeCast)).setOnClickListener(new f5.t(this));
        ((TextView) X2(R$id.mTvDLNACast)).setOnClickListener(new u(this));
    }

    public void g1() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    public final void i3() {
        String str;
        TextView tvMenuView = ((TitleView) X2(R$id.mTitleView)).getTvMenuView();
        if (tvMenuView != null) {
            tvMenuView.setText(getResources().getString(R.string.cast_faq));
            tvMenuView.setBackgroundResource(R.drawable.bg_cast_help);
            tvMenuView.setTextColor(getResources().getColor(R.color.color_1ecd6a));
            ViewGroup.LayoutParams layoutParams = tvMenuView.getLayoutParams();
            i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
            AutoRelativeLayout.LayoutParams layoutParams2 = (AutoRelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = AutoUtils.getPercentWidthSize(100);
            layoutParams2.height = AutoUtils.getPercentWidthSize(42);
            layoutParams2.addRule(15);
            tvMenuView.setLayoutParams(layoutParams2);
        }
        m mVar = m.f9270a;
        Context Q1 = Q1();
        a6.a aVar = a6.a.f10646a;
        String a10 = aVar.a();
        i.c cVar = w6.i.f9510g;
        AdInfo H = mVar.H(Q1, a10, "picture", cVar.I(), true, cVar.r());
        if (H != null) {
            Context Q12 = Q1();
            int i10 = R$id.mIvAd;
            ImageView imageView = (ImageView) X2(i10);
            String a11 = aVar.a();
            t9.i.f(imageView, "mIvAd");
            m.h0(mVar, Q12, imageView, a11, H, (Integer) null, new b(this, H), Integer.MIN_VALUE, false, 0, 400, (Object) null);
            ((ImageView) X2(i10)).setOnClickListener(new v(H, this));
        }
        if (k3()) {
            int i11 = R$id.mTvChromeCastHint;
            ((TextView) X2(i11)).setVisibility(0);
            ((TextView) X2(i11)).setTextColor(getResources().getColor(R.color.color_secondary_assist));
            TextView textView = (TextView) X2(i11);
            String str2 = this.f5906k;
            if (t9.i.b(str2, "VOD")) {
                str = getResources().getString(R.string.cast_not_supported_vod_chrome);
            } else if (t9.i.b(str2, "LIVE")) {
                str = getResources().getString(R.string.cast_not_supported_live_chrome);
            } else {
                str = "";
            }
            textView.setText(str);
            int i12 = R$id.mTvMockChromeCast;
            ((TextView) X2(i12)).setBackgroundResource(R.drawable.bg_disable_cast_mode);
            ((TextView) X2(i12)).setTextColor(getResources().getColor(R.color.color_737780));
            ((TextView) X2(i12)).setEnabled(false);
        }
    }

    public void k2() {
        n2();
    }

    public final boolean k3() {
        if (this.f5907l || (!t9.i.b(this.f5906k, "LIVE") && (!t9.i.b(this.f5906k, "VOD") || l3()))) {
            return false;
        }
        return true;
    }

    public void l0() {
        if (this.f5910o) {
            ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).performClick();
        }
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(0);
        Z2();
    }

    public final boolean l3() {
        if (!t9.i.b(this.f5908m, IjkMediaFormat.CODEC_NAME_H264) || !t9.i.b(this.f5909n, "mp4")) {
            return false;
        }
        return true;
    }

    public final void m3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f72f2f));
        ((TextView) X2(i10)).setText(Html.fromHtml(getResources().getString(R.string.cast_search_chrome_not_available)));
        ((TextView) X2(i10)).setOnClickListener((View.OnClickListener) null);
    }

    public final void n3() {
        int i10;
        String e10 = f.e(getApplicationContext(), "last_cast_mode");
        if (b0.J(e10)) {
            ((TextView) X2(R$id.mTvLastTime)).setVisibility(8);
            return;
        }
        int i11 = R$id.mTvLastTime;
        ((TextView) X2(i11)).setVisibility(0);
        if (t9.i.b(e10, "CHROME_CAST")) {
            i10 = R.id.mTvChromeCastWrapper;
        } else {
            i10 = R.id.mTvDLNACast;
        }
        ViewGroup.LayoutParams layoutParams = ((TextView) X2(i11)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        AutoRelativeLayout.LayoutParams layoutParams2 = (AutoRelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(6, i10);
        layoutParams2.addRule(7, i10);
        ((TextView) X2(i11)).setLayoutParams(layoutParams2);
    }

    public final void o3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_f72f2f));
        ((TextView) X2(i10)).setText(Html.fromHtml(getResources().getString(R.string.cast_search_chrome_fail)));
        ((TextView) X2(i10)).setOnClickListener(new w(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0085, code lost:
        if (r4.getCastState() == 1) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            r4 = 2131558495(0x7f0d005f, float:1.8742307E38)
            r3.setContentView(r4)
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r0 = "from_type"
            java.lang.String r4 = r4.getStringExtra(r0)
            java.lang.String r0 = ""
            if (r4 != 0) goto L_0x0018
            r4 = r0
        L_0x0018:
            r3.f5906k = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "experience_mode"
            r2 = 0
            boolean r4 = r4.getBooleanExtra(r1, r2)
            r3.f5907l = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "cast_video_encode_format"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r4 != 0) goto L_0x0034
            r4 = r0
        L_0x0034:
            r3.f5908m = r4
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "cast_video_stream_format"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r4 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r0 = r4
        L_0x0044:
            r3.f5909n = r0
            r3.i3()
            r3.d3()
            z5.c$a r4 = z5.c.f20263e
            boolean r4 = r4.a(r3)
            r3.f5913r = r4
            boolean r4 = r3.k3()
            if (r4 == 0) goto L_0x005c
            r3.f5913r = r2
        L_0x005c:
            boolean r4 = r3.f5913r
            if (r4 == 0) goto L_0x0094
            com.google.android.gms.cast.framework.CastContext r4 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r3)
            r3.f5912q = r4
            z5.c r4 = new z5.c
            r4.<init>()
            r3.f5911p = r4
            android.content.Context r4 = r3.getApplicationContext()
            int r0 = com.mobile.brasiltv.R$id.mTvRealChromeCast
            android.view.View r1 = r3.X2(r0)
            androidx.mediarouter.app.MediaRouteButton r1 = (androidx.mediarouter.app.MediaRouteButton) r1
            com.google.android.gms.cast.framework.CastButtonFactory.setUpMediaRouteButton(r4, r1)
            com.google.android.gms.cast.framework.CastContext r4 = r3.f5912q
            if (r4 == 0) goto L_0x0088
            int r4 = r4.getCastState()
            r1 = 1
            if (r4 != r1) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r1 = 0
        L_0x0089:
            if (r1 != 0) goto L_0x0094
            android.view.View r4 = r3.X2(r0)
            androidx.mediarouter.app.MediaRouteButton r4 = (androidx.mediarouter.app.MediaRouteButton) r4
            r4.setVisibility(r2)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.CastModeAty.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        b3();
        this.f5915t.removeMessages(1);
        super.onDestroy();
    }

    public void onPause() {
        c3();
        z5.c cVar = this.f5911p;
        if (cVar != null) {
            cVar.n(this);
        }
        z5.c cVar2 = this.f5911p;
        if (cVar2 != null) {
            cVar2.p(this);
        }
        super.onPause();
    }

    public void onResume() {
        z5.c cVar = this.f5911p;
        if (cVar != null) {
            cVar.c(this, this);
        }
        z5.c cVar2 = this.f5911p;
        if (cVar2 != null) {
            cVar2.g(this, this);
        }
        super.onResume();
        n3();
    }

    public final void q3() {
        int i10 = R$id.mTvChromeCastHint;
        ((TextView) X2(i10)).setVisibility(0);
        ((TextView) X2(i10)).setTextColor(getResources().getColor(R.color.color_1ecd6a));
        ((TextView) X2(i10)).setText(getResources().getString(R.string.cast_searching_chrome));
        ((TextView) X2(i10)).setOnClickListener((View.OnClickListener) null);
    }

    public void r1() {
        ((MediaRouteButton) X2(R$id.mTvRealChromeCast)).setVisibility(8);
        Z2();
    }

    public final void r3() {
        this.f5910o = true;
        ((ImageView) X2(R$id.mIvChromeCastLoading)).setVisibility(0);
        s3();
        q3();
        this.f5915t.sendEmptyMessageDelayed(1, NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    public final void s3() {
        b3();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) X2(R$id.mIvChromeCastLoading), ParamsMap.MirrorParams.KEY_ROTATION, new float[]{0.0f, 359.0f});
        this.f5914s = ofFloat;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator = this.f5914s;
        if (objectAnimator != null) {
            objectAnimator.setDuration(2000);
        }
        ObjectAnimator objectAnimator2 = this.f5914s;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.f5914s;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
    }

    @xa.j
    public final void toFinishAty(CastToFinishModeAtyEvent castToFinishModeAtyEvent) {
        t9.i.g(castToFinishModeAtyEvent, "event");
        finish();
    }

    public void w1(CastSession castSession, int i10) {
    }
}
