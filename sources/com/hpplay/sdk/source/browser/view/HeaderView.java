package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.b.c;

public class HeaderView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11639a = "HeaderView";

    /* renamed from: b  reason: collision with root package name */
    private Context f11640b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11641c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11642d;

    /* renamed from: e  reason: collision with root package name */
    private LoadingView f11643e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11644f = false;

    public HeaderView(Context context) {
        super(context);
        this.f11640b = context;
        d();
    }

    private void d() {
        setPadding(b.a(this.f11640b, 0.0d), b.a(this.f11640b, 20.0d), b.a(this.f11640b, 0.0d), b.a(this.f11640b, 24.0d));
        LinearLayout linearLayout = new LinearLayout(this.f11640b);
        this.f11641c = linearLayout;
        linearLayout.setOrientation(0);
        this.f11641c.setGravity(17);
        this.f11641c.setId(c.a());
        this.f11641c.setBackgroundDrawable(getDefaultBackgroundDrawable());
        addView(this.f11641c, new RelativeLayout.LayoutParams(-1, b.a(this.f11640b, 104.0d)));
        TextView textView = new TextView(this.f11640b);
        this.f11642d = textView;
        textView.setText("正在搜索投屏设备");
        this.f11642d.setTextColor(-1);
        this.f11642d.setTextSize(2, 14.0f);
        this.f11642d.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = b.a(this.f11640b, 20.0d);
        this.f11641c.addView(this.f11642d, layoutParams);
        this.f11643e = new LoadingView(this.f11640b);
        this.f11641c.addView(this.f11643e, new LinearLayout.LayoutParams(b.a(this.f11640b, 56.0d), b.a(this.f11640b, 56.0d)));
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void a() {
        LeLog.i(f11639a, "startBrowserAnim isAnimating:" + this.f11644f);
        if (!this.f11644f) {
            this.f11643e.setVisibility(0);
            this.f11643e.a();
            this.f11642d.setText("正在搜索投屏设备");
            this.f11644f = true;
        }
    }

    public void b() {
        LeLog.i(f11639a, "stopBrowserAnim isAnimating:" + this.f11644f);
        this.f11644f = false;
        this.f11643e.setVisibility(8);
        this.f11643e.b();
        this.f11642d.setText("【搜索结束，点击右上角按钮继续搜索】");
    }

    public void c() {
        b();
    }

    public HeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11640b = context;
        d();
    }

    public HeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11640b = context;
        d();
    }
}
