package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.SearchAty;

public final /* synthetic */ class a4 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAty f16539a;

    public /* synthetic */ a4(SearchAty searchAty) {
        this.f16539a = searchAty;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        SearchAty.h3(this.f16539a, baseQuickAdapter, view, i10);
    }
}
