package t5;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import u8.a;

public final /* synthetic */ class l implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f19533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f19534b;

    public /* synthetic */ l(a aVar, SwitchAccountBean switchAccountBean) {
        this.f19533a = aVar;
        this.f19534b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        o.k(this.f19533a, this.f19534b, observableEmitter);
    }
}
