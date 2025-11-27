package com.mobile.brasiltv.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import ba.s;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CreateOrderEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.Controller;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.webview.CommonParams;
import com.mobile.brasiltv.view.webview.ExtraJson;
import com.mobile.brasiltv.view.webview.LollipopFixedWebView;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d6;
import f5.e6;
import f5.f6;
import f5.g6;
import i6.d1;
import i6.e1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.q4;
import org.greenrobot.eventbus.ThreadMode;

public final class WebViewAty extends f5.d implements e1 {
    public static final a B = new a((t9.g) null);
    public static final String C = "bundleUrl";
    public static final String D = "show_back";
    public static final String E = "backToMain";
    public static final String F = "header";
    public static final String G = "extra_json";
    public static final String H = "follow_sersor";
    public static final String I = "bundle_enter_browser";
    public static final String J = "bundle_share_invitation_code";
    public static final String K = "bundle_dont_care_invite_code";
    public static final String L = "bundle_repay_payment_type";
    public static final String M = "bundle_not_override_url";
    public Map A = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public final String f6035l = "image/*";

    /* renamed from: m  reason: collision with root package name */
    public ValueCallback f6036m;

    /* renamed from: n  reason: collision with root package name */
    public ValueCallback f6037n;

    /* renamed from: o  reason: collision with root package name */
    public final int f6038o = 1;

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f6039p = h9.h.b(new l(this));

    /* renamed from: q  reason: collision with root package name */
    public final h9.g f6040q = h9.h.b(new f(this));

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f6041r = h9.h.b(new b(this));

    /* renamed from: s  reason: collision with root package name */
    public final h9.g f6042s = h9.h.b(new d(this));

    /* renamed from: t  reason: collision with root package name */
    public final h9.g f6043t = h9.h.b(new e(this));

    /* renamed from: u  reason: collision with root package name */
    public final h9.g f6044u = h9.h.b(new i(this));

    /* renamed from: v  reason: collision with root package name */
    public final h9.g f6045v = h9.h.b(new h(this));

    /* renamed from: w  reason: collision with root package name */
    public final h9.g f6046w = h9.h.b(new g(this));

    /* renamed from: x  reason: collision with root package name */
    public boolean f6047x;

    /* renamed from: y  reason: collision with root package name */
    public String f6048y = "";

