package k6;

import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.l;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import t9.i;
import t9.j;

public final class w implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18146a;

    /* renamed from: b  reason: collision with root package name */
    public final l f18147b;

    public static final class a extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18148a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                return data.getChildColumnList();
            }
            return null;
        }
    }

    public static final class b extends j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f18149a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(w wVar) {
            super(1);
            this.f18149a = wVar;
        }

        /* renamed from: b */
        public final Boolean invoke(List list) {
            i.g(list, "it");
            if (list.isEmpty()) {
                this.f18149a.k().k();
            }
            return Boolean.valueOf(b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f18150a;

        public static final class a extends j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18151a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18151a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f18151a, yVar.b(), (String) null, 4, (Object) null));
            }
        }

        public c(w wVar) {
            this.f18150a = wVar;
        }

        /* renamed from: f */
        public void onNext(List list) {
            i.g(list, "t");
            this.f18150a.k().f(list);
            this.f18150a.k().k();
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18150a.k().c(str);
            x.f12622a.w(this.f18150a.j(), new a(str));
        }
    }

    public w(f5.c cVar, l lVar) {
        i.g(cVar, f.X);
        i.g(lVar, "view");
        this.f18146a = cVar;
        this.f18147b = lVar;
    }

    public static final List m(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean n(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public void e() {
    }

    public void g() {
    }

    public final f5.c j() {
        return this.f18146a;
    }

    public final l k() {
        return this.f18147b;
    }

    public void l(ChildColumnList childColumnList) {
        i.g(childColumnList, "columnData");
        this.f18147b.a();
        w6.i.i1(w6.i.f9510g.b(), childColumnList.getId(), false, 0, 0, 14, (Object) null).compose(this.f18146a.O1()).map(new u(a.f18148a)).filter(new v(new b(this))).subscribe(new c(this));
    }
}
