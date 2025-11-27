package r6;

import android.view.View;
import com.mobile.brasiltv.player.view.ProgramActorInfoView;
import mobile.com.requestframe.utils.response.AssetData;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetData f19402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgramActorInfoView f19403b;

    public /* synthetic */ a(AssetData assetData, ProgramActorInfoView programActorInfoView) {
        this.f19402a = assetData;
        this.f19403b = programActorInfoView;
    }

    public final void onClick(View view) {
        ProgramActorInfoView.e(this.f19402a, this.f19403b, view);
    }
}
