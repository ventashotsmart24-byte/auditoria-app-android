package r6;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;

public final /* synthetic */ class d implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgramRecommendInfoView f19406a;

    public /* synthetic */ d(ProgramRecommendInfoView programRecommendInfoView) {
        this.f19406a = programRecommendInfoView;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        ProgramRecommendInfoView.d(this.f19406a, baseQuickAdapter, view, i10);
    }
}
