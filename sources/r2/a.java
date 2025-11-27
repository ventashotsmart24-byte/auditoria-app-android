package r2;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;

public abstract class a {

    /* renamed from: r2.a$a  reason: collision with other inner class name */
    public static class C0119a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f9014a;

        public C0119a(Handler handler) {
            this.f9014a = handler;
        }

        public void handleMessage(Message message) {
            Handler handler = this.f9014a;
            if (handler != null) {
                try {
                    handler.handleMessage(message);
                } catch (WindowManager.BadTokenException unused) {
                }
            }
        }
    }

    public static void a(Toast toast) {
        try {
            Field declaredField = toast.getClass().getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Handler handler = (Handler) declaredField2.get(obj);
            if (!(handler instanceof C0119a)) {
                declaredField2.set(obj, new C0119a(handler));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            m2.a.a(e10, "FIX TOAST FAIL");
        }
    }
}
