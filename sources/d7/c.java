package d7;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;

public final class c {

    /* renamed from: k  reason: collision with root package name */
    public static c f16356k;

    /* renamed from: l  reason: collision with root package name */
    public static final int f16357l;

    /* renamed from: a  reason: collision with root package name */
    public final Context f16358a;

    /* renamed from: b  reason: collision with root package name */
    public final b f16359b;

    /* renamed from: c  reason: collision with root package name */
    public Camera f16360c;

    /* renamed from: d  reason: collision with root package name */
    public Rect f16361d;

    /* renamed from: e  reason: collision with root package name */
    public Rect f16362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16363f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16364g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f16365h;

    /* renamed from: i  reason: collision with root package name */
    public final f f16366i;

    /* renamed from: j  reason: collision with root package name */
    public final a f16367j;

    static {
        int i10;
        try {
            i10 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i10 = 10000;
        }
        f16357l = i10;
    }

    public c(Context context) {
        boolean z10;
        this.f16358a = context;
        b bVar = new b(context);
        this.f16359b = bVar;
        if (Integer.parseInt(Build.VERSION.SDK) > 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f16365h = z10;
        this.f16366i = new f(bVar, z10);
        this.f16367j = new a();
    }

    public static c c() {
        return f16356k;
    }

    public static void f(Context context) {
        if (f16356k == null) {
            f16356k = new c(context);
        }
    }

    public e a(byte[] bArr, int i10, int i11) {
        Rect e10 = e();
        int e11 = this.f16359b.e();
        String f10 = this.f16359b.f();
        if (e11 == 16 || e11 == 17) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        } else if ("yuv420p".equals(f10)) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        } else {
            throw new IllegalArgumentException("Unsupported picture format: " + e11 + '/' + f10);
        }
    }

    public void b() {
        if (this.f16360c != null) {
            d.a();
            this.f16360c.release();
            this.f16360c = null;
        }
    }

    public Rect d() {
        Point g10 = this.f16359b.g();
        if (g10 == null) {
            return null;
        }
        if (this.f16361d == null) {
            if (this.f16360c == null) {
                return null;
            }
            int i10 = g10.x;
            int i11 = (i10 * 7) / 10;
            int i12 = g10.y;
            int i13 = (i12 * 7) / 10;
            if (i13 < i11) {
                i11 = i13;
            }
            int i14 = (i10 - i11) / 2;
            int i15 = (i12 - i11) / 2;
            this.f16361d = new Rect(i14, i15, i14 + i11, i11 + i15);
        }
        return this.f16361d;
    }

    public Rect e() {
        if (this.f16362e == null) {
            Rect rect = new Rect(d());
            Point c10 = this.f16359b.c();
            Point g10 = this.f16359b.g();
            int i10 = rect.left;
            int i11 = c10.y;
            int i12 = g10.x;
            rect.left = (i10 * i11) / i12;
            rect.right = (rect.right * i11) / i12;
            int i13 = rect.top;
            int i14 = c10.x;
            int i15 = g10.y;
            rect.top = (i13 * i14) / i15;
            rect.bottom = (rect.bottom * i14) / i15;
            this.f16362e = rect;
        }
        return this.f16362e;
    }

    public void g(SurfaceHolder surfaceHolder) {
        if (this.f16360c == null) {
            Camera open = Camera.open();
            this.f16360c = open;
            if (open != null) {
                open.setPreviewDisplay(surfaceHolder);
                if (!this.f16363f) {
                    this.f16363f = true;
                    this.f16359b.h(this.f16360c);
                }
                this.f16359b.i(this.f16360c);
                d.b();
                return;
            }
            throw new IOException();
        }
    }

    public void h(Handler handler, int i10) {
        if (this.f16360c != null && this.f16364g) {
            this.f16367j.a(handler, i10);
            this.f16360c.autoFocus(this.f16367j);
        }
    }

    public void i(Handler handler, int i10) {
        if (this.f16360c != null && this.f16364g) {
            this.f16366i.a(handler, i10);
            if (this.f16365h) {
                this.f16360c.setOneShotPreviewCallback(this.f16366i);
            } else {
                this.f16360c.setPreviewCallback(this.f16366i);
            }
        }
    }

    public void j() {
        Camera camera = this.f16360c;
        if (camera != null && !this.f16364g) {
            camera.startPreview();
            this.f16364g = true;
        }
    }

    public void k() {
        Camera camera = this.f16360c;
        if (camera != null && this.f16364g) {
            if (!this.f16365h) {
                camera.setPreviewCallback((Camera.PreviewCallback) null);
            }
            this.f16360c.stopPreview();
            this.f16366i.a((Handler) null, 0);
            this.f16367j.a((Handler) null, 0);
            this.f16364g = false;
        }
    }
}
