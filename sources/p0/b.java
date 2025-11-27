package p0;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import com.mobile.brasiltv.view.RoundedDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: f  reason: collision with root package name */
    public static final c f8768f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List f8769a;

    /* renamed from: b  reason: collision with root package name */
    public final List f8770b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f8771c = new androidx.collection.a();

    /* renamed from: d  reason: collision with root package name */
    public final SparseBooleanArray f8772d = new SparseBooleanArray();

    /* renamed from: e  reason: collision with root package name */
    public final d f8773e = a();

    public static class a implements c {
        public boolean a(int i10, float[] fArr) {
            if (d(fArr) || b(fArr) || c(fArr)) {
                return false;
            }
            return true;
        }

        public final boolean b(float[] fArr) {
            if (fArr[2] <= 0.05f) {
                return true;
            }
            return false;
        }

        public final boolean c(float[] fArr) {
            float f10 = fArr[0];
            if (f10 < 10.0f || f10 > 37.0f || fArr[1] > 0.82f) {
                return false;
            }
            return true;
        }

        public final boolean d(float[] fArr) {
            if (fArr[2] >= 0.95f) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: p0.b$b  reason: collision with other inner class name */
    public static final class C0116b {

        /* renamed from: a  reason: collision with root package name */
        public final List f8774a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f8775b;

        /* renamed from: c  reason: collision with root package name */
        public final List f8776c;

        /* renamed from: d  reason: collision with root package name */
        public int f8777d = 16;

        /* renamed from: e  reason: collision with root package name */
        public int f8778e = 12544;

        /* renamed from: f  reason: collision with root package name */
        public int f8779f = -1;

        /* renamed from: g  reason: collision with root package name */
        public final List f8780g;

        /* renamed from: h  reason: collision with root package name */
        public Rect f8781h;

        public C0116b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f8776c = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f8780g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(b.f8768f);
            this.f8775b = bitmap;
            this.f8774a = null;
            arrayList.add(c.f8791e);
            arrayList.add(c.f8792f);
            arrayList.add(c.f8793g);
            arrayList.add(c.f8794h);
            arrayList.add(c.f8795i);
            arrayList.add(c.f8796j);
        }

        public b a() {
            List list;
            c[] cVarArr;
            Bitmap bitmap = this.f8775b;
            if (bitmap != null) {
                Bitmap d10 = d(bitmap);
                Rect rect = this.f8781h;
                if (!(d10 == this.f8775b || rect == null)) {
                    double width = (double) d10.getWidth();
                    double width2 = (double) this.f8775b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d11 = width / width2;
                    double d12 = (double) rect.left;
                    Double.isNaN(d12);
                    rect.left = (int) Math.floor(d12 * d11);
                    double d13 = (double) rect.top;
                    Double.isNaN(d13);
                    rect.top = (int) Math.floor(d13 * d11);
                    double d14 = (double) rect.right;
                    Double.isNaN(d14);
                    rect.right = Math.min((int) Math.ceil(d14 * d11), d10.getWidth());
                    double d15 = (double) rect.bottom;
                    Double.isNaN(d15);
                    rect.bottom = Math.min((int) Math.ceil(d15 * d11), d10.getHeight());
                }
                int[] b10 = b(d10);
                int i10 = this.f8777d;
                if (this.f8780g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List list2 = this.f8780g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                a aVar = new a(b10, i10, cVarArr);
                if (d10 != this.f8775b) {
                    d10.recycle();
                }
                list = aVar.d();
            } else {
                list = this.f8774a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f8776c);
            bVar.b();
            return bVar;
        }

        public final int[] b(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f8781h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f8781h.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i10 = 0; i10 < height2; i10++) {
                Rect rect2 = this.f8781h;
                System.arraycopy(iArr, ((rect2.top + i10) * width) + rect2.left, iArr2, i10 * width2, width2);
            }
            return iArr2;
        }

        public C0116b c(int i10) {
            this.f8777d = i10;
            return this;
        }

        public final Bitmap d(Bitmap bitmap) {
            int max;
            int i10;
            double d10 = -1.0d;
            if (this.f8778e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i11 = this.f8778e;
                if (width > i11) {
                    double d11 = (double) i11;
                    double d12 = (double) width;
                    Double.isNaN(d11);
                    Double.isNaN(d12);
                    d10 = Math.sqrt(d11 / d12);
                }
            } else if (this.f8779f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i10 = this.f8779f)) {
                double d13 = (double) i10;
                double d14 = (double) max;
                Double.isNaN(d13);
                Double.isNaN(d14);
                d10 = d13 / d14;
            }
            if (d10 <= 0.0d) {
                return bitmap;
            }
            double width2 = (double) bitmap.getWidth();
            Double.isNaN(width2);
            int ceil = (int) Math.ceil(width2 * d10);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d10), false);
        }
    }

    public interface c {
        boolean a(int i10, float[] fArr);
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f8782a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8783b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8784c;

        /* renamed from: d  reason: collision with root package name */
        public final int f8785d;

        /* renamed from: e  reason: collision with root package name */
        public final int f8786e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8787f;

        /* renamed from: g  reason: collision with root package name */
        public int f8788g;

        /* renamed from: h  reason: collision with root package name */
        public int f8789h;

        /* renamed from: i  reason: collision with root package name */
        public float[] f8790i;

        public d(int i10, int i11) {
            this.f8782a = Color.red(i10);
            this.f8783b = Color.green(i10);
            this.f8784c = Color.blue(i10);
            this.f8785d = i10;
            this.f8786e = i11;
        }

        public final void a() {
            int i10;
            int i11;
            if (!this.f8787f) {
                int e10 = r.a.e(-1, this.f8785d, 4.5f);
                int e11 = r.a.e(-1, this.f8785d, 3.0f);
                if (e10 == -1 || e11 == -1) {
                    int e12 = r.a.e(RoundedDrawable.DEFAULT_BORDER_COLOR, this.f8785d, 4.5f);
                    int e13 = r.a.e(RoundedDrawable.DEFAULT_BORDER_COLOR, this.f8785d, 3.0f);
                    if (e12 == -1 || e13 == -1) {
                        if (e10 != -1) {
                            i10 = r.a.m(-1, e10);
                        } else {
                            i10 = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e12);
                        }
                        this.f8789h = i10;
                        if (e11 != -1) {
                            i11 = r.a.m(-1, e11);
                        } else {
                            i11 = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e13);
                        }
                        this.f8788g = i11;
                        this.f8787f = true;
                        return;
                    }
                    this.f8789h = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e12);
                    this.f8788g = r.a.m(RoundedDrawable.DEFAULT_BORDER_COLOR, e13);
                    this.f8787f = true;
                    return;
                }
                this.f8789h = r.a.m(-1, e10);
                this.f8788g = r.a.m(-1, e11);
                this.f8787f = true;
            }
        }

        public int b() {
            a();
            return this.f8789h;
        }

        public float[] c() {
            if (this.f8790i == null) {
                this.f8790i = new float[3];
            }
            r.a.a(this.f8782a, this.f8783b, this.f8784c, this.f8790i);
            return this.f8790i;
        }

        public int d() {
            return this.f8786e;
        }

        public int e() {
            return this.f8785d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f8786e == dVar.f8786e && this.f8785d == dVar.f8785d) {
                return true;
            }
            return false;
        }

        public int f() {
            a();
            return this.f8788g;
        }

        public int hashCode() {
            return (this.f8785d * 31) + this.f8786e;
        }

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + ']' + " [HSL: " + Arrays.toString(c()) + ']' + " [Population: " + this.f8786e + ']' + " [Title Text: #" + Integer.toHexString(f()) + ']' + " [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    public b(List list, List list2) {
        this.f8769a = list;
        this.f8770b = list2;
    }

    public final d a() {
        int size = this.f8769a.size();
        int i10 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar2 = (d) this.f8769a.get(i11);
            if (dVar2.d() > i10) {
                i10 = dVar2.d();
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public void b() {
        int size = this.f8770b.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) this.f8770b.get(i10);
            cVar.k();
            this.f8771c.put(cVar, d(cVar));
        }
        this.f8772d.clear();
    }

    public final float c(d dVar, c cVar) {
        int i10;
        float f10;
        float f11;
        float[] c10 = dVar.c();
        d dVar2 = this.f8773e;
        if (dVar2 != null) {
            i10 = dVar2.d();
        } else {
            i10 = 1;
        }
        float f12 = 0.0f;
        if (cVar.g() > 0.0f) {
            f10 = cVar.g() * (1.0f - Math.abs(c10[1] - cVar.i()));
        } else {
            f10 = 0.0f;
        }
        if (cVar.a() > 0.0f) {
            f11 = cVar.a() * (1.0f - Math.abs(c10[2] - cVar.h()));
        } else {
            f11 = 0.0f;
        }
        if (cVar.f() > 0.0f) {
            f12 = cVar.f() * (((float) dVar.d()) / ((float) i10));
        }
        return f10 + f11 + f12;
    }

    public final d d(c cVar) {
        d e10 = e(cVar);
        if (e10 != null && cVar.j()) {
            this.f8772d.append(e10.e(), true);
        }
        return e10;
    }

    public final d e(c cVar) {
        int size = this.f8769a.size();
        float f10 = 0.0f;
        d dVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar2 = (d) this.f8769a.get(i10);
            if (g(dVar2, cVar)) {
                float c10 = c(dVar2, cVar);
                if (dVar == null || c10 > f10) {
                    dVar = dVar2;
                    f10 = c10;
                }
            }
        }
        return dVar;
    }

    public List f() {
        return Collections.unmodifiableList(this.f8769a);
    }

    public final boolean g(d dVar, c cVar) {
        float[] c10 = dVar.c();
        if (c10[1] < cVar.e() || c10[1] > cVar.c() || c10[2] < cVar.d() || c10[2] > cVar.b() || this.f8772d.get(dVar.e())) {
            return false;
        }
        return true;
    }
}
