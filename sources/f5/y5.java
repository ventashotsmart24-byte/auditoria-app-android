package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.TopTenActivity;

public final /* synthetic */ class y5 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TopTenActivity f16725a;

    public /* synthetic */ y5(TopTenActivity topTenActivity) {
        this.f16725a = topTenActivity;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        TopTenActivity.m3(this.f16725a, baseQuickAdapter, view, i10);
    }
}
