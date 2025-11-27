package r6;

import android.view.View;
import com.mobile.brasiltv.player.view.ProgramActorInfoView;
import mobile.com.requestframe.utils.response.AssetData;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgramActorInfoView f19404a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetData f19405b;

    public /* synthetic */ b(ProgramActorInfoView programActorInfoView, AssetData assetData) {
        this.f19404a = programActorInfoView;
        this.f19405b = assetData;
    }

    public final void onClick(View view) {
        ProgramActorInfoView.f(this.f19404a, this.f19405b, view);
    }
}
