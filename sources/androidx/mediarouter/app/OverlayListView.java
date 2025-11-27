package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class OverlayListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public final List f2468a = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public BitmapDrawable f2469a;

        /* renamed from: b  reason: collision with root package name */
        public float f2470b = 1.0f;

        /* renamed from: c  reason: collision with root package name */
        public Rect f2471c;

        /* renamed from: d  reason: collision with root package name */
        public Interpolator f2472d;

        /* renamed from: e  reason: collision with root package name */
        public long f2473e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f2474f;

        /* renamed from: g  reason: collision with root package name */
        public int f2475g;

        /* renamed from: h  reason: collision with root package name */
        public float f2476h = 1.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f2477i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public long f2478j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f2479k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f2480l;

        /* renamed from: m  reason: collision with root package name */
        public C0035a f2481m;

        /* renamed from: androidx.mediarouter.app.OverlayListView$a$a  reason: collision with other inner class name */
        public interface C0035a {
            void onAnimationEnd();
        }

        public a(BitmapDrawable bitmapDrawable, Rect rect) {
            this.f2469a = bitmapDrawable;
            this.f2474f = rect;
            this.f2471c = new Rect(rect);
            BitmapDrawable bitmapDrawable2 = this.f2469a;
            if (bitmapDrawable2 != null) {
                bitmapDrawable2.setAlpha((int) (this.f2470b * 255.0f));
                this.f2469a.setBounds(this.f2471c);
            }
        }

        public BitmapDrawable a() {
            return this.f2469a;
        }

        public boolean b() {
            return this.f2479k;
        }

        public a c(float f10, float f11) {
            this.f2476h = f10;
            this.f2477i = f11;
            return this;
        }

        public a d(C0035a aVar) {
            this.f2481m = aVar;
            return this;
        }

        public a e(long j10) {
            this.f2473e = j10;
            return this;
        }

        public a f(Interpolator interpolator) {
            this.f2472d = interpolator;
            return this;
        }

        public a g(int i10) {
            this.f2475g = i10;
            return this;
        }

        public void h(long j10) {
            this.f2478j = j10;
            this.f2479k = true;
        }

        public void i() {
            this.f2479k = true;
            this.f2480l = true;
            C0035a aVar = this.f2481m;
            if (aVar != null) {
                aVar.onAnimationEnd();
            }
        }

        public boolean j(long j10) {
            float f10;
            if (this.f2480l) {
                return false;
            }
            float f11 = 0.0f;
            float max = Math.max(0.0f, Math.min(1.0f, ((float) (j10 - this.f2478j)) / ((float) this.f2473e)));
            if (this.f2479k) {
                f11 = max;
            }
            Interpolator interpolator = this.f2472d;
            if (interpolator == null) {
                f10 = f11;
            } else {
                f10 = interpolator.getInterpolation(f11);
            }
            int i10 = (int) (((float) this.f2475g) * f10);
            Rect rect = this.f2471c;
            Rect rect2 = this.f2474f;
            rect.top = rect2.top + i10;
            rect.bottom = rect2.bottom + i10;
            float f12 = this.f2476h;
            float f13 = f12 + ((this.f2477i - f12) * f10);
            this.f2470b = f13;
            BitmapDrawable bitmapDrawable = this.f2469a;
            if (!(bitmapDrawable == null || rect == null)) {
                bitmapDrawable.setAlpha((int) (f13 * 255.0f));
                this.f2469a.setBounds(this.f2471c);
            }
            if (this.f2479k && f11 >= 1.0f) {
                this.f2480l = true;
                C0035a aVar = this.f2481m;
                if (aVar != null) {
                    aVar.onAnimationEnd();
                }
            }
            return !this.f2480l;
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(a aVar) {
        this.f2468a.add(aVar);
    }

    public void b() {
        for (a aVar : this.f2468a) {
            if (!aVar.b()) {
                aVar.h(getDrawingTime());
            }
        }
    }

    public void c() {
        for (a i10 : this.f2468a) {
            i10.i();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2468a.size() > 0) {
            Iterator it = this.f2468a.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BitmapDrawable a10 = aVar.a();
                if (a10 != null) {
                    a10.draw(canvas);
                }
                if (!aVar.j(getDrawingTime())) {
                    it.remove();
                }
            }
        }
    }
}
