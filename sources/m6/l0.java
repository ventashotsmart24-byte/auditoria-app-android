package m6;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class l0 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18900a;

    public /* synthetic */ l0(TitanPlayerController titanPlayerController) {
        this.f18900a = titanPlayerController;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        TitanPlayerController.n4(this.f18900a, baseQuickAdapter, view, i10);
    }
}
