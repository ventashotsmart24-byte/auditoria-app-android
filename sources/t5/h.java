package t5;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import u8.a;

public final /* synthetic */ class h implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f19518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f19519b;

    public /* synthetic */ h(a aVar, SwitchAccountBean switchAccountBean) {
        this.f19518a = aVar;
        this.f19519b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        k.n(this.f19518a, this.f19519b, observableEmitter);
    }
}
