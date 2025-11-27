package e6;

import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ScanLoginAty;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class b1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScanLoginAty f16445a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f16446b;

    public /* synthetic */ b1(ScanLoginAty scanLoginAty, SwitchAccountBean switchAccountBean) {
        this.f16445a = scanLoginAty;
        this.f16446b = switchAccountBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        ScanLoginAty.k3(this.f16445a, this.f16446b, observableEmitter);
    }
}
