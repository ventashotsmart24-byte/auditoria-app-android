package b6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.y;
import b6.r;
import b6.r0;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.Search1Aty;
import com.mobile.brasiltv.bean.event.ClickChannelEpgEvent;
import com.mobile.brasiltv.bean.event.LiveFragVisibleEvent;
import com.mobile.brasiltv.bean.event.StopPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.view.LiveFragmentTabLayout;
import com.mobile.brasiltv.view.RatioFrameLayout;
import com.mobile.brasiltv.view.TabOnClickListener;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.x0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import l6.n0;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import t9.j;

public final class z extends e<n0> implements j6.d {
    public static boolean A;
    public static ChildColumnList B;
    public static ChildColumnList C;
    public static boolean D;

    /* renamed from: u  reason: collision with root package name */
    public static final a f4508u = new a((t9.g) null);

    /* renamed from: v  reason: collision with root package name */
    public static androidx.collection.a f4509v = new androidx.collection.a();

    /* renamed from: w  reason: collision with root package name */
    public static String f4510w = "";

    /* renamed from: x  reason: collision with root package name */
    public static SparseArray f4511x = new SparseArray();

    /* renamed from: y  reason: collision with root package name */
    public static String f4512y;

    /* renamed from: z  reason: collision with root package name */
    public static ArrayList f4513z;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4514i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f4515j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f4516k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f4517l = h9.h.b(new b(this));

    /* renamed from: m  reason: collision with root package name */
    public final h9.g f4518m = h9.h.b(new c(this));

    /* renamed from: n  reason: collision with root package name */
    public n0 f4519n;

    /* renamed from: o  reason: collision with root package name */
    public final h9.g f4520o = h9.h.b(e.f11187a);

    /* renamed from: p  reason: collision with root package name */
    public final h9.g f4521p = h9.h.b(f.f11188a);

    /* renamed from: q  reason: collision with root package name */
    public final h9.g f4522q = h9.h.b(i.f11191a);

    /* renamed from: r  reason: collision with root package name */
    public final h9.g f4523r = h9.h.b(h.f11190a);

    /* renamed from: s  reason: collision with root package name */
    public final h9.g f4524s = h9.h.b(g.f11189a);

    /* renamed from: t  reason: collision with root package name */
    public Map f4525t = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final ChildColumnList a() {
            return z.B;
        }

        public final androidx.collection.a b() {
            return z.f4509v;
        }

        public final String c() {
            return z.f4510w;
        }

        public final ArrayList d() {
            return z.f4513z;
        }

        public final ChildColumnList e() {
            return z.C;
        }

        public final String f() {
            return z.f4512y;
        }

        public final SparseArray g() {
            return z.f4511x;
        }

        public final boolean h() {
            return z.D;
        }

        public final void i(ChildColumnList childColumnList) {
            z.B = childColumnList;
        }

        public final void j(String str) {
            t9.i.g(str, "<set-?>");
            z.f4510w = str;
        }

        public final void k(ArrayList arrayList) {
            z.f4513z = arrayList;
        }

        public final void l(boolean z10) {
            z.A = z10;
        }

        public final void m(ChildColumnList childColumnList) {
            z.C = childColumnList;
        }

