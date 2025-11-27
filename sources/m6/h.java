package m6;

import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class h implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18885a;

    public /* synthetic */ h(TitanPlayerController titanPlayerController) {
        this.f18885a = titanPlayerController;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.F3(this.f18885a, observableEmitter);
    }
}
