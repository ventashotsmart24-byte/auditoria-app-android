package r8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r8.a;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

public class c extends TextureView implements a {

    /* renamed from: a  reason: collision with root package name */
    public q8.b f19424a;

    /* renamed from: b  reason: collision with root package name */
    public b f19425b;

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public c f19426a;

        /* renamed from: b  reason: collision with root package name */
        public SurfaceTexture f19427b;

        /* renamed from: c  reason: collision with root package name */
        public ISurfaceTextureHost f19428c;

        public a(c cVar, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.f19426a = cVar;
            this.f19427b = surfaceTexture;
            this.f19428c = iSurfaceTextureHost;
        }

        public a getRenderView() {
            return this.f19426a;
        }

        public Surface openSurface() {
            if (this.f19427b == null) {
                return null;
            }
            return new Surface(this.f19427b);
        }
    }

    public static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceTexture f19429a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f19430b;

        /* renamed from: c  reason: collision with root package name */
        public int f19431c;

        /* renamed from: d  reason: collision with root package name */
        public int f19432d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f19433e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19434f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19435g = false;

        /* renamed from: h  reason: collision with root package name */
        public WeakReference f19436h;

        /* renamed from: i  reason: collision with root package name */
        public Map f19437i = new ConcurrentHashMap();

        public b(c cVar) {
            this.f19436h = new WeakReference(cVar);
        }

        public void b(a.C0281a aVar) {
            a aVar2;
            this.f19437i.put(aVar, aVar);
            if (this.f19429a != null) {
                aVar2 = new a((c) this.f19436h.get(), this.f19429a, this);
                aVar.b(aVar2, this.f19431c, this.f19432d);
            } else {
                aVar2 = null;
            }
            if (this.f19430b) {
                if (aVar2 == null) {
                    aVar2 = new a((c) this.f19436h.get(), this.f19429a, this);
                }
                aVar.c(aVar2, 0, this.f19431c, this.f19432d);
            }
        }

        public void c() {
            this.f19435g = true;
        }

        public void d(a.C0281a aVar) {
            int i10;
            int i11;
            if (this.f19436h.get() != null) {
                i11 = ((c) this.f19436h.get()).getView().getWidth();
                i10 = ((c) this.f19436h.get()).getView().getHeight();
            } else {
                i11 = 0;
                i10 = 0;
            }
            aVar.d(i11, i10);
        }

        public void e(a.C0281a aVar) {
            this.f19437i.remove(aVar);
        }

        public void f(boolean z10) {
            this.f19433e = z10;
        }

        public void g() {
            this.f19434f = true;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            this.f19429a = surfaceTexture;
            this.f19430b = false;
            this.f19431c = 0;
            this.f19432d = 0;
            a aVar = new a((c) this.f19436h.get(), surfaceTexture, this);
            for (a.C0281a b10 : this.f19437i.keySet()) {
                b10.b(aVar, 0, 0);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f19429a = surfaceTexture;
            this.f19430b = false;
            this.f19431c = 0;
            this.f19432d = 0;
            a aVar = new a((c) this.f19436h.get(), surfaceTexture, this);
            for (a.C0281a a10 : this.f19437i.keySet()) {
                a10.a(aVar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onSurfaceTextureDestroyed: destroy: ");
            sb.append(this.f19433e);
            return this.f19433e;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            this.f19429a = surfaceTexture;
            this.f19430b = true;
            this.f19431c = i10;
            this.f19432d = i11;
            a aVar = new a((c) this.f19436h.get(), surfaceTexture, this);
            for (a.C0281a aVar2 : this.f19437i.keySet()) {
                aVar2.c(aVar, 0, i10, i11);
                d(aVar2);
            }
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture != null) {
                if (this.f19435g) {
                    if (surfaceTexture != this.f19429a) {
                        surfaceTexture.release();
                    } else if (!this.f19433e) {
                        surfaceTexture.release();
                    }
                } else if (this.f19434f) {
                    if (surfaceTexture != this.f19429a) {
                        surfaceTexture.release();
                    } else if (!this.f19433e) {
                        f(true);
                    }
                } else if (surfaceTexture != this.f19429a) {
                    surfaceTexture.release();
                } else if (!this.f19433e) {
                    f(true);
                }
            }
        }
    }

    public c(Context context) {
        super(context);
        c(context);
    }

    public void a(a.C0281a aVar) {
        this.f19425b.e(aVar);
    }

    public void b(a.C0281a aVar) {
        this.f19425b.b(aVar);
    }

    public final void c(Context context) {
        this.f19424a = new q8.b(this);
        b bVar = new b(this);
        this.f19425b = bVar;
        setSurfaceTextureListener(bVar);
    }

    public Bitmap getScreenshot() {
        return getBitmap();
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.f19425b.f19429a, this.f19425b);
    }

    public View getView() {
        return this;
    }

    public void onDetachedFromWindow() {
        this.f19425b.g();
        super.onDetachedFromWindow();
        this.f19425b.c();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(c.class.getName());
    }

    public void onMeasure(int i10, int i11) {
        this.f19424a.a(i10, i11);
        setMeasuredDimension(this.f19424a.c(), this.f19424a.b());
    }

    public void setAspectRatio(int i10) {
        this.f19424a.d(i10);
        requestLayout();
    }

    public void setVideoRotation(int i10) {
        this.f19424a.e(i10);
        setRotation((float) i10);
    }

    public void setVideoSize(int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            this.f19424a.f(i10, i11);
            requestLayout();
        }
    }
}
