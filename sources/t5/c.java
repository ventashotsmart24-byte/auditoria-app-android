package t5;

import com.mobile.brasiltv.db.SwitchAccountBean;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import u8.a;

public final /* synthetic */ class c implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f19492a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f19493b;

    public /* synthetic */ c(a aVar, SwitchAccountBean switchAccountBean) {
        this.f19492a = aVar;
        this.f19493b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        f.m(this.f19492a, this.f19493b, observableEmitter);
    }
}
