package b0;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final a f4106a;

    public interface a {
        void a(boolean z10);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final GestureDetector f4107a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f4107a = new GestureDetector(context, onGestureListener, handler);
        }

        public void a(boolean z10) {
            this.f4107a.setIsLongpressEnabled(z10);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f4107a.onTouchEvent(motionEvent);
        }
    }

    public i(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f4106a.onTouchEvent(motionEvent);
    }

    public void b(boolean z10) {
        this.f4106a.a(z10);
    }

    public i(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f4106a = new b(context, onGestureListener, handler);
    }
}
