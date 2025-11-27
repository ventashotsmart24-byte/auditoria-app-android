package h5;

import com.mobile.brasiltv.app.App;
import com.umeng.message.api.UPushAliasCallback;

public final /* synthetic */ class b implements UPushAliasCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ App f6954a;

    public /* synthetic */ b(App app) {
        this.f6954a = app;
    }

    public final void onMessage(boolean z10, String str) {
        App.q(this.f6954a, z10, str);
    }
}
