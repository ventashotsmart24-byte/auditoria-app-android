package b6;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.e;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LinerItemDecoration;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.q0;
import g5.s0;
import h9.g;
import j6.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.z0;
import t9.i;
import t9.j;

public final class c2 extends e<z0> implements h, s0.a {

    /* renamed from: i  reason: collision with root package name */
    public z0 f10925i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f10926j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final g f10927k = h9.h.b(new c(this));

    /* renamed from: l  reason: collision with root package name */
    public final g f10928l = h9.h.b(new b(this));

    /* renamed from: m  reason: collision with root package name */
    public Map f10929m = new LinkedHashMap();

    public static final class a implements q0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f10930a;

        public a(c2 c2Var) {
            this.f10930a = c2Var;
        }

        public void a(String str, int i10) {
            i.g(str, "str");
            this.f10930a.h3(i10);
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f10931a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c2 c2Var) {
            super(0);
            this.f10931a = c2Var;
        }

        /* renamed from: b */
        public final s0 invoke() {
            e activity = this.f10931a.getActivity();
            i.d(activity);
            return new s0(activity, this.f10931a);
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f10932a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c2 c2Var) {
            super(0);
            this.f10932a = c2Var;
        }

        /* renamed from: b */
        public final q0 invoke() {
            e activity = this.f10932a.getActivity();
            i.d(activity);
            return new q0(activity, this.f10932a.f10926j);
        }
    }

    public void B2(int i10) {
        i3().getData().remove(i10);
        i3().notifyDataSetChanged();
    }

    public void J0(boolean z10) {
        int i10;
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) f3(R$id.mLlNoData);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        autoLinearLayout.setVisibility(i10);
    }

    public void T(int i10) {
        z0 k32 = a3();
        Object obj = i3().getData().get(i10);
        i.f(obj, "mLiveSubAdapter.data[pos]");
        k32.B((LiveSubProgram) obj, i10);
    }

    public void T2() {
        b0.U(this, "lazyLoad:");
        a3().q();
        a3().w();
        a3().x(j3().b());
    }

    public void X2() {
        this.f10929m.clear();
    }

    public void Y2() {
        m3();
        l3();
    }

    public int c3() {
        return R.layout.frag_live_epg;
    }

    public View f3(int i10) {
        View findViewById;
        Map map = this.f10929m;
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

    public final void h3(int i10) {
        j3().f(i10);
        i3().getData().clear();
        i3().notifyDataSetChanged();
        a3().x(j3().b());
    }

    public void i1(List list) {
        i.g(list, "datas");
        i3().getData().clear();
        i3().getData().addAll(list);
        i3().notifyDataSetChanged();
    }

    public final s0 i3() {
        return (s0) this.f10928l.getValue();
    }

    public final q0 j3() {
        return (q0) this.f10927k.getValue();
    }

    /* renamed from: k3 */
    public z0 a3() {
        z0 z0Var = this.f10925i;
        if (z0Var != null) {
            return z0Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void l3() {
        j3().g(new a(this));
    }

    public final void m3() {
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i10 = R$id.mRecyclerViewSort;
        ((RecyclerView) f3(i10)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) f3(i10)).setAdapter(j3());
        LinerItemDecoration linerItemDecoration = new LinerItemDecoration(com.mobile.brasiltv.utils.s0.a(getActivity(), 1.0f), 0, true);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper2 = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRecyclerViewEpg;
        ((RecyclerView) f3(i11)).setLayoutManager(linearLayoutManagerWrapper2);
        ((RecyclerView) f3(i11)).addItemDecoration(linerItemDecoration);
        ((RecyclerView) f3(i11)).setAdapter(i3());
    }

    public void n3(z0 z0Var) {
        i.g(z0Var, "<set-?>");
        this.f10925i = z0Var;
    }

    public void o0(ArrayList arrayList) {
        i.g(arrayList, "datas");
        this.f10926j.clear();
        this.f10926j.addAll(arrayList);
        j3().notifyDataSetChanged();
        j3().f(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n3(new z0(this, this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void showLoading(boolean z10) {
        FragmentManager fragmentManager;
        if (z10) {
            LoadingDialog.Companion companion = LoadingDialog.Companion;
            e activity = getActivity();
            if (activity != null) {
                fragmentManager = activity.getFragmentManager();
            } else {
                fragmentManager = null;
            }
            companion.show(fragmentManager);
            return;
        }
        LoadingDialog.Companion.hidden();
    }
}