        public final void n(String str) {
            z.f4512y = str;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z f11184a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(z zVar) {
            super(0);
            this.f11184a = zVar;
        }

        /* renamed from: b */
        public final x0 invoke() {
            o childFragmentManager = this.f11184a.getChildFragmentManager();
            t9.i.f(childFragmentManager, "childFragmentManager");
            return new x0(childFragmentManager, this.f11184a.E3(), this.f11184a.F3());
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z f11185a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(z zVar) {
            super(0);
            this.f11185a = zVar;
        }

        public final Integer invoke() {
            return Integer.valueOf(n5.a.f8310a.a(this.f11185a.getActivity()));
        }
    }

    public static final class d implements TabOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z f11186a;

        public d(z zVar) {
            this.f11186a = zVar;
        }

        public void leftTextClick() {
            this.f11186a.M3();
        }

        public void rightTextClick() {
            this.f11186a.O3();
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f11187a = new e();

        public e() {
            super(0);
        }

        /* renamed from: b */
        public final o2 invoke() {
            return new o2();
        }
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f11188a = new f();

        public f() {
            super(0);
        }

        /* renamed from: b */
        public final w invoke() {
            return new w();
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f11189a = new g();

        public g() {
            super(0);
        }

        /* renamed from: b */
        public final l2 invoke() {
            return new l2();
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f11190a = new h();

        public h() {
            super(0);
        }

        /* renamed from: b */
        public final r1 invoke() {
            return new r1();
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final i f11191a = new i();

        public i() {
            super(0);
        }

        /* renamed from: b */
        public final c2 invoke() {
            return new c2();
        }
    }

    public static final void w3(z zVar, View view) {
        t9.i.g(zVar, "this$0");
        b0.a0(zVar, Search1Aty.class);
    }

    public static final void x3(z zVar, View view) {
        t9.i.g(zVar, "this$0");
        zVar.N3(true);
    }

    public final o2 A3() {
        return (o2) this.f4520o.getValue();
    }

    public final w B3() {
        return (w) this.f4521p.getValue();
    }

    public final l2 C3() {
        return (l2) this.f4524s.getValue();
    }

    public final r1 D3() {
        return (r1) this.f4523r.getValue();
    }

    public final ArrayList E3() {
        return this.f4515j;
    }

    public final ArrayList F3() {
        return this.f4516k;
    }

    /* renamed from: G3 */
    public n0 a3() {
        n0 n0Var = this.f4519n;
        if (n0Var != null) {
            return n0Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final FrameLayout H3() {
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) h3(R$id.livePlayFrg);
        t9.i.f(ratioFrameLayout, "livePlayFrg");
        return ratioFrameLayout;
    }

    public final void I3() {
        D3().w4();
    }

    public final boolean J3() {
        return D3().J4();
    }

    public final void K3(Fragment fragment, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(r0.A.a(), str);
        fragment.setArguments(bundle);
    }

    public void L3(n0 n0Var) {
        t9.i.g(n0Var, "<set-?>");
        this.f4519n = n0Var;
    }

    public final void M3() {
        if (getChildFragmentManager().h0("liveChannelFrag") != null || A3().isAdded()) {
            getChildFragmentManager().m().u(A3()).i();
            if (B3() != null && getChildFragmentManager().h0("liveCollectFrag") != null) {
                getChildFragmentManager().m().o(B3()).i();
                return;
            }
            return;
        }
        getChildFragmentManager().m().c(R.id.channelAndFavoriteFrg, A3(), "liveChannelFrag").i();
        if (B3() != null && getChildFragmentManager().h0("liveCollectFrag") != null) {
            getChildFragmentManager().m().o(B3()).i();
        }
    }

    public final void N3(boolean z10) {
        y m10 = getChildFragmentManager().m();
        t9.i.f(m10, "childFragmentManager.beginTransaction()");
        if (z10) {
            ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setVisibility(0);
            ((AutoRelativeLayout) h3(R$id.channelAndFavoriteContent)).setVisibility(0);
            ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setVisibility(8);
            if (C3().isVisible()) {
                m10.o(C3()).i();
            }
            ((AutoRelativeLayout) h3(R$id.mLayoutEpgContent)).setVisibility(8);
            return;
        }
        ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setVisibility(8);
        ((AutoRelativeLayout) h3(R$id.channelAndFavoriteContent)).setVisibility(8);
        ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setVisibility(0);
        ((AutoRelativeLayout) h3(R$id.mLayoutEpgContent)).setVisibility(0);
        ((TextView) h3(R$id.mTextEpgChannel)).setText(r.f4434j.b());
        if (C3().isAdded()) {
            m10.u(C3()).i();
        } else {
            m10.b(R.id.mLayoutEPGFragment, C3()).i();
        }
    }

    public final void O3() {
        if (getChildFragmentManager().h0("liveCollectFrag") != null) {
            getChildFragmentManager().m().u(B3()).i();
            if (A3() != null && getChildFragmentManager().h0("liveChannelFrag") != null) {
                getChildFragmentManager().m().o(A3()).i();
                return;
            }
            return;
        }
        getChildFragmentManager().m().c(R.id.channelAndFavoriteFrg, B3(), "liveCollectFrag").i();
        if (A3() != null && getChildFragmentManager().h0("liveChannelFrag") != null) {
            getChildFragmentManager().m().o(A3()).i();
        }
    }

    public void T2() {
        if (y3().getCount() == 0) {
            a3().x();
        }
        d6.a aVar = d6.a.f16338a;
        if (aVar.j() == 1) {
            aVar.m();
        }
        xa.c.c().j(new LiveFragVisibleEvent(true));
    }

    public void U2() {
        super.U2();
        D = false;
        D3().z4();
        xa.c.c().j(new LiveFragVisibleEvent(false));
    }

    public void V2() {
        super.V2();
        D = true;
        D3().A4(A);
    }

    public void X2() {
        this.f4525t.clear();
    }

    public void Y2() {
        ViewGroup.LayoutParams layoutParams = ((TextView) h3(R$id.mTextTitle)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams).setMargins(0, z3(), 0, 0);
        int i10 = R$id.mImageSearch;
        ViewGroup.LayoutParams layoutParams2 = ((ImageView) h3(i10)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type com.zhy.autolayout.AutoRelativeLayout.LayoutParams");
        ((AutoRelativeLayout.LayoutParams) layoutParams2).setMargins(0, z3(), 0, 0);
        if (S2()) {
            d6.a.f16338a.m();
        }
        getChildFragmentManager().m().q(R.id.livePlayFrg, D3()).i();
        ((LiveFragmentTabLayout) h3(R$id.liveFragmentTab)).setOnClickListener(new d(this));
        com.mobile.brasiltv.utils.n0 n0Var = com.mobile.brasiltv.utils.n0.f12601a;
        androidx.fragment.app.e activity = getActivity();
        t9.i.d(activity);
        f4512y = n0Var.e(activity, "live_last_play_chanel", "");
        ((ImageView) h3(i10)).setOnClickListener(new x(this));
        ((AutoLinearLayout) h3(R$id.mLayoutEPGTitle)).setOnClickListener(new y(this));
    }

    public void c(String str) {
        t9.i.g(str, "returnCode");
    }

    public int c3() {
        return R.layout.frag_live;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void clickChannelEpg(ClickChannelEpgEvent clickChannelEpgEvent) {
        t9.i.g(clickChannelEpgEvent, "event");
        b0.U(this, "clickChannelEpg: " + clickChannelEpgEvent.getChannelName() + ' ' + clickChannelEpgEvent.getChannelCode() + ' ' + clickChannelEpgEvent.getColumnId());
        r.a aVar = r.f4434j;
        aVar.d(clickChannelEpgEvent.getChannelCode());
        aVar.f(clickChannelEpgEvent.getColumnId());
        if (f0.b() || TextUtils.isEmpty(clickChannelEpgEvent.getChannelAlias())) {
            aVar.e(clickChannelEpgEvent.getChannelName());
        } else {
            aVar.e(clickChannelEpgEvent.getChannelAlias());
        }
        N3(false);
    }

    public View h3(int i10) {
        View findViewById;
        Map map = this.f4525t;
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

    public void onConfigurationChanged(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.MainAty");
            ((MainAty) activity).r4();
            return;
        }
        androidx.fragment.app.e activity2 = getActivity();
        t9.i.e(activity2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.MainAty");
        ((MainAty) activity2).V3();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L3(new n0(this, this));
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

    public void onLoading() {
    }

    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            D = false;
            D3().z4();
        }
    }

    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()) {
            D = true;
            D3().A4(A);
            A = false;
        }
    }

    public void s() {
        o2 A3 = A3();
        r0.a aVar = r0.A;
        K3(A3, aVar.b());
        K3(B3(), aVar.c());
        this.f4515j.clear();
        this.f4516k.clear();
        this.f4515j.addAll(i9.j.c(A3(), B3()));
        this.f4516k.addAll(i9.j.c(b0.z(R.string.live_channel), b0.z(R.string.live_fav), b0.z(R.string.live_sub_list)));
        if (!this.f4514i) {
            this.f4514i = true;
            M3();
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void stopPlay(StopPlayEvent stopPlayEvent) {
        t9.i.g(stopPlayEvent, "event");
        if (stopPlayEvent.getReason() != StopPlayEvent.Reason.PRESS_HOME) {
            U2();
            r1 D3 = D3();
            if (D3 != null) {
                D3.P5();
            }
        }
    }

    public final x0 y3() {
        return (x0) this.f4517l.getValue();
    }

    public final int z3() {
        return ((Number) this.f4518m.getValue()).intValue();
    }
}
