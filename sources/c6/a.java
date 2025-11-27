package c6;

import android.content.Context;
import android.os.Looper;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.umeng.analytics.MobclickAgent;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;

public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: d  reason: collision with root package name */
    public static a f4892d = new a();

    /* renamed from: a  reason: collision with root package name */
    public Context f4893a;

    /* renamed from: b  reason: collision with root package name */
    public Map f4894b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f4895c;

    /* renamed from: c6.a$a  reason: collision with other inner class name */
    public class C0152a implements Runnable {
        public C0152a() {
        }

        public void run() {
            Looper.prepare();
            f1.f12517a.w(R.string.app_restart);
            Looper.loop();
        }
    }

    public static a a() {
        return f4892d;
    }

    public void b(Context context) {
        this.f4893a = context;
        this.f4895c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Context context = this.f4893a;
        if (context != null) {
            MobclickAgent.onKillProcess(context);
            new Thread(new C0152a()).start();
            try {
                Thread.currentThread();
                Thread.sleep(2000);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            com.mobile.brasiltv.utils.a.b().e();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f4895c;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
