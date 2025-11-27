package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.SearchAty;

public final /* synthetic */ class b4 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAty f16547a;

    public /* synthetic */ b4(SearchAty searchAty) {
        this.f16547a = searchAty;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        SearchAty.i3(this.f16547a, baseQuickAdapter, view, i10);
    }
}
