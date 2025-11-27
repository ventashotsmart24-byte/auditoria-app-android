package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import f5.c;
import f5.d;
import f5.o3;
import f5.p3;
import i6.l0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.s2;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class ResetPwdSucAty extends d implements l0 {

    /* renamed from: q  reason: collision with root package name */
    public static final a f12105q = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public boolean f12106l = true;

    /* renamed from: m  reason: collision with root package name */
    public final Handler f12107m = new Handler();

    /* renamed from: n  reason: collision with root package name */
    public final Runnable f12108n = new p3(this);

    /* renamed from: o  reason: collision with root package name */
    public s2 f12109o;

    /* renamed from: p  reason: collision with root package name */
    public Map f12110p = new LinkedHashMap();

    public static final class a {

        /* renamed from: com.mobile.brasiltv.activity.ResetPwdSucAty$a$a  reason: collision with other inner class name */
        public static final class C0185a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f12111a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0185a(boolean z10) {
                super(1);
                this.f12111a = z10;
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                Intent putExtra = intent.putExtra("extra_login_status", this.f12111a);
                i.f(putExtra, "it.putExtra(EXTRA_LOGIN_STATUS, isLogin)");
                return putExtra;
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(c cVar, boolean z10) {
            i.g(cVar, "activity");
            b0.d0(cVar, ResetPwdSucAty.class, new C0185a(z10));
        }
    }

    public static final void Y2(ResetPwdSucAty resetPwdSucAty, View view) {
        i.g(resetPwdSucAty, "this$0");
        resetPwdSucAty.X2();
    }

    public static final void a3(ResetPwdSucAty resetPwdSucAty) {
        i.g(resetPwdSucAty, "this$0");
        resetPwdSucAty.X2();
    }

    public void R2() {
        b3(new s2(this, this));
        this.f12106l = getIntent().getBooleanExtra("extra_login_status", true);
        int i10 = R$id.mTbvTitle;
        String string = getString(R.string.reset_successful);
        i.f(string, "getString(R.string.reset_successful)");
        ((TitleBarView) W2(i10)).setTitleText(string);
        ((TitleBarView) W2(i10)).isShowClose(false);
        ((TextView) W2(R$id.mTvHint)).setText(getString(R.string.pwd_reset_ok));
        ((TitleBarView) W2(i10)).setOnBackClickListener(new o3(this));
        this.f12107m.postDelayed(this.f12108n, 5000);
    }

    public int T2() {
        return R.layout.aty_reset_pwd_suc;
    }

    public View W2(int i10) {
        Map map = this.f12110p;
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

    public final void X2() {
        if (this.f12106l) {
            b0.c0(this, MainAty.class);
            return;
        }
        b0.c0(this, LoginAty.class);
        finish();
    }

    /* renamed from: Z2 */
    public s2 S2() {
        s2 s2Var = this.f12109o;
        if (s2Var != null) {
            return s2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void b3(s2 s2Var) {
        i.g(s2Var, "<set-?>");
        this.f12109o = s2Var;
    }

    public void k2() {
        n2();
    }

    public void onBackPressed() {
        X2();
    }

    public void onDestroy() {
        this.f12107m.removeCallbacks(this.f12108n);
        super.onDestroy();
    }
}
