package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.images.WebImage;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CastExperienceModelToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.g0;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.view.dialog.feedback.CastFeedBackDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.l0;
import f5.m0;
import f5.n0;
import f5.o0;
import f5.p0;
import f5.q0;
import f5.r0;
import f5.s0;
import i6.p;
import i6.q;
import i9.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.z;
import s9.l;
import t9.g;
import t9.i;
import z5.c;

public final class ExperienceCastPlayAty extends f5.d implements q, c.d, c.e {

    /* renamed from: l  reason: collision with root package name */
    public z f5925l;

    /* renamed from: m  reason: collision with root package name */
    public int f5926m = 2;

    /* renamed from: n  reason: collision with root package name */
    public final List f5927n = j.h(o6.c.a(), o6.c.b(), o6.c.c());

    /* renamed from: o  reason: collision with root package name */
    public z5.c f5928o = new z5.c();

    /* renamed from: p  reason: collision with root package name */
    public final String f5929p = "http://www.oi1lgew.com/dl/4.mp4";

    /* renamed from: q  reason: collision with root package name */
    public final String f5930q = "http://www.oi1lgew.com/dl/5.mp4";

    /* renamed from: r  reason: collision with root package name */
    public final String f5931r = "http://www.oi1lgew.com/dl/1080p_short.mp4";

    /* renamed from: s  reason: collision with root package name */
    public final String f5932s = "http://www.oi1lgew.com/dl/pic00.jpg";

    /* renamed from: t  reason: collision with root package name */
    public String f5933t = "";

    /* renamed from: u  reason: collision with root package name */
    public Map f5934u = new LinkedHashMap();

    public static final class a implements g0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExperienceCastPlayAty f12009a;

