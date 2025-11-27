package h5;

import android.content.Context;
import com.mobile.brasiltv.app.App;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.entity.UMessage;

public final /* synthetic */ class e implements UPushMessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ App f6956a;

    public /* synthetic */ e(App app) {
        this.f6956a = app;
    }

    public final void handleMessage(Context context, UMessage uMessage) {
        App.t(this.f6956a, context, uMessage);
    }
}
