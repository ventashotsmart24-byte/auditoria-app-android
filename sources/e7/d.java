package e7;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.mobile.brasiltv.activity.ScanLoginActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public final class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final ScanLoginActivity f16517a;

    /* renamed from: b  reason: collision with root package name */
    public final Hashtable f16518b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f16519c;

    /* renamed from: d  reason: collision with root package name */
    public final CountDownLatch f16520d = new CountDownLatch(1);

    public d(ScanLoginActivity scanLoginActivity, Vector vector, String str, ResultPointCallback resultPointCallback) {
        this.f16517a = scanLoginActivity;
        Hashtable hashtable = new Hashtable(3);
        this.f16518b = hashtable;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(b.f16512c);
            vector.addAll(b.f16513d);
            vector.addAll(b.f16514e);
        }
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            hashtable.put(DecodeHintType.CHARACTER_SET, str);
        }
        hashtable.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    public Handler a() {
        try {
            this.f16520d.await();
        } catch (InterruptedException unused) {
        }
        return this.f16519c;
    }

    public void run() {
        Looper.prepare();
        this.f16519c = new c(this.f16517a, this.f16518b);
        this.f16520d.countDown();
        Looper.loop();
    }
}