        public a(ExperienceCastPlayAty experienceCastPlayAty) {
            this.f12009a = experienceCastPlayAty;
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12010a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "EXPERIENCE");
            i.f(putExtra, "intent.putExtra(Constant…ant.FROM_TYPE_EXPERIENCE)");
            return putExtra;
        }
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExperienceCastPlayAty f12011a;

        public c(ExperienceCastPlayAty experienceCastPlayAty) {
            this.f12011a = experienceCastPlayAty;
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
            if (((AutoLinearLayout) this.f12011a.c3(R$id.llCastContainer)).getVisibility() == 0) {
                h hVar = h.f12562a;
                if (i.b(hVar.a(), hVar.k())) {
                    g0.f12538a.i(seekBar.getProgress());
                } else if (i.b(hVar.a(), hVar.l())) {
                    this.f12011a.f5928o.q(((long) seekBar.getProgress()) * 1000);
                }
            }
        }
    }

    public static final class d extends ha.a {
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
        }
    }

    public static final void k3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        n6.b bVar = new n6.b(false, 1, (g) null);
        String string = experienceCastPlayAty.getResources().getString(R.string.popup_quality_title);
        i.f(string, "resources.getString(R.string.popup_quality_title)");
        g7.d dVar = new g7.d(experienceCastPlayAty, string, bVar);
        bVar.c(experienceCastPlayAty.f5926m);
        bVar.addData(experienceCastPlayAty.f5927n);
        bVar.setOnItemClickListener(new s0(experienceCastPlayAty, bVar, dVar));
        dVar.c(true);
    }

    public static final void l3(ExperienceCastPlayAty experienceCastPlayAty, n6.b bVar, g7.d dVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(experienceCastPlayAty, "this$0");
        i.g(bVar, "$qualityAdapter");
        i.g(dVar, "$qualityPop");
        experienceCastPlayAty.f5926m = i10;
        if (bVar.b() != i10) {
            h hVar = h.f12562a;
            if (i.b(hVar.a(), hVar.k())) {
                experienceCastPlayAty.z3();
            } else if (i.b(hVar.a(), hVar.l())) {
                experienceCastPlayAty.A3();
            }
        }
        dVar.dismiss();
    }

    public static final void m3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        experienceCastPlayAty.finish();
    }

    public static final void n3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        b0.d0(experienceCastPlayAty, CastByNativeDeviceAty.class, b.f12010a);
    }

    public static final void o3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        new CastFeedBackDialog(experienceCastPlayAty).show();
    }

    public static final void p3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        h hVar = h.f12562a;
        if (i.b(hVar.a(), hVar.k())) {
            g0 g0Var = g0.f12538a;
            if (g0Var.f()) {
                g0Var.g();
            } else if (g0Var.e()) {
                g0Var.h();
            } else if (g0Var.d()) {
                experienceCastPlayAty.z3();
            }
        } else if (i.b(hVar.a(), hVar.l())) {
            experienceCastPlayAty.f5928o.k();
        }
    }

    public static final void q3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        b0.l(experienceCastPlayAty);
    }

    public static final void s3(ExperienceCastPlayAty experienceCastPlayAty, View view) {
        i.g(experienceCastPlayAty, "this$0");
        experienceCastPlayAty.finish();
    }

    public final void A3() {
        String str;
        int i10 = this.f5926m;
        if (i10 == 0) {
            str = this.f5931r;
        } else if (i10 == 1) {
            str = this.f5930q;
        } else if (i10 != 2) {
            str = this.f5929p;
        } else {
            str = this.f5929p;
        }
        this.f5928o.j(str, 0, 0, g3());
        z5.c.m(this.f5928o, this, "Experience", "Experience", "Experience", "vod", CdnType.TYPE_ICDN, (String) null, (String) null, 192, (Object) null);
        this.f5933t = h.f12562a.l();
        e3();
    }

    public void L0() {
    }

    public void L1(int i10) {
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        h3(i10);
    }

    public void N1(long j10, long j11) {
        long j12 = (long) 1000;
        long j13 = j11 / j12;
        long j14 = j10 / j12;
        int i10 = R$id.mSeekBarCast;
        int i11 = (int) j13;
        if (((SeekBar) c3(i10)).getMax() != i11) {
            ((SeekBar) c3(i10)).setMax(i11);
        }
        ((SeekBar) c3(i10)).setProgress((int) j14);
        String l10 = y6.a.l(j13);
        String l11 = y6.a.l(j14);
        int i12 = R$id.mTextTotalTimeCast;
        CharSequence text = ((TextView) c3(i12)).getText();
        if (!i.b(text, '/' + l10)) {
            ((TextView) c3(i12)).setText('/' + l10);
        }
        ((TextView) c3(R$id.mTextCurTimeCast)).setText(l11);
    }

    public void R2() {
        w3(new z(this, this));
        ((AutoLinearLayout) c3(R$id.llCastContainer)).setVisibility(0);
        r3();
        j3();
        i3();
        z3();
    }

    public int T2() {
        return R.layout.aty_experience_cast_play;
    }

    public void U() {
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public void b0() {
    }

    public void c2() {
        int i10 = R$id.mTvCastState;
        ((TextView) c3(i10)).setText(Q1().getResources().getString(R.string.cast_status_casting));
        ((TextView) c3(i10)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
        ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
        v3();
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public View c3(int i10) {
        Map map = this.f5934u;
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

    @xa.j
    public final void castToPlay(CastExperienceModelToPlayEvent castExperienceModelToPlayEvent) {
        i.g(castExperienceModelToPlayEvent, "event");
        boolean z10 = !i.b(this.f5933t, h.f12562a.a());
        if (z10) {
            y3(this.f5933t);
        }
        if (castExperienceModelToPlayEvent.isDLNA()) {
            if (z10) {
                i3();
            }
            z3();
            return;
        }
        A3();
        if (z10) {
            t3();
        }
    }

    public void e0() {
    }

    public final void e3() {
        int i10 = R$id.mTvCastState;
        ((TextView) c3(i10)).setText(Q1().getResources().getString(R.string.cast_status_prepare));
        ((TextView) c3(i10)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
        ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(0);
        ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
        v3();
        ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
        int i11 = this.f5926m;
        if (i11 == 2) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_480);
        } else if (i11 == 1) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_720);
        } else if (i11 == 0) {
            ((ImageView) c3(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_1080);
        }
    }

    /* renamed from: f3 */
    public z S2() {
        z zVar = this.f5925l;
        if (zVar != null) {
            return zVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void finish() {
        y3(h.f12562a.a());
        super.finish();
    }

    public final MediaMetadata g3() {
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, "Experience Video");
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, "");
        mediaMetadata.addImage(new WebImage(Uri.parse(this.f5932s)));
        return mediaMetadata;
    }

    public final void h3(int i10) {
        if (i10 == 1) {
            ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        } else if (i10 == 3) {
            int i11 = R$id.mTvCastState;
            ((TextView) c3(i11)).setText(Q1().getResources().getString(R.string.cast_status_casting));
            ((TextView) c3(i11)).setTextColor(Q1().getResources().getColor(R.color.color_fffefe));
            ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(4);
            v3();
            ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
        } else if (i10 == 4) {
            int i12 = R$id.mTvCastState;
            ((TextView) c3(i12)).setText(Q1().getResources().getString(R.string.cast_status_casting_failed));
            ((TextView) c3(i12)).append("(4)");
            ((TextView) c3(i12)).setTextColor(Q1().getResources().getColor(R.color.color_f72f2f));
            ((TextView) c3(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) c3(R$id.mTvCastRecommendHint)).setVisibility(0);
            ((ImageView) c3(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
            u3();
        }
    }

    public final void i3() {
        g0.f12538a.j(new a(this));
    }

    public final void j3() {
        ((ImageView) c3(R$id.mIvCastQuality)).setOnClickListener(new m0(this));
        ((ImageView) c3(R$id.mIvCastClose)).setOnClickListener(new n0(this));
        ((ImageView) c3(R$id.mIvCastSwitchDevice)).setOnClickListener(new o0(this));
        ((ImageView) c3(R$id.mIvCastFeedback)).setOnClickListener(new p0(this));
        ((SeekBar) c3(R$id.mSeekBarCast)).setOnSeekBarChangeListener(new c(this));
        ((ImageView) c3(R$id.mImagePlayCast)).setOnClickListener(new q0(this));
        ((TextView) c3(R$id.mTvCastRecommendHint)).setOnClickListener(new r0(this));
    }

    public void k2() {
        n2();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        h hVar = h.f12562a;
        if (i.b(hVar.a(), hVar.k())) {
            if (i10 != 24) {
                if (i10 == 25 && ((AutoLinearLayout) c3(R$id.llCastContainer)).getVisibility() == 0) {
                    g0.f12538a.o();
                    return true;
                }
            } else if (((AutoLinearLayout) c3(R$id.llCastContainer)).getVisibility() == 0) {
                g0.f12538a.a();
                return true;
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public final void r3() {
        int a10 = n5.a.f8310a.a(this);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i10 = R$id.mNavBack;
        ((ImageView) c3(i10)).setLayoutParams(layoutParams);
        ((ImageView) c3(i10)).setOnClickListener(new l0(this));
        ((TextView) c3(R$id.mTvCastRecommendHint)).setText(Html.fromHtml(getResources().getString(R.string.cast_recommend_hint)));
    }

    public final void t3() {
        z5.c.m(this.f5928o, this, "Experience", "Experience", "Experience", "vod", CdnType.TYPE_ICDN, (String) null, (String) null, 192, (Object) null);
    }

    public final void u3() {
        String str;
        if (this.f5926m == 0) {
            str = "480P";
        } else {
            str = "720P";
        }
        w6.i.f9510g.b().s2("Experience", ((TextView) c3(R$id.mTvCastDevice)).getText().toString(), h.f12562a.a(), str).subscribe(new d());
    }

    public final void v3() {
        CastDevice castDevice;
        String friendlyName;
        String name;
        h hVar = h.f12562a;
        String str = "";
        if (i.b(hVar.a(), hVar.k())) {
            int i10 = R$id.mTvCastDevice;
            TextView textView = (TextView) c3(i10);
            LelinkServiceInfo c10 = g0.f12538a.c();
            if (!(c10 == null || (name = c10.getName()) == null)) {
                str = name;
            }
            textView.setText(str);
            ((TextView) c3(i10)).append("-DLNA");
            ((TextView) c3(R$id.mTvTitle)).setText(getResources().getString(R.string.cast_test_dlna));
            return;
        }
        int i11 = R$id.mTvCastDevice;
        TextView textView2 = (TextView) c3(i11);
        CastSession i12 = this.f5928o.i();
        if (!(i12 == null || (castDevice = i12.getCastDevice()) == null || (friendlyName = castDevice.getFriendlyName()) == null)) {
            str = friendlyName;
        }
        textView2.setText(str);
        ((TextView) c3(i11)).append("-ChromeCast");
        ((TextView) c3(R$id.mTvTitle)).setText(getResources().getString(R.string.cast_test_google));
    }

    public void w3(z zVar) {
        i.g(zVar, "<set-?>");
        this.f5925l = zVar;
    }

    /* renamed from: x3 */
    public void Y0(p pVar) {
        i.g(pVar, "presenter");
    }

    public final void y3(String str) {
        h hVar = h.f12562a;
        if (i.b(str, hVar.k())) {
            g0 g0Var = g0.f12538a;
            g0Var.b();
            g0Var.l(false);
        } else if (i.b(str, hVar.l())) {
            this.f5928o.s();
            this.f5928o.r();
        }
    }

    public final void z3() {
        g0 g0Var = g0.f12538a;
        g0Var.k("EXPERIENCE");
        g0Var.l(true);
        g0Var.m(this.f5926m);
        this.f5933t = h.f12562a.k();
        e3();
    }
}
