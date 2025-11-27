package l6;

import android.content.Context;
import b6.f;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.m;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import t9.i;
import t9.j;
import w6.i;

public final class l implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f f18506a;

    /* renamed from: b  reason: collision with root package name */
    public final m f18507b;

    public static final class a extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18508a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(ShelveDataBean shelveDataBean) {
            i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class b extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f18509a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l lVar) {
            super(1);
            this.f18509a = lVar;
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            i.g(list, "it");
            if (list.isEmpty()) {
                this.f18509a.k().b();
            }
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f18510a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18511b;

        public static final class a extends j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18512a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18512a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18512a, yVar.k(), (String) null, 4, (Object) null));
            }
        }

        public c(l lVar, int i10) {
            this.f18510a = lVar;
            this.f18511b = i10;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "t");
            this.f18510a.k().g(list, this.f18511b);
            b0.U(this, "ColumnListFragPresenter:onNext");
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18510a.k().p(str, this.f18511b);
            Context context = this.f18510a.j().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public l(f fVar, m mVar) {
        i.g(fVar, "frag");
        i.g(mVar, "view");
        this.f18506a = fVar;
        this.f18507b = mVar;
    }

    public static final List p(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean q(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public void e() {
    }

    public void g() {
    }

    public final f j() {
        return this.f18506a;
    }

    public final m k() {
        return this.f18507b;
    }

    public void l(int i10, int i11, int i12) {
        o(i10, i11, i12, 2);
    }

    public void m(int i10, int i11, int i12) {
        this.f18507b.a();
        o(i10, i11, i12, 0);
    }

    public void n(int i10, int i11, int i12) {
        o(i10, i11, i12, 1);
    }

    public final void o(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, (Integer) null, (Integer) null)).compose(this.f18506a.O2()).map(new j(a.f18508a)).filter(new k(new b(this))).subscribe(new c(this, i13));
    }
}
