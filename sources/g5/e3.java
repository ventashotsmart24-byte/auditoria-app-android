package g5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.NationBean;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.h0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.SideBar;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import s9.l;
import t9.i;
import t9.j;

public final class e3 extends BaseQuickAdapter implements SideBar.OnTouchingLetterChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayoutManagerWrapper f16899a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f16900b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public c f16901c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e3 f16902a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e3 e3Var) {
            super(1);
            this.f16902a = e3Var;
        }

        /* renamed from: b */
        public final ArrayList invoke(List list) {
            i.g(list, "nationBeen");
            return h0.c(list, this.f16902a.f16900b);
        }
    }

    public static final class b implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e3 f16903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f16904b;

        public b(e3 e3Var, ArrayList arrayList) {
            this.f16903a = e3Var;
            this.f16904b = arrayList;
        }

        /* renamed from: a */
        public void onNext(ArrayList arrayList) {
            i.g(arrayList, "resultList");
            this.f16904b.addAll(arrayList);
        }

        public void onComplete() {
            this.f16903a.setNewData(this.f16904b);
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            b0.U(this, "onError");
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
        }
    }

    public interface c {
        void a(int i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e3(ArrayList arrayList) {
        super((int) R.layout.adapter_select_nation_item);
        i.g(arrayList, "datas");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList.subList(0, 6));
        Observable.just(arrayList.subList(6, arrayList.size())).map(new c3(new a(this))).compose(p0.a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, arrayList2));
    }

    public static final ArrayList c(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (ArrayList) lVar.invoke(obj);
    }

    public static final void f(e3 e3Var, BaseViewHolder baseViewHolder, View view) {
        i.g(e3Var, "this$0");
        i.g(baseViewHolder, "$helper");
        c cVar = e3Var.f16901c;
        if (cVar != null) {
            cVar.a(baseViewHolder.getAdapterPosition());
        }
    }

    /* renamed from: e */
    public void convert(BaseViewHolder baseViewHolder, NationBean nationBean) {
        i.g(baseViewHolder, "helper");
        i.g(nationBean, PlistBuilder.KEY_ITEM);
        baseViewHolder.getView(R.id.select_nation_rl).setOnClickListener(new d3(this, baseViewHolder));
        if (baseViewHolder.getAdapterPosition() == 0) {
            baseViewHolder.setVisible(R.id.index_tv, true).setText((int) R.id.index_tv, (CharSequence) b0.z(R.string.register_nation_most_usr));
        } else if (nationBean.isFirstSZM()) {
            baseViewHolder.setVisible(R.id.index_tv, true).setText((int) R.id.index_tv, (CharSequence) nationBean.getSzm());
        } else {
            baseViewHolder.setGone(R.id.index_tv, false);
        }
        BaseViewHolder text = baseViewHolder.setText((int) R.id.nation_tv, (CharSequence) nationBean.getCountry());
        text.setText((int) R.id.code_tv, (CharSequence) '+' + nationBean.getCode());
    }

    public final String g(String str) {
        if (this.f16900b.get(str) != null || i.b("A", str)) {
            return str;
        }
        return g("" + ((char) (str.charAt(0) - 1)));
    }

    public final void h(LinearLayoutManagerWrapper linearLayoutManagerWrapper) {
        this.f16899a = linearLayoutManagerWrapper;
    }

    public final void i(c cVar) {
        this.f16901c = cVar;
    }

    public final void j(SideBar sideBar) {
        i.g(sideBar, "sideBar");
        sideBar.setOnTouchingLetterChangedListener(this);
    }

    public void onTouchingLetterChanged(String str) {
        i.g(str, "s");
        b0.U(this, "onTouchingLetterChanged:" + str + "  position:" + this.f16900b.get(str));
        String g10 = g(str);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f16899a;
        if (linearLayoutManagerWrapper != null) {
            Integer num = (Integer) this.f16900b.get(g10);
            if (num == null) {
                num = 0;
            }
            linearLayoutManagerWrapper.scrollToPositionWithOffset(num.intValue(), 0);
        }
    }
}
