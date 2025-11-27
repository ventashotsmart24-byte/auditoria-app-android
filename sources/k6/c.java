package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class c implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f17659a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17660b;

    public /* synthetic */ c(f fVar, SwitchAccountBean switchAccountBean) {
        this.f17659a = fVar;
        this.f17660b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        f.v(this.f17659a, this.f17660b, observableEmitter);
    }
}
