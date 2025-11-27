package com.titans.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.titan.ranger.bean.Program;
import l7.e;
import q8.d;

public class TitanVODView extends TitanVideoView {

    /* renamed from: l  reason: collision with root package name */
    public String f13401l = "TitanVodVideoView";

    /* renamed from: m  reason: collision with root package name */
    public Long f13402m = 0L;

    /* renamed from: n  reason: collision with root package name */
    public String f13403n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f13404o = "";

    /* renamed from: p  reason: collision with root package name */
    public TextView f13405p = null;

    /* renamed from: q  reason: collision with root package name */
    public int f13406q = 11;

    /* renamed from: r  reason: collision with root package name */
    public int f13407r = 14;

    /* renamed from: s  reason: collision with root package name */
    public boolean f13408s = true;

    public TitanVODView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        H();
    }

    private int getBottomMargin() {
        if (getResources().getConfiguration().orientation == 2) {
            return d.a(getContext(), 70.0f);
        }
        return d.a(getContext(), 25.0f);
    }

    public void B(Program program, String str, String str2) {
        e.j();
        F();
        super.B(program, str, str2);
    }

    public final int E() {
        if (getResources().getConfiguration().orientation == 2) {
            return this.f13407r;
        }
        return this.f13406q;
    }

    public final void F() {
        this.f13405p.setVisibility(8);
        this.f13405p.setText("");
    }

    public void G(boolean z10) {
        this.f13408s = z10;
    }

    public void H() {
        TextView I = I();
        this.f13405p = I;
        addView(I);
    }

    public final TextView I() {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setShadowLayer(1.0f, 1.0f, 3.0f, RoundedDrawable.DEFAULT_BORDER_COLOR);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(2, (float) E());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = getBottomMargin();
        textView.setLayoutParams(layoutParams);
        textView.setText("");
        return textView;
    }

    public void J(String str, String str2) {
        this.f13403n = str;
        this.f13404o = str2;
        F();
        if (t() && getTitanContext() != null && str2.equals(getTitanContext().e())) {
            e.l(str);
        }
    }

    public void K(int i10, int i11) {
        this.f13406q = i10;
        this.f13407r = i11;
        M();
    }

    public final void L() {
        if (this.f13408s && !TextUtils.isEmpty(this.f13403n) && s()) {
            e.k(this.f13405p, getCurrentProgress() + 200 + this.f13402m.longValue());
        }
    }

    public final void M() {
        TextView textView = this.f13405p;
        if (textView != null) {
            textView.setTextSize(2, (float) E());
        }
    }

    public void a(int i10, String str, String str2) {
        super.a(i10, str, str2);
        if (str.equals("media")) {
            F();
        }
    }

    public void b(int i10, long j10, String str) {
        super.b(i10, j10, str);
        L();
    }

    public String getSubtitlePath() {
        return this.f13403n;
    }

    public void h(int i10, int i11, int i12, String str, String str2) {
        super.h(i10, i11, i12, str, str2);
        if (str.equals("media")) {
            e.j();
            F();
            if (this.f13403n != null && getTitanContext() != null && this.f13404o.equals(getTitanContext().e())) {
                e.l(this.f13403n);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f13405p.setTextSize(2, (float) E());
    }

    public void onDetachedFromWindow() {
        e.j();
        super.onDetachedFromWindow();
    }

    public void setSubtitleBg(int i10) {
        TextView textView = this.f13405p;
        if (textView == null) {
            return;
        }
        if (i10 == 1) {
            textView.setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        } else {
            textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
    }

    public void setSubtitleColor(int i10) {
        TextView textView = this.f13405p;
        if (textView != null) {
            textView.setTextColor(getContext().getResources().getColor(i10));
        }
    }

    public void setSubtitleVisible(boolean z10) {
        G(z10);
        if (z10) {
            TextView textView = this.f13405p;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        F();
    }

    public void setSubtitlestime(long j10) {
        this.f13402m = Long.valueOf(j10);
    }
}
