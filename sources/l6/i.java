package l6;

import android.content.Context;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.adView.MemAdShowControl;
import com.msandroid.mobile.R;
import g5.e1;
import g5.n;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ma.m;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.RecommendList;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import s9.l;
import t9.w;
import w6.i;

public final class i implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18439a;

    /* renamed from: b  reason: collision with root package name */
    public final i6.j f18440b;

    /* renamed from: c  reason: collision with root package name */
    public ChildColumnList f18441c;

    /* renamed from: d  reason: collision with root package name */
    public String f18442d = "";

    /* renamed from: e  reason: collision with root package name */
    public List f18443e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List f18444f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List f18445g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public HashMap f18446h = new HashMap();

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18447a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18448b;

        /* renamed from: l6.i$a$a  reason: collision with other inner class name */
        public static final class C0264a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18449a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0264a(String str) {
                super(1);
                this.f18449a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18449a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(i iVar, String str) {
            this.f18447a = iVar;
            this.f18448b = str;
        }

        /* renamed from: f */
        public void onNext(PwdCheckResult pwdCheckResult) {
            t9.i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = m.e(this.f18448b);
            t9.i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            this.f18447a.H().y(false);
            this.f18447a.H().I();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18447a.H().y(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18447a.H().y(false);
            if (b0.T(str, "aaa100012")) {
                f1.f12517a.w(R.string.pwd_wrong);
            } else if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                f1.f12517a.w(R.string.pi_connect_timeout);
            } else {
                Context context = this.f18447a.C().getContext();
                if (context != null) {
                    x.f12622a.w(context, new C0264a(str));
                }
            }
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18450a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(i iVar) {
            super(1);
            this.f18450a = iVar;
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
                l6.i r0 = r1.f18450a
                i6.j r0 = r0.H()
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
            throw new UnsupportedOperationException("Method not decompiled: l6.i.b.invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult):java.util.List");
        }
    }

    public static final class c extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18451a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class d extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f18453b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(i iVar, ChildColumnList childColumnList) {
            super(1);
            this.f18452a = iVar;
            this.f18453b = childColumnList;
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            this.f18452a.I(this.f18453b, list);
            return Observable.fromIterable(list).skip(6);
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18454a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18455a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w f18456b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, w wVar) {
                super(1);
                this.f18455a = str;
                this.f18456b = wVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18455a, (String) null, (String) null, 6, (Object) null);
                if (!t9.i.b(na.d.c(this.f18455a), "no_report_type")) {
                    w wVar = this.f18456b;
                    String c10 = na.d.c(this.f18455a);
                    t9.i.f(c10, "isEBReport(returnCode)");
                    wVar.f19600a = c10;
                    p10 = y.p(yVar, this.f18455a, (String) null, (String) null, 6, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public e(i iVar) {
            this.f18454a = iVar;
        }

        /* renamed from: f */
        public void onNext(ChildColumnList childColumnList) {
            t9.i.g(childColumnList, "t");
            this.f18454a.F(childColumnList);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18454a.f18444f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18454a.H().c(str);
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            Context context = this.f18454a.C().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str, wVar));
            }
        }
    }

    public static final class f extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18457a = new f();

        public f() {
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

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18458a;

        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18459a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18459a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18459a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public g(i iVar) {
            this.f18458a = iVar;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            if (b0.I(list)) {
                this.f18458a.f18445g.clear();
                this.f18458a.f18445g.addAll(list);
                if (this.f18458a.B().size() > 0) {
                    this.f18458a.L();
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18458a.f18444f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18458a.C().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class h extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f18460a = new h();

        public h() {
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

    /* renamed from: l6.i$i  reason: collision with other inner class name */
    public static final class C0265i extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18461a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f18462b;

        /* renamed from: l6.i$i$a */
        public static final class a extends t9.j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18463a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18463a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18463a, (String) null, (String) null, 6, (Object) null);
                if (!t9.i.b(na.d.c(this.f18463a), "no_report_type")) {
                    p10 = y.p(yVar, this.f18463a, (String) null, (String) null, 6, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public C0265i(i iVar, ChildColumnList childColumnList) {
            this.f18461a = iVar;
            this.f18462b = childColumnList;
        }

        /* renamed from: f */
        public void onNext(List list) {
            t9.i.g(list, "t");
            this.f18461a.f18446h.put(Integer.valueOf(this.f18462b.getId()), list);
            this.f18461a.M(this.f18462b.getId(), list);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18461a.f18444f.add(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18461a.H().k();
            this.f18461a.H().c(str);
            Context context = this.f18461a.C().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class j extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f18464a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(i iVar) {
            super(1);
            this.f18464a = iVar;
        }

        public final void b(Integer num) {
            i6.j H = this.f18464a.H();
            t9.i.f(num, FirebaseAnalytics.Param.INDEX);
            H.r(num.intValue());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public i(b6.f fVar, i6.j jVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(jVar, "view");
        this.f18439a = fVar;
        this.f18440b = jVar;
    }

    public static final ObservableSource A(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final List E(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final List G(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void N(i iVar, int i10, List list, ObservableEmitter observableEmitter) {
        boolean z10;
        t9.i.g(iVar, "this$0");
        t9.i.g(list, "$list");
        t9.i.g(observableEmitter, "it");
        int i11 = 0;
        for (Object next : iVar.f18443e) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                i9.j.j();
            }
            MultiItemEntity multiItemEntity = (MultiItemEntity) next;
            if (multiItemEntity instanceof n) {
                ChildColumnList a10 = ((n) multiItemEntity).a();
                if (a10 == null || a10.getId() != i10) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    Object obj = iVar.f18443e.get(i11);
                    t9.i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.CRFragNormalItem");
                    ((n) obj).d(list);
                    observableEmitter.onNext(Integer.valueOf(i11));
                }
            }
            i11 = i12;
        }
    }

    public static final void O(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final List y(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean z(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final List B() {
        return this.f18443e;
    }

    public final b6.f C() {
        return this.f18439a;
    }

    public final void D(ChildColumnList childColumnList) {
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.v());
        sb.append("_6");
        this.f18442d = sb.toString();
        cVar.b().H1(i9.j.c(this.f18442d)).compose(this.f18439a.O2()).map(new b(f.f18457a)).subscribe(new g(this));
    }

    public final void F(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 20, 1, (Integer) null, (Integer) null)).compose(this.f18439a.O2()).map(new f(h.f18460a)).subscribe(new C0265i(this, childColumnList));
    }

    public final i6.j H() {
        return this.f18440b;
    }

    public final void I(ChildColumnList childColumnList, List list) {
        boolean z10;
        this.f18443e.clear();
        int i10 = 0;
        if (this.f18442d.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f18443e.add(0, new g5.l(childColumnList.getCode(), childColumnList.getId(), this.f18445g));
        }
        if (list.size() > 6) {
            List subList = list.subList(0, 6);
            for (Object next : list.subList(6, list.size())) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList2 = (ChildColumnList) next;
                List list2 = this.f18443e;
                List list3 = (List) this.f18446h.get(Integer.valueOf(childColumnList2.getId()));
                if (list3 == null) {
                    list3 = i9.j.d();
                }
                list2.add(new n(childColumnList2, list3, i10 + 6));
                i10 = i11;
            }
            this.f18443e.add(2, new g5.m(subList));
        } else if (this.f18443e.size() >= 3) {
            this.f18443e.add(2, new g5.m(list));
        } else {
            this.f18443e.add(new g5.m(list));
        }
        K();
        this.f18440b.f(this.f18443e);
    }

    public void J(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "column");
        this.f18440b.a();
        v();
        this.f18443e.clear();
        this.f18441c = childColumnList;
        D(childColumnList);
        x(childColumnList);
    }

    public final void K() {
        Integer num;
        ChildColumnList childColumnList = this.f18441c;
        if (childColumnList != null) {
            num = Integer.valueOf(childColumnList.getId());
        } else {
            num = null;
        }
        if (num != null && this.f18443e.size() > 0) {
            List list = this.f18443e;
            String string = this.f18439a.getString(R.string.home_bl1_ad_id);
            t9.i.f(string, "frag.getString(R.string.home_bl1_ad_id)");
            list.add(2, new e1(string, a6.a.f10646a.g(), new MemAdShowControl(), true));
        }
    }

    public final void L() {
        this.f18440b.r(0);
    }

    public final void M(int i10, List list) {
        if (!this.f18443e.isEmpty()) {
            Observable.create(new g(this, i10, list)).compose(p0.a()).subscribe(new h(new j(this)));
        }
    }

    public void e() {
    }

    public void g() {
    }

    public final void v() {
        for (Disposable disposable : this.f18444f) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f18444f.clear();
    }

    public void w(String str) {
        t9.i.g(str, "password");
        w6.i b10 = w6.i.f9510g.b();
        String e10 = m.e(str);
        t9.i.f(e10, "md5(password)");
        b10.d2(e10).compose(this.f18439a.O2()).subscribe(new a(this, str));
    }

    public final void x(ChildColumnList childColumnList) {
        w6.i.i1(w6.i.f9510g.b(), childColumnList.getId(), false, 0, 0, 14, (Object) null).compose(this.f18439a.O2()).map(new c(new b(this))).filter(new d(c.f18451a)).flatMap(new e(new d(this, childColumnList))).subscribe(new e(this));
    }
}
