package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.common.log.LeLog;
import com.hpplay.glide.Glide;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.b.c;
import com.hpplay.sdk.source.browser.d;
import com.mobile.brasiltv.view.RoundedDrawable;

public class NetWorkView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11678a = "NetWorkView";

    /* renamed from: b  reason: collision with root package name */
    private Context f11679b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f11680c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f11681d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f11682e;

    /* renamed from: f  reason: collision with root package name */
    private d f11683f;

    /* renamed from: g  reason: collision with root package name */
    private WebViewClient f11684g = new WebViewClient() {
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            LeLog.i(NetWorkView.f11678a, "onReceivedError error:" + webResourceError.getDescription() + webResourceError.getErrorCode());
            NetWorkView.this.a();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f11685h = new View.OnClickListener() {
        public void onClick(View view) {
            NetWorkView.this.e();
        }
    };

    public NetWorkView(Context context) {
        super(context);
        this.f11679b = context;
        d();
    }

    private void d() {
        setBackgroundColor(-1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f11679b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout.setId(c.a());
        addView(relativeLayout, layoutParams);
        ImageView imageView = new ImageView(this.f11679b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(b.a(this.f11679b, 50.0d), b.a(this.f11679b, 50.0d));
        layoutParams2.setMargins(b.b(this.f11679b, 28.0d), b.b(this.f11679b, 24.0d), b.b(this.f11679b, 28.0d), b.b(this.f11679b, 24.0d));
        Glide.with(this.f11679b).load(b.f11741f).into(imageView);
        relativeLayout.addView(imageView, layoutParams2);
        imageView.setClickable(true);
        imageView.setOnClickListener(this.f11685h);
        TextView textView = new TextView(this.f11679b);
        textView.setText("投屏帮助");
        textView.setOnClickListener(this.f11685h);
        textView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        textView.setTextSize(2, 18.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        relativeLayout.addView(textView, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f11679b);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, relativeLayout.getId());
        layoutParams4.addRule(13);
        addView(relativeLayout2, layoutParams4);
        this.f11680c = b();
        relativeLayout2.addView(this.f11680c, new RelativeLayout.LayoutParams(-1, -1));
        this.f11681d = c();
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        relativeLayout2.addView(this.f11681d, layoutParams5);
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    /* access modifiers changed from: private */
    public void e() {
        LeLog.i(f11678a, "destroyView");
        d dVar = this.f11683f;
        if (dVar != null) {
            dVar.a();
        }
    }

    private GradientDrawable getDefaultBackgroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-15107585);
        gradientDrawable.setCornerRadius(30.0f);
        return gradientDrawable;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        e();
        return true;
    }

    public void setCallback(d dVar) {
        this.f11683f = dVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        WebView webView = this.f11680c;
        if (webView != null) {
            webView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f11681d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private WebView b() {
        try {
            com.hpplay.sdk.source.browser.b.d.a();
            WebView webView = new WebView(this.f11679b);
            this.f11680c = webView;
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setAppCacheEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadsImagesAutomatically(true);
        } catch (Exception e10) {
            LeLog.w(f11678a, (Throwable) e10);
        }
        return this.f11680c;
    }

    private RelativeLayout c() {
        setClickable(true);
        this.f11681d = new RelativeLayout(this.f11679b);
        ImageView imageView = new ImageView(this.f11679b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b.a(this.f11679b, 160.0d), b.a(this.f11679b, 160.0d));
        layoutParams.addRule(14);
        imageView.setId(c.a());
        this.f11681d.addView(imageView, layoutParams);
        Glide.with(this.f11679b).load(b.f11745j).into(imageView);
        TextView textView = new TextView(this.f11679b);
        textView.setText("网络异常，请检查你的网络");
        textView.setTextColor(-14868961);
        textView.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, imageView.getId());
        layoutParams2.setMargins(0, b.a(this.f11679b, 24.0d), 0, b.a(this.f11679b, 24.0d));
        layoutParams2.addRule(14);
        textView.setId(c.a());
        this.f11681d.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.f11679b);
        textView2.setText("点击重试");
        textView2.setBackgroundDrawable(getDefaultBackgroundDrawable());
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 16.0f);
        textView2.setPadding(b.a(this.f11679b, 48.0d), b.a(this.f11679b, 18.0d), b.a(this.f11679b, 48.0d), b.a(this.f11679b, 18.0d));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, textView.getId());
        layoutParams3.addRule(14);
        this.f11681d.addView(textView2, layoutParams3);
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NetWorkView netWorkView = NetWorkView.this;
                netWorkView.a(netWorkView.f11682e);
            }
        });
        return this.f11681d;
    }

    public NetWorkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11679b = context;
        d();
    }

    public void a(String str) {
        RelativeLayout relativeLayout = this.f11681d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        WebView webView = this.f11680c;
        if (webView != null) {
            this.f11682e = str;
            webView.loadUrl(str);
            this.f11680c.setWebViewClient(this.f11684g);
            this.f11680c.setVisibility(0);
        }
    }

    public NetWorkView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11679b = context;
        d();
    }
}
