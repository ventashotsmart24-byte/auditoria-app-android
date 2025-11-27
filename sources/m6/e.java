package m6;

import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class e implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18876a;

    public /* synthetic */ e(TitanPlayerController titanPlayerController) {
        this.f18876a = titanPlayerController;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.O3(this.f18876a, observableEmitter);
    }
}
