package com.mobile.brasiltv.mine.activity;

import android.content.DialogInterface;
import android.view.View;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.TitleBarView;
import com.mobile.brasiltv.view.setting.MenuItem;
import com.msandroid.mobile.R;
import e6.e1;
import e6.f1;
import e6.g1;
import e6.h1;
import f5.d;
import h9.t;
import i6.v0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.y3;
import t9.i;

public final class SettingAty extends d implements v0 {

    /* renamed from: l  reason: collision with root package name */
    public LoadingView f12399l;

    /* renamed from: m  reason: collision with root package name */
    public y3 f12400m;

    /* renamed from: n  reason: collision with root package name */
    public Map f12401n = new LinkedHashMap();

    public static final void Z2(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        settingAty.finish();
    }

    public static final void a3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        b0.c0(settingAty, NotificationSettingAty.class);
    }

    public static final void b3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        settingAty.S2().i();
    }

    public static final void c3(SettingAty settingAty, View view) {
        i.g(settingAty, "this$0");
        b0.c0(settingAty, AboutAty.class);
    }

    public void J(String str) {
        i.g(str, "versionName");
        ((MenuItem) Y2(R$id.mMiUpgrade)).setMenuInfo(str);
    }

    public void R0(boolean z10) {
        int i10;
        MenuItem menuItem = (MenuItem) Y2(R$id.mMiUpgrade);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        menuItem.setMenuFlagVisibility(i10);
    }

    public void R2() {
        e3(new y3(this, this));
        ((TitleBarView) Y2(R$id.mTbvTitle)).setOnBackClickListener(new e1(this));
        ((MenuItem) Y2(R$id.mMiNotify)).setOnClickListener(new f1(this));
        ((MenuItem) Y2(R$id.mMiUpgrade)).setOnClickListener(new g1(this));
        ((MenuItem) Y2(R$id.mMiAboutUs)).setOnClickListener(new h1(this));
    }

    public int T2() {
        return R.layout.aty_setting;
    }

    public View Y2(int i10) {
        Map map = this.f12401n;
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

    /* renamed from: d3 */
    public y3 S2() {
        y3 y3Var = this.f12400m;
        if (y3Var != null) {
            return y3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void e3(y3 y3Var) {
        i.g(y3Var, "<set-?>");
        this.f12400m = y3Var;
    }

    public void k2() {
        n2();
    }

    public void m0(String str) {
        i.g(str, Constant.KEY_STATUS);
        ((MenuItem) Y2(R$id.mMiNotify)).setMenuInfo(str);
    }

    public void onResume() {
        super.onResume();
        S2().h();
    }

    public void showLoading(boolean z10) {
        if (this.f12399l == null) {
            this.f12399l = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, (DialogInterface.OnDismissListener) null, 14, (Object) null);
            t tVar = t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f12399l;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f12399l;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }
}
