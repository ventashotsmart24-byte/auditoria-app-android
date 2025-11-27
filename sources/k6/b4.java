package k6;

import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.w0;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class b4 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17652a;

    /* renamed from: b  reason: collision with root package name */
    public final w0 f17653b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b4 f17654a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b4 b4Var) {
            super(1);
            this.f17654a = b4Var;
        }

        /* renamed from: b */
        public final Boolean invoke(ShelveDataBean shelveDataBean) {
            List<ShelveAsset> list;
            boolean z10;
            i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            List<ShelveAsset> list2 = null;
            if (data != null) {
                list = data.getAssetList();
            } else {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.f17654a.k().b();
            }
            ShelveListData data2 = shelveDataBean.getData();
            if (data2 != null) {
                list2 = data2.getAssetList();
            }
            return Boolean.valueOf(b0.I(list2));
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17655a = new b();

        public b() {
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

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b4 f17656a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17657b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17658a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17658a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17658a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(b4 b4Var, int i10) {
            this.f17656a = b4Var;
            this.f17657b = i10;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "t");
            this.f17656a.k().g(list, this.f17657b);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17656a.k().p(str, this.f17657b);
            x.f12622a.w(this.f17656a.j(), new a(str));
        }
    }

    public b4(f5.c cVar, w0 w0Var) {
        i.g(cVar, f.X);
        i.g(w0Var, "view");
        this.f17652a = cVar;
        this.f17653b = w0Var;
    }

    public static final boolean o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final f5.c j() {
        return this.f17652a;
    }

    public final w0 k() {
        return this.f17653b;
    }

    public void l(int i10, int i11, int i12) {
        n(i10, i11, i12, 2);
    }

    public void m(int i10, int i11, int i12) {
        this.f17653b.a();
        n(i10, i11, i12, 0);
    }

    public final void n(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, (Integer) null, (Integer) null)).compose(this.f17652a.O1()).filter(new z3(new a(this))).map(new a4(b.f17655a)).subscribe(new c(this, i13));
    }
}
