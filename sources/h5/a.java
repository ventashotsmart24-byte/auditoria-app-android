package h5;

import com.mobile.brasiltv.app.App;
import com.umeng.message.api.UPushAliasCallback;

public final /* synthetic */ class a implements UPushAliasCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ App f6953a;

    public /* synthetic */ a(App app) {
        this.f6953a = app;
    }

    public final void onMessage(boolean z10, String str) {
        App.p(this.f6953a, z10, str);
    }
}
