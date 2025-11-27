package com.mobile.brasiltv.view.vod;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import java.util.Map;
import t9.g;
import t9.i;

public final class CouponFloatView extends RelativeLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private c activity;
    private ImageView imCoupon;
    private ImageView imCouponClose;
    private View view;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CouponFloatView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final RelativeLayout.LayoutParams getParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(layoutParams.leftMargin, s0.b(getContext()) / 2, layoutParams.rightMargin, layoutParams.bottomMargin);
        return layoutParams;
    }

    public static /* synthetic */ void slideIn$default(CouponFloatView couponFloatView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        couponFloatView.slideIn(j10);
    }

    public static /* synthetic */ void slideOut$default(CouponFloatView couponFloatView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 500;
        }
        couponFloatView.slideOut(j10);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i10));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void add(ViewGroup viewGroup) {
        i.g(viewGroup, "parent");
        viewGroup.addView(this);
    }

    public final void hide() {
        setVisibility(8);
    }

    public void onClick(View view2) {
        Integer num;
        if (view2 != null) {
            num = Integer.valueOf(view2.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.imCoupon) {
            i1.l(getContext());
            com.mobile.brasiltv.utils.f.f12516a.b();
            MyBenefitsAty.a aVar = MyBenefitsAty.f12342r;
            Context context = getContext();
            i.f(context, f.X);
            aVar.a(context, 0, true);
            c cVar = this.activity;
            if (cVar != null) {
                cVar.overridePendingTransition(0, 0);
            }
        } else if (num != null && num.intValue() == R.id.imCouponClose) {
            w6.i.f9510g.X(true);
            remove();
        }
    }

    public final void remove() {
        ViewParent parent = getParent();
        i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(this);
    }

    public final void setActivity(c cVar) {
        this.activity = cVar;
    }

    public final void show() {
        setVisibility(0);
    }

    public final void slideIn(long j10) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.view, "translationX", new float[]{170.0f}).setDuration(j10);
        i.f(duration, "ofFloat(view, \"translati…()).setDuration(duration)");
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
        View view2 = this.view;
        if (view2 != null) {
            view2.setAlpha(0.5f);
        }
    }

    public final void slideOut(long j10) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.view, "translationX", new float[]{0.0f}).setDuration(j10);
        i.f(duration, "ofFloat(view, \"translati…0f).setDuration(duration)");
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
        View view2 = this.view;
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CouponFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [android.view.View] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CouponFloatView(android.content.Context r2, android.util.AttributeSet r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            t9.i.g(r2, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1._$_findViewCache = r0
            r1.<init>(r2, r3, r4)
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131558700(0x7f0d012c, float:1.8742723E38)
            r4 = 1
            android.view.View r2 = r2.inflate(r3, r1, r4)
            r1.view = r2
            r3 = 0
            if (r2 == 0) goto L_0x002a
            r4 = 2131362101(0x7f0a0135, float:1.8343973E38)
            android.view.View r2 = r2.findViewById(r4)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x002b
        L_0x002a:
            r2 = r3
        L_0x002b:
            r1.imCoupon = r2
            android.view.View r2 = r1.view
            if (r2 == 0) goto L_0x003b
            r3 = 2131362102(0x7f0a0136, float:1.8343975E38)
            android.view.View r2 = r2.findViewById(r3)
            r3 = r2
            android.widget.ImageView r3 = (android.widget.ImageView) r3
        L_0x003b:
            r1.imCouponClose = r3
            android.widget.RelativeLayout$LayoutParams r2 = r1.getParams()
            r1.setLayoutParams(r2)
            android.widget.ImageView r2 = r1.imCoupon
            if (r2 == 0) goto L_0x004b
            r2.setOnClickListener(r1)
        L_0x004b:
            android.widget.ImageView r2 = r1.imCouponClose
            if (r2 == 0) goto L_0x0052
            r2.setOnClickListener(r1)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.vod.CouponFloatView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponFloatView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
