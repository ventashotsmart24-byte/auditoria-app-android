package l6;

import android.content.Context;
import android.os.SystemClock;
import b6.f;
import com.google.gson.Gson;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i2.h;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import j6.m;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;

public final class p2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18559a;

    /* renamed from: b  reason: collision with root package name */
    public final m f18560b;

    /* renamed from: c  reason: collision with root package name */
    public List f18561c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f18563b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p2 p2Var, w wVar) {
            super(1);
            this.f18562a = p2Var;
            this.f18563b = wVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            i.f(bool, "it");
            if (bool.booleanValue()) {
                p2 p2Var = this.f18562a;
                Object obj = this.f18563b.f19600a;
                i.d(obj);
                p2Var.w((ColumnContentsBean) obj);
                return;
            }
            this.f18562a.t();
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18564a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            List<ChildColumnList> list;
            i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                list = data.getChildColumnList();
            } else {
                list = null;
            }
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18565a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            i.d(data);
            List<ChildColumnList> childColumnList = data.getChildColumnList();
            i.d(childColumnList);
            return childColumnList;
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18566a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ColumnContentsBean f18567a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ColumnContentsBean columnContentsBean) {
                super(1);
                this.f18567a = columnContentsBean;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                n7.a.e(na.a.f8315a, "vod_column", m8.a.a().toJson((Object) this.f18567a));
                String f10 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
                i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f8315a, "service_time_vod_column", String.valueOf((h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f18568a = new b();

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
            public final /* synthetic */ String f18569a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f18569a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18569a, yVar.b(), (String) null, 4, (Object) null));
            }
        }

        public d(p2 p2Var) {
            this.f18566a = p2Var;
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
            if (list.isEmpty()) {
                this.f18566a.s().b();
            } else {
                this.f18566a.s().q1(list);
            }
            this.f18566a.x(list);
            b0.U(this, "getChildColumn:" + list);
            Observable.just("ioSchedulers").compose(p0.c()).subscribe(new q2(new a(new ColumnContentsBean((Integer) null, list))), new r2(b.f18568a));
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18566a.s().c(str);
            Context context = this.f18566a.q().getContext();
            if (context != null) {
                x.f12622a.w(context, new c(str));
            }
        }
    }

    public p2(f fVar, m mVar) {
        i.g(fVar, "frag");
        i.g(mVar, "view");
        this.f18559a = fVar;
        this.f18560b = mVar;
    }

    public static final void o(w wVar, w wVar2, ObservableEmitter observableEmitter) {
        boolean z10;
        i.g(wVar, "$cacheColumnData");
        i.g(wVar2, "$columnContentsBean");
        i.g(observableEmitter, "it");
        Object b10 = n7.a.b(na.a.f8315a, "vod_column", "");
        i.e(b10, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b10;
        wVar.f19600a = str;
        if (!b0.J(str)) {
            Gson a10 = m8.a.a();
            Object obj = wVar.f19600a;
            i.d(obj);
            wVar2.f19600a = a10.fromJson((String) obj, ColumnContentsBean.class);
        }
        if (wVar2.f19600a != null) {
            int d10 = na.f.d(na.a.f8315a, "column_cache_time", 0);
            String f10 = na.f.f(na.a.f8315a, "service_time_vod_column", "0");
            i.f(f10, "getStrings(AppHelper.mCo…ICE_TIME_VOD_COLUMN, \"0\")");
            long parseLong = Long.parseLong(f10);
            String f11 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            long a11 = (h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
            StringBuilder sb = new StringBuilder();
            sb.append("vod column: nowTime: ");
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

    public static final void p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List v(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public void n() {
        w wVar = new w();
        w wVar2 = new w();
        Observable.create(new l2(wVar, wVar2)).compose(p0.b()).subscribe(new m2(new a(this, wVar2)));
    }

    public final f q() {
        return this.f18559a;
    }

    public final List r() {
        return this.f18561c;
    }

    public final m s() {
        return this.f18560b;
    }

    public final void t() {
        w6.i.i1(w6.i.f9510g.b(), RootColumnId.mainId, false, 0, 0, 14, (Object) null).compose(this.f18559a.O2()).filter(new n2(b.f18564a)).map(new o2(c.f18565a)).subscribe(new d(this));
    }

    public final void w(ColumnContentsBean columnContentsBean) {
        m mVar = this.f18560b;
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        i.d(childColumnList);
        mVar.q1(childColumnList);
        List<ChildColumnList> childColumnList2 = columnContentsBean.getChildColumnList();
        i.d(childColumnList2);
        this.f18561c = childColumnList2;
        StringBuilder sb = new StringBuilder();
        sb.append("getChildColumn by cache: ");
        List<ChildColumnList> childColumnList3 = columnContentsBean.getChildColumnList();
        i.d(childColumnList3);
        sb.append(childColumnList3);
        b0.U(this, sb.toString());
    }

    public final void x(List list) {
        this.f18561c = list;
    }
}