    /* renamed from: z  reason: collision with root package name */
    public q4 f6049z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return WebViewAty.E;
        }

        public final String b() {
            return WebViewAty.I;
        }

        public final String c() {
            return WebViewAty.G;
        }

        public final String d() {
            return WebViewAty.H;
        }

        public final String e() {
            return WebViewAty.F;
        }

        public final String f() {
            return WebViewAty.M;
        }

        public final String g() {
            return WebViewAty.L;
        }

        public final String h() {
            return WebViewAty.J;
        }

        public final String i() {
            return WebViewAty.D;
        }

        public final String j() {
            return WebViewAty.C;
        }

        public final boolean k(Context context, String str) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(str, "url");
            if (!t.o(str, "urlOpen=out", false, 2, (Object) null) && !t.o(str, ".page.link", false, 2, (Object) null)) {
                return false;
            }
            b0.f0(context, str);
            return true;
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12255a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(WebViewAty webViewAty) {
            super(0);
            this.f12255a = webViewAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12255a.getIntent().getBooleanExtra(WebViewAty.B.a(), true));
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12256a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(WebViewAty webViewAty) {
            super(1);
            this.f12256a = webViewAty;
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "it");
            Intent putExtra = intent.putExtra(OrderConfirmAty.f12063m.a(), this.f12256a.f6048y);
            t9.i.f(putExtra, "it.putExtra(OrderConfirm…YMENT_TYPE, mPaymentType)");
            return putExtra;
        }
    }

    public static final class d extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12257a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(WebViewAty webViewAty) {
            super(0);
            this.f12257a = webViewAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12257a.getIntent().getBooleanExtra(WebViewAty.B.e(), true));
        }
    }

    public static final class e extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12258a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(WebViewAty webViewAty) {
            super(0);
            this.f12258a = webViewAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12258a.getIntent().getBooleanExtra(WebViewAty.B.b(), false));
        }
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12259a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(WebViewAty webViewAty) {
            super(0);
            this.f12259a = webViewAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12259a.getIntent().getBooleanExtra(WebViewAty.B.i(), false));
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12260a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(WebViewAty webViewAty) {
            super(0);
            this.f12260a = webViewAty;
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(this.f12260a.getIntent().getBooleanExtra(WebViewAty.B.f(), false));
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12261a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(WebViewAty webViewAty) {
            super(0);
            this.f12261a = webViewAty;
        }

        public final String invoke() {
            return this.f12261a.getIntent().getStringExtra(WebViewAty.B.g());
        }
    }

    public static final class i extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12262a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(WebViewAty webViewAty) {
            super(0);
            this.f12262a = webViewAty;
        }

        public final String invoke() {
            return this.f12262a.getIntent().getStringExtra(WebViewAty.B.h());
        }
    }

    public static final class j extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12263a = true;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12264b;

        public j(WebViewAty webViewAty) {
            this.f12264b = webViewAty;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
            if (ba.t.o(r4, r2, false, 2, (java.lang.Object) null) == true) goto L_0x007b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPageFinished(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "onPageFinished progress: "
                r8.append(r0)
                r0 = 0
                if (r7 == 0) goto L_0x0016
                int r1 = r7.getProgress()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x0017
            L_0x0016:
                r1 = r0
            L_0x0017:
                r8.append(r1)
                java.lang.String r1 = ", title: "
                r8.append(r1)
                if (r7 == 0) goto L_0x0026
                java.lang.String r1 = r7.getTitle()
                goto L_0x0027
            L_0x0026:
                r1 = r0
            L_0x0027:
                r8.append(r1)
                java.lang.String r8 = r8.toString()
                com.mobile.brasiltv.utils.b0.U(r6, r8)
                r8 = 1
                r1 = 0
                if (r7 == 0) goto L_0x003f
                int r2 = r7.getProgress()
                r3 = 100
                if (r2 != r3) goto L_0x003f
                r2 = 1
                goto L_0x0040
            L_0x003f:
                r2 = 0
            L_0x0040:
                if (r2 == 0) goto L_0x005d
                com.mobile.brasiltv.activity.WebViewAty r2 = r6.f12264b
                int r3 = com.mobile.brasiltv.R$id.atyWebView
                android.view.View r2 = r2.Y2(r3)
                com.mobile.brasiltv.view.webview.LollipopFixedWebView r2 = (com.mobile.brasiltv.view.webview.LollipopFixedWebView) r2
                if (r2 != 0) goto L_0x004f
                goto L_0x0052
            L_0x004f:
                r2.setVisibility(r1)
            L_0x0052:
                boolean r2 = r6.f12263a
                if (r2 == 0) goto L_0x005d
                r6.f12263a = r1
                com.mobile.brasiltv.activity.WebViewAty r2 = r6.f12264b
                r2.v3(r7)
            L_0x005d:
                if (r7 == 0) goto L_0x009f
                java.lang.String r2 = r7.getTitle()
                if (r2 == 0) goto L_0x009f
                com.mobile.brasiltv.activity.WebViewAty r3 = r6.f12264b
                java.lang.String r4 = r7.getUrl()
                if (r4 == 0) goto L_0x007a
                java.lang.String r5 = "url"
                t9.i.f(r4, r5)
                r5 = 2
                boolean r0 = ba.t.o(r4, r2, r1, r5, r0)
                if (r0 != r8) goto L_0x007a
                goto L_0x007b
            L_0x007a:
                r8 = 0
            L_0x007b:
                if (r8 == 0) goto L_0x008b
                int r7 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r7 = r3.Y2(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                java.lang.String r8 = " "
                r7.setText(r8)
                goto L_0x009f
            L_0x008b:
                int r8 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r8 = r3.Y2(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                java.lang.String r7 = r7.getTitle()
                if (r7 == 0) goto L_0x009a
                goto L_0x009c
            L_0x009a:
                java.lang.String r7 = ""
            L_0x009c:
                r8.setText(r7)
            L_0x009f:
                com.mobile.brasiltv.view.LoadingDialog$Companion r7 = com.mobile.brasiltv.view.LoadingDialog.Companion
                r7.hidden()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.WebViewAty.j.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            try {
                LoadingDialog.Companion.show(this.f12264b.getFragmentManager());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str;
            int i10;
            Uri a10;
            String host;
            Uri a11;
            String path;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            c2.d dVar = c2.d.f4594a;
            String str2 = "";
            if (webResourceRequest == null || (a11 = webResourceRequest.getUrl()) == null || (path = a11.getPath()) == null) {
                str = str2;
            } else {
                str = path;
            }
            if (!(webResourceRequest == null || (a10 = webResourceRequest.getUrl()) == null || (host = a10.getHost()) == null)) {
                str2 = host;
            }
            String a12 = a3.d.a(str2, a3.d.f162a);
            t9.i.f(a12, "encryption(request?.url?…\"\", DESUtils.MAC_DES_KEY)");
            if (webResourceResponse != null) {
                i10 = webResourceResponse.getStatusCode();
            } else {
                i10 = -1;
            }
            c2.d.e(dVar, elapsedRealtime, elapsedRealtime, str, a12, i10, na.e.f19079e, (HashMap) null, true, 64, (Object) null);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (this.f12264b.A3()) {
                return true;
            }
            if (str == null || !s.l(str, "tel:", false, 2, (Object) null)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.setFlags(268435456);
                this.f12264b.startActivity(intent);
                return false;
            }
            if (str == null || !s.l(str, "mailto:", false, 2, (Object) null)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse(str));
                this.f12264b.startActivity(intent2);
                return false;
            }
            if (str == null || !t.o(str, "alipays://platformapi", false, 2, (Object) null)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                return false;
            }
            if (!(str == null || webView == null)) {
                webView.loadUrl(str);
            }
            b0.U(this, "should override url loading and url: " + str);
            return true;
        }
    }

    public static final class k extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12265a;

        public k(WebViewAty webViewAty) {
            this.f12265a = webViewAty;
        }

        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            if (defaultVideoPoster == null) {
                return BitmapFactory.decodeResource(this.f12265a.Q1().getResources(), R.mipmap.ic_logo);
            }
            return defaultVideoPoster;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            t9.i.g(webView, "view");
            t9.i.g(str, "url");
            t9.i.g(str2, Constants.SHARED_MESSAGE_ID_FILE);
            t9.i.g(str3, "defaultValue");
            t9.i.g(jsPromptResult, "result");
            b0.U(this, "onJsPrompt:" + str2);
            jsPromptResult.confirm();
            return super.onJsPrompt(webView, str, str2, str2, jsPromptResult);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
            if (r3 == false) goto L_0x006b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceivedTitle(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                super.onReceivedTitle(r7, r8)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "onReceivedTitle title: "
                r0.append(r1)
                r1 = 0
                if (r7 == 0) goto L_0x0015
                java.lang.String r2 = r7.getTitle()
                goto L_0x0016
            L_0x0015:
                r2 = r1
            L_0x0016:
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.mobile.brasiltv.utils.b0.U(r6, r0)
                if (r8 == 0) goto L_0x0076
                com.mobile.brasiltv.activity.WebViewAty r0 = r6.f12265a
                java.lang.String r2 = "koocan.com"
                r3 = 0
                r4 = 2
                boolean r8 = ba.t.o(r8, r2, r3, r4, r1)
                java.lang.String r2 = " "
                if (r8 != 0) goto L_0x006b
                if (r7 == 0) goto L_0x0037
                java.lang.String r8 = r7.getTitle()
                goto L_0x0038
            L_0x0037:
                r8 = r1
            L_0x0038:
                if (r8 == 0) goto L_0x0056
                java.lang.String r8 = r7.getUrl()
                if (r8 == 0) goto L_0x0053
                java.lang.String r5 = "url"
                t9.i.f(r8, r5)
                java.lang.String r5 = r7.getTitle()
                t9.i.d(r5)
                boolean r8 = ba.t.o(r8, r5, r3, r4, r1)
                if (r8 != 0) goto L_0x0053
                r3 = 1
            L_0x0053:
                if (r3 != 0) goto L_0x0056
                goto L_0x006b
            L_0x0056:
                int r8 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r8 = r0.Y2(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                if (r7 == 0) goto L_0x0067
                java.lang.String r7 = r7.getTitle()
                if (r7 == 0) goto L_0x0067
                r2 = r7
            L_0x0067:
                r8.setText(r2)
                goto L_0x0076
            L_0x006b:
                int r7 = com.mobile.brasiltv.R$id.atyWebViewTitle
                android.view.View r7 = r0.Y2(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                r7.setText(r2)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.WebViewAty.k.onReceivedTitle(android.webkit.WebView, java.lang.String):void");
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            t9.i.g(webView, "webView");
            t9.i.g(fileChooserParams, "fileChooserParams");
            b0.U(this, "onShowFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture)");
            this.f12265a.f6037n = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(this.f12265a.f6035l);
            this.f12265a.startActivityForResult(Intent.createChooser(intent, "File Browser"), this.f12265a.f6038o);
            return true;
        }
    }

    public static final class l extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebViewAty f12266a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(WebViewAty webViewAty) {
            super(0);
            this.f12266a = webViewAty;
        }

        public final String invoke() {
            String stringExtra = this.f12266a.getIntent().getStringExtra(WebViewAty.B.j());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final void J3(WebViewAty webViewAty, String str, String str2, String str3, String str4, long j10) {
        t9.i.g(webViewAty, "this$0");
        b0.U(webViewAty, "DownloadListener: " + str);
        t9.i.f(str, "url");
        webViewAty.t3(str);
    }

    public static final void q3(WebViewAty webViewAty, View view) {
        t9.i.g(webViewAty, "this$0");
        webViewAty.onBackPressed();
    }

    public static final void r3(View view) {
    }

    public static final void s3(WebViewAty webViewAty, View view) {
        t9.i.g(webViewAty, "this$0");
        webViewAty.w3();
    }

    public final boolean A3() {
        return ((Boolean) this.f6046w.getValue()).booleanValue();
    }

    public final String B3() {
        return (String) this.f6045v.getValue();
    }

    public final String C3() {
        return (String) this.f6044u.getValue();
    }

    public final String D3() {
        return (String) this.f6039p.getValue();
    }

    public final boolean E3() {
        return ((Boolean) this.f6043t.getValue()).booleanValue();
    }

    public final void F3(int i10, int i11, Intent intent) {
        Uri[] uriArr;
        if (i10 == this.f6038o && this.f6037n != null) {
            if (i11 != -1 || intent == null) {
                uriArr = null;
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    int itemCount = clipData.getItemCount();
                    for (int i12 = 0; i12 < itemCount; i12++) {
                        uriArr[i12] = clipData.getItemAt(i12).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            }
            ValueCallback valueCallback = this.f6037n;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uriArr);
            }
            this.f6037n = null;
        }
    }

    public void G3(q4 q4Var) {
        t9.i.g(q4Var, "<set-?>");
        this.f6049z = q4Var;
    }

    /* renamed from: H3 */
    public void Y0(d1 d1Var) {
        t9.i.g(d1Var, "presenter");
    }

    public final void I3(String str) {
        t9.i.g(str, "url");
        b0.U(this, "h5 url: " + str);
        p3();
        int i10 = R$id.atyWebView;
        WebSettings settings = ((LollipopFixedWebView) Y2(i10)).getSettings();
        t9.i.f(settings, "atyWebView.settings");
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setSupportZoom(true);
        settings.setDomStorageEnabled(true);
        if (A3()) {
            settings.setBuiltInZoomControls(true);
        }
        ((LollipopFixedWebView) Y2(i10)).addJavascriptInterface(new Controller(this), "Controller");
        LollipopFixedWebView lollipopFixedWebView = (LollipopFixedWebView) Y2(i10);
        boolean E3 = E3();
        String C3 = C3();
        if (C3 == null) {
            C3 = "";
        }
        lollipopFixedWebView.addJavascriptInterface(new CommonParams(E3, C3), "xxl_pub");
        ((LollipopFixedWebView) Y2(i10)).addJavascriptInterface(new ExtraJson(getIntent().getStringExtra(G)), "xxl_extra");
        ((LollipopFixedWebView) Y2(i10)).setVerticalScrollBarEnabled(true);
        ((LollipopFixedWebView) Y2(i10)).setHorizontalScrollBarEnabled(true);
        ((LollipopFixedWebView) Y2(i10)).setWebViewClient(new j(this));
        ((LollipopFixedWebView) Y2(i10)).setWebChromeClient(new k(this));
        ((LollipopFixedWebView) Y2(i10)).setDownloadListener(new g6(this));
        ((LollipopFixedWebView) Y2(i10)).loadUrl(str);
    }

    public final void K3() {
        Intent intent = new Intent(this, MainAty.class);
        intent.putExtra(K, true);
        startActivity(intent);
        finish();
    }

    public void R2() {
        boolean z10;
        G3(new q4(this, this));
        String B3 = B3();
        if (B3 == null || B3.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f6047x = true;
            String B32 = B3();
            t9.i.d(B32);
            this.f6048y = B32;
        }
        int i10 = R$id.atyBack;
        ((ImageView) Y2(i10)).setVisibility(0);
        ((ImageView) Y2(i10)).setOnClickListener(new d6(this));
        ((ImageView) Y2(R$id.shareIcon)).setOnClickListener(new e6());
        ((ImageView) Y2(R$id.atyExit)).setOnClickListener(new f6(this));
        if (!y3()) {
            ((AutoRelativeLayout) Y2(R$id.atyWebViewHeader)).setVisibility(8);
        }
        if (getIntent().getBooleanExtra(H, false)) {
            setRequestedOrientation(10);
        }
        String D3 = D3();
        t9.i.f(D3, "url");
        I3(D3);
    }

    public int T2() {
        return R.layout.aty_webview;
    }

    public View Y2(int i10) {
        Map map = this.A;
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

    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        super.onActivityResult(i10, i11, intent);
        if (i10 != this.f6038o) {
            return;
        }
        if (this.f6036m != null || this.f6037n != null) {
            if (intent == null || i11 != -1) {
                uri = null;
            } else {
                uri = intent.getData();
            }
            if (this.f6037n != null) {
                F3(i10, i11, intent);
                return;
            }
            ValueCallback valueCallback = this.f6036m;
            if (valueCallback != null) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(uri);
                }
                this.f6036m = null;
            }
        }
    }

    public void onBackPressed() {
        if (this.f6047x) {
            u3();
            return;
        }
        int i10 = R$id.atyWebView;
        if (!((LollipopFixedWebView) Y2(i10)).canGoBack() || t9.i.b(((LollipopFixedWebView) Y2(i10)).getUrl(), D3())) {
            b0.U(this, "exit()");
            if (x3()) {
                K3();
                return;
            }
            setResult(10010, getIntent());
            finish();
            return;
        }
        ((LollipopFixedWebView) Y2(i10)).goBack();
        b0.U(this, "webView.goBack()");
    }

    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            getWindow().addFlags(1024);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(1024);
            return;
        }
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.flags |= 1024;
        getWindow().setAttributes(attributes2);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onEventCreateOrder(CreateOrderEvent createOrderEvent) {
        t9.i.g(createOrderEvent, "event");
        this.f6048y = createOrderEvent.getPaymentType();
        this.f6047x = true;
    }

    public void onPause() {
        ((LollipopFixedWebView) Y2(R$id.atyWebView)).onPause();
        super.onPause();
        LoadingDialog.Companion.hidden();
    }

    public void onResume() {
        super.onResume();
        ((LollipopFixedWebView) Y2(R$id.atyWebView)).onResume();
    }

    public final void p3() {
        String a10 = com.mobile.brasiltv.utils.e.a(this);
        Object b10 = n7.a.b(this, "clear_webview_cache_version", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        if (!t9.i.b((String) b10, a10)) {
            b0.U(this, "清除缓存");
            ((LollipopFixedWebView) Y2(R$id.atyWebView)).clearCache(true);
            n7.a.e(this, "clear_webview_cache_version", a10);
        }
    }

    public final void t3(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        if (getPackageManager().resolveActivity(intent, 0) != null) {
            startActivity(intent);
        }
    }

    public final void u3() {
        b0.d0(this, OrderConfirmAty.class, new c(this));
        this.f6047x = false;
        this.f6048y = "";
        finish();
    }

    public final void v3(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f})}).setDuration(250).start();
    }

    public final void w3() {
        b0.U(this, "exit()");
        if (this.f6047x) {
            u3();
        } else if (x3()) {
            K3();
        } else {
            setResult(10010, getIntent());
            finish();
        }
    }

    public final boolean x3() {
        return ((Boolean) this.f6041r.getValue()).booleanValue();
    }

    public final boolean y3() {
        return ((Boolean) this.f6042s.getValue()).booleanValue();
    }

    /* renamed from: z3 */
    public q4 S2() {
        q4 q4Var = this.f6049z;
        if (q4Var != null) {
            return q4Var;
        }
        t9.i.w("mPresenter");
        return null;
    }
}
