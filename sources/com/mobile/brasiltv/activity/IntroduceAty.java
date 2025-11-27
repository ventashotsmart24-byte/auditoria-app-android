package com.mobile.brasiltv.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.e;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import f5.c;
import f5.u0;
import g5.i0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class IntroduceAty extends c {

    /* renamed from: q  reason: collision with root package name */
    public static final a f12015q = new a((g) null);

    /* renamed from: r  reason: collision with root package name */
    public static final String f12016r = "key_introduce_type";

    /* renamed from: s  reason: collision with root package name */
    public static final String f12017s = "value_first_install";

    /* renamed from: t  reason: collision with root package name */
    public static final String f12018t = "value_upgrade_app";

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f12019k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public i0 f12020l;

    /* renamed from: m  reason: collision with root package name */
    public final Integer[] f12021m;

    /* renamed from: n  reason: collision with root package name */
    public final Integer[] f12022n;

    /* renamed from: o  reason: collision with root package name */
    public final Integer[] f12023o;

    /* renamed from: p  reason: collision with root package name */
    public Map f12024p = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IntroduceAty f12025a;

        public b(IntroduceAty introduceAty) {
            this.f12025a = introduceAty;
        }

        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
            IntroduceAty introduceAty = this.f12025a;
            int i11 = R$id.mLayoutPoint;
            if (i10 <= ((LinearLayout) introduceAty.S2(i11)).getChildCount()) {
                ((LinearLayout) this.f12025a.S2(i11)).getChildAt(i10).setSelected(true);
                int childCount = ((LinearLayout) this.f12025a.S2(i11)).getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    if (i12 != i10) {
                        ((LinearLayout) this.f12025a.S2(R$id.mLayoutPoint)).getChildAt(i12).setSelected(false);
                    }
                }
                IntroduceAty introduceAty2 = this.f12025a;
                ((TextView) this.f12025a.S2(R$id.mTextIntroduceFirst)).setText(introduceAty2.getString(introduceAty2.f12022n[i10].intValue()));
                IntroduceAty introduceAty3 = this.f12025a;
                ((TextView) this.f12025a.S2(R$id.mTextIntroduceSecond)).setText(introduceAty3.getString(introduceAty3.f12023o[i10].intValue()));
                if (i10 == 0 || i10 == 1) {
                    ((Button) this.f12025a.S2(R$id.mButtonEnter)).setVisibility(8);
                } else if (i10 == 2) {
                    ((Button) this.f12025a.S2(R$id.mButtonEnter)).setVisibility(0);
                }
            }
        }
    }

    public IntroduceAty() {
        Integer[] numArr = new Integer[3];
        for (int i10 = 0; i10 < 3; i10++) {
            numArr[i10] = 0;
        }
        this.f12021m = numArr;
        Integer[] numArr2 = new Integer[3];
        for (int i11 = 0; i11 < 3; i11++) {
            numArr2[i11] = 0;
        }
        this.f12022n = numArr2;
        Integer[] numArr3 = new Integer[3];
        for (int i12 = 0; i12 < 3; i12++) {
            numArr3[i12] = 0;
        }
        this.f12023o = numArr3;
    }

    public static final void Z2(IntroduceAty introduceAty, View view) {
        i.g(introduceAty, "this$0");
        b0.c0(introduceAty, MainAty.class);
        introduceAty.finish();
    }

    public View S2(int i10) {
        Map map = this.f12024p;
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

    public final i0 V2() {
        i0 i0Var = this.f12020l;
        if (i0Var != null) {
            return i0Var;
        }
        i.w("pagerAdapter");
        return null;
    }

    public final void W2() {
        ((LinearLayout) S2(R$id.mLayoutPoint)).getChildAt(0).setSelected(true);
        ((TextView) S2(R$id.mTextIntroduceFirst)).setText(getString(this.f12022n[0].intValue()));
        ((TextView) S2(R$id.mTextIntroduceSecond)).setText(getString(this.f12023o[0].intValue()));
        ((Button) S2(R$id.mButtonEnter)).setVisibility(8);
        if (TextUtils.equals(getIntent().getStringExtra(f12016r), f12017s)) {
            App.f6050e.a().j().n(false);
        }
        com.mobile.brasiltv.utils.c j10 = App.f6050e.a().j();
        String a10 = e.a(this);
        i.f(a10, "getAppVersionCode(this)");
        j10.m(a10);
    }

    public final void X2() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(s0.a(this, 10.0f), s0.a(this, 10.0f));
        layoutParams.leftMargin = 12;
        layoutParams.rightMargin = 12;
        int size = this.f12019k.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = new View(this);
            view.setBackgroundResource(R.drawable.selector_dot_introduce);
            view.setLayoutParams(layoutParams);
            ((LinearLayout) S2(R$id.mLayoutPoint)).addView(view);
        }
    }

    public final void Y2() {
        ((ViewPager) S2(R$id.mViewPager)).addOnPageChangeListener(new b(this));
        ((Button) S2(R$id.mButtonEnter)).setOnClickListener(new u0(this));
    }

    public final void a3() {
        if (i.b(getIntent().getStringExtra(f12016r), f12017s)) {
            this.f12021m[0] = Integer.valueOf(R.drawable.bg_install_introduce1);
            this.f12021m[1] = Integer.valueOf(R.drawable.bg_install_introduce2);
            this.f12021m[2] = Integer.valueOf(R.drawable.bg_install_introduce3);
            this.f12022n[0] = Integer.valueOf(R.string.introduce_install_first_1);
            this.f12022n[1] = Integer.valueOf(R.string.introduce_install_second_1);
            this.f12022n[2] = Integer.valueOf(R.string.introduce_install_three_1);
            this.f12023o[0] = Integer.valueOf(R.string.introduce_install_first_2);
            this.f12023o[1] = Integer.valueOf(R.string.introduce_install_second_2);
            this.f12023o[2] = Integer.valueOf(R.string.introduce_install_three_2);
            return;
        }
        this.f12021m[0] = Integer.valueOf(R.drawable.bg_upgrade_introduce1);
        this.f12021m[1] = Integer.valueOf(R.drawable.bg_upgrade_introduce2);
        this.f12021m[2] = Integer.valueOf(R.drawable.bg_upgrade_introduce3);
        this.f12022n[0] = Integer.valueOf(R.string.introduce_upgrade_first_1);
        this.f12022n[1] = Integer.valueOf(R.string.introduce_upgrade_second_1);
        this.f12022n[2] = Integer.valueOf(R.string.introduce_upgrade_three_1);
        this.f12023o[0] = Integer.valueOf(R.string.introduce_upgrade_first_2);
        this.f12023o[1] = Integer.valueOf(R.string.introduce_upgrade_second_2);
        this.f12023o[2] = Integer.valueOf(R.string.introduce_upgrade_three_2);
    }

    public final void b3() {
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.layout.layout_introduce_view, (ViewGroup) null);
        View inflate2 = from.inflate(R.layout.layout_introduce_view, (ViewGroup) null);
        View inflate3 = from.inflate(R.layout.layout_introduce_view, (ViewGroup) null);
        inflate.setBackgroundResource(this.f12021m[0].intValue());
        inflate2.setBackgroundResource(this.f12021m[1].intValue());
        inflate3.setBackgroundResource(this.f12021m[2].intValue());
        this.f12019k.add(inflate);
        this.f12019k.add(inflate2);
        this.f12019k.add(inflate3);
        c3(new i0(this.f12019k));
        ((ViewPager) S2(R$id.mViewPager)).setAdapter(V2());
    }

    public final void c3(i0 i0Var) {
        i.g(i0Var, "<set-?>");
        this.f12020l = i0Var;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_introduce);
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        a3();
        b3();
        X2();
        Y2();
        W2();
    }
}
