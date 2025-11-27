package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.MyFavListActivity;

public final /* synthetic */ class p1 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyFavListActivity f16653a;

    public /* synthetic */ p1(MyFavListActivity myFavListActivity) {
        this.f16653a = myFavListActivity;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        MyFavListActivity.U3(this.f16653a, baseQuickAdapter, view, i10);
    }
}
