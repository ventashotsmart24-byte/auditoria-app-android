package r8;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r8.a;

public class b extends SurfaceView implements a {

    /* renamed from: a  reason: collision with root package name */
    public q8.b f19413a;

    /* renamed from: b  reason: collision with root package name */
    public C0282b f19414b;

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public b f19415a;

        /* renamed from: b  reason: collision with root package name */
        public SurfaceHolder f19416b;

        public a(b bVar, SurfaceHolder surfaceHolder) {
            this.f19415a = bVar;
            this.f19416b = surfaceHolder;
        }

        public a getRenderView() {
            return this.f19415a;
        }

        public Surface openSurface() {
            SurfaceHolder surfaceHolder = this.f19416b;
            if (surfaceHolder == null) {
                return null;
            }
            return surfaceHolder.getSurface();
        }
    }

    /* renamed from: r8.b$b  reason: collision with other inner class name */
    public static final class C0282b implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceHolder f19417a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19418b;

        /* renamed from: c  reason: collision with root package name */
        public int f19419c;

        /* renamed from: d  reason: collision with root package name */
        public int f19420d;

        /* renamed from: e  reason: collision with root package name */
        public int f19421e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference f19422f;

        /* renamed from: g  reason: collision with root package name */
        public Map f19423g = new ConcurrentHashMap();

        public C0282b(b bVar) {
            this.f19422f = new WeakReference(bVar);
        }

        public void a(a.C0281a aVar) {
            a aVar2;
            this.f19423g.put(aVar, aVar);
            if (this.f19417a != null) {
                aVar2 = new a((b) this.f19422f.get(), this.f19417a);
                aVar.b(aVar2, this.f19420d, this.f19421e);
            } else {
                aVar2 = null;
            }
            if (this.f19418b) {
                if (aVar2 == null) {
                    aVar2 = new a((b) this.f19422f.get(), this.f19417a);
                }
                aVar.c(aVar2, this.f19419c, this.f19420d, this.f19421e);
            }
        }

        public void b(a.C0281a aVar) {
            int i10;
            int i11;
            if (this.f19422f.get() != null) {
                i11 = ((b) this.f19422f.get()).getView().getWidth();
                i10 = ((b) this.f19422f.get()).getView().getHeight();
            } else {
                i11 = 0;
                i10 = 0;
            }
            aVar.d(i11, i10);
        }

        public void c(a.C0281a aVar) {
            this.f19423g.remove(aVar);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            this.f19417a = surfaceHolder;
            this.f19418b = true;
            this.f19419c = i10;
            this.f19420d = i11;
            this.f19421e = i12;
            a aVar = new a((b) this.f19422f.get(), this.f19417a);
            for (a.C0281a aVar2 : this.f19423g.keySet()) {
                aVar2.c(aVar, i10, i11, i12);
                b(aVar2);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f19417a = surfaceHolder;
            this.f19418b = false;
            this.f19419c = 0;
            this.f19420d = 0;
            this.f19421e = 0;
            a aVar = new a((b) this.f19422f.get(), this.f19417a);
            for (a.C0281a b10 : this.f19423g.keySet()) {
                b10.b(aVar, 0, 0);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f19417a = null;
            this.f19418b = false;
            this.f19419c = 0;
            this.f19420d = 0;
            this.f19421e = 0;
            a aVar = new a((b) this.f19422f.get(), this.f19417a);
            for (a.C0281a a10 : this.f19423g.keySet()) {
                a10.a(aVar);
            }
        }
    }

    public b(Context context) {
        super(context);
        c(context);
    }

    public void a(a.C0281a aVar) {
        this.f19414b.c(aVar);
    }

    public void b(a.C0281a aVar) {
        this.f19414b.a(aVar);
    }

    public final void c(Context context) {
        this.f19413a = new q8.b(this);
        this.f19414b = new C0282b(this);
        getHolder().addCallback(this.f19414b);
        getHolder().setType(0);
    }

    public Bitmap getScreenshot() {
        return null;
    }

    public View getView() {
        return this;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(b.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(b.class.getName());
    }

    public void onMeasure(int i10, int i11) {
        this.f19413a.a(i10, i11);
        setMeasuredDimension(this.f19413a.c(), this.f19413a.b());
    }

    public void setAspectRatio(int i10) {
        this.f19413a.d(i10);
        requestLayout();
    }

    public void setVideoRotation(int i10) {
        Log.e("", "SurfaceView doesn't support rotation (" + i10 + ")!\n");
    }

    public void setVideoSize(int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            this.f19413a.f(i10, i11);
            getHolder().setFixedSize(i10, i11);
            requestLayout();
        }
    }
}
