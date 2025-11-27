package com.mobile.brasiltv.activity;

import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.z0;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.d;
import f5.s2;
import i6.d0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.m1;
import na.f;
import t9.i;
import w6.i;

public final class PhoneBindSuccessAty extends d implements d0 {

    /* renamed from: l  reason: collision with root package name */
    public boolean f12085l;

    /* renamed from: m  reason: collision with root package name */
    public m1 f12086m;

    /* renamed from: n  reason: collision with root package name */
    public Map f12087n = new LinkedHashMap();

    public static final void X2(PhoneBindSuccessAty phoneBindSuccessAty) {
        i.g(phoneBindSuccessAty, "this$0");
        i.c cVar = w6.i.f9510g;
        if (t9.i.b(cVar.I(), "1")) {
            phoneBindSuccessAty.S2().m(cVar.t(), MemberInfo.INSTANCE.getLastPassword(), "3", cVar.f(), cVar.K(), true);
        } else {
            b0.c0(phoneBindSuccessAty, MainAty.class);
        }
    }

    public void R2() {
        a3(new m1(this, this));
        Z2();
        boolean booleanExtra = getIntent().getBooleanExtra("toLogin", true);
        this.f12085l = booleanExtra;
        if (booleanExtra) {
            ((TitleView) V2(R$id.titleView)).setAtyBackVisible(8);
            String b10 = z0.b(w6.i.f9510g.t(), f.e(this, "login_area_code"));
            ((TextView) V2(R$id.bindStatus)).setText(getResources().getString(R.string.phone_bind_success_notice1, new Object[]{b10}));
            ((TextView) V2(R$id.noticeText)).setVisibility(0);
            W2();
            return;
        }
        ((TextView) V2(R$id.bindStatus)).setText(getResources().getString(R.string.bind_phone_success));
        ((TextView) V2(R$id.noticeText)).setVisibility(8);
    }

    public int T2() {
        return R.layout.activity_phone_bind_success;
    }

    public View V2(int i10) {
        Map map = this.f12087n;
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

    public final void W2() {
        ((TextView) V2(R$id.bindStatus)).postDelayed(new s2(this), 2000);
    }

    /* renamed from: Y2 */
    public m1 S2() {
        m1 m1Var = this.f12086m;
        if (m1Var != null) {
            return m1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void Z2() {
        int i10 = R$id.titleView;
        ((TitleView) V2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) V2(i10)).getSettingView().setVisibility(8);
        ((TitleView) V2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) V2(i10)).setIvMenuSrc(0);
        ((TitleView) V2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) V2(i10)).setTvMenuText("");
    }

    public void a3(m1 m1Var) {
        t9.i.g(m1Var, "<set-?>");
        this.f12086m = m1Var;
    }

    public void k2() {
        n2();
    }

    public void onBackPressed() {
    }
}
