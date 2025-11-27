package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import c0.g0;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {

    /* renamed from: a  reason: collision with root package name */
    public int f2816a = -1;

    /* renamed from: b  reason: collision with root package name */
    public f[] f2817b;

    /* renamed from: c  reason: collision with root package name */
    public m f2818c;

    /* renamed from: d  reason: collision with root package name */
    public m f2819d;

    /* renamed from: e  reason: collision with root package name */
    public int f2820e;

    /* renamed from: f  reason: collision with root package name */
    public int f2821f;

    /* renamed from: g  reason: collision with root package name */
    public final i f2822g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2823h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2824i = false;

    /* renamed from: j  reason: collision with root package name */
    public BitSet f2825j;

    /* renamed from: k  reason: collision with root package name */
    public int f2826k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f2827l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    public d f2828m = new d();

    /* renamed from: n  reason: collision with root package name */
    public int f2829n = 2;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2830o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2831p;

    /* renamed from: q  reason: collision with root package name */
    public e f2832q;

    /* renamed from: r  reason: collision with root package name */
    public int f2833r;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f2834s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public final b f2835t = new b();

    /* renamed from: u  reason: collision with root package name */
    public boolean f2836u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2837v = true;

    /* renamed from: w  reason: collision with root package name */
    public int[] f2838w;

    /* renamed from: x  reason: collision with root package name */
    public final Runnable f2839x = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.m();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2841a;

        /* renamed from: b  reason: collision with root package name */
        public int f2842b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2843c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2844d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2845e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2846f;

        public b() {
            c();
        }

        public void a() {
            int i10;
            if (this.f2843c) {
                i10 = StaggeredGridLayoutManager.this.f2818c.i();
            } else {
                i10 = StaggeredGridLayoutManager.this.f2818c.m();
            }
            this.f2842b = i10;
        }

        public void b(int i10) {
            if (this.f2843c) {
                this.f2842b = StaggeredGridLayoutManager.this.f2818c.i() - i10;
            } else {
                this.f2842b = StaggeredGridLayoutManager.this.f2818c.m() + i10;
            }
        }

        public void c() {
            this.f2841a = -1;
            this.f2842b = Integer.MIN_VALUE;
            this.f2843c = false;
            this.f2844d = false;
            this.f2845e = false;
            int[] iArr = this.f2846f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f2846f;
            if (iArr == null || iArr.length < length) {
                this.f2846f = new int[StaggeredGridLayoutManager.this.f2817b.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f2846f[i10] = fVarArr[i10].r(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public f f2848e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2849f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f2848e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f2870e;
        }

        public boolean f() {
            return this.f2849f;
        }

        public void g(boolean z10) {
            this.f2849f = z10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2856a;

        /* renamed from: b  reason: collision with root package name */
        public int f2857b;

        /* renamed from: c  reason: collision with root package name */
        public int f2858c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f2859d;

        /* renamed from: e  reason: collision with root package name */
        public int f2860e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2861f;

        /* renamed from: g  reason: collision with root package name */
        public List f2862g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2863h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2864i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f2865j;

        public static class a implements Parcelable.Creator {
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* renamed from: b */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e() {
        }

        public void a() {
            this.f2859d = null;
            this.f2858c = 0;
            this.f2856a = -1;
            this.f2857b = -1;
        }

        public void b() {
            this.f2859d = null;
            this.f2858c = 0;
            this.f2860e = 0;
            this.f2861f = null;
            this.f2862g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2856a);
            parcel.writeInt(this.f2857b);
            parcel.writeInt(this.f2858c);
            if (this.f2858c > 0) {
                parcel.writeIntArray(this.f2859d);
            }
            parcel.writeInt(this.f2860e);
            if (this.f2860e > 0) {
                parcel.writeIntArray(this.f2861f);
            }
            parcel.writeInt(this.f2863h ? 1 : 0);
            parcel.writeInt(this.f2864i ? 1 : 0);
            parcel.writeInt(this.f2865j ? 1 : 0);
            parcel.writeList(this.f2862g);
        }

        public e(Parcel parcel) {
            this.f2856a = parcel.readInt();
            this.f2857b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2858c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2859d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2860e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2861f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z10 = false;
            this.f2863h = parcel.readInt() == 1;
            this.f2864i = parcel.readInt() == 1;
            this.f2865j = parcel.readInt() == 1 ? true : z10;
            this.f2862g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f2858c = eVar.f2858c;
            this.f2856a = eVar.f2856a;
            this.f2857b = eVar.f2857b;
            this.f2859d = eVar.f2859d;
            this.f2860e = eVar.f2860e;
            this.f2861f = eVar.f2861f;
            this.f2863h = eVar.f2863h;
            this.f2864i = eVar.f2864i;
            this.f2865j = eVar.f2865j;
            this.f2862g = eVar.f2862g;
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList f2866a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public int f2867b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public int f2868c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f2869d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f2870e;

        public f(int i10) {
            this.f2870e = i10;
        }

        public void a(View view) {
            c p10 = p(view);
            p10.f2848e = this;
            this.f2866a.add(view);
            this.f2868c = Integer.MIN_VALUE;
            if (this.f2866a.size() == 1) {
                this.f2867b = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f2869d += StaggeredGridLayoutManager.this.f2818c.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int i11;
            if (z10) {
                i11 = n(Integer.MIN_VALUE);
            } else {
                i11 = r(Integer.MIN_VALUE);
            }
            e();
            if (i11 != Integer.MIN_VALUE) {
                if (z10 && i11 < StaggeredGridLayoutManager.this.f2818c.i()) {
                    return;
                }
                if (z10 || i11 <= StaggeredGridLayoutManager.this.f2818c.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        i11 += i10;
                    }
                    this.f2868c = i11;
                    this.f2867b = i11;
                }
            }
        }

        public void c() {
            d.a f10;
            ArrayList arrayList = this.f2866a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c p10 = p(view);
            this.f2868c = StaggeredGridLayoutManager.this.f2818c.d(view);
            if (p10.f2849f && (f10 = StaggeredGridLayoutManager.this.f2828m.f(p10.a())) != null && f10.f2853b == 1) {
                this.f2868c += f10.a(this.f2870e);
            }
        }

        public void d() {
            d.a f10;
            View view = (View) this.f2866a.get(0);
            c p10 = p(view);
            this.f2867b = StaggeredGridLayoutManager.this.f2818c.g(view);
            if (p10.f2849f && (f10 = StaggeredGridLayoutManager.this.f2828m.f(p10.a())) != null && f10.f2853b == -1) {
                this.f2867b -= f10.a(this.f2870e);
            }
        }

        public void e() {
            this.f2866a.clear();
            s();
            this.f2869d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f2823h) {
                return j(this.f2866a.size() - 1, -1, true);
            }
            return j(0, this.f2866a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f2823h) {
                return k(0, this.f2866a.size(), true);
            }
            return k(this.f2866a.size() - 1, -1, true);
        }

        public int h() {
            if (StaggeredGridLayoutManager.this.f2823h) {
                return j(0, this.f2866a.size(), true);
            }
            return j(this.f2866a.size() - 1, -1, true);
        }

        public int i(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int i12;
            boolean z13;
            int m10 = StaggeredGridLayoutManager.this.f2818c.m();
            int i13 = StaggeredGridLayoutManager.this.f2818c.i();
            if (i11 > i10) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            while (i10 != i11) {
                View view = (View) this.f2866a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f2818c.g(view);
                int d10 = StaggeredGridLayoutManager.this.f2818c.d(view);
                boolean z14 = false;
                if (!z12 ? g10 >= i13 : g10 > i13) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z14 = true;
                }
                if (z13 && z14) {
                    if (!z10 || !z11) {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g10 < m10 || d10 > i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (g10 >= m10 && d10 <= i13) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        public int j(int i10, int i11, boolean z10) {
            return i(i10, i11, false, false, z10);
        }

        public int k(int i10, int i11, boolean z10) {
            return i(i10, i11, z10, true, false);
        }

        public int l() {
            return this.f2869d;
        }

        public int m() {
            int i10 = this.f2868c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f2868c;
        }

        public int n(int i10) {
            int i11 = this.f2868c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f2866a.size() == 0) {
                return i10;
            }
            c();
            return this.f2868c;
        }

        public View o(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f2866a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f2866a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f2823h && staggeredGridLayoutManager.getPosition(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f2823h && staggeredGridLayoutManager2.getPosition(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2866a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = (View) this.f2866a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f2823h && staggeredGridLayoutManager3.getPosition(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f2823h && staggeredGridLayoutManager4.getPosition(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        public c p(View view) {
            return (c) view.getLayoutParams();
        }

        public int q() {
            int i10 = this.f2867b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f2867b;
        }

        public int r(int i10) {
            int i11 = this.f2867b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f2866a.size() == 0) {
                return i10;
            }
            d();
            return this.f2867b;
        }

        public void s() {
            this.f2867b = Integer.MIN_VALUE;
            this.f2868c = Integer.MIN_VALUE;
        }

        public void t(int i10) {
            int i11 = this.f2867b;
            if (i11 != Integer.MIN_VALUE) {
                this.f2867b = i11 + i10;
            }
            int i12 = this.f2868c;
            if (i12 != Integer.MIN_VALUE) {
                this.f2868c = i12 + i10;
            }
        }

        public void u() {
            int size = this.f2866a.size();
            View view = (View) this.f2866a.remove(size - 1);
            c p10 = p(view);
            p10.f2848e = null;
            if (p10.c() || p10.b()) {
                this.f2869d -= StaggeredGridLayoutManager.this.f2818c.e(view);
            }
            if (size == 1) {
                this.f2867b = Integer.MIN_VALUE;
            }
            this.f2868c = Integer.MIN_VALUE;
        }

        public void v() {
            View view = (View) this.f2866a.remove(0);
            c p10 = p(view);
            p10.f2848e = null;
            if (this.f2866a.size() == 0) {
                this.f2868c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f2869d -= StaggeredGridLayoutManager.this.f2818c.e(view);
            }
            this.f2867b = Integer.MIN_VALUE;
        }

        public void w(View view) {
            c p10 = p(view);
            p10.f2848e = this;
            this.f2866a.add(0, view);
            this.f2867b = Integer.MIN_VALUE;
            if (this.f2866a.size() == 1) {
                this.f2868c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f2869d += StaggeredGridLayoutManager.this.f2818c.e(view);
            }
        }

        public void x(int i10) {
            this.f2867b = i10;
            this.f2868c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f2785a);
        setSpanCount(properties.f2786b);
        setReverseLayout(properties.f2787c);
        this.f2822g = new i();
        t();
    }

    public final int A(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public final void B(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10;
        int F = F(Integer.MIN_VALUE);
        if (F != Integer.MIN_VALUE && (i10 = this.f2818c.i() - F) > 0) {
            int i11 = i10 - (-scrollBy(-i10, vVar, a0Var));
            if (z10 && i11 > 0) {
                this.f2818c.r(i11);
            }
        }
    }

    public final void C(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int I = I(Integer.MAX_VALUE);
        if (I != Integer.MAX_VALUE && (m10 = I - this.f2818c.m()) > 0) {
            int scrollBy = m10 - scrollBy(m10, vVar, a0Var);
            if (z10 && scrollBy > 0) {
                this.f2818c.r(-scrollBy);
            }
        }
    }

    public int D() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int E() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int F(int i10) {
        int n10 = this.f2817b[0].n(i10);
        for (int i11 = 1; i11 < this.f2816a; i11++) {
            int n11 = this.f2817b[i11].n(i10);
            if (n11 > n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    public final int G(int i10) {
        int r10 = this.f2817b[0].r(i10);
        for (int i11 = 1; i11 < this.f2816a; i11++) {
            int r11 = this.f2817b[i11].r(i10);
            if (r11 > r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    public final int H(int i10) {
        int n10 = this.f2817b[0].n(i10);
        for (int i11 = 1; i11 < this.f2816a; i11++) {
            int n11 = this.f2817b[i11].n(i10);
            if (n11 < n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    public final int I(int i10) {
        int r10 = this.f2817b[0].r(i10);
        for (int i11 = 1; i11 < this.f2816a; i11++) {
            int r11 = this.f2817b[i11].r(i10);
            if (r11 < r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    public final f J(i iVar) {
        int i10;
        int i11;
        int i12;
        if (Q(iVar.f2991e)) {
            i12 = this.f2816a - 1;
            i11 = -1;
            i10 = -1;
        } else {
            i11 = this.f2816a;
            i12 = 0;
            i10 = 1;
        }
        f fVar = null;
        if (iVar.f2991e == 1) {
            int m10 = this.f2818c.m();
            int i13 = Integer.MAX_VALUE;
            while (i12 != i11) {
                f fVar2 = this.f2817b[i12];
                int n10 = fVar2.n(m10);
                if (n10 < i13) {
                    fVar = fVar2;
                    i13 = n10;
                }
                i12 += i10;
            }
            return fVar;
        }
        int i14 = this.f2818c.i();
        int i15 = Integer.MIN_VALUE;
        while (i12 != i11) {
            f fVar3 = this.f2817b[i12];
            int r10 = fVar3.r(i14);
            if (r10 > i15) {
                fVar = fVar3;
                i15 = r10;
            }
            i12 += i10;
        }
        return fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2824i
            if (r0 == 0) goto L_0x0009
            int r0 = r6.E()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.D()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f2828m
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f2828m
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f2828m
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f2828m
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f2828m
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f2824i
            if (r7 == 0) goto L_0x004d
            int r7 = r6.D()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.E()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.K(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View L() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f2816a
            r2.<init>(r3)
            int r3 = r12.f2816a
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f2820e
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f2824i
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2848e
            int r9 = r9.f2870e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2848e
            boolean r9 = r12.n(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2848e
            int r9 = r9.f2870e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f2849f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f2824i
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.m r10 = r12.f2818c
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.m r11 = r12.f2818c
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.m r10 = r12.f2818c
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.m r11 = r12.f2818c
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f2848e
            int r8 = r8.f2870e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f2848e
            int r9 = r9.f2870e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.L():android.view.View");
    }

    public void M() {
        this.f2828m.b();
        requestLayout();
    }

    public final void N(View view, int i10, int i11, boolean z10) {
        boolean z11;
        calculateItemDecorationsForChild(view, this.f2834s);
        c cVar = (c) view.getLayoutParams();
        int i12 = cVar.leftMargin;
        Rect rect = this.f2834s;
        int g02 = g0(i10, i12 + rect.left, cVar.rightMargin + rect.right);
        int i13 = cVar.topMargin;
        Rect rect2 = this.f2834s;
        int g03 = g0(i11, i13 + rect2.top, cVar.bottomMargin + rect2.bottom);
        if (z10) {
            z11 = shouldReMeasureChild(view, g02, g03, cVar);
        } else {
            z11 = shouldMeasureChild(view, g02, g03, cVar);
        }
        if (z11) {
            view.measure(g02, g03);
        }
    }

    public final void O(View view, c cVar, boolean z10) {
        if (cVar.f2849f) {
            if (this.f2820e == 1) {
                N(view, this.f2833r, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), cVar.height, true), z10);
            } else {
                N(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), cVar.width, true), this.f2833r, z10);
            }
        } else if (this.f2820e == 1) {
            N(view, RecyclerView.o.getChildMeasureSpec(this.f2821f, getWidthMode(), 0, cVar.width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), cVar.height, true), z10);
        } else {
            N(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), cVar.width, true), RecyclerView.o.getChildMeasureSpec(this.f2821f, getHeightMode(), 0, cVar.height, false), z10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (m() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.f2835t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r1 = r8.f2832q
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f2826k
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f2845e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f2826k
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r1 = r8.f2832q
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r5 = r8.f2832q
            if (r5 == 0) goto L_0x0037
            r8.h(r0)
            goto L_0x003e
        L_0x0037:
            r8.X()
            boolean r5 = r8.f2824i
            r0.f2843c = r5
        L_0x003e:
            r8.c0(r10, r0)
            r0.f2845e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r5 = r8.f2832q
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f2826k
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f2843c
            boolean r6 = r8.f2830o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.f2831p
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.f2828m
            r5.b()
            r0.f2844d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r5 = r8.f2832q
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f2858c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f2844d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.f2816a
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r5 = r8.f2817b
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f2842b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r6 = r8.f2817b
            r6 = r6[r1]
            r6.x(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f2835t
            int[] r1 = r1.f2846f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.f2816a
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r5 = r8.f2817b
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.f2835t
            int[] r6 = r6.f2846f
            r6 = r6[r1]
            r5.x(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.f2816a
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r5 = r8.f2817b
            r5 = r5[r1]
            boolean r6 = r8.f2824i
            int r7 = r0.f2842b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f2835t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r5 = r8.f2817b
            r1.d(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.i r1 = r8.f2822g
            r1.f2987a = r3
            r8.f2836u = r3
            androidx.recyclerview.widget.m r1 = r8.f2819d
            int r1 = r1.n()
            r8.e0(r1)
            int r1 = r0.f2841a
            r8.d0(r1, r10)
            boolean r1 = r0.f2843c
            if (r1 == 0) goto L_0x00fc
            r8.Y(r2)
            androidx.recyclerview.widget.i r1 = r8.f2822g
            r8.u(r9, r1, r10)
            r8.Y(r4)
            androidx.recyclerview.widget.i r1 = r8.f2822g
            int r2 = r0.f2841a
            int r5 = r1.f2990d
            int r2 = r2 + r5
            r1.f2989c = r2
            r8.u(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.Y(r4)
            androidx.recyclerview.widget.i r1 = r8.f2822g
            r8.u(r9, r1, r10)
            r8.Y(r2)
            androidx.recyclerview.widget.i r1 = r8.f2822g
            int r2 = r0.f2841a
            int r5 = r1.f2990d
            int r2 = r2 + r5
            r1.f2989c = r2
            r8.u(r9, r1, r10)
        L_0x0113:
            r8.W()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.f2824i
            if (r1 == 0) goto L_0x0127
            r8.B(r9, r10, r4)
            r8.C(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.C(r9, r10, r4)
            r8.B(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.e()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.f2829n
            if (r11 == 0) goto L_0x014b
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.f2836u
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.L()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.f2839x
            r8.removeCallbacks(r11)
            boolean r11 = r8.m()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f2835t
            r11.c()
        L_0x0166:
            boolean r11 = r0.f2843c
            r8.f2830o = r11
            boolean r11 = r8.isLayoutRTL()
            r8.f2831p = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f2835t
            r11.c()
            r8.P(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    public final boolean Q(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f2820e == 0) {
            if (i10 == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 != this.f2824i) {
                return true;
            }
            return false;
        }
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 == this.f2824i) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public void R(int i10, RecyclerView.a0 a0Var) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = E();
            i11 = 1;
        } else {
            i12 = D();
            i11 = -1;
        }
        this.f2822g.f2987a = true;
        d0(i12, a0Var);
        Y(i11);
        i iVar = this.f2822g;
        iVar.f2989c = i12 + iVar.f2990d;
        iVar.f2988b = Math.abs(i10);
    }

    public final void S(View view) {
        for (int i10 = this.f2816a - 1; i10 >= 0; i10--) {
            this.f2817b[i10].w(view);
        }
    }

    public final void T(RecyclerView.v vVar, i iVar) {
        int i10;
        int i11;
        if (iVar.f2987a && !iVar.f2995i) {
            if (iVar.f2988b == 0) {
                if (iVar.f2991e == -1) {
                    U(vVar, iVar.f2993g);
                } else {
                    V(vVar, iVar.f2992f);
                }
            } else if (iVar.f2991e == -1) {
                int i12 = iVar.f2992f;
                int G = i12 - G(i12);
                if (G < 0) {
                    i11 = iVar.f2993g;
                } else {
                    i11 = iVar.f2993g - Math.min(G, iVar.f2988b);
                }
                U(vVar, i11);
            } else {
                int H = H(iVar.f2993g) - iVar.f2993g;
                if (H < 0) {
                    i10 = iVar.f2992f;
                } else {
                    i10 = Math.min(H, iVar.f2988b) + iVar.f2992f;
                }
                V(vVar, i10);
            }
        }
    }

    public final void U(RecyclerView.v vVar, int i10) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f2818c.g(childAt) >= i10 && this.f2818c.q(childAt) >= i10) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2849f) {
                    int i11 = 0;
                    while (i11 < this.f2816a) {
                        if (this.f2817b[i11].f2866a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f2816a; i12++) {
                        this.f2817b[i12].u();
                    }
                } else if (cVar.f2848e.f2866a.size() != 1) {
                    cVar.f2848e.u();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, vVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    public final void V(RecyclerView.v vVar, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f2818c.d(childAt) <= i10 && this.f2818c.p(childAt) <= i10) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f2849f) {
                    int i11 = 0;
                    while (i11 < this.f2816a) {
                        if (this.f2817b[i11].f2866a.size() != 1) {
                            i11++;
                        } else {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f2816a; i12++) {
                        this.f2817b[i12].v();
                    }
                } else if (cVar.f2848e.f2866a.size() != 1) {
                    cVar.f2848e.v();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, vVar);
            } else {
                return;
            }
        }
    }

    public final void W() {
        if (this.f2819d.k() != 1073741824) {
            int childCount = getChildCount();
            float f10 = 0.0f;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                float e10 = (float) this.f2819d.e(childAt);
                if (e10 >= f10) {
                    if (((c) childAt.getLayoutParams()).f()) {
                        e10 = (e10 * 1.0f) / ((float) this.f2816a);
                    }
                    f10 = Math.max(f10, e10);
                }
            }
            int i11 = this.f2821f;
            int round = Math.round(f10 * ((float) this.f2816a));
            if (this.f2819d.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2819d.n());
            }
            e0(round);
            if (this.f2821f != i11) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt2 = getChildAt(i12);
                    c cVar = (c) childAt2.getLayoutParams();
                    if (!cVar.f2849f) {
                        if (!isLayoutRTL() || this.f2820e != 1) {
                            int i13 = cVar.f2848e.f2870e;
                            int i14 = this.f2821f * i13;
                            int i15 = i13 * i11;
                            if (this.f2820e == 1) {
                                childAt2.offsetLeftAndRight(i14 - i15);
                            } else {
                                childAt2.offsetTopAndBottom(i14 - i15);
                            }
                        } else {
                            int i16 = this.f2816a;
                            int i17 = cVar.f2848e.f2870e;
                            childAt2.offsetLeftAndRight(((-((i16 - 1) - i17)) * this.f2821f) - ((-((i16 - 1) - i17)) * i11));
                        }
                    }
                }
            }
        }
    }

    public final void X() {
        if (this.f2820e == 1 || !isLayoutRTL()) {
            this.f2824i = this.f2823h;
        } else {
            this.f2824i = !this.f2823h;
        }
    }

    public final void Y(int i10) {
        boolean z10;
        i iVar = this.f2822g;
        iVar.f2991e = i10;
        boolean z11 = this.f2824i;
        int i11 = 1;
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z11 != z10) {
            i11 = -1;
        }
        iVar.f2990d = i11;
    }

    public final void Z(int i10, int i11) {
        for (int i12 = 0; i12 < this.f2816a; i12++) {
            if (!this.f2817b[i12].f2866a.isEmpty()) {
                f0(this.f2817b[i12], i10, i11);
            }
        }
    }

    public final boolean a0(RecyclerView.a0 a0Var, b bVar) {
        int i10;
        if (this.f2830o) {
            i10 = A(a0Var.b());
        } else {
            i10 = v(a0Var.b());
        }
        bVar.f2841a = i10;
        bVar.f2842b = Integer.MIN_VALUE;
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f2832q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean b0(RecyclerView.a0 a0Var, b bVar) {
        int i10;
        int i11;
        int i12;
        boolean z10 = false;
        if (!a0Var.e() && (i10 = this.f2826k) != -1) {
            if (i10 < 0 || i10 >= a0Var.b()) {
                this.f2826k = -1;
                this.f2827l = Integer.MIN_VALUE;
            } else {
                e eVar = this.f2832q;
                if (eVar == null || eVar.f2856a == -1 || eVar.f2858c < 1) {
                    View findViewByPosition = findViewByPosition(this.f2826k);
                    if (findViewByPosition != null) {
                        if (this.f2824i) {
                            i11 = E();
                        } else {
                            i11 = D();
                        }
                        bVar.f2841a = i11;
                        if (this.f2827l != Integer.MIN_VALUE) {
                            if (bVar.f2843c) {
                                bVar.f2842b = (this.f2818c.i() - this.f2827l) - this.f2818c.d(findViewByPosition);
                            } else {
                                bVar.f2842b = (this.f2818c.m() + this.f2827l) - this.f2818c.g(findViewByPosition);
                            }
                            return true;
                        } else if (this.f2818c.e(findViewByPosition) > this.f2818c.n()) {
                            if (bVar.f2843c) {
                                i12 = this.f2818c.i();
                            } else {
                                i12 = this.f2818c.m();
                            }
                            bVar.f2842b = i12;
                            return true;
                        } else {
                            int g10 = this.f2818c.g(findViewByPosition) - this.f2818c.m();
                            if (g10 < 0) {
                                bVar.f2842b = -g10;
                                return true;
                            }
                            int i13 = this.f2818c.i() - this.f2818c.d(findViewByPosition);
                            if (i13 < 0) {
                                bVar.f2842b = i13;
                                return true;
                            }
                            bVar.f2842b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i14 = this.f2826k;
                        bVar.f2841a = i14;
                        int i15 = this.f2827l;
                        if (i15 == Integer.MIN_VALUE) {
                            if (l(i14) == 1) {
                                z10 = true;
                            }
                            bVar.f2843c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i15);
                        }
                        bVar.f2844d = true;
                    }
                } else {
                    bVar.f2842b = Integer.MIN_VALUE;
                    bVar.f2841a = this.f2826k;
                }
                return true;
            }
        }
        return false;
    }

    public void c0(RecyclerView.a0 a0Var, b bVar) {
        if (!b0(a0Var, bVar) && !a0(a0Var, bVar)) {
            bVar.a();
            bVar.f2841a = 0;
        }
    }

    public boolean canScrollHorizontally() {
        if (this.f2820e == 0) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.f2820e == 1) {
            return true;
        }
        return false;
    }

    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int i12;
        int i13;
        if (this.f2820e != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            R(i10, a0Var);
            int[] iArr = this.f2838w;
            if (iArr == null || iArr.length < this.f2816a) {
                this.f2838w = new int[this.f2816a];
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f2816a; i15++) {
                i iVar = this.f2822g;
                if (iVar.f2990d == -1) {
                    i13 = iVar.f2992f;
                    i12 = this.f2817b[i15].r(i13);
                } else {
                    i13 = this.f2817b[i15].n(iVar.f2993g);
                    i12 = this.f2822g.f2993g;
                }
                int i16 = i13 - i12;
                if (i16 >= 0) {
                    this.f2838w[i14] = i16;
                    i14++;
                }
            }
            Arrays.sort(this.f2838w, 0, i14);
            for (int i17 = 0; i17 < i14 && this.f2822g.a(a0Var); i17++) {
                cVar.a(this.f2822g.f2989c, this.f2838w[i17]);
                i iVar2 = this.f2822g;
                iVar2.f2989c += iVar2.f2990d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        return o(a0Var);
    }

    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return p(a0Var);
    }

    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return q(a0Var);
    }

    public PointF computeScrollVectorForPosition(int i10) {
        int l10 = l(i10);
        PointF pointF = new PointF();
        if (l10 == 0) {
            return null;
        }
        if (this.f2820e == 0) {
            pointF.x = (float) l10;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) l10;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        return o(a0Var);
    }

    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return p(a0Var);
    }

    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return q(a0Var);
    }

    public final int convertFocusDirectionToLayoutDirection(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 == 130 && this.f2820e == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.f2820e == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.f2820e == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.f2820e == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f2820e != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.f2820e != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d0(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.i r0 = r4.f2822g
            r1 = 0
            r0.f2988b = r1
            r0.f2989c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f2824i
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.m r5 = r4.f2818c
            int r5 = r5.n()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.m r5 = r4.f2818c
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.i r0 = r4.f2822g
            androidx.recyclerview.widget.m r3 = r4.f2818c
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f2992f = r3
            androidx.recyclerview.widget.i r6 = r4.f2822g
            androidx.recyclerview.widget.m r0 = r4.f2818c
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f2993g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.i r0 = r4.f2822g
            androidx.recyclerview.widget.m r3 = r4.f2818c
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f2993g = r3
            androidx.recyclerview.widget.i r5 = r4.f2822g
            int r6 = -r6
            r5.f2992f = r6
        L_0x005d:
            androidx.recyclerview.widget.i r5 = r4.f2822g
            r5.f2994h = r1
            r5.f2987a = r2
            androidx.recyclerview.widget.m r6 = r4.f2818c
            int r6 = r6.k()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.m r6 = r4.f2818c
            int r6 = r6.h()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.f2995i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d0(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    public void e0(int i10) {
        this.f2821f = i10 / this.f2816a;
        this.f2833r = View.MeasureSpec.makeMeasureSpec(i10, this.f2819d.k());
    }

    public final void f0(f fVar, int i10, int i11) {
        int l10 = fVar.l();
        if (i10 == -1) {
            if (fVar.q() + l10 <= i11) {
                this.f2825j.set(fVar.f2870e, false);
            }
        } else if (fVar.m() - l10 >= i11) {
            this.f2825j.set(fVar.f2870e, false);
        }
    }

    public final void g(View view) {
        for (int i10 = this.f2816a - 1; i10 >= 0; i10--) {
            this.f2817b[i10].a(view);
        }
    }

    public final int g0(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode);
        }
        return i10;
    }

    public RecyclerView.p generateDefaultLayoutParams() {
        if (this.f2820e == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f2820e == 1) {
            return this.f2816a;
        }
        return super.getColumnCountForAccessibility(vVar, a0Var);
    }

    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f2820e == 0) {
            return this.f2816a;
        }
        return super.getRowCountForAccessibility(vVar, a0Var);
    }

    public int getSpanCount() {
        return this.f2816a;
    }

    public final void h(b bVar) {
        int i10;
        e eVar = this.f2832q;
        int i11 = eVar.f2858c;
        if (i11 > 0) {
            if (i11 == this.f2816a) {
                for (int i12 = 0; i12 < this.f2816a; i12++) {
                    this.f2817b[i12].e();
                    e eVar2 = this.f2832q;
                    int i13 = eVar2.f2859d[i12];
                    if (i13 != Integer.MIN_VALUE) {
                        if (eVar2.f2864i) {
                            i10 = this.f2818c.i();
                        } else {
                            i10 = this.f2818c.m();
                        }
                        i13 += i10;
                    }
                    this.f2817b[i12].x(i13);
                }
            } else {
                eVar.b();
                e eVar3 = this.f2832q;
                eVar3.f2856a = eVar3.f2857b;
            }
        }
        e eVar4 = this.f2832q;
        this.f2831p = eVar4.f2865j;
        setReverseLayout(eVar4.f2863h);
        X();
        e eVar5 = this.f2832q;
        int i14 = eVar5.f2856a;
        if (i14 != -1) {
            this.f2826k = i14;
            bVar.f2843c = eVar5.f2864i;
        } else {
            bVar.f2843c = this.f2824i;
        }
        if (eVar5.f2860e > 1) {
            d dVar = this.f2828m;
            dVar.f2850a = eVar5.f2861f;
            dVar.f2851b = eVar5.f2862g;
        }
    }

    public boolean i() {
        int n10 = this.f2817b[0].n(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f2816a; i10++) {
            if (this.f2817b[i10].n(Integer.MIN_VALUE) != n10) {
                return false;
            }
        }
        return true;
    }

    public boolean isAutoMeasureEnabled() {
        if (this.f2829n != 0) {
            return true;
        }
        return false;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean j() {
        int r10 = this.f2817b[0].r(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f2816a; i10++) {
            if (this.f2817b[i10].r(Integer.MIN_VALUE) != r10) {
                return false;
            }
        }
        return true;
    }

    public final void k(View view, c cVar, i iVar) {
        if (iVar.f2991e == 1) {
            if (cVar.f2849f) {
                g(view);
            } else {
                cVar.f2848e.a(view);
            }
        } else if (cVar.f2849f) {
            S(view);
        } else {
            cVar.f2848e.w(view);
        }
    }

    public final int l(int i10) {
        boolean z10;
        if (getChildCount() != 0) {
            if (i10 < D()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 != this.f2824i) {
                return -1;
            }
            return 1;
        } else if (this.f2824i) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean m() {
        int i10;
        int i11;
        int i12;
        if (getChildCount() == 0 || this.f2829n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f2824i) {
            i11 = E();
            i10 = D();
        } else {
            i11 = D();
            i10 = E();
        }
        if (i11 == 0 && L() != null) {
            this.f2828m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f2836u) {
            return false;
        } else {
            if (this.f2824i) {
                i12 = -1;
            } else {
                i12 = 1;
            }
            int i13 = i10 + 1;
            d.a e10 = this.f2828m.e(i11, i13, i12, true);
            if (e10 == null) {
                this.f2836u = false;
                this.f2828m.d(i13);
                return false;
            }
            d.a e11 = this.f2828m.e(i11, e10.f2852a, i12 * -1, true);
            if (e11 == null) {
                this.f2828m.d(e10.f2852a);
            } else {
                this.f2828m.d(e11.f2852a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public final boolean n(f fVar) {
        if (this.f2824i) {
            if (fVar.m() < this.f2818c.i()) {
                ArrayList arrayList = fVar.f2866a;
                return !fVar.p((View) arrayList.get(arrayList.size() - 1)).f2849f;
            }
        } else if (fVar.q() > this.f2818c.m()) {
            return !fVar.p((View) fVar.f2866a.get(0)).f2849f;
        }
        return false;
    }

    public final int o(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.a(a0Var, this.f2818c, x(!this.f2837v), w(!this.f2837v), this, this.f2837v);
    }

    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.f2816a; i11++) {
            this.f2817b[i11].t(i10);
        }
    }

    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.f2816a; i11++) {
            this.f2817b[i11].t(i10);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        removeCallbacks(this.f2839x);
        for (int i10 = 0; i10 < this.f2816a; i10++) {
            this.f2817b[i10].e();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View findContainingItemView;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        View o10;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        X();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) findContainingItemView.getLayoutParams();
        boolean z12 = cVar.f2849f;
        f fVar = cVar.f2848e;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i11 = E();
        } else {
            i11 = D();
        }
        d0(i11, a0Var);
        Y(convertFocusDirectionToLayoutDirection);
        i iVar = this.f2822g;
        iVar.f2989c = iVar.f2990d + i11;
        iVar.f2988b = (int) (((float) this.f2818c.n()) * 0.33333334f);
        i iVar2 = this.f2822g;
        iVar2.f2994h = true;
        iVar2.f2987a = false;
        u(vVar, iVar2, a0Var);
        this.f2830o = this.f2824i;
        if (!z12 && (o10 = fVar.o(i11, convertFocusDirectionToLayoutDirection)) != null && o10 != findContainingItemView) {
            return o10;
        }
        if (Q(convertFocusDirectionToLayoutDirection)) {
            for (int i15 = this.f2816a - 1; i15 >= 0; i15--) {
                View o11 = this.f2817b[i15].o(i11, convertFocusDirectionToLayoutDirection);
                if (o11 != null && o11 != findContainingItemView) {
                    return o11;
                }
            }
        } else {
            for (int i16 = 0; i16 < this.f2816a; i16++) {
                View o12 = this.f2817b[i16].o(i11, convertFocusDirectionToLayoutDirection);
                if (o12 != null && o12 != findContainingItemView) {
                    return o12;
                }
            }
        }
        boolean z13 = !this.f2823h;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z13 == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z12) {
            if (z11) {
                i14 = fVar.f();
            } else {
                i14 = fVar.h();
            }
            View findViewByPosition = findViewByPosition(i14);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (Q(convertFocusDirectionToLayoutDirection)) {
            for (int i17 = this.f2816a - 1; i17 >= 0; i17--) {
                if (i17 != fVar.f2870e) {
                    if (z11) {
                        i13 = this.f2817b[i17].f();
                    } else {
                        i13 = this.f2817b[i17].h();
                    }
                    View findViewByPosition2 = findViewByPosition(i13);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i18 = 0; i18 < this.f2816a; i18++) {
                if (z11) {
                    i12 = this.f2817b[i18].f();
                } else {
                    i12 = this.f2817b[i18].h();
                }
                View findViewByPosition3 = findViewByPosition(i12);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View x10 = x(false);
            View w10 = w(false);
            if (x10 != null && w10 != null) {
                int position = getPosition(x10);
                int position2 = getPosition(w10);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, g0 g0Var) {
        int i10;
        int i11;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, g0Var);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f2820e == 0) {
            int e10 = cVar.e();
            if (cVar.f2849f) {
                i11 = this.f2816a;
            } else {
                i11 = 1;
            }
            g0Var.Z(g0.c.a(e10, i11, -1, -1, false, false));
            return;
        }
        int e11 = cVar.e();
        if (cVar.f2849f) {
            i10 = this.f2816a;
        } else {
            i10 = 1;
        }
        g0Var.Z(g0.c.a(-1, -1, e11, i10, false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        K(i10, i11, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f2828m.b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        K(i10, i11, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        K(i10, i11, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        K(i10, i11, 4);
    }

    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        P(vVar, a0Var, true);
    }

    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.f2826k = -1;
        this.f2827l = Integer.MIN_VALUE;
        this.f2832q = null;
        this.f2835t.c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f2832q = (e) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i10;
        int i11;
        int i12;
        int[] iArr;
        if (this.f2832q != null) {
            return new e(this.f2832q);
        }
        e eVar = new e();
        eVar.f2863h = this.f2823h;
        eVar.f2864i = this.f2830o;
        eVar.f2865j = this.f2831p;
        d dVar = this.f2828m;
        if (dVar == null || (iArr = dVar.f2850a) == null) {
            eVar.f2860e = 0;
        } else {
            eVar.f2861f = iArr;
            eVar.f2860e = iArr.length;
            eVar.f2862g = dVar.f2851b;
        }
        if (getChildCount() > 0) {
            if (this.f2830o) {
                i10 = E();
            } else {
                i10 = D();
            }
            eVar.f2856a = i10;
            eVar.f2857b = y();
            int i13 = this.f2816a;
            eVar.f2858c = i13;
            eVar.f2859d = new int[i13];
            for (int i14 = 0; i14 < this.f2816a; i14++) {
                if (this.f2830o) {
                    i11 = this.f2817b[i14].n(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f2818c.i();
                    } else {
                        eVar.f2859d[i14] = i11;
                    }
                } else {
                    i11 = this.f2817b[i14].r(Integer.MIN_VALUE);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f2818c.m();
                    } else {
                        eVar.f2859d[i14] = i11;
                    }
                }
                i11 -= i12;
                eVar.f2859d[i14] = i11;
            }
        } else {
            eVar.f2856a = -1;
            eVar.f2857b = -1;
            eVar.f2858c = 0;
        }
        return eVar;
    }

    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            m();
        }
    }

    public final int p(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.b(a0Var, this.f2818c, x(!this.f2837v), w(!this.f2837v), this, this.f2837v, this.f2824i);
    }

    public final int q(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.c(a0Var, this.f2818c, x(!this.f2837v), w(!this.f2837v), this, this.f2837v);
    }

    public final d.a r(int i10) {
        d.a aVar = new d.a();
        aVar.f2854c = new int[this.f2816a];
        for (int i11 = 0; i11 < this.f2816a; i11++) {
            aVar.f2854c[i11] = i10 - this.f2817b[i11].n(i10);
        }
        return aVar;
    }

    public final d.a s(int i10) {
        d.a aVar = new d.a();
        aVar.f2854c = new int[this.f2816a];
        for (int i11 = 0; i11 < this.f2816a; i11++) {
            aVar.f2854c[i11] = this.f2817b[i11].r(i10) - i10;
        }
        return aVar;
    }

    public int scrollBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        R(i10, a0Var);
        int u10 = u(vVar, this.f2822g, a0Var);
        if (this.f2822g.f2988b >= u10) {
            if (i10 < 0) {
                i10 = -u10;
            } else {
                i10 = u10;
            }
        }
        this.f2818c.r(-i10);
        this.f2830o = this.f2824i;
        i iVar = this.f2822g;
        iVar.f2988b = 0;
        T(vVar, iVar);
        return i10;
    }

    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i10, vVar, a0Var);
    }

    public void scrollToPosition(int i10) {
        e eVar = this.f2832q;
        if (!(eVar == null || eVar.f2856a == i10)) {
            eVar.a();
        }
        this.f2826k = i10;
        this.f2827l = Integer.MIN_VALUE;
        requestLayout();
    }

    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i10, vVar, a0Var);
    }

    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f2820e == 1) {
            i13 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            i12 = RecyclerView.o.chooseSize(i10, (this.f2821f * this.f2816a) + paddingLeft, getMinimumWidth());
        } else {
            i12 = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            i13 = RecyclerView.o.chooseSize(i11, (this.f2821f * this.f2816a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i12, i13);
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i10 != this.f2820e) {
                this.f2820e = i10;
                m mVar = this.f2818c;
                this.f2818c = this.f2819d;
                this.f2819d = mVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        e eVar = this.f2832q;
        if (!(eVar == null || eVar.f2863h == z10)) {
            eVar.f2863h = z10;
        }
        this.f2823h = z10;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll((String) null);
        if (i10 != this.f2816a) {
            M();
            this.f2816a = i10;
            this.f2825j = new BitSet(this.f2816a);
            this.f2817b = new f[this.f2816a];
            for (int i11 = 0; i11 < this.f2816a; i11++) {
                this.f2817b[i11] = new f(i11);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i10);
        startSmoothScroll(jVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.f2832q == null) {
            return true;
        }
        return false;
    }

    public final void t() {
        this.f2818c = m.b(this, this.f2820e);
        this.f2819d = m.b(this, 1 - this.f2820e);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v5 */
    public final int u(RecyclerView.v vVar, i iVar, RecyclerView.a0 a0Var) {
        int i10;
        int i11;
        int i12;
        boolean z10;
        f fVar;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z11;
        int i19;
        int i20;
        int i21;
        RecyclerView.v vVar2 = vVar;
        i iVar2 = iVar;
        ? r92 = 0;
        this.f2825j.set(0, this.f2816a, true);
        if (!this.f2822g.f2995i) {
            if (iVar2.f2991e == 1) {
                i21 = iVar2.f2993g + iVar2.f2988b;
            } else {
                i21 = iVar2.f2992f - iVar2.f2988b;
            }
            i10 = i21;
        } else if (iVar2.f2991e == 1) {
            i10 = Integer.MAX_VALUE;
        } else {
            i10 = Integer.MIN_VALUE;
        }
        Z(iVar2.f2991e, i10);
        if (this.f2824i) {
            i11 = this.f2818c.i();
        } else {
            i11 = this.f2818c.m();
        }
        int i22 = i11;
        boolean z12 = false;
        while (iVar.a(a0Var) && (this.f2822g.f2995i || !this.f2825j.isEmpty())) {
            View b10 = iVar2.b(vVar2);
            c cVar = (c) b10.getLayoutParams();
            int a10 = cVar.a();
            int g10 = this.f2828m.g(a10);
            if (g10 == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (cVar.f2849f) {
                    fVar = this.f2817b[r92];
                } else {
                    fVar = J(iVar2);
                }
                this.f2828m.n(a10, fVar);
            } else {
                fVar = this.f2817b[g10];
            }
            f fVar2 = fVar;
            cVar.f2848e = fVar2;
            if (iVar2.f2991e == 1) {
                addView(b10);
            } else {
                addView(b10, r92);
            }
            O(b10, cVar, r92);
            if (iVar2.f2991e == 1) {
                if (cVar.f2849f) {
                    i20 = F(i22);
                } else {
                    i20 = fVar2.n(i22);
                }
                int e10 = this.f2818c.e(b10) + i20;
                if (z10 && cVar.f2849f) {
                    d.a r10 = r(i20);
                    r10.f2853b = -1;
                    r10.f2852a = a10;
                    this.f2828m.a(r10);
                }
                i13 = e10;
                i14 = i20;
            } else {
                if (cVar.f2849f) {
                    i19 = I(i22);
                } else {
                    i19 = fVar2.r(i22);
                }
                i14 = i19 - this.f2818c.e(b10);
                if (z10 && cVar.f2849f) {
                    d.a s10 = s(i19);
                    s10.f2853b = 1;
                    s10.f2852a = a10;
                    this.f2828m.a(s10);
                }
                i13 = i19;
            }
            if (cVar.f2849f && iVar2.f2990d == -1) {
                if (z10) {
                    this.f2836u = true;
                } else {
                    if (iVar2.f2991e == 1) {
                        z11 = i();
                    } else {
                        z11 = j();
                    }
                    if (!z11) {
                        d.a f10 = this.f2828m.f(a10);
                        if (f10 != null) {
                            f10.f2855d = true;
                        }
                        this.f2836u = true;
                    }
                }
            }
            k(b10, cVar, iVar2);
            if (!isLayoutRTL() || this.f2820e != 1) {
                if (cVar.f2849f) {
                    i17 = this.f2819d.m();
                } else {
                    i17 = (fVar2.f2870e * this.f2821f) + this.f2819d.m();
                }
                i16 = i17;
                i15 = this.f2819d.e(b10) + i17;
            } else {
                if (cVar.f2849f) {
                    i18 = this.f2819d.i();
                } else {
                    i18 = this.f2819d.i() - (((this.f2816a - 1) - fVar2.f2870e) * this.f2821f);
                }
                i15 = i18;
                i16 = i18 - this.f2819d.e(b10);
            }
            if (this.f2820e == 1) {
                layoutDecoratedWithMargins(b10, i16, i14, i15, i13);
            } else {
                layoutDecoratedWithMargins(b10, i14, i16, i13, i15);
            }
            if (cVar.f2849f) {
                Z(this.f2822g.f2991e, i10);
            } else {
                f0(fVar2, this.f2822g.f2991e, i10);
            }
            T(vVar2, this.f2822g);
            if (this.f2822g.f2994h && b10.hasFocusable()) {
                if (cVar.f2849f) {
                    this.f2825j.clear();
                } else {
                    this.f2825j.set(fVar2.f2870e, false);
                    z12 = true;
                    r92 = 0;
                }
            }
            z12 = true;
            r92 = 0;
        }
        if (!z12) {
            T(vVar2, this.f2822g);
        }
        if (this.f2822g.f2991e == -1) {
            i12 = this.f2818c.m() - I(this.f2818c.m());
        } else {
            i12 = F(this.f2818c.i()) - this.f2818c.i();
        }
        if (i12 > 0) {
            return Math.min(iVar2.f2988b, i12);
        }
        return 0;
    }

    public final int v(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public View w(boolean z10) {
        int m10 = this.f2818c.m();
        int i10 = this.f2818c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g10 = this.f2818c.g(childAt);
            int d10 = this.f2818c.d(childAt);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View x(boolean z10) {
        int m10 = this.f2818c.m();
        int i10 = this.f2818c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int g10 = this.f2818c.g(childAt);
            if (this.f2818c.d(childAt) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int y() {
        View view;
        if (this.f2824i) {
            view = w(true);
        } else {
            view = x(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int[] z(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f2816a];
        } else if (iArr.length < this.f2816a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f2816a + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f2816a; i10++) {
            iArr[i10] = this.f2817b[i10].g();
        }
        return iArr;
    }

    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int[] f2850a;

        /* renamed from: b  reason: collision with root package name */
        public List f2851b;

        public void a(a aVar) {
            if (this.f2851b == null) {
                this.f2851b = new ArrayList();
            }
            int size = this.f2851b.size();
            for (int i10 = 0; i10 < size; i10++) {
                a aVar2 = (a) this.f2851b.get(i10);
                if (aVar2.f2852a == aVar.f2852a) {
                    this.f2851b.remove(i10);
                }
                if (aVar2.f2852a >= aVar.f2852a) {
                    this.f2851b.add(i10, aVar);
                    return;
                }
            }
            this.f2851b.add(aVar);
        }

        public void b() {
            int[] iArr = this.f2850a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2851b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f2850a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i10, 10) + 1)];
                this.f2850a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f2850a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2850a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List list = this.f2851b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f2851b.get(size)).f2852a >= i10) {
                        this.f2851b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public a e(int i10, int i11, int i12, boolean z10) {
            List list = this.f2851b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                a aVar = (a) this.f2851b.get(i13);
                int i14 = aVar.f2852a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || aVar.f2853b == i12 || (z10 && aVar.f2855d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i10) {
            List list = this.f2851b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2851b.get(size);
                if (aVar.f2852a == i10) {
                    return aVar;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f2850a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int h(int i10) {
            int[] iArr = this.f2850a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f2850a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f2850a.length;
            }
            int i12 = i11 + 1;
            Arrays.fill(this.f2850a, i10, i12, -1);
            return i12;
        }

        public final int i(int i10) {
            if (this.f2851b == null) {
                return -1;
            }
            a f10 = f(i10);
            if (f10 != null) {
                this.f2851b.remove(f10);
            }
            int size = this.f2851b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (((a) this.f2851b.get(i11)).f2852a >= i10) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            this.f2851b.remove(i11);
            return ((a) this.f2851b.get(i11)).f2852a;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f2850a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f2850a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f2850a, i10, i12, -1);
                l(i10, i11);
            }
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f2850a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f2850a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f2850a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        public final void l(int i10, int i11) {
            List list = this.f2851b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.f2851b.get(size);
                    int i12 = aVar.f2852a;
                    if (i12 >= i10) {
                        aVar.f2852a = i12 + i11;
                    }
                }
            }
        }

        public final void m(int i10, int i11) {
            List list = this.f2851b;
            if (list != null) {
                int i12 = i10 + i11;
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.f2851b.get(size);
                    int i13 = aVar.f2852a;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f2851b.remove(size);
                        } else {
                            aVar.f2852a = i13 - i11;
                        }
                    }
                }
            }
        }

        public void n(int i10, f fVar) {
            c(i10);
            this.f2850a[i10] = fVar.f2870e;
        }

        public int o(int i10) {
            int length = this.f2850a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0039a();

            /* renamed from: a  reason: collision with root package name */
            public int f2852a;

            /* renamed from: b  reason: collision with root package name */
            public int f2853b;

            /* renamed from: c  reason: collision with root package name */
            public int[] f2854c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f2855d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            public static class C0039a implements Parcelable.Creator {
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: b */
                public a[] newArray(int i10) {
                    return new a[i10];
                }
            }

            public a(Parcel parcel) {
                this.f2852a = parcel.readInt();
                this.f2853b = parcel.readInt();
                this.f2855d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2854c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f2854c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2852a + ", mGapDir=" + this.f2853b + ", mHasUnwantedGapAfter=" + this.f2855d + ", mGapPerSpan=" + Arrays.toString(this.f2854c) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f2852a);
                parcel.writeInt(this.f2853b);
                parcel.writeInt(this.f2855d ? 1 : 0);
                int[] iArr = this.f2854c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2854c);
            }

            public a() {
            }
        }
    }
}
