package com.mobile.brasiltv.mine.activity;

import a6.f;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.EmailManagerAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.login.LoginButton;
import com.msandroid.mobile.R;
import e6.k;
import e6.m;
import f5.d;
import h9.t;
import i6.c;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class AccountBindAty extends d implements c, z7.a {

    /* renamed from: r  reason: collision with root package name */
    public static final a f12277r = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public boolean f12278l = true;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f12279m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f12280n;

    /* renamed from: o  reason: collision with root package name */
    public z7.b f12281o;

    /* renamed from: p  reason: collision with root package name */
    public k6.b f12282p;

    /* renamed from: q  reason: collision with root package name */
    public Map f12283q = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12284a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    public static final void d3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        accountBindAty.onBackPressed();
    }

    public static final void e3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        b0.d0(accountBindAty, WebViewAty.class, b.f12284a);
    }

    public static final void f3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        if (!f.f10686a.a()) {
            accountBindAty.n(R.string.try_other_bind_method);
        } else {
            accountBindAty.b3();
        }
    }

    public static final void g3(AccountBindAty accountBindAty, View view) {
        i.g(accountBindAty, "this$0");
        if (b0.T(w6.i.f9510g.h(), "0")) {
            b0.c0(accountBindAty, EmailAty.class);
        } else {
            b0.c0(accountBindAty, EmailManagerAty.class);
        }
    }

    public static final void j3(AccountBindAty accountBindAty, DialogInterface dialogInterface) {
        i.g(accountBindAty, "this$0");
        accountBindAty.f12279m = null;
    }

    public void R2() {
        i3(new k6.b(this, this));
        h3();
        c3();
    }

    public void S0(int i10, x7.a aVar) {
        String str;
        i.g(aVar, "info");
        if (i10 == 1) {
            str = "google";
        } else {
            str = "facebook";
        }
        S2().j(str, aVar);
    }

    public int T2() {
        return R.layout.aty_account_bind;
    }

    public View Z2(int i10) {
        Map map = this.f12283q;
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

    /* renamed from: a3 */
    public k6.b S2() {
        k6.b bVar = this.f12282p;
        if (bVar != null) {
            return bVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void b3() {
        if (this.f12281o == null) {
            w7.a aVar = w7.a.f19762a;
            String string = getResources().getString(R.string.server_client_id);
            i.f(string, "resources.getString(R.string.server_client_id)");
            z7.b a10 = aVar.a(this, 1, string);
            this.f12281o = a10;
            if (a10 != null) {
                a10.b(this);
            }
        }
        z7.b bVar = this.f12281o;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    public final void c3() {
        ((TitleBarView) Z2(R$id.mTbvTitle)).setOnBackClickListener(new e6.j(this));
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setOnClickListener(new k(this));
        ((LoginButton) Z2(R$id.mLbGoogleBind)).setOnClickListener(new e6.l(this));
        ((LoginButton) Z2(R$id.mLbEmailBind)).setOnClickListener(new m(this));
    }

    public final void h3() {
        int i10;
        String str;
        this.f12278l = getIntent().getBooleanExtra("can_back", true);
        TitleBarView titleBarView = (TitleBarView) Z2(R$id.mTbvTitle);
        if (this.f12278l) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        titleBarView.setBackVisibility(i10);
        if (!f.f10686a.a()) {
            ((LoginButton) Z2(R$id.mLbGoogleBind)).setVisibility(8);
        }
        if (i.b(s6.a.f9335a.a().b(), "1")) {
            str = "#3cd977";
        } else {
            str = "#FFFEFE";
        }
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setText(Html.fromHtml(getResources().getString(R.string.account_bind_privacy_prefix) + " <font color=\"" + str + "\"><u>(" + getResources().getString(R.string.privacy_policy) + ")</u></font>"));
    }

    public void i3(k6.b bVar) {
        i.g(bVar, "<set-?>");
        this.f12282p = bVar;
    }

    public void k2() {
        n2();
    }

    public void n(int i10) {
        String string = getResources().getString(i10);
        i.f(string, "resources.getString(resId)");
        z0(string);
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        z7.b bVar = this.f12281o;
        if (bVar != null) {
            bVar.e(i10, i11, intent);
        }
    }

    public void onBackPressed() {
        if (this.f12278l && !this.f12280n) {
            super.onBackPressed();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BlackListDialog L2 = L2();
        if (L2 != null) {
            L2.dismiss();
        }
        h3();
    }

    public void p1(int i10, y7.b bVar) {
        i.g(bVar, "exception");
        if (bVar.a()) {
            String string = getResources().getString(R.string.account_bind_timeout);
            i.f(string, "resources.getString(R.string.account_bind_timeout)");
            z0(string);
        } else if (bVar.b()) {
            String string2 = getResources().getString(R.string.g_unsupport_google_service);
            i.f(string2, "resources.getString(R.st…unsupport_google_service)");
            z0(string2);
        }
    }

    public void q() {
        z7.b bVar = this.f12281o;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    public void showLoading(boolean z10) {
        if (this.f12279m == null) {
            this.f12279m = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new e6.i(this), 6, (Object) null);
            t tVar = t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f12279m;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f12279m;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    public void t(boolean z10) {
        ((LoginButton) Z2(R$id.mLbGoogleBind)).setClickable(!z10);
        ((LoginButton) Z2(R$id.mLbEmailBind)).setClickable(!z10);
        ((TextView) Z2(R$id.mTvPrivacyPolicy)).setClickable(!z10);
        this.f12280n = z10;
    }
}
