package r6;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.player.view.ProgramSetInfoView;

public final /* synthetic */ class g implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgramSetInfoView f19409a;

    public /* synthetic */ g(ProgramSetInfoView programSetInfoView) {
        this.f19409a = programSetInfoView;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        ProgramSetInfoView.v(this.f19409a, baseQuickAdapter, view, i10);
    }
}
