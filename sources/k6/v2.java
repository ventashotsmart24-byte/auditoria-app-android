package k6;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import mobile.com.requestframe.utils.response.Channel;

public final /* synthetic */ class v2 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Channel f18125a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h3 f18126b;

    public /* synthetic */ v2(Channel channel, h3 h3Var) {
        this.f18125a = channel;
        this.f18126b = h3Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        h3.w(this.f18125a, this.f18126b, observableEmitter);
    }
}
