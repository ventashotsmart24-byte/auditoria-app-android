package l6;

import android.os.Bundle;
import b6.f;
import com.mobile.brasiltv.utils.b0;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.ApkReceiveCouponResult;
import mobile.com.requestframe.utils.response.AvailableCouponCodeList;
import mobile.com.requestframe.utils.response.CouponCodeList;
import mobile.com.requestframe.utils.response.QueryCouponData;
import t9.i;
import w6.i;

public final class q implements j6.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18570a;

    /* renamed from: b  reason: collision with root package name */
    public final j6.b f18571b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f18572a;

        public a(q qVar) {
            this.f18572a = qVar;
        }

        /* renamed from: f */
        public void onNext(ApkQueryCouponResult apkQueryCouponResult) {
            i.g(apkQueryCouponResult, "t");
            if (apkQueryCouponResult.getData() != null) {
                q qVar = this.f18572a;
                QueryCouponData data = apkQueryCouponResult.getData();
                i.d(data);
                qVar.w(data.getCouponCodeList());
                QueryCouponData data2 = apkQueryCouponResult.getData();
                i.d(data2);
                if (b0.I(data2.getReceiveCouponCodeList())) {
                    q qVar2 = this.f18572a;
                    QueryCouponData data3 = apkQueryCouponResult.getData();
                    i.d(data3);
                    List<AvailableCouponCodeList> receiveCouponCodeList = data3.getReceiveCouponCodeList();
                    i.d(receiveCouponCodeList);
                    qVar2.u(receiveCouponCodeList);
                    return;
                }
                return;
            }
            this.f18572a.o().C();
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18572a.o().C();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f18573a;

        public b(q qVar) {
            this.f18573a = qVar;
        }

        /* renamed from: f */
        public void onNext(ApkReceiveCouponResult apkReceiveCouponResult) {
            i.g(apkReceiveCouponResult, "t");
            this.f18573a.o().t2("success");
            this.f18573a.o().E2();
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            i.c cVar = w6.i.f9510g;
            cVar.r0(cVar.B() + 1);
            this.f18573a.o().t2("failed");
        }
    }

    public static final class c implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f18574a;

        public c(q qVar) {
            this.f18574a = qVar;
        }

        /* renamed from: a */
        public void onNext(List list) {
            Boolean bool;
            t9.i.g(list, "sortedAvailableList");
            this.f18574a.o().o1(list);
            this.f18574a.o().s1();
            Bundle arguments = this.f18574a.n().getArguments();
            if (arguments != null) {
                bool = Boolean.valueOf(arguments.getBoolean("isOpenInHome", false));
            } else {
                bool = null;
            }
            if (t9.i.b(bool, Boolean.TRUE)) {
                this.f18574a.o().Q0();
                Bundle arguments2 = this.f18574a.n().getArguments();
                if (arguments2 != null) {
                    arguments2.remove("isOpenInHome");
                }
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f18575a;

        public d(q qVar) {
            this.f18575a = qVar;
        }

        /* renamed from: a */
        public void onNext(List list) {
            t9.i.g(list, "sortedList");
            this.f18575a.o().K1(list);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public q(f fVar, j6.b bVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(bVar, "view");
        this.f18570a = fVar;
        this.f18571b = bVar;
    }

    public static final int r(AvailableCouponCodeList availableCouponCodeList, AvailableCouponCodeList availableCouponCodeList2) {
        float f10;
        Float f11;
        Float f12;
        String couponCurrency = availableCouponCodeList.getCouponCurrency();
        String str = "";
        if (couponCurrency == null) {
            couponCurrency = str;
        }
        Map<String, Float> couponAmount = availableCouponCodeList.getCouponAmount();
        float f13 = 0.0f;
        if (couponAmount == null || (f12 = couponAmount.get(couponCurrency)) == null) {
            f10 = 0.0f;
        } else {
            f10 = f12.floatValue();
        }
        String couponCurrency2 = availableCouponCodeList2.getCouponCurrency();
        if (couponCurrency2 != null) {
            str = couponCurrency2;
        }
        Map<String, Float> couponAmount2 = availableCouponCodeList2.getCouponAmount();
        if (!(couponAmount2 == null || (f11 = couponAmount2.get(str)) == null)) {
            f13 = f11.floatValue();
        }
        return Float.compare(f13, f10);
    }

    public static final int t(CouponCodeList couponCodeList, CouponCodeList couponCodeList2) {
        float f10;
        Float f11;
        Float f12;
        if (b0.T(couponCodeList.getStatus(), "0") && !b0.T(couponCodeList2.getStatus(), "0")) {
            return -1;
        }
        if (!b0.T(couponCodeList.getStatus(), "0") && b0.T(couponCodeList2.getStatus(), "0")) {
            return 1;
        }
        if (!b0.T(couponCodeList.getStatus(), "0") || !b0.T(couponCodeList2.getStatus(), "0")) {
            return couponCodeList2.getInvalidTime().compareTo(couponCodeList.getInvalidTime());
        }
        String couponCurrency = couponCodeList.getCouponCurrency();
        String str = "";
        if (couponCurrency == null) {
            couponCurrency = str;
        }
        Map<String, Float> couponAmount = couponCodeList.getCouponAmount();
        float f13 = 0.0f;
        if (couponAmount == null || (f12 = couponAmount.get(couponCurrency)) == null) {
            f10 = 0.0f;
        } else {
            f10 = f12.floatValue();
        }
        String couponCurrency2 = couponCodeList2.getCouponCurrency();
        if (couponCurrency2 != null) {
            str = couponCurrency2;
        }
        Map<String, Float> couponAmount2 = couponCodeList2.getCouponAmount();
        if (!(couponAmount2 == null || (f11 = couponAmount2.get(str)) == null)) {
            f13 = f11.floatValue();
        }
        return Float.compare(f13, f10);
    }

    public static final void v(q qVar, List list, ObservableEmitter observableEmitter) {
        t9.i.g(qVar, "this$0");
        t9.i.g(list, "$receiveCouponCodeList");
        t9.i.g(observableEmitter, "emitter");
        List q10 = qVar.q(list);
        t9.i.d(q10);
        observableEmitter.onNext(q10);
    }

    public static final void x(q qVar, List list, ObservableEmitter observableEmitter) {
        t9.i.g(qVar, "this$0");
        t9.i.g(observableEmitter, "emitter");
        List s10 = qVar.s(list);
        t9.i.d(s10);
        observableEmitter.onNext(s10);
    }

    public void e() {
    }

    public void f(String str) {
        this.f18571b.h();
        w6.i.f9510g.b().M0((String) null, str).compose(this.f18570a.O2()).subscribe(new a(this));
    }

    public void g() {
    }

    public final f n() {
        return this.f18570a;
    }

    public final j6.b o() {
        return this.f18571b;
    }

    public void p() {
        w6.i.f9510g.b().N0().compose(this.f18570a.O2()).subscribe(new b(this));
    }

    public final List q(List list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        return r.I(r.C(list, new o()));
    }

    public final List s(List list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        return r.I(r.C(list, new p()));
    }

    public final void u(List list) {
        Observable.create(new n(this, list)).compose(this.f18570a.O2()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void w(List list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f18571b.K1((List) null);
        } else {
            Observable.create(new m(this, list)).compose(this.f18570a.O2()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
        }
    }
}
