package b6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import f5.t0;
import g5.r3;
import i6.z0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.k2;
import mobile.com.requestframe.utils.response.Msg;
import t9.i;
import w5.m;

public final class m3 extends e<k2> implements z0, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: i  reason: collision with root package name */
    public k2 f11021i;

    /* renamed from: j  reason: collision with root package name */
    public final int f11022j = 10;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11023k = true;

    /* renamed from: l  reason: collision with root package name */
    public r3 f11024l;

    /* renamed from: m  reason: collision with root package name */
    public t0 f11025m;

    /* renamed from: n  reason: collision with root package name */
    public Map f11026n = new LinkedHashMap();

    public static final void k3(m3 m3Var, View view) {
        i.g(m3Var, "this$0");
        m3Var.q3();
    }

    public static final void l3(m3 m3Var, View view) {
        i.g(m3Var, "this$0");
        m3Var.q3();
    }

    public static final void o3(m3 m3Var, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Msg msg;
        boolean z10;
        i.g(m3Var, "this$0");
        r3 r3Var = m3Var.f11024l;
        String str = null;
        if (r3Var != null) {
            msg = (Msg) r3Var.getItem(i10);
        } else {
            msg = null;
        }
        if (msg != null) {
            str = msg.getType();
        }
        m mVar = m.f19701a;
        if (i.b(str, mVar.E())) {
            MyBenefitsAty.a aVar = MyBenefitsAty.f12342r;
            Context context = m3Var.getContext();
            i.d(context);
            MyBenefitsAty.a.b(aVar, context, 0, false, 6, (Object) null);
            return;
        }
        boolean z11 = true;
        if (i.b(str, mVar.I())) {
            z10 = true;
        } else {
            z10 = i.b(str, mVar.H());
        }
        if (z10) {
            b0.a0(m3Var, OrderAty.class);
            return;
        }
        if (!i.b(str, mVar.F())) {
            z11 = i.b(str, mVar.G());
        }
        if (z11) {
            b0.D(m3Var);
        }
    }

    public void A(ArrayList arrayList, boolean z10) {
        i.g(arrayList, "datas");
        b0.U(this, "find data result:" + arrayList.size() + " freshData: " + z10);
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(0);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(8);
        if (z10) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
            r3 r3Var = this.f11024l;
            if (r3Var != null) {
                r3Var.setEnableLoadMore(true);
            }
            r3 r3Var2 = this.f11024l;
            if (r3Var2 != null) {
                r3Var2.setNewData(arrayList);
            }
        } else {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
            if (arrayList.size() == this.f11022j) {
                r3 r3Var3 = this.f11024l;
                if (r3Var3 != null) {
                    r3Var3.loadMoreComplete();
                }
            } else {
                r3 r3Var4 = this.f11024l;
                if (r3Var4 != null) {
                    r3Var4.loadMoreEnd();
                }
            }
            r3 r3Var5 = this.f11024l;
            if (r3Var5 != null) {
                r3Var5.addData(arrayList);
            }
        }
        t0 t0Var = this.f11025m;
        if (t0Var != null) {
            t0Var.c1(0);
        }
    }

    public void D() {
        b0.U(this, "empty data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(true);
        }
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(8);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(0);
        t0 t0Var = this.f11025m;
        if (t0Var != null) {
            t0Var.T(0);
        }
    }

    public void E() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.loadMoreComplete();
        }
    }

    public void T2() {
        int i10;
        List data;
        b0.U(this, "system msg frag");
        if (this.f11023k) {
            this.f11023k = false;
            a3().p();
            q3();
            return;
        }
        b0.U(this, "system msg frag: " + this.f11023k);
        r3 r3Var = this.f11024l;
        if (r3Var == null || (data = r3Var.getData()) == null) {
            i10 = 0;
        } else {
            i10 = data.size();
        }
        if (i10 > 0) {
            t0 t0Var = this.f11025m;
            if (t0Var != null) {
                t0Var.c1(0);
                return;
            }
            return;
        }
        t0 t0Var2 = this.f11025m;
        if (t0Var2 != null) {
            t0Var2.T(0);
        }
    }

    public void X2() {
        this.f11026n.clear();
    }

    public void Y2() {
        ((ImageView) i3(R$id.mIvMsgEmpty)).setOnClickListener(new j3(this));
        ((TextView) i3(R$id.mTvMsgEmpty)).setOnClickListener(new k3(this));
        p3();
        n3();
    }

    public int c3() {
        return R.layout.frag_system_msg;
    }

    public View i3(int i10) {
        View findViewById;
        Map map = this.f11026n;
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

    public final void j3() {
        List data;
        r3 r3Var = this.f11024l;
        if (!(r3Var == null || (data = r3Var.getData()) == null)) {
            data.clear();
        }
        r3 r3Var2 = this.f11024l;
        if (r3Var2 != null) {
            r3Var2.notifyDataSetChanged();
        }
        D();
    }

    /* renamed from: m3 */
    public k2 a3() {
        k2 k2Var = this.f11021i;
        if (k2Var != null) {
            return k2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final void n3() {
        this.f11024l = new r3();
        int i10 = R$id.mRvContent;
        ((RecyclerView) i3(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) i3(i10)).setAdapter(this.f11024l);
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.setOnLoadMoreListener(this, (RecyclerView) i3(i10));
        }
        r3 r3Var2 = this.f11024l;
        if (r3Var2 != null) {
            r3Var2.setLoadMoreView(new RecyclerLoadMoreView());
        }
        r3 r3Var3 = this.f11024l;
        if (r3Var3 != null) {
            r3Var3.disableLoadMoreIfNotFullPage();
        }
        r3 r3Var4 = this.f11024l;
        if (r3Var4 != null) {
            r3Var4.setOnItemClickListener(new l3(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r3(new k2(this, this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onLoadMoreRequested() {
        int i10;
        List data;
        b0.U(this, "load more requested");
        r3 r3Var = this.f11024l;
        if (r3Var == null || (data = r3Var.getData()) == null) {
            i10 = 0;
        } else {
            i10 = data.size();
        }
        if (i10 == 0 || i10 % this.f11022j != 0) {
            r3 r3Var2 = this.f11024l;
            if (r3Var2 != null) {
                r3Var2.loadMoreEnd();
                return;
            }
            return;
        }
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(false);
        a3().o();
    }

    public void onRefresh() {
        b0.U(this, "refresh requested");
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(false);
        }
        a3().l();
    }

    public final void p3() {
        int i10 = R$id.mSrlRefresh;
        ((SwipeRefreshLayout) i3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) i3(i10)).setOnRefreshListener(this);
    }

    public final void q3() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(true);
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.setEnableLoadMore(false);
        }
        a3().l();
    }

    public void r3(k2 k2Var) {
        i.g(k2Var, "<set-?>");
        this.f11021i = k2Var;
    }

    public final void s3(t0 t0Var) {
        this.f11025m = t0Var;
    }

    public void w() {
        b0.U(this, "no more data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        r3 r3Var = this.f11024l;
        if (r3Var != null) {
            r3Var.loadMoreEnd();
        }
    }
}
