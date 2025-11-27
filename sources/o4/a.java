package o4;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import io.reactivex.FlowableEmitter;

public final /* synthetic */ class a implements ProgramaticContextualTriggers.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter f10621a;

    public /* synthetic */ a(FlowableEmitter flowableEmitter) {
        this.f10621a = flowableEmitter;
    }

    public final void onEventTrigger(String str) {
        this.f10621a.onNext(str);
    }
}
