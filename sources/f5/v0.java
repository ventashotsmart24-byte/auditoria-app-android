package f5;

import com.mobile.brasiltv.activity.MainAty;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class v0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainAty f16696a;

    public /* synthetic */ v0(MainAty mainAty) {
        this.f16696a = mainAty;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        MainAty.e4(this.f16696a, observableEmitter);
    }
}
