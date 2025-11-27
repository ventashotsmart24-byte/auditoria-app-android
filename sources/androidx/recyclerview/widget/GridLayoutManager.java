package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c0.g0;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    c mSpanSizeLookup = new a();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class a extends c {
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        public int getSpanSize(int i10) {
            return 1;
        }
    }

    public static abstract class c {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanGroupIndex(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.mCacheSpanGroupIndices
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.util.SparseIntArray r0 = r6.mSpanGroupIndexCache
                int r0 = findFirstKeyLessThan(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0024
                android.util.SparseIntArray r2 = r6.mSpanGroupIndexCache
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.getCachedSpanIndex(r0, r8)
                int r0 = r6.getSpanSize(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0027
                int r2 = r2 + 1
                goto L_0x0026
            L_0x0024:
                r2 = 0
                r3 = 0
            L_0x0026:
                r4 = 0
            L_0x0027:
                int r0 = r6.getSpanSize(r7)
            L_0x002b:
                if (r3 >= r7) goto L_0x0040
                int r5 = r6.getSpanSize(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0038
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003d
            L_0x0038:
                if (r4 <= r8) goto L_0x003d
                int r2 = r2 + 1
                r4 = r5
            L_0x003d:
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0040:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0045
                int r2 = r2 + 1
            L_0x0045:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanGroupIndex(int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        setSpanCount(RecyclerView.o.getProperties(context, attributeSet, i10, i11).f2786b);
    }

    public static int[] calculateItemBorders(int[] iArr, int i10, int i11) {
        int i12;
        if (!(iArr != null && iArr.length == i10 + 1 && iArr[iArr.length - 1] == i11)) {
            iArr = new int[(i10 + 1)];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    public final void K(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i11 = i10;
            i12 = 0;
            i13 = 1;
        } else {
            i12 = i10 - 1;
            i11 = -1;
            i13 = -1;
        }
        while (i12 != i11) {
            View view = this.mSet[i12];
            b bVar = (b) view.getLayoutParams();
            int U = U(vVar, a0Var, getPosition(view));
            bVar.f2717f = U;
            bVar.f2716e = i14;
            i14 += U;
            i12 += i13;
        }
    }

    public final void L() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            b bVar = (b) getChildAt(i10).getLayoutParams();
            int a10 = bVar.a();
            this.mPreLayoutSpanSizeCache.put(a10, bVar.f());
            this.mPreLayoutSpanIndexCache.put(a10, bVar.e());
        }
    }

    public final void M(int i10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i10);
    }

    public final void N() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    public final int O(RecyclerView.a0 a0Var) {
        int i10;
        if (!(getChildCount() == 0 || a0Var.b() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i10 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i10 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i10;
                }
                return Math.round((((float) i10) * (((float) Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    public final int P(RecyclerView.a0 a0Var) {
        if (!(getChildCount() == 0 || a0Var.b() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1;
                }
                int d10 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) d10) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    public final void Q(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        boolean z10;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int T = T(vVar, a0Var, aVar.f2719b);
        if (z10) {
            while (T > 0) {
                int i11 = aVar.f2719b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f2719b = i12;
                    T = T(vVar, a0Var, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int b10 = a0Var.b() - 1;
        int i13 = aVar.f2719b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int T2 = T(vVar, a0Var, i14);
            if (T2 <= T) {
                break;
            }
            i13 = i14;
            T = T2;
        }
        aVar.f2719b = i13;
    }

    public final void R() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public final int S(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i10, this.mSpanCount);
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(f10, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(i10);
        return 0;
    }

    public final int T(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i10, this.mSpanCount);
        }
        int i11 = this.mPreLayoutSpanIndexCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(f10, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i10);
        return 0;
    }

    public final int U(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getSpanSize(i10);
        }
        int i11 = this.mPreLayoutSpanSizeCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getSpanSize(f10);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i10);
        return 1;
    }

    public final void V(float f10, int i10) {
        M(Math.max(Math.round(f10 * ((float) this.mSpanCount)), i10));
    }

    public final void W(View view, int i10, boolean z10) {
        int i11;
        int i12;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2790b;
        int i13 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i14 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(bVar.f2716e, bVar.f2717f);
        if (this.mOrientation == 1) {
            i11 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i10, i14, bVar.width, false);
            i12 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i13, bVar.height, true);
        } else {
            int childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i10, i13, bVar.height, false);
            int childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i14, bVar.width, true);
            i12 = childMeasureSpec;
            i11 = childMeasureSpec2;
        }
        X(view, i11, i12, z10);
    }

    public final void X(View view, int i10, int i11, boolean z10) {
        boolean z11;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10) {
            z11 = shouldReMeasureChild(view, i10, i11, pVar);
        } else {
            z11 = shouldMeasureChild(view, i10, i11, pVar);
        }
        if (z11) {
            view.measure(i10, i11);
        }
    }

    public final void Y() {
        int i10;
        int i11;
        if (getOrientation() == 1) {
            i11 = getWidth() - getPaddingRight();
            i10 = getPaddingLeft();
        } else {
            i11 = getHeight() - getPaddingBottom();
            i10 = getPaddingTop();
        }
        M(i11 - i10);
    }

    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i10 = this.mSpanCount;
        for (int i11 = 0; i11 < this.mSpanCount && cVar.c(a0Var) && i10 > 0; i11++) {
            int i12 = cVar.f2730d;
            cVar2.a(i12, Math.max(0, cVar.f2733g));
            i10 -= this.mSpanSizeLookup.getSpanSize(i12);
            cVar.f2730d += cVar.f2731e;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return O(a0Var);
        }
        return super.computeHorizontalScrollOffset(a0Var);
    }

    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return P(a0Var);
        }
        return super.computeHorizontalScrollRange(a0Var);
    }

    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return O(a0Var);
        }
        return super.computeVerticalScrollOffset(a0Var);
    }

    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return P(a0Var);
        }
        return super.computeVerticalScrollRange(a0Var);
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
            if (position >= 0 && position < i12 && T(vVar, a0Var, position) == 0) {
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

    public RecyclerView.p generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i10, int i11) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.mCachedBorders;
        int i12 = this.mSpanCount;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0214 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0212  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutChunk(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.a0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            r17 = this;
            r6 = r17
            r0 = r18
            r1 = r19
            r2 = r20
            r7 = r21
            androidx.recyclerview.widget.m r3 = r6.mOrientationHelper
            int r3 = r3.l()
            r8 = 1
            r4 = 0
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 == r5) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            int r10 = r17.getChildCount()
            if (r10 <= 0) goto L_0x0026
            int[] r10 = r6.mCachedBorders
            int r11 = r6.mSpanCount
            r10 = r10[r11]
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            if (r9 == 0) goto L_0x002c
            r17.Y()
        L_0x002c:
            int r11 = r2.f2731e
            if (r11 != r8) goto L_0x0032
            r11 = 1
            goto L_0x0033
        L_0x0032:
            r11 = 0
        L_0x0033:
            int r12 = r6.mSpanCount
            if (r11 != 0) goto L_0x0044
            int r12 = r2.f2730d
            int r12 = r6.T(r0, r1, r12)
            int r13 = r2.f2730d
            int r13 = r6.U(r0, r1, r13)
            int r12 = r12 + r13
        L_0x0044:
            r13 = 0
        L_0x0045:
            int r14 = r6.mSpanCount
            if (r13 >= r14) goto L_0x009d
            boolean r14 = r2.c(r1)
            if (r14 == 0) goto L_0x009d
            if (r12 <= 0) goto L_0x009d
            int r14 = r2.f2730d
            int r15 = r6.U(r0, r1, r14)
            int r5 = r6.mSpanCount
            if (r15 > r5) goto L_0x006f
            int r12 = r12 - r15
            if (r12 >= 0) goto L_0x005f
            goto L_0x009d
        L_0x005f:
            android.view.View r5 = r2.d(r0)
            if (r5 != 0) goto L_0x0066
            goto L_0x009d
        L_0x0066:
            android.view.View[] r14 = r6.mSet
            r14[r13] = r5
            int r13 = r13 + 1
            r5 = 1073741824(0x40000000, float:2.0)
            goto L_0x0045
        L_0x006f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Item at position "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " requires "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " spans but GridLayoutManager has only "
            r1.append(r2)
            int r2 = r6.mSpanCount
            r1.append(r2)
            java.lang.String r2 = " spans."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009d:
            if (r13 != 0) goto L_0x00a2
            r7.f2724b = r8
            return
        L_0x00a2:
            r6.K(r0, r1, r13, r11)
            r0 = 0
            r1 = 0
            r5 = 0
        L_0x00a8:
            if (r1 >= r13) goto L_0x00f3
            android.view.View[] r12 = r6.mSet
            r12 = r12[r1]
            java.util.List r14 = r2.f2738l
            if (r14 != 0) goto L_0x00bc
            if (r11 == 0) goto L_0x00b8
            r6.addView(r12)
            goto L_0x00c5
        L_0x00b8:
            r6.addView(r12, r4)
            goto L_0x00c5
        L_0x00bc:
            if (r11 == 0) goto L_0x00c2
            r6.addDisappearingView(r12)
            goto L_0x00c5
        L_0x00c2:
            r6.addDisappearingView(r12, r4)
        L_0x00c5:
            android.graphics.Rect r14 = r6.mDecorInsets
            r6.calculateItemDecorationsForChild(r12, r14)
            r6.W(r12, r3, r4)
            androidx.recyclerview.widget.m r14 = r6.mOrientationHelper
            int r14 = r14.e(r12)
            if (r14 <= r5) goto L_0x00d6
            r5 = r14
        L_0x00d6:
            android.view.ViewGroup$LayoutParams r14 = r12.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r14 = (androidx.recyclerview.widget.GridLayoutManager.b) r14
            androidx.recyclerview.widget.m r15 = r6.mOrientationHelper
            int r12 = r15.f(r12)
            float r12 = (float) r12
            r15 = 1065353216(0x3f800000, float:1.0)
            float r12 = r12 * r15
            int r14 = r14.f2717f
            float r14 = (float) r14
            float r12 = r12 / r14
            int r14 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x00f0
            r0 = r12
        L_0x00f0:
            int r1 = r1 + 1
            goto L_0x00a8
        L_0x00f3:
            if (r9 == 0) goto L_0x0111
            r6.V(r0, r10)
            r0 = 0
            r5 = 0
        L_0x00fa:
            if (r0 >= r13) goto L_0x0111
            android.view.View[] r1 = r6.mSet
            r1 = r1[r0]
            r3 = 1073741824(0x40000000, float:2.0)
            r6.W(r1, r3, r8)
            androidx.recyclerview.widget.m r3 = r6.mOrientationHelper
            int r1 = r3.e(r1)
            if (r1 <= r5) goto L_0x010e
            r5 = r1
        L_0x010e:
            int r0 = r0 + 1
            goto L_0x00fa
        L_0x0111:
            r0 = 0
        L_0x0112:
            if (r0 >= r13) goto L_0x0171
            android.view.View[] r1 = r6.mSet
            r1 = r1[r0]
            androidx.recyclerview.widget.m r3 = r6.mOrientationHelper
            int r3 = r3.e(r1)
            if (r3 == r5) goto L_0x016c
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r3 = (androidx.recyclerview.widget.GridLayoutManager.b) r3
            android.graphics.Rect r9 = r3.f2790b
            int r10 = r9.top
            int r11 = r9.bottom
            int r10 = r10 + r11
            int r11 = r3.topMargin
            int r10 = r10 + r11
            int r11 = r3.bottomMargin
            int r10 = r10 + r11
            int r11 = r9.left
            int r9 = r9.right
            int r11 = r11 + r9
            int r9 = r3.leftMargin
            int r11 = r11 + r9
            int r9 = r3.rightMargin
            int r11 = r11 + r9
            int r9 = r3.f2716e
            int r12 = r3.f2717f
            int r9 = r6.getSpaceForSpanRange(r9, r12)
            int r12 = r6.mOrientation
            if (r12 != r8) goto L_0x0159
            int r3 = r3.width
            r12 = 1073741824(0x40000000, float:2.0)
            int r3 = androidx.recyclerview.widget.RecyclerView.o.getChildMeasureSpec(r9, r12, r11, r3, r4)
            int r9 = r5 - r10
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12)
            goto L_0x0168
        L_0x0159:
            r12 = 1073741824(0x40000000, float:2.0)
            int r11 = r5 - r11
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r12)
            int r3 = r3.height
            int r9 = androidx.recyclerview.widget.RecyclerView.o.getChildMeasureSpec(r9, r12, r10, r3, r4)
            r3 = r11
        L_0x0168:
            r6.X(r1, r3, r9, r8)
            goto L_0x016e
        L_0x016c:
            r12 = 1073741824(0x40000000, float:2.0)
        L_0x016e:
            int r0 = r0 + 1
            goto L_0x0112
        L_0x0171:
            r7.f2723a = r5
            int r0 = r6.mOrientation
            r1 = -1
            if (r0 != r8) goto L_0x0189
            int r0 = r2.f2732f
            if (r0 != r1) goto L_0x0181
            int r0 = r2.f2728b
            int r1 = r0 - r5
            goto L_0x0185
        L_0x0181:
            int r1 = r2.f2728b
            int r0 = r1 + r5
        L_0x0185:
            r2 = r1
            r1 = 0
            r3 = 0
            goto L_0x019a
        L_0x0189:
            int r0 = r2.f2732f
            if (r0 != r1) goto L_0x0192
            int r0 = r2.f2728b
            int r1 = r0 - r5
            goto L_0x0196
        L_0x0192:
            int r1 = r2.f2728b
            int r0 = r1 + r5
        L_0x0196:
            r3 = r1
            r2 = 0
            r1 = r0
            r0 = 0
        L_0x019a:
            r9 = 0
        L_0x019b:
            if (r9 >= r13) goto L_0x0226
            android.view.View[] r4 = r6.mSet
            r10 = r4[r9]
            android.view.ViewGroup$LayoutParams r4 = r10.getLayoutParams()
            r11 = r4
            androidx.recyclerview.widget.GridLayoutManager$b r11 = (androidx.recyclerview.widget.GridLayoutManager.b) r11
            int r4 = r6.mOrientation
            if (r4 != r8) goto L_0x01e4
            boolean r1 = r17.isLayoutRTL()
            if (r1 == 0) goto L_0x01cc
            int r1 = r17.getPaddingLeft()
            int[] r3 = r6.mCachedBorders
            int r4 = r6.mSpanCount
            int r5 = r11.f2716e
            int r4 = r4 - r5
            r3 = r3[r4]
            int r1 = r1 + r3
            androidx.recyclerview.widget.m r3 = r6.mOrientationHelper
            int r3 = r3.f(r10)
            int r3 = r1 - r3
            r12 = r0
            r14 = r1
            r15 = r2
            goto L_0x01f9
        L_0x01cc:
            int r1 = r17.getPaddingLeft()
            int[] r3 = r6.mCachedBorders
            int r4 = r11.f2716e
            r3 = r3[r4]
            int r1 = r1 + r3
            androidx.recyclerview.widget.m r3 = r6.mOrientationHelper
            int r3 = r3.f(r10)
            int r3 = r3 + r1
            r12 = r0
            r16 = r1
            r15 = r2
            r14 = r3
            goto L_0x01fb
        L_0x01e4:
            int r0 = r17.getPaddingTop()
            int[] r2 = r6.mCachedBorders
            int r4 = r11.f2716e
            r2 = r2[r4]
            int r0 = r0 + r2
            androidx.recyclerview.widget.m r2 = r6.mOrientationHelper
            int r2 = r2.f(r10)
            int r2 = r2 + r0
            r15 = r0
            r14 = r1
            r12 = r2
        L_0x01f9:
            r16 = r3
        L_0x01fb:
            r0 = r17
            r1 = r10
            r2 = r16
            r3 = r15
            r4 = r14
            r5 = r12
            r0.layoutDecoratedWithMargins(r1, r2, r3, r4, r5)
            boolean r0 = r11.c()
            if (r0 != 0) goto L_0x0212
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x0214
        L_0x0212:
            r7.f2725c = r8
        L_0x0214:
            boolean r0 = r7.f2726d
            boolean r1 = r10.hasFocusable()
            r0 = r0 | r1
            r7.f2726d = r0
            int r9 = r9 + 1
            r0 = r12
            r1 = r14
            r2 = r15
            r3 = r16
            goto L_0x019b
        L_0x0226:
            android.view.View[] r0 = r6.mSet
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        super.onAnchorReady(vVar, a0Var, aVar, i10);
        Y();
        if (a0Var.b() > 0 && !a0Var.e()) {
            Q(vVar, a0Var, aVar, i10);
        }
        R();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == r7) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.f2716e
            int r5 = r5.f2717f
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.S(r1, r2, r7)
            r10 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.S(r1, r2, r10)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.f2716e
            r18 = r3
            int r3 = r9.f2717f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f2716e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f2716e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, g0 g0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, g0Var);
            return;
        }
        b bVar = (b) layoutParams;
        int S = S(vVar, a0Var, bVar.a());
        if (this.mOrientation == 0) {
            g0Var.Z(g0.c.a(bVar.e(), bVar.f(), S, 1, false, false));
            return;
        }
        g0Var.Z(g0.c.a(S, 1, bVar.e(), bVar.f(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            L();
        }
        super.onLayoutChildren(vVar, a0Var);
        N();
    }

    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Y();
        R();
        return super.scrollHorizontallyBy(i10, vVar, a0Var);
    }

    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Y();
        R();
        return super.scrollVerticallyBy(i10, vVar, a0Var);
    }

    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i13 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i12 = RecyclerView.o.chooseSize(i10, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i12 = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i13 = RecyclerView.o.chooseSize(i11, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i12, i13);
    }

    public void setSpanCount(int i10) {
        if (i10 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i10 >= 1) {
                this.mSpanCount = i10;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void setSpanSizeLookup(c cVar) {
        this.mSpanSizeLookup = cVar;
    }

    public void setStackFromEnd(boolean z10) {
        if (!z10) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z10) {
        this.mUsingSpansToEstimateScrollBarDimensions = z10;
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.mPendingSpanCountChange) {
            return false;
        }
        return true;
    }

    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public int f2716e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2717f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.f2716e;
        }

        public int f() {
            return this.f2717f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        setSpanCount(i10);
    }
}
