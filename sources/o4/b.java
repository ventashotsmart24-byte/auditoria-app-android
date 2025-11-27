package o4;

import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public final /* synthetic */ class b implements FlowableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgrammaticContextualTriggerFlowableModule f10622a;

    public /* synthetic */ b(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.f10622a = programmaticContextualTriggerFlowableModule;
    }

    public final void subscribe(FlowableEmitter flowableEmitter) {
        this.f10622a.lambda$providesProgramaticContextualTriggerStream$1(flowableEmitter);
    }
}
