package v5;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.business.message.db.MessageDao;
import com.mobile.brasiltv.utils.b0;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import ma.q;
import s9.l;
import t9.i;
import t9.j;
import w5.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f19670a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static int f19671b;

    /* renamed from: c  reason: collision with root package name */
    public static int f19672c;

    /* renamed from: d  reason: collision with root package name */
    public static int f19673d;

    /* renamed from: e  reason: collision with root package name */
    public static h f19674e;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19675a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final Integer invoke(Integer num) {
            i.g(num, "it");
            m mVar = m.f19701a;
            MessageDao C = mVar.C();
            d6.b bVar = d6.b.f6366a;
            int queryCouponNum = C.queryCouponNum(bVar.l());
            g gVar = g.f19670a;
            b0.U(gVar, "cache coupon num is " + queryCouponNum);
            int intValue = num.intValue() - queryCouponNum;
            if (intValue < 0) {
                mVar.C().updateCouponNum(bVar.l(), num.intValue());
            }
            return Integer.valueOf(intValue);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19676a = new b();

        public b() {
            super(1);
        }

        public final void b(Integer num) {
            Integer num2;
            g gVar = g.f19670a;
            i.f(num, "it");
            if (num.intValue() < 0) {
                num2 = 0;
            } else {
                num2 = num;
            }
            gVar.v(num2.intValue());
            b0.U(gVar, "diff coupon num is " + num);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f19677a = new c();

        public c() {
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

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19678a = new d();

        public d() {
            super(1);
        }

        public final void b(Integer num) {
            g gVar = g.f19670a;
            gVar.v(0);
            b0.U(gVar, "update coupon num is " + num);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Integer) obj);
            return t.f17319a;
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f19679a = new e();

        public e() {
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

    public static final Integer h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (Integer) lVar.invoke(obj);
    }

    public static final void i(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void j(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(ObservableEmitter observableEmitter) {
        i.g(observableEmitter, "it");
        m mVar = m.f19701a;
        MessageDao C = mVar.C();
        d6.b bVar = d6.b.f6366a;
        int queryCouponNum = C.queryCouponNum(bVar.l());
        g gVar = f19670a;
        b0.U(gVar, "cache coupon num is " + queryCouponNum);
        int l10 = queryCouponNum + gVar.l();
        mVar.C().updateCouponNum(bVar.l(), l10);
        observableEmitter.onNext(Integer.valueOf(l10));
        observableEmitter.onComplete();
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void g(int i10) {
        Observable.just(Integer.valueOf(i10)).map(new a(a.f19675a)).compose(q.b()).subscribe(new b(b.f19676a), new c(c.f19677a));
    }

    public final int k() {
        return f19672c;
    }

    public final int l() {
        return f19673d;
    }

    public final int m() {
        return f19671b + f19672c;
    }

    public final int n() {
        return f19671b;
    }

    public final void o(h hVar) {
        i.g(hVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        f19674e = hVar;
    }

    public final void p() {
        f19674e = null;
        f19671b = 0;
        f19672c = 0;
        f19673d = 0;
    }

    public final void q(int i10) {
        f19672c = i10;
        h hVar = f19674e;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void r() {
        Observable.create(new d()).compose(q.b()).subscribe(new e(d.f19678a), new f(e.f19679a));
    }

    public final void v(int i10) {
        f19673d = i10;
        h hVar = f19674e;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void w(int i10) {
        f19671b = i10;
        h hVar = f19674e;
        if (hVar != null) {
            hVar.a();
        }
    }
}
