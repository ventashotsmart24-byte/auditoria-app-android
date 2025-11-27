package k6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class a0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f17567a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17568b;

    public /* synthetic */ a0(j0 j0Var, SwitchAccountBean switchAccountBean) {
        this.f17567a = j0Var;
        this.f17568b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        j0.Y(this.f17567a, this.f17568b, observableEmitter);
    }
}
