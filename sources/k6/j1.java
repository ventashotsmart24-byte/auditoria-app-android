package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class j1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m1 f17901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17902b;

    public /* synthetic */ j1(m1 m1Var, SwitchAccountBean switchAccountBean) {
        this.f17901a = m1Var;
        this.f17902b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        m1.o(this.f17901a, this.f17902b, observableEmitter);
    }
}
