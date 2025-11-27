package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CloseBindEmailSucEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.mine.activity.AccountAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import d6.b;
import f5.d;
import f5.e;
import f5.f;
import f5.h;
import i6.i;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.p;
import s9.l;
import t9.g;
import t9.j;
import xa.c;

public final class BindEmailSucAty extends d implements i {

    /* renamed from: r  reason: collision with root package name */
    public static final a f11956r = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public final Handler f11957l = new Handler();

    /* renamed from: m  reason: collision with root package name */
    public Runnable f11958m = new f5.g(this);

    /* renamed from: n  reason: collision with root package name */
    public Runnable f11959n = new h(this);

    /* renamed from: o  reason: collision with root package name */
    public Runnable f11960o = new f5.i(this);

    /* renamed from: p  reason: collision with root package name */
    public p f11961p;

    /* renamed from: q  reason: collision with root package name */
    public Map f11962q = new LinkedHashMap();

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.BindEmailSucAty$a$a  reason: collision with other inner class name */
        public static final class C0184a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0184a f11963a = new C0184a();

            public C0184a() {
                super(1);
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", false);
                intent.putExtra("extra_email", "");
                intent.putExtra("extra_return_account_page", false);
                intent.putExtra("extra_return_home_page", false);
                Intent putExtra = intent.putExtra("extra_change_email", false);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, false)");
                return putExtra;
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f11964a = new b();

            public b() {
                super(1);
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", false);
                intent.putExtra("extra_email", "");
                intent.putExtra("extra_return_account_page", false);
                intent.putExtra("extra_return_home_page", false);
                Intent putExtra = intent.putExtra("extra_change_email", true);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, true)");
                return putExtra;
            }
        }

        public static final class c extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f11965a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f11966b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f11967c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ boolean f11968d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(boolean z10, String str, boolean z11, boolean z12) {
                super(1);
                this.f11965a = z10;
                this.f11966b = str;
                this.f11967c = z11;
                this.f11968d = z12;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("extra_show_email", this.f11965a);
                intent.putExtra("extra_email", this.f11966b);
                intent.putExtra("extra_return_account_page", this.f11967c);
                intent.putExtra("extra_return_home_page", this.f11968d);
                Intent putExtra = intent.putExtra("extra_change_email", false);
                t9.i.f(putExtra, "it.putExtra(EXTRA_CHANGE_EMAIL, false)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(f5.c cVar) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, BindEmailSucAty.class, C0184a.f11963a);
        }

        public final void b(f5.c cVar) {
            t9.i.g(cVar, "activity");
            b0.d0(cVar, BindEmailSucAty.class, b.f11964a);
        }

        public final void c(f5.c cVar, boolean z10, String str, boolean z11, boolean z12) {
            t9.i.g(cVar, "activity");
            t9.i.g(str, Scopes.EMAIL);
            b0.d0(cVar, BindEmailSucAty.class, new c(z10, str, z11, z12));
        }
    }

    public static final void b3(BindEmailSucAty bindEmailSucAty, View view) {
        t9.i.g(bindEmailSucAty, "this$0");
        bindEmailSucAty.a3();
    }

    public static final void c3(BindEmailSucAty bindEmailSucAty, View view) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new GotoHomeTabEvent(2));
        b0.c0(bindEmailSucAty, MainAty.class);
    }

    public static final void e3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new CloseBindEmailSucEvent());
        b0.c0(bindEmailSucAty, AccountAty.class);
        bindEmailSucAty.finish();
    }

    public static final void f3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        b0.c0(bindEmailSucAty, MainAty.class);
        bindEmailSucAty.finish();
    }

    public static final void g3(BindEmailSucAty bindEmailSucAty) {
        t9.i.g(bindEmailSucAty, "this$0");
        c.c().j(new CloseBindEmailSucEvent());
        b bVar = b.f6366a;
        bVar.E(bindEmailSucAty.Q1(), "");
        bVar.I(bindEmailSucAty.Q1(), "", "");
        LoginAty.C.a(bindEmailSucAty, false, true);
        bindEmailSucAty.finish();
    }

    public void R2() {
        h3(new p(this, this));
        boolean booleanExtra = getIntent().getBooleanExtra("extra_show_email", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("extra_return_account_page", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("extra_return_home_page", false);
        boolean booleanExtra4 = getIntent().getBooleanExtra("extra_change_email", false);
        if (booleanExtra2) {
            this.f11957l.postDelayed(this.f11959n, 5000);
        } else if (booleanExtra3) {
            this.f11957l.postDelayed(this.f11960o, 5000);
        } else if (booleanExtra4 && b.f6366a.s(this, "2")) {
            this.f11957l.postDelayed(this.f11958m, 5000);
        }
        if (booleanExtra) {
            String stringExtra = getIntent().getStringExtra("extra_email");
            if (stringExtra == null) {
                stringExtra = "";
            }
            Resources resources = getResources();
            ((TextView) Z2(R$id.mTvHint)).setText(Html.fromHtml(resources.getString(R.string.be_bind_suc_and_keep_pwd, new Object[]{"<font color=\"#3cd977\">" + stringExtra + "</font>"})));
        } else {
            ((TextView) Z2(R$id.mTvHint)).setText(getResources().getString(R.string.be_bind_suc_and_login));
        }
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) Z2(i10)).setOnBackClickListener(new e(this));
        ((TitleBarView) Z2(i10)).setOnCloseClickListener(new f(this));
    }

    public int T2() {
        return R.layout.aty_bind_email_suc;
    }

    public View Z2(int i10) {
        Map map = this.f11962q;
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

    public final void a3() {
        boolean booleanExtra = getIntent().getBooleanExtra("extra_return_account_page", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("extra_return_home_page", false);
        boolean booleanExtra3 = getIntent().getBooleanExtra("extra_change_email", false);
        c.c().j(new CloseBindEmailSucEvent());
        if (booleanExtra) {
            b0.c0(this, AccountAty.class);
        } else if (booleanExtra2) {
            b0.c0(this, MainAty.class);
        } else if (booleanExtra3) {
            b bVar = b.f6366a;
            if (bVar.s(this, "2")) {
                bVar.E(Q1(), "");
                bVar.I(Q1(), "", "");
                LoginAty.C.a(this, false, true);
            }
        }
        finish();
    }

    /* renamed from: d3 */
    public p S2() {
        p pVar = this.f11961p;
        if (pVar != null) {
            return pVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public void h3(p pVar) {
        t9.i.g(pVar, "<set-?>");
        this.f11961p = pVar;
    }

    public void k2() {
        n2();
    }

    public void onBackPressed() {
        a3();
    }

    public void onDestroy() {
        this.f11957l.removeCallbacks(this.f11959n);
        this.f11957l.removeCallbacks(this.f11960o);
        this.f11957l.removeCallbacks(this.f11958m);
        super.onDestroy();
    }
}
