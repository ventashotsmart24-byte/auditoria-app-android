package a8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.umeng.analytics.pro.f;
import t9.i;
import z7.b;

public final class a implements b {
    public boolean a(int i10) {
        return true;
    }

    public void b(z7.a aVar) {
        i.g(aVar, "callback");
    }

    public int c(Context context) {
        i.g(context, f.X);
        return 0;
    }

    public void d(Activity activity) {
        i.g(activity, "activity");
    }

    public void e(int i10, int i11, Intent intent) {
    }

    public void f(Activity activity) {
        i.g(activity, "activity");
    }
}
