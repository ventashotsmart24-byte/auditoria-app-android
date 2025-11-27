package m6;

import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseGuideManager f18919b;

    public /* synthetic */ q(TitanPlayerController titanPlayerController, BaseGuideManager baseGuideManager) {
        this.f18918a = titanPlayerController;
        this.f18919b = baseGuideManager;
    }

    public final void run() {
        TitanPlayerController.K4(this.f18918a, this.f18919b);
    }
}
