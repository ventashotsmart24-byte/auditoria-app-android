package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.SearchBean;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SearchLiveHistory;
import com.mobile.brasiltv.utils.b0;
import h9.t;
import i6.m0;
import i9.n;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.LiveAddress;
import mobile.com.requestframe.utils.response.PosterList;
import s9.l;
import t9.w;

public final class h3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17808a;

    /* renamed from: b  reason: collision with root package name */
    public final m0 f17809b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f17810c;

    /* renamed from: d  reason: collision with root package name */
    public final h9.g f17811d = h9.h.b(new e(this));

    public static final class a extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f17812a = new a();

        public a() {
            super(1);
        }

        public final void b(Channel channel) {
            k7.f.e("增加搜索历史记录成功！", new Object[0]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return t.f17319a;
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17813a = new b();

        public b() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("增加搜索历史记录失败！", new Object[0]);
        }
    }

    public static final class c extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h3 f17814a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h3 h3Var) {
            super(1);
            this.f17814a = h3Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            k7.f.c("删除搜索历史记录成功！", new Object[0]);
            this.f17814a.F().l();
        }
    }

    public static final class d extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f17815a = new d();

        public d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除搜索历史记录失败！", new Object[0]);
        }
    }

    public static final class e extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h3 f17816a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(h3 h3Var) {
            super(0);
            this.f17816a = h3Var;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            return new MobileDao(this.f17816a.D());
        }
    }

    public static final class f extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h3 f17817a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(h3 h3Var) {
            super(1);
            this.f17817a = h3Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f17319a;
        }

        public final void invoke(ArrayList arrayList) {
            t9.i.f(arrayList, "it");
            if (!arrayList.isEmpty()) {
                this.f17817a.F().y2(arrayList);
                return;
            }
            k7.f.c("无搜索历史记录，不展示", new Object[0]);
            this.f17817a.F().l();
        }
    }

    public static final class g extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f17818a = new g();

        public g() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询搜索历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class h extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17819a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(1);
            this.f17819a = str;
        }

        /* renamed from: b */
        public final Boolean invoke(Channel channel) {
            boolean z10;
            t9.i.g(channel, "it");
            if (this.f17819a.length() <= channel.getName().length()) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class i extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17820a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f17821b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, w wVar) {
            super(1);
            this.f17820a = str;
            this.f17821b = wVar;
        }

        public final void b(Channel channel) {
            int y10 = ba.t.y(channel.getName(), this.f17820a, 0, true, 2, (Object) null);
            if (y10 != -1) {
                t9.i.f(channel, "it");
                ((ArrayList) this.f17821b.f19600a).add(new SearchBean(y10, channel));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return t.f17319a;
        }
    }

    public static final class j extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final j f17822a = new j();

        public j() {
            super(1);
        }

        public final void b(Channel channel) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Channel) obj);
            return t.f17319a;
        }
    }

    public static final class k extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h3 f17823a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(h3 h3Var) {
            super(1);
            this.f17823a = h3Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("搜索失败", new Object[0]);
            th.printStackTrace();
            this.f17823a.F().showLoading(false);
            this.f17823a.F().N();
        }
    }

    public h3(f5.c cVar, m0 m0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(m0Var, "view");
        this.f17808a = cVar;
        this.f17809b = m0Var;
    }

    public static final void A(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void B(h3 h3Var, ObservableEmitter observableEmitter) {
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter, "it");
        h3Var.E().deleteAllSearchLiveHistory();
        observableEmitter.onNext("");
    }

    public static final void C(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(h3 h3Var, ObservableEmitter observableEmitter) {
        ObservableEmitter observableEmitter2 = observableEmitter;
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter2, "it");
        List<SearchLiveHistory> queryAllSearchLiveHistory = h3Var.E().queryAllSearchLiveHistory();
        if (!queryAllSearchLiveHistory.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<SearchLiveHistory> it = queryAllSearchLiveHistory.iterator();
            while (it.hasNext()) {
                SearchLiveHistory next = it.next();
                Iterator<SearchLiveHistory> it2 = it;
                Channel channel = r4;
                Channel channel2 = new Channel(next.getChannelCode(), next.getName(), next.getAlias(), 0, (String) null, (String) null, (String) null, (String) null, (String) null, (List<? extends PosterList>) null, (List<LiveAddress>) null);
                arrayList.add(channel);
                it = it2;
            }
            observableEmitter2.onNext(arrayList);
            return;
        }
        observableEmitter2.onNext(new ArrayList());
    }

    public static final void I(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void J(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean L(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void M(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void O(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P(w wVar, h3 h3Var) {
        t9.i.g(wVar, "$searchResult");
        t9.i.g(h3Var, "this$0");
        k7.f.d("搜索成功 " + ((ArrayList) wVar.f19600a).size(), new Object[0]);
        h3Var.f17809b.showLoading(false);
        if (!((Collection) wVar.f19600a).isEmpty()) {
            n.l((List) wVar.f19600a);
            h3Var.f17809b.R1((ArrayList) wVar.f19600a);
            return;
        }
        h3Var.f17809b.N();
    }

    public static final void w(Channel channel, h3 h3Var, ObservableEmitter observableEmitter) {
        t9.i.g(channel, "$channel");
        t9.i.g(h3Var, "this$0");
        t9.i.g(observableEmitter, "it");
        SearchLiveHistory searchLiveHistory = new SearchLiveHistory();
        searchLiveHistory.setChannelCode(channel.getChannelCode());
        searchLiveHistory.setName(channel.getName());
        searchLiveHistory.setAlias(channel.getAlias());
        h3Var.E().addSearchLiveHistory(searchLiveHistory);
        observableEmitter.onNext(channel);
    }

    public static final void x(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final f5.c D() {
        return this.f17808a;
    }

    public final MobileDao E() {
        return (MobileDao) this.f17811d.getValue();
    }

    public final m0 F() {
        return this.f17809b;
    }

    public void G() {
        Disposable disposable;
        Disposable disposable2 = this.f17810c;
        boolean z10 = false;
        if (disposable2 != null && disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f17810c) != null) {
            disposable.dispose();
        }
        Observable.create(new t2(this)).compose(this.f17808a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new y2(new f(this)), new z2(g.f17818a));
    }

    public void K(String str, List list) {
        boolean z10;
        t9.i.g(str, "keyWord");
        t9.i.g(list, "allChannelList");
        if (!TextUtils.isEmpty(str)) {
            Disposable disposable = this.f17810c;
            if (disposable == null || !disposable.isDisposed()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Disposable disposable2 = this.f17810c;
                if (disposable2 != null) {
                    disposable2.dispose();
                }
                this.f17809b.showLoading(false);
            }
            this.f17809b.showLoading(true);
            if (!b0.I(list)) {
                this.f17809b.showLoading(false);
                return;
            }
            w wVar = new w();
            wVar.f19600a = new ArrayList();
            this.f17810c = Observable.fromIterable(list).compose(this.f17808a.O1()).filter(new a3(new h(str))).doOnNext(new b3(new i(str, wVar))).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c3(j.f17822a), new d3(new k(this)), new e3(wVar, this));
        }
    }

    public void e() {
        G();
    }

    public void g() {
        Disposable disposable;
        Disposable disposable2 = this.f17810c;
        boolean z10 = false;
        if (disposable2 != null && disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f17810c) != null) {
            disposable.dispose();
        }
    }

    public void v(Channel channel) {
        t9.i.g(channel, "channel");
        Observable.create(new v2(channel, this)).compose(this.f17808a.O1()).subscribeOn(Schedulers.io()).subscribe(new w2(a.f17812a), new x2(b.f17813a));
    }

    public void z() {
        Observable.create(new f3(this)).compose(this.f17808a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g3(new c(this)), new u2(d.f17815a));
    }
}
