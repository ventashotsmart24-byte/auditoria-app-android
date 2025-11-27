package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import org.json.JSONObject;

public final class s implements ActionInfo {
    public final String getModule(Context context) {
        return "push";
    }

    public final String[] getSupportAction(Context context) {
        return new String[]{a.f14512e};
    }

    public final boolean getSwitchState(Context context, String str) {
        if (TextUtils.equals(str, a.f14512e)) {
            return f.f15949a;
        }
        return false;
    }

    public final void onCommand(Context context, String str, Object obj) {
        Future future;
        if (TextUtils.equals(str, a.f14512e) && (obj instanceof JSONObject) && f.b(context)) {
            JSONObject jSONObject = (JSONObject) obj;
            WeakReference<Future<?>> weakReference = o.f15991a;
            if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                o.f15991a = new WeakReference<>(b.b(new n(jSONObject)));
            }
        }
    }
}
