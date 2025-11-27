package m6;

import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class t0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18930a;

    public /* synthetic */ t0(TitanPlayerController titanPlayerController) {
        this.f18930a = titanPlayerController;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.I3(this.f18930a, observableEmitter);
    }
}
