package b6;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.RecyclerLoadMoreView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import f5.t0;
import i6.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.a;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.pushMsg;
import t9.i;

public final class d extends e<a> implements h, SwipeRefreshLayout.j, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: i  reason: collision with root package name */
    public a f10934i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10935j = 10;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10936k = true;

    /* renamed from: l  reason: collision with root package name */
    public g5.a f10937l;

    /* renamed from: m  reason: collision with root package name */
    public t0 f10938m;

    /* renamed from: n  reason: collision with root package name */
    public Map f10939n = new LinkedHashMap();

    public static final void k3(d dVar, View view) {
        i.g(dVar, "this$0");
        dVar.q3();
    }

    public static final void l3(d dVar, View view) {
        i.g(dVar, "this$0");
        dVar.q3();
    }

    public static final void o3(d dVar, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Msg msg;
        String str;
        boolean z10;
        pushMsg content;
        pushMsg content2;
        i.g(dVar, "this$0");
        g5.a aVar = dVar.f10937l;
        String str2 = null;
        if (aVar != null) {
            msg = (Msg) aVar.getItem(i10);
        } else {
            msg = null;
        }
        if (msg == null || (content2 = msg.getContent()) == null) {
            str = null;
        } else {
            str = content2.getUrl();
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (!(msg == null || (content = msg.getContent()) == null)) {
                str2 = content.getUrl();
            }
            String str3 = str2;
            i.d(str3);
            b0.k0(dVar, str3, false, true, false, 8, (Object) null);
        } else if (i.b(w6.i.f9510g.I(), "1")) {
            f1.a.j(f1.f12517a, dVar.getContext(), R.string.vod_please_bind, 0, 4, (Object) null);
        } else {
            b0.B(dVar);
        }
        dVar.a3().p(i10, msg);
    }

    public void A(ArrayList arrayList, boolean z10) {
        i.g(arrayList, "datas");
        b0.U(this, "find data result:" + arrayList.size() + " freshData: " + z10);
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(0);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(8);
        if (z10) {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
            g5.a aVar = this.f10937l;
            if (aVar != null) {
                aVar.setEnableLoadMore(true);
            }
            g5.a aVar2 = this.f10937l;
            if (aVar2 != null) {
                aVar2.setNewData(arrayList);
            }
        } else {
            ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
            if (arrayList.size() == this.f10935j) {
                g5.a aVar3 = this.f10937l;
                if (aVar3 != null) {
                    aVar3.loadMoreComplete();
                }
            } else {
                g5.a aVar4 = this.f10937l;
                if (aVar4 != null) {
                    aVar4.loadMoreEnd();
                }
            }
            g5.a aVar5 = this.f10937l;
            if (aVar5 != null) {
                aVar5.addData(arrayList);
            }
        }
        t0 t0Var = this.f10938m;
        if (t0Var != null) {
            t0Var.c1(1);
        }
    }

    public void D() {
        b0.U(this, "empty data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setRefreshing(false);
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.setEnableLoadMore(true);
        }
        ((RecyclerView) i3(R$id.mRvContent)).setVisibility(8);
        ((AutoLinearLayout) i3(R$id.mAllMsgEmpty)).setVisibility(0);
        t0 t0Var = this.f10938m;
        if (t0Var != null) {
            t0Var.T(1);
        }
    }

    public void E() {
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.loadMoreComplete();
        }
    }

    public void T2() {
        List data;
        b0.L(this, "activity msg frag");
        int i10 = 0;
        if (this.f10936k) {
            this.f10936k = false;
            q3();
            return;
        }
        g5.a aVar = this.f10937l;
        if (!(aVar == null || (data = aVar.getData()) == null)) {
            i10 = data.size();
        }
        if (i10 > 0) {
            t0 t0Var = this.f10938m;
            if (t0Var != null) {
                t0Var.c1(1);
                return;
            }
            return;
        }
        t0 t0Var2 = this.f10938m;
        if (t0Var2 != null) {
            t0Var2.T(1);
        }
    }

    public void X2() {
        this.f10939n.clear();
    }

    public void Y2() {
        ((ImageView) i3(R$id.mIvMsgEmpty)).setOnClickListener(new a(this));
        ((TextView) i3(R$id.mTvMsgEmpty)).setOnClickListener(new b(this));
        p3();
        n3();
    }

    public int c3() {
        return R.layout.frag_activity_msg;
    }

    public View i3(int i10) {
        View findViewById;
        Map map = this.f10939n;
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
        g5.a aVar = this.f10937l;
        if (!(aVar == null || (data = aVar.getData()) == null)) {
            data.clear();
        }
        g5.a aVar2 = this.f10937l;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
        D();
    }

    /* renamed from: m3 */
    public a a3() {
        a aVar = this.f10934i;
        if (aVar != null) {
            return aVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void n0(int i10) {
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.notifyItemChanged(i10);
        }
    }

    public final void n3() {
        this.f10937l = new g5.a();
        int i10 = R$id.mRvContent;
        ((RecyclerView) i3(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) i3(i10)).setAdapter(this.f10937l);
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.setOnLoadMoreListener(this, (RecyclerView) i3(i10));
        }
        g5.a aVar2 = this.f10937l;
        if (aVar2 != null) {
            aVar2.setLoadMoreView(new RecyclerLoadMoreView());
        }
        g5.a aVar3 = this.f10937l;
        if (aVar3 != null) {
            aVar3.disableLoadMoreIfNotFullPage();
        }
        g5.a aVar4 = this.f10937l;
        if (aVar4 != null) {
            aVar4.setOnItemClickListener(new c(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r3(new a(this, this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onLoadMoreRequested() {
        int i10;
        List data;
        b0.U(this, "load more requested");
        g5.a aVar = this.f10937l;
        if (aVar == null || (data = aVar.getData()) == null) {
            i10 = 0;
        } else {
            i10 = data.size();
        }
        if (i10 == 0 || i10 % this.f10935j != 0) {
            g5.a aVar2 = this.f10937l;
            if (aVar2 != null) {
                aVar2.loadMoreEnd();
                return;
            }
            return;
        }
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(false);
        a3().o();
    }

    public void onRefresh() {
        b0.U(this, "refresh requested");
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.setEnableLoadMore(false);
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
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.setEnableLoadMore(false);
        }
        a3().l();
    }

    public void r3(a aVar) {
        i.g(aVar, "<set-?>");
        this.f10934i = aVar;
    }

    public final void s3(t0 t0Var) {
        this.f10938m = t0Var;
    }

    public void w() {
        b0.U(this, "no more data result");
        ((SwipeRefreshLayout) i3(R$id.mSrlRefresh)).setEnabled(true);
        g5.a aVar = this.f10937l;
        if (aVar != null) {
            aVar.loadMoreEnd();
        }
    }
}
