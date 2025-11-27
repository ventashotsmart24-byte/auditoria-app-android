package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.y;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import e6.o0;
import e6.p0;
import f5.d;
import h6.b;
import h6.c;
import i6.x;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.e1;
import t9.g;
import t9.i;

public final class MyBenefitsAty extends d implements x {

    /* renamed from: r  reason: collision with root package name */
    public static final a f12342r = new a((g) null);

    /* renamed from: l  reason: collision with root package name */
    public e1 f12343l;

    /* renamed from: m  reason: collision with root package name */
    public c f12344m;

    /* renamed from: n  reason: collision with root package name */
    public b f12345n;

    /* renamed from: o  reason: collision with root package name */
    public final String f12346o = "tag_exchange";

    /* renamed from: p  reason: collision with root package name */
    public final String f12347p = "tag_coupons";

    /* renamed from: q  reason: collision with root package name */
    public Map f12348q = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            if ((i11 & 4) != 0) {
                z10 = false;
            }
            aVar.a(context, i10, z10);
        }

        public final void a(Context context, int i10, boolean z10) {
            i.g(context, f.X);
            Intent intent = new Intent(context, MyBenefitsAty.class);
            intent.putExtra("page_index_key", i10);
            intent.putExtra("isOpenInHome", z10);
            context.startActivity(intent);
        }
    }

    public static final void X2(MyBenefitsAty myBenefitsAty, View view) {
        i.g(myBenefitsAty, "this$0");
        myBenefitsAty.c3(0);
    }

    public static final void Y2(MyBenefitsAty myBenefitsAty, View view) {
        i.g(myBenefitsAty, "this$0");
        myBenefitsAty.c3(1);
        v5.g.f19670a.r();
        myBenefitsAty.W2(R$id.mVCouponDot).setVisibility(8);
    }

    public void R2() {
        b3(new e1(this, this));
        this.f12344m = (c) getSupportFragmentManager().h0(this.f12346o);
        this.f12345n = (b) getSupportFragmentManager().h0(this.f12347p);
        c3(getIntent().getIntExtra("page_index_key", 0));
        ((TextView) W2(R$id.mTvExchangeCode)).setOnClickListener(new o0(this));
        int i10 = R$id.mArlCoupon;
        ((AutoRelativeLayout) W2(i10)).setOnClickListener(new p0(this));
        if (v5.g.f19670a.l() != 0) {
            W2(R$id.mVCouponDot).setVisibility(0);
        }
        if (getIntent().getBooleanExtra("isOpenInHome", false)) {
            ((AutoRelativeLayout) W2(i10)).performClick();
        }
    }

    public int T2() {
        return R.layout.aty_my_benefits;
    }

    public View W2(int i10) {
        Map map = this.f12348q;
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

    /* renamed from: Z2 */
    public e1 S2() {
        e1 e1Var = this.f12343l;
        if (e1Var != null) {
            return e1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void a3(y yVar) {
        c cVar = this.f12344m;
        if (cVar != null) {
            yVar.o(cVar);
        }
        b bVar = this.f12345n;
        if (bVar != null) {
            yVar.o(bVar);
        }
    }

    public void b3(e1 e1Var) {
        i.g(e1Var, "<set-?>");
        this.f12343l = e1Var;
    }

    public final void c3(int i10) {
        y m10 = getSupportFragmentManager().m();
        i.f(m10, "supportFragmentManager.beginTransaction()");
        a3(m10);
        if (i10 == 0) {
            ((TextView) W2(R$id.mTvExchangeCode)).setSelected(true);
            ((TextView) W2(R$id.mTvCoupons)).setSelected(false);
            c cVar = this.f12344m;
            if (cVar == null) {
                c cVar2 = new c();
                this.f12344m = cVar2;
                i.d(cVar2);
                m10.c(R.id.mFlContent, cVar2, this.f12346o);
            } else {
                i.d(cVar);
                m10.u(cVar);
            }
        } else if (i10 == 1) {
            ((TextView) W2(R$id.mTvExchangeCode)).setSelected(false);
            ((TextView) W2(R$id.mTvCoupons)).setSelected(true);
            b bVar = this.f12345n;
            if (bVar == null) {
                this.f12345n = new b();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isOpenInHome", getIntent().getBooleanExtra("isOpenInHome", false));
                b bVar2 = this.f12345n;
                i.e(bVar2, "null cannot be cast to non-null type com.mobile.brasiltv.fragment.BaseDaggerFrag<*>");
                bVar2.setArguments(bundle);
                b bVar3 = this.f12345n;
                i.d(bVar3);
                m10.c(R.id.mFlContent, bVar3, this.f12347p);
            } else {
                i.d(bVar);
                m10.u(bVar);
            }
        }
        m10.h();
    }

    public void k2() {
        n2();
    }
}
