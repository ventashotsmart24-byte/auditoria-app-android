package l6;

import b6.f;
import com.mobile.brasiltv.utils.b0;
import i9.r;
import j6.c;
import java.util.List;
import mobile.com.requestframe.utils.response.ExchangeCodeItem;
import mobile.com.requestframe.utils.response.ExchangeCodeResult;
import t9.i;

public final class s implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18584a;

    /* renamed from: b  reason: collision with root package name */
    public final c f18585b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s f18586a;

        public a(s sVar) {
            this.f18586a = sVar;
        }

        /* renamed from: f */
        public void onNext(ExchangeCodeResult exchangeCodeResult) {
            i.g(exchangeCodeResult, "t");
            this.f18586a.k().h2(this.f18586a.n(exchangeCodeResult.getData()));
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18586a.k().C();
        }
    }

    public s(f fVar, c cVar) {
        i.g(fVar, "frag");
        i.g(cVar, "view");
        this.f18584a = fVar;
        this.f18585b = cVar;
    }

    public static final int o(s sVar, ExchangeCodeItem exchangeCodeItem, ExchangeCodeItem exchangeCodeItem2) {
        i.g(sVar, "this$0");
        i.f(exchangeCodeItem, "o1");
        if (sVar.l(exchangeCodeItem)) {
            i.f(exchangeCodeItem2, "o2");
            if (sVar.m(exchangeCodeItem2)) {
                return -1;
            }
        }
        if (sVar.m(exchangeCodeItem)) {
            i.f(exchangeCodeItem2, "o2");
            if (sVar.l(exchangeCodeItem2)) {
                return 1;
            }
        }
        boolean z10 = false;
        if (b0.T(exchangeCodeItem.getRecordDate(), exchangeCodeItem2.getRecordDate())) {
            return 0;
        }
        if (exchangeCodeItem.getRecordDate().compareTo(exchangeCodeItem2.getRecordDate()) < 0) {
            z10 = true;
        }
        if (z10) {
            return -1;
        }
        return 1;
    }

    public void e() {
        j();
    }

    public void g() {
    }

    public void j() {
        this.f18585b.h();
        w6.i.f9510g.b().s1().compose(this.f18584a.O2()).subscribe(new a(this));
    }

    public final c k() {
        return this.f18585b;
    }

    public final boolean l(ExchangeCodeItem exchangeCodeItem) {
        if (b0.T(exchangeCodeItem.getStatus(), "1") || b0.T(exchangeCodeItem.getStatus(), "3")) {
            return true;
        }
        return false;
    }

    public final boolean m(ExchangeCodeItem exchangeCodeItem) {
        if (b0.T(exchangeCodeItem.getStatus(), "0") || b0.T(exchangeCodeItem.getStatus(), "2")) {
            return true;
        }
        return false;
    }

    public final List n(List list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        return r.I(r.C(list, new r(this)));
    }
}
