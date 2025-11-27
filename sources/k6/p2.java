package k6;

import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import h9.t;
import i6.h0;
import i6.i0;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import s9.l;
import s9.p;
import t9.i;
import t9.j;

public final class p2 implements h0 {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18013a;

    /* renamed from: b  reason: collision with root package name */
    public final i0 f18014b;

    /* renamed from: c  reason: collision with root package name */
    public VodDao f18015c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18016a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p2 p2Var) {
            super(1);
            this.f18016a = p2Var;
        }

        /* renamed from: b */
        public final Boolean invoke(Object obj) {
            i.g(obj, "it");
            if (!(obj instanceof Album)) {
                return Boolean.FALSE;
            }
            Album album = (Album) obj;
            if (album.isSelect()) {
                VodDao w10 = this.f18016a.w();
                String contentId = album.getContentId();
                if (contentId == null) {
                    contentId = "";
                }
                w10.deleteByAlbum(contentId, album.getTypeId());
            }
            return Boolean.valueOf(!album.isSelect());
        }
    }

    public static final class b extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18017a = new b();

        public b() {
            super(2);
        }

        public final void b(ArrayList arrayList, Object obj) {
            i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.db.Album");
            arrayList.add((Album) obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, obj2);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18018a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p2 p2Var) {
            super(1);
            this.f18018a = p2Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f17319a;
        }

        public final void invoke(ArrayList arrayList) {
            k7.f.c("删除历史数据成功!", new Object[0]);
            this.f18018a.v().z2();
            i.f(arrayList, "it");
            if (!arrayList.isEmpty()) {
                this.f18018a.v().F(arrayList);
            } else {
                this.f18018a.v().l();
            }
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18019a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(p2 p2Var) {
            super(1);
            this.f18019a = p2Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除历史数据失败!", new Object[0]);
            th.printStackTrace();
            this.f18019a.v().p2();
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p2 f18020a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(p2 p2Var) {
            super(1);
            this.f18020a = p2Var;
        }

        public final void b(List list) {
            i.f(list, "it");
            if (!list.isEmpty()) {
                this.f18020a.v().F(list);
                return;
            }
            k7.f.c("无历史记录，不展示", new Object[0]);
            this.f18020a.v().l();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18021a = new f();

        public f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class g implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((Album) obj2).getSaveTime(), ((Album) obj).getSaveTime());
        }
    }

    public p2(f5.c cVar, i0 i0Var) {
        i.g(cVar, com.umeng.analytics.pro.f.X);
        i.g(i0Var, "view");
        this.f18013a = cVar;
        this.f18014b = i0Var;
        i0Var.Y0(this);
        this.f18015c = new VodDao(cVar);
    }

    public static final void A(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean q(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ArrayList r() {
        return new ArrayList();
    }

    public static final void s(p pVar, Object obj, Object obj2) {
        i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y(p2 p2Var, ObservableEmitter observableEmitter) {
        i.g(p2Var, "this$0");
        i.g(observableEmitter, "it");
        List queryAllRecord = p2Var.f18015c.queryAllRecord();
        List C = r.C(queryAllRecord, new g());
        if (!C.isEmpty()) {
            queryAllRecord = new ArrayList(C);
        }
        observableEmitter.onNext(queryAllRecord);
    }

    public static final void z(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public void p(ArrayList arrayList) {
        i.g(arrayList, "dataList");
        if (!arrayList.isEmpty()) {
            Observable.fromIterable(arrayList).filter(new h2(new a(this))).collect(new i2(), new j2(b.f18017a)).compose(this.f18013a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k2(new c(this)), new l2(new d(this)));
        }
    }

    public final i0 v() {
        return this.f18014b;
    }

    public final VodDao w() {
        return this.f18015c;
    }

    public void x() {
        Observable.create(new m2(this)).compose(this.f18013a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n2(new e(this)), new o2(f.f18021a));
    }
}
