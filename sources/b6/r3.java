package b6;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.RecordsAty;
import com.mobile.brasiltv.activity.SearchAty;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.bean.event.GotoCREvent;
import com.mobile.brasiltv.bean.event.MoveToFirst;
import com.mobile.brasiltv.bean.event.ToggleShowTitleBarEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.NoScrollViewPager;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.x;
import h9.g;
import h9.h;
import j6.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.p2;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import t9.i;
import t9.j;

public final class r3 extends e<p2> implements m {

    /* renamed from: i  reason: collision with root package name */
    public p2 f4493i;

    /* renamed from: j  reason: collision with root package name */
    public final g f4494j = h.b(new a(this));

    /* renamed from: k  reason: collision with root package name */
    public final g f4495k = h.b(new c(this));

    /* renamed from: l  reason: collision with root package name */
    public final List f4496l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final List f4497m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final g f4498n = h.b(d.f11143a);

    /* renamed from: o  reason: collision with root package name */
    public String f4499o = "";

    /* renamed from: p  reason: collision with root package name */
    public Map f4500p = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r3 f11138a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(r3 r3Var) {
            super(0);
            this.f11138a = r3Var;
        }

        public final Integer invoke() {
            n5.a aVar = n5.a.f8310a;
            androidx.fragment.app.e activity = this.f11138a.getActivity();
            i.d(activity);
            return Integer.valueOf(aVar.a(activity));
        }
    }

    public static final class b implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11139a;

        /* renamed from: b  reason: collision with root package name */
        public int f11140b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r3 f11141c;

        public b(r3 r3Var) {
            this.f11141c = r3Var;
        }

        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            boolean z11 = false;
            if (i10 < this.f11140b) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f11139a = z10;
            List k32 = this.f11141c.f4496l;
            if (k32 == null || k32.isEmpty()) {
                z11 = true;
            }
            if (!z11 && this.f11140b <= this.f11141c.f4496l.size() - 1) {
                AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(-1, -1);
                if (this.f11139a) {
                    if (this.f11141c.f4496l.get(this.f11140b) instanceof i3) {
                        layoutParams.topMargin = AutoUtils.getPercentHeightSize((int) ((((float) 1) - f10) * ((float) 201)));
                        ((NoScrollViewPager) this.f11141c.j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
                    }
                } else if (this.f11141c.f4496l.get(this.f11140b) instanceof i3) {
                    layoutParams.topMargin = AutoUtils.getPercentHeightSize((int) (f10 * ((float) 201)));
                    ((NoScrollViewPager) this.f11141c.j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
                }
            }
        }

        public void onPageSelected(int i10) {
            this.f11140b = i10;
            this.f11141c.t3(i10);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r3 f11142a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(r3 r3Var) {
            super(0);
            this.f11142a = r3Var;
        }

        /* renamed from: b */
        public final x invoke() {
            List k32 = this.f11142a.f4496l;
            List l32 = this.f11142a.f4497m;
            o childFragmentManager = this.f11142a.getChildFragmentManager();
            i.f(childFragmentManager, "childFragmentManager");
            return new x(k32, l32, childFragmentManager);
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f11143a = new d();

        public d() {
            super(0);
        }

        /* renamed from: b */
        public final l invoke() {
            return new l();
        }
    }

    public static final class e implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r3 f11144a;

        public e(r3 r3Var) {
            this.f11144a = r3Var;
        }

        public void onClick() {
            this.f11144a.a3().n();
        }
    }

    public static final class f implements KoocanEmptyView.ReloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r3 f11145a;

        public f(r3 r3Var) {
            this.f11145a = r3Var;
        }

        public void onClick() {
            this.f11145a.a3().n();
        }
    }

    public static /* synthetic */ void o3(r3 r3Var, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        r3Var.n3(list, z10);
    }

    public static final void v3(r3 r3Var, View view) {
        i.g(r3Var, "this$0");
        b0.a0(r3Var, SearchAty.class);
    }

    public static final void w3(r3 r3Var, View view) {
        i.g(r3Var, "this$0");
        b0.a0(r3Var, RecordsAty.class);
    }

    public static final void x3(View view) {
        xa.c.c().j(new MoveToFirst());
    }

    public static final void y3(View view) {
        xa.c.c().j(new MoveToFirst());
    }

    public final void A3() {
        if (Q2()) {
            for (Fragment fragment : this.f4496l) {
                if (fragment instanceof p) {
                    ((p) fragment).f1(getUserVisibleHint());
                }
            }
        }
    }

    public final void B3(Fragment fragment, ChildColumnList childColumnList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("fragment_bound_key", childColumnList);
        fragment.setArguments(bundle);
    }

    public void C3(p2 p2Var) {
        i.g(p2Var, "<set-?>");
        this.f4493i = p2Var;
    }

    public void T2() {
        if (Q2() && S2() && !z3() && b0.I(this.f4496l)) {
            xa.c.c().j(new BannerAutoPlayEvent(true));
        }
    }

    public void U2() {
        super.U2();
        if (Q2() && !z3() && b0.I(this.f4496l)) {
            xa.c.c().j(new BannerAutoPlayEvent(false));
        }
    }

    public void X2() {
        this.f4500p.clear();
    }

    public void Y2() {
        ViewGroup.LayoutParams layoutParams = ((TextView) j3(R$id.mCinemaTitle)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, p3(), 0, 0);
        ViewGroup.LayoutParams layoutParams2 = ((ImageView) j3(R$id.mVodImageSearch)).getLayoutParams();
        i.e(layoutParams2, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams2).setMargins(0, p3(), 0, 0);
        int i10 = R$id.mRecommendVp;
        ((NoScrollViewPager) j3(i10)).setScrollable(true);
        ((NoScrollViewPager) j3(i10)).setAdapter(q3());
        int i11 = R$id.mRecommendTab;
        ((SlidingTabLayout) j3(i11)).setSnapOnTabClick(true);
        ((SlidingTabLayout) j3(i11)).setViewPager((NoScrollViewPager) j3(i10));
        u3();
        a();
        a3().n();
    }

    public void a() {
        ((KoocanEmptyView) j3(R$id.vod_loadingView)).setVisibility(0);
    }

    public void b() {
        int i10 = R$id.vod_loadingView;
        ((KoocanEmptyView) j3(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
        ((KoocanEmptyView) j3(i10)).setVisibility(0);
        ((KoocanEmptyView) j3(i10)).setReloadListener(new e(this));
    }

    public void c(String str) {
        i.g(str, "errorCode");
        j1.h(Z2(), str);
        int i10 = R$id.vod_loadingView;
        ((KoocanEmptyView) j3(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
        ((KoocanEmptyView) j3(i10)).setVisibility(0);
        ((KoocanEmptyView) j3(i10)).setReloadListener(new f(this));
    }

    public int c3() {
        return R.layout.frag_vod;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void gotoCRMessage(GotoCREvent gotoCREvent) {
        i.g(gotoCREvent, "event");
        int size = this.f4496l.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f4496l.get(i10) instanceof l) {
                ((NoScrollViewPager) j3(R$id.mRecommendVp)).setCurrentItem(i10, false);
                return;
            }
        }
    }

    @xa.j
    public final void handleUpdateRestrictEvent(UpdateRestrictEvent updateRestrictEvent) {
        i.g(updateRestrictEvent, "event");
        w6.i.f9510g.q0(updateRestrictEvent.getStatus());
        List r10 = a3().r();
        if (b0.I(r10)) {
            i.d(r10);
            n3(r10, true);
        }
    }

    public View j3(int i10) {
        View findViewById;
        Map map = this.f4500p;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void k() {
        ((KoocanEmptyView) j3(R$id.vod_loadingView)).setVisibility(8);
    }

    public final void n3(List list, boolean z10) {
        if (!z10) {
            Iterator it = list.iterator();
            int i10 = -1;
            while (it.hasNext()) {
                ChildColumnList childColumnList = (ChildColumnList) it.next();
                if (i.b(childColumnList.getRestricted(), "1")) {
                    i10 = list.indexOf(childColumnList);
                } else {
                    String code = childColumnList.getCode();
                    if (i.b(code, w6.i.f9510g.v() + "_short")) {
                        i3 i3Var = new i3();
                        B3(i3Var, childColumnList);
                        this.f4497m.add(b0.e(childColumnList.getAlias(), childColumnList.getName()));
                        this.f4496l.add(i3Var);
                    } else {
                        g3 g3Var = new g3();
                        B3(g3Var, childColumnList);
                        this.f4497m.add(b0.e(childColumnList.getAlias(), childColumnList.getName()));
                        this.f4496l.add(g3Var);
                    }
                }
            }
            if (i10 != -1 && i.b(w6.i.f9510g.A(), "1")) {
                ChildColumnList childColumnList2 = (ChildColumnList) list.get(i10);
                B3(r3(), childColumnList2);
                String c10 = b0.c(childColumnList2.getAlias(), childColumnList2.getName());
                this.f4499o = c10;
                this.f4497m.add(c10);
                this.f4496l.add(r3());
            }
        } else if (i.b(w6.i.f9510g.A(), "1")) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ChildColumnList childColumnList3 = (ChildColumnList) it2.next();
                if (i.b(childColumnList3.getRestricted(), "1")) {
                    if (!r3().isStateSaved()) {
                        B3(r3(), childColumnList3);
                    }
                    String c11 = b0.c(childColumnList3.getAlias(), childColumnList3.getName());
                    this.f4499o = c11;
                    if (!this.f4497m.contains(c11)) {
                        this.f4497m.add(this.f4499o);
                        this.f4496l.add(r3());
                    }
                }
            }
        } else {
            this.f4497m.remove(this.f4499o);
            this.f4496l.remove(r3());
        }
        int i11 = R$id.mRecommendTab;
        if (((SlidingTabLayout) j3(i11)) != null) {
            ((SlidingTabLayout) j3(i11)).notifyDataSetChanged();
            q3().notifyDataSetChanged();
            ((SlidingTabLayout) j3(i11)).setCurrentTab(0);
            k();
            xa.c.c().j(new CouponQualificationEvent(w6.i.f9510g.M()));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3(new p2(this, this));
        xa.c.c().o(this);
    }

    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        R2();
    }

    public final int p3() {
        return ((Number) this.f4494j.getValue()).intValue();
    }

    public void q1(List list) {
        i.g(list, "childColumn");
        o3(this, list, false, 2, (Object) null);
        A3();
    }

    public final x q3() {
        return (x) this.f4495k.getValue();
    }

    public final l r3() {
        return (l) this.f4498n.getValue();
    }

    /* renamed from: s3 */
    public p2 a3() {
        p2 p2Var = this.f4493i;
        if (p2Var != null) {
            return p2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        A3();
    }

    public final void t3(int i10) {
        boolean z10;
        List list = this.f4496l;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (this.f4496l.get(i10) instanceof i3) {
                int i11 = R$id.mLayoutNavigator;
                ((AutoFrameLayout) j3(i11)).setVisibility(8);
                ((AutoFrameLayout) j3(i11)).setBackgroundColor(0);
                ((ImageView) j3(R$id.mIvTitleLine)).setBackgroundColor(0);
                AutoFrameLayout.LayoutParams layoutParams = new AutoFrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = AutoUtils.getPercentHeightSize(0);
                ((NoScrollViewPager) j3(R$id.mRecommendVp)).setLayoutParams(layoutParams);
                return;
            }
            int i12 = R$id.mLayoutNavigator;
            ((AutoFrameLayout) j3(i12)).setVisibility(0);
            ((AutoFrameLayout) j3(i12)).setBackgroundColor(getResources().getColor(R.color.color_191a23));
            ((ImageView) j3(R$id.mIvTitleLine)).setBackgroundColor(getResources().getColor(R.color.color_1f202a));
            AutoFrameLayout.LayoutParams layoutParams2 = new AutoFrameLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = AutoUtils.getPercentHeightSize(201);
            ((NoScrollViewPager) j3(R$id.mRecommendVp)).setLayoutParams(layoutParams2);
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void toggleShowTitleBar(ToggleShowTitleBarEvent toggleShowTitleBarEvent) {
        i.g(toggleShowTitleBarEvent, "event");
        if (toggleShowTitleBarEvent.getShow()) {
            ((AutoFrameLayout) j3(R$id.mLayoutNavigator)).setVisibility(0);
        } else {
            ((AutoFrameLayout) j3(R$id.mLayoutNavigator)).setVisibility(8);
        }
    }

    public final void u3() {
        ((ImageView) j3(R$id.mVodImageSearch)).setOnClickListener(new n3(this));
        ((ImageView) j3(R$id.mVodImageHistory)).setOnClickListener(new o3(this));
        ((TextView) j3(R$id.mCinemaTitle)).setOnClickListener(new p3());
        ((ImageView) j3(R$id.mVodImageLogo)).setOnClickListener(new q3());
        ((NoScrollViewPager) j3(R$id.mRecommendVp)).addOnPageChangeListener(new b(this));
    }

    public final boolean z3() {
        int i10 = R$id.mRecommendTab;
        if (((SlidingTabLayout) j3(i10)) == null || ((SlidingTabLayout) j3(i10)).getTabCount() < 1) {
            return true;
        }
        return false;
    }
}
