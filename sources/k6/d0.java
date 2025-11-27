package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class d0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f17667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17668b;

    public /* synthetic */ d0(j0 j0Var, SwitchAccountBean switchAccountBean) {
        this.f17667a = j0Var;
        this.f17668b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        j0.U(this.f17667a, this.f17668b, observableEmitter);
    }
}
