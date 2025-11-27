package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.SingleColumnAty;

public final /* synthetic */ class t4 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SingleColumnAty f16686a;

    public /* synthetic */ t4(SingleColumnAty singleColumnAty) {
        this.f16686a = singleColumnAty;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        SingleColumnAty.i3(this.f16686a, baseQuickAdapter, view, i10);
    }
}
