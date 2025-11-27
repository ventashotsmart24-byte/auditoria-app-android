package com.mobile.brasiltv.player.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import ba.s;
import ba.t;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.event.GoToSharingEvent;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import mobile.com.requestframe.utils.response.AssetData;
import t9.i;
import xa.c;

public final class ProgramActorInfoView extends AutoRelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public Map f12466a = new LinkedHashMap();

    public static final class a extends ForegroundColorSpan {

        /* renamed from: a  reason: collision with root package name */
        public final float f12467a;

        public a(int i10, float f10) {
            super(i10);
            this.f12467a = f10;
        }

        public void updateDrawState(TextPaint textPaint) {
            i.g(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setTextSize(this.f12467a);
        }
    }

    public static final class b extends ReplacementSpan {

        /* renamed from: a  reason: collision with root package name */
        public final int f12468a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12469b;

        public b(int i10, int i11) {
            this.f12468a = i10;
            this.f12469b = i11;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
            i.g(canvas, "canvas");
            i.g(paint, "paint");
        }

        public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
            i.g(paint, "paint");
            return this.f12468a + this.f12469b;
        }
    }

    public ProgramActorInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.layout_actor_info_view, this, true);
    }

    public static final void e(AssetData assetData, ProgramActorInfoView programActorInfoView, View view) {
        i.g(assetData, "$data");
        i.g(programActorInfoView, "this$0");
        if (b0.H(assetData.getAwardsUrl())) {
            Context context = programActorInfoView.getContext();
            i.f(context, f.X);
            String awardsUrl = assetData.getAwardsUrl();
            i.d(awardsUrl);
            b0.h0(context, awardsUrl, false, false, false, true);
        }
    }

    public static final void f(ProgramActorInfoView programActorInfoView, AssetData assetData, View view) {
        i.g(programActorInfoView, "this$0");
        i.g(assetData, "$data");
        b0.U(programActorInfoView, "mFavLayout: " + w6.i.f9510g.I());
        PlayAty.a aVar = PlayAty.G;
        if (!aVar.b().contains(assetData.getContentId())) {
            aVar.b().add(assetData.getContentId());
            c.c().j(new VodFavEvent(assetData));
        }
    }

    private final void setAwards(AssetData assetData) {
        boolean z10;
        String awardsUrl = assetData.getAwardsUrl();
        if (awardsUrl == null || awardsUrl.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((TextView) _$_findCachedViewById(R$id.mTvAwards)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvAwards;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new r6.a(assetData, this));
    }

    private final void setFavAndSub(AssetData assetData) {
        k(assetData);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mFavLayout)).setOnClickListener(new r6.b(this, assetData));
        l(assetData);
    }

    /* access modifiers changed from: private */
    public static final void setShare$lambda$2(View view) {
        c.c().j(new GoToSharingEvent());
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f12466a;
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

    public final void d(AssetData assetData) {
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        i.g(assetData, "program");
        setFavAndSub(assetData);
        setAwards(assetData);
        i();
        String contentTag = assetData.getContentTag();
        if (contentTag == null || contentTag.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((TextView) _$_findCachedViewById(R$id.mTvGrade)).setVisibility(8);
        } else {
            int i10 = R$id.mTvGrade;
            ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
            ((TextView) _$_findCachedViewById(i10)).setText(assetData.getContentTag());
        }
        String j10 = s.j(b0.e(assetData.getAlias(), assetData.getName()), "\n", "", false, 4, (Object) null);
        if (!i.b(IdManager.DEFAULT_VERSION_NAME, String.valueOf(assetData.getScore()))) {
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            sb.append(assetData.getScore());
            str = sb.toString();
        } else {
            str = "";
        }
        if (!i.b(assetData.getProgramType(), "movie") || assetData.getVolumnCount() <= 0) {
            str2 = "";
        } else {
            str2 = Operator.Operation.DIVISION + String.valueOf(assetData.getVolumnCount()) + " " + getContext().getResources().getString(R.string.epsode_all);
        }
        i.f(str2, "if (program.programType …\n            \"\"\n        }");
        SpannableString spannableString = new SpannableString(j10 + str + str2);
        if (!i.b(str, "")) {
            spannableString.setSpan(new b(25, 0), j10.length(), j10.length() + 1, 17);
            spannableString.setSpan(new a(b0.y(R.color.color_ff8900), (float) s0.d(getContext(), 15.0f)), j10.length() + 1, (j10 + str).length(), 17);
        }
        if (!i.b(str2, "")) {
            spannableString.setSpan(new a(b0.y(R.color.color_cccccc), (float) s0.d(getContext(), 15.0f)), (j10 + str).length(), (j10 + str + str2).length(), 17);
        }
        ((TextView) _$_findCachedViewById(R$id.mTextName)).setText(spannableString);
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTextCountry);
        if (b0.H(assetData.getOriginalCountry())) {
            str3 = assetData.getOriginalCountry();
        } else {
            str3 = b0.z(R.string.unkownInfo);
        }
        textView.setText(str3);
        TextView textView2 = (TextView) _$_findCachedViewById(R$id.mTextReleaseTime);
        if (!b0.H(assetData.getReleaseTime())) {
            str4 = b0.z(R.string.unkownInfo);
        } else if (assetData.getReleaseTime().length() >= 4) {
            str4 = assetData.getReleaseTime().substring(0, 4);
            i.f(str4, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str4 = assetData.getReleaseTime();
        }
        textView2.setText(str4);
        int i11 = R$id.mTextDirector;
        ((TextView) _$_findCachedViewById(i11)).setText(b0.z(R.string.dector) + ' ');
        if (b0.H(assetData.getDirector())) {
            ((TextView) _$_findCachedViewById(i11)).append(t.W(s.j(assetData.getDirector(), ",", Operator.Operation.DIVISION, false, 4, (Object) null)).toString());
        } else {
            ((TextView) _$_findCachedViewById(i11)).append(b0.z(R.string.unkownInfo));
        }
        int i12 = R$id.mTextActors;
        ((TextView) _$_findCachedViewById(i12)).setText(b0.z(R.string.actor) + ' ');
        if (!TextUtils.isEmpty(assetData.getActorDisplay())) {
            ((TextView) _$_findCachedViewById(i12)).append(t.W(s.j(assetData.getActorDisplay(), ",", Operator.Operation.DIVISION, false, 4, (Object) null)).toString());
        } else {
            ((TextView) _$_findCachedViewById(i12)).append(b0.z(R.string.unkownInfo));
        }
        int i13 = R$id.mTextType;
        ((TextView) _$_findCachedViewById(i13)).setText("");
        if (!TextUtils.isEmpty(assetData.getTags())) {
            ((TextView) _$_findCachedViewById(i13)).append(t.W(s.j(assetData.getTags(), ",", Operator.Operation.DIVISION, false, 4, (Object) null)).toString());
        } else {
            ((TextView) _$_findCachedViewById(i13)).append(b0.z(R.string.unkownInfo));
        }
        j();
    }

    public final void g(VodDao vodDao, AssetData assetData, String str, boolean z10) {
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        ((ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView)).r(vodDao, assetData, str, z10, true);
    }

    public final void h(VodDao vodDao, AssetData assetData, String str, boolean z10) {
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        ProgramSetInfoView programSetInfoView = (ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView);
        i.f(programSetInfoView, "mProgramSetInfoView");
        ProgramSetInfoView.s(programSetInfoView, vodDao, assetData, str, z10, false, 16, (Object) null);
    }

    public final void i() {
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) _$_findCachedViewById(R$id.mShareLayout);
        i.f(autoLinearLayout, "mShareLayout");
        b0.P(autoLinearLayout, new r6.c());
    }

    public final void j() {
        ViewParent parent = getParent();
        i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setVisibility(0);
    }

    public final void k(AssetData assetData) {
        i.g(assetData, "data");
        if (TextUtils.isEmpty(assetData.getHasFavorite())) {
            assetData.setHasFavorite("0");
        }
        if (i.b(assetData.getHasFavorite(), "1")) {
            ((ImageView) _$_findCachedViewById(R$id.mImageFav)).setImageResource(R.drawable.ic_vod_fav);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageFav)).setImageResource(R.drawable.ic_vod_unfav);
        }
    }

    public final void l(AssetData assetData) {
        i.g(assetData, "data");
        if (TextUtils.isEmpty(assetData.getHasSubscribe())) {
            assetData.setHasSubscribe("0");
        }
    }

    public final void m(AssetData assetData) {
        i.g(assetData, "program");
        ((ProgramDetailView) _$_findCachedViewById(R$id.mProgramDetail)).a(assetData);
    }

    public final void setIsResumed(boolean z10) {
        ((ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView)).setIsResumed(z10);
    }
}
