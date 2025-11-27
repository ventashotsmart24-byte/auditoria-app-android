package m6;

import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class b implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18866a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f18867b;

    public /* synthetic */ b(TitanPlayerController titanPlayerController, int i10) {
        this.f18866a = titanPlayerController;
        this.f18867b = i10;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.W3(this.f18866a, this.f18867b, observableEmitter);
    }
}
