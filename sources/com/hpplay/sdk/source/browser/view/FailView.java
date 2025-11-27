package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.b.c;
import com.hpplay.sdk.source.browser.d;

public class FailView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11629a = "FailView";

    /* renamed from: b  reason: collision with root package name */
    private Context f11630b;

    /* renamed from: c  reason: collision with root package name */
    private String f11631c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f11632d = null;

    /* renamed from: e  reason: collision with root package name */
    private d f11633e;

    public FailView(Context context) {
        super(context);
        this.f11630b = context;
        a();
    }

    /* access modifiers changed from: private */
    public void b() {
        LeLog.i(f11629a, "destroyView");
        d dVar = this.f11633e;
        if (dVar != null) {
            dVar.a();
        }
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void setCallback(d dVar) {
        this.f11633e = dVar;
    }

    private void a() {
        setClickable(true);
        RelativeLayout relativeLayout = new RelativeLayout(this.f11630b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.setBackgroundDrawable(getDefaultBackgroundDrawable());
        addView(relativeLayout, layoutParams);
        ImageView imageView = new ImageView(this.f11630b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b.a(this.f11630b, 160.0d), b.a(this.f11630b, 160.0d));
        layoutParams2.addRule(14);
        layoutParams2.setMargins(220, b.a(this.f11630b, 40.0d), 220, b.a(this.f11630b, 24.0d));
        imageView.setId(c.a());
        relativeLayout.addView(imageView, layoutParams2);
        Glide.with(imageView.getContext()).load(b.f11739d).into(imageView);
        TextView textView = new TextView(this.f11630b);
        if (TextUtils.isEmpty(this.f11631c)) {
            textView.setText("服务器异常");
        } else {
            textView.setText(this.f11631c);
        }
        textView.setTextColor(-2433050);
        textView.setTextSize(2, 18.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, imageView.getId());
        layoutParams3.addRule(14);
        textView.setId(c.a());
        relativeLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f11630b);
        if (TextUtils.isEmpty(this.f11632d)) {
            textView2.setText("未知错误\n请重启大屏和手机App后重试");
        } else {
            textView2.setText(this.f11632d);
        }
        textView2.setTextColor(-6972250);
        textView2.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, textView.getId());
        layoutParams4.setMargins(0, b.a(this.f11630b, 20.0d), 0, b.a(this.f11630b, 63.0d));
        textView2.setId(c.a());
        layoutParams4.addRule(14);
        textView2.setTextAlignment(4);
        relativeLayout.addView(textView2, layoutParams4);
        TextView textView3 = new TextView(this.f11630b);
        textView3.setText("知道了");
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FailView.this.b();
            }
        });
        textView3.setTextColor(-13395457);
        textView3.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, textView2.getId());
        layoutParams5.addRule(14);
        layoutParams5.setMargins(0, b.a(this.f11630b, 63.0d), 0, b.a(this.f11630b, 22.0d));
        relativeLayout.addView(textView3, layoutParams5);
    }

    public FailView(Context context, String str, String str2) {
        super(context);
        LeLog.i(f11629a, "FailView title:" + str + ", extra:" + str2);
        this.f11630b = context;
        this.f11631c = str;
        this.f11632d = str2;
        a();
    }

    public FailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11630b = context;
        a();
    }

    public FailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11630b = context;
        a();
    }
}
