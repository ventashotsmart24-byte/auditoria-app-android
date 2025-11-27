package b6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.ShortBeforePlayingEvent;
import com.mobile.brasiltv.bean.event.ToggleShowTitleBarEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.shortvideo.OnStretchListener;
import com.mobile.brasiltv.view.shortvideo.StretchPager;
import com.msandroid.mobile.R;
import g5.v3;
import h9.g;
import h9.h;
import j6.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import l6.c2;
import mobile.com.requestframe.utils.response.ShortAssetData;
import t9.i;
import t9.j;

public final class i3 extends e<c2> implements k, p {

    /* renamed from: i  reason: collision with root package name */
    public c2 f4402i;

    /* renamed from: j  reason: collision with root package name */
    public int f4403j;

    /* renamed from: k  reason: collision with root package name */
    public ShortAssetData f4404k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f4405l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public final g f4406m = h.b(new d(this));

    /* renamed from: n  reason: collision with root package name */
    public final g f4407n = h.b(c.f10985a);

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f4408o = new h3(this);

    /* renamed from: p  reason: collision with root package name */
    public boolean f4409p;

    /* renamed from: q  reason: collision with root package name */
    public Map f4410q = new LinkedHashMap();

    public static final class a implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public int f10981a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10982b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i3 f10983c;

        public a(i3 i3Var) {
            this.f10983c = i3Var;
        }

        public void onPageScrollStateChanged(int i10) {
            if (i10 == 1) {
                this.f10981a = ((StretchPager) this.f10983c.g3(R$id.mViewPager)).getCurrentItem();
            }
            if (i10 == 0) {
                b0.U(this, "恢复预加载");
            } else {
                b0.U(this, "暂停预加载");
            }
        }

        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            int i12 = this.f10981a;
            if (i10 != i12) {
                if (i10 < i12) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f10982b = z10;
            }
        }

        public void onPageSelected(int i10) {
            if (i10 != this.f10983c.f4403j) {
                this.f10983c.l2(i10);
                if (i10 == this.f10983c.f4405l.size() - 2) {
                    this.f10983c.a3().m();
                }
            }
        }
    }

    public static final class b implements OnStretchListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i3 f10984a;

        public b(i3 i3Var) {
            this.f10984a = i3Var;
        }

        public void onRefresh(int i10, int i11) {
        }

        public void onRelease(int i10) {
            if (i10 == 16) {
                this.f10984a.a3().m();
            }
        }

        public void onScrolled(int i10, int i11) {
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f10985a = new c();

        public c() {
            super(0);
        }

        /* renamed from: b */
        public final u6.b invoke() {
            return new u6.b();
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i3 f10986a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i3 i3Var) {
            super(0);
            this.f10986a = i3Var;
        }

        /* renamed from: b */
        public final v3 invoke() {
            return new v3(this.f10986a.f4405l);
        }
    }

    public static final void q3(i3 i3Var) {
        i.g(i3Var, "this$0");
        TextView textView = (TextView) i3Var.g3(R$id.mTvDataTip);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void T2() {
        if (this.f4405l.isEmpty()) {
            a3().m();
        }
        l3();
    }

    public void U2() {
        l3();
    }

    public void X2() {
        this.f4410q.clear();
    }

    public void Y1(ArrayList arrayList) {
        i.g(arrayList, "shortAssetList");
        this.f4405l.clear();
        this.f4405l.addAll(arrayList);
        k3().notifyDataSetChanged();
        if (this.f4403j == 0 && !a3().o() && (!this.f4405l.isEmpty())) {
            l2(0);
        }
    }

    public void Y2() {
        n3();
        m3();
        ((StretchPager) g3(R$id.mViewPager)).setCurrentItem(0);
    }

    public void c(String str) {
        i.g(str, "errorCode");
        j1.h(Z2(), str);
        xa.c.c().j(new ToggleShowTitleBarEvent(true));
    }

    public int c3() {
        return R.layout.frag_shortvideo;
    }

    public void f1(boolean z10) {
        this.f4409p = z10;
        l3();
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f4410q;
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

    /* renamed from: j3 */
    public c2 a3() {
        c2 c2Var = this.f4402i;
        if (c2Var != null) {
            return c2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void k1() {
        if (S2()) {
            int i10 = R$id.mTvDataTip;
            ((TextView) g3(i10)).setVisibility(0);
            ((TextView) g3(i10)).removeCallbacks(this.f4408o);
            ((TextView) g3(i10)).postDelayed(this.f4408o, 5000);
        }
    }

    public final v3 k3() {
        return (v3) this.f4406m.getValue();
    }

    public void l2(int i10) {
        boolean z10;
        b0.U(this, "startPlay " + i10);
        int childCount = ((StretchPager) g3(R$id.mViewPager)).getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            v3.a aVar = (v3.a) ((StretchPager) g3(R$id.mViewPager)).getChildAt(i11).getTag();
            if (aVar == null || aVar.c() != i10) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Object obj = this.f4405l.get(i10);
                i.f(obj, "mVideoList[position]");
                ShortAssetData shortAssetData = (ShortAssetData) obj;
                String playUrl = shortAssetData.getPlayUrl((String) r5.i.f19378a.B().c());
                this.f4404k = shortAssetData;
                b0.U(this, "startPlay: position: " + i10 + "  url: " + playUrl);
                this.f4403j = i10;
                return;
            }
        }
    }

    public final void l3() {
        if (!this.f4409p || !getUserVisibleHint() || !Q2()) {
            o3();
        }
    }

    public final void m3() {
    }

    public final void n3() {
        int i10 = R$id.mViewPager;
        ((StretchPager) g3(i10)).setOffscreenPageLimit(4);
        ((StretchPager) g3(i10)).setAdapter(k3());
        ((StretchPager) g3(i10)).setOverScrollMode(2);
        ((StretchPager) g3(i10)).setRefreshView((View) null, LayoutInflater.from(getContext()).inflate(R.layout.item_pager_bottom, (ViewGroup) null));
        ((StretchPager) g3(i10)).setStretchModel(16);
        ((StretchPager) g3(i10)).setOnPageChangeListener(new a(this));
        ((StretchPager) g3(i10)).setOnStretchListener(new b(this));
    }

    public final void o3() {
        Q2();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p3(new c2(this, this));
        xa.c.c().o(this);
    }

    public void onDestroyView() {
        xa.c.c().r(this);
        super.onDestroyView();
        ((TextView) g3(R$id.mTvDataTip)).removeCallbacks(this.f4408o);
        X2();
    }

    public void onPause() {
        super.onPause();
        o3();
    }

    public void p3(c2 c2Var) {
        i.g(c2Var, "<set-?>");
        this.f4402i = c2Var;
    }

    @xa.j
    public final void shortVideoBeforePlaying(ShortBeforePlayingEvent shortBeforePlayingEvent) {
        i.g(shortBeforePlayingEvent, "event");
        if (!this.f4409p || !getUserVisibleHint()) {
            o3();
        } else {
            xa.c.c().j(new ToggleShowTitleBarEvent(false));
        }
    }
}
