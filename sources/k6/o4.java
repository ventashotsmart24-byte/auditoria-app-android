package k6;

import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import i6.a1;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class o4 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18003a;

    /* renamed from: b  reason: collision with root package name */
    public final a1 f18004b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o4 f18005a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(o4 o4Var) {
            super(1);
            this.f18005a = o4Var;
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
                this.f18005a.j().b();
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
        public static final b f18006a = new b();

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
        public final /* synthetic */ o4 f18007a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18008b;

        public c(o4 o4Var, int i10) {
            this.f18007a = o4Var;
            this.f18008b = i10;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "t");
            this.f18007a.j().g(list, this.f18008b);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18007a.j().p(str, this.f18008b);
            f1.f12517a.x(y.p(y.f12639a, str, (String) null, (String) null, 6, (Object) null));
        }
    }

    public o4(f5.c cVar, a1 a1Var) {
        i.g(cVar, f.X);
        i.g(a1Var, "view");
        this.f18003a = cVar;
        this.f18004b = a1Var;
    }

    public static final boolean n(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final a1 j() {
        return this.f18004b;
    }

    public void k(int i10, int i11, int i12) {
        m(i10, i11, i12, 2);
    }

    public void l(int i10, int i11, int i12) {
        this.f18004b.a();
        m(i10, i11, i12, 0);
    }

    public final void m(int i10, int i11, int i12, int i13) {
        i.c cVar = w6.i.f9510g;
        cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), i10, "2", i11, i12, (Integer) null, (Integer) null)).compose(this.f18003a.O1()).filter(new m4(new a(this))).map(new n4(b.f18006a)).subscribe(new c(this, i13));
    }
}
