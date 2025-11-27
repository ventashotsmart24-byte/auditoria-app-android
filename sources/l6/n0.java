package l6;

import android.content.Context;
import android.os.SystemClock;
import b6.z;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.UpdateFullScreenSortEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i2.h;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import j6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import s9.l;
import t9.a0;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class n0 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18539a;

    /* renamed from: b  reason: collision with root package name */
    public final j6.d f18540b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18541a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            boolean z10;
            i.g(getColumnContentsResult, "it");
            if (getColumnContentsResult.getData() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18542a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            i.d(data);
            return data.getChildColumnList();
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18543a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            i.g(list, "it");
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18544a = new d();

        public d() {
            super(1);
        }

        public final void b(List list) {
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ChildColumnList childColumnList = (ChildColumnList) it.next();
                    if (i.b(childColumnList.getRestricted(), "1")) {
                        z.f4508u.i(childColumnList);
                    }
                    if (i.b(childColumnList.getFree(), "1")) {
                        z.f4508u.m(childColumnList);
                    }
                }
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f18545a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f18546a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f18546a = columnContentsBean;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f8315a, "live_column", m8.a.a().toJson((Object) this.f18546a));
                String f10 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
                i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f8315a, "service_time_live_column", String.valueOf((h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f18547a = new b();

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

        public static final class c extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18548a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f18548a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18548a, yVar.b(), (String) null, 4, (Object) null));
            }
        }

        public e(n0 n0Var) {
            this.f18545a = n0Var;
        }

        public static final void i(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void j(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        /* renamed from: h */
        public void onNext(List list) {
            i.g(list, "t");
            Observable.just("ioSchedulers").compose(p0.c()).subscribe(new o0(new a(new ColumnContentsBean((Integer) null, list))), new p0(b.f18547a));
            z.a aVar = z.f4508u;
            aVar.k(new ArrayList());
            ArrayList d10 = aVar.d();
            i.d(d10);
            d10.addAll(list);
            if (aVar.a() != null) {
                ArrayList d11 = aVar.d();
                i.d(d11);
                ChildColumnList a10 = aVar.a();
                i.d(a10);
                d11.remove(a10);
                ArrayList d12 = aVar.d();
                i.d(d12);
                ChildColumnList a11 = aVar.a();
                i.d(a11);
                d12.add(a11);
            }
            i.c cVar = w6.i.f9510g;
            if (!t9.i.b(cVar.A(), "1")) {
                ArrayList d13 = aVar.d();
                t9.i.d(d13);
                a0.a(d13).remove(aVar.a());
            }
            if (aVar.e() != null) {
                ArrayList d14 = aVar.d();
                t9.i.d(d14);
                ChildColumnList e10 = aVar.e();
                t9.i.d(e10);
                d14.remove(e10);
                if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                    ArrayList d15 = aVar.d();
                    t9.i.d(d15);
                    if (d15.size() > 0) {
                        ArrayList d16 = aVar.d();
                        t9.i.d(d16);
                        ChildColumnList e11 = aVar.e();
                        t9.i.d(e11);
                        d16.add(1, e11);
                    } else {
                        ArrayList d17 = aVar.d();
                        t9.i.d(d17);
                        ChildColumnList e12 = aVar.e();
                        t9.i.d(e12);
                        d17.add(e12);
                    }
                }
            }
            xa.c.c().m(new UpdateFullScreenSortEvent());
            this.f18545a.w().s();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18545a.w().onLoading();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18545a.w().c(str);
            Context context = this.f18545a.p().getContext();
            if (context != null) {
                x.f12622a.w(context, new c(str));
            }
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f18549a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f18550b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(n0 n0Var, w wVar) {
            super(1);
            this.f18549a = n0Var;
            this.f18550b = wVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                n0 n0Var = this.f18549a;
                Object obj = this.f18550b.f19600a;
                t9.i.d(obj);
                n0Var.q((ColumnContentsBean) obj);
                return;
            }
            this.f18549a.r();
        }
    }

    public n0(b6.f fVar, j6.d dVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(dVar, "view");
        this.f18539a = fVar;
        this.f18540b = dVar;
    }

    public static final boolean s(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List t(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean u(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void v(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(w wVar, w wVar2, ObservableEmitter observableEmitter) {
        boolean z10;
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f8315a, "live_column", "");
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
            String f10 = na.f.f(na.a.f8315a, "service_time_live_column", "0");
            t9.i.f(f10, "getStrings(AppHelper.mCo…CE_TIME_LIVE_COLUMN, \"0\")");
            long parseLong = Long.parseLong(f10);
            String f11 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            long a11 = (h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
            StringBuilder sb = new StringBuilder();
            sb.append("live column: nowTime: ");
            sb.append(a11);
            sb.append(", lastCacheTime: ");
            sb.append(parseLong);
            sb.append(", cacheTime: ");
            int i10 = 60000 * d10;
            sb.append(i10);
            sb.append(", needRequest= ");
            if (a11 > ((long) i10) + parseLong) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            k7.f.e(sb.toString(), new Object[0]);
            if (parseLong == 0 || d10 == 0 || a11 >= parseLong + ((long) (d10 * 60 * 1000))) {
                observableEmitter.onNext(Boolean.FALSE);
            } else {
                observableEmitter.onNext(Boolean.TRUE);
            }
        } else {
            observableEmitter.onNext(Boolean.FALSE);
        }
    }

    public static final void z(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final b6.f p() {
        return this.f18539a;
    }

    public final void q(ColumnContentsBean columnContentsBean) {
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        for (ChildColumnList childColumnList2 : childColumnList) {
            if (t9.i.b(childColumnList2.getRestricted(), "1")) {
                z.f4508u.i(childColumnList2);
            } else if (t9.i.b(childColumnList2.getFree(), "1")) {
                z.f4508u.m(childColumnList2);
            }
        }
        z.a aVar = z.f4508u;
        aVar.k(new ArrayList());
        ArrayList d10 = aVar.d();
        t9.i.d(d10);
        List<ChildColumnList> childColumnList3 = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList3);
        d10.addAll(childColumnList3);
        if (aVar.a() != null) {
            ArrayList d11 = aVar.d();
            t9.i.d(d11);
            ChildColumnList a10 = aVar.a();
            t9.i.d(a10);
            d11.remove(a10);
            ArrayList d12 = aVar.d();
            t9.i.d(d12);
            ChildColumnList a11 = aVar.a();
            t9.i.d(a11);
            d12.add(a11);
        }
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.A(), "1")) {
            ArrayList d13 = aVar.d();
            t9.i.d(d13);
            a0.a(d13).remove(aVar.a());
        }
        if (aVar.e() != null) {
            ArrayList d14 = aVar.d();
            t9.i.d(d14);
            ChildColumnList e10 = aVar.e();
            t9.i.d(e10);
            d14.remove(e10);
            if (t9.i.b(cVar.e(), "1") && (t9.i.b(cVar.I(), "1") || t9.i.b(cVar.I(), "2"))) {
                ArrayList d15 = aVar.d();
                t9.i.d(d15);
                if (d15.size() > 0) {
                    ArrayList d16 = aVar.d();
                    t9.i.d(d16);
                    ChildColumnList e11 = aVar.e();
                    t9.i.d(e11);
                    d16.add(1, e11);
                } else {
                    ArrayList d17 = aVar.d();
                    t9.i.d(d17);
                    ChildColumnList e12 = aVar.e();
                    t9.i.d(e12);
                    d17.add(e12);
                }
            }
        }
        xa.c.c().m(new UpdateFullScreenSortEvent());
        this.f18540b.s();
    }

    public final void r() {
        w6.i.i1(w6.i.f9510g.b(), RootColumnId.tvId, false, 0, 0, 14, (Object) null).compose(this.f18539a.O2()).filter(new j0(a.f18541a)).map(new k0(b.f18542a)).filter(new l0(c.f18543a)).doOnNext(new m0(d.f18544a)).subscribe(new e(this));
    }

    public final j6.d w() {
        return this.f18540b;
    }

    public void x() {
        if (RootColumnId.tvColumn == null) {
            b0.U(this, "tv column id == null");
            d.a.a(this.f18540b, (String) null, 1, (Object) null);
            return;
        }
        w wVar = new w();
        w wVar2 = new w();
        Observable.create(new h0(wVar, wVar2)).compose(p0.b()).subscribe(new i0(new f(this, wVar2)));
    }
}
