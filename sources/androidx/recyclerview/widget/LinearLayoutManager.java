package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.q;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.o implements f.b, RecyclerView.z.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    m mOrientationHelper;
    d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public m f2718a;

        /* renamed from: b  reason: collision with root package name */
        public int f2719b;

        /* renamed from: c  reason: collision with root package name */
        public int f2720c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2721d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2722e;

        public a() {
            e();
        }

        public void a() {
            int i10;
            if (this.f2721d) {
                i10 = this.f2718a.i();
            } else {
                i10 = this.f2718a.m();
            }
            this.f2720c = i10;
        }

        public void b(View view, int i10) {
            if (this.f2721d) {
                this.f2720c = this.f2718a.d(view) + this.f2718a.o();
            } else {
                this.f2720c = this.f2718a.g(view);
            }
            this.f2719b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f2718a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f2719b = i10;
            if (this.f2721d) {
                int i11 = (this.f2718a.i() - o10) - this.f2718a.d(view);
                this.f2720c = this.f2718a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f2720c - this.f2718a.e(view);
                    int m10 = this.f2718a.m();
                    int min = e10 - (m10 + Math.min(this.f2718a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f2720c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f2718a.g(view);
            int m11 = g10 - this.f2718a.m();
            this.f2720c = g10;
            if (m11 > 0) {
                int i12 = (this.f2718a.i() - Math.min(0, (this.f2718a.i() - o10) - this.f2718a.d(view))) - (g10 + this.f2718a.e(view));
                if (i12 < 0) {
                    this.f2720c -= Math.min(m11, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (pVar.c() || pVar.a() < 0 || pVar.a() >= a0Var.b()) {
                return false;
            }
            return true;
        }

        public void e() {
            this.f2719b = -1;
            this.f2720c = Integer.MIN_VALUE;
            this.f2721d = false;
            this.f2722e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2719b + ", mCoordinate=" + this.f2720c + ", mLayoutFromEnd=" + this.f2721d + ", mValid=" + this.f2722e + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2723a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2724b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2725c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2726d;

        public void a() {
            this.f2723a = 0;
            this.f2724b = false;
            this.f2725c = false;
            this.f2726d = false;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2727a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f2728b;

        /* renamed from: c  reason: collision with root package name */
        public int f2729c;

        /* renamed from: d  reason: collision with root package name */
        public int f2730d;

        /* renamed from: e  reason: collision with root package name */
        public int f2731e;

        /* renamed from: f  reason: collision with root package name */
        public int f2732f;

        /* renamed from: g  reason: collision with root package name */
        public int f2733g;

        /* renamed from: h  reason: collision with root package name */
        public int f2734h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f2735i = 0;

        /* renamed from: j  reason: collision with root package name */
        public boolean f2736j = false;

        /* renamed from: k  reason: collision with root package name */
        public int f2737k;

        /* renamed from: l  reason: collision with root package name */
        public List f2738l = null;

        /* renamed from: m  reason: collision with root package name */
        public boolean f2739m;

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f2730d = -1;
            } else {
                this.f2730d = ((RecyclerView.p) f10.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.a0 a0Var) {
            int i10 = this.f2730d;
            if (i10 < 0 || i10 >= a0Var.b()) {
                return false;
            }
            return true;
        }

        public View d(RecyclerView.v vVar) {
            if (this.f2738l != null) {
                return e();
            }
            View o10 = vVar.o(this.f2730d);
            this.f2730d += this.f2731e;
            return o10;
        }

        public final View e() {
            int size = this.f2738l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((RecyclerView.d0) this.f2738l.get(i10)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f2730d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int a10;
            int size = this.f2738l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = ((RecyclerView.d0) this.f2738l.get(i11)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a10 = (pVar.a() - this.f2730d) * this.f2731e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2740a;

        /* renamed from: b  reason: collision with root package name */
        public int f2741b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2742c;

        public static class a implements Parcelable.Creator {
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* renamed from: b */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d() {
        }

        public boolean a() {
            if (this.f2740a >= 0) {
                return true;
            }
            return false;
        }

        public void b() {
            this.f2740a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2740a);
            parcel.writeInt(this.f2741b);
            parcel.writeInt(this.f2742c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f2740a = parcel.readInt();
            this.f2741b = parcel.readInt();
            this.f2742c = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f2740a = dVar.f2740a;
            this.f2741b = dVar.f2741b;
            this.f2742c = dVar.f2742c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public final void A(RecyclerView.v vVar, int i10, int i11) {
        if (i10 >= 0) {
            int i12 = i10 - i11;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i13 = childCount - 1;
                for (int i14 = i13; i14 >= 0; i14--) {
                    View childAt = getChildAt(i14);
                    if (this.mOrientationHelper.d(childAt) > i12 || this.mOrientationHelper.p(childAt) > i12) {
                        y(vVar, i13, i14);
                        return;
                    }
                }
                return;
            }
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt2 = getChildAt(i15);
                if (this.mOrientationHelper.d(childAt2) > i12 || this.mOrientationHelper.p(childAt2) > i12) {
                    y(vVar, 0, i15);
                    return;
                }
            }
        }
    }

    public final void B() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final boolean C(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        View view;
        int i10;
        boolean z10 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, a0Var)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            if (aVar.f2721d) {
                view = p(vVar, a0Var);
            } else {
                view = q(vVar, a0Var);
            }
            if (view == null) {
                return false;
            }
            aVar.b(view, getPosition(view));
            if (!a0Var.e() && supportsPredictiveItemAnimations()) {
                if (this.mOrientationHelper.g(view) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(view) < this.mOrientationHelper.m()) {
                    z10 = true;
                }
                if (z10) {
                    if (aVar.f2721d) {
                        i10 = this.mOrientationHelper.i();
                    } else {
                        i10 = this.mOrientationHelper.m();
                    }
                    aVar.f2720c = i10;
                }
            }
            return true;
        }
    }

    public final boolean D(RecyclerView.a0 a0Var, a aVar) {
        int i10;
        boolean z10;
        int i11;
        boolean z11 = false;
        if (!a0Var.e() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 < 0 || i10 >= a0Var.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f2719b = this.mPendingScrollPosition;
                d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.a()) {
                    boolean z12 = this.mPendingSavedState.f2742c;
                    aVar.f2721d = z12;
                    if (z12) {
                        aVar.f2720c = this.mOrientationHelper.i() - this.mPendingSavedState.f2741b;
                    } else {
                        aVar.f2720c = this.mOrientationHelper.m() + this.mPendingSavedState.f2741b;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10 == this.mShouldReverseLayout) {
                                z11 = true;
                            }
                            aVar.f2721d = z11;
                        }
                        aVar.a();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.f2720c = this.mOrientationHelper.m();
                        aVar.f2721d = false;
                        return true;
                    } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.f2720c = this.mOrientationHelper.i();
                        aVar.f2721d = true;
                        return true;
                    } else {
                        if (aVar.f2721d) {
                            i11 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o();
                        } else {
                            i11 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        aVar.f2720c = i11;
                    }
                    return true;
                } else {
                    boolean z13 = this.mShouldReverseLayout;
                    aVar.f2721d = z13;
                    if (z13) {
                        aVar.f2720c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f2720c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void E(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        int i10;
        if (!D(a0Var, aVar) && !C(vVar, a0Var, aVar)) {
            aVar.a();
            if (this.mStackFromEnd) {
                i10 = a0Var.b() - 1;
            } else {
                i10 = 0;
            }
            aVar.f2719b = i10;
        }
    }

    public final void F(int i10, int i11, boolean z10, RecyclerView.a0 a0Var) {
        int i12;
        int i13;
        this.mLayoutState.f2739m = resolveIsInfinite();
        this.mLayoutState.f2732f = i10;
        int[] iArr = this.mReusableIntPair;
        boolean z11 = false;
        iArr[0] = 0;
        int i14 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i10 == 1) {
            z11 = true;
        }
        c cVar = this.mLayoutState;
        if (z11) {
            i12 = max2;
        } else {
            i12 = max;
        }
        cVar.f2734h = i12;
        if (!z11) {
            max = max2;
        }
        cVar.f2735i = max;
        if (z11) {
            cVar.f2734h = i12 + this.mOrientationHelper.j();
            View t10 = t();
            c cVar2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i14 = -1;
            }
            cVar2.f2731e = i14;
            int position = getPosition(t10);
            c cVar3 = this.mLayoutState;
            cVar2.f2730d = position + cVar3.f2731e;
            cVar3.f2728b = this.mOrientationHelper.d(t10);
            i13 = this.mOrientationHelper.d(t10) - this.mOrientationHelper.i();
        } else {
            View u10 = u();
            this.mLayoutState.f2734h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i14 = -1;
            }
            cVar4.f2731e = i14;
            int position2 = getPosition(u10);
            c cVar5 = this.mLayoutState;
            cVar4.f2730d = position2 + cVar5.f2731e;
            cVar5.f2728b = this.mOrientationHelper.g(u10);
            i13 = (-this.mOrientationHelper.g(u10)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f2729c = i11;
        if (z10) {
            cVar6.f2729c = i11 - i13;
        }
        cVar6.f2733g = i13;
    }

    public final void G(int i10, int i11) {
        int i12;
        this.mLayoutState.f2729c = this.mOrientationHelper.i() - i11;
        c cVar = this.mLayoutState;
        if (this.mShouldReverseLayout) {
            i12 = -1;
        } else {
            i12 = 1;
        }
        cVar.f2731e = i12;
        cVar.f2730d = i10;
        cVar.f2732f = 1;
        cVar.f2728b = i11;
        cVar.f2733g = Integer.MIN_VALUE;
    }

    public final void H(a aVar) {
        G(aVar.f2719b, aVar.f2720c);
    }

    public final void I(int i10, int i11) {
        int i12;
        this.mLayoutState.f2729c = i11 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f2730d = i10;
        if (this.mShouldReverseLayout) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        cVar.f2731e = i12;
        cVar.f2732f = -1;
        cVar.f2728b = i11;
        cVar.f2733g = Integer.MIN_VALUE;
    }

    public final void J(a aVar) {
        I(aVar.f2719b, aVar.f2720c);
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.a0 a0Var, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(a0Var);
        if (this.mLayoutState.f2732f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int i12;
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            ensureLayoutState();
            if (i10 > 0) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            F(i12, Math.abs(i10), true, a0Var);
            collectPrefetchPositionsForLayoutState(a0Var, this.mLayoutState, cVar);
        }
    }

    public void collectInitialPrefetchPositions(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        d dVar = this.mPendingSavedState;
        int i12 = -1;
        if (dVar == null || !dVar.a()) {
            B();
            z10 = this.mShouldReverseLayout;
            i11 = this.mPendingScrollPosition;
            if (i11 == -1) {
                if (z10) {
                    i11 = i10 - 1;
                } else {
                    i11 = 0;
                }
            }
        } else {
            d dVar2 = this.mPendingSavedState;
            z10 = dVar2.f2742c;
            i11 = dVar2.f2740a;
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.mInitialPrefetchItemCount && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f2730d;
        if (i10 >= 0 && i10 < a0Var.b()) {
            cVar2.a(i10, Math.max(0, cVar.f2733g));
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        return g(a0Var);
    }

    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < getPosition(getChildAt(0))) {
            z10 = true;
        }
        if (z10 != this.mShouldReverseLayout) {
            i11 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i11, 0.0f);
        }
        return new PointF(0.0f, (float) i11);
    }

    public int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        return g(a0Var);
    }

    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    public int convertFocusDirectionToLayoutDirection(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 == 130 && this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10 = cVar.f2729c;
        int i11 = cVar.f2733g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f2733g = i11 + i10;
            }
            x(vVar, cVar);
        }
        int i12 = cVar.f2729c + cVar.f2734h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f2739m && i12 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            layoutChunk(vVar, a0Var, cVar, bVar);
            if (!bVar.f2724b) {
                cVar.f2728b += bVar.f2723a * cVar.f2732f;
                if (!bVar.f2725c || cVar.f2738l != null || !a0Var.e()) {
                    int i13 = cVar.f2729c;
                    int i14 = bVar.f2723a;
                    cVar.f2729c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f2733g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f2723a;
                    cVar.f2733g = i16;
                    int i17 = cVar.f2729c;
                    if (i17 < 0) {
                        cVar.f2733g = i16 + i17;
                    }
                    x(vVar, cVar);
                }
                if (z10 && bVar.f2726d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f2729c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z10, z11);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
        }
        return findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i10, int i11) {
        char c10;
        int i12;
        int i13;
        ensureLayoutState();
        if (i11 > i10) {
            c10 = 1;
        } else if (i11 < i10) {
            c10 = 65535;
        } else {
            c10 = 0;
        }
        if (c10 == 0) {
            return getChildAt(i10);
        }
        if (this.mOrientationHelper.g(getChildAt(i10)) < this.mOrientationHelper.m()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = q.a.f14388a;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i10, i11, i13, i12);
        }
        return this.mVerticalBoundCheck.a(i10, i11, i13, i12);
    }

    public View findOneVisibleChild(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        ensureLayoutState();
        int i13 = 320;
        if (z10) {
            i12 = 24579;
        } else {
            i12 = 320;
        }
        if (!z11) {
            i13 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i10, i11, i12, i13);
        }
        return this.mVerticalBoundCheck.a(i10, i11, i12, i13);
    }

    public View findReferenceChild(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11, int i12) {
        int i13;
        ensureLayoutState();
        int m10 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        if (i11 > i10) {
            i13 = 1;
        } else {
            i13 = -1;
        }
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            int position = getPosition(childAt);
            if (position >= 0 && position < i12) {
                if (((RecyclerView.p) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.g(childAt) < i14 && this.mOrientationHelper.d(childAt) >= m10) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i10 += i13;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    public final int g(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        m mVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return p.a(a0Var, mVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public final int h(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        m mVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return p.b(a0Var, mVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int i(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        m mVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return p.c(a0Var, mVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public final View j() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    public final View k(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return findReferenceChild(vVar, a0Var, 0, getChildCount(), a0Var.b());
    }

    public final View l() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public void layoutChunk(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        boolean z11;
        View d10 = cVar.d(vVar);
        if (d10 == null) {
            bVar.f2724b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d10.getLayoutParams();
        if (cVar.f2738l == null) {
            boolean z12 = this.mShouldReverseLayout;
            if (cVar.f2732f == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z12 == z11) {
                addView(d10);
            } else {
                addView(d10, 0);
            }
        } else {
            boolean z13 = this.mShouldReverseLayout;
            if (cVar.f2732f == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13 == z10) {
                addDisappearingView(d10);
            } else {
                addDisappearingView(d10, 0);
            }
        }
        measureChildWithMargins(d10, 0, 0);
        bVar.f2723a = this.mOrientationHelper.e(d10);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i14 = getWidth() - getPaddingRight();
                i13 = i14 - this.mOrientationHelper.f(d10);
            } else {
                i13 = getPaddingLeft();
                i14 = this.mOrientationHelper.f(d10) + i13;
            }
            if (cVar.f2732f == -1) {
                int i15 = cVar.f2728b;
                i10 = i15;
                i11 = i14;
                i12 = i15 - bVar.f2723a;
            } else {
                int i16 = cVar.f2728b;
                i12 = i16;
                i11 = i14;
                i10 = bVar.f2723a + i16;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f10 = this.mOrientationHelper.f(d10) + paddingTop;
            if (cVar.f2732f == -1) {
                int i17 = cVar.f2728b;
                i11 = i17;
                i12 = paddingTop;
                i10 = f10;
                i13 = i17 - bVar.f2723a;
            } else {
                int i18 = cVar.f2728b;
                i12 = paddingTop;
                i11 = bVar.f2723a + i18;
                i10 = f10;
                i13 = i18;
            }
        }
        layoutDecoratedWithMargins(d10, i13, i12, i11, i10);
        if (pVar.c() || pVar.b()) {
            bVar.f2725c = true;
        }
        bVar.f2726d = d10.hasFocusable();
    }

    public final View m(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return findReferenceChild(vVar, a0Var, getChildCount() - 1, -1, a0Var.b());
    }

    public final View n() {
        if (this.mShouldReverseLayout) {
            return j();
        }
        return l();
    }

    public final View o() {
        if (this.mShouldReverseLayout) {
            return l();
        }
        return j();
    }

    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i10) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(vVar);
            vVar.c();
        }
    }

    public View onFocusSearchFailed(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        B();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        F(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.n()) * MAX_SCROLL_FACTOR), false, a0Var);
        c cVar = this.mLayoutState;
        cVar.f2733g = Integer.MIN_VALUE;
        cVar.f2727a = false;
        fill(vVar, cVar, a0Var, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = o();
        } else {
            view2 = n();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = u();
        } else {
            view3 = t();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View findViewByPosition;
        int i17;
        int i18;
        int i19 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && a0Var.b() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f2740a;
        }
        ensureLayoutState();
        this.mLayoutState.f2727a = false;
        B();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f2722e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f2721d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            E(vVar, a0Var, aVar2);
            this.mAnchorInfo.f2722e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        if (cVar.f2737k >= 0) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        cVar.f2732f = i10;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (!(!a0Var.e() || (i16 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i16)) == null)) {
            if (this.mShouldReverseLayout) {
                i17 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                i18 = this.mPendingScrollPositionOffset;
            } else {
                i18 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i17 = this.mPendingScrollPositionOffset;
            }
            int i20 = i17 - i18;
            if (i20 > 0) {
                max += i20;
            } else {
                max2 -= i20;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f2721d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i19 = 1;
        }
        onAnchorReady(vVar, a0Var, aVar3, i19);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.f2739m = resolveIsInfinite();
        this.mLayoutState.f2736j = a0Var.e();
        this.mLayoutState.f2735i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f2721d) {
            J(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f2734h = max;
            fill(vVar, cVar2, a0Var, false);
            c cVar3 = this.mLayoutState;
            i12 = cVar3.f2728b;
            int i21 = cVar3.f2730d;
            int i22 = cVar3.f2729c;
            if (i22 > 0) {
                max2 += i22;
            }
            H(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f2734h = max2;
            cVar4.f2730d += cVar4.f2731e;
            fill(vVar, cVar4, a0Var, false);
            c cVar5 = this.mLayoutState;
            i11 = cVar5.f2728b;
            int i23 = cVar5.f2729c;
            if (i23 > 0) {
                I(i21, i12);
                c cVar6 = this.mLayoutState;
                cVar6.f2734h = i23;
                fill(vVar, cVar6, a0Var, false);
                i12 = this.mLayoutState.f2728b;
            }
        } else {
            H(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f2734h = max2;
            fill(vVar, cVar7, a0Var, false);
            c cVar8 = this.mLayoutState;
            i11 = cVar8.f2728b;
            int i24 = cVar8.f2730d;
            int i25 = cVar8.f2729c;
            if (i25 > 0) {
                max += i25;
            }
            J(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f2734h = max;
            cVar9.f2730d += cVar9.f2731e;
            fill(vVar, cVar9, a0Var, false);
            c cVar10 = this.mLayoutState;
            i12 = cVar10.f2728b;
            int i26 = cVar10.f2729c;
            if (i26 > 0) {
                G(i24, i11);
                c cVar11 = this.mLayoutState;
                cVar11.f2734h = i26;
                fill(vVar, cVar11, a0Var, false);
                i11 = this.mLayoutState.f2728b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int r10 = r(i11, vVar, a0Var, true);
                i14 = i12 + r10;
                i13 = i11 + r10;
                i15 = s(i14, vVar, a0Var, false);
            } else {
                int s10 = s(i12, vVar, a0Var, true);
                i14 = i12 + s10;
                i13 = i11 + s10;
                i15 = r(i13, vVar, a0Var, false);
            }
            i12 = i14 + i15;
            i11 = i13 + i15;
        }
        v(vVar, a0Var, i12, i11);
        if (!a0Var.e()) {
            this.mOrientationHelper.s();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.mPendingSavedState = (d) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new d(this.mPendingSavedState);
        }
        d dVar = new d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar.f2742c = z10;
            if (z10) {
                View t10 = t();
                dVar.f2741b = this.mOrientationHelper.i() - this.mOrientationHelper.d(t10);
                dVar.f2740a = getPosition(t10);
            } else {
                View u10 = u();
                dVar.f2740a = getPosition(u10);
                dVar.f2741b = this.mOrientationHelper.g(u10) - this.mOrientationHelper.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    public final View p(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mShouldReverseLayout) {
            return k(vVar, a0Var);
        }
        return m(vVar, a0Var);
    }

    public void prepareForDrop(View view, View view2, int i10, int i11) {
        char c10;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        B();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c10 = 1;
        } else {
            c10 = 65535;
        }
        if (this.mShouldReverseLayout) {
            if (c10 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
            }
        } else if (c10 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    public final View q(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mShouldReverseLayout) {
            return m(vVar, a0Var);
        }
        return k(vVar, a0Var);
    }

    public final int r(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i11;
        int i12 = this.mOrientationHelper.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -scrollBy(-i12, vVar, a0Var);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.mOrientationHelper.i() - i14) <= 0) {
            return i13;
        }
        this.mOrientationHelper.r(i11);
        return i11 + i13;
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0) {
            return true;
        }
        return false;
    }

    public final int s(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int m11 = i10 - this.mOrientationHelper.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(m11, vVar, a0Var);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.mOrientationHelper.m()) <= 0) {
            return i11;
        }
        this.mOrientationHelper.r(-m10);
        return i11 - m10;
    }

    public int scrollBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i11;
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2727a = true;
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        int abs = Math.abs(i10);
        F(i11, abs, true, a0Var);
        c cVar = this.mLayoutState;
        int fill = cVar.f2733g + fill(vVar, cVar, a0Var, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i10 = i11 * fill;
        }
        this.mOrientationHelper.r(-i10);
        this.mLayoutState.f2737k = i10;
        return i10;
    }

    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i10, vVar, a0Var);
    }

    public void scrollToPosition(int i10) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i10, vVar, a0Var);
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i10 != this.mOrientation || this.mOrientationHelper == null) {
                m b10 = m.b(this, i10);
                this.mOrientationHelper = b10;
                this.mAnchorInfo.f2718a = b10;
                this.mOrientation = i10;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i10);
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        if (z10 != this.mReverseLayout) {
            this.mReverseLayout = z10;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z10) {
            this.mStackFromEnd = z10;
            requestLayout();
        }
    }

    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i10);
        startSmoothScroll(jVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    public final View t() {
        int i10;
        if (this.mShouldReverseLayout) {
            i10 = 0;
        } else {
            i10 = getChildCount() - 1;
        }
        return getChildAt(i10);
    }

    public final View u() {
        int i10;
        if (this.mShouldReverseLayout) {
            i10 = getChildCount() - 1;
        } else {
            i10 = 0;
        }
        return getChildAt(i10);
    }

    public final void v(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11) {
        boolean z10;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.a0 a0Var2 = a0Var;
        if (a0Var.g() && getChildCount() != 0 && !a0Var.e() && supportsPredictiveItemAnimations()) {
            List k10 = vVar.k();
            int size = k10.size();
            int position = getPosition(getChildAt(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.d0 d0Var = (RecyclerView.d0) k10.get(i14);
                if (!d0Var.isRemoved()) {
                    char c10 = 1;
                    if (d0Var.getLayoutPosition() < position) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10 != this.mShouldReverseLayout) {
                        c10 = 65535;
                    }
                    if (c10 == 65535) {
                        i12 += this.mOrientationHelper.e(d0Var.itemView);
                    } else {
                        i13 += this.mOrientationHelper.e(d0Var.itemView);
                    }
                }
            }
            this.mLayoutState.f2738l = k10;
            if (i12 > 0) {
                I(getPosition(u()), i10);
                c cVar = this.mLayoutState;
                cVar.f2734h = i12;
                cVar.f2729c = 0;
                cVar.a();
                fill(vVar2, this.mLayoutState, a0Var2, false);
            }
            if (i13 > 0) {
                G(getPosition(t()), i11);
                c cVar2 = this.mLayoutState;
                cVar2.f2734h = i13;
                cVar2.f2729c = 0;
                cVar2.a();
                fill(vVar2, this.mLayoutState, a0Var2, false);
            }
            this.mLayoutState.f2738l = null;
        }
    }

    public void validateChildOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("validating child count ");
        sb.append(getChildCount());
        boolean z10 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int g10 = this.mOrientationHelper.g(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i10 = 1;
                while (i10 < getChildCount()) {
                    View childAt = getChildAt(i10);
                    int position2 = getPosition(childAt);
                    int g11 = this.mOrientationHelper.g(childAt);
                    if (position2 < position) {
                        w();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("detected invalid position. loc invalid? ");
                        if (g11 >= g10) {
                            z10 = false;
                        }
                        sb2.append(z10);
                        throw new RuntimeException(sb2.toString());
                    } else if (g11 <= g10) {
                        i10++;
                    } else {
                        w();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i11 = 1;
            while (i11 < getChildCount()) {
                View childAt2 = getChildAt(i11);
                int position3 = getPosition(childAt2);
                int g12 = this.mOrientationHelper.g(childAt2);
                if (position3 < position) {
                    w();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    if (g12 >= g10) {
                        z10 = false;
                    }
                    sb3.append(z10);
                    throw new RuntimeException(sb3.toString());
                } else if (g12 >= g10) {
                    i11++;
                } else {
                    w();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public final void w() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(getPosition(childAt));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.g(childAt));
        }
    }

    public final void x(RecyclerView.v vVar, c cVar) {
        if (cVar.f2727a && !cVar.f2739m) {
            int i10 = cVar.f2733g;
            int i11 = cVar.f2735i;
            if (cVar.f2732f == -1) {
                z(vVar, i10, i11);
            } else {
                A(vVar, i10, i11);
            }
        }
    }

    public final void y(RecyclerView.v vVar, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                for (int i12 = i11 - 1; i12 >= i10; i12--) {
                    removeAndRecycleViewAt(i12, vVar);
                }
                return;
            }
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, vVar);
                i10--;
            }
        }
    }

    public final void z(RecyclerView.v vVar, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 >= 0) {
            int h10 = (this.mOrientationHelper.h() - i10) + i11;
            if (this.mShouldReverseLayout) {
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (this.mOrientationHelper.g(childAt) < h10 || this.mOrientationHelper.q(childAt) < h10) {
                        y(vVar, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = childCount - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View childAt2 = getChildAt(i14);
                if (this.mOrientationHelper.g(childAt2) < h10 || this.mOrientationHelper.q(childAt2) < h10) {
                    y(vVar, i13, i14);
                    return;
                }
            }
        }
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f2785a);
        setReverseLayout(properties.f2787c);
        setStackFromEnd(properties.f2788d);
    }
}
