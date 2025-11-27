package b6;

import android.content.Context;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b6.r;
import ba.s;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.mobile.brasiltv.bean.event.LiveTabEpgNotificationEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.CenterLayoutManager;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.AutoLinearLayout;
import g5.g0;
import g5.u0;
import g5.v0;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ma.m;
import mobile.com.requestframe.utils.response.GetProgramData;
import mobile.com.requestframe.utils.response.GetProgramResult;
import mobile.com.requestframe.utils.response.Program;
import s9.l;
import t9.w;

public final class l2 extends f {

    /* renamed from: e  reason: collision with root package name */
    public final List f4415e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public LruCache f4416f = new LruCache(24);

    /* renamed from: g  reason: collision with root package name */
    public HashMap f4417g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public int f4418h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f4419i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List f4420j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public LiveTabEntity f4421k;

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f4422l = h9.h.b(new d(this));

    /* renamed from: m  reason: collision with root package name */
    public final h9.g f4423m = h9.h.b(new f(this));

    /* renamed from: n  reason: collision with root package name */
    public final h9.g f4424n = h9.h.b(new a(this));

    /* renamed from: o  reason: collision with root package name */
    public Map f4425o = new LinkedHashMap();

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11003a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l2 l2Var) {
            super(0);
            this.f11003a = l2Var;
        }

        /* renamed from: b */
        public final u0 invoke() {
            return new u0(this.f11003a.getChildFragmentManager(), this.f11003a.f4415e);
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11004a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l2 l2Var) {
            super(1);
            this.f11004a = l2Var;
        }

        public final void b(Integer num) {
            if (num != null && num.intValue() == 0) {
                ArrayList arrayList = (ArrayList) this.f11004a.l3().get(this.f11004a.f4419i.get(this.f11004a.k3()));
                if (arrayList != null) {
                    this.f11004a.v3(arrayList);
                }
            } else if (num != null && num.intValue() == 1) {
                this.f11004a.v3((List) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class c extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11005a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(l2 l2Var) {
            super(1);
            this.f11005a = l2Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) this.f11005a.g3(R$id.mLlNoData);
            if (autoLinearLayout != null) {
                autoLinearLayout.setVisibility(0);
            }
        }
    }

    public static final class d extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11006a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(l2 l2Var) {
            super(0);
            this.f11006a = l2Var;
        }

        /* renamed from: b */
        public final VodDao invoke() {
            Context context = this.f11006a.getContext();
            t9.i.d(context);
            return new VodDao(context);
        }
    }

    public static final class e implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11007a;

        public e(l2 l2Var) {
            this.f11007a = l2Var;
        }

        public void onPageScrollStateChanged(int i10) {
        }

        public void onPageScrolled(int i10, float f10, int i11) {
        }

        public void onPageSelected(int i10) {
            this.f11007a.C3(i10);
            ArrayList arrayList = (ArrayList) this.f11007a.l3().get(this.f11007a.f4419i.get(this.f11007a.k3()));
            if (arrayList != null) {
                this.f11007a.v3(arrayList);
            }
            this.f11007a.A3(i10);
        }
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11008a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(l2 l2Var) {
            super(0);
            this.f11008a = l2Var;
        }

        /* renamed from: b */
        public final v0 invoke() {
            androidx.fragment.app.e activity = this.f11008a.getActivity();
            if (activity != null) {
                return new v0(activity);
            }
            return null;
        }
    }

    public static final class g extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f11009a = new g();

        public g() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(GetProgramResult getProgramResult) {
            boolean z10;
            t9.i.g(getProgramResult, "it");
            if (getProgramResult.getData() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class h extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f11010a = new h();

        public h() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetProgramResult getProgramResult) {
            t9.i.g(getProgramResult, "it");
            GetProgramData data = getProgramResult.getData();
            t9.i.d(data);
            return data.getProgramList();
        }
    }

    public static final class i extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11011a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(l2 l2Var) {
            super(1);
            this.f11011a = l2Var;
        }

        public final void b(List list) {
            if (b0.I(list)) {
                this.f11011a.m3().put(r.f4434j.a(), list);
            } else {
                this.f11011a.m3().put(r.f4434j.a(), new ArrayList());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class j extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l2 f11012a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f11013a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f11013a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f11013a, (String) null, (String) null, 6, (Object) null);
                yVar.c(this.f11013a);
                f1.f12517a.x(p10);
            }
        }

        public j(l2 l2Var) {
            this.f11012a = l2Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            this.f11012a.q3();
        }

        public void onComplete() {
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            AutoLinearLayout autoLinearLayout = (AutoLinearLayout) this.f11012a.g3(R$id.mLlNoData);
            if (autoLinearLayout != null) {
                autoLinearLayout.setVisibility(0);
            }
            Context context = this.f11012a.getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final void B3(RecyclerView.o oVar, l2 l2Var, int i10) {
        t9.i.g(l2Var, "this$0");
        oVar.smoothScrollToPosition((RecyclerView) l2Var.g3(R$id.tabRecyclerView), new RecyclerView.a0(), i10);
    }

    public static final void r3(l2 l2Var, w wVar, w wVar2, w wVar3, w wVar4, w wVar5, ObservableEmitter observableEmitter) {
        l2 l2Var2 = l2Var;
        w wVar6 = wVar;
        w wVar7 = wVar2;
        w wVar8 = wVar3;
        w wVar9 = wVar4;
        w wVar10 = wVar5;
        ObservableEmitter observableEmitter2 = observableEmitter;
        t9.i.g(l2Var2, "this$0");
        t9.i.g(wVar6, "$startTime");
        t9.i.g(wVar7, "$endTime");
        t9.i.g(wVar8, "$startDay");
        t9.i.g(wVar9, "$endDay");
        t9.i.g(wVar10, "$curTime");
        t9.i.g(observableEmitter2, "it");
        LruCache lruCache = l2Var2.f4416f;
        r.a aVar = r.f4434j;
        if (b0.I((Collection) lruCache.get(aVar.a()))) {
            Object obj = l2Var2.f4416f.get(aVar.a());
            t9.i.f(obj, "mEpgLruCache.get(LiveEpgFrag.mChannelCode)");
            for (Program program : (Iterable) obj) {
                String e10 = y6.b.e(program.getStartTime(), "yyyyMMddHHmmSS", "yyyy/MM/dd HH:mm");
                t9.i.f(e10, "utc2LocalStr(it.startTim…mSS\", \"yyyy/MM/dd HH:mm\")");
                wVar6.f19600a = e10;
                String e11 = y6.b.e(program.getEndTime(), "yyyyMMddHHmmSS", "yyyy/MM/dd HH:mm");
                t9.i.f(e11, "utc2LocalStr(it.endTime,…mSS\", \"yyyy/MM/dd HH:mm\")");
                wVar7.f19600a = e11;
                String substring = ((String) wVar6.f19600a).substring(0, 10);
                t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                wVar8.f19600a = substring;
                String substring2 = ((String) wVar7.f19600a).substring(0, 10);
                t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                wVar9.f19600a = substring2;
                if (l2Var2.f4419i.contains(wVar8.f19600a)) {
                    if (!t9.i.b(wVar8.f19600a, wVar9.f19600a)) {
                        Object obj2 = l2Var2.f4417g.get(wVar8.f19600a);
                        t9.i.d(obj2);
                        ((ArrayList) obj2).add(new Program(program.getProgramName(), (String) wVar6.f19600a, ((String) wVar8.f19600a) + " 23:59", program.getType(), program.getRemark(), false, 32, (t9.g) null));
                        if (l2Var2.f4419i.contains(wVar9.f19600a) && !ba.t.o((CharSequence) wVar7.f19600a, "00:00", false, 2, (Object) null)) {
                            String programName = program.getProgramName();
                            String type = program.getType();
                            String remark = program.getRemark();
                            Program o32 = l2Var.o3(programName, ((String) wVar9.f19600a) + " 00:00", (String) wVar7.f19600a, type, remark);
                            Object obj3 = l2Var2.f4417g.get(wVar9.f19600a);
                            t9.i.d(obj3);
                            ((ArrayList) obj3).add(o32);
                        }
                    } else if (!y6.a.b((String) wVar10.f19600a, (String) wVar7.f19600a)) {
                        String type2 = program.getType();
                        String remark2 = program.getRemark();
                        Program o33 = l2Var.o3(program.getProgramName(), (String) wVar6.f19600a, (String) wVar7.f19600a, type2, remark2);
                        Object obj4 = l2Var2.f4417g.get(wVar8.f19600a);
                        t9.i.d(obj4);
                        ((ArrayList) obj4).add(o33);
                    }
                }
            }
            observableEmitter2.onNext(0);
            return;
        }
        observableEmitter2.onNext(1);
    }

    public static final void s3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u3(l2 l2Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(l2Var, "this$0");
        ((ViewPager) l2Var.g3(R$id.liveViewPager)).setCurrentItem(i10);
        l2Var.A3(i10);
    }

    public static final boolean x3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List y3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void z3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void A3(int i10) {
        LiveTabEntity liveTabEntity;
        v0 p32 = p3();
        RecyclerView.o oVar = null;
        if (p32 != null) {
            liveTabEntity = (LiveTabEntity) p32.getItem(i10);
        } else {
            liveTabEntity = null;
        }
        if (!t9.i.b(liveTabEntity, this.f4421k)) {
            if (liveTabEntity != null) {
                liveTabEntity.setSelected(true);
            }
            LiveTabEntity liveTabEntity2 = this.f4421k;
            if (liveTabEntity2 != null) {
                if (liveTabEntity2 != null) {
                    liveTabEntity2.setSelected(false);
                }
                v0 p33 = p3();
                if (p33 != null) {
                    p33.notifyDataSetChanged();
                }
            }
            this.f4421k = liveTabEntity;
            int i11 = R$id.tabRecyclerView;
            RecyclerView recyclerView = (RecyclerView) g3(i11);
            if (recyclerView != null) {
                oVar = recyclerView.getLayoutManager();
            }
            if (oVar != null) {
                ((RecyclerView) g3(i11)).postDelayed(new k2(oVar, this, i10), 100);
            }
        }
    }

    public final void C3(int i10) {
        this.f4418h = i10;
    }

    public void T2() {
    }

    public void X2() {
        this.f4425o.clear();
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f4425o;
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

    public final u0 j3() {
        return (u0) this.f4424n.getValue();
    }

    public final int k3() {
        return this.f4418h;
    }

    public final HashMap l3() {
        return this.f4417g;
    }

    public final LruCache m3() {
        return this.f4416f;
    }

    public final VodDao n3() {
        return (VodDao) this.f4422l.getValue();
    }

    public final Program o3(String str, String str2, String str3, String str4, String str5) {
        String e10 = m.e(r.f4434j.b() + str + str2 + str3);
        VodDao n32 = n3();
        t9.i.f(e10, "pid");
        return new Program(str, str2, str3, str4, str5, n32.queryLiveSubByPid(e10));
    }

    public void onCreate(Bundle bundle) {
        String str;
        boolean z10;
        super.onCreate(bundle);
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (int i10 = 0; i10 < 7; i10++) {
            String b10 = y6.b.b(((long) (i10 * 24 * 60 * 60 * 1000)) + currentTimeMillis, "yyyy/MM/dd");
            if (i10 == 0) {
                str = getResources().getString(R.string.today);
            } else {
                t9.i.f(b10, "nextDay");
                String substring = b10.substring(5);
                t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
                str = s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, (Object) null);
            }
            String str2 = str;
            List list = this.f4415e;
            t9.i.f(str2, "nextDay");
            list.add(str2);
            List list2 = this.f4420j;
            t9.i.f(str2, "nextDay");
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            list2.add(new LiveTabEntity(str2, z10, 0, 4, (t9.g) null));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t9.i.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.frag_live_tab_epg, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        X2();
    }

    public void onHiddenChanged(boolean z10) {
        boolean z11;
        super.onHiddenChanged(z10);
        if (!z10) {
            r.a aVar = r.f4434j;
            if (aVar.a().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && aVar.c() != -1) {
                w3();
                xa.c.c().j(new LiveTabEpgNotificationEvent());
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        t9.i.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f4421k = (LiveTabEntity) this.f4420j.get(0);
        int i10 = R$id.liveViewPager;
        if (((ViewPager) g3(i10)) != null) {
            ((ViewPager) g3(i10)).setAdapter(j3());
        }
        ((ViewPager) g3(i10)).addOnPageChangeListener(new e(this));
        CenterLayoutManager centerLayoutManager = new CenterLayoutManager(getActivity(), 0, false);
        int i11 = R$id.tabRecyclerView;
        ((RecyclerView) g3(i11)).setHasFixedSize(true);
        ((RecyclerView) g3(i11)).setLayoutManager(centerLayoutManager);
        ((RecyclerView) g3(i11)).setAdapter(p3());
        v0 p32 = p3();
        if (p32 != null) {
            p32.setNewData(this.f4420j);
        }
        v0 p33 = p3();
        if (p33 != null) {
            p33.setOnItemClickListener(new d2(this));
        }
        this.f4419i.clear();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i12 = 0; i12 < 7; i12++) {
            this.f4419i.add(y6.b.b(((long) (i12 * 24 * 60 * 60 * 1000)) + currentTimeMillis, "yyyy/MM/dd"));
        }
        int size = this.f4419i.size();
        for (int i13 = 0; i13 < size; i13++) {
            HashMap hashMap = this.f4417g;
            Object obj = this.f4419i.get(i13);
            t9.i.f(obj, "dateList[i]");
            hashMap.put(obj, new ArrayList());
        }
        w3();
    }

    public final v0 p3() {
        return (v0) this.f4423m.getValue();
    }

    public final void q3() {
        w wVar = new w();
        wVar.f19600a = y6.a.d("yyyy/MM/dd HH:mm");
        w wVar2 = new w();
        wVar2.f19600a = "";
        w wVar3 = new w();
        wVar3.f19600a = "";
        w wVar4 = new w();
        wVar4.f19600a = "";
        w wVar5 = new w();
        wVar5.f19600a = "";
        int size = this.f4419i.size();
        for (int i10 = 0; i10 < size; i10++) {
            HashMap hashMap = this.f4417g;
            Object obj = this.f4419i.get(i10);
            t9.i.f(obj, "dateList[i]");
            hashMap.put(obj, new ArrayList());
        }
        Observable.create(new h2(this, wVar2, wVar3, wVar4, wVar5, wVar)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i2(new b(this)), new j2(new c(this)));
    }

    @xa.j
    public final void updateFavStatus(UpdateFavStatusEvent updateFavStatusEvent) {
        t9.i.g(updateFavStatusEvent, "event");
    }

    public final void v3(List list) {
        List<Fragment> s02 = getChildFragmentManager().s0();
        t9.i.f(s02, "childFragmentManager.fragments");
        for (Fragment fragment : s02) {
            if (fragment instanceof g0) {
                ((g0) fragment).P0(list);
            }
        }
    }

    public final void w3() {
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) g3(R$id.mLlNoData);
        if (autoLinearLayout != null) {
            autoLinearLayout.setVisibility(8);
        }
        LruCache lruCache = this.f4416f;
        r.a aVar = r.f4434j;
        if (lruCache.get(aVar.a()) != null) {
            q3();
        } else {
            w6.i.f9510g.b().F1(aVar.a(), aVar.c()).compose(O2()).filter(new e2(g.f11009a)).map(new f2(h.f11010a)).doOnNext(new g2(new i(this))).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this));
        }
    }
}
