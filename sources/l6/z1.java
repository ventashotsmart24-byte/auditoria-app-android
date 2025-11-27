package l6;

import android.content.Context;
import android.os.SystemClock;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.adView.MemAdShowControl;
import com.msandroid.mobile.R;
import g5.e1;
import g5.o2;
import g5.p2;
import g5.s1;
import g5.t1;
import g5.u1;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.RecommendList;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import t9.a0;
import t9.w;
import w6.i;

public final class z1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18638a;

    /* renamed from: b  reason: collision with root package name */
    public final j6.j f18639b;

    /* renamed from: c  reason: collision with root package name */
    public ChildColumnList f18640c;

    /* renamed from: d  reason: collision with root package name */
    public String f18641d = "";

    /* renamed from: e  reason: collision with root package name */
    public List f18642e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List f18643f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List f18644g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f18645h = -1;

    /* renamed from: i  reason: collision with root package name */
    public final Set f18646i = new LinkedHashSet();

    /* renamed from: j  reason: collision with root package name */
    public List f18647j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List f18648k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public HashMap f18649l = new HashMap();

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18650a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z1 z1Var) {
            super(1);
            this.f18650a = z1Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x001a, code lost:
            if (com.mobile.brasiltv.utils.b0.I(r0.getChildColumnList()) == false) goto L_0x001c;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult r2) {
            /*
                r1 = this;
                java.lang.String r0 = "it"
                t9.i.g(r2, r0)
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r2.getData()
                if (r0 == 0) goto L_0x001c
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r2.getData()
                t9.i.d(r0)
                java.util.List r0 = r0.getChildColumnList()
                boolean r0 = com.mobile.brasiltv.utils.b0.I(r0)
                if (r0 != 0) goto L_0x0025
            L_0x001c:
                l6.z1 r0 = r1.f18650a
                j6.j r0 = r0.Y()
                r0.b()
            L_0x0025:
                mobile.com.requestframe.utils.response.ColumnContentsBean r2 = r2.getData()
                if (r2 == 0) goto L_0x0030
                java.util.List r2 = r2.getChildColumnList()
                goto L_0x0031
            L_0x0030:
                r2 = 0
            L_0x0031:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.z1.a.invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult):java.util.List");
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18651a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18652a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f18653b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18654a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18654a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18654a, yVar.b(), (String) null, 4, (Object) null);
                if (!t9.i.b(na.d.c(this.f18654a), "no_report_type")) {
                    p10 = y.p(yVar, this.f18654a, yVar.b(), (String) null, 4, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public c(z1 z1Var, ChildColumnList childColumnList) {
            this.f18652a = z1Var;
            this.f18653b = childColumnList;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "it");
            this.f18652a.f18644g = a0.b(list);
            this.f18652a.f18645h = -1;
            this.f18652a.f18646i.clear();
            this.f18652a.Z(this.f18653b, list);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18652a.f18643f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18652a.Y().c(str);
            Context context = this.f18652a.M().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18655a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(VodRecommendsRespone vodRecommendsRespone) {
            t9.i.g(vodRecommendsRespone, "it");
            RecommendList data = vodRecommendsRespone.getData();
            if (data != null) {
                return data.getRecommendList();
            }
            return null;
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18656a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18657a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18657a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18657a, yVar.g(), (String) null, 4, (Object) null));
            }
        }

        public e(z1 z1Var) {
            this.f18656a = z1Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (b0.I(list)) {
                this.f18656a.f18647j.clear();
                this.f18656a.f18647j.addAll(list);
                if (this.f18656a.L().size() > 0) {
                    this.f18656a.e0();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18656a.f18643f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18656a.M().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18658a = new f();

        public f() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(ShelveDataBean shelveDataBean) {
            t9.i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18659a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f18660b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18661a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18661a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18661a, yVar.k(), (String) null, 4, (Object) null);
                if (!t9.i.b(na.d.c(this.f18661a), "no_report_type")) {
                    p10 = y.p(yVar, this.f18661a, yVar.k(), (String) null, 4, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public g(z1 z1Var, ChildColumnList childColumnList) {
            this.f18659a = z1Var;
            this.f18660b = childColumnList;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            this.f18659a.f18649l.put(Integer.valueOf(this.f18660b.getId()), list);
            this.f18659a.f0(this.f18660b.getId(), list);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18659a.f18643f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18659a.Y().k();
            this.f18659a.Y().c(str);
            Context context = this.f18659a.M().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18662a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f18663b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(z1 z1Var, w wVar) {
            super(1);
            this.f18662a = z1Var;
            this.f18663b = wVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                z1 z1Var = this.f18662a;
                Object obj = this.f18663b.f19600a;
                t9.i.d(obj);
                z1Var.a0((ColumnContentsBean) obj);
                return;
            }
            this.f18662a.V();
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final i f18664a = new i();

        public i() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            List<ChildColumnList> list;
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                list = data.getChildColumnList();
            } else {
                list = null;
            }
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final j f18665a = new j();

        public j() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            t9.i.d(data);
            return data.getChildColumnList();
        }
    }

    public static final class k extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18666a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f18667a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f18667a = columnContentsBean;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f8315a, "special_column", m8.a.a().toJson((Object) this.f18667a));
                String f10 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
                t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f8315a, "service_time_hot_search", String.valueOf((i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f18668a = new b();

            public b() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return t.f17319a;
            }

            public final void invoke(Throwable th) {
                th.printStackTrace();
            }
        }

        public static final class c extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18669a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f18669a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18669a, yVar.b(), (String) null, 4, (Object) null));
            }
        }

        public k(z1 z1Var) {
            this.f18666a = z1Var;
        }

        public static final void i(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void j(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        /* renamed from: h */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (b0.I(list)) {
                this.f18666a.f18648k.clear();
                this.f18666a.f18648k.addAll(list);
                if (this.f18666a.L().size() > 7) {
                    this.f18666a.i0();
                }
                Observable.just("ioSchedulers").compose(p0.c()).subscribe(new a2(new a(new ColumnContentsBean((Integer) null, list))), new b2(b.f18668a));
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18666a.f18643f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18666a.M().getContext();
            if (context != null) {
                x.f12622a.w(context, new c(str));
            }
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18670a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(z1 z1Var) {
            super(1);
            this.f18670a = z1Var;
        }

        public final void b(Integer num) {
            j6.j Y = this.f18670a.Y();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            Y.r(num.intValue());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z1 f18671a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(z1 z1Var) {
            super(1);
            this.f18671a = z1Var;
        }

        public final void b(Integer num) {
            j6.j Y = this.f18671a.Y();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            Y.r(num.intValue());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public z1(b6.f fVar, j6.j jVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(jVar, "view");
        this.f18638a = fVar;
        this.f18639b = jVar;
    }

    public static final List J(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean K(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List P(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List R(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void T(w wVar, w wVar2, ObservableEmitter observableEmitter) {
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f8315a, "special_column", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b10;
        wVar.f19600a = str;
        if (!b0.J(str)) {
            Gson a10 = m8.a.a();
            Object obj = wVar.f19600a;
            t9.i.d(obj);
            wVar2.f19600a = a10.fromJson((String) obj, ColumnContentsBean.class);
        }
        if (wVar2.f19600a != null) {
            int d10 = na.f.d(na.a.f8315a, "column_cache_time", 0);
            String f10 = na.f.f(na.a.f8315a, "service_time_hot_search", "0");
            t9.i.f(f10, "getStrings(AppHelper.mCo…TIME_SPECIAL_COLUMN, \"0\")");
            long parseLong = Long.parseLong(f10);
            String f11 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            long a11 = (i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
            if (parseLong == 0 || d10 == 0 || a11 >= parseLong + ((long) (d10 * 60 * 1000))) {
                observableEmitter.onNext(Boolean.FALSE);
            } else {
                observableEmitter.onNext(Boolean.TRUE);
            }
        } else {
            observableEmitter.onNext(Boolean.FALSE);
        }
    }

    public static final void U(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List X(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void g0(z1 z1Var, int i10, List list, ObservableEmitter observableEmitter) {
        boolean z10;
        t9.i.g(z1Var, "this$0");
        t9.i.g(list, "$list");
        t9.i.g(observableEmitter, "it");
        int i11 = 0;
        for (Object next : z1Var.f18642e) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                i9.j.j();
            }
            MultiItemEntity multiItemEntity = (MultiItemEntity) next;
            if (multiItemEntity instanceof g5.f1) {
                ChildColumnList a10 = ((g5.f1) multiItemEntity).a();
                if (a10 == null || a10.getId() != i10) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    Object obj = z1Var.f18642e.get(i11);
                    t9.i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.RecommenFragmentNormal");
                    ((g5.f1) obj).c(list);
                    observableEmitter.onNext(Integer.valueOf(i11));
                }
            }
            i11 = i12;
        }
    }

    public static final void h0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void j0(z1 z1Var, ObservableEmitter observableEmitter) {
        t9.i.g(z1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        int i10 = 0;
        for (Object next : z1Var.f18642e) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (((MultiItemEntity) next) instanceof u1) {
                observableEmitter.onNext(Integer.valueOf(i10));
            }
            i10 = i11;
        }
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void G(List list) {
        t9.i.g(list, "datas");
        if (s6.a.f9335a.a().r()) {
            int i10 = 0;
            int i11 = -1;
            for (Object next : list) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (((MultiItemEntity) next).getItemType() == a6.d.f10667a.f()) {
                    i11 = i10;
                }
                i10 = i12;
            }
            if (i11 == -1 && list.size() > 0) {
                list.add(1, new g5.b0());
            }
        }
    }

    public final void H() {
        for (Disposable disposable : this.f18643f) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f18643f.clear();
    }

    public final void I(ChildColumnList childColumnList) {
        w6.i.i1(w6.i.f9510g.b(), childColumnList.getId(), false, 0, 0, 14, (Object) null).compose(this.f18638a.O2()).map(new r1(new a(this))).filter(new s1(b.f18651a)).subscribe(new c(this, childColumnList));
    }

    public final List L() {
        return this.f18642e;
    }

    public final b6.f M() {
        return this.f18638a;
    }

    public final void N(int i10, int i11) {
        List list = this.f18644g;
        if (i10 <= i11) {
            while (true) {
                if (i10 >= 0 && i10 < list.size() && (i10 > this.f18645h || !this.f18646i.contains(Integer.valueOf(i10)))) {
                    Q((ChildColumnList) list.get(i10));
                    this.f18645h = i10;
                    this.f18646i.add(Integer.valueOf(i10));
                }
                if (i10 != i11) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public final void O(ChildColumnList childColumnList) {
        boolean z10;
        String a10 = a6.b.f10666a.a(childColumnList.getCode());
        this.f18641d = a10;
        if (a10.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            w6.i.f9510g.b().H1(i9.j.c(this.f18641d)).compose(this.f18638a.O2()).map(new u1(d.f18655a)).subscribe(new e(this));
        }
    }

    public final void Q(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 20, 1, (Integer) null, (Integer) null)).compose(this.f18638a.O2()).map(new t1(f.f18658a)).subscribe(new g(this, childColumnList));
    }

    public final void S(ChildColumnList childColumnList) {
        String code = childColumnList.getCode();
        if (t9.i.b(code, w6.i.f9510g.v() + "_movies") && RootColumnId.specialColumn != null) {
            w wVar = new w();
            w wVar2 = new w();
            Observable.create(new n1(wVar, wVar2)).compose(p0.b()).subscribe(new q1(new h(this, wVar2)));
        }
    }

    public final void V() {
        w6.i.i1(w6.i.f9510g.b(), RootColumnId.specialColumn.getId(), true, 0, 10, 4, (Object) null).compose(this.f18638a.O2()).filter(new o1(i.f18664a)).map(new p1(j.f18665a)).subscribe(new k(this));
    }

    public final j6.j Y() {
        return this.f18639b;
    }

    public final void Z(ChildColumnList childColumnList, List list) {
        boolean z10;
        this.f18642e.clear();
        int i10 = 0;
        if (this.f18641d.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f18642e.add(0, new s1(childColumnList.getCode(), childColumnList.getId(), this.f18647j));
        }
        String code = childColumnList.getCode();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.v());
        sb.append("_movies");
        if (t9.i.b(code, sb.toString()) && ((t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2")) && s6.a.f9335a.a().r())) {
            if (this.f18642e.size() > 0) {
                this.f18642e.add(1, new g5.b0());
            } else {
                this.f18642e.add(0, new g5.b0());
            }
        }
        if (b0.I(list)) {
            for (Object next : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList2 = (ChildColumnList) next;
                if (i10 == 4) {
                    String code2 = childColumnList.getCode();
                    if (t9.i.b(code2, w6.i.f9510g.v() + "_movies")) {
                        this.f18642e.add(new u1(RootColumnId.specialColumn, this.f18648k));
                    }
                }
                String style = childColumnList2.getStyle();
                if (t9.i.b(style, "top")) {
                    List list2 = this.f18642e;
                    List list3 = (List) this.f18649l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list3 == null) {
                        list3 = i9.j.d();
                    }
                    list2.add(new o2(childColumnList2, list3, i10));
                } else if (t9.i.b(style, "normal")) {
                    List list4 = this.f18642e;
                    List list5 = (List) this.f18649l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list5 == null) {
                        list5 = i9.j.d();
                    }
                    list4.add(new p2(childColumnList2, list5, i10));
                } else {
                    List list6 = this.f18642e;
                    List list7 = (List) this.f18649l.get(Integer.valueOf(childColumnList2.getId()));
                    if (list7 == null) {
                        list7 = i9.j.d();
                    }
                    list6.add(new t1(childColumnList2, list7, i10));
                }
                i10 = i11;
            }
        }
        d0();
        this.f18639b.f(this.f18642e);
    }

    public final void a0(ColumnContentsBean columnContentsBean) {
        this.f18648k.clear();
        List list = this.f18648k;
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        list.addAll(childColumnList);
        if (this.f18642e.size() > 7) {
            i0();
        }
    }

    public void b0(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "column");
        this.f18639b.a();
        H();
        this.f18642e.clear();
        this.f18640c = childColumnList;
        O(childColumnList);
        S(childColumnList);
        I(childColumnList);
    }

    public void c0(List list) {
        t9.i.g(list, "datas");
        if (s6.a.f9335a.a().r()) {
            int i10 = 0;
            int i11 = -1;
            for (Object next : list) {
                int i12 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                if (((MultiItemEntity) next).getItemType() == a6.d.f10667a.f()) {
                    i11 = i10;
                }
                i10 = i12;
            }
            if (i11 != -1 && list.size() > i11) {
                list.remove(i11);
            }
        }
    }

    public final void d0() {
        Integer num;
        ChildColumnList childColumnList = this.f18640c;
        if (childColumnList != null) {
            num = Integer.valueOf(childColumnList.getId());
        } else {
            num = null;
        }
        if (num != null) {
            ChildColumnList childColumnList2 = this.f18640c;
            t9.i.d(childColumnList2);
            String code = childColumnList2.getCode();
            StringBuilder sb = new StringBuilder();
            i.c cVar = w6.i.f9510g;
            sb.append(cVar.v());
            sb.append("_Recommended");
            if (!t9.i.b(code, sb.toString())) {
                if (!t9.i.b(code, cVar.v() + "_movies")) {
                    if (!t9.i.b(code, cVar.v() + "_series")) {
                        if (!t9.i.b(code, cVar.v() + "_kids")) {
                            if (t9.i.b(code, cVar.v() + "_animes") && this.f18642e.size() > 0) {
                                List list = this.f18642e;
                                String string = this.f18638a.getString(R.string.home_anime_ad_id);
                                t9.i.f(string, "frag.getString(R.string.home_anime_ad_id)");
                                list.add(2, new e1(string, a6.a.f10646a.o(), new MemAdShowControl(), true));
                            }
                        } else if (this.f18642e.size() > 0) {
                            List list2 = this.f18642e;
                            String string2 = this.f18638a.getString(R.string.home_kids_ad_id);
                            t9.i.f(string2, "frag.getString(R.string.home_kids_ad_id)");
                            list2.add(2, new e1(string2, a6.a.f10646a.p(), new MemAdShowControl(), true));
                        }
                    } else if (this.f18642e.size() > 0) {
                        List list3 = this.f18642e;
                        String string3 = this.f18638a.getString(R.string.home_tv_ad_id);
                        t9.i.f(string3, "frag.getString(R.string.home_tv_ad_id)");
                        list3.add(2, new e1(string3, a6.a.f10646a.q(), new MemAdShowControl(), true));
                    }
                } else if (this.f18642e.size() > 0) {
                    List list4 = this.f18642e;
                    String string4 = this.f18638a.getString(R.string.home_movie_first_banner_id);
                    t9.i.f(string4, "frag.getString(R.string.…me_movie_first_banner_id)");
                    list4.add(2, new e1(string4, a6.a.f10646a.c(), new MemAdShowControl(), true));
                }
            } else if (this.f18642e.size() > 0) {
                List list5 = this.f18642e;
                String string5 = this.f18638a.getString(R.string.home1_ad_id);
                t9.i.f(string5, "frag.getString(R.string.home1_ad_id)");
                list5.add(2, new e1(string5, a6.a.f10646a.j(), new MemAdShowControl(), true));
            }
        }
    }

    public void e() {
    }

    public final void e0() {
        this.f18639b.r(0);
    }

    public final void f0(int i10, List list) {
        if (!this.f18642e.isEmpty()) {
            Observable.create(new x1(this, i10, list)).compose(p0.a()).subscribe(new y1(new l(this)));
        }
    }

    public void g() {
    }

    public final void i0() {
        if (!this.f18642e.isEmpty()) {
            Observable.create(new v1(this)).compose(p0.a()).subscribe(new w1(new m(this)));
        }
    }
}
