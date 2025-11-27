package h6;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import b6.e;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import h9.g;
import h9.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.s;
import t9.i;
import t9.j;

public final class c extends e<s> implements j6.c {

    /* renamed from: i  reason: collision with root package name */
    public s f17297i;

    /* renamed from: j  reason: collision with root package name */
    public final g f17298j = h.b(a.f17300a);

    /* renamed from: k  reason: collision with root package name */
    public Map f17299k = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f17300a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final f6.e invoke() {
            return new f6.e();
        }
    }

    public void C() {
        ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(8);
        ((RecyclerView) f3(R$id.mList)).setVisibility(8);
        ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(0);
    }

    public void T2() {
    }

    public void X2() {
        this.f17299k.clear();
    }

    public void Y2() {
        int i10 = R$id.mList;
        ((RecyclerView) f3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        g3().bindToRecyclerView((RecyclerView) f3(i10));
    }

    public int c3() {
        return R.layout.frag_exchange_record;
    }

    public View f3(int i10) {
        View findViewById;
        Map map = this.f17299k;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final f6.e g3() {
        return (f6.e) this.f17298j.getValue();
    }

    public void h() {
        ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(0);
        ((RecyclerView) f3(R$id.mList)).setVisibility(8);
        ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(8);
    }

    public void h2(List list) {
        int i10;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(8);
            ((RecyclerView) f3(R$id.mList)).setVisibility(0);
            ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(8);
            g3().setNewData(list);
            return;
        }
        C();
    }

    /* renamed from: h3 */
    public s a3() {
        s sVar = this.f17297i;
        if (sVar != null) {
            return sVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void i3(s sVar) {
        i.g(sVar, "<set-?>");
        this.f17297i = sVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i3(new s(this, this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }
}
