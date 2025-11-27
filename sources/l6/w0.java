package l6;

import com.mobile.brasiltv.db.LiveSubProgram;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class w0 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveSubProgram f18615a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z0 f18616b;

    public /* synthetic */ w0(LiveSubProgram liveSubProgram, z0 z0Var) {
        this.f18615a = liveSubProgram;
        this.f18616b = z0Var;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        z0.C(this.f18615a, this.f18616b, observableEmitter);
    }
}
