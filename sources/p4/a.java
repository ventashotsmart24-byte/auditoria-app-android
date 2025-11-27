package p4;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f10625b;

    public /* synthetic */ a(String str, Component component) {
        this.f10624a = str;
        this.f10625b = component;
    }

    public final Object create(ComponentContainer componentContainer) {
        return ComponentMonitor.lambda$processRegistrar$0(this.f10624a, this.f10625b, componentContainer);
    }
}
