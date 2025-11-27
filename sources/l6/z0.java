package l6;

import android.content.Context;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.utils.b0;
import com.umeng.analytics.AnalyticsConfig;
import h9.t;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import j6.h;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ma.m;
import ma.q;
import s9.l;
import t9.i;
import t9.j;

public final class z0 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18628a;

    /* renamed from: b  reason: collision with root package name */
    public final h f18629b;

    /* renamed from: c  reason: collision with root package name */
    public VodDao f18630c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f18631a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z0 z0Var) {
            super(1);
            this.f18631a = z0Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            i.f(bool, "it");
            if (bool.booleanValue()) {
                b0.U(this.f18631a, "clear expire sub info success");
            }
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18632a = new b();

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
        public final /* synthetic */ z0 f18633a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(z0 z0Var) {
            super(1);
            this.f18633a = z0Var;
        }

        public final void b(List list) {
            z0 z0Var = this.f18633a;
            b0.U(z0Var, "subscribe list size: " + list.size());
            if (list.isEmpty()) {
                this.f18633a.u().J0(true);
            }
            this.f18633a.u().showLoading(false);
            h u10 = this.f18633a.u();
            i.f(list, "it");
            u10.i1(list);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f18634a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(z0 z0Var) {
            super(1);
            this.f18634a = z0Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f18634a, "subscribe list is empty");
            th.printStackTrace();
            this.f18634a.u().showLoading(false);
            this.f18634a.u().J0(true);
        }
    }

    public static final class e implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((LiveSubProgram) obj).getStartTime(), ((LiveSubProgram) obj2).getStartTime());
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f18635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18636b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(z0 z0Var, int i10) {
            super(1);
            this.f18635a = z0Var;
            this.f18636b = i10;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            z0 z0Var = this.f18635a;
            b0.U(z0Var, "unsub list result: " + bool);
            i.f(bool, "it");
            if (bool.booleanValue()) {
                this.f18635a.u().B2(this.f18636b);
            }
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18637a = new g();

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

    public z0(b6.f fVar, h hVar) {
        i.g(fVar, "frag");
        i.g(hVar, "view");
        this.f18628a = fVar;
        this.f18629b = hVar;
        Context requireContext = fVar.requireContext();
        i.f(requireContext, "frag.requireContext()");
        this.f18630c = new VodDao(requireContext);
    }

    public static final void A(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void C(LiveSubProgram liveSubProgram, z0 z0Var, ObservableEmitter observableEmitter) {
        i.g(liveSubProgram, "$subProgram");
        i.g(z0Var, "this$0");
        i.g(observableEmitter, "it");
        String e10 = m.e(liveSubProgram.getChannelName() + liveSubProgram.getProgramName() + liveSubProgram.getStartTime() + liveSubProgram.getEndTime());
        VodDao vodDao = z0Var.f18630c;
        i.f(e10, "pid");
        vodDao.delLiveSub(e10);
        observableEmitter.onNext(Boolean.TRUE);
    }

    public static final void D(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r(z0 z0Var, ObservableEmitter observableEmitter) {
        i.g(z0Var, "this$0");
        i.g(observableEmitter, "it");
        String d10 = y6.a.d("yyyy/MM/dd HH:mm");
        for (LiveSubProgram next : z0Var.f18630c.queryAllLiveSub()) {
            if (y6.a.b(d10, next.getEndTime())) {
                z0Var.f18630c.delLiveSub(next.get_pid());
            }
        }
        observableEmitter.onNext(Boolean.TRUE);
    }

    public static final void s(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(z0 z0Var, String str, ObservableEmitter observableEmitter) {
        i.g(z0Var, "this$0");
        i.g(str, "$startTime");
        i.g(observableEmitter, "it");
        observableEmitter.onNext(r.C(z0Var.v(str), new e()));
    }

    public static final void z(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void B(LiveSubProgram liveSubProgram, int i10) {
        i.g(liveSubProgram, "subProgram");
        Observable.create(new w0(liveSubProgram, this)).compose(q.b()).compose(this.f18628a.O2()).subscribe(new x0(new f(this, i10)), new y0(g.f18637a));
    }

    public void e() {
    }

    public void g() {
    }

    public void q() {
        Observable.create(new t0(this)).compose(q.b()).compose(this.f18628a.O2()).subscribe(new u0(new a(this)), new v0(b.f18632a));
    }

    public final h u() {
        return this.f18629b;
    }

    public final List v(String str) {
        ArrayList arrayList = new ArrayList();
        List<LiveSubProgram> queryLiveSubByDate = this.f18630c.queryLiveSubByDate(str);
        String d10 = y6.a.d("yyyy/MM/dd HH:mm");
        for (LiveSubProgram next : queryLiveSubByDate) {
            if (!y6.a.b(d10, next.getEndTime())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void w() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i10 = 0; i10 < 7; i10++) {
            arrayList.add(y6.b.b(((long) (86400000 * i10)) + currentTimeMillis, "yyyy/MM/dd"));
        }
        this.f18629b.o0(arrayList);
    }

    public void x(String str) {
        i.g(str, AnalyticsConfig.RTD_START_TIME);
        this.f18629b.showLoading(true);
        this.f18629b.J0(false);
        Observable.create(new q0(this, str)).compose(q.b()).compose(this.f18628a.O2()).subscribe(new r0(new c(this)), new s0(new d(this)));
    }
}
