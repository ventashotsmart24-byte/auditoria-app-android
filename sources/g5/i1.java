package g5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

public final /* synthetic */ class i1 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f16933a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p2 f16934b;

    public /* synthetic */ i1(r1 r1Var, p2 p2Var) {
        this.f16933a = r1Var;
        this.f16934b = p2Var;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        r1.D(this.f16933a, this.f16934b, baseQuickAdapter, view, i10);
    }
}
