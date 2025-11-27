package l6;

import android.content.Context;
import b6.f;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.h;
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

public final class a implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18356a;

    /* renamed from: b  reason: collision with root package name */
    public final h f18357b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18358c = 10;

    /* renamed from: d  reason: collision with root package name */
    public int f18359d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f18360e;

    /* renamed from: l6.a$a  reason: collision with other inner class name */
    public static final class C0258a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18361a;

        /* renamed from: l6.a$a$a  reason: collision with other inner class name */
        public static final class C0259a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18362a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0259a(String str) {
                super(1);
                this.f18362a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18362a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public C0258a(a aVar) {
            this.f18361a = aVar;
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
                this.f18361a.n().D();
                return;
            }
            this.f18361a.f18359d = 2;
            h n10 = this.f18361a.n();
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
            this.f18361a.f18360e = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18361a.n().D();
            Context context = this.f18361a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0259a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18363a;

        /* renamed from: l6.a$b$a  reason: collision with other inner class name */
        public static final class C0260a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18364a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0260a(String str) {
                super(1);
                this.f18364a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18364a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(a aVar) {
            this.f18363a = aVar;
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
                this.f18363a.n().w();
                return;
            }
            a aVar = this.f18363a;
            aVar.f18359d = aVar.f18359d + 1;
            h n10 = this.f18363a.n();
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
            this.f18363a.f18360e = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18363a.n().E();
            Context context = this.f18363a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0260a(str));
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18365a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Msg f18366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18367c;

        /* renamed from: l6.a$c$a  reason: collision with other inner class name */
        public static final class C0261a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18368a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0261a(String str) {
                super(1);
                this.f18368a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18368a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(a aVar, Msg msg, int i10) {
            this.f18365a = aVar;
            this.f18366b = msg;
            this.f18367c = i10;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            Context context = this.f18365a.m().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0261a(str));
            }
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            super.onNext(baseResult);
            Msg msg = this.f18366b;
            if (msg != null) {
                msg.setStatus(2);
            }
            g gVar = g.f19670a;
            gVar.q(gVar.k() - 1);
            this.f18365a.n().n0(this.f18367c);
        }
    }

    public a(f fVar, h hVar) {
        i.g(fVar, "frag");
        i.g(hVar, "view");
        this.f18356a = fVar;
        this.f18357b = hVar;
    }

    public void e() {
    }

    public void g() {
        k();
    }

    public void k() {
        Disposable disposable = this.f18360e;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (!z10) {
            Disposable disposable2 = this.f18360e;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f18360e = null;
        }
    }

    public void l() {
        k();
        w6.i.f9510g.b().g1(this.f18358c, 1, m.f19701a.D()).compose(this.f18356a.O2()).subscribe(new C0258a(this));
    }

    public final f m() {
        return this.f18356a;
    }

    public final h n() {
        return this.f18357b;
    }

    public void o() {
        k();
        w6.i.f9510g.b().g1(this.f18358c, this.f18359d, m.f19701a.D()).compose(this.f18356a.O2()).subscribe(new b(this));
    }

    public void p(int i10, Msg msg) {
        String str;
        w6.i b10 = w6.i.f9510g.b();
        if (msg == null || (str = msg.getMessageId()) == null) {
            str = "";
        }
        b10.g2(str, m.f19701a.D()).subscribe(new c(this, msg, i10));
    }
}
