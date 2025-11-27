package l6;

import android.content.Context;
import b6.f;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.ShortVideoPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import io.reactivex.disposables.Disposable;
import j6.k;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.GetShortVideoResult;
import mobile.com.requestframe.utils.response.ShortAssetData;
import mobile.com.requestframe.utils.response.ShortAssetDataList;
import s9.l;
import t9.i;
import t9.j;
import xa.c;

public final class c2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f7631a;

    /* renamed from: b  reason: collision with root package name */
    public final k f7632b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f7633c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f7634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7635e;

    /* renamed from: f  reason: collision with root package name */
    public Disposable f7636f;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f18378a;

        /* renamed from: l6.c2$a$a  reason: collision with other inner class name */
        public static final class C0262a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18379a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0262a(String str) {
                super(1);
                this.f18379a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18379a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(c2 c2Var) {
            this.f18378a = c2Var;
        }

        /* renamed from: f */
        public void onNext(GetShortVideoResult getShortVideoResult) {
            List<ShortAssetData> list;
            i.g(getShortVideoResult, "t");
            this.f18378a.f7635e = false;
            ShortAssetDataList data = getShortVideoResult.getData();
            if (data != null) {
                list = data.getAssetDataList();
            } else {
                list = null;
            }
            if (b0.I(list)) {
                ShortAssetDataList data2 = getShortVideoResult.getData();
                i.d(data2);
                this.f18378a.f7633c.addAll(data2.getAssetDataList());
                this.f18378a.n().Y1(this.f18378a.f7633c);
            }
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            this.f18378a.f7635e = false;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            this.f18378a.f7636f = disposable;
            this.f18378a.f7635e = true;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18378a.n().c(str);
            Context context = this.f18378a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0262a(str));
            }
        }
    }

    public c2(f fVar, k kVar) {
        i.g(fVar, "frag");
        i.g(kVar, "view");
        this.f7631a = fVar;
        this.f7632b = kVar;
    }

    public void e() {
        Context context = this.f7631a.getContext();
        i.d(context);
        k(context);
        if (!c.c().h(this)) {
            c.c().o(this);
        }
    }

    public void g() {
        if (c.c().h(this)) {
            c.c().r(this);
        }
    }

    public void k(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (ga.a.a(context) && !ga.a.c(context)) {
            this.f7632b.k1();
        }
    }

    public final f l() {
        return this.f7631a;
    }

    public void m() {
        if (this.f7635e) {
            Disposable disposable = this.f7636f;
            boolean z10 = false;
            if (disposable != null && !disposable.isDisposed()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
        }
        w6.i.f9510g.b().Q1().compose(this.f7631a.O2()).subscribe(new a(this));
    }

    public final k n() {
        return this.f7632b;
    }

    public boolean o() {
        return this.f7634d;
    }

    @xa.j
    public final void shortVideoPlay(ShortVideoPlayEvent shortVideoPlayEvent) {
        i.g(shortVideoPlayEvent, "event");
        this.f7634d = false;
        this.f7632b.l2(0);
    }

    @xa.j
    public final void showNoNetNotify(NetworkEvent networkEvent) {
        i.g(networkEvent, "event");
        if (NetworkEvent.NetState.MOBILE == networkEvent.getMState()) {
            Context context = this.f7631a.getContext();
            i.d(context);
            k(context);
        }
    }
}
