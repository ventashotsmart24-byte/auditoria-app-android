package l6;

import android.content.Context;
import b6.f;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.z0;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.MsgBoxResult;
import mobile.com.requestframe.utils.response.MsgData;
import s9.l;
import t9.i;
import t9.j;
import v5.g;
import w5.m;

public final class k2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18495a;

    /* renamed from: b  reason: collision with root package name */
    public final z0 f18496b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18497c = 10;

    /* renamed from: d  reason: collision with root package name */
    public int f18498d = 1;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f18499e;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k2 f18500a;

        /* renamed from: l6.k2$a$a  reason: collision with other inner class name */
        public static final class C0266a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18501a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0266a(String str) {
                super(1);
                this.f18501a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18501a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(k2 k2Var) {
            this.f18500a = k2Var;
        }

        /* renamed from: f */
        public void onNext(MsgBoxResult msgBoxResult) {
            ArrayList<Msg> arrayList;
            boolean z10;
            i.g(msgBoxResult, "t");
            MsgData data = msgBoxResult.getData();
            ArrayList<Msg> arrayList2 = null;
            if (data != null) {
                arrayList = data.getMsgList();
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f18500a.n().D();
                return;
            }
            this.f18500a.f18498d = 2;
            z0 n10 = this.f18500a.n();
            MsgData data2 = msgBoxResult.getData();
            if (data2 != null) {
                arrayList2 = data2.getMsgList();
            }
            i.d(arrayList2);
            n10.A(arrayList2, true);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18500a.f18499e = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18500a.n().D();
            Context context = this.f18500a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0266a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k2 f18502a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18503a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18503a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18503a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(k2 k2Var) {
            this.f18502a = k2Var;
        }

        /* renamed from: f */
        public void onNext(MsgBoxResult msgBoxResult) {
            ArrayList<Msg> arrayList;
            boolean z10;
            i.g(msgBoxResult, "t");
            MsgData data = msgBoxResult.getData();
            ArrayList<Msg> arrayList2 = null;
            if (data != null) {
                arrayList = data.getMsgList();
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f18502a.n().w();
                return;
            }
            k2 k2Var = this.f18502a;
            k2Var.f18498d = k2Var.f18498d + 1;
            z0 n10 = this.f18502a.n();
            MsgData data2 = msgBoxResult.getData();
            if (data2 != null) {
                arrayList2 = data2.getMsgList();
            }
            i.d(arrayList2);
            n10.A(arrayList2, false);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18502a.f18499e = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18502a.n().E();
            Context context = this.f18502a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k2 f18504a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18505a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18505a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18505a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(k2 k2Var) {
            this.f18504a = k2Var;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            Context context = this.f18504a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            super.onNext(baseResult);
            g.f19670a.w(0);
        }
    }

    public k2(f fVar, z0 z0Var) {
        i.g(fVar, "frag");
        i.g(z0Var, "view");
        this.f18495a = fVar;
        this.f18496b = z0Var;
    }

    public void e() {
    }

    public void g() {
        k();
    }

    public void k() {
        Disposable disposable = this.f18499e;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (!z10) {
            Disposable disposable2 = this.f18499e;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f18499e = null;
        }
    }

    public void l() {
        k();
        w6.i.f9510g.b().g1(this.f18497c, 1, m.f19701a.J()).compose(this.f18495a.O2()).subscribe(new a(this));
    }

    public final f m() {
        return this.f18495a;
    }

    public final z0 n() {
        return this.f18496b;
    }

    public void o() {
        k();
        w6.i.f9510g.b().g1(this.f18497c, this.f18498d, m.f19701a.J()).compose(this.f18495a.O2()).subscribe(new b(this));
    }

    public void p() {
        w6.i.f9510g.b().g2("", m.f19701a.J()).compose(this.f18495a.O2()).subscribe(new c(this));
    }
}
