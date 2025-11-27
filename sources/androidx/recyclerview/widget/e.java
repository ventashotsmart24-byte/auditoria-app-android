package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import x.q;

public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public static final ThreadLocal f2971e = new ThreadLocal();

    /* renamed from: f  reason: collision with root package name */
    public static Comparator f2972f = new a();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2973a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f2974b;

    /* renamed from: c  reason: collision with root package name */
    public long f2975c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f2976d = new ArrayList();

    public static class a implements Comparator {
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            boolean z10;
            boolean z11;
            RecyclerView recyclerView = cVar.f2984d;
            if (recyclerView == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cVar2.f2984d == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 == z11) {
                boolean z12 = cVar.f2981a;
                if (z12 == cVar2.f2981a) {
                    int i10 = cVar2.f2982b - cVar.f2982b;
                    if (i10 != 0) {
                        return i10;
                    }
                    int i11 = cVar.f2983c - cVar2.f2983c;
                    if (i11 != 0) {
                        return i11;
                    }
                    return 0;
                } else if (z12) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (recyclerView == null) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        public int f2977a;

        /* renamed from: b  reason: collision with root package name */
        public int f2978b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f2979c;

        /* renamed from: d  reason: collision with root package name */
        public int f2980d;

        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i11 >= 0) {
                int i12 = this.f2980d * 2;
                int[] iArr = this.f2979c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f2979c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i12 >= iArr.length) {
                    int[] iArr3 = new int[(i12 * 2)];
                    this.f2979c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f2979c;
                iArr4[i12] = i10;
                iArr4[i12 + 1] = i11;
                this.f2980d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b() {
            int[] iArr = this.f2979c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2980d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f2980d = 0;
            int[] iArr = this.f2979c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && oVar != null && oVar.isItemPrefetchEnabled()) {
                if (z10) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    oVar.collectAdjacentPrefetchPositions(this.f2977a, this.f2978b, recyclerView.mState, this);
                }
                int i10 = this.f2980d;
                if (i10 > oVar.mPrefetchMaxCountObserved) {
                    oVar.mPrefetchMaxCountObserved = i10;
                    oVar.mPrefetchMaxObservedInInitialPrefetch = z10;
                    recyclerView.mRecycler.K();
                }
            }
        }

        public boolean d(int i10) {
            if (this.f2979c != null) {
                int i11 = this.f2980d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f2979c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f2977a = i10;
            this.f2978b = i11;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2981a;

        /* renamed from: b  reason: collision with root package name */
        public int f2982b;

        /* renamed from: c  reason: collision with root package name */
        public int f2983c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2984d;

        /* renamed from: e  reason: collision with root package name */
        public int f2985e;

        public void a() {
            this.f2981a = false;
            this.f2982b = 0;
            this.f2983c = 0;
            this.f2984d = null;
            this.f2985e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.mChildHelper.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i11));
            if (childViewHolderInt.mPosition == i10 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f2973a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        boolean z10;
        int size = this.f2973a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f2973a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i10 += recyclerView.mPrefetchRegistry.f2980d;
            }
        }
        this.f2976d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f2973a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f2977a) + Math.abs(bVar.f2978b);
                for (int i14 = 0; i14 < bVar.f2980d * 2; i14 += 2) {
                    if (i12 >= this.f2976d.size()) {
                        cVar = new c();
                        this.f2976d.add(cVar);
                    } else {
                        cVar = (c) this.f2976d.get(i12);
                    }
                    int[] iArr = bVar.f2979c;
                    int i15 = iArr[i14 + 1];
                    if (i15 <= abs) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    cVar.f2981a = z10;
                    cVar.f2982b = abs;
                    cVar.f2983c = i15;
                    cVar.f2984d = recyclerView2;
                    cVar.f2985e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f2976d, f2972f);
    }

    public final void c(c cVar, long j10) {
        long j11;
        if (cVar.f2981a) {
            j11 = Long.MAX_VALUE;
        } else {
            j11 = j10;
        }
        RecyclerView.d0 i10 = i(cVar.f2984d, cVar.f2985e, j11);
        if (i10 != null && i10.mNestedRecyclerView != null && i10.isBound() && !i10.isInvalid()) {
            h(i10.mNestedRecyclerView.get(), j10);
        }
    }

    public final void d(long j10) {
        int i10 = 0;
        while (i10 < this.f2976d.size()) {
            c cVar = (c) this.f2976d.get(i10);
            if (cVar.f2984d != null) {
                c(cVar, j10);
                cVar.a();
                i10++;
            } else {
                return;
            }
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f2974b == 0) {
            this.f2974b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(RecyclerView recyclerView, long j10) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            b bVar = recyclerView.mPrefetchRegistry;
            bVar.c(recyclerView, true);
            if (bVar.f2980d != 0) {
                try {
                    q.a("RV Nested Prefetch");
                    recyclerView.mState.f(recyclerView.mAdapter);
                    for (int i10 = 0; i10 < bVar.f2980d * 2; i10 += 2) {
                        i(recyclerView, bVar.f2979c[i10], j10);
                    }
                } finally {
                    q.b();
                }
            }
        }
    }

    public final RecyclerView.d0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 I = vVar.I(i10, false, j10);
            if (I != null) {
                if (!I.isBound() || I.isInvalid()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.itemView);
                }
            }
            return I;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f2973a.remove(recyclerView);
    }

    public void run() {
        try {
            q.a("RV Prefetch");
            if (!this.f2973a.isEmpty()) {
                int size = this.f2973a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f2973a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f2975c);
                    this.f2974b = 0;
                    q.b();
                }
            }
        } finally {
            this.f2974b = 0;
            q.b();
        }
    }
}
