package k6;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.q0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.n0;
import i6.o0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.bean.SearchByNameBean;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.SearchByNameResult;
import mobile.com.requestframe.utils.response.SearchData;
import mobile.com.requestframe.utils.response.SearchItem;
import mobile.com.requestframe.utils.response.SearchShelveItem;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import s9.l;
import t9.u;
import w6.i;

public final class s3 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18055a;

    /* renamed from: b  reason: collision with root package name */
    public final o0 f18056b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18057c = 50;

    /* renamed from: d  reason: collision with root package name */
    public int f18058d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f18059e = 1;

    /* renamed from: f  reason: collision with root package name */
    public String f18060f = "";

    /* renamed from: g  reason: collision with root package name */
    public boolean f18061g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18062h;

    /* renamed from: i  reason: collision with root package name */
    public Disposable f18063i;

    /* renamed from: j  reason: collision with root package name */
    public int f18064j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f18065k = 10;

    /* renamed from: l  reason: collision with root package name */
    public int f18066l;

    /* renamed from: m  reason: collision with root package name */
    public List f18067m;

    /* renamed from: n  reason: collision with root package name */
    public long f18068n;

    public static final class a extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18069a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                return data.getChildColumnList();
            }
            return null;
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18070a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(s3 s3Var) {
            super(1);
            this.f18070a = s3Var;
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            if (list.isEmpty()) {
                this.f18070a.H().v2();
            }
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18071a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(s3 s3Var) {
            super(1);
            this.f18071a = s3Var;
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            String f10 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            na.f.k(na.a.f8315a, "service_time_hot_search", String.valueOf((i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            na.f.j(na.a.f8315a, "hot_search_column", ((ChildColumnList) list.get(0)).getId());
            i.c cVar = w6.i.f9510g;
            return cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), ((ChildColumnList) list.get(0)).getId(), "2", 100, 1, (Integer) null, (Integer) null)).compose(this.f18071a.z().O1());
        }
    }

    public static final class d extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18072a = new d();

        public d() {
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

    public static final class e extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f18073a = new e();

        public e() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (b0.K(((ShelveAsset) next).getName())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    public static final class f extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18074a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18075a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18075a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18075a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public f(s3 s3Var) {
            this.f18074a = s3Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            int i10;
            t9.i.g(list, "it");
            super.onNext(list);
            if (list.isEmpty()) {
                this.f18074a.H().v2();
                return;
            }
            this.f18074a.f18067m = list;
            this.f18074a.f18066l = list.size() / this.f18074a.f18065k;
            s3 s3Var = this.f18074a;
            int t10 = s3Var.f18066l;
            if (list.size() % this.f18074a.f18065k == 0) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            s3Var.f18066l = t10 + i10;
            if (this.f18074a.f18066l > 3) {
                this.f18074a.f18066l = 3;
            }
            this.f18074a.P();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            x.f12622a.w(this.f18074a.z(), new a(str));
        }
    }

    public static final class g extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18076a = new g();

        public g() {
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

    public static final class h extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f18077a = new h();

        public h() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (b0.K(((ShelveAsset) next).getName())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    public static final class i extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18078a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18079a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18079a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18079a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public i(s3 s3Var) {
            this.f18078a = s3Var;
        }

        /* renamed from: f */
        public void onNext(List list) {
            int i10;
            t9.i.g(list, "it");
            super.onNext(list);
            if (list.isEmpty()) {
                this.f18078a.H().v2();
                return;
            }
            this.f18078a.f18067m = list;
            this.f18078a.f18066l = list.size() / this.f18078a.f18065k;
            s3 s3Var = this.f18078a;
            int t10 = s3Var.f18066l;
            if (list.size() % this.f18078a.f18065k == 0) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            s3Var.f18066l = t10 + i10;
            if (this.f18078a.f18066l > 3) {
                this.f18078a.f18066l = 3;
            }
            this.f18078a.P();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            x.f12622a.w(this.f18078a.z(), new a(str));
        }
    }

    public static final class j extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18080a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u f18081b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(s3 s3Var, u uVar) {
            super(1);
            this.f18080a = s3Var;
            this.f18081b = uVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                this.f18080a.I(this.f18081b.f19598a);
            } else {
                this.f18080a.A();
            }
        }
    }

    public static final class k extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s3 f18082a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18083b;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18084a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18084a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18084a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public k(s3 s3Var, String str) {
            this.f18082a = s3Var;
            this.f18083b = str;
        }

        /* renamed from: f */
        public void onNext(SearchByNameResult searchByNameResult) {
            t9.i.g(searchByNameResult, "t");
            this.f18082a.H().T0();
            this.f18082a.O(searchByNameResult, this.f18083b);
        }

        public void onComplete() {
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18082a.W(disposable);
            this.f18082a.U(true);
            this.f18082a.H().h();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18082a.H().T0();
            this.f18082a.H().M0(this.f18083b);
            x.f12622a.w(this.f18082a.z(), new a(str));
        }
    }

    public s3(f5.c cVar, o0 o0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(o0Var, "view");
        this.f18055a = cVar;
        this.f18056b = o0Var;
        o0Var.Y0(this);
    }

    public static final List B(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean C(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ObservableSource D(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final List E(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List F(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List J(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List K(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void M(u uVar, ObservableEmitter observableEmitter) {
        boolean z10;
        t9.i.g(uVar, "$cacheId");
        t9.i.g(observableEmitter, "it");
        int d10 = na.f.d(na.a.f8315a, "hot_search_column", 0);
        uVar.f19598a = d10;
        if (d10 != 0) {
            int d11 = na.f.d(na.a.f8315a, "column_cache_time", 0);
            String f10 = na.f.f(na.a.f8315a, "service_time_hot_search", "0");
            t9.i.f(f10, "getStrings(AppHelper.mCo…ICE_TIME_HOT_SEARCH, \"0\")");
            long parseLong = Long.parseLong(f10);
            String f11 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            long a10 = (i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
            StringBuilder sb = new StringBuilder();
            sb.append("hot column: nowTime: ");
            sb.append(a10);
            sb.append(", lastCacheTime: ");
            sb.append(parseLong);
            sb.append(", cacheTime: ");
            int i10 = 60000 * d11;
            sb.append(i10);
            sb.append(", needRequest= ");
            if (a10 > ((long) i10) + parseLong) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            k7.f.e(sb.toString(), new Object[0]);
            if (parseLong == 0 || d11 == 0 || a10 >= parseLong + ((long) (d11 * 60 * 1000))) {
                observableEmitter.onNext(Boolean.FALSE);
            } else {
                observableEmitter.onNext(Boolean.TRUE);
            }
        } else {
            observableEmitter.onNext(Boolean.FALSE);
        }
    }

    public static final void N(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void R(s3 s3Var, String str) {
        t9.i.g(s3Var, "this$0");
        t9.i.g(str, "$searchKey");
        q0.d(s3Var.f18055a, str);
    }

    public final void A() {
        w6.i.i1(w6.i.f9510g.b(), RootColumnId.hotSearchId, false, 0, 0, 14, (Object) null).compose(this.f18055a.O1()).map(new l3(a.f18069a)).filter(new m3(new b(this))).flatMap(new n3(new c(this))).map(new o3(d.f18072a)).map(new p3(e.f18073a)).subscribe(new f(this));
    }

    public String G() {
        return this.f18060f;
    }

    public final o0 H() {
        return this.f18056b;
    }

    public final void I(int i10) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", 100, 1, (Integer) null, (Integer) null)).compose(this.f18055a.O1()).map(new q3(g.f18076a)).map(new r3(h.f18077a)).subscribe(new i(this));
    }

    public final void L() {
        u uVar = new u();
        Observable.create(new i3(uVar)).compose(p0.b()).subscribe(new j3(new j(this, uVar)));
    }

    public final void O(SearchByNameResult searchByNameResult, String str) {
        int i10;
        if (t9.i.b(str, this.f18056b.X())) {
            if (searchByNameResult.getData() != null) {
                SearchData data = searchByNameResult.getData();
                t9.i.d(data);
                if (b0.I(data.getSearchItemList())) {
                    SearchData data2 = searchByNameResult.getData();
                    t9.i.d(data2);
                    if (data2.getTotalSize() % this.f18057c == 0) {
                        SearchData data3 = searchByNameResult.getData();
                        t9.i.d(data3);
                        i10 = data3.getTotalSize() / this.f18057c;
                    } else {
                        SearchData data4 = searchByNameResult.getData();
                        t9.i.d(data4);
                        i10 = (data4.getTotalSize() / this.f18057c) + 1;
                    }
                    this.f18059e = i10;
                    ArrayList arrayList = new ArrayList();
                    SearchData data5 = searchByNameResult.getData();
                    t9.i.d(data5);
                    for (SearchItem itemList : data5.getSearchItemList()) {
                        List<SearchShelveItem> itemList2 = itemList.getItemList();
                        t9.i.d(itemList2);
                        for (SearchShelveItem add : itemList2) {
                            arrayList.add(add);
                        }
                    }
                    if (b0.I(arrayList)) {
                        this.f18058d++;
                        this.f18056b.a1(arrayList, str, this.f18062h);
                        return;
                    } else if (this.f18058d == 1) {
                        this.f18056b.h0(8);
                        this.f18056b.C2(str);
                        return;
                    } else {
                        this.f18056b.j0();
                        return;
                    }
                }
            }
            this.f18056b.C2(str);
        }
    }

    public void P() {
        int i10;
        this.f18064j = (this.f18064j + 1) % this.f18066l;
        List list = this.f18067m;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        int i11 = this.f18064j;
        int i12 = this.f18065k;
        int i13 = i11 * i12;
        int i14 = i12 + i13;
        if (i10 != 0 && i13 < i10) {
            if (i14 <= i10) {
                i10 = i14;
            }
            o0 o0Var = this.f18056b;
            List list2 = this.f18067m;
            t9.i.d(list2);
            o0Var.F0(i13, list2.subList(i13, i10));
        }
    }

    public void Q(String str) {
        boolean z10;
        t9.i.g(str, "searchKey");
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            Schedulers.computation().createWorker().schedule(new k3(this, str));
        }
    }

    public void S(String str) {
        boolean z10;
        t9.i.g(str, "searchKey");
        if (TextUtils.isEmpty(str)) {
            this.f18056b.x0();
            return;
        }
        if (ba.t.W(str).toString().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (!y()) {
                this.f18056b.j0();
            } else if (!t9.i.b(G(), str)) {
                V(str);
                this.f18062h = true;
                this.f18058d = 1;
                this.f18059e = 1;
                T(str, 1);
            } else {
                int i10 = this.f18058d;
                if (i10 > this.f18059e) {
                    this.f18056b.j0();
                    return;
                }
                this.f18062h = false;
                T(str, i10);
            }
        }
    }

    public final void T(String str, int i10) {
        Disposable disposable;
        Disposable disposable2 = this.f18063i;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f18063i) != null) {
            disposable.dispose();
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().i2(new SearchByNameBean(cVar.J(), cVar.H(), cVar.v(), (Integer) null, str, "1", Integer.valueOf(this.f18057c), Integer.valueOf(i10), (String) null)).compose(this.f18055a.O1()).subscribe(new k(this, str));
        i1.o(this.f18055a, str);
    }

    public final void U(boolean z10) {
        this.f18061g = z10;
    }

    public void V(String str) {
        t9.i.g(str, "<set-?>");
        this.f18060f = str;
    }

    public final void W(Disposable disposable) {
        this.f18063i = disposable;
    }

    public void e() {
        L();
    }

    public void g() {
    }

    public final boolean y() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f18068n <= 500) {
            return false;
        }
        this.f18068n = currentTimeMillis;
        return true;
    }

    public final f5.c z() {
        return this.f18055a;
    }
}
