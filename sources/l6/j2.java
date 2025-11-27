package l6;

import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import g5.j3;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import j6.l;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import t9.i;
import t9.j;
import w6.i;

public final class j2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18471a;

    /* renamed from: b  reason: collision with root package name */
    public final l f18472b;

    /* renamed from: c  reason: collision with root package name */
    public int f18473c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f18474d = -1;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f18475e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f18476f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List f18477g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f18478h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final long f18479i = 10;

    /* renamed from: j  reason: collision with root package name */
    public Disposable f18480j;

    public static final class a extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j2 f18481a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j2 j2Var) {
            super(1);
            this.f18481a = j2Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
            if (com.mobile.brasiltv.utils.b0.I(r0.getChildColumnList()) == false) goto L_0x0033;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult r3) {
            /*
                r2 = this;
                java.lang.String r0 = "it"
                t9.i.g(r3, r0)
                l6.j2 r0 = r2.f18481a
                mobile.com.requestframe.utils.response.ColumnContentsBean r1 = r3.getData()
                if (r1 == 0) goto L_0x0018
                java.lang.Integer r1 = r1.getTotalSize()
                if (r1 == 0) goto L_0x0018
                int r1 = r1.intValue()
                goto L_0x0019
            L_0x0018:
                r1 = -1
            L_0x0019:
                r0.f18474d = r1
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r3.getData()
                if (r0 == 0) goto L_0x0033
                mobile.com.requestframe.utils.response.ColumnContentsBean r0 = r3.getData()
                t9.i.d(r0)
                java.util.List r0 = r0.getChildColumnList()
                boolean r0 = com.mobile.brasiltv.utils.b0.I(r0)
                if (r0 != 0) goto L_0x003c
            L_0x0033:
                l6.j2 r0 = r2.f18481a
                j6.l r0 = r0.B()
                r0.b()
            L_0x003c:
                mobile.com.requestframe.utils.response.ColumnContentsBean r3 = r3.getData()
                if (r3 == 0) goto L_0x0047
                java.util.List r3 = r3.getChildColumnList()
                goto L_0x0048
            L_0x0047:
                r3 = 0
            L_0x0048:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.j2.a.invoke(mobile.com.requestframe.utils.response.GetColumnContentsResult):java.util.List");
        }
    }

    public static final class b extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18482a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            i.g(list, "it");
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j2 f18483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18484b;

        public static final class a extends j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18485a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18485a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18485a, (String) null, (String) null, 6, (Object) null);
                if (!i.b(na.d.c(this.f18485a), "no_report_type")) {
                    p10 = y.p(yVar, this.f18485a, (String) null, (String) null, 6, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public c(j2 j2Var, int i10) {
            this.f18483a = j2Var;
            this.f18484b = i10;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "list");
            this.f18483a.f18475e.addAll(list);
            this.f18483a.E(this.f18484b);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18483a.f18477g.add(disposable);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18483a.B().c(str);
            x.f12622a.w(this.f18483a.y(), new a(str));
        }
    }

    public static final class d extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18486a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(ShelveDataBean shelveDataBean) {
            i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j2 f18487a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f18488b;

        public static final class a extends j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18489a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18489a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18489a, (String) null, (String) null, 6, (Object) null);
                if (!i.b(na.d.c(this.f18489a), "no_report_type")) {
                    p10 = y.p(yVar, this.f18489a, (String) null, (String) null, 6, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public e(j2 j2Var, ChildColumnList childColumnList) {
            this.f18487a = j2Var;
            this.f18488b = childColumnList;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "t");
            this.f18487a.K(this.f18488b.getId(), list);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18487a.f18477g.add(disposable);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18487a.B().c(str);
            x.f12622a.w(this.f18487a.y(), new a(str));
        }
    }

    public static final class f extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j2 f18490a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(j2 j2Var) {
            super(1);
            this.f18490a = j2Var;
        }

        public final void b(ChildColumnList childColumnList) {
            ArrayList o10 = this.f18490a.f18476f;
            i.f(childColumnList, "it");
            o10.add(new j3(childColumnList, i9.j.d()));
            this.f18490a.z(childColumnList);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ChildColumnList) obj);
            return t.f17319a;
        }
    }

    public static final class g extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18491a = new g();

        public g() {
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

    public j2(f5.c cVar, l lVar) {
        i.g(cVar, com.umeng.analytics.pro.f.X);
        i.g(lVar, "view");
        this.f18471a = cVar;
        this.f18472b = lVar;
    }

    public static final List A(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void F(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void G(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(j2 j2Var) {
        i.g(j2Var, "this$0");
        j2Var.I();
    }

    public static final List w(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean x(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final l B() {
        return this.f18472b;
    }

    public void C() {
        int i10 = this.f18478h;
        if (((long) this.f18474d) > ((long) i10) * this.f18479i) {
            int i11 = i10 + 1;
            this.f18478h = i11;
            D(i11);
            return;
        }
        this.f18472b.n1();
    }

    public final void D(int i10) {
        int i11 = this.f18473c;
        if (i11 != -1) {
            v(i11, i10);
        }
    }

    public final void E(int i10) {
        boolean z10 = true;
        long j10 = ((long) (i10 - 1)) * this.f18479i;
        if (j10 < ((long) this.f18475e.size())) {
            Disposable disposable = this.f18480j;
            if (disposable == null || disposable.isDisposed()) {
                z10 = false;
            }
            if (z10) {
                Disposable disposable2 = this.f18480j;
                i.d(disposable2);
                disposable2.dispose();
            }
            this.f18480j = Observable.fromIterable(this.f18475e).skip(j10).take(this.f18479i).compose(p0.a()).subscribe(new f2(new f(this)), new g2(g.f18491a), new h2(this));
            return;
        }
        this.f18472b.n1();
    }

    public final void I() {
        this.f18472b.f(this.f18476f);
        this.f18472b.u0();
    }

    public void J(ChildColumnList childColumnList) {
        i.g(childColumnList, "column");
        this.f18472b.a();
        b0.U(this, "column.code " + childColumnList.getCode());
        u();
        this.f18478h = 1;
        this.f18475e.clear();
        this.f18476f.clear();
        this.f18473c = childColumnList.getId();
        D(this.f18478h);
    }

    public final void K(int i10, List list) {
        if (!this.f18476f.isEmpty()) {
            int i11 = 0;
            for (Object next : this.f18476f) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (((j3) next).a().getId() == i10) {
                    ((j3) this.f18476f.get(i11)).c(list);
                    this.f18472b.r(i11);
                }
                i11 = i12;
            }
        }
    }

    public void e() {
    }

    public void g() {
        Disposable disposable = this.f18480j;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f18480j;
            i.d(disposable2);
            disposable2.dispose();
        }
        u();
    }

    public final void u() {
        for (Disposable disposable : this.f18477g) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f18477g.clear();
    }

    public final void v(int i10, int i11) {
        w6.i.f9510g.b().h1(i10, true, i11, (int) this.f18479i).map(new d2(new a(this))).filter(new e2(b.f18482a)).subscribe(new c(this, i11));
    }

    public final f5.c y() {
        return this.f18471a;
    }

    public final void z(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 1000, 1, (Integer) null, (Integer) null)).map(new i2(d.f18486a)).subscribe(new e(this, childColumnList));
    }
}
