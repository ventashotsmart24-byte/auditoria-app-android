package l6;

import android.content.Context;
import android.text.TextUtils;
import b6.f;
import b6.r0;
import com.google.gson.Gson;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.r;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.EpgResultData;
import mobile.com.requestframe.utils.response.GetLiveData;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import mobile.com.requestframe.utils.response.JsonEpgResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;

public final class d1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18382a;

    /* renamed from: b  reason: collision with root package name */
    public final r f18383b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f18384c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d1 f18385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18386b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d1 d1Var, int i10) {
            super(1);
            this.f18385a = d1Var;
            this.f18386b = i10;
        }

        public final void b(GetLiveDataResult getLiveDataResult) {
            GetLiveData data = getLiveDataResult.getData();
            i.d(data);
            if (!TextUtils.isEmpty(data.getDataVersion())) {
                n0 n0Var = n0.f12601a;
                Context context = this.f18385a.l().getContext();
                i.d(context);
                GetLiveData data2 = getLiveDataResult.getData();
                i.d(data2);
                n0Var.j(context, "DATA_VERSION" + this.f18386b, data2.getDataVersion());
            }
            GetLiveData data3 = getLiveDataResult.getData();
            i.d(data3);
            if (!TextUtils.isEmpty(data3.getExpireTimeStr())) {
                n0 n0Var2 = n0.f12601a;
                Context context2 = this.f18385a.l().getContext();
                i.d(context2);
                GetLiveData data4 = getLiveDataResult.getData();
                i.d(data4);
                n0Var2.j(context2, "EXPIRE_TIME" + this.f18386b, data4.getExpireTimeStr());
            }
            String json = new Gson().toJson((Object) getLiveDataResult);
            if (!TextUtils.isEmpty(json)) {
                b0.U(this.f18385a, "请求成功，缓存节目单");
                na.f.m(this.f18385a.l().getContext(), String.valueOf(this.f18386b), String.valueOf(this.f18386b), json);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetLiveDataResult) obj);
            return t.f17319a;
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d1 f18387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f18389c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f18390a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d1 f18391b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f18392c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ w f18393d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(boolean z10, d1 d1Var, int i10, w wVar) {
                super(1);
                this.f18390a = z10;
                this.f18391b = d1Var;
                this.f18392c = i10;
                this.f18393d = wVar;
            }

            public final void b(GetLiveData getLiveData) {
                if (this.f18390a) {
                    this.f18391b.m().G(getLiveData.getChannelList(), this.f18392c);
                }
                Disposable disposable = (Disposable) this.f18393d.f19600a;
                if (disposable != null) {
                    disposable.dispose();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((GetLiveData) obj);
                return t.f17319a;
            }
        }

        /* renamed from: l6.d1$b$b  reason: collision with other inner class name */
        public static final class C0263b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0263b f18394a = new C0263b();

            public C0263b() {
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
            public final /* synthetic */ String f18395a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f18395a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String p10 = y.p(y.f12639a, this.f18395a, (String) null, (String) null, 6, (Object) null);
                f1.a aVar = f1.f12517a;
                aVar.x(p10 + ' ' + w6.i.f9510g.H());
            }
        }

        public static final class d extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f18396a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(w wVar) {
                super(1);
                this.f18396a = wVar;
            }

            public final void b(Disposable disposable) {
                this.f18396a.f19600a = disposable;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((Disposable) obj);
                return t.f17319a;
            }
        }

        public b(d1 d1Var, int i10, boolean z10) {
            this.f18387a = d1Var;
            this.f18388b = i10;
            this.f18389c = z10;
        }

        public static final void l(String str, b bVar, d1 d1Var, int i10, ObservableEmitter observableEmitter) {
            i.g(str, "$returnCode");
            i.g(bVar, "this$0");
            i.g(d1Var, "this$1");
            i.g(observableEmitter, "it");
            if (i.b(str, "304")) {
                b0.U(bVar, "节目单有缓存");
                if (d1Var.l().getContext() != null) {
                    String h10 = na.f.h(d1Var.l().getContext(), String.valueOf(i10), String.valueOf(i10));
                    if (!TextUtils.isEmpty(h10)) {
                        GetLiveDataResult getLiveDataResult = (GetLiveDataResult) new Gson().fromJson(h10, GetLiveDataResult.class);
                        if (getLiveDataResult.getData() != null) {
                            GetLiveData data = getLiveDataResult.getData();
                            i.d(data);
                            observableEmitter.onNext(data);
                        }
                    } else {
                        n0 n0Var = n0.f12601a;
                        Context context = d1Var.l().getContext();
                        i.d(context);
                        n0Var.k(context, new String[]{"DATA_VERSION" + i10, "EXPIRE_TIME" + i10}, new String[]{"", ""});
                    }
                }
            }
            observableEmitter.onComplete();
        }

        public static final void m(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void n(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void o(d1 d1Var, String str) {
            i.g(d1Var, "this$0");
            i.g(str, "$returnCode");
            Context context = d1Var.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new c(str));
            }
        }

        public static final void p(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        /* renamed from: k */
        public void onNext(GetLiveDataResult getLiveDataResult) {
            i.g(getLiveDataResult, "it");
            if (getLiveDataResult.getData() != null) {
                GetLiveData data = getLiveDataResult.getData();
                i.d(data);
                if (b0.I(data.getChannelList())) {
                    b0.U(this, "节目单无缓存");
                    if (this.f18389c) {
                        r m10 = this.f18387a.m();
                        GetLiveData data2 = getLiveDataResult.getData();
                        i.d(data2);
                        m10.G(data2.getChannelList(), this.f18388b);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            w wVar = new w();
            Observable.create(new e1(str, this, this.f18387a, this.f18388b)).compose(p0.b()).compose(this.f18387a.l().O2()).subscribe(new f1(new a(this.f18389c, this.f18387a, this.f18388b, wVar)), new g1(C0263b.f18394a), new h1(this.f18387a, str), new i1(new d(wVar)));
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f18397a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(Long l10) {
            i.g(l10, "it");
            return w6.i.f9510g.b().r1().c(s6.a.f9335a.a().g());
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18398a = new d();

        public d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f17319a;
        }

        public final void invoke(ArrayList arrayList) {
            r0.A.e().clear();
            i.f(arrayList, "it");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JsonEpgResult jsonEpgResult = (JsonEpgResult) it.next();
                if (b0.I(jsonEpgResult.getContents())) {
                    HashMap e10 = r0.A.e();
                    String channelCode = jsonEpgResult.getChannelCode();
                    ArrayList<EpgResultData> contents = jsonEpgResult.getContents();
                    i.d(contents);
                    e10.put(channelCode, contents);
                } else {
                    r0.A.e().put(jsonEpgResult.getChannelCode(), new ArrayList());
                }
            }
        }
    }

    public static final class e implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d1 f18399a;

        public e(d1 d1Var) {
            this.f18399a = d1Var;
        }

        /* renamed from: a */
        public void onNext(ArrayList arrayList) {
            i.g(arrayList, "t");
            this.f18399a.m().q2();
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            i.g(th, "e");
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            this.f18399a.f18384c = disposable;
        }
    }

    public d1(f fVar, r rVar) {
        i.g(fVar, "frag");
        i.g(rVar, "view");
        this.f18382a = fVar;
        this.f18383b = rVar;
    }

    public static final void o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource q(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void r(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
        p();
    }

    public void g() {
        Disposable disposable = this.f18384c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final f l() {
        return this.f18382a;
    }

    public final r m() {
        return this.f18383b;
    }

    public void n(int i10, boolean z10) {
        w6.i b10 = w6.i.f9510g.b();
        n0 n0Var = n0.f12601a;
        Context context = this.f18382a.getContext();
        i.d(context);
        String f10 = n0.f(n0Var, context, "DATA_VERSION" + i10, (String) null, 4, (Object) null);
        Context context2 = this.f18382a.getContext();
        i.d(context2);
        b10.z1(i10, f10, n0.f(n0Var, context2, "EXPIRE_TIME" + i10, (String) null, 4, (Object) null)).compose(this.f18382a.O2()).doOnNext(new c1(new a(this, i10))).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, i10, z10));
    }

    public final void p() {
        Disposable disposable = this.f18384c;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable.interval(0, 12, TimeUnit.HOURS).flatMap(new a1(c.f18397a)).doOnNext(new b1(d.f18398a)).subscribe(new e(this));
    }
}
