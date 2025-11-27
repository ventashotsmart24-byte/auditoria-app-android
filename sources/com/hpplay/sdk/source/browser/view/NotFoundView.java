package com.hpplay.sdk.source.browser.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.glide.Glide;
import com.hpplay.sdk.source.browser.b;
import com.hpplay.sdk.source.browser.b.a;

public class NotFoundView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11689a = "NotFoundView";

    /* renamed from: b  reason: collision with root package name */
    private Context f11690b;

    /* renamed from: c  reason: collision with root package name */
    private b f11691c;

    public NotFoundView(Context context) {
        super(context);
        this.f11690b = context;
        a();
    }

    private boolean b() {
        Context context = this.f11690b;
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f11691c.a(a.f11612d);
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-14868961);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public void setCallback(b bVar) {
        this.f11691c = bVar;
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this.f11690b);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        ImageView imageView = new ImageView(this.f11690b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 160.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 160.0d));
        layoutParams2.gravity = 1;
        linearLayout.addView(imageView, layoutParams2);
        if (!b()) {
            Glide.with(this.f11690b).load(b.f11743h).into(imageView);
        }
        TextView textView = new TextView(this.f11690b);
        textView.setText("未搜索到想要的设备？");
        textView.setTextColor(-1);
        textView.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 24.0d), 0, com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 42.0d));
        layoutParams3.gravity = 1;
        linearLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f11690b);
        textView2.setText("查看详情");
        textView2.setBackgroundDrawable(getDefaultBackgroundDrawable());
        textView2.setTextColor(-13395457);
        textView2.setTextSize(2, 16.0f);
        textView2.setPadding(com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 18.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 48.0d), com.hpplay.sdk.source.browser.b.b.a(this.f11690b, 18.0d));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        linearLayout.addView(textView2, layoutParams4);
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NotFoundView.this.c();
            }
        });
    }

    public NotFoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11690b = context;
        a();
    }

    public NotFoundView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11690b = context;
        a();
    }
}
