package com.mobile.brasiltv.activity;

import android.view.View;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import b6.m3;
import com.flyco.tablayout.SlidingTabLayout;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.dialog.DeleteMsgDialog;
import com.msandroid.mobile.R;
import f5.d;
import f5.i1;
import f5.j1;
import f5.k1;
import f5.t0;
import g5.a1;
import i6.w;
import i9.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.d1;
import t9.i;
import v5.g;
import w5.m;

public final class MsgBoxAty extends d implements w, t0 {

    /* renamed from: l  reason: collision with root package name */
    public d1 f12043l;

    /* renamed from: m  reason: collision with root package name */
    public m3 f12044m;

    /* renamed from: n  reason: collision with root package name */
    public b6.d f12045n;

    /* renamed from: o  reason: collision with root package name */
    public Map f12046o = new LinkedHashMap();

    public static final class a implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MsgBoxAty f12047a;

        public a(MsgBoxAty msgBoxAty) {
            this.f12047a = msgBoxAty;
        }

        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
            g.f19670a.w(0);
            this.f12047a.f3();
        }
    }

    public static final void Z2(MsgBoxAty msgBoxAty, View view) {
        i.g(msgBoxAty, "this$0");
        msgBoxAty.finish();
    }

    public static final void a3(MsgBoxAty msgBoxAty, View view) {
        i.g(msgBoxAty, "this$0");
        msgBoxAty.d3();
    }

    public static final void e3(MsgBoxAty msgBoxAty, View view) {
        i.g(msgBoxAty, "this$0");
        if (((ViewPager) msgBoxAty.X2(R$id.mVpContent)).getCurrentItem() == 0) {
            msgBoxAty.S2().h(m.f19701a.J());
        } else {
            msgBoxAty.S2().h(m.f19701a.D());
        }
    }

    public void J1(String str) {
        b6.d dVar;
        i.g(str, "messageType");
        m mVar = m.f19701a;
        if (i.b(str, mVar.J())) {
            m3 m3Var = this.f12044m;
            if (m3Var != null) {
                m3Var.j3();
            }
        } else if (i.b(str, mVar.D()) && (dVar = this.f12045n) != null) {
            dVar.j3();
        }
    }

    public void R2() {
        c3(new d1(this, this));
        int i10 = R$id.mTbvTitle;
        ((TitleBarView) X2(i10)).setMenuVisibility(8);
        ((TitleBarView) X2(i10)).setOnBackClickListener(new i1(this));
        ((TitleBarView) X2(i10)).setOnMenuClickListener(new j1(this));
        m3 m3Var = new m3();
        this.f12044m = m3Var;
        m3Var.s3(this);
        b6.d dVar = new b6.d();
        this.f12045n = dVar;
        dVar.s3(this);
        m3 m3Var2 = this.f12044m;
        i.d(m3Var2);
        b6.d dVar2 = this.f12045n;
        i.d(dVar2);
        List h10 = j.h(m3Var2, dVar2);
        String string = getResources().getString(R.string.msg_box_system);
        i.f(string, "resources.getString(R.string.msg_box_system)");
        String string2 = getResources().getString(R.string.msg_box_activity);
        i.f(string2, "resources.getString(R.string.msg_box_activity)");
        List h11 = j.h(string, string2);
        int i11 = R$id.mVpContent;
        o supportFragmentManager = getSupportFragmentManager();
        i.f(supportFragmentManager, "supportFragmentManager");
        ((ViewPager) X2(i11)).setAdapter(new a1(h10, h11, supportFragmentManager));
        ((SlidingTabLayout) X2(R$id.mStlMsgTab)).setViewPager((ViewPager) X2(i11));
        ((ViewPager) X2(i11)).addOnPageChangeListener(new a(this));
    }

    public void T(int i10) {
        b0.U(this, "empty msg list");
        if (i10 == ((ViewPager) X2(R$id.mVpContent)).getCurrentItem()) {
            ((TitleBarView) X2(R$id.mTbvTitle)).setMenuVisibility(8);
        }
    }

    public int T2() {
        return R.layout.aty_msg_box;
    }

    public View X2(int i10) {
        Map map = this.f12046o;
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

    /* renamed from: b3 */
    public d1 S2() {
        d1 d1Var = this.f12043l;
        if (d1Var != null) {
            return d1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void c1(int i10) {
        b0.U(this, "find msg list");
        if (i10 == ((ViewPager) X2(R$id.mVpContent)).getCurrentItem()) {
            ((TitleBarView) X2(R$id.mTbvTitle)).setMenuVisibility(0);
        }
    }

    public void c3(d1 d1Var) {
        i.g(d1Var, "<set-?>");
        this.f12043l = d1Var;
    }

    public final void d3() {
        String str;
        if (((ViewPager) X2(R$id.mVpContent)).getCurrentItem() == 0) {
            str = getString(R.string.msg_box_delete_sys_msg);
        } else {
            str = getString(R.string.msg_box_delete_event_msg);
        }
        i.f(str, "if (mVpContent.currentIt…lete_event_msg)\n        }");
        new DeleteMsgDialog(this, str).setConfirmListener(new k1(this)).show();
    }

    public final void f3() {
        g gVar = g.f19670a;
        int n10 = gVar.n();
        if (n10 >= 100) {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).showNumMsg(0, "99+");
        } else if (n10 > 0) {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).showNumMsg(0, String.valueOf(n10));
        } else {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).hideMsg(0);
        }
        int k10 = gVar.k();
        if (k10 >= 100) {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).showNumMsg(1, "99+");
        } else if (k10 > 0) {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).showNumMsg(1, String.valueOf(k10));
        } else {
            ((SlidingTabLayout) X2(R$id.mStlMsgTab)).hideMsg(1);
        }
    }

    public void k2() {
        n2();
    }

    public void onDestroy() {
        m3 m3Var = this.f12044m;
        if (m3Var != null) {
            m3Var.s3((t0) null);
        }
        b6.d dVar = this.f12045n;
        if (dVar != null) {
            dVar.s3((t0) null);
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        f3();
    }

    public void showLoading(boolean z10) {
        O2(z10);
    }
}
