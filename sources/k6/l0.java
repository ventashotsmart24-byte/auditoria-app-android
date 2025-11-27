package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class l0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b1 f17930a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17931b;

    public /* synthetic */ l0(b1 b1Var, SwitchAccountBean switchAccountBean) {
        this.f17930a = b1Var;
        this.f17931b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        b1.a1(this.f17930a, this.f17931b, observableEmitter);
    }
}
