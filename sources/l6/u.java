package l6;

import android.content.Context;
import android.text.TextUtils;
import b6.f;
import com.google.gson.Gson;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j6.e;
import mobile.com.requestframe.utils.response.GetLiveData;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;

public final class u implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18592a;

    /* renamed from: b  reason: collision with root package name */
    public final e f18593b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f18594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18595b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i10) {
            super(1);
            this.f18594a = uVar;
            this.f18595b = i10;
        }

        public final void b(GetLiveDataResult getLiveDataResult) {
            GetLiveData data = getLiveDataResult.getData();
            i.d(data);
            if (!TextUtils.isEmpty(data.getDataVersion())) {
                n0 n0Var = n0.f12601a;
                Context context = this.f18594a.i().getContext();
                i.d(context);
                GetLiveData data2 = getLiveDataResult.getData();
                i.d(data2);
                n0Var.j(context, "DATA_VERSION" + this.f18595b, data2.getDataVersion());
            }
            GetLiveData data3 = getLiveDataResult.getData();
            i.d(data3);
            if (!TextUtils.isEmpty(data3.getExpireTimeStr())) {
                n0 n0Var2 = n0.f12601a;
                Context context2 = this.f18594a.i().getContext();
                i.d(context2);
                GetLiveData data4 = getLiveDataResult.getData();
                i.d(data4);
                n0Var2.j(context2, "EXPIRE_TIME" + this.f18595b, data4.getExpireTimeStr());
            }
            String json = new Gson().toJson((Object) getLiveDataResult);
            if (!TextUtils.isEmpty(json)) {
                b0.U(this.f18594a, "请求成功，缓存节目单");
                na.f.m(this.f18594a.i().getContext(), String.valueOf(this.f18595b), String.valueOf(this.f18595b), json);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetLiveDataResult) obj);
            return t.f17319a;
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f18596a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18597b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f18598c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f18599a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ u f18600b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f18601c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ w f18602d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(boolean z10, u uVar, int i10, w wVar) {
                super(1);
                this.f18599a = z10;
                this.f18600b = uVar;
                this.f18601c = i10;
                this.f18602d = wVar;
            }

            public final void b(GetLiveData getLiveData) {
                if (this.f18599a) {
                    this.f18600b.j().G(getLiveData.getChannelList(), this.f18601c);
                } else {
                    this.f18600b.j().g(getLiveData.getChannelList(), this.f18601c);
                }
                Disposable disposable = (Disposable) this.f18602d.f19600a;
                if (disposable != null) {
                    disposable.dispose();
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((GetLiveData) obj);
                return t.f17319a;
            }
        }

        /* renamed from: l6.u$b$b  reason: collision with other inner class name */
        public static final class C0268b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0268b f18603a = new C0268b();

            public C0268b() {
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
            public final /* synthetic */ String f18604a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(1);
                this.f18604a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18604a, yVar.f(), (String) null, 4, (Object) null);
                f1.a aVar = f1.f12517a;
                aVar.x(p10 + ' ' + w6.i.f9510g.H());
            }
        }

        public static final class d extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f18605a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(w wVar) {
                super(1);
                this.f18605a = wVar;
            }

            public final void b(Disposable disposable) {
                this.f18605a.f19600a = disposable;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((Disposable) obj);
                return t.f17319a;
            }
        }

        public b(u uVar, int i10, boolean z10) {
            this.f18596a = uVar;
            this.f18597b = i10;
            this.f18598c = z10;
        }

        public static final void l(String str, b bVar, u uVar, int i10, ObservableEmitter observableEmitter) {
            i.g(str, "$returnCode");
            i.g(bVar, "this$0");
            i.g(uVar, "this$1");
            i.g(observableEmitter, "it");
            if (i.b(str, "304")) {
                b0.U(bVar, "节目单有缓存");
                if (uVar.i().getContext() != null) {
                    String h10 = na.f.h(uVar.i().getContext(), String.valueOf(i10), String.valueOf(i10));
                    if (!TextUtils.isEmpty(h10)) {
                        GetLiveDataResult getLiveDataResult = (GetLiveDataResult) new Gson().fromJson(h10, GetLiveDataResult.class);
                        if (getLiveDataResult.getData() != null) {
                            GetLiveData data = getLiveDataResult.getData();
                            i.d(data);
                            observableEmitter.onNext(data);
                        }
                    } else {
                        n0 n0Var = n0.f12601a;
                        Context context = uVar.i().getContext();
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

        public static final void o(u uVar, String str) {
            i.g(uVar, "this$0");
            i.g(str, "$returnCode");
            Context context = uVar.i().getContext();
            if (context != null) {
                x.f12622a.w(context, new c(str));
            }
            uVar.j().onError();
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
                    if (this.f18598c) {
                        e j10 = this.f18596a.j();
                        GetLiveData data2 = getLiveDataResult.getData();
                        i.d(data2);
                        j10.G(data2.getChannelList(), this.f18597b);
                        return;
                    }
                    e j11 = this.f18596a.j();
                    GetLiveData data3 = getLiveDataResult.getData();
                    i.d(data3);
                    j11.g(data3.getChannelList(), this.f18597b);
                    return;
                }
            }
            this.f18596a.j().onError();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            this.f18596a.j().onLoading();
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            w wVar = new w();
            Observable.create(new v(str, this, this.f18596a, this.f18597b)).compose(p0.b()).compose(this.f18596a.i().O2()).subscribe(new w(new a(this.f18598c, this.f18596a, this.f18597b, wVar)), new x(C0268b.f18603a), new y(this.f18596a, str), new z(new d(wVar)));
        }
    }

    public u(f fVar, e eVar) {
        i.g(fVar, "frag");
        i.g(eVar, "view");
        this.f18592a = fVar;
        this.f18593b = eVar;
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final f i() {
        return this.f18592a;
    }

    public final e j() {
        return this.f18593b;
    }

    public void k(int i10, boolean z10) {
        w6.i b10 = w6.i.f9510g.b();
        n0 n0Var = n0.f12601a;
        Context context = this.f18592a.getContext();
        i.d(context);
        String f10 = n0.f(n0Var, context, "DATA_VERSION" + i10, (String) null, 4, (Object) null);
        Context context2 = this.f18592a.getContext();
        i.d(context2);
        b10.z1(i10, f10, n0.f(n0Var, context2, "EXPIRE_TIME" + i10, (String) null, 4, (Object) null)).compose(this.f18592a.O2()).doOnNext(new t(new a(this, i10))).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, i10, z10));
    }
}
