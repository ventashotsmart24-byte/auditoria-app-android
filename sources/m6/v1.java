package m6;

import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class v1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18937a;

    public /* synthetic */ v1(TitanPlayerController titanPlayerController) {
        this.f18937a = titanPlayerController;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.L3(this.f18937a, observableEmitter);
    }
}
